package com.itau.dados_cadastrais.adapter.dynamo;

import com.itau.dados_cadastrais.adapter.dynamo.dadoscadastrais.repository.DadosCadastraisRepository;
import com.itau.dados_cadastrais.adapter.dynamo.exception.AtualizarDadosCadastraisAdapterException;
import com.itau.dados_cadastrais.adapter.dynamo.mapper.AtualizarDadosCadastraisMapper;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static com.itau.dados_cadastrais.DTOUtils.criaCliente;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class AtualizarDadosCadastraisAdapterTest {

    @Mock
    private DadosCadastraisRepository dadosCadastraisRepository;

    @Spy
    private AtualizarDadosCadastraisMapper atualizarDadosCadastraisMapper;

    @InjectMocks
    private AtualizarDadosCadastraisAdapter atualizarDadosCadastraisAdapter;

    @BeforeEach
    void setUp() {
        atualizarDadosCadastraisAdapter = new AtualizarDadosCadastraisAdapter(dadosCadastraisRepository, atualizarDadosCadastraisMapper);
    }

    @Test
    @DisplayName("Teste do exception adapter para atualizar os dados cadastrais")
    public void testeAdapterDadosCadastrais() {
        assertThrows(AtualizarDadosCadastraisAdapterException.class , ()-> atualizarDadosCadastraisAdapter
                .execute("123-123", criaCliente()));
    }
}
