package com.itau.dados_cadastrais.core.usecase;

import com.itau.dados_cadastrais.core.port.out.ConsultarDadosCadastraisPortOut;
import javassist.NotFoundException;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.itau.dados_cadastrais.DTOUtils.criaCliente;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class ConsultarDadosClienteUseCaseTest {

    @Mock
    private ConsultarDadosCadastraisPortOut consultarDadosCadastraisPortOut;

    @InjectMocks
    private ConsultarDadosClienteUseCase consultarDadosClienteUseCase;

    @Test
    @DisplayName("Teste do usecase para consultar os dados cadastrais")
    public void testeUseCaseCadastrarDadosCadastrais() throws NotFoundException {

        doReturn(criaCliente()).when(consultarDadosCadastraisPortOut)
                .execute(anyString());
        var cliente = consultarDadosClienteUseCase.execute("31c3f324-714b-496f-9e18-8f88baf11a7a");

        assertEquals("31c3f324-714b-496f-9e18-8f88baf11a7a", cliente.getIdCliente());
    }
}
