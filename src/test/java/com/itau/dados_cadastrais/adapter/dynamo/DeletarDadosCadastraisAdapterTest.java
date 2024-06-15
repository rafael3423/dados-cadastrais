package com.itau.dados_cadastrais.adapter.dynamo;

import com.itau.dados_cadastrais.adapter.dynamo.dadoscadastrais.repository.DadosCadastraisRepository;
import com.itau.dados_cadastrais.adapter.dynamo.mapper.ConsultarDadosCadastraisMapper;
import com.itau.dados_cadastrais.adapter.dynamo.mapper.DeletarDadosCadastraisMapper;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static com.itau.dados_cadastrais.DTOUtils.criaEntity;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class DeletarDadosCadastraisAdapterTest {

    @Mock
    private DadosCadastraisRepository dadosCadastraisRepository;

    @Spy
    private DeletarDadosCadastraisMapper deletarDadosCadastraisMapper
            = Mappers.getMapper(DeletarDadosCadastraisMapper.class);

    @InjectMocks
    private DeletarDadosCadastraisAdapter deletarDadosCadastraisAdapter;

    @BeforeEach
    void setUp() {
        deletarDadosCadastraisAdapter = new DeletarDadosCadastraisAdapter(dadosCadastraisRepository);
    }

    @Test
    @DisplayName("Teste do adapter para deletar os dados cadastrais")
    public void testeAdapterDadosCadastrais() {

        doNothing().when(dadosCadastraisRepository)
                .deleteDynamoDBItem(anyString(), anyString());

        deletarDadosCadastraisAdapter.execute("123-123", "34879027880");

    }

}
