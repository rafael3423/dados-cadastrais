package com.itau.dados_cadastrais.adapter.dynamo.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AtualizarDadosCadastraisAdapterExceptionTest extends RuntimeException {
    @Test
    @DisplayName("teste de exception de adapter de atualização de dados")
    public void testeAtualizarDadosAdapterExcpetion(){
        Throwable throwable = assertThrows(AtualizarDadosCadastraisAdapterException.class,
                () -> {throw new AtualizarDadosCadastraisAdapterException("teste throw");});

        assertEquals(throwable.getMessage(), "teste throw");
    }
}