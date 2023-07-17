package br.com.banco.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.entity.Transferencia;
import br.com.banco.repository.TransferenciaRepository;

@Service
public class TransferenciaService {
    @Autowired
    private TransferenciaRepository transferenciaRepository;

    public List<Transferencia> getAllTransferencias() {
        return transferenciaRepository.findAll();
    }

    public List<Transferencia> getTransferenciasByDataTransferenciaRange(LocalDateTime startDate, LocalDateTime endDate) {
        return transferenciaRepository.findByDataTransferenciaBetween(startDate, endDate);
    }

    public List<Transferencia> getTransferenciasByNomeOperadorTransacao(String nomeOperadorTransacao) {
        return transferenciaRepository.findByNomeOperadorTransacao(nomeOperadorTransacao);
    }

    public List<Transferencia> getTransferenciasByNomeOperadorTransacaoAndDataTransferenciaRange(String nomeOperadorTransacao, LocalDateTime startDate, LocalDateTime endDate) {
        return transferenciaRepository.findByNomeOperadorTransacaoAndDataTransferenciaBetween(nomeOperadorTransacao, startDate, endDate);
    }

}
