package com.itau.dados_cadastrais.adapter.dynamo.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConsultarDadosCadastraisAdapterExceptionTest extends RuntimeException {
    @Test
    @DisplayName("teste de exception de adapter de ConsultarDados")
    public void testeDynamoAdapterExcpetion(){
        Throwable throwable = assertThrows(ConsultarDadosCadastraisAdapterException.class,
                () -> {throw new ConsultarDadosCadastraisAdapterException("teste throw");});

        assertEquals(throwable.getMessage(), "teste throw");
    }
}

