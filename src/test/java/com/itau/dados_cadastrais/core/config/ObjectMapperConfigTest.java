package com.itau.dados_cadastrais.core.config;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class ObjectMapperConfigTest {

    @InjectMocks
    private ObjectMapperConfig objectMapperConfig;


    @Test
    @DisplayName("teste de configuração ObjectMapper")
    public void testObjectMapper(){
      var objectMapper = objectMapperConfig.objectMapper();
      assertNotNull(objectMapper);
    }
}