package br.com.banco.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.entity.Conta;
import br.com.banco.service.ContaService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/contas")
public class ContaController {
    private final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @GetMapping
    public List<Conta> getAllContas() {
        return contaService.getAllContas();
    }
}