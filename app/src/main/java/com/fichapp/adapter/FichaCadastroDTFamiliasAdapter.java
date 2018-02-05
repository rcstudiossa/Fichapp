package com.fichapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.fichapp.R;
import com.fichapp.business.FichaCadastroDTFamiliasBS;
import com.fichapp.model.FamiliaModel;
import com.fichapp.util.Utilitario;

import java.util.List;
import java.util.Locale;

/**
 * Created by Rodrigo Costa on 21/12/2017.
 */

public class FichaCadastroDTFamiliasAdapter extends RecyclerView.Adapter<FichaCadastroDTFamiliasAdapter.FichaCadastroDTFamiliasVH> {

    private List<FamiliaModel> mList;
    private LayoutInflater mLayoutInflater;


    public FichaCadastroDTFamiliasAdapter(Context c, List<FamiliaModel> l){
        mList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public FichaCadastroDTFamiliasVH onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_rv_familia, viewGroup, false);
        FichaCadastroDTFamiliasVH mvh = new FichaCadastroDTFamiliasVH(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(FichaCadastroDTFamiliasVH fichaCadastroDTFamiliasVH, final int position) {

        fichaCadastroDTFamiliasVH.tvProntuarioFamiliar.setText(String.format(Locale.getDefault(), "%s", mList.get(position).getProntuario()));
        fichaCadastroDTFamiliasVH.tvCnsResponsavel.setText(String.format(Locale.getDefault(), "%s", mList.get(position).getCnsResponsavel()));

        fichaCadastroDTFamiliasVH.btDeletarFamilia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeListItem(view, position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addListItem(FamiliaModel c) {
        addListItem(c, mList.size());
    }


    protected void addListItem(FamiliaModel c, int position){
        mList.add(c);
        notifyItemInserted(position);
    }


    public void removeListItem(View view, int position){

        FichaCadastroDTFamiliasBS fichaCadastroDTFamiliasBS = new FichaCadastroDTFamiliasBS(view.getContext());
        if (!Utilitario.isEmpty(mList) && !Utilitario.isEmpty(mList.get(position).getId())) {
            fichaCadastroDTFamiliasBS.excluir(mList.get(position));
        }
        mList.remove(position);
        notifyDataSetChanged();
    }


    public class FichaCadastroDTFamiliasVH extends RecyclerView.ViewHolder {

        public TextView tvProntuarioFamiliar;
        public TextView tvCnsResponsavel;
        public ImageButton btDeletarFamilia;

        public FichaCadastroDTFamiliasVH(View itemView) {

            super(itemView);

            tvProntuarioFamiliar = itemView.findViewById(R.id.tv_prontuario_familiar);
            tvCnsResponsavel = itemView.findViewById(R.id.tv_cns_responsavel);
            btDeletarFamilia = itemView.findViewById(R.id.bt_delete);

        }


    }

    public List<FamiliaModel> getList() {
        return mList;
    }

    public void setList(List<FamiliaModel> mList) {
        this.mList = mList;
    }

}
