package com.fichapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;

import com.fichapp.R;

public class AlterarSenhaActivity extends AppCompatActivity {

    private EditText usuarioET;
    private EditText senhaAtualET;
    private EditText novaSenhaET;
    private EditText confirmarSenhaET;
    private Button alterarSenhaBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_senha);

        usuarioET = (EditText) findViewById(R.id.et_usuario);
        senhaAtualET = (EditText) findViewById(R.id.et_senha_atual);
        novaSenhaET = (EditText) findViewById(R.id.et_nova_senha);
        confirmarSenhaET = (EditText) findViewById(R.id.et_confirmar_senha);
        alterarSenhaBT = (Button) findViewById(R.id.bt_alterar_senha);

    }


}
