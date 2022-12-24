package br.com.banco.service;

import br.com.banco.dto.TransferenciaDTO;
import br.com.banco.dto.TransferenciaFiltro;
import br.com.banco.repository.TransferenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferenciaService {

    private final TransferenciaRepository repository;

    public Page<TransferenciaDTO> listarPorFiltro(TransferenciaFiltro filtro, Pageable pageable) {
        return repository.findByFilter(filtro, pageable);
    }
}
