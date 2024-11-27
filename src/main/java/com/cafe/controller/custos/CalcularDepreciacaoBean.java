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
import com.cafe.service.CalcularDepreciacaoService;
import com.cafe.service.DespesaMaquinaService;
import com.cafe.service.InstalacaoService;
import com.cafe.service.MaquinaService;
import com.cafe.service.TalhaoService;
import com.cafe.util.MessageUtil;
import com.cafe.controller.LoginBean;

import lombok.Getter;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Getter
@Setter
@Named
@ViewScoped
public class CalcularDepreciacaoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Maquina> maquinas;
    private List<Talhao> talhoes;
    private List<Instalacao> instalacoes;
    private List<DespesaMaquina> despesasMaquinas;
    private Unidade unidade;
    private DespesaMaquina despesaMaquinaSelecionada;
    private Maquina maquinaSelecionada;
    private Talhao talhao;
    private Instalacao instalacaoSelecionada;
    private List<BigDecimal> resultadosDepreciacaoMaquina;
    private List<BigDecimal> resultadosDepreciacaoInstalacao;

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

 
    public List<BigDecimal> calcularDepreciacaoMaquina() {
        try {
        	
        	log.info("Iniciando cálculo de depreciação maquina...");
            log.info("Máquina selecionada: " + maquinaSelecionada);
            log.info("Talhões selecionados: " + talhoes);
            log.info("Despesa Máquina: " + despesaMaquinaSelecionada);
            log.info("Unidade: " + unidade);

            if (maquinaSelecionada == null || talhoes == null || talhoes.isEmpty() || despesaMaquinaSelecionada == null || unidade == null) {
                MessageUtil.erro("Dados insuficientes para calcular a depreciação.");
                return null;
            }

            resultadosDepreciacaoMaquina= calcularDepreciacaoService.calcularDepreciacaoMaquina(maquinaSelecionada, talhoes, despesaMaquinaSelecionada, unidade);

            BigDecimal totalDepreciacao = resultadosDepreciacaoMaquina.get(resultadosDepreciacaoMaquina.size() - 1);
            MessageUtil.info("Cálculo realizado com sucesso!");
            MessageUtil.info("Soma total das depreciações: " + totalDepreciacao);

            
            for (int i = 0; i < resultadosDepreciacaoMaquina.size() - 1; i++) {
                log.info("Depreciação Talhão " + (i + 1) + ": " + resultadosDepreciacaoMaquina.get(i));
            }

            return resultadosDepreciacaoMaquina;

        } catch (Exception e) {
            log.error("Erro ao calcular a depreciação: ", e);
            MessageUtil.erro("Erro ao calcular a depreciação: " + e.getMessage());
            return null;
        }
    }
        
        public List<BigDecimal> calcularDepreciacaoInstalacao(){
        	try {
        	log.info("Iniciando cálculo de depreciação maquina...");
            log.info("Instalação selecionada: " + instalacaoSelecionada);
            log.info("Talhões selecionados: " + talhoes);
            log.info("Unidade: " + unidade);

            if (instalacaoSelecionada == null || talhoes == null || talhoes.isEmpty()  || unidade == null) {
                MessageUtil.erro("Dados insuficientes para calcular a depreciação.");
                return null;
            }
            
            resultadosDepreciacaoInstalacao = calcularDepreciacaoService.calcularDepreciacaoInstalacao(instalacaoSelecionada, unidade, talhoes);
            
            BigDecimal totalDepreciacao = resultadosDepreciacaoInstalacao.get(resultadosDepreciacaoInstalacao.size() - 1);
            MessageUtil.info("Cálculo realizado com sucesso!");
            MessageUtil.info("Soma total das depreciações: " + totalDepreciacao);
            
            for (int i = 0; i < resultadosDepreciacaoInstalacao.size() - 1; i++) {
                log.info("Depreciação Talhão " + (i + 1) + ": " + resultadosDepreciacaoInstalacao.get(i));
            }
            
            return resultadosDepreciacaoInstalacao;
        	
        } catch (Exception e) {
            log.error("Erro ao calcular a depreciação: ", e);
            MessageUtil.erro("Erro ao calcular a depreciação: " + e.getMessage());
            return null;
        }
    }


    
    
  
}