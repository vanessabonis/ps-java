package br.com.banco.dto;

import br.com.banco.enums.TipoTransferencia;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class TransferenciaFiltro {

    public LocalDateTime dataInicio;
    public LocalDateTime dataFim;
    public Double valor;
    public TipoTransferencia tipoTransferencia;
    public String nomeOperadorTransacao;
}
