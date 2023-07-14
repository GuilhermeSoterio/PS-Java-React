package br.com.banco.http.controller.impl;


import br.com.banco.http.controller.ITransferenciaController;
import br.com.banco.http.dto.TransferenciaDTO;
import br.com.banco.http.dto.TransferenciaFilterDTO;
import br.com.banco.service.TransferenciaService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TransferenciaController implements ITransferenciaController {

    private final TransferenciaService transferenciaService;

    @Override
    public Page<TransferenciaDTO> listAll(TransferenciaFilterDTO filter, Pageable page) {
        return transferenciaService.findAll(filter, page);
    }
}
