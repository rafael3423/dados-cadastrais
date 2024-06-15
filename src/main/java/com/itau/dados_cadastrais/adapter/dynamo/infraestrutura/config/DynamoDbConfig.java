package com.itau.dados_cadastrais.adapter.dynamo.infraestrutura.config;

import java.net.URI;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.http.apache.ApacheHttpClient;
import software.amazon.awssdk.http.apache.ProxyConfiguration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Configuration
@AllArgsConstructor
public class DynamoDbConfig {

    @Autowired
    private AwsProperties awsProperties;

    @Bean(value = "dynamoDbEnhancedClient")
    public static DynamoDbEnhancedClient dynamoDbEnhancedClient(DynamoDbClient dynamoDbClient) {
        return DynamoDbEnhancedClient.builder()
                .dynamoDbClient(dynamoDbClient)
                .build();
    }


    @Bean(value = "dynamoDbClient")
    @Profile("!local & !local-aws")
    public DynamoDbClient dynamoDbClient() {
        ProxyConfiguration.Builder proxyConfig = ProxyConfiguration.builder();

        ApacheHttpClient.Builder httpClientBuilder =
                ApacheHttpClient.builder()
                        .proxyConfiguration(proxyConfig.build());

        ClientOverrideConfiguration.Builder overrideConfig =
                ClientOverrideConfiguration.builder();

        return DynamoDbClient.builder()
                .region(Region.SA_EAST_1)
                .httpClientBuilder(httpClientBuilder)
                .overrideConfiguration(overrideConfig.build())
                .build();
    }

    @Bean(value = "dynamoDbClientLocal")
    @Profile("local")
    public DynamoDbClient dynamoDbClientLocal() {
        URI uri = URI.create(awsProperties.getDynamodb().getEndpoint());
        AwsCredentials awsCredentials = AwsBasicCredentials.create(awsProperties.getAccessKeyId(), awsProperties.getSecretAccessKey());
        return DynamoDbClient.builder()
                .region(Region.SA_EAST_1)
                .endpointOverride(uri)
                .credentialsProvider(StaticCredentialsProvider.create(awsCredentials))
                .build();
    }

    @Bean(value = "dynamoDbClientLocalAws")
    @Profile("local-aws")
    public DynamoDbClient dynamoDbClientLocalAws() {

        ClientOverrideConfiguration.Builder overrideConfig =
                ClientOverrideConfiguration.builder();

        return DynamoDbClient.builder()
                .region(Region.SA_EAST_1)
                .httpClientBuilder(sdkHttpClient())
                .overrideConfiguration(overrideConfig.build())
                .build();
    }

    @Bean(value = "sdkHttpClientDynamo")
    @Profile("local-aws")
    public ApacheHttpClient.Builder sdkHttpClient() {
        URI uri = URI.create(awsProperties.getDynamodb().getEndpoint());
        ProxyConfiguration proxyConfiguration = ProxyConfiguration.builder()
                .endpoint(uri)
                .build();
        return ApacheHttpClient.builder()
                .proxyConfiguration(proxyConfiguration);
    }
}
