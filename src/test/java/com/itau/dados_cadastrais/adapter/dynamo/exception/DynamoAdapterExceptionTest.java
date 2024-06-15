package com.itau.dados_cadastrais.adapter.dynamo.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith({MockitoExtension.class})
public class DynamoAdapterExceptionTest {

  @Test
  @DisplayName("teste de exception de adapter do dynamo")
  public void testeDynamoAdapterExcpetion(){
    Throwable throwable = assertThrows(DynamoAdapterException.class,
        () -> {throw new DynamoAdapterException("teste throw");});

    assertEquals(throwable.getMessage(), "teste throw");
  }
}