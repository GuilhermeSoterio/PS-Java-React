package br.com.banco.http.dto;

import br.com.banco.entity.Transferencia;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
public class TransferenciasComSaldoDTO {
    private Page<TransferenciaDTO> transferencias;
    private BigDecimal saldoTotal;
    private BigDecimal saldoTotalPeriodo;

    public TransferenciasComSaldoDTO(Page<TransferenciaDTO> transferencias, BigDecimal saldoTotal, BigDecimal saldoTotalPeriodo) {
        this.transferencias = transferencias;
        this.saldoTotal = saldoTotal;
        this.saldoTotalPeriodo = saldoTotalPeriodo;
    }
}
