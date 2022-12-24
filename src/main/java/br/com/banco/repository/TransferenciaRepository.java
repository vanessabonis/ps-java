package br.com.banco.repository;

import br.com.banco.dto.TransferenciaDTO;
import br.com.banco.dto.TransferenciaFiltro;
import br.com.banco.model.Transferencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

    @Query("SELECT NEW br.com.banco.dto.TransferenciaDTO(t.id, t.dataTransferencia, t.valor, t.tipoTransferencia, t.nomeOperadorTransacao, c.idConta) " +
        "FROM Transferencia t JOIN t.conta c " +
        "WHERE " +
        "(:#{#filtro.dataInicio} IS NULL OR t.dataTransferencia >= :#{#filtro.dataInicio}) AND " +
        "(:#{#filtro.dataFim} IS NULL OR t.dataTransferencia <= :#{#filtro.dataFim}) AND " +
        "(:#{#filtro.valor} IS NULL OR t.valor = :#{#filtro.valor}) AND " +
        "(:#{#filtro.tipoTransferencia} IS NULL OR t.tipoTransferencia = :#{#filtro.tipoTransferencia}) AND " +
        "(:#{#filtro.nomeOperadorTransacao} IS NULL OR t.nomeOperadorTransacao LIKE %:#{#filtro.nomeOperadorTransacao}%)")
    Page<TransferenciaDTO> findByFilter(@Param("filtro") TransferenciaFiltro filtro, Pageable page);
}
