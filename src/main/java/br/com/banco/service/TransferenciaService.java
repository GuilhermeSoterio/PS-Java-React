package br.com.banco.service;

import br.com.banco.entity.Transferencia;
import br.com.banco.http.dto.TransferenciaDTO;
import br.com.banco.http.dto.TransferenciaFilterDTO;
import br.com.banco.http.dto.TransferenciasComSaldoDTO;
import br.com.banco.repository.TransferenciaRepository;
import br.com.banco.service.specifications.TransferenciaSpecification;
import br.com.banco.utils.SaldoUtils;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Service
public class TransferenciaService {

    private final TransferenciaRepository repository;

    private final TransferenciaSpecification transferenciaSpecification;

    public TransferenciasComSaldoDTO findAll(TransferenciaFilterDTO filter, Pageable pageable) {
        Page<Transferencia> transferenciasPage = repository.findAll(transferenciaSpecification.getTransferencia(filter),
                pageable);

        BigDecimal saldoTotal = SaldoUtils.calcularSaldoTotal(repository.findAll());
        BigDecimal saldoTotalPeriodo = SaldoUtils.calcularSaldoTotalPeriodo(transferenciasPage.getContent());

        return TransferenciasComSaldoDTO.builder().transferencias(transferenciasPage.map(TransferenciaDTO::new))
                .saldoTotal(saldoTotal)
                .saldoTotalPeriodo(saldoTotalPeriodo)
                .build();
    }
}
