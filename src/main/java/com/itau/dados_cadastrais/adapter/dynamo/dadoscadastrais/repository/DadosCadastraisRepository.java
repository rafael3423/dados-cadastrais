package com.itau.dados_cadastrais.adapter.dynamo.dadoscadastrais.repository;

import com.itau.dados_cadastrais.adapter.dynamo.dadoscadastrais.entity.ClienteEntity;
import com.itau.dados_cadastrais.adapter.dynamo.infraestrutura.BaseRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.model.Page;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.enhanced.dynamodb.model.UpdateItemEnhancedRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class DadosCadastraisRepository extends BaseRepository<ClienteEntity> {

    public DadosCadastraisRepository(DynamoDbEnhancedClient dynamoDbEnhancedClient) {
        super(dynamoDbEnhancedClient);
    }

    public Optional<String> salvar(ClienteEntity clienteEntity) {
        log.info("Salvando registros na tabela de dados cliente...");
        getDynamoDbTable().putItem(clienteEntity);
        return Optional.of(clienteEntity.toString());
    }

    public Optional<ClienteEntity> atualizar(ClienteEntity vinculoContasEntity) {
        log.info("Atualizando registros na tabela de dados cliente...");
        return Optional.of(getDynamoDbTable().updateItem(buildUpdateRequest(vinculoContasEntity)));
    }

    public Optional<ClienteEntity> buscarPorChave(String partitionKey) {
        log.info("Buscando registro na tabela de dados cliente com chave {}", partitionKey);

        var iterator = getDynamoDbTable().query(QueryConditional.keyEqualTo(getKeyBuild(partitionKey))).iterator();

        List<ClienteEntity> dadosCadastraisConsultado = new ArrayList<>();

        while (iterator.hasNext()) {
            final Page<ClienteEntity> page = iterator.next();
            if (!page.items().isEmpty()) {
                dadosCadastraisConsultado.addAll(page.items());
                break;
            }
        }

        return dadosCadastraisConsultado.stream().findFirst();
    }

    public Optional<ClienteEntity> buscarPorSortkey(String pk, String cpf) {
        log.info("Buscando registro na tabela de dados cliente com chave {}", cpf);

        var iterator = getDynamoDbTable().query(QueryConditional.keyEqualTo(getKeyBuild(pk, cpf))).iterator();

        List<ClienteEntity> dadosCadastraisConsultado = new ArrayList<>();

        while (iterator.hasNext()) {
            final Page<ClienteEntity> page = iterator.next();
            if (!page.items().isEmpty()) {
                dadosCadastraisConsultado.addAll(page.items());
                break;
            }
        }

        return dadosCadastraisConsultado.stream().findFirst();
    }

    public void deleteDynamoDBItem(String key, String cpf) {
        log.info("Deletando registros na tabela de dados cliente...");
        getDynamoDbTable().deleteItem(getKeyBuild(key, cpf));
    }
    private UpdateItemEnhancedRequest<ClienteEntity> buildUpdateRequest(ClienteEntity entity) {
        return UpdateItemEnhancedRequest.builder(ClienteEntity.class)
                .ignoreNulls(true)
                .item(entity)
                .build();
    }

}
