package com.fh.emprestimo.domain;

import com.fh.emprestimo.Exceptions.EmprestimoNaoDisponivelException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Nested;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class EmprestimoTest {

    @Mock
    private Cliente cliente;

    @InjectMocks
    private Emprestimo emprestimo;

    @Nested
    class emprestimoPessoalDisponivel {

        @Test
        void deveEstarDisponivelQuandoRendaForIgualOuMenorQue3k() {

            doReturn(true).when(cliente).isRendaMenorIgualA(3000.0);

            assertTrue(emprestimo.isEmprestimoPessoalDisponivel());
        }

        @Test
        void deveEstarDisponivelQuandoRendaEstiverEntre3kE5kEIdadeForMenorQue30ELocalForSP() {

            doReturn(false).when(cliente).isRendaMenorIgualA(3000.0);
            doReturn(true).when(cliente).isRendaEntre(3000.0, 5000.0);
            doReturn(true).when(cliente).isIdadeMenorQue(30);
            doReturn(true).when(cliente).isClienteLocalizacao("SP");

            assertTrue(emprestimo.isEmprestimoPessoalDisponivel());
        }
    }

    @Nested
    class emprestimoGarantidoDisponivel {

        @Test
        void deveEstarDisponivelQuandoRendaForIgualOuMenorQue3k() {

            doReturn(true).when(cliente).isRendaMenorIgualA(3000.0);

            assertTrue(emprestimo.isEmprestimoGarantiaDisponivel());
        }

        @Test
        void deveEstarDisponivelQuandoRendaEstiverEntre3kE5kEIdadeForMenorQue30ELocalForSP() {

            doReturn(false).when(cliente).isRendaMenorIgualA(3000.0);
            doReturn(true).when(cliente).isRendaEntre(3000.0, 5000.0);
            doReturn(true).when(cliente).isIdadeMenorQue(30);
            doReturn(true).when(cliente).isClienteLocalizacao("SP");

            assertTrue(emprestimo.isEmprestimoGarantiaDisponivel());
        }
    }

    @Nested
    class emprestimoConsignadoDisponivel {

        @Test
        void deveEstarDisponivelQuandoRendaForIgualOuMaiorQue5k() {

            doReturn(true).when(cliente).isRendaMaiorIgualA(5000.0);

            assertTrue(emprestimo.isEmprestimoConsignadoDisponivel());
        }

        @Test
        void naoDeveEstarDisponivelQuandoRendaForIgualA4K() {

            doReturn(false).when(cliente).isRendaMaiorIgualA(5000.0);

            assertFalse(emprestimo.isEmprestimoConsignadoDisponivel());
        }
    }

    @Nested
    class taxaDeJurosEmprestimoPessoal {

        @Test
        void deveSerATaxaDe4() {

            doReturn(true).when(cliente).isRendaMenorIgualA(3000.0);

            assertEquals(4.0, emprestimo.getTaxaJurosEmprestimoPessoal());
        }

        @Test
        void deveLancarExcecaoQuandoNaoEstiverDisponivel() {

            doReturn(false).when(cliente).isRendaMenorIgualA(3000.0);

            assertThrows(EmprestimoNaoDisponivelException.class, () -> emprestimo.getTaxaJurosEmprestimoPessoal());
        }
    }

    @Nested
    class taxaDeJurosEmprestimoGarantido {

        @Test
        void deveSerATaxaDe3() {

            doReturn(true).when(cliente).isRendaMenorIgualA(3000.0);

            assertEquals(3.0, emprestimo.getTaxaJurosEmprestimoGarantia());
        }

        @Test
        void deveLancarExcecaoQuandoNaoEstiverDisponivel() {

            doReturn(false).when(cliente).isRendaMenorIgualA(3000.0);

            assertThrows(EmprestimoNaoDisponivelException.class, () -> emprestimo.getTaxaJurosEmprestimoGarantia());
        }
    }

    @Nested
    class taxaDeJurosEmprestimoConsignado {

        @Test
        void deveSerATaxaDe2() {

            doReturn(true).when(cliente).isRendaMaiorIgualA(5000.0);

            assertEquals(2.0, emprestimo.getTaxaJurosEmprestimoConsignado());
        }

        @Test
        void deveLancarExcecaoQuandoNaoEstiverDisponivel() {

            doReturn(false).when(cliente).isRendaMaiorIgualA(5000.0);

            assertThrows(EmprestimoNaoDisponivelException.class, () -> emprestimo.getTaxaJurosEmprestimoConsignado());
        }
    }


}