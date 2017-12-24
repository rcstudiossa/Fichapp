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
import com.fichapp.Adapter.CNESAdapter;
import com.fichapp.Model.CNESModel;
import com.fichapp.R;
import com.fichapp.business.CNESBS;

import java.util.List;

public class CNESFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private List<CNESModel> mList;
    private CNESBS cnesBS;


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cnes, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_cnes);
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);

        cnesBS = new CNESBS(getActivity());

        mList = cnesBS.pesquisarAtivo();
        CNESAdapter adapter = new CNESAdapter(getActivity(), mList);
        mRecyclerView.setAdapter(adapter);

        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        return view;
    }

}
