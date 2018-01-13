package com.fichapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.fichapp.R;

public class FichaCadastroDTActivity extends AppCompatActivity {

    private Spinner spTipoImovel;
    private Spinner spSituacaoMoradia;
    private Spinner spCondicaoPosseTerra;
    private Spinner spNumMoradores;
    private Spinner spNumComodos;
    private Spinner spMaterialParedes;
    private Spinner spAbastecimentoAgua;
    private Spinner spAguaConsumo;
    private Spinner spEscoamentoBanheiro;
    private Spinner spDestinoLixo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha_cadastro_dt);

        spTipoImovel = (Spinner) findViewById(R.id.spinner_tipo_imovel);
        ArrayAdapter spAdapterTipoImovel = ArrayAdapter.createFromResource(this, R.array.tipo_imovel, R.layout.spinner_item);
        spAdapterTipoImovel.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTipoImovel.setAdapter(spAdapterTipoImovel);

        spSituacaoMoradia = (Spinner) findViewById(R.id.spinner_situacao_moradia);
        ArrayAdapter spAdapterSituacaoMoradia = ArrayAdapter.createFromResource(this, R.array.situacao_moradia, R.layout.spinner_item);
        spAdapterSituacaoMoradia.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSituacaoMoradia.setAdapter(spAdapterSituacaoMoradia);

        spCondicaoPosseTerra = (Spinner) findViewById(R.id.spinner_condicao_posse_terra);
        ArrayAdapter spAdapterPosseTerra = ArrayAdapter.createFromResource(this, R.array.posse_terra, R.layout.spinner_item);
        spAdapterPosseTerra.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCondicaoPosseTerra.setAdapter(spAdapterPosseTerra);

        spNumMoradores = (Spinner) findViewById(R.id.spinner_numero_moradores);
        ArrayAdapter spAdapterNumMoradores = ArrayAdapter.createFromResource(this, R.array.numeros, R.layout.spinner_item);
        spAdapterNumMoradores.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spNumMoradores.setAdapter(spAdapterNumMoradores);

        spNumComodos = (Spinner) findViewById(R.id.spinner_numero_comodos);
        ArrayAdapter spAdapterNumComodos = ArrayAdapter.createFromResource(this, R.array.numeros, R.layout.spinner_item);
        spAdapterNumComodos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spNumComodos.setAdapter(spAdapterNumComodos);

        spMaterialParedes = (Spinner) findViewById(R.id.spinner_material_paredes);
        ArrayAdapter spAdapterMaterialParedes = ArrayAdapter.createFromResource(this, R.array.material_paredes, R.layout.spinner_item);
        spAdapterMaterialParedes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spMaterialParedes.setAdapter(spAdapterMaterialParedes);

        spAbastecimentoAgua = (Spinner) findViewById(R.id.spinner_abastecimento_agua);
        ArrayAdapter spAdapterAbastecimentoAgua = ArrayAdapter.createFromResource(this, R.array.abastecimento_agua, R.layout.spinner_item);
        spAdapterAbastecimentoAgua.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spAbastecimentoAgua.setAdapter(spAdapterAbastecimentoAgua);

        spAguaConsumo = (Spinner) findViewById(R.id.spinner_agua_consumo);
        ArrayAdapter spAdapterAguaConsumo = ArrayAdapter.createFromResource(this, R.array.agua_consumo, R.layout.spinner_item);
        spAdapterAguaConsumo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spAguaConsumo.setAdapter(spAdapterAguaConsumo);

        spEscoamentoBanheiro = (Spinner) findViewById(R.id.spinner_escoamento_banheiro);
        ArrayAdapter spAdapterEscoamentoBanheiro = ArrayAdapter.createFromResource(this, R.array.escoamento_banheiro, R.layout.spinner_item);
        spAdapterEscoamentoBanheiro.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spEscoamentoBanheiro.setAdapter(spAdapterEscoamentoBanheiro);

        spDestinoLixo = (Spinner) findViewById(R.id.spinner_destino_lixo);
        ArrayAdapter spAdapterDestinoLixo = ArrayAdapter.createFromResource(this, R.array.destino_lixo, R.layout.spinner_item);
        spAdapterDestinoLixo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDestinoLixo.setAdapter(spAdapterDestinoLixo);


    }



}
