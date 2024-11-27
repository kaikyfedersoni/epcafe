package com.cafe.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import com.cafe.modelo.DespesaMaquina;
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

	public List<BigDecimal> calcularManutencaoInstalacao(Instalacao instalacao,Unidade unidade){
		List<BigDecimal> valores = new ArrayList<>();
		BigDecimal valorDoBem =  instalacao.getValor();
		BigDecimal area = unidade.getArea();
		BigDecimal taxaDeManutencao = new BigDecimal(0.01);
		
		BigDecimal valor = valorDoBem.multiply(taxaDeManutencao)
				.divide(area,2,RoundingMode.UP);
		
		BigDecimal valorMes = valor.divide(new BigDecimal(12),2,RoundingMode.UP);
		
		valores.add(valor);
		valores.add(valorMes);
		
		return valores;
	       
	}

	
	public List<BigDecimal> calcularSeguroEquipamento(Maquina maquina,DespesaMaquina despesa) {
		
		List<BigDecimal> valoresSeguro = new ArrayList<>();
		BigDecimal valorDoBem = maquina.getValor();
		BigDecimal vidaUtil = maquina.getVidaUtil();
		BigDecimal vidaUtilHoras = maquina.getVidaUtilHoras();
		BigDecimal razaoVida = vidaUtilHoras.divide(vidaUtil,2,RoundingMode.UP);
		BigDecimal horasTrabalhadas = despesa.getTempoTrabalhado();
		BigDecimal seguroEstipulado = new BigDecimal(0.0075);
		
		BigDecimal valorSeguro = (((valorDoBem.
				divide(new BigDecimal(2),2,RoundingMode.UP))
				.multiply(seguroEstipulado))
				.divide(razaoVida,4,RoundingMode.UP))
				.multiply(horasTrabalhadas);
		
		BigDecimal valorSeguroMes = valorSeguro.divide(new BigDecimal(12),2,RoundingMode.UP);
		
		valoresSeguro.add(valorSeguro);
		valoresSeguro.add(valorSeguroMes);

		return valoresSeguro;
		
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
