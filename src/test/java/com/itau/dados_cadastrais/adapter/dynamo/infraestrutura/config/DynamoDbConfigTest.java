package com.itau.dados_cadastrais.adapter.dynamo.infraestrutura.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@ExtendWith(MockitoExtension.class)
public class DynamoDbConfigTest {

  @Mock
  private AwsProperties awsProperties;

  @Mock
  private AwsProperties.DynamoDb dynamoDb;
  private DynamoDbConfig dynamoDbConfig;
  @Mock
  private DynamoDbClient dynamoDbClient;

  @BeforeEach
  void setUp() {
    Mockito.when(awsProperties.getAccessKeyId()).thenReturn("fakeAccessKeyId");
    Mockito.when(awsProperties.getSecretAccessKey()).thenReturn("fakeSecretAccessKey");
    Mockito.when(awsProperties.getDynamodb()).thenReturn(dynamoDb);
    Mockito.when(dynamoDb.getEndpoint()).thenReturn("http://localhost:4566");

    dynamoDbConfig = new DynamoDbConfig(awsProperties);
  }

  @Test
  @DisplayName("Teste criação dos beans do dynamo")
  public void getDynamoDbEnhancedClient() {
    DynamoDbConfig.dynamoDbEnhancedClient(dynamoDbClient);

    dynamoDbConfig.dynamoDbClient();
    dynamoDbConfig.dynamoDbClientLocal();
    dynamoDbConfig.dynamoDbClientLocalAws();
  }

}