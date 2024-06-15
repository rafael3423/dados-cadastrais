package com.itau.dados_cadastrais.adapter.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith({MockitoExtension.class})
public class DadosNaoEncontradosExceptionTest {

  @Test
  @DisplayName("teste de exception de adapter do dynamo")
  public void testeDynamoAdapterExcpetion(){
    Throwable throwable = assertThrows(DadosNaoEncontradosException.class,
        () -> {throw new DadosNaoEncontradosException("teste throw");});

    assertEquals(throwable.getMessage(), "teste throw");
  }
}