package com.fichapp.fragment;


import android.net.http.HttpResponseCache;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fichapp.adapter.FichaVisitaDTAdapter;
import com.fichapp.model.FichaVisitaDTModel;
import com.fichapp.R;
import com.fichapp.business.FichaVisitaDTBS;

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

    protected void exportar() {

        ExportTask exportTask;

        List<FichaVisitaDTModel> fichas = fichaVisitaDTBS.pesquisarNaoExportados();

        for (FichaVisitaDTModel ficha: fichas) {

            exportTask = new ExportTask(ficha);
            exportTask.execute((Void) null);

        }

    }

    public class ExportTask extends AsyncTask<Void, Void, Boolean> {

        private FichaVisitaDTModel ficha;

        ExportTask(FichaVisitaDTModel ficha) {
            this.ficha = ficha;
        }

        @Override
        protected Boolean doInBackground(Void... params) {

            String jsonStr = fichaVisitaDTBS.getJSONObject(ficha);

            String url = "http://localhost:8080/smpep/webresources/wsintegracaoubs/inserirFichaVisitaDomiciliar";

            //new HttpHandler().makeRequest(url, jsonStr);

            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {

            /*mAuthTask = null;
            showProgress(false);

            if (success) {
                mInfo.setVisibility(View.VISIBLE);
            } else {
                if (!TextUtils.isEmpty(jsonStr)) {
                    mEmailView.setError(getString(R.string.error_exist_email));
                    mEmailView.requestFocus();
                }
            }*/

        }

        @Override
        protected void onCancelled() {
            /*mAuthTask = null;
            showProgress(false);*/
        }
    }




}
