package com.cafe.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.cafe.dao.InstalacaoDAO;
import com.cafe.dao.PropriedadeDAO;
import com.cafe.modelo.Instalacao;
import com.cafe.modelo.Propriedade;
import com.cafe.util.NegocioException;

import lombok.extern.log4j.Log4j;

/**
 * @author isabella
 *
 */

@Log4j
public class InstalacaoService implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Inject
	private InstalacaoDAO instalacaoDAO;
	@Inject
	private PropriedadeDAO propriedadeDAO;

	public void salvar(Instalacao instalacao) throws NegocioException {
		
		log.info("Service : tenant = " + instalacao.getTenant_id());		
		this.instalacaoDAO.salvar(instalacao);
	}
	
	public void excluir(Instalacao instalacao) throws NegocioException {
		this.instalacaoDAO.excluir(instalacao);		
	}
		
	public Instalacao buscarPeloCodigo(long codigo) {
		return this.instalacaoDAO.buscarPeloCodigo(codigo);
	}	
	
	public List<Instalacao> buscarInstalacoes(Long tenantId) {
		
		log.info("Primeiro acesso a banco... buscar instalacões");					
		return this.instalacaoDAO.buscarInstalacoes(tenantId);
	}
	
	public List<Instalacao> buscarInstalacoesPorUnidade(Propriedade propriedade, Long tenantId) {
		
		return this.instalacaoDAO.buscarInstalacoesPorUnidade(propriedade, tenantId);
	}

	/* Unidades */
	
	public List<Propriedade> buscarUnidades(Long tenantId) {		
		return propriedadeDAO.buscarTodos(tenantId);
	}
	

}
