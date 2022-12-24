package br.com.banco.controller;

import br.com.banco.dto.TransferenciaDTO;
import br.com.banco.dto.filtro.TransferenciaFiltro;
import br.com.banco.enums.TipoTransferencia;
import br.com.banco.service.ContaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping(value = "/api/conta")
@RequiredArgsConstructor
public class ContaController {

    private final ContaService service;

    @GetMapping(value = "/{idConta}/transferencias", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<TransferenciaDTO>> listarPorFiltro(@PathVariable Long idConta,
                                                                 @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicio,
                                                                 @RequestParam(required = false)  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFim,
                                                                 @RequestParam(required = false) Double valor,
                                                                 @RequestParam(required = false) TipoTransferencia tipoTransferencia,
                                                                 @RequestParam(required = false) String nomeOperadorTransacao,
                                                                 Pageable pageable) {
        var filtro = new TransferenciaFiltro(dataInicio, dataFim, valor, tipoTransferencia, nomeOperadorTransacao);
        log.info("Listando Transferências por filtro");
        return ResponseEntity.ok(service.listarPorContaAssociadaEfiltros(filtro, pageable, idConta));
    }
}
