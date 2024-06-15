package com.itau.dados_cadastrais.adapter.web.model.response;

import com.itau.dados_cadastrais.DTOUtils;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ClienteResponseDTOTest {

    @Test
    @DisplayName("Teste dos atributos ClienteRequestDTO")
    public void testeAtributos() {
        assertEquals(DTOUtils.criaClienteResponseDTO().getCodigoTipoPessoa(), "F");
        assertEquals(DTOUtils.criaClienteResponseDTO().getCpfCliente(), "348.790.278-80");
        assertEquals(DTOUtils.criaClienteResponseDTO().getEnderecoResponseDTO().getCep(), "09120075");
        assertEquals(DTOUtils.criaClienteResponseDTO().getNumeroCelular(), "11991665922");
        assertEquals(DTOUtils.criaClienteResponseDTO().getIdCliente(), "31c3f324-714b-496f-9e18-8f88baf11a7a");

    }

}
