package com.itau.dados_cadastrais.core.usecase;

import com.itau.dados_cadastrais.DTOUtils;
import com.itau.dados_cadastrais.core.domain.Cliente;
import com.itau.dados_cadastrais.core.port.out.AtualizarDadosCadastraisPortOut;
import com.itau.dados_cadastrais.core.port.out.SalvarAlteracoesDBPortOut;
import javassist.NotFoundException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.itau.dados_cadastrais.DTOUtils.criaCliente;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class AtualizarDadosClienteUseCaseTest {

    @Mock
    private AtualizarDadosCadastraisPortOut atualizarDadosCadastraisPortOut;
    @Mock
    private SalvarAlteracoesDBPortOut salvarAlteracoesDBPortOut;

    @InjectMocks
    private AtualizarDadosClienteUseCase atualizarDadosClienteUseCase;

    @Test
    @DisplayName("Teste do usecase para atualizar os dados cadastrais")
    public void testeUseCaseAtualziarDadosCadastrais() throws NotFoundException {

        doReturn(criaCliente()).when(atualizarDadosCadastraisPortOut)
                .execute(anyString(), any(Cliente.class));

        doNothing().when(salvarAlteracoesDBPortOut)
                .execute(any(Cliente.class), anyString());

        var cliente = atualizarDadosClienteUseCase.execute("1234-1234", criaCliente());

        assertEquals("31c3f324-714b-496f-9e18-8f88baf11a7a", cliente.getIdCliente());

    }

}
