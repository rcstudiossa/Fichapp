package com.fichapp.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fichapp.Activity.MainActivity;
import com.fichapp.Adapter.FichaVisitaDTAdapter;
import com.fichapp.Model.FichaVisitaDTModel;
import com.fichapp.R;
import com.fichapp.business.CNESBS;
import com.fichapp.business.FichaVisitaDTBS;

import java.util.List;

public class FichaVisitaDTFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private List<FichaVisitaDTModel> mList;
    private FichaVisitaDTBS fichaVisitaDTBS;


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

        mList = fichaVisitaDTBS.pesquisarAtivo();
        
        FichaVisitaDTAdapter adapter = new FichaVisitaDTAdapter(getActivity(), mList);
        mRecyclerView.setAdapter( adapter );

        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));


        return view;
    }

}
