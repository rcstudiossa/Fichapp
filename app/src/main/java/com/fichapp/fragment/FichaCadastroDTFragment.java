package com.fichapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fichapp.R;
import com.fichapp.adapter.FichaCadastroDTAdapter;
import com.fichapp.business.FichaCadastroDTBS;
import com.fichapp.model.FichaCadastroDTModel;

import java.util.List;

public class FichaCadastroDTFragment extends TemplateFragment {

    private List<FichaCadastroDTModel> mList;
    private FichaCadastroDTBS fichaCadastroDTBS;
    private FichaCadastroDTAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ficha_cadastro_dt, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_ficha_dt);
        this.configRV();

        fichaCadastroDTBS = new FichaCadastroDTBS(getActivity());

        mList = fichaCadastroDTBS.pesquisarAtivos();

        adapter = new FichaCadastroDTAdapter(getActivity(), mList);
        mRecyclerView.setAdapter(adapter);

        return view;
    }

    protected void pesquisarAtivos(String query) {

        mList = fichaCadastroDTBS.pesquisarAtivos(query);

        adapter.setList(mList);
        adapter.notifyDataSetChanged();

    }

    protected void exportar() {

    }

}
