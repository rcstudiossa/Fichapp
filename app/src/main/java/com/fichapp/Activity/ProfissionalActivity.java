package com.fichapp.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;

import com.fichapp.Model.ProfissionalModel;
import com.fichapp.Model.ProfissionalModel;
import com.fichapp.R;
import com.fichapp.business.ProfissionalBS;

public class ProfissionalActivity extends AppCompatActivity {

    private ProfissionalModel profissionalModel;
    private ProfissionalBS profissionalBS;

    private AutoCompleteTextView mCbo;
    private AutoCompleteTextView mCns;
    private AutoCompleteTextView mNome;
    private CheckBox mFlagAtivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profissional);

        Button btnGravar = (Button) findViewById(R.id.btnGravar);
        mCbo = (AutoCompleteTextView) findViewById(R.id.cbo);
        mCns = (AutoCompleteTextView) findViewById(R.id.cns);
        mNome = (AutoCompleteTextView) findViewById(R.id.nome);
        mFlagAtivo = (CheckBox) findViewById(R.id.flag_ativo);

        this.profissionalBS = new ProfissionalBS(getApplicationContext());

        this.instanciarProfissionalModel();

        btnGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gravar();
            }
        });
        
    }

    private void instanciarProfissionalModel() {

        this.profissionalModel = (ProfissionalModel) getIntent().getSerializableExtra("profissional");

        if (this.profissionalModel == null) {
            this.profissionalModel = new ProfissionalModel();
            mFlagAtivo.setChecked(Boolean.TRUE);
        } else {
            mCbo.setText(this.profissionalModel.getCbo());
            mCns.setText(this.profissionalModel.getCns());
            mNome.setText(this.profissionalModel.getNome());
            mFlagAtivo.setChecked(this.profissionalModel.getFlagAtivo());
        }

    }

    private void gravar() {

        this.profissionalModel.setCbo(mCbo.getText().toString());
        this.profissionalModel.setCns(mCns.getText().toString());
        this.profissionalModel.setNome(mNome.getText().toString());
        this.profissionalModel.setFlagAtivo(mFlagAtivo.isChecked());

        profissionalBS.gravar(this.profissionalModel);

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("fragment", "ProfissionalFragment");
        startActivity(intent);


    }
}
