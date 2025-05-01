package com.fh.emprestimo.Exceptions;

import com.fh.emprestimo.domain.EmprestimoType;

/**
 * Exceção lançada quando um empréstimo não está disponível para ser realizado.
 */
public class EmprestimoNaoDisponivelException extends RuntimeException {

    public EmprestimoNaoDisponivelException() {
        super("Empréstimo não disponível.");
    }

    public EmprestimoNaoDisponivelException(EmprestimoType emprestimoType) {
        super("Empréstimo "+emprestimoType.getDescricao()+" não disponível.");
    }

    public EmprestimoNaoDisponivelException(String mensagem) {
        super(mensagem);
    }

    public EmprestimoNaoDisponivelException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

    public EmprestimoNaoDisponivelException(Throwable causa) {
        super(causa);
    }
}
