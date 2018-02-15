package com.fichapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.fichapp.R;
import com.fichapp.business.FichaCadastroDTFamiliasBS;
import com.fichapp.model.FamiliaModel;
import com.fichapp.model.TipoModel;
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

        fichaCadastroDTFamiliasVH.tvCnsResponsavel.setText(String.format(Locale.getDefault(), "%s", mList.get(position).getCnsResponsavel()));

        StringBuilder sb = new StringBuilder("Prontuario: ");

        if (!Utilitario.isEmpty(mList.get(position).getProntuario())) {
            sb.append(mList.get(position).getProntuario());
        }

        if (!Utilitario.isEmpty(mList.get(position).getDataNascimentoResponsavel())) {

            if (!Utilitario.isEmpty(sb.toString())) {
                sb.append(", ");
            }

            sb.append(Utilitario.getDataFormatada(mList.get(position).getDataNascimentoResponsavel()));
        }

        if (!Utilitario.isEmpty(sb.toString())) {
            fichaCadastroDTFamiliasVH.tvLinha2.setText(sb.toString());
        }

        sb = new StringBuilder("Renda familiar: ");

        if (!Utilitario.isEmpty(mList.get(position).getRendaFamiliar()) && !Utilitario.isEmpty(mList.get(position).getRendaFamiliar().getCodigo()) && mList.get(position).getRendaFamiliar().getCodigo() > 0) {

            List<TipoModel> rendaFamiliar = new TipoModel().getComboRendaFamiliar();

            sb.append(rendaFamiliar.get(rendaFamiliar.indexOf(mList.get(position).getRendaFamiliar())).getDescricao());

        }

        if (!Utilitario.isEmpty(sb.toString())) {
            fichaCadastroDTFamiliasVH.tvLinha3.setText(sb.toString());
        }

        sb = new StringBuilder("Reside desde: ");

        if (!Utilitario.isEmpty(mList.get(position).getResideMes()) && !Utilitario.isEmpty(mList.get(position).getResideAno()) && mList.get(position).getResideMes() > 0 &&mList.get(position).getResideAno() > 0) {
            sb.append(mList.get(position).getResideMes()).append("/").append(mList.get(position).getResideAno());
        }

        if (!Utilitario.isEmpty(sb.toString())) {
            fichaCadastroDTFamiliasVH.tvLinha4.setText(sb.toString());
        }

        sb = new StringBuilder("Membros: ");

        if (!Utilitario.isEmpty(mList.get(position).getNumeroMembros()) && mList.get(position).getNumeroMembros() > 0) {
            sb.append(mList.get(position).getNumeroMembros());
        }

        if (mList.get(position).getFlagMudou()) {

            if (!Utilitario.isEmpty(sb.toString())) {
                sb.append(", ");
            }

            sb.append("Mudou-se");
        }

        if (!Utilitario.isEmpty(sb.toString())) {
            fichaCadastroDTFamiliasVH.tvLinha5.setText(sb.toString());
        }

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

        public TextView tvCnsResponsavel;
        public TextView tvLinha2;
        public TextView tvLinha3;
        public TextView tvLinha4;
        public TextView tvLinha5;
        public ImageButton btDeletarFamilia;

        public FichaCadastroDTFamiliasVH(View itemView) {

            super(itemView);

            tvCnsResponsavel = itemView.findViewById(R.id.tv_cns_responsavel);
            tvLinha2 = itemView.findViewById(R.id.tv_linha2);
            tvLinha3 = itemView.findViewById(R.id.tv_linha3);
            tvLinha4 = itemView.findViewById(R.id.tv_linha4);
            tvLinha5 = itemView.findViewById(R.id.tv_linha5);
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
