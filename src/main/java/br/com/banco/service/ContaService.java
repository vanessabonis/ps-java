package br.com.banco.service;

import br.com.banco.dto.TransferenciaDTO;
import br.com.banco.dto.filtro.TransferenciaFiltro;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContaService {

    private final TransferenciaService transferenciaService;

    public Page<TransferenciaDTO> listarPorContaAssociadaEfiltros(TransferenciaFiltro filtro, Pageable pageable, Long idConta) {
        return transferenciaService.listarPorContaAssociadaEfiltros(filtro, pageable, idConta);
    }
}
