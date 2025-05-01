package com.fh.emprestimo.controllers;

import com.fh.emprestimo.controllers.dto.ClienteEmprestimoRequest;
import com.fh.emprestimo.controllers.dto.ClienteEmprestimoResponse;
import com.fh.emprestimo.service.EmprestimoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @PostMapping(value = "/cliente-emprestimo")
    public ResponseEntity<ClienteEmprestimoResponse> clienteEmprestimo(@RequestBody @Valid ClienteEmprestimoRequest request) {

        var emprestimoResponse = emprestimoService.checkDisponibilidadeEmprestimo(request);
        return ResponseEntity.ok(emprestimoResponse);
    }

}
