package com.cafe.modelo.enums;

public enum TipoInstalacao {
	
	ACUDE(50),
	ALMOXARIFADO_ALVENARIA(40),
	ALMOXARIFADO_MADEIRA(25),
	ALOJAMENTO_ALVENARIA(40),
	ALOJAMENTO_MADEIRA(25),
	BARRACAO_ALVENARIA(40),
	BARRACAO_MADEIRA(25),
	BARRAGEM(50),
	CAIXA_MISTURA(40),
	CASA_ALVENARIA_SEDE(40),
	CASA_MADEIRA_SEDE(25),
	CASA_ALVENARIA_ADMINISTRADOR(40),
	CASA_MADEIRA_ADMINISTRADOR(25),
	CASA_ALVENARIA_EMPREGADOS(40),
	CASA_MADEIRA_EMPREGADOS(25),
	CASA_METEOROLOGIA_HIDROLOGIA(40),
	CERCA_INTERNA(25),
	CERCA_EXTERNA(25),
	CISTERNA(40),
	ESCRITORIO_ALVENARIA(40),
	ESCRITORIO_MADEIRA(25),
	ELETRIFICACAO_RURAL(40),
	GALPAO_ALVENARIA(40),
	GALPAO_MADEIRA(25),
	GALPAO_METALICO(40),
	GALPAO_BENEFICIAMENTO(40),
	GALPAO_DEFENSIVOS(40),
	GALPAO_PRODUTOS(40),
	LAVADOR_MAQUINAS(40),
	OFICINA_MECANICA_ALVENARIA(40),
	OFICINA_MECANICA_MADEIRA(25),
	PAIOL_ALVENARIA(40),
	PAIOL_MADEIRA(25),
	POCO_ARTESIANO(40),
	REFEITORIO(40),
	REPRESA(50),
	RODOLUVIO(40),
	TANQUE(40),
	TERREIRO_ASFALTO(40),
	TERREIRO_CONCRETO(40),
	TERREIRO_TERRA_BATIDA(0),
	TULHA_ALVENARIA(40),
	TULHA_CONCRETO(40),
	TULHA_MADEIRA(25);
	
	
	private final int valor;
	 
    private TipoInstalacao(int valor) {
        this.valor = valor;
    }

    public int getValor() {
    	//BigDecimal valorFinal = 
        return this.valor;
    }

}
