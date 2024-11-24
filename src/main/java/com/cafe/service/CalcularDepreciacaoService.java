

package com.cafe.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import com.cafe.modelo.DespesaMaquina;
import com.cafe.modelo.Instalacao;
import com.cafe.modelo.Maquina;
import com.cafe.modelo.Talhao;
import com.cafe.modelo.Unidade;
import com.cafe.modelo.to.CalcularDepreciacaoMaquinaDTO;

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

	public List<BigDecimal> calcularDepreciacaoMaquina(
	        Maquina maquina, 
	        List<Talhao> talhoes, 
	        DespesaMaquina despesaMaquina, 
	        Unidade unidade) {

	    List<BigDecimal> depreciacoes = new ArrayList<>();
	    BigDecimal valorDoBem = maquina.getValor();
	    BigDecimal vidaUtilEmHoras = new BigDecimal(30000);
	    BigDecimal valorResidual = maquina.getValorResidual();
	    BigDecimal valorSubtrai = new BigDecimal(1);
	    BigDecimal valorDivide = new BigDecimal(100);
	    BigDecimal horasTrabalhadas = despesaMaquina.getTempoTrabalhado();
	    BigDecimal depreciacaoTalhao = BigDecimal.ZERO;
	    BigDecimal areaTotal = unidade.getArea();

	    BigDecimal depreciacao = valorDoBem
                .multiply(valorSubtrai
                        .subtract(valorResidual.divide(valorDivide, 2, RoundingMode.DOWN)))
                .divide(vidaUtilEmHoras, 2, RoundingMode.DOWN)
                .multiply(horasTrabalhadas).divide(new BigDecimal(2),2, RoundingMode.DOWN);
	    depreciacoes.add(depreciacao);
	   
	    for (Talhao talhao : talhoes) {
	        BigDecimal areaTalhao = talhao.getArea();
	        depreciacaoTalhao = depreciacao.multiply(areaTalhao.divide(areaTotal, 4, RoundingMode.UP));
	        depreciacoes.add(depreciacaoTalhao);
	    }

	    
	    return depreciacoes;
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
