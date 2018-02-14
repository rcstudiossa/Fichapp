package com.fichapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.fichapp.R;
import com.fichapp.business.FichaVisitaDTBS;

import java.util.List;

/**
 * Created by Rodrigo Costa on 21/12/2017.
 */

public abstract class TemplateAdapter<T extends RecyclerView.Adapter> {

    private List<T> mList;
    private LayoutInflater mLayoutInflater;
    private T fichaSelecionada;


    public TemplateAdapter(Context c, List<T> l) {
        mList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void onBindViewHolder(TemplateVH ficha, final int position) {

        ficha.deleteBT.setOnClickListener(new View.OnClickListener() {
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

    public int getItemCount() {
        return mList.size();
    }

    public void restaurarFicha(View view, int position) {

        FichaVisitaDTBS fichaVisitaDTBS = new FichaVisitaDTBS(view.getContext());
        //fichaVisitaDTBS.restaurar(fichaSelecionada);
        mList.add(position, fichaSelecionada);
        //notifyItemInserted(position);

    }


    public void removerFicha(View view, int position) {

        FichaVisitaDTBS fichaVisitaDTBS = new FichaVisitaDTBS(view.getContext());
        fichaSelecionada = mList.get(position);
        //fichaVisitaDTBS.excluir(fichaSelecionada);
        mList.remove(position);
        //notifyItemRemoved(position);
    }


    public class TemplateVH extends RecyclerView.ViewHolder {

        public TextView linha1TV;
        public TextView linha2TV;
        public TextView linha3TV;
        public TextView dataTV;
        public ImageButton editBT;
        public ImageButton deleteBT;

        public TemplateVH(View itemView) {

            super(itemView);
            /*linha1TV = (TextView) itemView.findViewById(R.id.tv_linha_1);
            linha2TV = (TextView) itemView.findViewById(R.id.tv_linha_2);
            linha3TV = (TextView) itemView.findViewById(R.id.tv_linha_3);
            */dataTV = (TextView) itemView.findViewById(R.id.tv_data);
            editBT = (ImageButton) itemView.findViewById(R.id.bt_edit);
            deleteBT = (ImageButton) itemView.findViewById(R.id.bt_delete);

        }


    }

    public List<T> getList() {
        return mList;
    }

    public void setList(List<T> mList) {
        this.mList = mList;
    }
}
