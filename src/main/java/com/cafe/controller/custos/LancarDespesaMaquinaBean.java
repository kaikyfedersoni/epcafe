package com.cafe.controller.custos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.cafe.controller.LoginBean;
import com.cafe.modelo.DespesaMaquina;
import com.cafe.modelo.Maquina;
import com.cafe.modelo.enums.FatorPotencia;
import com.cafe.service.DespesaMaquinaService;
import com.cafe.service.MaquinaService;
import com.cafe.util.CalculoUtil;
import com.cafe.util.MessageUtil;
import com.cafe.util.NegocioException;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

/**
 * @author murakamiadmin
 *
 */
@Log4j
@Getter
@Setter
@Named
@ViewScoped
public class LancarDespesaMaquinaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Maquina> maquinas;
	private DespesaMaquina despesaMaquina;
	private DespesaMaquina despesaMaquinaSelecionada;
	private List<FatorPotencia> fatorPotencias;
	private List<DespesaMaquina> despesas = new ArrayList<>();
	private Long tenantId;
	
	private String nomeMaquina;
	
	private String yearRange;
	
	@Inject
	private LoginBean loginBean;
	
	@Inject
	private MaquinaService maquinaService;
	
	@Inject
	private DespesaMaquinaService despesaService;
	
	@Inject
	private CalculoUtil calcUtil;

	@PostConstruct
	public void inicializar() {
		
		log.info("inicializar login = " + loginBean.getUsuario());
		
		this.yearRange = this.calcUtil.getAnoCorrente();
		maquinas = maquinaService.buscarMaquinasAlfabetico(loginBean.getTenantId());
		fatorPotencias = Arrays.asList(FatorPotencia.values());
		despesas = despesaService.buscarDespesasMaquinas(loginBean.getTenantId());		

		
		limpar();
	}
	
    public void salvar() {
    	
    	
    	log.info("salvar ..." + despesaMaquina);
    	

    	try {
    		despesaMaquina = this.despesaService.salvar(despesaMaquina);
    		this.despesas = despesaService.buscarDespesasMaquinas(loginBean.getTenantId());
			MessageUtil.sucesso("Despesa salva com sucesso!");
		} catch (NegocioException e) {
			e.printStackTrace();
			MessageUtil.erro(e.getMessage());
		}
		this.limpar();
 	
    }
    
    
    
    public void excluirDespesa() {
    	try {
    		log.info("excluindo...");
			despesaService.excluir(despesaMaquinaSelecionada);			
			this.despesas = despesaService.buscarDespesasMaquinas(loginBean.getTenantId());
			MessageUtil.sucesso("Despesa " + despesaMaquinaSelecionada.getId() + " excluída com sucesso.");
		} catch (NegocioException e) {
			e.printStackTrace();
			MessageUtil.erro(e.getMessage());
		}
    }
    

	public void limpar() {
		log.info("limpar");
		despesaMaquina = new DespesaMaquina();

		despesaMaquina.setPropriedade(loginBean.getUsuario().getPropriedade());
		despesaMaquina.setTenant_id(loginBean.getUsuario().getTenant().getCodigo());
	}
	
	
	
}