package com.fichapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.fichapp.R;
import com.fichapp.activity.FichaCadastroDTActivity;
import com.fichapp.business.FichaCadastroDTBS;
import com.fichapp.model.FichaCadastroDTModel;
import com.fichapp.util.Utilitario;

import java.util.List;
import java.util.Locale;

/**
 * Created by Rodrigo Costa on 21/12/2017.
 */

public class FichaCadastroDTAdapter extends RecyclerView.Adapter<FichaCadastroDTAdapter.FichaCadastroDTVH> {

    private List<FichaCadastroDTModel> mList;
    private LayoutInflater mLayoutInflater;
    private FichaCadastroDTModel fichaSelecionada;


    public FichaCadastroDTAdapter(Context c, List<FichaCadastroDTModel> l){
        mList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public FichaCadastroDTVH onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_rv_ficha_cadastro_dt, viewGroup, false);
        FichaCadastroDTVH mvh = new FichaCadastroDTVH(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(FichaCadastroDTVH fichaCadastroDTVH, final int position) {

        fichaCadastroDTVH.tvFicha.setText(String.format(Locale.getDefault(), "Ficha %s", mList.get(position).getId()));
        fichaCadastroDTVH.tvCep.setText(String.format(Locale.getDefault(), "CEP: %s", mList.get(position).getCep()));
        if (!Utilitario.isEmpty(mList.get(position).getNumero())) {
            fichaCadastroDTVH.tvBairro.setText(String.format(Locale.getDefault(), "Bairro: %s, %s", mList.get(position).getBairro(), mList.get(position).getNumero()));
        } else {
            fichaCadastroDTVH.tvBairro.setText(String.format(Locale.getDefault(), "Bairro: %s", mList.get(position).getBairro()));
        }
        fichaCadastroDTVH.tvData.setText(String.format("Data: %s", Utilitario.getDataFormatada(mList.get(position).getDataRegistro())));


        fichaCadastroDTVH.cardRV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), FichaCadastroDTActivity.class);
                FichaCadastroDTBS fichaCadastroDTBS = new FichaCadastroDTBS(view.getContext());
                intent.putExtra("fichaCadastroDT", fichaCadastroDTBS.obter(mList.get(position)));
                view.getContext().startActivity(intent);

            }
        });

        fichaCadastroDTVH.deleteBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                removerFicha(view, position);

                Snackbar snackbar = Snackbar.make(view, "A ficha foi excluida", Snackbar.LENGTH_LONG).setAction("DESFAZER", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        restaurarFicha(view, position);

                        Toast.makeText(view.getContext(), "Ficha restaurada", Toast.LENGTH_SHORT).show();
                    }
                });

                snackbar.setActionTextColor(Color.YELLOW);

                snackbar.show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addListItem(FichaCadastroDTModel c, int position){
        mList.add(c);
        notifyItemInserted(position);
    }

    public void restaurarFicha(View view, int position) {

        FichaCadastroDTBS fichaCadastroDTBS = new FichaCadastroDTBS(view.getContext());
        fichaCadastroDTBS.restaurar(fichaSelecionada);
        mList.add(position, fichaSelecionada);
        notifyItemInserted(position);

    }


    public void removerFicha(View view, int position) {

        FichaCadastroDTBS fichaCadastroDTBS = new FichaCadastroDTBS(view.getContext());
        fichaSelecionada = mList.get(position);
        fichaCadastroDTBS.excluir(fichaSelecionada);
        mList.remove(position);
        notifyDataSetChanged();

    }


    public class FichaCadastroDTVH extends RecyclerView.ViewHolder {

        public CardView cardRV;
        public TextView tvFicha;
        public TextView tvCep;
        public TextView tvBairro;
        public TextView tvData;
        public ImageButton deleteBT;

        public FichaCadastroDTVH(View itemView) {
            super(itemView);

            cardRV = (CardView) itemView.findViewById(R.id.card_rv);
            tvFicha = (TextView) itemView.findViewById(R.id.tv_ficha);
            tvCep = (TextView) itemView.findViewById(R.id.tv_cep);
            tvBairro = (TextView) itemView.findViewById(R.id.tv_bairro);
            tvData = (TextView) itemView.findViewById(R.id.tv_data);
            deleteBT = (ImageButton) itemView.findViewById(R.id.bt_delete);

        }


    }

    public List<FichaCadastroDTModel> getList() {
        return mList;
    }

    public void setList(List<FichaCadastroDTModel> mList) {
        this.mList = mList;
    }
}
