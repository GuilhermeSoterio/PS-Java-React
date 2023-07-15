package br.com.banco.http.controller;

import br.com.banco.http.dto.TransferenciaDTO;
import br.com.banco.http.dto.TransferenciaFilterDTO;
import br.com.banco.http.dto.TransferenciasComSaldoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(value = "/api/transacao", produces = APPLICATION_JSON_VALUE)
public interface ITransferenciaController {

    @PostMapping
    TransferenciasComSaldoDTO listAll(@RequestBody TransferenciaFilterDTO filter, Pageable page);
}
