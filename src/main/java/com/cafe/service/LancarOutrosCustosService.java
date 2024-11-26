package com.cafe.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

import com.cafe.modelo.DespesaMaquina;
import com.cafe.modelo.Funcionario;
import com.cafe.modelo.Instalacao;
import com.cafe.modelo.Maquina;
import com.cafe.modelo.Unidade;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Getter
@Setter
@NoArgsConstructor
@Log4j
public class LancarOutrosCustosService implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BigDecimal calcularManutencaoInstalacao(Instalacao instalacao,Unidade unidade){
		BigDecimal valor = new BigDecimal(0);
		BigDecimal valorDoBem =  instalacao.getValor();
		BigDecimal area = unidade.getArea();
		BigDecimal taxaDeManutencao = new BigDecimal(0.01);
		
		valor = valorDoBem.multiply(taxaDeManutencao)
				.divide(area,4,RoundingMode.UP);
		return valor;
	       
	}

	
	public BigDecimal calcularSeguroEquipamento(Maquina maquina,DespesaMaquina despesa) {
		
		BigDecimal valorSeguro = new BigDecimal(0);
		BigDecimal valorDoBem = maquina.getValor();
		BigDecimal vidaUtil = maquina.getVidaUtil();
		BigDecimal vidaUtilHoras = maquina.getVidaUtilHoras();
		BigDecimal horasTrabalhadas = despesa.getTempoTrabalhado();
		BigDecimal seguroEstipulado = new BigDecimal(0.0075);
		
		valorSeguro = ((valorDoBem.
				divide(new BigDecimal(2)))
				.multiply(seguroEstipulado))
				.divide((vidaUtilHoras.divide(vidaUtil)))
				.multiply(horasTrabalhadas);
		
		return valorSeguro;
		
	}
	
	//public BigDecimal calcularEncargosSociais(Funcionario funcionario, Unidade unidade) {
		//BigDecimal valor = new BigDecimal(0);
		//BigDecimal salario = funcionario.getSalario();
		//BigDecimal administradorRural = new BigDecimal(0);
		//BigDecimal taxaEncargoSocial = new BigDecimal(0.04);
		//BigDecimal diferencaMes = new BigDecimal(6);
		//BigDecimal areaTotal = unidade.getArea();
		
//		administradorRural = salario.multiply(diferencaMes).divide(areaTotal);
		
	//	valor = administradorRural.multiply(taxaEncargoSocial);
		
	//	return valor;
		
//	}
	
		
	
}
