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
    private String abreviacao;

    public TipoModel() {

    }

    public TipoModel(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public TipoModel(Integer codigo, String descricao, String abreviacao) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.abreviacao = abreviacao;
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

    public String getAbreviacao() {
        return abreviacao;
    }

    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
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

    public List<TipoModel> getComboUF() {

        List<TipoModel> combo = new ArrayList<>();

        combo.add(new TipoModel(null, "Não respondido"));
        combo.add(new TipoModel(1,"ACRE", "AC"));
        combo.add(new TipoModel(2,"ALAGOAS", "AL"));
        combo.add(new TipoModel(3,"AMAPÁ", "AP"));
        combo.add(new TipoModel(4,"AMAZONAS", "AM"));
        combo.add(new TipoModel(5,"BAHIA", "BA"));
        combo.add(new TipoModel(6,"CEARÁ", "CE"));
        combo.add(new TipoModel(7,"DISTRITO FEDERAL", "DF"));
        combo.add(new TipoModel(8,"ESPÍRITO SANTO", "ES"));
        combo.add(new TipoModel(10,"GOIÁS", "GO"));
        combo.add(new TipoModel(11,"MARANHÃO", "MA"));
        combo.add(new TipoModel(12,"MATO GROSSO", "MT"));
        combo.add(new TipoModel(13,"MATO GROSSO DO SUL", "MS"));
        combo.add(new TipoModel(14,"MINAS GERAIS", "MG"));
        combo.add(new TipoModel(15,"PARÁ", "PA"));
        combo.add(new TipoModel(16,"PARAÍBA", "PB"));
        combo.add(new TipoModel(17,"PARANÁ", "PN"));
        combo.add(new TipoModel(18,"PERNAMBUCO", "PE"));
        combo.add(new TipoModel(19,"PIAUÍ", "PI"));
        combo.add(new TipoModel(20,"RIO DE JANEIRO", "RJ"));
        combo.add(new TipoModel(21,"RIO GRANDE DO NORTE", "RN"));
        combo.add(new TipoModel(22,"RIO GRANDE DO SUL", "RS"));
        combo.add(new TipoModel(23,"RONDÔNIA", "RO"));
        combo.add(new TipoModel(9,"RORAIMA", "RR"));
        combo.add(new TipoModel(25,"SANTA CATARINA", "SC"));
        combo.add(new TipoModel(26,"SÃO PAULO", "SP"));
        combo.add(new TipoModel(27,"SERGIPE", "SE"));
        combo.add(new TipoModel(24,"TOCANTINS", "TO"));

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

    public List<TipoModel> getComboPais() {

        List<TipoModel> combo = new ArrayList<>();

        combo.add(new TipoModel(1,"AFEGANISTÃO"));
        combo.add(new TipoModel(2,"ÁFRICA DO SUL"));
        combo.add(new TipoModel(3,"ALBÂNIA"));
        combo.add(new TipoModel(4,"ALEMANHA"));
        combo.add(new TipoModel(5,"ANDORRA"));
        combo.add(new TipoModel(6,"ANGOLA"));
        combo.add(new TipoModel(7,"ANGUILLA"));
        combo.add(new TipoModel(8,"ANTÁRCTICA"));
        combo.add(new TipoModel(9,"ANTIGUA E BARBUDA"));
        combo.add(new TipoModel(10,"ANTILHAS HOLANDESAS"));
        combo.add(new TipoModel(11,"ARÁBIA SAUDITA"));
        combo.add(new TipoModel(12,"ARGÉLIA"));
        combo.add(new TipoModel(13,"ARGENTINA"));
        combo.add(new TipoModel(14,"ARMÊNIA"));
        combo.add(new TipoModel(15,"ARUBA"));
        combo.add(new TipoModel(16,"AUSTRÁLIA"));
        combo.add(new TipoModel(17,"ÁUSTRIA"));
        combo.add(new TipoModel(18,"AZERBAIDJÃO"));
        combo.add(new TipoModel(19,"BAHAMAS"));
        combo.add(new TipoModel(20,"BANGLADESH"));
        combo.add(new TipoModel(21,"BARBADOS"));
        combo.add(new TipoModel(22,"BAREIN"));
        combo.add(new TipoModel(23,"BELARUS"));
        combo.add(new TipoModel(24,"BÉLGICA"));
        combo.add(new TipoModel(25,"BELIZE"));
        combo.add(new TipoModel(26,"BENIN"));
        combo.add(new TipoModel(27,"BERMUDA"));
        combo.add(new TipoModel(28,"BOLÍVIA"));
        combo.add(new TipoModel(29,"BÓSNIA E HERZEGÓVINA"));
        combo.add(new TipoModel(30,"BOTSWANA"));
        combo.add(new TipoModel(31,"BRASIL"));
        combo.add(new TipoModel(32,"BRUNEI"));
        combo.add(new TipoModel(33,"BULGÁRIA"));
        combo.add(new TipoModel(34,"BURKINA FASSO"));
        combo.add(new TipoModel(35,"BURUNDI"));
        combo.add(new TipoModel(36,"BUTÃO"));
        combo.add(new TipoModel(37,"CABO VERDE"));
        combo.add(new TipoModel(38,"CAMARÕES"));
        combo.add(new TipoModel(39,"CAMBOJA"));
        combo.add(new TipoModel(40,"CANADÁ"));
        combo.add(new TipoModel(41,"CATAR"));
        combo.add(new TipoModel(42,"CAZAQUISTÃO"));
        combo.add(new TipoModel(43,"CHADE"));
        combo.add(new TipoModel(44,"CHILE"));
        combo.add(new TipoModel(45,"CHINA"));
        combo.add(new TipoModel(46,"CHIPRE"));
        combo.add(new TipoModel(47,"CINGAPURA"));
        combo.add(new TipoModel(48,"COLÔMBIA"));
        combo.add(new TipoModel(49,"COMORES"));
        combo.add(new TipoModel(50,"CONGO"));
        combo.add(new TipoModel(51,"CORÉIA DO NORTE"));
        combo.add(new TipoModel(52,"CORÉIA DO SUL"));
        combo.add(new TipoModel(53,"COSTA DO MARFIM"));
        combo.add(new TipoModel(54,"COSTA RICA"));
        combo.add(new TipoModel(55,"CROÁCIA"));
        combo.add(new TipoModel(56,"CUBA"));
        combo.add(new TipoModel(57,"DINAMARCA"));
        combo.add(new TipoModel(58,"DJIBUTI"));
        combo.add(new TipoModel(59,"DOMINICA"));
        combo.add(new TipoModel(60,"EGITO"));
        combo.add(new TipoModel(61,"EL SALVADOR"));
        combo.add(new TipoModel(62,"EMIRADOS ÁRABES UNIDOS"));
        combo.add(new TipoModel(63,"EQUADOR"));
        combo.add(new TipoModel(64,"ERITRÉIA"));
        combo.add(new TipoModel(65,"ESLOVÁQUIA"));
        combo.add(new TipoModel(66,"ESLOVÊNIA"));
        combo.add(new TipoModel(67,"ESPANHA"));
        combo.add(new TipoModel(68,"ESTADOS UNIDOS"));
        combo.add(new TipoModel(69,"ESTÔNIA"));
        combo.add(new TipoModel(70,"ETIÓPIA"));
        combo.add(new TipoModel(71,"FEDERAÇÃO RUSSA"));
        combo.add(new TipoModel(72,"FIJI"));
        combo.add(new TipoModel(73,"FILIPINAS"));
        combo.add(new TipoModel(74,"FINLÂNDIA"));
        combo.add(new TipoModel(75,"FRANÇA"));
        combo.add(new TipoModel(76,"FRANÇA METROPOLITANA"));
        combo.add(new TipoModel(77,"GABÃO"));
        combo.add(new TipoModel(78,"GÂMBIA"));
        combo.add(new TipoModel(79,"GANA"));
        combo.add(new TipoModel(80,"GEÓRGIA"));
        combo.add(new TipoModel(81,"GIBRALTAR"));
        combo.add(new TipoModel(82,"GRÃ-BRETANHA"));
        combo.add(new TipoModel(83,"GRANADA"));
        combo.add(new TipoModel(84,"GRÉCIA"));
        combo.add(new TipoModel(85,"GROENLÂNDIA"));
        combo.add(new TipoModel(86,"GUADALUPE"));
        combo.add(new TipoModel(87,"GUAM"));
        combo.add(new TipoModel(88,"GUATEMALA"));
        combo.add(new TipoModel(89,"GUIANA"));
        combo.add(new TipoModel(90,"GUIANA FRANCESA"));
        combo.add(new TipoModel(91,"GUINÉ"));
        combo.add(new TipoModel(92,"GUINÉ EQUATORIAL"));
        combo.add(new TipoModel(93,"GUINÉ-BISSAU"));
        combo.add(new TipoModel(94,"HAITI"));
        combo.add(new TipoModel(95,"HOLANDA"));
        combo.add(new TipoModel(96,"HONDURAS"));
        combo.add(new TipoModel(97,"HONG KONG"));
        combo.add(new TipoModel(98,"HUNGRIA"));
        combo.add(new TipoModel(99,"IÊMEN"));
        combo.add(new TipoModel(100,"ILHA BOUVET"));
        combo.add(new TipoModel(101,"ILHA CHRISTMAS"));
        combo.add(new TipoModel(102,"ILHA NORFOLK"));
        combo.add(new TipoModel(103,"ILHAS CAYMAN"));
        combo.add(new TipoModel(104,"ILHAS COCOS"));
        combo.add(new TipoModel(105,"ILHAS COOK"));
        combo.add(new TipoModel(106,"ILHAS DE GUERNSEY"));
        combo.add(new TipoModel(107,"ILHAS DE JERSEY"));
        combo.add(new TipoModel(108,"ILHAS FAROE"));
        combo.add(new TipoModel(109,"ILHAS GEÓRGIA DO SUL E ILHAS SANDWICH DO SUL"));
        combo.add(new TipoModel(110,"ILHAS HEARD E MAC DONALD"));
        combo.add(new TipoModel(111,"ILHAS MALVINAS"));
        combo.add(new TipoModel(112,"ILHAS MARIANA"));
        combo.add(new TipoModel(113,"ILHAS MARSHALL"));
        combo.add(new TipoModel(114,"ILHAS PITCAIRN"));
        combo.add(new TipoModel(115,"ILHAS REUNIÃO"));
        combo.add(new TipoModel(116,"ILHAS SALOMÃO"));
        combo.add(new TipoModel(117,"ILHAS SANTA HELENA"));
        combo.add(new TipoModel(118,"ILHAS SVALBARD E JAN MAYEN"));
        combo.add(new TipoModel(119,"ILHAS TOKELAU"));
        combo.add(new TipoModel(120,"ILHAS TURKS E CAICOS"));
        combo.add(new TipoModel(121,"ILHAS VIRGENS"));
        combo.add(new TipoModel(122,"ILHAS VIRGENS BRITÂNICAS"));
        combo.add(new TipoModel(123,"ILHAS WALLIS E FUTUNA"));
        combo.add(new TipoModel(124,"ÍNDIA"));
        combo.add(new TipoModel(125,"INDONÉSIA"));
        combo.add(new TipoModel(126,"IRÃ"));
        combo.add(new TipoModel(127,"IRAQUE"));
        combo.add(new TipoModel(128,"IRLANDA"));
        combo.add(new TipoModel(129,"ISLÂNDIA"));
        combo.add(new TipoModel(130,"ISRAEL"));
        combo.add(new TipoModel(131,"ITÁLIA"));
        combo.add(new TipoModel(132,"IUGOSLÁVIA"));
        combo.add(new TipoModel(133,"JAMAICA"));
        combo.add(new TipoModel(134,"JAPÃO"));
        combo.add(new TipoModel(135,"JORDÂNIA"));
        combo.add(new TipoModel(136,"KIRIBATI"));
        combo.add(new TipoModel(137,"KUWEIT"));
        combo.add(new TipoModel(138,"LAOS"));
        combo.add(new TipoModel(139,"LESOTO"));
        combo.add(new TipoModel(140,"LETÔNIA"));
        combo.add(new TipoModel(141,"LÍBANO"));
        combo.add(new TipoModel(142,"LIBÉRIA"));
        combo.add(new TipoModel(143,"LÍBIA"));
        combo.add(new TipoModel(144,"LIECHTENSTEIN"));
        combo.add(new TipoModel(145,"LITUÂNIA"));
        combo.add(new TipoModel(146,"LUXEMBURGO"));
        combo.add(new TipoModel(147,"MACAU"));
        combo.add(new TipoModel(148,"MACEDÔNIA"));
        combo.add(new TipoModel(149,"MADAGASCAR"));
        combo.add(new TipoModel(150,"MALÁSIA"));
        combo.add(new TipoModel(151,"MALAUÍ"));
        combo.add(new TipoModel(152,"MALDIVAS"));
        combo.add(new TipoModel(153,"MALI"));
        combo.add(new TipoModel(154,"MALTA"));
        combo.add(new TipoModel(155,"MARROCOS"));
        combo.add(new TipoModel(156,"MARTINICA"));
        combo.add(new TipoModel(157,"MAURÍCIO"));
        combo.add(new TipoModel(158,"MAURITÂNIA"));
        combo.add(new TipoModel(159,"MAYOTTE"));
        combo.add(new TipoModel(160,"MÉXICO"));
        combo.add(new TipoModel(161,"MIANMAR"));
        combo.add(new TipoModel(162,"MICRONÉSIA"));
        combo.add(new TipoModel(163,"MOÇAMBIQUE"));
        combo.add(new TipoModel(164,"MOLDÁVIA"));
        combo.add(new TipoModel(165,"MÔNACO"));
        combo.add(new TipoModel(166,"MONGÓLIA"));
        combo.add(new TipoModel(167,"MONTSERRAT"));
        combo.add(new TipoModel(168,"NAMÍBIA"));
        combo.add(new TipoModel(169,"NAURU"));
        combo.add(new TipoModel(170,"NEPAL"));
        combo.add(new TipoModel(171,"NICARÁGUA"));
        combo.add(new TipoModel(172,"NIGER"));
        combo.add(new TipoModel(173,"NIGÉRIA"));
        combo.add(new TipoModel(174,"NIUE"));
        combo.add(new TipoModel(175,"NORUEGA"));
        combo.add(new TipoModel(176,"NOVA CALEDÔNIA"));
        combo.add(new TipoModel(177,"NOVA ZELÂNDIA"));
        combo.add(new TipoModel(178,"OMÃ"));
        combo.add(new TipoModel(179,"PALAU"));
        combo.add(new TipoModel(180,"PANAMÁ"));
        combo.add(new TipoModel(181,"PAPUA NOVA GUINÉ"));
        combo.add(new TipoModel(182,"PAQUISTÃO"));
        combo.add(new TipoModel(183,"PARAGUAI"));
        combo.add(new TipoModel(184,"PERU"));
        combo.add(new TipoModel(185,"POLINÉSIA FRANCESA"));
        combo.add(new TipoModel(186,"POLÔNIA"));
        combo.add(new TipoModel(187,"PORTO RICO"));
        combo.add(new TipoModel(188,"PORTUGAL"));
        combo.add(new TipoModel(189,"QUÊNIA"));
        combo.add(new TipoModel(190,"QUIRGUÍZIA"));
        combo.add(new TipoModel(191,"REPÚBLICA CENTRO-AFRICANA"));
        combo.add(new TipoModel(192,"REPÚBLICA DOMINICANA"));
        combo.add(new TipoModel(193,"REPÚBLICA TCHECA"));
        combo.add(new TipoModel(194,"ROMÊNIA"));
        combo.add(new TipoModel(195,"RUANDA"));
        combo.add(new TipoModel(196,"SAHARA OCIDENTAL"));
        combo.add(new TipoModel(197,"SAMOA AMERICANA"));
        combo.add(new TipoModel(198,"SAMOA OCIDENTAL"));
        combo.add(new TipoModel(199,"SAN MARINO"));
        combo.add(new TipoModel(200,"SANTA LÚCIA"));
        combo.add(new TipoModel(201,"SÃO CRISTÓVÃO E NÉVIS"));
        combo.add(new TipoModel(202,"SÃO PIERRE E MIQUELON"));
        combo.add(new TipoModel(203,"SÃO TOMÉ E PRÍNCIPE"));
        combo.add(new TipoModel(204,"SÃO VICENTE E GRANADINAS"));
        combo.add(new TipoModel(205,"SEICHELES"));
        combo.add(new TipoModel(206,"SENEGAL"));
        combo.add(new TipoModel(207,"SERRA LEOA"));
        combo.add(new TipoModel(208,"SÍRIA"));
        combo.add(new TipoModel(209,"SOMÁLIA"));
        combo.add(new TipoModel(210,"SRI LANKA"));
        combo.add(new TipoModel(211,"SUAZILÂNDIA"));
        combo.add(new TipoModel(212,"SUDÃO"));
        combo.add(new TipoModel(213,"SUÉCIA"));
        combo.add(new TipoModel(214,"SUÍÇA"));
        combo.add(new TipoModel(215,"SURINAME"));
        combo.add(new TipoModel(216,"TADJIQUISTÃO"));
        combo.add(new TipoModel(217,"TAILÂNDIA"));
        combo.add(new TipoModel(218,"TAIWAN"));
        combo.add(new TipoModel(219,"TANZÂNIA"));
        combo.add(new TipoModel(220,"TERRITÓRIOS FRANCESES MERIDIONAIS"));
        combo.add(new TipoModel(221,"TIMOR LESTE"));
        combo.add(new TipoModel(222,"TOGO"));
        combo.add(new TipoModel(223,"TONGA"));
        combo.add(new TipoModel(224,"TRINIDAD E TOBAGO"));
        combo.add(new TipoModel(225,"TUNÍSIA"));
        combo.add(new TipoModel(226,"TURCOMÊNIA"));
        combo.add(new TipoModel(227,"TURQUIA"));
        combo.add(new TipoModel(228,"TUVALU"));
        combo.add(new TipoModel(229,"UCRÂNIA"));
        combo.add(new TipoModel(230,"UGANDA"));
        combo.add(new TipoModel(231,"URUGUAI"));
        combo.add(new TipoModel(232,"UZBEQUISTÃO"));
        combo.add(new TipoModel(233,"VANUATU"));
        combo.add(new TipoModel(234,"VATICANO"));
        combo.add(new TipoModel(235,"VENEZUELA"));
        combo.add(new TipoModel(236,"VIETNÃ"));
        combo.add(new TipoModel(237,"ZÂMBIA"));
        combo.add(new TipoModel(238,"ZIMBÁBUE"));
        combo.add(new TipoModel(239,"ILHAS GUERNSEY"));
        combo.add(new TipoModel(240,"JERSEY"));
        combo.add(new TipoModel(241,"MONTENEGRO"));
        combo.add(new TipoModel(242,"ESTADO DA PALESTINA"));
        combo.add(new TipoModel(243,"SÉRVIA"));

        return combo;

    }

    public List<TipoModel> getComboCBO() {

        List<TipoModel> combo = new ArrayList<>();

        combo.add(new TipoModel(null, "Não respondido"));

        combo.add(new TipoModel(515105,"AGENTE COMUNITÁRIO DE SAÚDE"));
        combo.add(new TipoModel(515310,"AGENTE DE AÇÃO SOCIAL"));
        combo.add(new TipoModel(515310,"AGENTE DE AÇÃO SOCIAL"));
        combo.add(new TipoModel(515140,"AGENTE DE COMBATE ÀS ENDEMIAS"));
        combo.add(new TipoModel(352210,"AGENTE DE SAÚDE PÚBLICA"));
        combo.add(new TipoModel(515130,"AGENTE INDÍGENA DE SANEAMENTO"));
        combo.add(new TipoModel(515124,"AGENTE INDÍGENA DE SAÚDE"));
        combo.add(new TipoModel(515125,"AGENTE INDÍGENA DE SAÚDE"));
        combo.add(new TipoModel(322230,"AUXILIAR DE ENFERMAGEM"));
        combo.add(new TipoModel(322229,"AUXILIAR DE ENFERMAGEM"));
        combo.add(new TipoModel(322250,"AUXILIAR DE ENFERMAGEM DA ESTRATEGIA DE SAUDE DA FAMILIA"));
        combo.add(new TipoModel(322415,"AUXILIAR EM SAÚDE BUCAL"));
        combo.add(new TipoModel(322430,"AUXILIAR EM SAÚDE BUCAL DA ESTRATÉGIA DE SAÚDE DA FAMÍLIA"));
        combo.add(new TipoModel(515305,"EDUCADOR SOCIAL"));
        combo.add(new TipoModel(422110,"RECEPCIONISTA DE CONSULTÓRIO MÉDICO OU DENTÁRIO"));
        combo.add(new TipoModel(322205,"TECNICO DE ENFERMAGEM"));
        combo.add(new TipoModel(322245,"TECNICO DE ENFERMAGEM DA ESTRATEGIA DE SAUDE DA FAMILIA"));
        combo.add(new TipoModel(322244,"TECNICO DE ENFERMAGEM DA ESTRATEGIA DE SAUDE DA FAMILIA"));
        combo.add(new TipoModel(322210,"TECNICO DE ENFERMAGEM DE TERAPIA INTENSIVA"));
        combo.add(new TipoModel(322405,"TECNICO EM SAUDE BUCAL"));
        combo.add(new TipoModel(322425,"TÉCNICO EM SAÚDE BUCAL DA ESTRATÉGIA DE SAÚDE DA FAMÍLIA"));
        combo.add(new TipoModel(515120,"VISITADOR SANITÁRIO"));

        return combo;

    }

    public List<TipoModel> getComboTipoLogradouro() {

        List<TipoModel> combo = new ArrayList<>();

        combo.add(new TipoModel(null, "Não respondido"));

        combo.add(new TipoModel(1, "ACESSO"));
        combo.add(new TipoModel(2, "ADRO"));
        combo.add(new TipoModel(4, "ALAMEDA"));
        combo.add(new TipoModel(5, "ALTO"));
        combo.add(new TipoModel(7, "ATALHO"));
        combo.add(new TipoModel(8, "AVENIDA"));
        combo.add(new TipoModel(9, "BALNEÁRIO"));
        combo.add(new TipoModel(10, "BELVEDERE"));
        combo.add(new TipoModel(11, "BECO"));
        combo.add(new TipoModel(12, "BLOCO"));
        combo.add(new TipoModel(13, "BOSQUE"));
        combo.add(new TipoModel(14, "BOULEVARD"));
        combo.add(new TipoModel(15, "BAIXA"));
        combo.add(new TipoModel(16, "CAIS"));
        combo.add(new TipoModel(17, "CAMINHO"));
        combo.add(new TipoModel(19, "CHAPADÃO"));
        combo.add(new TipoModel(20, "CONJUNTO"));
        combo.add(new TipoModel(21, "COLÔNIA"));
        combo.add(new TipoModel(22, "CORREDOR"));
        combo.add(new TipoModel(23, "CAMPO"));
        combo.add(new TipoModel(24, "CÓRREGO"));
        combo.add(new TipoModel(27, "DESVIO"));
        combo.add(new TipoModel(28, "DISTRITO"));
        combo.add(new TipoModel(30, "ESCADA"));
        combo.add(new TipoModel(31, "ESTRADA"));
        combo.add(new TipoModel(32, "ESTAÇÃO"));
        combo.add(new TipoModel(33, "ESTÁDIO"));
        combo.add(new TipoModel(36, "FAVELA"));
        combo.add(new TipoModel(37, "FAZENDA"));
        combo.add(new TipoModel(38, "FERROVIA"));
        combo.add(new TipoModel(39, "FONTE"));
        combo.add(new TipoModel(40, "FEIRA"));
        combo.add(new TipoModel(43, "FORTE"));
        combo.add(new TipoModel(45, "GALERIA"));
        combo.add(new TipoModel(46, "GRANJA"));
        combo.add(new TipoModel(50, "ILHA"));
        combo.add(new TipoModel(52, "JARDIM"));
        combo.add(new TipoModel(53, "LADEIRA"));
        combo.add(new TipoModel(54, "LARGO"));
        combo.add(new TipoModel(55, "LAGOA"));
        combo.add(new TipoModel(56, "LOTEAMENTO"));
        combo.add(new TipoModel(59, "MORRO"));
        combo.add(new TipoModel(60, "MONTE"));
        combo.add(new TipoModel(62, "PARALELA"));
        combo.add(new TipoModel(63, "PASSEIO"));
        combo.add(new TipoModel(64, "PÁTIO"));
        combo.add(new TipoModel(65, "PRAÇA"));
        combo.add(new TipoModel(67, "PARADA"));
        combo.add(new TipoModel(70, "PRAIA"));
        combo.add(new TipoModel(71, "PROLONGAMENTO"));
        combo.add(new TipoModel(72, "PARQUE"));
        combo.add(new TipoModel(73, "PASSARELA"));
        combo.add(new TipoModel(74, "PASSAGEM"));
        combo.add(new TipoModel(76, "PONTE"));
        combo.add(new TipoModel(77, "QUADRA"));
        combo.add(new TipoModel(79, "QUINTA"));
        combo.add(new TipoModel(81, "RUA"));
        combo.add(new TipoModel(82, "RAMAL"));
        combo.add(new TipoModel(87, "RECANTO"));
        combo.add(new TipoModel(88, "RETIRO"));
        combo.add(new TipoModel(89, "RETA"));
        combo.add(new TipoModel(90, "RODOVIA"));
        combo.add(new TipoModel(91, "RETORNO"));
        combo.add(new TipoModel(92, "SÍTIO"));
        combo.add(new TipoModel(94, "SERVIDÃO"));
        combo.add(new TipoModel(95, "SETOR"));
        combo.add(new TipoModel(96, "SUBIDA"));
        combo.add(new TipoModel(97, "TRINCHEIRA"));
        combo.add(new TipoModel(98, "TERMINAL"));
        combo.add(new TipoModel(99, "TREVO"));
        combo.add(new TipoModel(100, "TRAVESSA"));
        combo.add(new TipoModel(101, "VIA"));
        combo.add(new TipoModel(103, "VIADUTO"));
        combo.add(new TipoModel(104, "VILA"));
        combo.add(new TipoModel(105, "VIELA"));
        combo.add(new TipoModel(106, "VALE"));
        combo.add(new TipoModel(108, "ZIGUE-ZAGUE"));
        combo.add(new TipoModel(452, "TRECHO"));
        combo.add(new TipoModel(453, "VEREDA"));
        combo.add(new TipoModel(465, "ARTÉRIA"));
        combo.add(new TipoModel(468, "ELEVADA"));
        combo.add(new TipoModel(469, "PORTO"));
        combo.add(new TipoModel(470, "BALÃO"));
        combo.add(new TipoModel(471, "PARADOURO"));
        combo.add(new TipoModel(472, "ÁREA"));
        combo.add(new TipoModel(473, "JARDINETE"));
        combo.add(new TipoModel(474, "ESPLANADA"));
        combo.add(new TipoModel(475, "QUINTAS"));
        combo.add(new TipoModel(476, "RÓTULA"));
        combo.add(new TipoModel(477, "MARINA"));
        combo.add(new TipoModel(478, "DESCIDA"));
        combo.add(new TipoModel(479, "CIRCULAR"));
        combo.add(new TipoModel(480, "UNIDADE"));
        combo.add(new TipoModel(481, "CHÁCARA"));
        combo.add(new TipoModel(482, "RAMPA"));
        combo.add(new TipoModel(483, "PONTA"));
        combo.add(new TipoModel(484, "VIA DE PEDESTRE"));
        combo.add(new TipoModel(485, "CONDOMÍNIO"));
        combo.add(new TipoModel(486, "NÚCLEO HABITACIONAL"));
        combo.add(new TipoModel(487, "RESIDENCIAL"));
        combo.add(new TipoModel(495, "CANAL"));
        combo.add(new TipoModel(496, "BURACO"));
        combo.add(new TipoModel(497, "MÓDULO"));
        combo.add(new TipoModel(498, "ESTÂNCIA"));
        combo.add(new TipoModel(499, "LAGO"));
        combo.add(new TipoModel(500, "NÚCLEO"));
        combo.add(new TipoModel(501, "AEROPORTO"));
        combo.add(new TipoModel(502, "PASSAGEM SUBTERRÂNEA"));
        combo.add(new TipoModel(503, "COMPLEXO VIÁRIO"));
        combo.add(new TipoModel(504, "PRAÇA DE ESPORTES"));
        combo.add(new TipoModel(505, "VIA ELEVADO"));
        combo.add(new TipoModel(506, "ROTATÓRIA"));
        combo.add(new TipoModel(507, "1ª TRAVESSA"));
        combo.add(new TipoModel(508, "2ª TRAVESSA"));
        combo.add(new TipoModel(509, "3ª TRAVESSA"));
        combo.add(new TipoModel(510, "4ª TRAVESSA"));
        combo.add(new TipoModel(511, "5ª TRAVESSA"));
        combo.add(new TipoModel(512, "6ª TRAVESSA"));
        combo.add(new TipoModel(513, "7ª TRAVESSA"));
        combo.add(new TipoModel(514, "8ª TRAVESSA"));
        combo.add(new TipoModel(515, "9ª TRAVESSA"));
        combo.add(new TipoModel(516, "10ª TRAVESSA"));
        combo.add(new TipoModel(517, "11ª TRAVESSA"));
        combo.add(new TipoModel(518, "12ª TRAVESSA"));
        combo.add(new TipoModel(519, "13ª TRAVESSA"));
        combo.add(new TipoModel(520, "14ª TRAVESSA"));
        combo.add(new TipoModel(521, "15ª TRAVESSA"));
        combo.add(new TipoModel(522, "16ª TRAVESSA"));
        combo.add(new TipoModel(523, "1º ALTO"));
        combo.add(new TipoModel(524, "2º ALTO"));
        combo.add(new TipoModel(525, "3º ALTO"));
        combo.add(new TipoModel(526, "4º ALTO"));
        combo.add(new TipoModel(527, "5º ALTO"));
        combo.add(new TipoModel(528, "1º BECO"));
        combo.add(new TipoModel(529, "2º BECO"));
        combo.add(new TipoModel(530, "3º BECO"));
        combo.add(new TipoModel(531, "4º BECO"));
        combo.add(new TipoModel(532, "5º BECO"));
        combo.add(new TipoModel(533, "1ª PARALELA"));
        combo.add(new TipoModel(534, "2ª PARALELA"));
        combo.add(new TipoModel(535, "3ª PARALELA"));
        combo.add(new TipoModel(536, "4ª PARALELA"));
        combo.add(new TipoModel(537, "5ª PARALELA"));
        combo.add(new TipoModel(538, "1ª SUBIDA"));
        combo.add(new TipoModel(539, "2ª SUBIDA"));
        combo.add(new TipoModel(540, "3ª SUBIDA"));
        combo.add(new TipoModel(541, "4ª SUBIDA"));
        combo.add(new TipoModel(542, "5ª SUBIDA"));
        combo.add(new TipoModel(543, "6ª SUBIDA"));
        combo.add(new TipoModel(544, "1ª VILA"));
        combo.add(new TipoModel(545, "2ª VILA"));
        combo.add(new TipoModel(546, "3ª VILA"));
        combo.add(new TipoModel(547, "4ª VILA"));
        combo.add(new TipoModel(548, "5ª VILA"));
        combo.add(new TipoModel(549, "1º PARQUE"));
        combo.add(new TipoModel(550, "2º PARQUE"));
        combo.add(new TipoModel(551, "3º PARQUE"));
        combo.add(new TipoModel(552, "1ª RUA"));
        combo.add(new TipoModel(553, "2ª RUA"));
        combo.add(new TipoModel(554, "3ª RUA"));
        combo.add(new TipoModel(555, "5ª RUA"));
        combo.add(new TipoModel(556, "4ª RUA"));
        combo.add(new TipoModel(557, "6ª RUA"));
        combo.add(new TipoModel(558, "7ª RUA"));
        combo.add(new TipoModel(559, "8ª RUA"));
        combo.add(new TipoModel(560, "9ª RUA"));
        combo.add(new TipoModel(561, "10ª RUA"));
        combo.add(new TipoModel(562, "11ª RUA"));
        combo.add(new TipoModel(563, "12ª RUA"));
        combo.add(new TipoModel(564, "ESTACIONAMENTO"));
        combo.add(new TipoModel(565, "VALA"));
        combo.add(new TipoModel(566, "RUA DE PEDESTRE"));
        combo.add(new TipoModel(567, "TÚNEL"));
        combo.add(new TipoModel(568, "VARIANTE"));
        combo.add(new TipoModel(569, "RODO ANEL"));
        combo.add(new TipoModel(570, "TRAVESSA PARTICULAR"));
        combo.add(new TipoModel(571, "CALÇADA"));
        combo.add(new TipoModel(572, "VIA DE ACESSO"));
        combo.add(new TipoModel(573, "ENTRADA PARTICULAR"));
        combo.add(new TipoModel(645, "ACAMPAMENTO"));
        combo.add(new TipoModel(646, "VIA EXPRESSA"));
        combo.add(new TipoModel(650, "ESTRADA MUNICIPAL"));
        combo.add(new TipoModel(651, "AVENIDA CONTORNO"));
        combo.add(new TipoModel(652, "ENTRE QUADRA"));
        combo.add(new TipoModel(653, "RUA DE LIGAÇÃO"));
        combo.add(new TipoModel(654, "ÁREA ESPECIAL"));
        combo.add(new TipoModel(655, "1ª AVENIDA"));
        combo.add(new TipoModel(656, "2ª AVENIDA"));
        combo.add(new TipoModel(657, "3ª AVENIDA"));
        combo.add(new TipoModel(658, "4ª AVENIDA"));
        combo.add(new TipoModel(659, "18ª TRAVESSA"));
        combo.add(new TipoModel(660, "19ª TRAVESSA"));
        combo.add(new TipoModel(661, "5ª AVENIDA"));
        combo.add(new TipoModel(662, "RECREIO"));
        combo.add(new TipoModel(663, "PARQUE MUNICIPAL"));
        combo.add(new TipoModel(664, "CONJUNTO MUTIRÃO"));
        combo.add(new TipoModel(665, "PARQUE RESIDENCIAL"));
        combo.add(new TipoModel(666, "VIA LOCAL"));
        combo.add(new TipoModel(667, "ACESSO LOCAL"));
        combo.add(new TipoModel(668, "VIA COLETORA"));
        combo.add(new TipoModel(669, "RUA PARTICULAR"));
        combo.add(new TipoModel(670, "RUA INTEGRAÇÃO"));
        combo.add(new TipoModel(671, "ESTRADA VELHA"));
        combo.add(new TipoModel(672, "RUA VELHA"));
        combo.add(new TipoModel(673, "TRAVESSA VELHA"));
        combo.add(new TipoModel(674, "ANTIGA ESTRADA"));
        combo.add(new TipoModel(675, "ESTRADA DE LIGAÇÃO"));
        combo.add(new TipoModel(676, "ESTRADA ESTADUAL"));
        combo.add(new TipoModel(677, "AVENIDA MARGINAL"));
        combo.add(new TipoModel(678, "AVENIDA VELHA"));
        combo.add(new TipoModel(679, "AVENIDA MARGINAL ESQUERDA"));
        combo.add(new TipoModel(680, "AVENIDA MARGINAL DIREITA"));
        combo.add(new TipoModel(681, "ESTRADA PARTICULAR"));
        combo.add(new TipoModel(682, "ESTRADA ANTIGA"));
        combo.add(new TipoModel(683, "6ª AVENIDA"));
        combo.add(new TipoModel(685, "VIA LITORANEA"));
        combo.add(new TipoModel(686, "CONTORNO"));
        combo.add(new TipoModel(687, "BLOCOS"));
        combo.add(new TipoModel(688, "CICLOVIA"));
        combo.add(new TipoModel(689, "BULEVAR"));
        combo.add(new TipoModel(690, "ESCADARIA"));
        combo.add(new TipoModel(691, "PRIMEIRA LADEIRA"));
        combo.add(new TipoModel(692, "2ª LADEIRA"));
        combo.add(new TipoModel(693, "3ª LADEIRA"));
        combo.add(new TipoModel(694, "QUARTA LADEIRA"));
        combo.add(new TipoModel(695, "QUINTA LADEIRA"));
        combo.add(new TipoModel(696, "PASSAGEM DE PEDESTRES"));
        combo.add(new TipoModel(697, "ESTRADA VICINAL"));
        combo.add(new TipoModel(698, "RUA PROJETADA"));
        combo.add(new TipoModel(699, "RUA PRINCIPAL"));
        combo.add(new TipoModel(700, "TERCEIRA AVENIDA"));
        combo.add(new TipoModel(701, "SEGUNDA AVENIDA"));
        combo.add(new TipoModel(702, "PASSEIO PÚBLICO"));
        combo.add(new TipoModel(704, "ENTRE BLOCO"));
        combo.add(new TipoModel(705, "ENSEADA"));
        combo.add(new TipoModel(706, "ILHOTA"));
        combo.add(new TipoModel(707, "VIA DE PEDESTRES"));
        combo.add(new TipoModel(708, "2ª TRAVESSA DA RODOVIA"));
        combo.add(new TipoModel(709, "1ª TRAVESSA DA RODOVIA"));
        combo.add(new TipoModel(710, "ESTRADA INTERMUNICIPAL"));
        combo.add(new TipoModel(711, "VIA COSTEIRA"));
        combo.add(new TipoModel(712, "ESTRADA DE SERVIDÃO"));
        combo.add(new TipoModel(713, "COMUNIDADE"));
        combo.add(new TipoModel(714, "EIXO INDUSTRIAL"));
        combo.add(new TipoModel(715, "MERCADO"));
        combo.add(new TipoModel(716, "EVANGÉLICA"));
        combo.add(new TipoModel(717, "CAMPUS"));
        combo.add(new TipoModel(718, "PROJEÇÃO"));
        combo.add(new TipoModel(719, "NÚCLEO RURAL"));
        combo.add(new TipoModel(720, "MARGEM"));
        combo.add(new TipoModel(721, "ÁREA VERDE"));
        combo.add(new TipoModel(722, "CONDOMÍNIO RESIDENCIAL"));
        combo.add(new TipoModel(723, "CALÇADÃO"));
        combo.add(new TipoModel(724, "RUELA"));
        combo.add(new TipoModel(725, "AVENIDA PERIMETRAL"));
        combo.add(new TipoModel(726, "VIA PRINCIPAL"));
        combo.add(new TipoModel(727, "VIA PEDESTRE"));
        combo.add(new TipoModel(728, "VIA LATERAL"));
        combo.add(new TipoModel(729, "CAMINHO DE SERVIDÃO"));
        combo.add(new TipoModel(730, "AVENIDA MARGINAL NORTE"));
        combo.add(new TipoModel(731, "ESTRADA DE FERRO"));
        combo.add(new TipoModel(732, "EIXO PRINCIPAL"));
        combo.add(new TipoModel(733, "EIXO"));
        combo.add(new TipoModel(734, "OUTEIRO"));
        combo.add(new TipoModel(735, "ESTRADA NOVA"));
        combo.add(new TipoModel(736, "CONJUNTO HABITACIONAL"));
        combo.add(new TipoModel(737, "JARDIM RESIDENCIAL"));
        combo.add(new TipoModel(738, "ANEL VIÁRIO"));
        combo.add(new TipoModel(739, "SERVIDÃO DE PASSAGEM"));
        combo.add(new TipoModel(740, "17ª TRAVESSA"));
        combo.add(new TipoModel(741, "ANTIGA ESTAÇÃO"));
        combo.add(new TipoModel(742, "20ª TRAVESSA"));
        combo.add(new TipoModel(743, "21ª TRAVESSA"));
        combo.add(new TipoModel(744, "22ª TRAVESSA"));
        combo.add(new TipoModel(745, "CONJUNTO RESIDENCIAL"));
        combo.add(new TipoModel(746, "2ª ALAMEDA"));
        combo.add(new TipoModel(747, "VARIANTE DA ESTRADA"));
        combo.add(new TipoModel(748, "VIA MARGINAL"));
        combo.add(new TipoModel(749, "MÓDULO COMERCIAL"));
        combo.add(new TipoModel(750, "NOVA AVENIDA"));
        combo.add(new TipoModel(751, "GLEBA"));

        return combo;

    }





    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        /*if (!Utilitario.isEmpty(this.codigo)) {
            sb.append(codigo).append(": ");
        }*/

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

