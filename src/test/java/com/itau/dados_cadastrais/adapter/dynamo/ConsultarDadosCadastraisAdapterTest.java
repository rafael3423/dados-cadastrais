package com.itau.dados_cadastrais.adapter.dynamo;

import com.itau.dados_cadastrais.adapter.dynamo.dadoscadastrais.entity.ClienteEntity;
import com.itau.dados_cadastrais.adapter.dynamo.dadoscadastrais.repository.DadosCadastraisRepository;
import com.itau.dados_cadastrais.adapter.dynamo.exception.ConsultarDadosCadastraisAdapterException;
import com.itau.dados_cadastrais.adapter.dynamo.mapper.ConsultarDadosCadastraisMapper;
import com.itau.dados_cadastrais.adapter.exception.DadosNaoEncontradosException;
import com.itau.dados_cadastrais.core.domain.Cliente;
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
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class ConsultarDadosCadastraisAdapterTest {

    @Mock
    private DadosCadastraisRepository dadosCadastraisRepository;

    @Spy
    private ConsultarDadosCadastraisMapper consultarDadosCadastraisMapper
            = Mappers.getMapper(ConsultarDadosCadastraisMapper.class);

    @InjectMocks
    private ConsultarDadosCadastraisAdapter consultarDadosCadastraisAdapter;

    @BeforeEach
    void setUp() {
        consultarDadosCadastraisAdapter = new ConsultarDadosCadastraisAdapter(dadosCadastraisRepository, consultarDadosCadastraisMapper);
    }

    @Test
    @DisplayName("Teste do adapter para consultar os dados cadastrais")
    public void testeAdapterDadosCadastrais() {

        var cleinteEntity = Optional.of(criaEntity());
        doReturn(cleinteEntity).when(dadosCadastraisRepository)
                .buscarPorChave(anyString());
        var cliente = consultarDadosCadastraisAdapter.execute("123-123");

        Assertions.assertEquals(cliente.getIdCliente(), "31c3f324-714b-496f-9e18-8f88baf11a7a");

    }

}
