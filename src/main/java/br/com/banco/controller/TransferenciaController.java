package br.com.banco.controller;

import br.com.banco.dto.TransferenciaDTO;
import br.com.banco.dto.TransferenciaFiltro;
import br.com.banco.enums.TipoTransferencia;
import br.com.banco.service.TransferenciaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping(value = "/api/transferencias")
@RequiredArgsConstructor
public class TransferenciaController {

    private final TransferenciaService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<TransferenciaDTO>> listarPorFiltro(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicio,
                                                                 @RequestParam(required = false)  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFim,
                                                                 @RequestParam(required = false) Double valor,
                                                                 @RequestParam(required = false) TipoTransferencia tipoTransferencia,
                                                                 @RequestParam(required = false) String nomeOperadorTransacao,
                                                                 Pageable pageable) {
        var filtro = new TransferenciaFiltro(dataInicio, dataFim, valor, tipoTransferencia, nomeOperadorTransacao);
        log.info("Listando Transferências por filtro");
        return ResponseEntity.ok(service.listarPorFiltro(filtro, pageable));
    }
}
