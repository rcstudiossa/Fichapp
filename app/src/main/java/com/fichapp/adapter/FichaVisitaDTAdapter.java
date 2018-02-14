package com.fichapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.fichapp.activity.FichaVisitaDTActivity;
import com.fichapp.model.FichaVisitaDTModel;
import com.fichapp.R;
import com.fichapp.business.FichaVisitaDTBS;
import com.fichapp.util.Utilitario;

import java.util.List;
import java.util.Locale;

/**
 * Created by Rodrigo Costa on 21/12/2017.
 */

public class FichaVisitaDTAdapter extends RecyclerView.Adapter<FichaVisitaDTAdapter.FichaVisitaDTVH> {

    private List<FichaVisitaDTModel> mList;
    private LayoutInflater mLayoutInflater;
    private FichaVisitaDTModel fichaSelecionada;

    public List<FichaVisitaDTModel> getmList() {
        return mList;
    }

    public FichaVisitaDTAdapter(Context c, List<FichaVisitaDTModel> l) {
        mList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public FichaVisitaDTVH onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_rv_ficha_visita_dt, viewGroup, false);
        FichaVisitaDTVH mvh = new FichaVisitaDTVH(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(FichaVisitaDTVH fichaVisitaDTVH, final int position) {

        fichaVisitaDTVH.fichaTV.setText(String.format(Locale.getDefault(), "Ficha %s", mList.get(position).getId()));

        if (Utilitario.isEmpty(mList.get(position).getCnsCidadao())) {
            fichaVisitaDTVH.cnsTV.setText("Sem CNS Cadastrado");
        } else {
            fichaVisitaDTVH.cnsTV.setText(String.format(Locale.getDefault(), "CNS: %s", mList.get(position).getCnsCidadao()));
        }

        if (Utilitario.isEmpty(mList.get(position).getProntuario())) {
            fichaVisitaDTVH.prontuarioTV.setText("Sem Prontuário Cadastrado");
        } else {
            fichaVisitaDTVH.prontuarioTV.setText(String.format(Locale.getDefault(), "Prontuário: %s", mList.get(position).getProntuario()));
        }

        fichaVisitaDTVH.dataTV.setText(String.format("Data: %s", Utilitario.getDataFormatada(mList.get(position).getDataRegistro())));

        fichaVisitaDTVH.deleteBT.setOnClickListener(new View.OnClickListener() {
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

        fichaVisitaDTVH.cardRV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), FichaVisitaDTActivity.class);
                FichaVisitaDTBS fichaVisitaDTBS = new FichaVisitaDTBS(view.getContext());
                intent.putExtra("fichaVisitaDT", fichaVisitaDTBS.obter(mList.get(position)));
                view.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public void addListItem(FichaVisitaDTModel c, int position) {
        mList.add(c);
        notifyItemInserted(position);
    }

    public void restaurarFicha(View view, int position) {

        FichaVisitaDTBS fichaVisitaDTBS = new FichaVisitaDTBS(view.getContext());
        fichaVisitaDTBS.restaurar(fichaSelecionada);
        mList.add(position, fichaSelecionada);
        notifyItemInserted(position);

    }


    public void removerFicha(View view, int position) {

        FichaVisitaDTBS fichaVisitaDTBS = new FichaVisitaDTBS(view.getContext());
        fichaSelecionada = mList.get(position);
        fichaVisitaDTBS.excluir(fichaSelecionada);
        mList.remove(position);
        notifyItemRemoved(position);

    }



    public class FichaVisitaDTVH extends RecyclerView.ViewHolder {

        public CardView cardRV;

        public TextView fichaTV;
        public TextView cnsTV;
        public TextView prontuarioTV;
        public TextView dataTV;
        public ImageButton deleteBT;

        public FichaVisitaDTVH(View itemView) {
            super(itemView);

            cardRV = (CardView) itemView.findViewById(R.id.card_rv);
            fichaTV = (TextView) itemView.findViewById(R.id.et_ficha);
            cnsTV = (TextView) itemView.findViewById(R.id.et_cns);
            prontuarioTV = (TextView) itemView.findViewById(R.id.tvProntuario);
            dataTV = (TextView) itemView.findViewById(R.id.tv_data);
            deleteBT = (ImageButton) itemView.findViewById(R.id.bt_delete);

        }


    }

    public List<FichaVisitaDTModel> getList() {
        return mList;
    }

    public void setList(List<FichaVisitaDTModel> mList) {
        this.mList = mList;
    }
}
