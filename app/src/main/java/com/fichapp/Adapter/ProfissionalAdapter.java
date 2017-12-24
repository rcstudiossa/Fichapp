package com.fichapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fichapp.Model.ProfissionalModel;
import com.fichapp.R;

import java.util.List;

/**
 * Created by Rodrigo Costa on 21/12/2017.
 */

public class ProfissionalAdapter extends RecyclerView.Adapter<ProfissionalAdapter.ProfissionalViewHolder> {
    private List<ProfissionalModel> mList;
    private LayoutInflater mLayoutInflater;


    public ProfissionalAdapter(Context c, List<ProfissionalModel> l){
        mList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public ProfissionalViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_rv_profissional, viewGroup, false);
        ProfissionalViewHolder mvh = new ProfissionalViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(ProfissionalViewHolder myViewHolder, int position) {
        myViewHolder.tvModel.setText(mList.get(position).getModel() );
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public void addListItem(ProfissionalModel c, int position){
        mList.add(c);
        notifyItemInserted(position);
    }


    public void removeListItem(int position){
        mList.remove(position);
        notifyItemRemoved(position);
    }


    public class ProfissionalViewHolder extends RecyclerView.ViewHolder {

        public TextView tvModel;

        public ProfissionalViewHolder(View itemView) {
            super(itemView);

            tvModel = (TextView) itemView.findViewById(R.id.cbo_nome);

        }


    }
}
