package com.fichapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.fichapp.R;

public class FichaCadastroIdvActivity extends AppCompatActivity {

    private Spinner spRaca;
    private Spinner spParentesco;
    private Spinner spCurso;
    private Spinner spTrabalho;
    private Spinner spOrientacao;
    private Spinner spGenero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha_cadastro_idv);

        spRaca = (Spinner) findViewById(R.id.spinner_raca);
        ArrayAdapter spAdapterRaca = ArrayAdapter.createFromResource(this, R.array.raca, R.layout.spinner_item);
        spAdapterRaca.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spRaca.setAdapter(spAdapterRaca);

        spParentesco = (Spinner) findViewById(R.id.spinner_parentesco);
        ArrayAdapter spAdapterParentesco = ArrayAdapter.createFromResource(this, R.array.parentesco, R.layout.spinner_item);
        spAdapterParentesco.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spParentesco.setAdapter(spAdapterParentesco);

        spCurso = (Spinner) findViewById(R.id.spinner_curso_frequentado);
        ArrayAdapter spAdapterCurso = ArrayAdapter.createFromResource(this, R.array.curso, R.layout.spinner_item);
        spAdapterCurso.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCurso.setAdapter(spAdapterCurso);

        spTrabalho = (Spinner) findViewById(R.id.spinner_situacao_trabalho);
        ArrayAdapter spAdapterTrabalho = ArrayAdapter.createFromResource(this, R.array.trabalho, R.layout.spinner_item);
        spAdapterTrabalho.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTrabalho.setAdapter(spAdapterTrabalho);

        spOrientacao = (Spinner) findViewById(R.id.spinner_orientacao);
        ArrayAdapter spAdapterOrientacao = ArrayAdapter.createFromResource(this, R.array.orientacao, R.layout.spinner_item);
        spAdapterOrientacao.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spOrientacao.setAdapter(spAdapterOrientacao);

        spGenero = (Spinner) findViewById(R.id.spinner_identidade_genero);
        ArrayAdapter spAdapterGenero = ArrayAdapter.createFromResource(this, R.array.genero, R.layout.spinner_item);
        spAdapterGenero.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spGenero.setAdapter(spAdapterGenero);


    }



}
