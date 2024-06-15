package com.itau.dados_cadastrais.adapter.dynamo.infraestrutura.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
@Component
@ConfigurationProperties(prefix = "aws")
public class AwsProperties {

    private String accessKeyId;

    private String secretAccessKey;

    private final DynamoDb dynamodb = new DynamoDb();


    @Getter
    @Setter
    public static class DynamoDb {

        private String endpoint;
    }

}
