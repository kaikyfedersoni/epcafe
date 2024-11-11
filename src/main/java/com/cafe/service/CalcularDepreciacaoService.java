

package com.cafe.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

import com.cafe.modelo.DespesaMaquina;
import com.cafe.modelo.Instalacao;
import com.cafe.modelo.Maquina;
import com.cafe.modelo.Talhao;
import com.cafe.modelo.Unidade;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Getter
@Setter
@NoArgsConstructor
@Log4j
public class CalcularDepreciacaoService implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BigDecimal calcularDepreciacaoMaquina(Maquina maquina, Talhao talhao, Unidade unidade, DespesaMaquina despesaMaquina) {
		
		BigDecimal valor = new BigDecimal(0);
		BigDecimal valorDoBem =  maquina.getValor();
		BigDecimal vidaUtil = maquina.getVidaUtil();
		BigDecimal valorEmHoras = new BigDecimal(8760);
		BigDecimal vidaUtilEmHoras = vidaUtil.multiply(valorEmHoras);
		BigDecimal valorResidual = maquina.getValorResidual();
		BigDecimal valorSubtrai = new BigDecimal(1);
		BigDecimal valorDivide = new BigDecimal(100);
		BigDecimal area =talhao.getArea();
		BigDecimal horasTrabalhadas = despesaMaquina.getTempoTrabalhado();
		BigDecimal horasPorHectare = horasTrabalhadas.divide(area,2,RoundingMode.DOWN);
		
		valor = valorDoBem
				.multiply(valorSubtrai
						.subtract(valorResidual
								.divide(valorDivide,2,RoundingMode.DOWN)))
				.divide(vidaUtilEmHoras,2,RoundingMode.DOWN)
				.multiply(horasPorHectare);
		

		return valor;
	}
	
	public BigDecimal calcularDepreciacaoInstalacao(Instalacao instalacao, Unidade unidade,Talhao talhao) {
		
		BigDecimal valor = new BigDecimal(0);
		BigDecimal valorDoBem = instalacao.getValor();
		BigDecimal vidaUtil = instalacao.getVidaUtil();
		BigDecimal valorResidual =  instalacao.getValorResidual();
		BigDecimal taxaDeOcupacao = new BigDecimal(0.33);
		BigDecimal area = talhao.getArea();
		BigDecimal valorSubtrai = new BigDecimal(1);
		BigDecimal valorDivide = new BigDecimal(100);
		
		valor = valorDoBem
				.multiply(valorSubtrai
						.subtract(valorResidual
								.divide(valorDivide,2,RoundingMode.DOWN)))
				.divide(vidaUtil,2,RoundingMode.DOWN)
				.multiply(taxaDeOcupacao
						.divide(area,2,RoundingMode.DOWN));
		return valor;
	}
		
	
}
