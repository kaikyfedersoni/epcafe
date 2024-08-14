package com.cafe.controller.custos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.cafe.controller.LoginBean;
import com.cafe.modelo.to.DespesaFertilizanteTO;
import com.cafe.modelo.to.TotalDespesaTO;
import com.cafe.service.RelatorioFertilizanteService;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Getter
@Setter
@Named
@ViewScoped
public class RelatorioDespesaFertilizanteBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private List<DespesaFertilizanteTO> despesasTO = new ArrayList<>();
	private List<BigDecimal> despesaTotal1 = new ArrayList<>(13);
	private TotalDespesaTO despesaTotal;
	private List<String> anos = new ArrayList<>();
	private String periodoSelecionado;
	private int ano1;
	private int ano2;
		
	@Inject
	private LoginBean loginBean;
	
	@Inject
	private RelatorioFertilizanteService relatorioService;

	@PostConstruct
	public void inicializar() {
	
		Integer diff = LocalDate.now().getMonthValue() < 8 ? 1 : 0;
		log.info(diff);
		// 1 -1 0
		// 0  0 1
		
		dataInicio 	= LocalDate.now().withMonth(Month.AUGUST.getValue()).withDayOfMonth(1).plusYears(0 - diff);
		dataFim 	= LocalDate.now().withMonth(Month.JULY.getValue()).withDayOfMonth(31).plusYears((diff+1)%2);
		this.alterarAnosHeader();
		
		despesasTO = relatorioService.buscarDespesasTO(dataInicio, dataFim, loginBean.getUsuario().getUnidade());
		//despesaTotal = relatorioService.calcTotal(despesasTO);
		anos = relatorioService.buscarAnosComRegistros(loginBean.getUsuario().getUnidade());
		
		log.info("finalizar...");
	}
	
	public void alterarAnosHeader() {
		ano1 = dataInicio.getYear();
		ano2 = dataFim.getYear();
		
	}
	
	public void filtrarPorAno() {
		
		dataInicio = LocalDate.of(Integer.parseInt(periodoSelecionado.substring(0, 4)), Month.AUGUST, 1);
		dataFim = LocalDate.of(Integer.parseInt(periodoSelecionado.substring(5, 9)), Month.JULY, 31);
		this.alterarAnosHeader();
		
		despesasTO = relatorioService.buscarDespesasTO(dataInicio, dataFim, loginBean.getUsuario().getUnidade());
		//despesaTotal = relatorioService.calcTotal(despesasTO);
		
	}
	
}
