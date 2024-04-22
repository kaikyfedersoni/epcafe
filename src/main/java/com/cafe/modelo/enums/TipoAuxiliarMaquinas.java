package com.cafe.modelo.enums;


public enum TipoAuxiliarMaquinas {
	
	/* ---------------------------------*/
	/* tipos de maquinas   */
	/* ---------------------------------*/
	ABANADOR_CEREAL(10),
	ADUBADORA_AUTOPROPELIDA(10),
	APLICADOR_AUTOPROPELIDO(10),
	ATOMIZADOR_COSTAL_MOTORIZADO(8),
	CAMINHÃO(10),
	COLHEDORA_AUTOMOTRIZ_CAFE(10),
	COLHEDORA_CAFE(10),
	MICROTRATOR(10),
	MOTORROÇADEIRA(10),
	PA_CARREGADEIRA(10),
	PULVERIZADOR(10),
	ROÇADEIRA_MANUAL(8),
	SOPRADOR(5),
	TRATOR(10),
	TRATOR_DE_RODA_PEQUENO_PORTE(10),
	TRITURADOR(12),
	OUTROS(0),

	
	/* ---------------------------------*/
	/* tipos de implementos   */
	/* ---------------------------------*/
	ABASTECEDOR_FERTILIZANTES(8),
	ABASTECEDOR_PULVERIZADOR(15),
	ADUBADEIRA_CITROS_CAFE(10),
	ADUBADEIRA_MANUAL(3),
	APLICADOR_ADUBO(10),
	APLICADOR_INSETICIDA(12),
	APLICADOR_LOCALIZADO_FERTILIZANTES(10),
	ARADO(15),
	ARADO_AIVECA(15),
	BARRA_APLICADORA_HERBICIDA(8),
	BOMBA_IRRIGAÇÃO(5),
	CAPINADEIRA(12),
	CARRETA_AGRICOLA(15),
	CARRETA_BASCULANTE_CAFE(15),
	CARRETA_BASCULANTE_METALICA(15),
	CARRETA_BASCULANTE_METALICA_MEDIO_PORTE(15),
	CARRETA_DISTRIBUIDORA_FERTILIZANTE_CALCARIO_ADUBO(10),
	CARRETA_PULVERIZADORA(8),
	//COLHEDORA_CAFE,
	COLHEDORA_CAFE_AUTOMOTRIZ(10),
	CULTIVADOR(12),
	CULTIVADOR_SUBSOLADOR(12),
	DECOTADEIRA_RECEPADEIRA(12),
	DISTRIBUIDOR_ADUBO_ORGANICO_CALCARIO(10),
	DISTRIBUIDOR_ADUBO_ORGANICO_LIQUIDO(15),
	DISTRIBUIDOR_FERTILIZANTE(10),
	DISTRIBUIDOR_FERTILIZANTE_CALCARIO(10),
	DISTRIBUIDOR_FERTILIZANTE_CORRETIVO(10),
	DISTRIBUIDOR_FERTILIZANTE_DISCO(10),
	DISTRIBUIDOR_FERTILIZANTE_SOLIDO(10),
	DISTRIBUIDOR_FERTILIZANTES_ORGANICOS(10),
	ENLEIRADEIRA_GRAO_CAFE(10),
	ENXADA_ROTATIVA(12),
	ENXADA_ROTATIVA_MEXEDOR_CAMA_AVIARIO(12),
	GRADE_ARADORA(15),
	GRADE_ARADORA_ARRASTO(15),
	GRADE_ARADORA_MECANICA(15),
	GRADE_NIVELADORA(15),
	GUINCHO_AGRICOLA(12),
	GUINCHO_AGRICOLA_TRASEIRO_REBOCAVEL(12),
	GUINCHO_BAG(12),
	GUINCHO_HIDRAULICO(12),
	GUINCHO_TRASEIRO(12),
	INCORPORADOR_FERTILIZANTE(10),
	LAMINA_ENLEIRADORA(15),
	MANEJO_SOLO_TRITURADOR(12),
	//PA_CARREGADEIRA,
	PA_CARREGADEIRA_TRASEIRA(12),
	PLANTADEIRA_ADUBADEIRA(15),
	PLANTADEIRA_CAFE(15),
	PLATAFORMA(10),
	PODADEIRA(12),
	PODADEIRA_HIDRAULICA(12),
	//PULVERIZADOR,
	PULVERIZADOR_ACOPLADO(8),
	PULVERIZADOR_ARRASTO(8),
	PULVERIZADOR_CANHAO(8),
	PULVERIZADOR_COSTAL(5),
	PULVERIZADOR_HIDRAULICO(8),
	PULVERIZADOR_MANUAL(5),
	PULVERIZADOR_REBOCADO(8),
	PULVERIZADOR_TRACIONADO(8),
	PULVERIZADOR_TURBINA_FRUTICULTURA(8),
	PULVERIZADOR_TURBO_ATOMIZADOR(8),
	PULVERIZADORA_CANHAO(8),
	RASTELO_CAFE(3),
	RECOLHEDORA_CAFE(10),
	ROÇADEIRA(12),
	ROÇADEIRA_ARRASTO(12),
	ROÇADEIRA_HIDRAULICA(12),
	ROÇADEIRA_LATERAL(12),
	SOPRADOR_TRASEIRO_CAFE(5),
	SUBSOLADOR(15),
	SULCADOR(15),
	SULCADOR_ADUBADOR(15),
	SULCADOR_ADUBADOR_ABRIDOR_SULCO(15),
	SULCADOR_ADUBADOR_CANAVIEIRO(15),
	SULCADOR_CANAVIEIRO(15),
	SULCADOR_TANDEM_CAFE(15),
	TRITURADOR_CITROS_CAFE(12);
	
	private final int valor;
	 
    private TipoAuxiliarMaquinas(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return this.valor;
    }

	
}