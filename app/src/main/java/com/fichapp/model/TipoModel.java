package com.fichapp.model;

import com.fichapp.util.Utilitario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rodrigo Costa on 24/12/2017.
 */

public class TipoModel implements Serializable {

    private Integer codigo;
    private String descricao;

    public TipoModel() {

    }

    public TipoModel(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public TipoModel(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<TipoModel> getComboTipoImovel() {

        List<TipoModel> combo = new ArrayList<>();

        combo.add(new TipoModel(null, "Não respondido"));
        combo.add(new TipoModel(1, "Domicílio"));
        combo.add(new TipoModel(2, "Comércio"));
        combo.add(new TipoModel(3, "Terreno"));
        combo.add(new TipoModel(4, "Ponto"));
        combo.add(new TipoModel(5, "Escola"));
        combo.add(new TipoModel(6, "Creche"));
        combo.add(new TipoModel(7, "Abrigo"));
        combo.add(new TipoModel(8, "Instituição de longa permanência p/ idosos"));
        combo.add(new TipoModel(9, "Unidade prisional"));
        combo.add(new TipoModel(10, "Unidade de medida socioeducativa"));
        combo.add(new TipoModel(11, "Delegacia"));
        combo.add(new TipoModel(12, "Estabelecimento religioso"));
        combo.add(new TipoModel(99, "Outros"));

        return combo;

    }

    public List<TipoModel> getComboRendaFamiliar() {

        List<TipoModel> combo = new ArrayList<>();

        combo.add(new TipoModel(null, "Não respondido"));
        combo.add(new TipoModel(1, "1/4 sal. mínimo"));
        combo.add(new TipoModel(2, "1/2 sal. mínimo"));
        combo.add(new TipoModel(3, "01 sal. mínimo"));
        combo.add(new TipoModel(4, "02 sal. mínimos"));
        combo.add(new TipoModel(7, "03 sal. mínimos"));
        combo.add(new TipoModel(5, "04 sal. mínimos"));
        combo.add(new TipoModel(6, "Acima de 04 sal. mínimos"));

        return combo;

    }

    public List<TipoModel> getComboRaca() {

        List<TipoModel> combo = new ArrayList<>();

        combo.add(new TipoModel(null, "Não respondido"));
        combo.add(new TipoModel(1, "Branca"));
        combo.add(new TipoModel(2, "Preta"));
        combo.add(new TipoModel(3, "Parda"));
        combo.add(new TipoModel(4, "Amarela"));
        combo.add(new TipoModel(5, "Indígena"));
        combo.add(new TipoModel(6, "Sem informação"));

        return combo;

    }

    public List<TipoModel> getComboSituacaoMoradia() {

        List<TipoModel> combo = new ArrayList<>();

        combo.add(new TipoModel(null, "Não respondido"));
        combo.add(new TipoModel(75, "Próprio"));
        combo.add(new TipoModel(76, "Financiado"));
        combo.add(new TipoModel(77, "Alugado"));
        combo.add(new TipoModel(78, "Arrendado"));
        combo.add(new TipoModel(79, "Cedido"));
        combo.add(new TipoModel(80, "Ocupação"));
        combo.add(new TipoModel(81, "Situação de Rua"));
        combo.add(new TipoModel(82, "Outra"));

        return combo;

    }

    public List<TipoModel> getComboPosseTerra() {

        List<TipoModel> combo = new ArrayList<>();

        combo.add(new TipoModel(null, "Não respondido"));
        combo.add(new TipoModel(101, "Proprietário"));
        combo.add(new TipoModel(102, "Parceiro(a)/Meeiro(a)"));
        combo.add(new TipoModel(103, "Assentado(a)"));
        combo.add(new TipoModel(104, "Posseiro"));
        combo.add(new TipoModel(105, "Arrendatário(a)"));
        combo.add(new TipoModel(106, "Comodatário(a)"));
        combo.add(new TipoModel(107, "Beneficiário(a) do Banco da Terra"));
        combo.add(new TipoModel(108, "Não se aplica"));

        return combo;

    }

    public List<TipoModel> getComboParentesco() {

        List<TipoModel> combo = new ArrayList<>();

        combo.add(new TipoModel(null, "Não respondido"));
        combo.add(new TipoModel(137, "Cônjuge/Companheiro(a)"));
        combo.add(new TipoModel(138, "Filho(a)"));
        combo.add(new TipoModel(139, "Enteado(a)"));
        combo.add(new TipoModel(140, "Neto(a)/Bisneto(a)"));
        combo.add(new TipoModel(141, "Pai/Mãe(a)"));
        combo.add(new TipoModel(142, "Sogro(a)"));
        combo.add(new TipoModel(143, "Irmão/Irmã"));
        combo.add(new TipoModel(144, "Genro/Nora"));
        combo.add(new TipoModel(145, "Outro parente"));
        combo.add(new TipoModel(146, "Não parente"));

        return combo;

    }
    
    public List<TipoModel> getComboCurso() {

        List<TipoModel> combo = new ArrayList<>();

        combo.add(new TipoModel(null, "Não respondido"));
        combo.add(new TipoModel(51, "Creche"));
        combo.add(new TipoModel(52, "Pré-escola (exceto CA)"));
        combo.add(new TipoModel(53, "Classe de Alfabetização - CA"));
        combo.add(new TipoModel(54, "Ensino Fundamental 1ª a 4ª séries"));
        combo.add(new TipoModel(55, "Ensino Fundamental 5ª a 8ª séries"));
        combo.add(new TipoModel(56, "Ensino Fundamental Completo"));
        combo.add(new TipoModel(61, "Ensino Fundamental Especial"));
        combo.add(new TipoModel(58, "Ensino Fundamental EJA - (Supletivo 1ª a 4ª)"));
        combo.add(new TipoModel(59, "Ensino Fundamental EJA - (Supletivo 5ª a 8ª)"));
        combo.add(new TipoModel(60, "Ensino Médio, Médio 2º Ciclo (Científico, Técnico etc.)"));
        combo.add(new TipoModel(57, "Ensino Médio Especial"));
        combo.add(new TipoModel(62, "Ensino Fundamental EJA (Supletivo)"));
        combo.add(new TipoModel(63, "Superioi, Aperfeiçoamento, Especialização, Mestrado, Doutorado"));
        combo.add(new TipoModel(64, "Alfabetização para Adultos"));
        combo.add(new TipoModel(65, "Nenhum"));

        return combo;

    }

    public List<TipoModel> getComboTrabalho() {

        List<TipoModel> combo = new ArrayList<>();

        combo.add(new TipoModel(null, "Não respondido"));
        combo.add(new TipoModel(66, "Empregador"));
        combo.add(new TipoModel(67, "Assalariado com carteira de trabalho"));
        combo.add(new TipoModel(68, "Assalariado sem carteira de trabalho"));
        combo.add(new TipoModel(69, "Autônomo com previdência social"));
        combo.add(new TipoModel(70, "Autônomo sem previdência social"));
        combo.add(new TipoModel(71, "Aposentado/Pensionista"));
        combo.add(new TipoModel(72, "Desempregado"));
        combo.add(new TipoModel(73, "Não trabalha"));
        combo.add(new TipoModel(147, "Servidor público/militar"));
        combo.add(new TipoModel(74, "Outro"));

        return combo;

    }

    public List<TipoModel> getComboOrientacaoSexual() {

        List<TipoModel> combo = new ArrayList<>();

        combo.add(new TipoModel(null, "Não respondido"));
        combo.add(new TipoModel(148, "Heterossexual"));
        combo.add(new TipoModel(153, "Bissexual"));
        combo.add(new TipoModel(154, "Homossexual"));
        combo.add(new TipoModel(155, "Outra"));

        return combo;

    }

    public List<TipoModel> getComboGeneroSexual() {

        List<TipoModel> combo = new ArrayList<>();

        combo.add(new TipoModel(null, "Não respondido"));
        combo.add(new TipoModel(149, "Homem transexual"));
        combo.add(new TipoModel(150, "Mulher transexual"));
        combo.add(new TipoModel(156, "Travesti"));
        combo.add(new TipoModel(151, "Outro"));

        return combo;

    }

    public List<TipoModel> getComboMaterialParedes() {

        List<TipoModel> combo = new ArrayList<>();

        combo.add(new TipoModel(null, "Não respondido"));
        combo.add(new TipoModel(109, "Alvenaria com revestimento"));
        combo.add(new TipoModel(110, "Alvenaria sem revestimento"));
        combo.add(new TipoModel(111, "Taipa com revestimento"));
        combo.add(new TipoModel(112, "Taipa sem revestimento"));
        combo.add(new TipoModel(113, "Madeira emparelhada"));
        combo.add(new TipoModel(114, "Material aproveitado"));
        combo.add(new TipoModel(115, "Palha"));
        combo.add(new TipoModel(116, "Outro material"));

        return combo;

    }

    public List<TipoModel> getComboAbastecimentoAgua() {

        List<TipoModel> combo = new ArrayList<>();

        combo.add(new TipoModel(null, "Não respondido"));
        combo.add(new TipoModel(117, "Rede encanada até o domicílio"));
        combo.add(new TipoModel(118, "Poço/Nascente no domicílio"));
        combo.add(new TipoModel(119, "Cisterna"));
        combo.add(new TipoModel(120, "Carro pipa"));
        combo.add(new TipoModel(121, "Outro"));

        return combo;

    }

    public List<TipoModel> getComboAguaConsumo() {

        List<TipoModel> combo = new ArrayList<>();

        combo.add(new TipoModel(null, "Não respondido"));
        combo.add(new TipoModel(97, "Filtrada"));
        combo.add(new TipoModel(98, "Fervida"));
        combo.add(new TipoModel(99, "Clorada"));
        combo.add(new TipoModel(152, "Mineral"));
        combo.add(new TipoModel(100, "Sem tratamento"));

        return combo;

    }

    public List<TipoModel> getComboEscoamentoBanheiro() {

        List<TipoModel> combo = new ArrayList<>();

        combo.add(new TipoModel(null, "Não respondido"));
        combo.add(new TipoModel(122, "Rede coletora de esgoto/pluvial"));
        combo.add(new TipoModel(123, "Fossa séptica"));
        combo.add(new TipoModel(124, "Fossa rudimentar"));
        combo.add(new TipoModel(125, "Direto para um rio/lago/mar"));
        combo.add(new TipoModel(126, "Céu aberto"));
        combo.add(new TipoModel(127, "Outra forma"));

        return combo;

    }

    public List<TipoModel> getComboDestinoLixo() {

        List<TipoModel> combo = new ArrayList<>();

        combo.add(new TipoModel(null, "Não respondido"));
        combo.add(new TipoModel(93, "Coletado"));
        combo.add(new TipoModel(94, "Queimado/Enterrado"));
        combo.add(new TipoModel(95, "Céu aberto"));
        combo.add(new TipoModel(96, "Outro"));
        return combo;

    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        if (!Utilitario.isEmpty(this.codigo)) {
            sb.append(codigo).append(": ");
        }

        sb.append(this.descricao);

        return sb.toString();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoModel tipoModel = (TipoModel) o;

        return codigo != null ? codigo.equals(tipoModel.codigo) : tipoModel.codigo == null;

    }

    @Override
    public int hashCode() {
        return codigo != null ? codigo.hashCode() : 0;
    }
}

