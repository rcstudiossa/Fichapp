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

import com.fichapp.R;
import com.fichapp.adapter.CNESAdapter;
import com.fichapp.business.CNESBS;
import com.fichapp.model.CNESModel;
import com.fichapp.util.Utilitario;

import java.util.List;

public abstract class TemplateFragment extends Fragment {

    protected SearchView searchView;

    protected void instanciarPesquisa() {

        searchView = getActivity().findViewById(R.id.searchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                pesquisarAtivos(query);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                if(Utilitario.isEmpty(newText)){
                    this.onQueryTextSubmit(newText);
                }

                return true;
            }
        });

    }

    protected abstract void pesquisarAtivos(String query);

}
