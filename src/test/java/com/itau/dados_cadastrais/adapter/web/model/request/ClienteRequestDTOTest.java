package com.itau.dados_cadastrais.adapter.web.model.request;

import com.itau.dados_cadastrais.DTOUtils;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ClienteRequestDTOTest {

    @Test
    @DisplayName("Teste dos atributos ClienteRequestDTO")
    public void testeAtributos() {
        assertEquals(DTOUtils.criaClienteRequestDTO().getCodigoTipoPessoa(), "F");
        assertEquals(DTOUtils.criaClienteRequestDTO().getCpfCliente(), "348.790.278-80");
        assertEquals(DTOUtils.criaClienteRequestDTO().getEnderecoRequestDTO().getCep(), "09120075");
        assertEquals(DTOUtils.criaClienteRequestDTO().getNumeroCelular(), "11991665922");
        assertEquals(DTOUtils.criaClienteRequestDTO().getIdCliente(), "31c3f324-714b-496f-9e18-8f88baf11a7a");

    }

}
