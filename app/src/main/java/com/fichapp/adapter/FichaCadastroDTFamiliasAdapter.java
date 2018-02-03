package com.fichapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

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
    private FamiliaModel familiaModel;


    public FichaCadastroDTFamiliasAdapter(Context c, List<FamiliaModel> l){
        mList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public FichaCadastroDTFamiliasVH onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_rv_cadastro_familias, viewGroup, false);
        FichaCadastroDTFamiliasVH mvh = new FichaCadastroDTFamiliasVH(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(FichaCadastroDTFamiliasVH fichaCadastroDTFamiliasVH, final int position) {

        fichaCadastroDTFamiliasVH.etProntuarioFamiliar.setText(String.format(Locale.getDefault(), "%s", mList.get(position).getProntuario()));
        fichaCadastroDTFamiliasVH.etCnsResponsavel.setText(String.format(Locale.getDefault(), "%s", mList.get(position).getCnsResponsavel()));
        fichaCadastroDTFamiliasVH.etDataNascimentoResponsavel.setText(String.format("Data: %s", Utilitario.getDataFormatada(mList.get(position).getDataNascimentoResponsavel())));
        fichaCadastroDTFamiliasVH.spSalarioFamiliar.setSelection(new TipoModel().getComboRendaFamiliar().indexOf(this.familiaModel.getRendaFamiliar()));
        fichaCadastroDTFamiliasVH.etResideMes.setText(String.format(Locale.getDefault(), "%s", mList.get(position).getResideMes()));
        fichaCadastroDTFamiliasVH.etResideAno.setText(String.format(Locale.getDefault(), "%s", mList.get(position).getResideAno()));
        fichaCadastroDTFamiliasVH.etNumMembros.setText(String.format(Locale.getDefault(), "%s", mList.get(position).getNumeroMembros()));
        fichaCadastroDTFamiliasVH.cbMudou.setChecked(mList.get(position).getFlagMudou());

        mList.get(position).setProntuario(fichaCadastroDTFamiliasVH.etProntuarioFamiliar.getText().toString());
        mList.get(position).setCnsResponsavel(fichaCadastroDTFamiliasVH.etCnsResponsavel.getText().toString());
        mList.get(position).setProntuario(fichaCadastroDTFamiliasVH.etProntuarioFamiliar.getText().toString());
        mList.get(position).setRendaFamiliar((TipoModel) fichaCadastroDTFamiliasVH.spSalarioFamiliar.getSelectedItem());
        mList.get(position).setResideMes(Integer.valueOf(fichaCadastroDTFamiliasVH.etResideMes.getText().toString()));
        mList.get(position).setResideAno(Integer.valueOf(fichaCadastroDTFamiliasVH.etResideAno.getText().toString()));
        mList.get(position).setNumeroMembros(Integer.valueOf(fichaCadastroDTFamiliasVH.etNumMembros.getText().toString()));
        mList.get(position).setFlagMudou(fichaCadastroDTFamiliasVH.cbMudou.isChecked());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addListItem(FamiliaModel c, int position){
        mList.add(c);
        notifyItemInserted(position);
    }


    public void removeListItem(View view, int position){

        FichaCadastroDTFamiliasBS fichaCadastroDTFamiliasBS = new FichaCadastroDTFamiliasBS(view.getContext());
        fichaCadastroDTFamiliasBS.excluir(mList.get(position));
        mList.remove(position);
        notifyItemRemoved(position);
    }


    public class FichaCadastroDTFamiliasVH extends RecyclerView.ViewHolder {

        private EditText etProntuarioFamiliar;
        private EditText etCnsResponsavel;
        private EditText etDataNascimentoResponsavel;
        private Spinner spSalarioFamiliar;
        private EditText etResideMes;
        private EditText etResideAno;
        private EditText etNumMembros;
        private CheckBox cbMudou;

        public FichaCadastroDTFamiliasVH(View itemView) {

            super(itemView);
            etProntuarioFamiliar = (EditText) itemView.findViewById(R.id.et_num_prontuario_familiar);
            etCnsResponsavel = (EditText) itemView.findViewById(R.id.et_cns_responsavel);
            etDataNascimentoResponsavel = (EditText) itemView.findViewById(R.id.et_data_nascimento);
            spSalarioFamiliar = (Spinner) itemView.findViewById(R.id.sp_renda_familiar);
            etResideMes = (EditText) itemView.findViewById(R.id.et_reside_mes);
            etResideAno = (EditText) itemView.findViewById(R.id.et_reside_ano);
            etNumMembros = (EditText) itemView.findViewById(R.id.et_num_membros);
            cbMudou = (CheckBox) itemView.findViewById(R.id.cb_mudou_se);

        }


    }

    public List<FamiliaModel> getList() {
        return mList;
    }

    public void setList(List<FamiliaModel> mList) {
        this.mList = mList;
    }
}
