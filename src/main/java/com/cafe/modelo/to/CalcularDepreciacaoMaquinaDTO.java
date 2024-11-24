package com.cafe.modelo.to;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CalcularDepreciacaoMaquinaDTO {
    private BigDecimal valorDoBem;
    private BigDecimal vidaUtil;
    private BigDecimal valorResidual;
    private BigDecimal area;
    private BigDecimal horasTrabalhadas;

}