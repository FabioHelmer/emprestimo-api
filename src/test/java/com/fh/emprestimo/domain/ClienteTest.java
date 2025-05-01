package com.fh.emprestimo.domain;

import com.fh.emprestimo.factory.ClienteFactory;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(MockitoExtension.class)
class ClienteTest {


    @Nested
    class RendaMenorIgual {
        @Test
        void deveSerVerdadeiroQuandoRendaIgual() {
            var cliente = ClienteFactory.builder();
            assertTrue(cliente.isRendaMenorIgualA(5500.0));
        }

        @Test
        void deveSerVerdadeiroQuandoRendaInferiorAoValor() {
            var cliente = ClienteFactory.builder();
            assertTrue(cliente.isRendaMenorIgualA(8000));
        }

        @Test
        void deveSerFalsoQuandoRendaSuperiorAoValor() {
            var cliente = ClienteFactory.builder();
            assertFalse(cliente.isRendaMenorIgualA(4000));
        }
    }

    @Nested
    class RendaMaiorOuIgual {

        @Test
        void deveSerVerdadeiraQuandoRendaIgual() {
            var cliente = ClienteFactory.builder(5000.0);
            assertTrue(cliente.isRendaMaiorIgualA(5000.0));
        }

        @Test
        void deveSerVerdadeiraQuandoRendaMaiorQueValor() {
            var cliente = ClienteFactory.builder(5000.0);
            assertTrue(cliente.isRendaMaiorIgualA(3000.0));
        }

        @Test
        void deveSerFalsaQuandoRendaMenorQueValor() {
            var cliente = ClienteFactory.builder(5000.0);
            assertFalse(cliente.isRendaMaiorIgualA(8000.0));
        }
    }

    @Nested
    class RendaEntreValores {

        @Test
        void deveSerVerdadeiraQuandoRendaDentroDoIntervalo() {
            var cliente = ClienteFactory.builder(5000.0);
            assertTrue(cliente.isRendaEntre(3000.0, 8000.0));
        }

        @Test
        void deveSerVerdadeiraQuandoRendaIgualAoMinimo() {
            var cliente = ClienteFactory.builder(5000.0);
            assertTrue(cliente.isRendaEntre(5000.0, 8000.0));
        }

        @Test
        void deveSerVerdadeiraQuandoRendaIgualAoMaximo() {
            var cliente = ClienteFactory.builder(8000.0);
            assertTrue(cliente.isRendaEntre(5000.0, 8000.0));
        }

        @Test
        void deveSerFalsaQuandoRendaForaDoIntervalo() {
            var cliente = ClienteFactory.builder(5000.0);
            assertFalse(cliente.isRendaEntre(3000.0, 4500.0));
        }
    }

    @Nested
    class IdadeMenorQue {

        @Test
        void deveSerVerdadeiraQuandoIdadeMenorQueValor() {
            var cliente = ClienteFactory.builder(25);
            assertTrue(cliente.isIdadeMenorQue(30));
        }

        @Test
        void deveSerFalsaQuandoIdadeMaiorOuIgualAoValor() {
            var cliente = ClienteFactory.builder(25);
            assertFalse(cliente.isIdadeMenorQue(22));
        }

        @Test
        void deveSerFalsaQuandoIdadeIgualAoValor() {
            var cliente = ClienteFactory.builder(25);
            assertFalse(cliente.isIdadeMenorQue(25));
        }
    }

    @Nested
    class Localizacao {

        @Test
        void deveSerVerdadeiraQuandoLocalIgual() {
            var cliente = ClienteFactory.builder("SP");
            assertTrue(cliente.isClienteLocalizacao("SP"));
        }

        @Test
        void deveSerFalsaQuandoLocalDiferente() {
            var cliente = ClienteFactory.builder("SP");
            assertFalse(cliente.isClienteLocalizacao("RJ"));
        }
    }



}