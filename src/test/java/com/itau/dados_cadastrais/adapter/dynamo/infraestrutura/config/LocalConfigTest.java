package com.itau.dados_cadastrais.adapter.dynamo.infraestrutura.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;

@ExtendWith(MockitoExtension.class)
public class LocalConfigTest {

  private LocalConfig localConfig;

  @Mock
  private DynamoDbEnhancedClient dynamoDbEnhancedClient;

  @BeforeEach
  void setUp(){
    localConfig = new LocalConfig(dynamoDbEnhancedClient);

  }

  @Test
  @DisplayName("teste config dynamo local")
  public void testeLocalConfigDynamo(){
    localConfig.run();

  }
}