package com.fichapp.activity;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.fichapp.R;
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

    private boolean validaCampos() {

        Boolean valido = true;
        String aviso = "";

        if (Utilitario.isEmpty(etUsuario.getText().toString())) {
            aviso = Utilitario.addAviso("Preencha o campo de usuário.", aviso);
            valido = false;
        } if (Utilitario.isEmpty(etSenhaAtual.getText().toString())) {
            aviso = Utilitario.addAviso("Preencha a senha .", aviso);
            valido = false;
        }

        if (!aviso.isEmpty()) {
            Utilitario.alertar(AlterarSenhaActivity.this, aviso);
        }

        return valido;

    }

    private void alterarSenha() {

        if (!validaCampos()) {
            return;
        }

    }

}
