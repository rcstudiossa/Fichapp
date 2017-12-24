package com.fichapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.fichapp.Activity.CNESActivity;
import com.fichapp.Model.CNESModel;
import com.fichapp.R;
import com.fichapp.business.CNESBS;

import java.util.ArrayList;
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

        cnesVH.CNES.setText(String.format(Locale.getDefault(), "%s - %s", mList.get(position).getCodigo(), mList.get(position).getNome()));

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

        public TextView CNES;
        public ImageButton editBT;
        public ImageButton deleteBT;

        public CNESViewHolder(View itemView) {
            super(itemView);
            CNES = (TextView) itemView.findViewById(R.id.cnes_nome);
            editBT = (ImageButton) itemView.findViewById(R.id.edit_bt);
            deleteBT = (ImageButton) itemView.findViewById(R.id.delete_bt);

        }


    }
}


