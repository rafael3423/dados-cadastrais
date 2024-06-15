package com.itau.dados_cadastrais.adapter.dynamo.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CadastrarDadosCadastraisAdapterExceptionTest extends RuntimeException {
    @Test
    @DisplayName("teste de exception de adapter de CadastrarDados")
    public void testeCadastrarDadosAdapterExcpetion(){
        Throwable throwable = assertThrows(CadastrarDadosCadastraisAdapterException.class,
                () -> {throw new CadastrarDadosCadastraisAdapterException("teste throw");});

        assertEquals(throwable.getMessage(), "teste throw");
    }
}

