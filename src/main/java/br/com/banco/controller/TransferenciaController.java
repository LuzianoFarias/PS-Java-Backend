package br.com.banco.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.entity.Transferencia;
import br.com.banco.service.TransferenciaService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/transferencias")
public class TransferenciaController {
    @Autowired
    private TransferenciaService transferenciaService;

    @GetMapping
    public List<Transferencia> getAllTransferencias() {
        return transferenciaService.getAllTransferencias();
    }


    @GetMapping("/data")
    public List<Transferencia> getTransferenciasByDataTransferenciaRange(
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ssX") LocalDateTime startDate,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ssX") LocalDateTime endDate) {
        if (startDate != null && endDate != null) {
            return transferenciaService.getTransferenciasByDataTransferenciaRange(startDate, endDate);
        } else {
            return transferenciaService.getAllTransferencias();
        }
  }


    @GetMapping("/operador/{nomeOperadorTransacao}")
    public List<Transferencia> getTransferenciasBynomeOperadorTransacao(@PathVariable String nomeOperadorTransacao) {
        return transferenciaService.getTransferenciasByNomeOperadorTransacao(nomeOperadorTransacao);
    }

    @GetMapping("/{nomeOperadorTransacao}/data")
    public List<Transferencia> getTransferenciasBynomeOperadorTransacaoAndDataTransferenciaRange(
            @PathVariable String nomeOperadorTransacao,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ssX") LocalDateTime startDate,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ssX") LocalDateTime endDate) {
        if (startDate != null && endDate != null) {
            return transferenciaService.getTransferenciasByNomeOperadorTransacaoAndDataTransferenciaRange(nomeOperadorTransacao, startDate, endDate);
        } else {
            return transferenciaService.getTransferenciasByNomeOperadorTransacao(nomeOperadorTransacao);
        }
    }
}