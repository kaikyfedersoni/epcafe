package com.cafe.modelo.to;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DespesaFertilizanteDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private LocalDate data;
	private BigDecimal valorDespesaFerTalhao;
	private String nomeTalhao;
	
	public DespesaFertilizanteDTO(
			LocalDate data,
			BigDecimal valorDespesaFerTalhao,
			String nomeTalhao
			) {
		this.data = data;
		this.valorDespesaFerTalhao = valorDespesaFerTalhao;
		this.nomeTalhao = nomeTalhao;
	}
	
	
}
