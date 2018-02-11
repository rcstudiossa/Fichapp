package com.fichapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.fichapp.activity.ProfissionalActivity;
import com.fichapp.model.ProfissionalModel;
import com.fichapp.R;
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

        profissionalViewHolder.nomeTV.setText(String.format(Locale.getDefault(), "%s", mList.get(position).getNome()));
        profissionalViewHolder.cnsTV.setText(String.format(Locale.getDefault(), "CNS: %s", mList.get(position).getCns()));
        profissionalViewHolder.cboTV.setText(String.format(Locale.getDefault(), "CBO: %s", mList.get(position).getCbo().getCodigo()));

        profissionalViewHolder.editBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), ProfissionalActivity.class);
                intent.putExtra("nomeTV", mList.get(position));

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

        public TextView nomeTV;
        public TextView cnsTV;
        public TextView cboTV;
        public ImageButton editBT;
        public ImageButton deleteBT;

        public ProfissionalViewHolder(View itemView) {

            super(itemView);

            nomeTV = (TextView) itemView.findViewById(R.id.et_nome_completo);
            cnsTV = (TextView) itemView.findViewById(R.id.tv_cns);
            cboTV = (TextView) itemView.findViewById(R.id.tv_cbo);
            editBT = (ImageButton) itemView.findViewById(R.id.edit_bt);
            deleteBT = (ImageButton) itemView.findViewById(R.id.delete_bt);

        }

    }

    public List<ProfissionalModel> getList() {
        return mList;
    }

    public void setList(List<ProfissionalModel> mList) {
        this.mList = mList;
    }
}
