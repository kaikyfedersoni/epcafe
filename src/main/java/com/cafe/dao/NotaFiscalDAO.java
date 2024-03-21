package com.cafe.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.cafe.modelo.Item;
import com.cafe.modelo.NotaFiscal;
import com.cafe.util.NegocioException;
import com.cafe.util.jpa.Transactional;

import lombok.extern.log4j.Log4j;

@Log4j
public class NotaFiscalDAO implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	@Transactional
	public NotaFiscal salvar(NotaFiscal notaFiscal) throws PersistenceException, NegocioException {
		try {	
			
			return manager.merge(notaFiscal);			
		
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw e;
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new NegocioException("Não foi possível executar a operação.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException("Não foi possível executar a operação.");
		} catch (Error e) {
			e.printStackTrace();
			throw new NegocioException("Não foi possível executar a operação.");
		}		
	}
	@Transactional
	public void atualizarNota(NotaFiscal notaFiscal) throws PersistenceException, NegocioException {
		// garatir que uma nf so é gravada se tiver itens
		salvarItens(notaFiscal, notaFiscal.getItens());	
	}
	private void salvarItens(NotaFiscal notaFiscal, List<Item> itens) throws PersistenceException, NegocioException {
		try {
			if(!itens.isEmpty() && itens != null) {
				for(Item item : itens) {
					log.info("gravando item -> " + item.getFertilizante().getTipo());
					log.info("gravando item nf id -> " + notaFiscal.getId());
					item.setNotaFiscal(notaFiscal);
					manager.merge(item);
				}
			}					
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw e;
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new NegocioException("Não foi possível executar a operação.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException("Não foi possível executar a operação.");
		} catch (Error e) {
			e.printStackTrace();
			throw new NegocioException("Não foi possível executar a operação.");
		}		
	}	
		
	@Transactional
	public void excluir(NotaFiscal notaFiscal) throws NegocioException {
			
		try {
			NotaFiscal m = this.buscarNotaFiscalPeloCodigo(notaFiscal.getId());
			manager.remove(m);
			manager.flush();
		} catch (PersistenceException e) {			
			e.printStackTrace();
			throw new NegocioException("Não foi possível executar a operação.");
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new NegocioException("Não foi possível executar a operação.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException("Não foi possível executar a operação.");
		} catch (Error e) {
			e.printStackTrace();
			throw new NegocioException("Não foi possível executar a operação.");
		}
	}
	
	
	/*
	 * Buscas
	 */
	
	public NotaFiscal buscarNotaFiscalPeloCodigo(Long id) {
		return manager.find(NotaFiscal.class, id);
	}
	
	public Item buscarItemPeloCodigo(Long id) {
		return manager.find(Item.class, id);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<NotaFiscal> buscarNotasFiscais(Long tenantId) {
		return manager.createNamedQuery("NotaFiscal.buscarNotasFiscais")
				.setParameter("tenantId", tenantId)
				.getResultList();
	}
	
	public NotaFiscal buscarNotaFiscalPorNumero(String numero, Long tenantId) {
		return manager.createNamedQuery("NotaFiscal.buscarNotaFiscalPorNumero", NotaFiscal.class)
				.setParameter("numero", numero)
				.setParameter("tenantId", tenantId)
				.getSingleResult();
	}
	
}
