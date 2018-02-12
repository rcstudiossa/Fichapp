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
import com.fichapp.activity.FichaCadastroIndividualActivity;
import com.fichapp.business.FichaCadastroIndividualBS;
import com.fichapp.model.FichaCadastroIndividualModel;
import com.fichapp.util.Utilitario;

import java.util.List;
import java.util.Locale;

/**
 * Created by Rodrigo Costa on 21/12/2017.
 */

public class FichaCadastroIndividualAdapter extends RecyclerView.Adapter<FichaCadastroIndividualAdapter.FichaCadastroIndividualVH> {

    private List<FichaCadastroIndividualModel> mList;
    private LayoutInflater mLayoutInflater;
    private FichaCadastroIndividualModel fichaSelecionada;

    public FichaCadastroIndividualAdapter(Context c, List<FichaCadastroIndividualModel> l) {
        mList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public FichaCadastroIndividualVH onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_rv_ficha_cadastro_individual, viewGroup, false);
        FichaCadastroIndividualVH mvh = new FichaCadastroIndividualVH(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(FichaCadastroIndividualVH fichaCadastroIndividualVH, final int position) {

        /*String nomeCompleto = mList.get(position).getNomeCompleto();

        String primeiroNome = nomeCompleto.split(" ")[0];
        String segundoNome = nomeCompleto.split(" ")[1];

        String nomeAbreviado = primeiroNome + " " + segundoNome;*/


        fichaCadastroIndividualVH.tvFicha.setText(String.format(Locale.getDefault(), "Ficha %s", mList.get(position).getId()));
        fichaCadastroIndividualVH.tvNome.setText(String.format(Locale.getDefault(), "Nome: %s", mList.get(position).getNomeCompleto()));
        fichaCadastroIndividualVH.tvCNS.setText(String.format(Locale.getDefault(), "CNS: %s", mList.get(position).getCnsCidadao()));
        fichaCadastroIndividualVH.tvData.setText(String.format("Data: %s", Utilitario.getDataFormatada(mList.get(position).getDataRegistro())));

        fichaCadastroIndividualVH.cardRV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), FichaCadastroIndividualActivity.class);
                FichaCadastroIndividualBS fichaCadastroIndividualBS = new FichaCadastroIndividualBS(view.getContext());
                intent.putExtra("fichaCadastroIndividual", fichaCadastroIndividualBS.obter(mList.get(position)));
                view.getContext().startActivity(intent);

            }
        });

        fichaCadastroIndividualVH.btDelete.setOnClickListener(new View.OnClickListener() {
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


    public void addListItem(FichaCadastroIndividualModel c, int position) {
        mList.add(c);
        notifyItemInserted(position);
    }

    public void restaurarFicha(View view, int position) {

        FichaCadastroIndividualBS fichaCadastroIndividualBS = new FichaCadastroIndividualBS(view.getContext());
        fichaCadastroIndividualBS.restaurar(fichaSelecionada);
        mList.add(position, fichaSelecionada);
        notifyItemInserted(position);

    }


    public void removerFicha(View view, int position) {

        FichaCadastroIndividualBS fichaCadastroIndividualBS = new FichaCadastroIndividualBS(view.getContext());
        fichaSelecionada = mList.get(position);
        fichaCadastroIndividualBS.excluir(fichaSelecionada);
        mList.remove(position);
        notifyItemRemoved(position);

    }


    public class FichaCadastroIndividualVH extends RecyclerView.ViewHolder {

        public CardView cardRV;
        public TextView tvFicha;
        public TextView tvNome;
        public TextView tvCNS;
        public TextView tvData;
        public ImageButton btDelete;

        public FichaCadastroIndividualVH(View itemView) {
            super(itemView);

            cardRV = itemView.findViewById(R.id.card_rv);
            tvFicha = itemView.findViewById(R.id.tv_ficha);
            tvNome = itemView.findViewById(R.id.tv_nome);
            tvCNS = itemView.findViewById(R.id.tv_cns);
            tvData = itemView.findViewById(R.id.tv_data);
            btDelete = itemView.findViewById(R.id.bt_delete);

        }


    }

    public List<FichaCadastroIndividualModel> getList() {
        return mList;
    }

    public void setList(List<FichaCadastroIndividualModel> mList) {
        this.mList = mList;
    }
}
