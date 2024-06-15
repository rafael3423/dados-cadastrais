package com.itau.dados_cadastrais.adapter.dynamo.dadoscadastrais.repository;

import com.itau.dados_cadastrais.DTOUtils;
import com.itau.dados_cadastrais.adapter.dynamo.dadoscadastrais.entity.ClienteEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbIndex;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.model.Page;
import software.amazon.awssdk.enhanced.dynamodb.model.PageIterable;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.enhanced.dynamodb.model.UpdateItemEnhancedRequest;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class DadosCadastraisRepositoryTest {

  private DadosCadastraisRepository repository;
  @Mock
  private DynamoDbEnhancedClient dynamoDbEnhancedClient;
  @Mock
  private DynamoDbTable<ClienteEntity> table;
  @Mock
  private DynamoDbIndex<ClienteEntity> tableIndex;

  @BeforeEach
  void setUp() {
    repository = new DadosCadastraisRepository(dynamoDbEnhancedClient);
    Mockito.doReturn(table).when(dynamoDbEnhancedClient).table(any(), any());
  }

  @Test
  @DisplayName("teste salvar no dynamo com repository")
  public void salvar() {
    repository.salvar(DTOUtils.criaEntity());
  }

  @Test
  @DisplayName("teste atualizar no dynamo com repository")
  public void atualizar() {
    doReturn(DTOUtils.criaEntity()).when(table)
        .updateItem((UpdateItemEnhancedRequest<ClienteEntity>) any());

    repository.atualizar(DTOUtils.criaEntity());
  }

  @Test
  @DisplayName("teste buscar no dynamo com repository")
  public void buscar() {
    PageIterable<ClienteEntity> pages = () -> new Iterator<>() {
        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Page<ClienteEntity> next() {
            return Page.create(List.of(new ClienteEntity()));
        }
    };

    doReturn(pages).when(table)
        .query((QueryConditional) any());

    repository.buscarPorChave(UUID.randomUUID().toString());
  }
}