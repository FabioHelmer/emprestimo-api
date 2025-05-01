package com.fh.emprestimo.domain;

import com.fh.emprestimo.Exceptions.EmprestimoNaoDisponivelException;
import lombok.Data;

@Data
public class Emprestimo {

    private Cliente cliente;

    public Emprestimo(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isEmprestimoPessoalDisponivel() {
        return validacaoBasicaEmprestimo();
    }

    public boolean isEmprestimoConsignadoDisponivel() {
        return cliente.isRendaMaiorIgualA(5000.0);
    }

    public boolean isEmprestimoGarantiaDisponivel() {
        return validacaoBasicaEmprestimo();
    }

    private boolean validacaoBasicaEmprestimo() {
        if (cliente.isRendaMenorIgualA(3000.0)) {
            return true;
        }

        return cliente.isRendaEntre(3000, 5000)
                && cliente.isIdadeMenorQue(30)
                && cliente.isClienteLocalizacao("SP");
    }


    public double getTaxaJurosEmprestimoPessoal() {
        EmprestimoType pessoalType = EmprestimoType.PESSOAL;

        if (isEmprestimoPessoalDisponivel()) {
            return pessoalType.getTaxaJuros();
        }
        throw new EmprestimoNaoDisponivelException(pessoalType);
    }

    public double getTaxaJurosEmprestimoConsignado() {
        EmprestimoType consignadoType = EmprestimoType.CONSIGNADO;

        if (isEmprestimoConsignadoDisponivel()) {
            return consignadoType.getTaxaJuros();
        }
        throw new EmprestimoNaoDisponivelException(consignadoType);
    }

    public double getTaxaJurosEmprestimoGarantia() {
        EmprestimoType garantiaType = EmprestimoType.GARANTIA;

        if (isEmprestimoGarantiaDisponivel()) {
            return garantiaType.getTaxaJuros();
        }
        throw new EmprestimoNaoDisponivelException(garantiaType);
    }


}
