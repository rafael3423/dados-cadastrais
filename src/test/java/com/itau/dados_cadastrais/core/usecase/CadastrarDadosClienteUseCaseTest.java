package com.itau.dados_cadastrais.core.usecase;

import com.itau.dados_cadastrais.core.observer.CadastrarDadosObserver;
import com.itau.dados_cadastrais.core.port.out.CadastrarDadosCadastraisPortOut;
import com.itau.dados_cadastrais.core.port.out.SalvarAlteracoesDBPortOut;
import javassist.NotFoundException;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static com.itau.dados_cadastrais.DTOUtils.criaCliente;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CadastrarDadosClienteUseCaseTest {

    @Mock
    private List<CadastrarDadosObserver> cadastrarDadosObserverList;
    @Mock
    private CadastrarDadosCadastraisPortOut cadastrarDadosCadastraisPortOut;
    @Mock
    private SalvarAlteracoesDBPortOut salvarAlteracoesDBPortOut;

    @InjectMocks
    private CadastrarDadosClienteUseCase cadastrarDadosClienteUseCase;

    @BeforeEach
    void setUp(){
        cadastrarDadosObserverList.addAll(List.of(cadastrarDadosCadastraisPortOut, salvarAlteracoesDBPortOut));
    }

    @Test
    @DisplayName("Teste do usecase para cadastrar os dados cadastrais")
    public void testeUseCaseCadastrarDadosCadastrais() throws NotFoundException {
        var cliente = cadastrarDadosClienteUseCase.execute(criaCliente(), "1234-1234");

        assertEquals("31c3f324-714b-496f-9e18-8f88baf11a7a", cliente.getIdCliente());
    }
}
