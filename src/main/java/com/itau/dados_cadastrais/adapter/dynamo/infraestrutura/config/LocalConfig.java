package com.itau.dados_cadastrais.adapter.dynamo.infraestrutura.config;

import com.itau.dados_cadastrais.adapter.dynamo.dadoscadastrais.entity.ClienteEntity;
import com.itau.dados_cadastrais.adapter.dynamo.infraestrutura.annotations.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.CreateTableEnhancedRequest;
import software.amazon.awssdk.enhanced.dynamodb.model.EnhancedGlobalSecondaryIndex;
import software.amazon.awssdk.services.dynamodb.model.Projection;
import software.amazon.awssdk.services.dynamodb.model.ProvisionedThroughput;
import java.util.List;
import static java.util.Optional.ofNullable;

@Slf4j
@Configuration
@Profile("local")
public class LocalConfig implements CommandLineRunner {

    private final DynamoDbEnhancedClient enhancedClient;
    private final List<TableDynamo> classList;

    public LocalConfig(DynamoDbEnhancedClient enhancedClient) {
        this.enhancedClient = enhancedClient;
        classList = List.of(
                TableDynamo.builder().tableType(ClienteEntity.class)
                        .enhancedRequest(CreateTableEnhancedRequest.builder()
                                .build()).build());
    }

    @Override
    public void run(String... args) {
        try {
            classList.forEach(tableDynamo -> ofNullable(tableDynamo.getTableType().getAnnotation(Entity.class))
                    .ifPresent(ann -> enhancedClient.table(ann.tableName(), TableSchema.fromBean(tableDynamo.getTableType()))
                            .createTable(tableDynamo.getEnhancedRequest())));

        } catch (Exception e) {
            log.info("Erro ao criar tabelas no DynamoDB local: " + e.getMessage());
        }
    }

    @Builder
    @Getter
    static class TableDynamo {

        private Class<?> tableType;
        private CreateTableEnhancedRequest enhancedRequest;
    }
}
