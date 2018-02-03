package com.fichapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

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

        fichaCadastroDTVH.tvCep.setText(String.format(Locale.getDefault(), "CEP: %s", mList.get(position).getCep()));
        fichaCadastroDTVH.tvBairro.setText(String.format(Locale.getDefault(), "%s, %s", mList.get(position).getBairro(), mList.get(position).getNumero()));
        fichaCadastroDTVH.tvData.setText(String.format("Data: %s", Utilitario.getDataFormatada(mList.get(position).getDataRegistro())));

        fichaCadastroDTVH.editBT.setOnClickListener(new View.OnClickListener() {
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
                removeListItem(view, position);
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


    public void removeListItem(View view, int position){

        FichaCadastroDTBS fichaCadastroDTBS = new FichaCadastroDTBS(view.getContext());
        fichaCadastroDTBS.excluir(mList.get(position));
        mList.remove(position);
        notifyItemRemoved(position);
    }


    public class FichaCadastroDTVH extends RecyclerView.ViewHolder {

        public TextView tvCep;
        public TextView tvBairro;
        public TextView tvData;
        public ImageButton editBT;
        public ImageButton deleteBT;

        public FichaCadastroDTVH(View itemView) {
            super(itemView);
            tvCep = (TextView) itemView.findViewById(R.id.tv_cep);
            tvBairro = (TextView) itemView.findViewById(R.id.tv_bairro);
            tvData = (TextView) itemView.findViewById(R.id.tv_data);
            editBT = (ImageButton) itemView.findViewById(R.id.edit_bt);
            deleteBT = (ImageButton) itemView.findViewById(R.id.delete_bt);

        }


    }

    public List<FichaCadastroDTModel> getList() {
        return mList;
    }

    public void setList(List<FichaCadastroDTModel> mList) {
        this.mList = mList;
    }
}
