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

