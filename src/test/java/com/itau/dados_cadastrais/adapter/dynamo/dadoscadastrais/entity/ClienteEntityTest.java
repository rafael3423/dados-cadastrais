package com.itau.dados_cadastrais.adapter.dynamo.dadoscadastrais.entity;

import com.itau.dados_cadastrais.DTOUtils;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;
import static pl.pojo.tester.api.assertion.Method.GETTER;
import static pl.pojo.tester.api.assertion.Method.SETTER;

@RunWith(MockitoJUnitRunner.class)
public class ClienteEntityTest {

    @Test
    @DisplayName("Teste dos atributos ClienteEntity")
    public void testeAtributos() {
        assertEquals(DTOUtils.criaEntity().getCodigoTipoPessoa(), "F");
        assertEquals(DTOUtils.criaEntity().getCpfCliente(), "34879027880");
        assertEquals(DTOUtils.criaEntity().getEndereco(), "{\"logradouro\":\"Rua Isabel\",\"numero\":\"352\",\"complemento\":null,\"bairro\":\"Vila Palmares\",\"cep\":\"09061580\",\"cidade\":\"Santo Andre\",\"uf\":\"SP\",\"pais\":\"Brasil\",\"principal\":true}");
        assertEquals(DTOUtils.criaEntity().getNumeroCelular(), "11991665922");
        assertEquals(DTOUtils.criaEntity().getIdCliente(), "31c3f324-714b-496f-9e18-8f88baf11a7a");
    }

}
