package com.fichapp.business;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.fichapp.dao.FichaCadastroDTFamiliasDAO;
import com.fichapp.dao.SMPEPDbHelper;
import com.fichapp.model.FamiliaModel;
import com.fichapp.model.FichaCadastroDTModel;
import com.fichapp.model.OrigemModel;
import com.fichapp.model.integracao.FichaCadastroDomiciliarTerritorialEsusModel;
import com.fichapp.model.integracao.FichaCondicaoMoradiaEsusModel;
import com.fichapp.model.integracao.FichaEnderecoLocalPermanenciaEsusModel;
import com.fichapp.model.integracao.FichaFamiliaRowEsusModel;
import com.fichapp.util.Utilitario;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Rodrigo Costa on 11/12/2017.
 */

public class FichaCadastroDTFamiliasBS {

    FichaCadastroDTFamiliasDAO fichaCadastroDTFamiliasDAO;

    public FichaCadastroDTFamiliasBS() {
    }

    public FichaCadastroDTFamiliasBS(Context context) {
        SMPEPDbHelper smpepDbHelper = new SMPEPDbHelper(context);
        fichaCadastroDTFamiliasDAO = new FichaCadastroDTFamiliasDAO(smpepDbHelper);
    }

    public void gravar(SQLiteDatabase db, List<FamiliaModel> familias) {

        for (FamiliaModel familiaModel: familias) {

            this.gravar(db, familiaModel);

        }

    }

    public void gravar(SQLiteDatabase db, FamiliaModel familiaModel) {

        if (familiaModel.getId() != null && familiaModel.getId() > 0) {
            fichaCadastroDTFamiliasDAO.alterar(db, familiaModel);
        } else {
            fichaCadastroDTFamiliasDAO.inserir(db, familiaModel);
        }

    }

    public void excluir(FamiliaModel familiaModel) {
        fichaCadastroDTFamiliasDAO.excluir(familiaModel);
    }

    public FamiliaModel obter(FamiliaModel FamiliaModel) {
        return this.fichaCadastroDTFamiliasDAO.obter(FamiliaModel);
    }

    public List<FamiliaModel> pesquisar(FichaCadastroDTModel fichaCadastroDTModel) {
        return this.fichaCadastroDTFamiliasDAO.pesquisar(fichaCadastroDTModel);
    }

    public String getJSONObject(FichaCadastroDTModel ficha) {

        FichaCadastroDomiciliarTerritorialEsusModel fichaCadastroDomiciliarTerritorialEsusModel = new FichaCadastroDomiciliarTerritorialEsusModel();
        fichaCadastroDomiciliarTerritorialEsusModel.setOrigemModel(new OrigemModel(25L));
        fichaCadastroDomiciliarTerritorialEsusModel.setFlagStatusTermoRecusa(ficha.getFlagRecusado());
        fichaCadastroDomiciliarTerritorialEsusModel.setTipoDeImovel(!Utilitario.isEmpty(ficha.getTipoImovel().getCodigo()) ? ficha.getTipoImovel().getCodigo().longValue() : null);
        fichaCadastroDomiciliarTerritorialEsusModel.setAnimaisNoDomicilio(ficha.getAnimais());
        fichaCadastroDomiciliarTerritorialEsusModel.setQuantosAnimaisNoDomicilio(!Utilitario.isEmpty(ficha.getQtdAnimais()) ? ficha.getQtdAnimais().toString() : null);

        FichaEnderecoLocalPermanenciaEsusModel endereco = new FichaEnderecoLocalPermanenciaEsusModel();
        endereco.setCep(ficha.getCep());
        endereco.setNumeroDneUf(!Utilitario.isEmpty(ficha.getUf().getCodigo()) ? ficha.getUf().getCodigo().toString() : null);
        endereco.setCodigoIbgeMunicipio(!Utilitario.isEmpty(ficha.getMunicipio().getCodigo()) ? ficha.getMunicipio().getCodigo().toString() : null);
        endereco.setBairro(ficha.getBairro());
        endereco.setTipoLogradouroNumeroDne(!Utilitario.isEmpty(ficha.getTipoLogradouro().getCodigo()) ? ficha.getTipoLogradouro().getCodigo().toString() : null);
        endereco.setNomeLogradouro(ficha.getNomeLogragouro());
        endereco.setComplemento(ficha.getComplemento());
        endereco.setPontoReferencia(ficha.getPontoReferencia());
        endereco.setNumero(ficha.getNumero());
        endereco.setFlagSemNumero(ficha.getFlagSemNumero());
        endereco.setMicroArea(ficha.getMicroArea());
        endereco.setTelefoneResidencia(ficha.getTelResidencia());
        endereco.setTelefoneContato(ficha.getTelContato());
        fichaCadastroDomiciliarTerritorialEsusModel.setEnderecoLocalPermanencia(endereco);

        FichaCondicaoMoradiaEsusModel condicoesMoradia = new FichaCondicaoMoradiaEsusModel();
        condicoesMoradia.setSituacaoMoradiaPosseTerra(!Utilitario.isEmpty(ficha.getSituacaoMoradia().getCodigo()) ? ficha.getSituacaoMoradia().getCodigo().longValue() : null);
        condicoesMoradia.setLocalizacao(!Utilitario.isEmpty(ficha.getLocalizacao()) ? ficha.getLocalizacao().longValue() : null);
        condicoesMoradia.setTipoDomicilio(!Utilitario.isEmpty(ficha.getTipoDomicilio()) ? ficha.getTipoDomicilio().longValue() : null);
        condicoesMoradia.setTipoAcessoDomicilio(!Utilitario.isEmpty(ficha.getAcessoDomicilio()) ? ficha.getAcessoDomicilio().longValue() : null);
        condicoesMoradia.setNuMoradores(ficha.getNumMoradores().toString());
        condicoesMoradia.setNuComodos(ficha.getNumComodos().toString());
        condicoesMoradia.setMaterialPredominanteParedesExtDomicilio(!Utilitario.isEmpty(ficha.getMaterialParedes().getCodigo()) ? ficha.getMaterialParedes().getCodigo().longValue() : null);
        condicoesMoradia.setFlagDisponibilidadeEnergiaEletrica(ficha.getFlagEnergiaEletrica() == 0);
        condicoesMoradia.setAbastecimentoAgua(!Utilitario.isEmpty(ficha.getAbastecimentoAgua().getCodigo()) ? ficha.getAbastecimentoAgua().getCodigo().longValue() : null);
        condicoesMoradia.setAguaConsumoDomicilio(!Utilitario.isEmpty(ficha.getAguaConsumo().getCodigo()) ? ficha.getAguaConsumo().getCodigo().longValue() : null);
        condicoesMoradia.setFormaEscoamentoBanheiro(!Utilitario.isEmpty(ficha.getEscoamentoBanheiro().getCodigo()) ? ficha.getEscoamentoBanheiro().getCodigo().longValue() : null);
        condicoesMoradia.setDestinoLixo(!Utilitario.isEmpty(ficha.getDestinoLixo().getCodigo()) ? ficha.getDestinoLixo().getCodigo().longValue() : null);
        fichaCadastroDomiciliarTerritorialEsusModel.setCondicaoMoradia(condicoesMoradia);

        fichaCadastroDomiciliarTerritorialEsusModel.setFamilias(new ArrayList<FichaFamiliaRowEsusModel>());

        for (FamiliaModel familia: ficha.getFamilias()) {

            FichaFamiliaRowEsusModel fichaFamilia = new FichaFamiliaRowEsusModel();
            fichaFamilia.setNumeroProntuario(familia.getProntuario());
            fichaFamilia.setNumeroCnsResponsavel(familia.getCnsResponsavel());
            fichaFamilia.setDataNascimentoResponsavel(familia.getDataNascimentoResponsavel());
            fichaFamilia.setRendaFamiliar(!Utilitario.isEmpty(familia.getRendaFamiliar().getCodigo()) ? familia.getRendaFamiliar().getCodigo().longValue() : null);
            if (!Utilitario.isEmpty(familia.getResideAno()) && !Utilitario.isEmpty(familia.getResideMes())) {
                Calendar c = new GregorianCalendar(familia.getResideAno(), familia.getResideMes(), 1);
                fichaFamilia.setDataInicioReside(c.getTime());
            }
            fichaFamilia.setNumeroMembrosFamilia(familia.getNumeroMembros());
            fichaFamilia.setFlagMudanca(familia.getFlagMudou());

            fichaCadastroDomiciliarTerritorialEsusModel.getFamilias().add(fichaFamilia);

        }

        Gson gson = new Gson();
        String json = gson.toJson(fichaCadastroDomiciliarTerritorialEsusModel);

        return json;

    }


}
