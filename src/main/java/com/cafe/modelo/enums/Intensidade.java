package com.cafe.modelo.enums;

/**
 * @author murakamiadmin
 *
 */
public enum Intensidade {
	A_100(100),
	A_90(90),
	A_80(80),
	ALTA_75(75),
	M_70(70),
	M_60(60),
	MEDIA_55(55),
	M_50(50),
	BAIXA_40(40),
	B_30(30),
	B_20(20),
	B_10(10);
	
	
	private final int valor;
	 
    private Intensidade(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return this.valor;
    }
}
