package com.itau.dados_cadastrais.adapter.dynamo.infraestrutura;

import com.itau.dados_cadastrais.adapter.dynamo.exception.DynamoAdapterException;
import com.itau.dados_cadastrais.adapter.dynamo.infraestrutura.annotations.Entity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.lang.reflect.ParameterizedType;

import static java.util.Optional.ofNullable;

@RequiredArgsConstructor
@Slf4j
@Component
public class BaseRepository<T extends BaseEntity> {

    private final DynamoDbEnhancedClient dynamoDbEnhancedClient;

    public DynamoDbTable<T> getDynamoDbTable() {
        return dynamoDbEnhancedClient.table(tableName(classType()), TableSchema.fromBean(classType()));
    }

    private Class<T> classType() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    private String tableName(Class<T> classType) {
        return ofNullable(classType.getAnnotation(Entity.class))
                .map(Entity::tableName)
                .orElseThrow(() -> new DynamoAdapterException(
                        "A Annotation @Entity é necessária " + classType.getName()));
    }

    protected Key getKeyBuild(String partitionKey) {
        return Key.builder()
                .partitionValue(partitionKey)
                .build();
    }

    protected Key getKeyBuild(String partitionKey, String sortKey) {
        return Key.builder()
                .partitionValue(partitionKey)
                .sortValue(sortKey)
                .build();
    }


}