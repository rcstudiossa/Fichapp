package com.fichapp.fragment;


import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.fichapp.adapter.FichaVisitaDTAdapter;
import com.fichapp.model.FichaVisitaDTModel;
import com.fichapp.R;
import com.fichapp.business.FichaVisitaDTBS;
import com.fichapp.util.Utilitario;

import java.util.List;

public class FichaVisitaDTFragment extends TemplateFragment {

    private List<FichaVisitaDTModel> mList;
    private FichaVisitaDTBS fichaVisitaDTBS;
    private FichaVisitaDTAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ficha_visita_dt, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_ficha_dt);
        this.configRV();

        fichaVisitaDTBS = new FichaVisitaDTBS(getActivity());

        mList = fichaVisitaDTBS.pesquisarAtivos();
        
        adapter = new FichaVisitaDTAdapter(getActivity(), mList);
        mRecyclerView.setAdapter( adapter );

        return view;
    }



    protected void pesquisarAtivos(String query) {

        mList = fichaVisitaDTBS.pesquisarAtivos(query);

        adapter.setList(mList);
        adapter.notifyDataSetChanged();

    }

}
