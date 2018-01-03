package com.fichapp.fragment;


import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fichapp.adapter.FichaVisitaDTAdapter;
import com.fichapp.model.FichaVisitaDTModel;
import com.fichapp.R;
import com.fichapp.business.FichaVisitaDTBS;
import com.fichapp.util.Utilitario;

import java.util.List;

public class FichaVisitaDTFragment extends TemplateFragment {

    private RecyclerView mRecyclerView;
    private List<FichaVisitaDTModel> mList;
    private FichaVisitaDTBS fichaVisitaDTBS;
    private FichaVisitaDTAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ficha_visita_dt, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_ficha_dt);
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);

        fichaVisitaDTBS = new FichaVisitaDTBS(getActivity());

        mList = fichaVisitaDTBS.pesquisarAtivos();
        
        adapter = new FichaVisitaDTAdapter(getActivity(), mList);
        mRecyclerView.setAdapter( adapter );

        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        this.instanciarPesquisa();

        return view;
    }

    protected void pesquisarAtivos(String query) {

        if (Utilitario.isEmpty(query)) {
            mList = fichaVisitaDTBS.pesquisarAtivos();
        } else {
            mList = fichaVisitaDTBS.pesquisarAtivos(query);
        }

        adapter.setList(mList);
        adapter.notifyDataSetChanged();

    }

}
