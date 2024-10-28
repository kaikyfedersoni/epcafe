package com.cafe.modelo.enums;

import java.math.BigDecimal;

public enum TipoInstalacao {
	
	ACUDE(new BigDecimal(50),new BigDecimal(20)),
	ALMOXARIFADO_ALVENARIA(new BigDecimal(40),new BigDecimal(20)),
	ALMOXARIFADO_MADEIRA(new BigDecimal(25),new BigDecimal(20)),
	ALOJAMENTO_ALVENARIA(new BigDecimal(40),new BigDecimal(20)),
	ALOJAMENTO_MADEIRA(new BigDecimal(25),new BigDecimal(20)),
	BARRACAO_ALVENARIA(new BigDecimal(40),new BigDecimal(20)),
	BARRACAO_MADEIRA(new BigDecimal(25),new BigDecimal(20)),
	BARRAGEM(new BigDecimal(50),new BigDecimal(20)),
	CAIXA_MISTURA(new BigDecimal(40),new BigDecimal(0)),
	CASA_ALVENARIA_SEDE(new BigDecimal(40),new BigDecimal(20)),
	CASA_MADEIRA_SEDE(new BigDecimal(25),new BigDecimal(20)),
	CASA_ALVENARIA_ADMINISTRADOR(new BigDecimal(40),new BigDecimal(20)),
	CASA_MADEIRA_ADMINISTRADOR(new BigDecimal(25),new BigDecimal(20)),
	CASA_ALVENARIA_EMPREGADOS(new BigDecimal(40),new BigDecimal(20)),
	CASA_MADEIRA_EMPREGADOS(new BigDecimal(25),new BigDecimal(20)),
	CASA_METEOROLOGIA_HIDROLOGIA(new BigDecimal(40),new BigDecimal(0)),
	CERCA_INTERNA(new BigDecimal(25),new BigDecimal(20)),
	CERCA_EXTERNA(new BigDecimal(25),new BigDecimal(20)),
	CISTERNA(new BigDecimal(40),new BigDecimal(0)),
	ESCRITORIO_ALVENARIA(new BigDecimal(40),new BigDecimal(20)),
	ESCRITORIO_MADEIRA(new BigDecimal(25),new BigDecimal(20)),
	ELETRIFICACAO_RURAL(new BigDecimal(40),new BigDecimal(20)),
	GALPAO_ALVENARIA(new BigDecimal(40),new BigDecimal(20)),
	GALPAO_MADEIRA(new BigDecimal(25),new BigDecimal(20)),
	GALPAO_METALICO(new BigDecimal(40),new BigDecimal(20)),
	GALPAO_BENEFICIAMENTO(new BigDecimal(40),new BigDecimal(0)),
	GALPAO_DEFENSIVOS(new BigDecimal(40),new BigDecimal(0)),
	GALPAO_PRODUTOS(new BigDecimal(40),new BigDecimal(0)),
	LAVADOR_MAQUINAS(new BigDecimal(40),new BigDecimal(0)),
	OFICINA_MECANICA_ALVENARIA(new BigDecimal(40),new BigDecimal(20)),
	OFICINA_MECANICA_MADEIRA(new BigDecimal(25),new BigDecimal(20)),
	PAIOL_ALVENARIA(new BigDecimal(40),new BigDecimal(20)),
	PAIOL_MADEIRA(new BigDecimal(25),new BigDecimal(20)),
	POCO_ARTESIANO(new BigDecimal(40),new BigDecimal(20)),
	REFEITORIO(new BigDecimal(40),new BigDecimal(0)),
	REPRESA(new BigDecimal(50),new BigDecimal(20)),
	RODOLUVIO(new BigDecimal(40),new BigDecimal(0)),
	TANQUE(new BigDecimal(40),new BigDecimal(20)),
	TERREIRO_ASFALTO(new BigDecimal(40),new BigDecimal(20)),
	TERREIRO_CONCRETO(new BigDecimal(40),new BigDecimal(20)),
	TERREIRO_TERRA_BATIDA(new BigDecimal(0),new BigDecimal(0)),
	TULHA_ALVENARIA(new BigDecimal(40),new BigDecimal(20)),
	TULHA_CONCRETO(new BigDecimal(40),new BigDecimal(20)),
	TULHA_MADEIRA(new BigDecimal(25),new BigDecimal(20)),
	OUTROS(new BigDecimal(0),new BigDecimal(0));
	
	
	private final BigDecimal valor;

	private final BigDecimal valorResidual;
	 
    private TipoInstalacao(BigDecimal valor, BigDecimal valorResidual) {
        this.valor = valor;
		this.valorResidual = valorResidual;
    }

    public BigDecimal getValor() {
    	//BigDecimal valorFinal = 
        return this.valor;
    }

	public BigDecimal getValorResidual(){
		return this.valorResidual;
	}

}
