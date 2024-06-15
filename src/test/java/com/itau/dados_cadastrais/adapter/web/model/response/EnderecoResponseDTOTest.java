package com.itau.dados_cadastrais.adapter.web.model.response;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static com.itau.dados_cadastrais.DTOUtils.criaEnderecoRequestDTO;
import static com.itau.dados_cadastrais.DTOUtils.criaEnderecoResponseDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class EnderecoResponseDTOTest {

    @Test
    @DisplayName("Teste dos atributos ClienteRequestDTO")
    public void testeAtributos() {
        assertEquals(criaEnderecoResponseDTO().getCep(), "09120075");
        assertEquals(criaEnderecoResponseDTO().getUf(), "SP");
        assertEquals(criaEnderecoResponseDTO().getBairro(), "Vila Palmares");
        assertEquals(criaEnderecoResponseDTO().getCidade(), "Santo Andre");
        assertEquals(criaEnderecoResponseDTO().getNumero(), "352");
        assertEquals(criaEnderecoResponseDTO().getPais(), "Brasil");
        assertEquals(criaEnderecoResponseDTO().getLogradouro(), "Rua Isabel");
        assertEquals(criaEnderecoResponseDTO().getPrincipal(), true);
    }

}
