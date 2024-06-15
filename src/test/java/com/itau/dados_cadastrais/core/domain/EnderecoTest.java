package com.itau.dados_cadastrais.core.domain;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static com.itau.dados_cadastrais.DTOUtils.criaEndereco;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class EnderecoTest {

    @Test
    @DisplayName("Teste dos atributos Cliente classe")
    public void testeAtributos() {
        assertEquals(criaEndereco().getCep(), "09120075");
        assertEquals(criaEndereco().getUf(), "SP");
        assertEquals(criaEndereco().getBairro(), "Vila Palmares");
        assertEquals(criaEndereco().getCidade(), "Santo Andre");
        assertEquals(criaEndereco().getNumero(), "352");
        assertEquals(criaEndereco().getPais(), "Brasil");
        assertEquals(criaEndereco().getLogradouro(), "Rua Isabel");
        assertEquals(criaEndereco().getPrincipal(), true);
    }
}
