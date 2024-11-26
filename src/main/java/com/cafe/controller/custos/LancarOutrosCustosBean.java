package com.cafe.controller.custos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.cafe.modelo.DespesaMaquina;
import com.cafe.modelo.Instalacao;
import com.cafe.modelo.Maquina;
import com.cafe.modelo.Unidade;

import com.cafe.service.DespesaMaquinaService;
import com.cafe.service.InstalacaoService;
import com.cafe.service.LancarOutrosCustosService;
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
public class LancarOutrosCustosBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Maquina> maquinas;
    private List<Instalacao> instalacoes;
    private List<DespesaMaquina> despesasMaquinas;
    private Unidade unidade;
    private DespesaMaquina despesaMaquinaSelecionada;
    private Maquina maquinaSelecionada;
    private Instalacao instalacaoSelecionada;
    private List<BigDecimal> resultadosManutencaoInstalacao;
    private List<BigDecimal> resultadosSeguroMaquina;

    @Inject
    private MaquinaService maquinaService;

    @Inject
    private LoginBean loginBean;

    @Inject
    private TalhaoService talhaoService;

    @Inject
    private InstalacaoService instalacaoService;

    @Inject
    private DespesaMaquinaService despesaMaquinaService;
    
    @Inject
    private LancarOutrosCustosService lancarOutrosCustosService;

    @PostConstruct
    public void inicializar() {
        log.info("Inicializando LancarOutrosCustosBean...");
        maquinas = maquinaService.buscarMaquinasAlfabetico(loginBean.getTenantId());
        unidade = loginBean.getUsuario().getUnidade();
        despesasMaquinas = despesaMaquinaService.buscarDespesasMaquinas(unidade);
        instalacoes = instalacaoService.buscarInstalacoes(loginBean.getTenantId());
        resultadosManutencaoInstalacao = calcularManutencaoParaTodasInstalacoes();
        resultadosSeguroMaquina = calcularSeguroParaTodasMaquinas();
      
    }

    public List<BigDecimal> calcularManutencaoParaTodasInstalacoes() {
        try {
            
            List<BigDecimal> resultados = new ArrayList<>();
            for (Instalacao instalacao : instalacoes) {
                BigDecimal resultado = lancarOutrosCustosService.calcularManutencaoInstalacao(instalacao, unidade);
                resultados.add(resultado);
            }

            log.info("Cálculo de manutenção de instalações concluído.");
            return resultados;
        } catch (Exception e) {
            log.error("Erro ao calcular a manutenção das instalações: ", e);
            MessageUtil.erro("Erro ao calcular a manutenção das instalações: " + e.getMessage());
            return Collections.emptyList();
        }
    }
        
    public List<BigDecimal> calcularSeguroParaTodasMaquinas() {
        try {
            
            List<BigDecimal> resultados = new ArrayList<>();
            
            for (Maquina maquina : maquinas) {
                for (DespesaMaquina despesa : despesasMaquinas) {
                    if (despesa.getMaquina().equals(maquina)) {
                        BigDecimal resultado = lancarOutrosCustosService.calcularSeguroEquipamento(maquina, despesa);
                        resultados.add(resultado);
                    }
                }
            }

            log.info("Cálculo de seguro de máquinas concluído.");
            return resultados;
        } catch (Exception e) {
            log.error("Erro ao calcular o seguro das máquinas: ", e);
            MessageUtil.erro("Erro ao calcular o seguro das máquinas: " + e.getMessage());
            return Collections.emptyList();
        }
    }
         
}
