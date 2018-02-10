package com.fichapp.business;

import android.content.Context;

import com.fichapp.dao.CNESDAO;
import com.fichapp.dao.MunicipioDAO;
import com.fichapp.dao.SMPEPDbHelper;
import com.fichapp.model.CNESModel;
import com.fichapp.model.MunicipioModel;
import com.fichapp.util.Utilitario;

import java.util.List;

/**
 * Created by Rodrigo Costa on 11/12/2017.
 */

public class MunicipioBS {

    MunicipioDAO municipioDAO;

    public MunicipioBS() {
    }

    public MunicipioBS(Context context) {
        SMPEPDbHelper smpepDbHelper = new SMPEPDbHelper(context);
        municipioDAO = new MunicipioDAO(smpepDbHelper);
    }

    public List<MunicipioModel> pesquisar(String uf) {
        return municipioDAO.pesquisar(uf);
    }

}
