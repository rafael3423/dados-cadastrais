package com.itau.dados_cadastrais.adapter.dynamo.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DeletarDadosCadastraisAdapterExceptionTest extends RuntimeException {
    @Test
    @DisplayName("teste de exception de adapter de DeletarDadosCadastrais")
    public void testeDynamoAdapterExcpetion(){
        Throwable throwable = assertThrows(DeletarDadosCadastraisAdapterException.class,
                () -> {throw new DeletarDadosCadastraisAdapterException("teste throw");});

        assertEquals(throwable.getMessage(), "teste throw");
    }
}

