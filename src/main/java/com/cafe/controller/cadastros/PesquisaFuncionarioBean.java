package com.cafe.controller.cadastros;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.cafe.controller.LoginBean;
import com.cafe.modelo.Formacao;
import com.cafe.modelo.Funcionario;
import com.cafe.service.FuncionarioService;
import com.cafe.util.MessageUtil;
import com.cafe.util.NegocioException;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;


/**
 * @author isabella
 *
 */
@Getter
@Setter
@Named
@ViewScoped
@Log4j2
public class PesquisaFuncionarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Funcionario> funcionarios = new ArrayList<>();
	private Funcionario funcionarioSelecionado;
	private Formacao formacaoSelecionada;
		
	@Inject
	private FuncionarioService funcionarioService;
	@Inject
	private LoginBean loginBean;

		
	@PostConstruct
	public void inicializar() {
		funcionarios = funcionarioService.buscarFuncionariosPorUnidade(loginBean.getUsuario().getUnidade() ,loginBean.getTenantId());
		
	}
	
	public void excluir() {
		try {
			funcionarioService.excluir(funcionarioSelecionado);			
			this.funcionarios.remove(funcionarioSelecionado);
			MessageUtil.sucesso("Funcionário " + funcionarioSelecionado.getNome() + " excluído com sucesso.");
		} catch (NegocioException e) {
			e.printStackTrace();
			MessageUtil.erro(e.getMessage());
		}
	}
	
	
	public StreamedContent getImage() {
		log.info("getImageBd... = ");
	
		StreamedContent file;
		
		InputStream in = new ByteArrayInputStream(this.formacaoSelecionada.getImagem());
		        
        file = DefaultStreamedContent.builder()
                .stream(() -> in)
                .build(); 

        return file;
	}
	
	
}