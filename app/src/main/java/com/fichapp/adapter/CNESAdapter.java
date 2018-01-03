package com.fichapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.fichapp.activity.CNESActivity;
import com.fichapp.model.CNESModel;
import com.fichapp.R;
import com.fichapp.business.CNESBS;

import java.util.List;
import java.util.Locale;

public class CNESAdapter extends RecyclerView.Adapter<CNESAdapter.CNESViewHolder> {

    private List<CNESModel> mList;
    private LayoutInflater mLayoutInflater;


    public CNESAdapter(Context c, List<CNESModel> l){
        mList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public CNESViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_rv_cnes, viewGroup, false);
        CNESViewHolder mvh = new CNESViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(CNESViewHolder cnesVH, final int position) {

        cnesVH.nome.setText(String.format(Locale.getDefault(), "%s", mList.get(position).getNome()));
        cnesVH.cnes.setText(String.format(Locale.getDefault(), "CNES: %s", mList.get(position).getCodigo()));

        cnesVH.editBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), CNESActivity.class);
                intent.putExtra("cnes", mList.get(position));

                view.getContext().startActivity(intent);

            }
        });

        cnesVH.deleteBT.setOnClickListener(new View.OnClickListener() {
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




    public void addListItem(CNESModel c, int position){
        mList.add(c);
        notifyItemInserted(position);
    }


    public void removeListItem(View view, int position){
        CNESBS cnesBS = new CNESBS(view.getContext());
        cnesBS.excluir(mList.get(position));
        mList.remove(position);
        notifyItemRemoved(position);
    }

    //VIEWHOLDER

    public class CNESViewHolder extends RecyclerView.ViewHolder {

        public TextView cnes;
        public TextView nome;
        public ImageButton editBT;
        public ImageButton deleteBT;

        public CNESViewHolder(View itemView) {
            super(itemView);
            cnes = (TextView) itemView.findViewById(R.id.tv_cnes);
            nome = (TextView) itemView.findViewById(R.id.tv_nome);
            editBT = (ImageButton) itemView.findViewById(R.id.edit_bt);
            deleteBT = (ImageButton) itemView.findViewById(R.id.delete_bt);

        }


    }

    public List<CNESModel> getList() {
        return mList;
    }

    public void setList(List<CNESModel> mList) {
        this.mList = mList;
    }
}


