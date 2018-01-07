package com.fichapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;

import com.fichapp.R;
import com.fichapp.adapter.CNESAdapter;
import com.fichapp.util.Utilitario;

public abstract class TemplateFragment extends Fragment implements SearchView.OnQueryTextListener {

    protected RecyclerView mRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu,MenuInflater inflater) {

        super.onCreateOptionsMenu(menu, inflater);

        SearchView sv = (SearchView) menu.findItem(R.id.search_bar).getActionView();
        sv.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        pesquisarAtivos(query);

        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        if (Utilitario.isEmpty(newText)) {
            return this.onQueryTextSubmit(newText);
        }

        return false;
    }

    protected void configRV() {

        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

    }

    protected abstract void pesquisarAtivos(String query);

}