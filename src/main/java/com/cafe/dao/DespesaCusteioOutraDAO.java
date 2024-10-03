package com.cafe.dao;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.cafe.modelo.DespesaCusteioOutra;
import com.cafe.modelo.Unidade;
import com.cafe.modelo.to.OutrasDespesasDTO;
import com.cafe.util.NegocioException;
import com.cafe.util.jpa.Transactional;

import lombok.extern.log4j.Log4j;

@Log4j
public class DespesaCusteioOutraDAO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	@Transactional
	public DespesaCusteioOutra salvar(DespesaCusteioOutra despesaCusteioOutra)
			throws PersistenceException, NegocioException {
		try {
			return manager.merge(despesaCusteioOutra);
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
	public void excluir(DespesaCusteioOutra despesaCusteioOutra) throws NegocioException {

		try {
			log.info("excluir dao");
			DespesaCusteioOutra m = this.buscarPeloCodigo(despesaCusteioOutra.getId());
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
	
	public DespesaCusteioOutra buscarPeloCodigo(Long id) {
		return manager.find(DespesaCusteioOutra.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<DespesaCusteioOutra> buscarDespesasOutrasDespesas(Unidade unidade) {
		return manager.createNamedQuery("DespesaCusteioOutra.buscarDespesasOutrasDespesas")
				.setParameter("codigo_unidade", unidade).getResultList();
	}
	
	public List<DespesaCusteioOutra> buscarOutrasDespesasPorAnoAgricola(
			LocalDate dataInicio, 
			LocalDate dataFim, 
			Unidade unidade
			){
		return manager.createQuery(
				"SELECT d FROM DespesaCusteioOutra d "
				+ "WHERE d.data "
				+ "BETWEEN :dataInicio AND :dataFim "
				+ "AND d.unidade = :codigo_unidade "
				+ "ORDER BY d.data", DespesaCusteioOutra.class)
				.setParameter("dataInicio", dataInicio)
				.setParameter("dataFim", dataFim)
				.setParameter("codigo_unidade", unidade)
				.getResultList();
	}
	
	/*
	 * RELATORIO OUTRAS DESPESAS
	 */
	
	
	
	public List<String> buscarAnosComRegistro (Unidade unidade) {
		
		log.info("Buscando anos com registro outras despesas");
		List<String> anos = manager.createQuery(
				"SELECT DISTINCT " +
						"CASE " +
						"  WHEN FUNCTION('MONTH', c.data) >= 8 THEN CONCAT(FUNCTION('YEAR', c.data), '/', FUNCTION('YEAR', c.data) + 1) " +
						"  ELSE CONCAT(FUNCTION('YEAR', c.data) - 1, '/', FUNCTION('YEAR', c.data)) " +
						"END " +
						"FROM DespesaCusteioOutra c " +
						"WHERE c.eCusteio = false " +
						"ORDER BY " +
						"CASE " +
						"  WHEN FUNCTION('MONTH', c.data) >= 8 THEN CONCAT(FUNCTION('YEAR', c.data), '/', FUNCTION('YEAR', c.data) + 1) " +
						"  ELSE CONCAT(FUNCTION('YEAR', c.data) - 1, '/', FUNCTION('YEAR', c.data)) " +
						"END", String.class).getResultList();
		
		log.info("Lista anos size: " + anos.size());
		return anos;
	}
	
	public List<OutrasDespesasDTO> buscarDespesasDTO(LocalDate dataInicio, LocalDate dataFim, Unidade unidade){
		
		List<OutrasDespesasDTO> lista = manager.createQuery(
				"SELECT new com.cafe.modelo.to.OutrasDespesasDTO( "
				+ "d.data, "
				+ "d.valorTotal, "
				+ "d.tipo) "
			+ "FROM DespesaCusteioOutra d "
			+ "WHERE "
			+ " d.eCusteio = false "
			+ " and d.data BETWEEN :dataInicio AND :dataFim "
			+ " and d.unidade = :unidade "
			+ " ORDER BY d.tipo"
				, OutrasDespesasDTO.class)
				.setParameter("dataInicio", dataInicio)
				.setParameter("dataFim", dataFim)
				.setParameter("unidade", unidade)
				.getResultList();
		
		return lista;
	}
	
	/*
	 * RELATORIO OUTRAS DESPESAS CUSTEIO
	 */
	
	
	public List<String> buscarAnosComRegistroCusteio (Unidade unidade) {
		
		List<String> anos = manager.createQuery(
				"SELECT DISTINCT " +
						"CASE " +
						"  WHEN FUNCTION('MONTH', c.data) >= 8 THEN CONCAT(FUNCTION('YEAR', c.data), '/', FUNCTION('YEAR', c.data) + 1) " +
						"  ELSE CONCAT(FUNCTION('YEAR', c.data) - 1, '/', FUNCTION('YEAR', c.data)) " +
						"END " +
						"FROM DespesaCusteioOutra c " +
						"WHERE c.eCusteio = true " +
						"ORDER BY " +
						"CASE " +
						"  WHEN FUNCTION('MONTH', c.data) >= 8 THEN CONCAT(FUNCTION('YEAR', c.data), '/', FUNCTION('YEAR', c.data) + 1) " +
						"  ELSE CONCAT(FUNCTION('YEAR', c.data) - 1, '/', FUNCTION('YEAR', c.data)) " +
						"END", String.class).getResultList();
		
		log.info("Lista anos size: " + anos.size());
		return anos;
	}
	
	public List<OutrasDespesasDTO> buscarDespesasDTOCusteio(LocalDate dataInicio, LocalDate dataFim, Unidade unidade){
		
		List<OutrasDespesasDTO> lista = manager.createQuery(
				"SELECT new com.cafe.modelo.to.OutrasDespesasDTO( "
				+ "d.data, "
				+ "d.valorTotal, "
				+ "d.tipo) "
			+ "FROM DespesaCusteioOutra d "
			+ "WHERE "
			+ " d.eCusteio = true "
			+ " and d.data BETWEEN :dataInicio AND :dataFim "
			+ " and d.unidade = :unidade "
			+ " ORDER BY d.tipo"
				, OutrasDespesasDTO.class)
				.setParameter("dataInicio", dataInicio)
				.setParameter("dataFim", dataFim)
				.setParameter("unidade", unidade)
				.getResultList();
		
		return lista;
	}
	

}
