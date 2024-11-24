package com.cafe.modelo;

import java.io.Serializable;
import java.time.OffsetDateTime;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.List;


import com.cafe.modelo.enums.TipoPropriedade;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author murakamiadmin
 *
 */
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Entity
@NamedQueries({
	@NamedQuery(name="Unidade.buscarTodos", query="select u from Unidade u where u.tenant_id = :tenantId"),	
	@NamedQuery(name="Unidade.buscarNomesUnidades", query="select u.nome from Unidade u where u.tenant_id = :tenantId")	
})
public class Unidade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5526059262907035239L;
	
	@EqualsAndHashCode.Include
	@ToString.Include
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	
	private Long tenant_id;
	
	@NotBlank(message="O nome da unidade é obrigatório.")
	private String nome;
	
	private String contato;
	
	@Enumerated(EnumType.STRING)
	private TipoPropriedade tipo;	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codigo_endereco")
	private Endereco endereco;

	@OneToMany(mappedBy = "unidade", cascade = CascadeType.ALL)
	private List<Talhao> talhoes;

	private BigDecimal area;
	
	
	public BigDecimal getArea() {
		return area;
	}
	
	public void setArea(BigDecimal area) {
		this.area = area;
		
	}
	
	public void setTenant_id(Long tenant_id) {
		this.tenant_id = tenant_id;
	}
	
	public Long getTenant_id() {
		return tenant_id;
	}
	
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	
	public void setContato(String contato) {
		this.contato = contato;
	}
	
	public String getContato() {
		return contato;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setTipo(TipoPropriedade tipo) {
		this.tipo = tipo;
	}
	
	public TipoPropriedade getTipo() {
		return tipo;
	}
	
	public void setTalhoes(List<Talhao> talhoes) {
		this.talhoes = talhoes;
	}
	public List<Talhao> getTalhoes(){
		return talhoes;
	}
	/*
	 * Datas de Criação e Modificação
	 */
	
	@CreationTimestamp	
	@Column(columnDefinition = "datetime")
	private OffsetDateTime dataCriacao;
	
	@UpdateTimestamp
	@Column(columnDefinition = "datetime")
	private OffsetDateTime dataModificacao;
}
