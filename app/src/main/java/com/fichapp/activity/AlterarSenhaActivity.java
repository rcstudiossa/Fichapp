package com.fichapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fichapp.R;
import com.fichapp.business.ProfissionalBS;
import com.fichapp.model.ProfissionalModel;
import com.fichapp.util.Utilitario;

public class AlterarSenhaActivity extends AppCompatActivity {

    private EditText etUsuario;
    private EditText etSenhaAtual;
    private EditText etNovaSenha;
    private EditText etConfirmarSenha;
    private Button btAlterarSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_senha);

        this.definirComponentes();

        this.btAlterarSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alterarSenha();
            }
        });

    }

    private void definirComponentes() {

        etUsuario = (EditText) findViewById(R.id.et_usuario);
        etSenhaAtual = (EditText) findViewById(R.id.et_senha_atual);
        etNovaSenha = (EditText) findViewById(R.id.et_nova_senha);
        etConfirmarSenha = (EditText) findViewById(R.id.et_confirmar_senha);
        btAlterarSenha = (Button) findViewById(R.id.bt_alterar_senha);

    }

    /*private class validaWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            validaCampos();
        }
    } */

    private boolean validaCampos() {

        boolean campoValido = true;

        if (Utilitario.isEmpty(etUsuario.getText().toString())) {
            Utilitario.enviarMsgErro(etUsuario, "Preencha o usuário.");
            campoValido = false;
        }

        if (Utilitario.isEmpty(etSenhaAtual.getText().toString())) {
            Utilitario.enviarMsgErro(etSenhaAtual, "Preencha a senha atual.");
            campoValido = false;
        }

        if (Utilitario.isEmpty(etNovaSenha.getText().toString())) {
            Utilitario.enviarMsgErro(etNovaSenha, "Preencha nova senha.");
            campoValido = false;
        }

        if (Utilitario.isEmpty(etConfirmarSenha.getText().toString())) {
            Utilitario.enviarMsgErro(etConfirmarSenha, "Confirme a nova senha.");
            campoValido = false;
        }

        if ((!Utilitario.isEmpty(etNovaSenha.getText().toString())) && (!Utilitario.isEmpty(etConfirmarSenha.getText().toString())) && (!etNovaSenha.getText().toString().equals(etConfirmarSenha.getText().toString()))) {
            Utilitario.enviarMsgErro(etConfirmarSenha, "A confirmação da senha não coincide");
            campoValido = false;
        } else {

            if ((!Utilitario.isEmpty(etSenhaAtual.getText().toString())) && (!Utilitario.isEmpty(etNovaSenha.getText().toString())) && (etNovaSenha.getText().toString().equals(etSenhaAtual.getText().toString()))) {
                Utilitario.enviarMsgErro(etNovaSenha, "É necessário que a nova senha seja diferente da atual.");
                campoValido = false;
            }
        }

        return campoValido;

    }

    private void alterarSenha() {

        if (!validaCampos()) {
            return;
        }

        ProfissionalBS profissionalBS = new ProfissionalBS(this);
        ProfissionalModel profissionalModel = profissionalBS.obterProfissionalLogado(new ProfissionalModel(etUsuario.getText().toString(), etSenhaAtual.getText().toString(), Boolean.FALSE));

        if (Utilitario.isEmpty(profissionalModel) || Utilitario.isEmpty(profissionalModel.getId())) {
            Utilitario.enviarMsgErro(etUsuario, "Usuário ou senha atual incorretos.");
        } else {
            profissionalBS.alterarSenha(new ProfissionalModel(profissionalModel.getId(), etNovaSenha.getText().toString()));
            Utilitario.avisoSucesso(this);
            Intent intent = new Intent(AlterarSenhaActivity.this, LoginActivity.class);
            startActivity(intent);
        }

    }

}
