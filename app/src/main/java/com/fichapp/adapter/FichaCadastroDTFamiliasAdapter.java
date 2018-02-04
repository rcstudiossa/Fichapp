package com.fichapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
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


    public FichaCadastroDTFamiliasAdapter(Context c, List<FamiliaModel> l){
        mList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public FichaCadastroDTFamiliasVH onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.include_cadastro_familia, viewGroup, false);
        FichaCadastroDTFamiliasVH mvh = new FichaCadastroDTFamiliasVH(v, new RecyclerToModelListener());
        return mvh;
    }

    @Override
    public void onBindViewHolder(FichaCadastroDTFamiliasVH fichaCadastroDTFamiliasVH, final int position) {

        fichaCadastroDTFamiliasVH.recyclerToModelListener.updatePosition(position);

        fichaCadastroDTFamiliasVH.etProntuarioFamiliar.setText(String.format(Locale.getDefault(), "%s", mList.get(position).getProntuario()));
        fichaCadastroDTFamiliasVH.etCnsResponsavel.setText(String.format(Locale.getDefault(), "%s", mList.get(position).getCnsResponsavel()));
        fichaCadastroDTFamiliasVH.etDataNascimentoResponsavel.setText(String.format("Data: %s", Utilitario.getDataFormatada(mList.get(position).getDataNascimentoResponsavel())));
        fichaCadastroDTFamiliasVH.spSalarioFamiliar.setSelection(new TipoModel().getComboRendaFamiliar().indexOf(mList.get(position).getRendaFamiliar()));
        fichaCadastroDTFamiliasVH.etResideMes.setText(String.format(Locale.getDefault(), "%s", mList.get(position).getResideMes()));
        fichaCadastroDTFamiliasVH.etResideAno.setText(String.format(Locale.getDefault(), "%s", mList.get(position).getResideAno()));
        fichaCadastroDTFamiliasVH.etNumMembros.setText(String.format(Locale.getDefault(), "%s", mList.get(position).getNumeroMembros()));
        fichaCadastroDTFamiliasVH.cbMudou.setChecked(mList.get(position).getFlagMudou() == null ? false : mList.get(position).getFlagMudou());

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
        public RecyclerToModelListener recyclerToModelListener;

        public FichaCadastroDTFamiliasVH(View itemView, RecyclerToModelListener listener) {

            super(itemView);
            recyclerToModelListener = listener;

            etProntuarioFamiliar = itemView.findViewById(R.id.et_num_prontuario_familiar);
            etProntuarioFamiliar.addTextChangedListener(listener);
            etCnsResponsavel = itemView.findViewById(R.id.et_cns_responsavel);
            etDataNascimentoResponsavel = (EditText) itemView.findViewById(R.id.et_data_nascimento);
            spSalarioFamiliar = itemView.findViewById(R.id.sp_renda_familiar);
            etResideMes = itemView.findViewById(R.id.et_reside_mes);
            etResideAno = itemView.findViewById(R.id.et_reside_ano);
            etNumMembros = itemView.findViewById(R.id.et_num_membros);
            cbMudou = itemView.findViewById(R.id.cb_mudou_se);

        }


    }

    public List<FamiliaModel> getList() {
        return mList;
    }

    public void setList(List<FamiliaModel> mList) {
        this.mList = mList;
    }


    private class RecyclerToModelListener implements TextWatcher {

        private int position;

        public void updatePosition(int position) {
            this.position = position;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            // no op
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            mList.get(position).setProntuario(editable.toString());
        }
    }
}
