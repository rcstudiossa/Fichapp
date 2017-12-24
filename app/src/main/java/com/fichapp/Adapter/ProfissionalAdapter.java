package com.fichapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.fichapp.Activity.CNESActivity;
import com.fichapp.Model.ProfissionalModel;
import com.fichapp.R;
import com.fichapp.business.CNESBS;
import com.fichapp.business.ProfissionalBS;

import java.util.List;
import java.util.Locale;

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
    public void onBindViewHolder(ProfissionalViewHolder profissionalViewHolder, final int position) {

        profissionalViewHolder.profissional.setText(String.format(Locale.getDefault(), "%s, CBO: %s", mList.get(position).getNome(), mList.get(position).getCbo()));

        profissionalViewHolder.editBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), CNESActivity.class);
                intent.putExtra("profissional", mList.get(position));

                view.getContext().startActivity(intent);

            }
        });

        profissionalViewHolder.deleteBT.setOnClickListener(new View.OnClickListener() {
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


    public void addListItem(ProfissionalModel c, int position){
        mList.add(c);
        notifyItemInserted(position);
    }


    public void removeListItem(View view, int position){
        ProfissionalBS profissionalBS = new ProfissionalBS(view.getContext());
        profissionalBS.excluir(mList.get(position));
        mList.remove(position);
        notifyItemRemoved(position);
    }


    public class ProfissionalViewHolder extends RecyclerView.ViewHolder {

        public TextView profissional;
        public ImageButton editBT;
        public ImageButton deleteBT;

        public ProfissionalViewHolder(View itemView) {

            super(itemView);

            profissional = (TextView) itemView.findViewById(R.id.profissional);
            editBT = (ImageButton) itemView.findViewById(R.id.edit_bt);
            deleteBT = (ImageButton) itemView.findViewById(R.id.delete_bt);

        }

    }
}
