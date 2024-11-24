package com.cafe.controller.custos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.cafe.modelo.DespesaMaquina;
import com.cafe.modelo.Instalacao;
import com.cafe.modelo.Maquina;
import com.cafe.modelo.Talhao;
import com.cafe.modelo.Unidade;
import com.cafe.modelo.to.CalcularDepreciacaoMaquinaDTO;
import com.cafe.service.CalcularDepreciacaoService;
import com.cafe.service.DespesaMaquinaService;
import com.cafe.service.InstalacaoService;
import com.cafe.service.MaquinaService;
import com.cafe.service.TalhaoService;
import com.cafe.util.MessageUtil;
import com.cafe.controller.LoginBean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Getter
@Setter
@NoArgsConstructor
@Named
@ViewScoped
public class CalcularDepreciacaoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Maquina> maquinas;
    private List<Talhao> talhoes;
    private List<Instalacao> instalacoes;
    private List<DespesaMaquina> despesasMaquinas;
    private Unidade unidade;
    private DespesaMaquina despesaMaquina;
    private Maquina maquina;
    private Talhao talhao;
    private Instalacao instalacao;
    private BigDecimal valorDepreciacao;

    @Inject
    private MaquinaService maquinaService;

    @Inject
    private LoginBean loginBean;

    @Inject
    private TalhaoService talhaoService;

    @Inject
    private InstalacaoService instalacaoService;

    @Inject
    private CalcularDepreciacaoService calcularDepreciacaoService;

    @Inject
    private DespesaMaquinaService despesaMaquinaService;

    @PostConstruct
    public void inicializar() {
        log.info("Inicializando CalcularDepreciacaoBean...");
        maquinas = maquinaService.buscarMaquinasAlfabetico(loginBean.getTenantId());
        talhoes = talhaoService.buscarTalhoes(loginBean.getTenantId()); 
        unidade = loginBean.getUsuario().getUnidade();
        despesasMaquinas = despesaMaquinaService.buscarDespesasMaquinas(unidade);
        instalacoes = instalacaoService.buscarInstalacoes(loginBean.getTenantId());
        

    }

 
    public BigDecimal calcularDepreciacaoMaquina() {
  
    	log.info("Máquina: " + maquina);
    	log.info("Talhão: " + talhoes);
    	log.info("Despesa Máquina: " + despesaMaquina);
    	log.info("Unidade: " + unidade);
    	log.info("Calculando depreciação para a máquina: " + maquina);
    	 
    //	 valorDepreciacao = calcularDepreciacaoService.calcularDepreciacaoMaquina(this.maquina, this.talhoes, this.despesaMaquina, this.unidade);
    	    return valorDepreciacao;
    }

    public void calcularDepreciacaoInstalacao() {
        log.info("Calculando depreciação para a instalação...");
            valorDepreciacao = calcularDepreciacaoService.calcularDepreciacaoInstalacao(instalacao, unidade, talhao);
            MessageUtil.sucesso("Depreciação calculada com sucesso: " + valorDepreciacao);
       
    }
    
  
}
