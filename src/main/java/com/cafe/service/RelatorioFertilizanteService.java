package com.cafe.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.cafe.dao.DespesaFertilizanteDAO;
import com.cafe.modelo.Unidade;
import com.cafe.modelo.to.DespesaFertilizanteDTO;
import com.cafe.modelo.to.DespesaFertilizanteTO;
import com.cafe.modelo.to.TotalDespesaTO;

import lombok.extern.log4j.Log4j;

@Log4j
public class RelatorioFertilizanteService implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private DespesaFertilizanteDAO despesaFertilizanteDAO;
	
	public List<String> buscarAnosComRegistros(Unidade unidade) {
		
		List<String> anos  = despesaFertilizanteDAO.buscarAnosComRegistro(unidade);
		return anos;
	}
	
	public List<DespesaFertilizanteTO> buscarDespesasTO(LocalDate dataInicio, LocalDate dataFim, Unidade unidade){
		
		log.info("entrou no service de relatorio fertilizante");
		List<DespesaFertilizanteDTO> despesasDTO = despesaFertilizanteDAO.buscarDespesasDTO(dataInicio, dataFim, unidade);
		
		List<DespesaFertilizanteTO> despesasTO = new ArrayList<>();
		
		List<DespesaFertilizanteTO> auxiliar = new ArrayList<>();
		log.info("despesasDTO Size: " + despesasDTO.size());
		
		int cont = -1;
		for(int i = 0; i < despesasDTO.size(); i++) {
			
			DespesaFertilizanteDTO dto = despesasDTO.get(i);
			
			log.info("DTO:: " + i + "Talhao: " + dto.getNomeTalhao() + "Valor: " + dto.getValorDespesaFerTalhao());
			
			DespesaFertilizanteTO to = new DespesaFertilizanteTO();
			
			if(i==0 || (dto.getIdTalhao() != auxiliar.get(cont).getIdTalhao())) {
				cont++;
				
				to.setNomeTalhao(dto.getNomeTalhao());
				to.setIdTalhao(dto.getIdTalhao());
				
				this.verificaMesAno(dto.getData(), to, dto.getValorDespesaFerTalhao());
				
				auxiliar.add(to);
			} else {
				this.verificaMesAno(dto.getData(), auxiliar.get(cont), dto.getValorDespesaFerTalhao());
			}
			
			log.info("qde TO..." + auxiliar.size());
		}
		
		despesasTO = auxiliar;
		
		for (int i = 0; i < despesasTO.size(); i++) {
			calcValorAnual(despesasTO.get(i));
		}
		
		return despesasTO;
	}
	
	public void verificaMesAno(LocalDate data, DespesaFertilizanteTO to, BigDecimal valorDespesa) {
		int mes = data.getMonthValue();
		
		switch(mes) {
		case 1:

			if (to.getValorTotalJan() == new BigDecimal(0)) {

				to.setValorTotalJan(valorDespesa);
			} else {
				BigDecimal totalExistente = to.getValorTotalJan();
				BigDecimal novoTotal = totalExistente.add(valorDespesa);
				to.setValorTotalJan(novoTotal);
			}

			break;
		case 2:

			if (to.getValorTotalFev() == new BigDecimal(0)) {

				to.setValorTotalFev(valorDespesa);
			} else {
				BigDecimal totalExistente = to.getValorTotalFev();
				BigDecimal novoTotal = totalExistente.add(valorDespesa);
				to.setValorTotalFev(novoTotal);
			}
			break;

		case 3:
			if (to.getValorTotalMar() == new BigDecimal(0)) {

				to.setValorTotalMar(valorDespesa);
			} else {
				BigDecimal totalExistente = to.getValorTotalMar();
				BigDecimal novoTotal = totalExistente.add(valorDespesa);
				to.setValorTotalMar(novoTotal);
			}
			break;

		case 4:
			if (to.getValorTotalAbr() == new BigDecimal(0)) {
				to.setValorTotalAbr(valorDespesa);
			} else {
				BigDecimal totalExistente = to.getValorTotalAbr();
				BigDecimal novoTotal = totalExistente.add(valorDespesa);
				to.setValorTotalAbr(novoTotal);
			}
			break;

		case 5:
			if (to.getValorTotalMai() == new BigDecimal(0)) {
				to.setValorTotalMai(valorDespesa);
			} else {
				BigDecimal totalExistente = to.getValorTotalMai();
				BigDecimal novoTotal = totalExistente.add(valorDespesa);
				to.setValorTotalMai(novoTotal);
			}
			break;

		case 6:
			if (to.getValorTotalJun() == new BigDecimal(0)) {
				to.setValorTotalJun(valorDespesa);
			} else {
				BigDecimal totalExistente = to.getValorTotalJun();
				BigDecimal novoTotal = totalExistente.add(valorDespesa);
				to.setValorTotalJun(novoTotal);
			}
			break;

		case 7:
			if (to.getValorTotalJul() == new BigDecimal(0)) {
				to.setValorTotalJul(valorDespesa);
			} else {
				BigDecimal totalExistente = to.getValorTotalJul();
				BigDecimal novoTotal = totalExistente.add(valorDespesa);
				to.setValorTotalJul(novoTotal);
			}
			break;

		case 8:
			if (to.getValorTotalAgo() == new BigDecimal(0)) {
				to.setValorTotalAgo(valorDespesa);
			} else {
				BigDecimal totalExistente = to.getValorTotalAgo();
				BigDecimal novoTotal = totalExistente.add(valorDespesa);
				to.setValorTotalAgo(novoTotal);
			}
			break;

		case 9:
			if (to.getValorTotalSet() == new BigDecimal(0)) {
				to.setValorTotalSet(valorDespesa);
			} else {
				BigDecimal totalExistente = to.getValorTotalSet();
				BigDecimal novoTotal = totalExistente.add(valorDespesa);
				to.setValorTotalSet(novoTotal);
			}
			break;

		case 10:
			if (to.getValorTotalOut() == new BigDecimal(0)) {
				to.setValorTotalOut(valorDespesa);
			} else {
				BigDecimal totalExistente = to.getValorTotalOut();
				BigDecimal novoTotal = totalExistente.add(valorDespesa);
				to.setValorTotalOut(novoTotal);
			}
			break;

		case 11:
			if (to.getValorTotalNov() == new BigDecimal(0)) {
				to.setValorTotalNov(valorDespesa);
			} else {
				BigDecimal totalExistente = to.getValorTotalNov();
				BigDecimal novoTotal = totalExistente.add(valorDespesa);
				to.setValorTotalNov(novoTotal);
			}
			break;

		case 12:
			if (to.getValorTotalDez() == new BigDecimal(0)) {
				to.setValorTotalDez(valorDespesa);
			} else {
				BigDecimal totalExistente = to.getValorTotalDez();
				BigDecimal novoTotal = totalExistente.add(valorDespesa);
				to.setValorTotalDez(novoTotal);
			}
			break;
		}
	}
	
	public void calcValorAnual(DespesaFertilizanteTO to) {

		log.info("calcValorAnual...");

		BigDecimal valor = to.getValorTotalJan().add(to.getValorTotalFev()).add(to.getValorTotalMar())
				.add(to.getValorTotalAbr()).add(to.getValorTotalMai()).add(to.getValorTotalJun())
				.add(to.getValorTotalJul()).add(to.getValorTotalAgo()).add(to.getValorTotalSet())
				.add(to.getValorTotalOut()).add(to.getValorTotalNov()).add(to.getValorTotalDez());

		to.setValorTotalAnual(valor);

	}
	
	public TotalDespesaTO calcTotal(List<DespesaFertilizanteTO> despesas) {
		
		log.info("calcular totais... ");
		
		TotalDespesaTO totais = new TotalDespesaTO();
		
		
		
		for(DespesaFertilizanteTO despesa : despesas) {
			
			totais.setValorTotalJan(totais.getValorTotalJan().add(despesa.getValorTotalJan()));
			totais.setValorTotalFev(totais.getValorTotalFev().add(despesa.getValorTotalFev()));
			totais.setValorTotalMar(totais.getValorTotalMar().add(despesa.getValorTotalMar()));
			totais.setValorTotalAbr(totais.getValorTotalAbr().add(despesa.getValorTotalAbr()));
			totais.setValorTotalMai(totais.getValorTotalMai().add(despesa.getValorTotalMai()));
			totais.setValorTotalJun(totais.getValorTotalJun().add(despesa.getValorTotalJun()));
			totais.setValorTotalJul(totais.getValorTotalJul().add(despesa.getValorTotalJul()));
			totais.setValorTotalAgo(totais.getValorTotalAgo().add(despesa.getValorTotalAgo()));
			totais.setValorTotalSet(totais.getValorTotalSet().add(despesa.getValorTotalSet()));
			totais.setValorTotalOut(totais.getValorTotalOut().add(despesa.getValorTotalOut()));
			totais.setValorTotalNov(totais.getValorTotalNov().add(despesa.getValorTotalNov()));
			totais.setValorTotalDez(totais.getValorTotalDez().add(despesa.getValorTotalDez()));
			totais.setValorTotalAnual(totais.getValorTotalAnual().add(despesa.getValorTotalAnual()));
		}
		
		log.info(totais);
		
		return totais;
	}
	
	
}
