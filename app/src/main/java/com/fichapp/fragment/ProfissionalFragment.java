package com.fichapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fichapp.adapter.ProfissionalAdapter;
import com.fichapp.model.ProfissionalModel;
import com.fichapp.R;
import com.fichapp.business.ProfissionalBS;

import java.util.List;

public class ProfissionalFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private List<ProfissionalModel> mList;
    private ProfissionalBS profissionalBS;


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profissional, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_profissional);
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);

        profissionalBS = new ProfissionalBS(getActivity());

        mList = profissionalBS.pesquisarAtivos();
        ProfissionalAdapter adapter = new ProfissionalAdapter(getActivity(), mList);
        mRecyclerView.setAdapter( adapter );

        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));


        return view;
    }

}
