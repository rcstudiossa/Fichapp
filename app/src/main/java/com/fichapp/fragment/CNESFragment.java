package com.fichapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fichapp.adapter.CNESAdapter;
import com.fichapp.model.CNESModel;
import com.fichapp.R;
import com.fichapp.business.CNESBS;
import com.fichapp.util.Utilitario;

import java.util.List;

public class CNESFragment extends TemplateFragment {

    private List<CNESModel> mList;
    private CNESBS cnesBS;
    private CNESAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cnes, container, false);

        mRecyclerView = view.findViewById(R.id.rv_cnes);
        configRV();

        cnesBS = new CNESBS(getActivity());

        mList = cnesBS.pesquisarAtivos();
        adapter = new CNESAdapter(getActivity(), mList);
        mRecyclerView.setAdapter(adapter);

        return view;
    }

    protected void pesquisarAtivos(String query) {

        mList = cnesBS.pesquisarAtivos(query);
        adapter.setList(mList);
        adapter.notifyDataSetChanged();

    }

    protected void exportar() {

    }

}
