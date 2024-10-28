package com.cafe.modelo.enums;

import java.math.BigDecimal;

public enum TipoAuxiliarMaquinas {
	
	/* ---------------------------------*/
	/* tipos de maquinas   */
	/* ---------------------------------*/
	ABANADOR_CEREAL(new BigDecimal(10),new BigDecimal(5)),
	ADUBADORA_AUTOPROPELIDA(new BigDecimal(10),new BigDecimal(20)),
	APLICADOR_AUTOPROPELIDO(new BigDecimal(10),new BigDecimal(20)),
	ATOMIZADOR_COSTAL_MOTORIZADO(new BigDecimal(8),new BigDecimal(5)),
	CAMINHÃO(new BigDecimal(10),new BigDecimal(25)),
	COLHEDORA_AUTOMOTRIZ_CAFE(new BigDecimal(10),new BigDecimal(0)), // n tem na tabela
	COLHEDORA_CAFE(new BigDecimal(10),new BigDecimal(0)), // n tem na tabela
	DERRIÇADORA(new BigDecimal(10),new BigDecimal(0)), // n tem na tabela
	MICROTRATOR(new BigDecimal(10),new BigDecimal(25)),
	MOTO_SERRA(new BigDecimal(10),new BigDecimal(25)),
	MOTORROÇADEIRA(new BigDecimal(10),new BigDecimal(25)),
	PA_CARREGADEIRA(new BigDecimal(10),new BigDecimal(25)),
	PULVERIZADOR(new BigDecimal(10),new BigDecimal(20)),
	ROÇADEIRA_MANUAL(new BigDecimal(8),new BigDecimal(5)),
	SOPRADOR(new BigDecimal(5),new BigDecimal(5)),
	TRATOR(new BigDecimal(10),new BigDecimal(20)),
	TRATOR_DE_RODA_PEQUENO_PORTE(new BigDecimal(10),new BigDecimal(25)),
	TRITURADOR(new BigDecimal(12),new BigDecimal(5)),
	OUTROS(new BigDecimal(0),new BigDecimal(0)),

	
	/* ---------------------------------*/
	/* tipos de implementos   */
	/* ---------------------------------*/
	ABASTECEDOR_FERTILIZANTES(new BigDecimal(8),new BigDecimal(0)),
	ABASTECEDOR_PULVERIZADOR(new BigDecimal(15),new BigDecimal(5)),
	ADUBADEIRA_CITROS_CAFE(new BigDecimal(10),new BigDecimal(5)),
	ADUBADEIRA_MANUAL(new BigDecimal(3),new BigDecimal(0)),
	APLICADOR_ADUBO(new BigDecimal(10),new BigDecimal(0)), // n tem na tabela
	APLICADOR_INSETICIDA(new BigDecimal(12),new BigDecimal(5)),
	APLICADOR_LOCALIZADO_FERTILIZANTES(new BigDecimal(10),new BigDecimal(5)),
	ARADO(new BigDecimal(15),new BigDecimal(5)),
	ARADO_AIVECA(new BigDecimal(15),new BigDecimal(0)),
	BARRA_APLICADORA_HERBICIDA(new BigDecimal(8),new BigDecimal(0)), // n tem na tabela
	BOMBA_IRRIGAÇÃO(new BigDecimal(5),new BigDecimal(5)),
	CAPINADEIRA(new BigDecimal(12),new BigDecimal(5)),
	CARRETA_AGRICOLA(new BigDecimal(15),new BigDecimal(5)),
	CARRETA_BASCULANTE_CAFE(new BigDecimal(15),new BigDecimal(5)),
	CARRETA_BASCULANTE_METALICA(new BigDecimal(15),new BigDecimal(5)),
	CARRETA_BASCULANTE_METALICA_MEDIO_PORTE(new BigDecimal(15),new BigDecimal(5)),
	CARRETA_DISTRIBUIDORA_FERTILIZANTE_CALCARIO_ADUBO(new BigDecimal(10),new BigDecimal(5)),
	CARRETA_PULVERIZADORA(new BigDecimal(8),new BigDecimal(5)),
	//COLHEDORA_CAFE,
	COLHEDORA_CAFE_AUTOMOTRIZ(new BigDecimal(10),new BigDecimal(25)),
	CULTIVADOR(new BigDecimal(12),new BigDecimal(5)),
	CULTIVADOR_SUBSOLADOR(new BigDecimal(12),new BigDecimal(5)),
	DECOTADEIRA_RECEPADEIRA(new BigDecimal(12),new BigDecimal(5)),
	DISTRIBUIDOR_ADUBO_ORGANICO_CALCARIO(new BigDecimal(10),new BigDecimal(5)),
	DISTRIBUIDOR_ADUBO_ORGANICO_LIQUIDO(new BigDecimal(15),new BigDecimal(5)),
	DISTRIBUIDOR_FERTILIZANTE(new BigDecimal(10),new BigDecimal(5)),
	DISTRIBUIDOR_FERTILIZANTE_CALCARIO(new BigDecimal(10),new BigDecimal(5)),
	DISTRIBUIDOR_FERTILIZANTE_CORRETIVO(new BigDecimal(10),new BigDecimal(5)),
	DISTRIBUIDOR_FERTILIZANTE_DISCO(new BigDecimal(10),new BigDecimal(5)),
	DISTRIBUIDOR_FERTILIZANTE_SOLIDO(new BigDecimal(10),new BigDecimal(5)),
	DISTRIBUIDOR_FERTILIZANTES_ORGANICOS(new BigDecimal(10),new BigDecimal(5)),
	ENLEIRADEIRA_GRAO_CAFE(new BigDecimal(10),new BigDecimal(25)),
	ENXADA_ROTATIVA(new BigDecimal(12),new BigDecimal(5)),
	ENXADA_ROTATIVA_MEXEDOR_CAMA_AVIARIO(new BigDecimal(12),new BigDecimal(5)),
	GRADE_ARADORA(new BigDecimal(15),new BigDecimal(5)),
	GRADE_ARADORA_ARRASTO(new BigDecimal(15),new BigDecimal(5)),
	GRADE_ARADORA_MECANICA(new BigDecimal(15),new BigDecimal(5)),
	GRADE_NIVELADORA(new BigDecimal(15),new BigDecimal(5)),
	GUINCHO_AGRICOLA(new BigDecimal(12),new BigDecimal(5)),
	GUINCHO_AGRICOLA_TRASEIRO_REBOCAVEL(new BigDecimal(12),new BigDecimal(5)),
	GUINCHO_BAG(new BigDecimal(12),new BigDecimal(5)),
	GUINCHO_HIDRAULICO(new BigDecimal(12),new BigDecimal(5)),
	GUINCHO_TRASEIRO(new BigDecimal(12),new BigDecimal(5)),
	INCORPORADOR_FERTILIZANTE(new BigDecimal(10),new BigDecimal(5)),
	LAMINA_ENLEIRADORA(new BigDecimal(15),new BigDecimal(25)),
	MANEJO_SOLO_TRITURADOR(new BigDecimal(12),new BigDecimal(5)),
	//PA_CARREGADEIRA,
	PA_CARREGADEIRA_TRASEIRA(new BigDecimal(12),new BigDecimal(5)),
	PLANTADEIRA_ADUBADEIRA(new BigDecimal(15),new BigDecimal(20)),
	PLANTADEIRA_CAFE(new BigDecimal(15),new BigDecimal(5)),
	PLATAFORMA(new BigDecimal(10),new BigDecimal(25)),
	PODADEIRA(new BigDecimal(12),new BigDecimal(5)),
	PODADEIRA_HIDRAULICA(new BigDecimal(12),new BigDecimal(5)),
	//PULVERIZADOR,
	PULVERIZADOR_ACOPLADO(new BigDecimal(8),new BigDecimal(5)),
	PULVERIZADOR_ARRASTO(new BigDecimal(8),new BigDecimal(5)),
	PULVERIZADOR_CANHAO(new BigDecimal(8),new BigDecimal(5)),
	PULVERIZADOR_COSTAL(new BigDecimal(5),new BigDecimal(0)),
	PULVERIZADOR_HIDRAULICO(new BigDecimal(8),new BigDecimal(5)),
	PULVERIZADOR_MANUAL(new BigDecimal(5),new BigDecimal(0)),
	PULVERIZADOR_REBOCADO(new BigDecimal(8),new BigDecimal(5)),
	PULVERIZADOR_TRACIONADO(new BigDecimal(8),new BigDecimal(5)),
	PULVERIZADOR_TURBINA_FRUTICULTURA(new BigDecimal(8),new BigDecimal(5)),
	PULVERIZADOR_TURBO_ATOMIZADOR(new BigDecimal(8),new BigDecimal(5)),
	PULVERIZADORA_CANHAO(new BigDecimal(8),new BigDecimal(5)),
	RASTELO_CAFE(new BigDecimal(3),new BigDecimal(0)),
	RECOLHEDORA_CAFE(new BigDecimal(10),new BigDecimal(25)),
	ROÇADEIRA(new BigDecimal(12),new BigDecimal(5)),
	ROÇADEIRA_ARRASTO(new BigDecimal(12),new BigDecimal(5)),
	ROÇADEIRA_HIDRAULICA(new BigDecimal(12),new BigDecimal(5)),
	ROÇADEIRA_LATERAL(new BigDecimal(12),new BigDecimal(5)),
	SOPRADOR_TRASEIRO_CAFE(new BigDecimal(5),new BigDecimal(5)),
	SUBSOLADOR(new BigDecimal(15),new BigDecimal(5)),
	SULCADOR(new BigDecimal(15),new BigDecimal(5)),
	SULCADOR_ADUBADOR(new BigDecimal(15),new BigDecimal(5)),
	SULCADOR_ADUBADOR_ABRIDOR_SULCO(new BigDecimal(15),new BigDecimal(5)),
	SULCADOR_ADUBADOR_CANAVIEIRO(new BigDecimal(15),new BigDecimal(5)),
	SULCADOR_CANAVIEIRO(new BigDecimal(15),new BigDecimal(5)),
	SULCADOR_TANDEM_CAFE(new BigDecimal(15),new BigDecimal(5)),
	TRITURADOR_CITROS_CAFE(new BigDecimal(12),new BigDecimal(5));
	
	private final BigDecimal valor;

	private final BigDecimal valorResidual;
	 
    private TipoAuxiliarMaquinas(BigDecimal valor, BigDecimal valorResidual) {
        this.valor = valor;
		this.valorResidual = valorResidual;
    }

    public BigDecimal getValor() {
        return this.valor;
    }
