package com.fh.emprestimo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Cliente {
    private Integer idade;
    private String cpf;
    private String nome;
    private Double renda;
    private String localizacao;


    public boolean isRendaMenorIgualA(double valor) {
        return this.renda <= valor;
    }

    public boolean isRendaMaiorIgualA(double valor) {
        return this.renda >= valor;
    }

    public boolean isRendaEntre(double min, double max) {
        return this.renda >= min && this.renda<=max;
    }

    public boolean isIdadeMenorQue(int valor) {
        return this.idade < valor;
    }

    public boolean isClienteLocalizacao( String localizacao) {
        return this.localizacao.equals(localizacao);
    }

}
