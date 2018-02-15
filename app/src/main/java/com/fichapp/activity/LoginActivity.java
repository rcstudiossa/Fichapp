package com.fichapp.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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

    boolean doubleBackToExitPressedOnce = false;

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

        //this.carregarCombos();

        ((TextView) findViewById(R.id.tv_versao)).setText(Utilitario.getVersao());

    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            this.finishAffinity();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Clique novamente para fechar", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);

    }


    private void carregarCombos() {

        CNESBS cnesBS = new CNESBS(this);
        List<CNESModel> hospitais = cnesBS.pesquisarAtivos();
        hospitais.add(0, new CNESModel("Selecione o CNES"));
        ArrayAdapter<CNESModel> adapterHospital = new ArrayAdapter<>(this, R.layout.spinner_item_habilitado, hospitais);
        spinnerHospital.setAdapter(adapterHospital);
        adapterHospital.setDropDownViewResource(R.layout.spinner_dropdown_item);

    }

    private boolean validaCampos() {

        boolean valido = true;

        if (Utilitario.isEmpty(usuarioET.getText().toString())) {
            usuarioET.setError("Preencha o Usuário");
            valido = false;
        }

        if (Utilitario.isEmpty(senhaET.getText().toString())) {
            senhaET.setError("Preencha a senha");
            valido = false;
        }

        return valido;

    }

    private void entrarApp() {

        if (!validaCampos()) {
            return;
        }

        ProfissionalModel profissionalModel = new ProfissionalModel(usuarioET.getText().toString(), senhaET.getText().toString());
        profissionalModel.setFlagAdministrador(false);
        ProfissionalBS profissionalBS = new ProfissionalBS(this);

        profissionalModel = profissionalBS.obterProfissionalLogado(profissionalModel);

        if (!Utilitario.isEmpty(profissionalModel) && !Utilitario.isEmpty(profissionalModel.getId())) {

            atualizarUsuario(profissionalModel);

            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);

            finish();

        } else {
            Toast.makeText(getApplicationContext(), "Acesso negado!", Toast.LENGTH_LONG).show();
            this.senhaET.getText().clear();
        }
    }

    private void irAlterarSenha() {
        Intent intent = new Intent(LoginActivity.this, AlterarSenhaActivity.class);
        startActivity(intent);
    }

    private void atualizarUsuario(ProfissionalModel profissionalModel) {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        prefs.edit().putLong("id", profissionalModel.getId()).commit();
        prefs.edit().putString("nome", profissionalModel.getNome()).commit();
        if (!Utilitario.isEmpty(profissionalModel.getCbo().getCodigo())) {
            prefs.edit().putString("cbo", profissionalModel.getCbo().getCodigo().toString()).commit();
        }
        prefs.edit().putLong("cnes_id", profissionalModel.getCnesModel().getId()).commit();
        prefs.edit().putString("cnes", profissionalModel.getCnesModel().getCodigo()).commit();

    }

}
