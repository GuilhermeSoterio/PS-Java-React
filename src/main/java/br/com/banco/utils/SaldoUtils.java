package br.com.banco.utils;

import br.com.banco.entity.Transferencia;

import java.math.BigDecimal;
import java.util.List;

public class SaldoUtils {
    public static BigDecimal calcularSaldoTotal(List<Transferencia> transferenciaList) {
        return transferenciaList.stream()
                .map(transferencia -> new BigDecimal(transferencia.getValor()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static BigDecimal calcularSaldoTotalPeriodo(List<Transferencia> transferenciaList) {
        BigDecimal saldoTotalPeriodo = BigDecimal.ZERO;
        for (Transferencia transferencia : transferenciaList) {
            saldoTotalPeriodo = saldoTotalPeriodo.add(new BigDecimal(transferencia.getValor()));
        }
        return saldoTotalPeriodo;
    }
}
