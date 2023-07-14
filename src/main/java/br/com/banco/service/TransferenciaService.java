package br.com.banco.service;

import br.com.banco.entity.Transferencia;
import br.com.banco.http.dto.TransferenciaDTO;
import br.com.banco.http.dto.TransferenciaFilterDTO;
import br.com.banco.repository.TransferenciaRepository;
import br.com.banco.service.specifications.TransferenciaSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TransferenciaService {

    private final TransferenciaRepository repository;

    private final TransferenciaSpecification transferenciaSpecification;

    public Page<TransferenciaDTO> findAll(TransferenciaFilterDTO filter, Pageable pageable) {
        Page<Transferencia> transferenciasPage = repository.findAll(transferenciaSpecification.getTransferencia(filter),
                pageable);

        return transferenciasPage.map(TransferenciaDTO::new);
    }
}
