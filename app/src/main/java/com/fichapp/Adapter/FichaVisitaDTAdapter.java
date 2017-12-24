package com.fichapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fichapp.Model.FichaVisitaDTModel;
import com.fichapp.R;

import java.util.List;

/**
 * Created by Rodrigo Costa on 21/12/2017.
 */

public class FichaVisitaDTAdapter extends RecyclerView.Adapter<FichaVisitaDTAdapter.MyViewHolder> {
    private List<FichaVisitaDTModel> mList;
    private LayoutInflater mLayoutInflater;


    public FichaVisitaDTAdapter(Context c, List<FichaVisitaDTModel> l){
        mList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_rv_ficha_visita_dt, viewGroup, false);
        MyViewHolder mvh = new MyViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {
        myViewHolder.tvModel.setText(mList.get(position).getModel() );
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }




    public void addListItem(FichaVisitaDTModel c, int position){
        mList.add(c);
        notifyItemInserted(position);
    }


    public void removeListItem(int position){
        mList.remove(position);
        notifyItemRemoved(position);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivCar;
        public TextView tvModel;
        public TextView tvBrand;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvModel = (TextView) itemView.findViewById(R.id.prontuario_paciente);


        }


    }
}
