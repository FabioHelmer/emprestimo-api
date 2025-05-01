package com.fh.emprestimo.factory;

import com.fh.emprestimo.domain.Cliente;

public class ClienteFactory {

    public static Cliente builder() {
        return Cliente.builder()
                .idade(25)
                .cpf("123.456.789-00")
                .nome("Nome Sobrenome")
                .renda(5000.00)
                .localizacao("ES")
                .build();
    }

    public static Cliente builder(int idade) {
        return Cliente.builder()
                .idade(idade)
                .cpf("123.456.789-00")
                .nome("Nome Sobrenome")
                .renda(5000.00)
                .localizacao("ES")
                .build();
    }

    public static Cliente builder(String local) {
        return Cliente.builder()
                .idade(25)
                .cpf("123.456.789-00")
                .nome("Nome Sobrenome")
                .renda(5000.00)
                .localizacao(local)
                .build();
    }

    public static Cliente builder(Double renda) {
        return Cliente.builder()
                .idade(25)
                .cpf("123.456.789-00")
                .nome("Nome Sobrenome")
                .renda(renda)
                .localizacao("ES")
                .build();
    }

}
