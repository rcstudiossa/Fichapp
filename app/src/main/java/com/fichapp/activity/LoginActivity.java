package com.fichapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.fichapp.AlterarSenhaActivity;
import com.fichapp.R;
import com.fichapp.business.CNESBS;
import com.fichapp.business.ProfissionalBS;
import com.fichapp.model.CNESModel;
import com.fichapp.model.ProfissionalModel;
import com.fichapp.util.Utilitario;

import java.util.List;

/**
 * Created by Rodrigo Costa on 25/12/2017.
 */

public class LoginActivity extends AppCompatActivity {

    private EditText usuarioET;
    private EditText senhaET;
    private Button loginBT;
    private TextView alterarSenhaTV;
    private Spinner spinnerHospital;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        usuarioET = (EditText) findViewById(R.id.ed_usuario);
        senhaET = (EditText) findViewById(R.id.ed_senha);

        loginBT = (Button) findViewById(R.id.bt_login);
        loginBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entrarApp();
            }
        });

        alterarSenhaTV = (TextView) findViewById(R.id.tv_alterar_senha);
        alterarSenhaTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irAlterarSenha();
            }
        });

        spinnerHospital = (Spinner) findViewById(R.id.spinner_hospital);

        this.carregarCombos();

    }

    private void carregarCombos() {

        CNESBS cnesBS = new CNESBS(this);
        List<CNESModel> hospitais = cnesBS.pesquisarAtivos();
        hospitais.add(0, new CNESModel("Selecione o CNES"));
        ArrayAdapter<CNESModel> adapterHospital = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, hospitais);
        spinnerHospital.setAdapter(adapterHospital);

    }

    private boolean validaCampos() {

        boolean valido = true;

        String aviso = "";

        if (Utilitario.isEmpty(usuarioET.getText().toString())) {
            aviso = Utilitario.addAviso("Preencha o usuário", aviso);
            valido = false;
        }

        if (Utilitario.isEmpty(senhaET.getText().toString())) {
            aviso = Utilitario.addAviso("Preencha a senha", aviso);
            valido = false;
        }

        if (!Utilitario.isEmpty(aviso)) {
            Snackbar.make(getCurrentFocus(), aviso, Snackbar.LENGTH_LONG).show();
        }

        return valido;

    }

    private void entrarApp() {

        if (!validaCampos()) {
            return;
        }

        ProfissionalModel profissionalModel = new ProfissionalModel(usuarioET.getText().toString(), senhaET.getText().toString());
        ProfissionalBS profissionalBS = new ProfissionalBS(this);

        profissionalModel = profissionalBS.obterProfissionalLogado(profissionalModel, (CNESModel) spinnerHospital.getSelectedItem());

        if (!Utilitario.isEmpty(profissionalModel) && !Utilitario.isEmpty(profissionalModel.getId())) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("profissional", profissionalModel);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Acesso negado!", Toast.LENGTH_LONG).show();
        }
    }

    private void irAlterarSenha() {
        Intent intent = new Intent(LoginActivity.this, AlterarSenhaActivity.class);
        startActivity(intent);
    }

}
