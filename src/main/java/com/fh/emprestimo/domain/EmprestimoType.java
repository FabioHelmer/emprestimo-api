package com.fh.emprestimo.domain;

public enum EmprestimoType {


    PESSOAL("Pessoal", 4.0),
    GARANTIA("Garantia",3.0),
    CONSIGNADO("Consignado", 2.0);

    private final String descricao;
    private final double taxaJuros;

    EmprestimoType(String descricao, double taxaJuros) {
        this.descricao = descricao;
        this.taxaJuros = taxaJuros;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

}
