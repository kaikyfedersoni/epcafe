package com.cafe.App;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.cafe.modelo.DespesaMaquina;
import com.cafe.modelo.Maquina;
import com.cafe.modelo.Talhao;
import com.cafe.modelo.Unidade;
import com.cafe.service.CalcularDepreciacaoService;

public class App{
public static void main(String[] args) {
	Maquina maquina = new Maquina();
	List<Talhao> talhoes = new ArrayList<>();
	Talhao talhaoA = new Talhao();
	talhoes.add(talhaoA);
	Talhao talhaoB = new Talhao();
	talhoes.add(talhaoB);
	Talhao talhaoC = new Talhao();
	talhoes.add(talhaoC);
	Talhao talhaoD = new Talhao();
	talhoes.add(talhaoD);
	Talhao talhaoE = new Talhao();
	talhoes.add(talhaoE);
	Talhao talhaoF = new Talhao();
	talhoes.add(talhaoF);
	CalcularDepreciacaoService calcD = new CalcularDepreciacaoService();
	DespesaMaquina despesaMaquina = new DespesaMaquina();
	Unidade unidade = new Unidade();
	unidade.setArea(new BigDecimal(7.99));
	talhaoA.setArea(new BigDecimal(0.75));
	talhaoB.setArea(new BigDecimal(1.1));
	talhaoC.setArea(new BigDecimal(0.45));
	talhaoD.setArea(new BigDecimal(1.9));
	talhaoE.setArea(new BigDecimal(2.9));
	talhaoF.setArea(new BigDecimal(0.89));
	
	maquina.setValor(new BigDecimal(120000));
	maquina.setValorResidual(new BigDecimal(20));
	despesaMaquina.setTempoTrabalhado(new BigDecimal(1400));
	
	List<BigDecimal> depreciacoes = calcD.calcularDepreciacaoMaquina(maquina,talhoes, despesaMaquina,unidade);
	
	System.out.println("Depreciações total:");
	 System.out.println(depreciacoes.get(0));
	System.out.println("Depreciações por talhão:");
    for (int i = 1; i < depreciacoes.size(); i++) {
        System.out.println("Talhão " + (i) + ": " + depreciacoes.get(i));
    }

    
	
	}
}