package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogbackExemplo {
    private static final Logger logger = LoggerFactory.getLogger(LogbackExemplo.class);

    public static void realizarOperacao() {
        logger.info("Realizando operação...");
        logger.debug("Processo de debug iniciado...");
        try {
            int resultado = 10 / 0;
            logger.debug("O resultado é: {}", resultado);
        } catch (ArithmeticException e) {
           throw new ArithmeticException("Erro ao realizar operação matemática: divisão por zero");
        }
    }

    @Test
    public static void operacaoLancarArithmeticException() {
        LogbackExemplo logbackExemplo = new LogbackExemplo();

        assertThrows(ArithmeticException.class, () -> {
            logbackExemplo.realizarOperacao();
        });
    }

    public static void main(String[] args) {
        LogbackExemplo example = new LogbackExemplo();
        example.realizarOperacao();
        example.operacaoLancarArithmeticException();
    }
}
