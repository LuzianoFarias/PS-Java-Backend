package br.com.banco.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import br.com.banco.entity.Transferencia;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
    List<Transferencia> findByDataTransferenciaBetween(LocalDateTime startDate, LocalDateTime endDate);
    List<Transferencia> findByNomeOperadorTransacao(String nomeOperadorTransacao);
    List<Transferencia> findByDataTransferenciaBetweenAndNomeOperadorTransacao(LocalDate startDate, LocalDate endDate, String nomeOperadorTransacao);
    List<Transferencia> findByNomeOperadorTransacaoAndDataTransferenciaBetween(String nomeOperadorTransacao,
            LocalDateTime startDate, LocalDateTime endDate);


}