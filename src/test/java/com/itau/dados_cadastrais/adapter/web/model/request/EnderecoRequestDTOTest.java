package com.itau.dados_cadastrais.adapter.web.model.request;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static com.itau.dados_cadastrais.DTOUtils.criaEndereco;
import static com.itau.dados_cadastrais.DTOUtils.criaEnderecoRequestDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class EnderecoRequestDTOTest {

    @Test
    @DisplayName("Teste dos atributos ClienteRequestDTO")
    public void testeAtributos() {
        assertEquals(criaEnderecoRequestDTO().getCep(), "09120075");
        assertEquals(criaEnderecoRequestDTO().getUf(), "SP");
        assertEquals(criaEnderecoRequestDTO().getBairro(), "Vila Palmares");
        assertEquals(criaEnderecoRequestDTO().getCidade(), "Santo Andre");
        assertEquals(criaEnderecoRequestDTO().getNumero(), "352");
        assertEquals(criaEnderecoRequestDTO().getPais(), "Brasil");
        assertEquals(criaEnderecoRequestDTO().getLogradouro(), "Rua Isabel");
        assertEquals(criaEnderecoRequestDTO().getPrincipal(), true);
    }

}
