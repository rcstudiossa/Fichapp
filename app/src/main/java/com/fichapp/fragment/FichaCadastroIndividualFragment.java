package com.fichapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fichapp.R;
import com.fichapp.adapter.FichaCadastroIndividualAdapter;
import com.fichapp.business.FichaCadastroIndividualBS;
import com.fichapp.model.FichaCadastroIndividualModel;

import java.util.List;

public class FichaCadastroIndividualFragment extends TemplateFragment {

    private List<FichaCadastroIndividualModel> mList;
    private FichaCadastroIndividualBS fichaCadastroIndividualBS;
    private FichaCadastroIndividualAdapter adapter;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ficha_cadastro_individual, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_ficha_cadastro_individual);
        configRV();

        fichaCadastroIndividualBS = new FichaCadastroIndividualBS(getActivity());

        mList = fichaCadastroIndividualBS.pesquisarAtivos();

        adapter = new FichaCadastroIndividualAdapter(getActivity(), mList);
        mRecyclerView.setAdapter(adapter);

        return view;
    }

    protected void pesquisarAtivos(String query) {

        mList = fichaCadastroIndividualBS.pesquisarAtivos(query);

        adapter.setList(mList);
        adapter.notifyDataSetChanged();

    }

}
