package com.itau.dados_cadastrais.adapter.dynamo;

import com.itau.dados_cadastrais.adapter.dynamo.dadoscadastrais.entity.ClienteEntity;
import com.itau.dados_cadastrais.adapter.dynamo.dadoscadastrais.repository.DadosCadastraisRepository;
import com.itau.dados_cadastrais.adapter.dynamo.mapper.CadastrarDadosCadastraisMapper;
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
import static com.itau.dados_cadastrais.DTOUtils.criaCliente;
import static com.itau.dados_cadastrais.DTOUtils.criaEntity;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class CadastrarDadosCadastraisAdapterTest {

    @Mock
    private DadosCadastraisRepository dadosCadastraisRepository;

    @Spy
    private CadastrarDadosCadastraisMapper cadastrarDadosCadastraisMapper
            = Mappers.getMapper(CadastrarDadosCadastraisMapper.class);

    @InjectMocks
    private CadastrarDadosCadastraisAdapter cadastrarDadosCadastraisAdapter;


    @BeforeEach
    void setUp() {
        cadastrarDadosCadastraisAdapter = new CadastrarDadosCadastraisAdapter(dadosCadastraisRepository, cadastrarDadosCadastraisMapper);
    }

    @Test
    @DisplayName("Teste do adapter para cadastrar os dados cadastrais")
    public void testeAdapterDadosCadastrais() {

        doReturn(Optional.of(criaEntity().toString())).when(dadosCadastraisRepository)
                .salvar(any(ClienteEntity.class));
        cadastrarDadosCadastraisAdapter.execute(criaCliente(), "34879027880");

    }
}
