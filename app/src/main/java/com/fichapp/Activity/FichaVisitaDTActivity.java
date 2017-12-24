package com.fichapp.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.fichapp.R;

public class FichaVisitaDTActivity extends AppCompatActivity {

    Spinner spinnerProfissional;
    Spinner spinnerHospital;
    Spinner spinnerTipoImovel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha_visita_dt);

        spinnerProfissional = (Spinner) findViewById(R.id.spinner_profissional);
        spinnerHospital = (Spinner) findViewById(R.id.spinner_hospital);
        spinnerTipoImovel = (Spinner) findViewById(R.id.spinner_tipo_imovel);

        ArrayAdapter adapterProfissional = ArrayAdapter.createFromResource(this, R.array.profissionais, android.R.layout.simple_spinner_item);
        spinnerProfissional.setAdapter(adapterProfissional);

        ArrayAdapter adapterHospital = ArrayAdapter.createFromResource(this, R.array.hospitais, android.R.layout.simple_spinner_item);
        spinnerHospital.setAdapter(adapterHospital);

        ArrayAdapter adapterTipoImovel = ArrayAdapter.createFromResource(this, R.array.tipoImovel, android.R.layout.simple_spinner_item);
        spinnerTipoImovel.setAdapter(adapterTipoImovel);
    }

}
