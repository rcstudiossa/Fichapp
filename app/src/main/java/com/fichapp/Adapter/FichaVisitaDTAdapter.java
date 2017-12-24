package com.fichapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.fichapp.Activity.CNESActivity;
import com.fichapp.Activity.FichaVisitaDTActivity;
import com.fichapp.Model.FichaVisitaDTModel;
import com.fichapp.R;
import com.fichapp.business.CNESBS;
import com.fichapp.business.FichaVisitaDTBS;

import java.util.List;
import java.util.Locale;

/**
 * Created by Rodrigo Costa on 21/12/2017.
 */

public class FichaVisitaDTAdapter extends RecyclerView.Adapter<FichaVisitaDTAdapter.FichaVisitaDTVH> {

    private List<FichaVisitaDTModel> mList;
    private LayoutInflater mLayoutInflater;


    public FichaVisitaDTAdapter(Context c, List<FichaVisitaDTModel> l){
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

        fichaVisitaDTVH.ficha.setText(String.format(Locale.getDefault(), "CNS: %s, P: %s", mList.get(position).getCnsCidadao(), mList.get(position).getProntuario()));

        fichaVisitaDTVH.editBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), FichaVisitaDTActivity.class);
                intent.putExtra("fichaVisitaDT", mList.get(position));

                view.getContext().startActivity(intent);

            }
        });

        fichaVisitaDTVH.deleteBT.setOnClickListener(new View.OnClickListener() {
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




    public void addListItem(FichaVisitaDTModel c, int position){
        mList.add(c);
        notifyItemInserted(position);
    }


    public void removeListItem(View view, int position){

        FichaVisitaDTBS fichaVisitaDTBS = new FichaVisitaDTBS(view.getContext());
        fichaVisitaDTBS.excluir(mList.get(position));
        mList.remove(position);
        notifyItemRemoved(position);
    }


    public class FichaVisitaDTVH extends RecyclerView.ViewHolder {

        public TextView ficha;
        public ImageButton editBT;
        public ImageButton deleteBT;

        public FichaVisitaDTVH(View itemView) {
            super(itemView);
            ficha = (TextView) itemView.findViewById(R.id.ficha);
            editBT = (ImageButton) itemView.findViewById(R.id.edit_bt);
            deleteBT = (ImageButton) itemView.findViewById(R.id.delete_bt);

        }


    }
}
