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
    private Unidade unidade;
    private DespesaMaquina despesaMaquina;
    private Maquina maquinaSelecionada;
    private Talhao talhaoSelecionado;
    private Unidade unidadeSelecionada;
    private List<Instalacao> instalacoes;
    private Instalacao instalacaoSelecionada;
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
        instalacoes = instalacaoService.buscarInstalacoes(loginBean.getTenantId());
        
        limpar(); // Inicializa variáveis com valores padrão para evitar null pointers
    }

    public void limpar() {
        // Inicializa as variáveis para evitar NullPointerException
        maquinaSelecionada = new Maquina();
        talhaoSelecionado = new Talhao();
        unidadeSelecionada = new Unidade();
        despesaMaquina = new DespesaMaquina();
        instalacaoSelecionada = new Instalacao();
        valorDepreciacao = BigDecimal.ZERO;
    }

    public BigDecimal calcularDepreciacaoMaquina() {
        log.info("Calculando depreciação para a máquina: " + maquinaSelecionada);
        
        // Verifica se os parâmetros necessários não estão nulos
        if (maquinaSelecionada != null && talhaoSelecionado != null && unidadeSelecionada != null && despesaMaquina != null) {
            valorDepreciacao = calcularDepreciacaoService.calcularDepreciacaoMaquina(maquinaSelecionada, talhaoSelecionado, unidadeSelecionada, despesaMaquina);
            MessageUtil.sucesso("Depreciação calculada com sucesso: " + valorDepreciacao);
        } else {
            MessageUtil.erro("Não foi possível calcular a depreciação. Verifique os dados selecionados.");
        }

        return valorDepreciacao;
    }

    public void calcularDepreciacaoInstalacao() {
        log.info("Calculando depreciação para a instalação...");

        // Verifica se os parâmetros necessários não estão nulos
        if (instalacaoSelecionada != null && unidadeSelecionada != null && talhaoSelecionado != null) {
            valorDepreciacao = calcularDepreciacaoService.calcularDepreciacaoInstalacao(instalacaoSelecionada, unidadeSelecionada, talhaoSelecionado);
            MessageUtil.sucesso("Depreciação calculada com sucesso: " + valorDepreciacao);
        } else {
            MessageUtil.erro("Não foi possível calcular a depreciação da instalação. Verifique os dados selecionados.");
        }
    }
}
