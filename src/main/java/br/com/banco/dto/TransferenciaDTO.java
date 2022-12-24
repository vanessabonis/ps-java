package br.com.banco.dto;

import br.com.banco.enums.TipoTransferencia;
import br.com.banco.model.Conta;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TransferenciaDTO {

    private Long id;
    private LocalDateTime dataTransferencia;
    private Double valor;
    private TipoTransferencia tipoTransferencia;
    private String nomeOperadorTransacao;
    private Conta conta;
}
