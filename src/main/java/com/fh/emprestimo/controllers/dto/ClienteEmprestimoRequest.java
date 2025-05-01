package com.fh.emprestimo.controllers.dto;

import com.fh.emprestimo.domain.Cliente;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record ClienteEmprestimoRequest(
        @Min(value = 18) @NotNull Integer idade,
        @NotBlank @CPF String cpf,
        @NotBlank String nome,
        @NotNull @Min(value = 1000) Double renda,
        @NotBlank String localizacao) {

    public Cliente toCliente() {
        return new Cliente(idade, cpf, nome, renda, localizacao);
    }
}
