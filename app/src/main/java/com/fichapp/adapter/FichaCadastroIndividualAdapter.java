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
import com.fichapp.activity.FichaCadastroIndividualActivity;
import com.fichapp.business.FichaCadastroIndividualBS;
import com.fichapp.model.FichaCadastroIndividualModel;

import java.util.List;
import java.util.Locale;

/**
 * Created by Rodrigo Costa on 21/12/2017.
 */

public class FichaCadastroIndividualAdapter extends RecyclerView.Adapter<FichaCadastroIndividualAdapter.FichaCadastroIndividualVH> {

    private List<FichaCadastroIndividualModel> mList;
    private LayoutInflater mLayoutInflater;

    public FichaCadastroIndividualAdapter(Context c, List<FichaCadastroIndividualModel> l) {
        mList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public FichaCadastroIndividualVH onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_rv_ficha_cadastro_individual, viewGroup, false);
        FichaCadastroIndividualVH mvh = new FichaCadastroIndividualVH(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(FichaCadastroIndividualVH fichaCadastroIndividualVH, final int position) {

        fichaCadastroIndividualVH.tvNome.setText(String.format(Locale.getDefault(), "%s", mList.get(position).getNomeCompleto()));
        fichaCadastroIndividualVH.tvCNS.setText(String.format(Locale.getDefault(), "CNS: %s", mList.get(position).getCnsCidadao()));
        //fichaCadastroIndividualVH.tvData.setText(String.format("Data: %s", new SimpleDateFormat("dd/MM/yyyy").format(mList.get(position).getDataRegistro())));

        fichaCadastroIndividualVH.btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), FichaCadastroIndividualActivity.class);

                FichaCadastroIndividualBS fichaCadastroIndividualBS = new FichaCadastroIndividualBS(view.getContext());

                intent.putExtra("fichaCadastroIndividual", fichaCadastroIndividualBS.obter(mList.get(position)));

                view.getContext().startActivity(intent);

            }
        });

        fichaCadastroIndividualVH.btDelete.setOnClickListener(new View.OnClickListener() {
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


    public void addListItem(FichaCadastroIndividualModel c, int position) {
        mList.add(c);
        notifyItemInserted(position);
    }


    public void removeListItem(View view, int position) {

        FichaCadastroIndividualBS fichaCadastroIndividualBS = new FichaCadastroIndividualBS(view.getContext());
        fichaCadastroIndividualBS.excluir(mList.get(position));
        mList.remove(position);
        notifyItemRemoved(position);
    }


    public class FichaCadastroIndividualVH extends RecyclerView.ViewHolder {

        public TextView tvNome;
        public TextView tvCNS;
        public TextView tvData;
        public ImageButton btEdit;
        public ImageButton btDelete;

        public FichaCadastroIndividualVH(View itemView) {
            super(itemView);
            tvNome = (TextView) itemView.findViewById(R.id.tv_nome);
            tvCNS = (TextView) itemView.findViewById(R.id.et_cns);
            tvData = (TextView) itemView.findViewById(R.id.tv_data);
            btEdit = (ImageButton) itemView.findViewById(R.id.bt_edit);
            btDelete = (ImageButton) itemView.findViewById(R.id.bt_delete);

        }


    }

    public List<FichaCadastroIndividualModel> getList() {
        return mList;
    }

    public void setList(List<FichaCadastroIndividualModel> mList) {
        this.mList = mList;
    }
}
