package com.itau.dados_cadastrais.core.domain;

import com.itau.dados_cadastrais.DTOUtils;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static com.itau.dados_cadastrais.DTOUtils.criaCliente;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ClienteTest {

    @Test
    @DisplayName("Teste dos atributos Cliente classe")
    public void testeAtributos() {
        assertEquals(criaCliente().getCodigoTipoPessoa(), "F");
        assertEquals(criaCliente().getCpfCliente(), "348.790.278-80");
        assertEquals(DTOUtils.criaEndereco().getCep(),  "09120075");
        assertEquals(criaCliente().getNumeroCelular(), "11991665922");
        assertEquals(criaCliente().getIdCliente(), "31c3f324-714b-496f-9e18-8f88baf11a7a");
    }

    @Test
    @DisplayName("Teste das função definir horario Cliente classe")
    public void testeDefinirHoraCadastro() {
        criaCliente().definirDataHoraCadastro();
        criaCliente().definirDataHoraAtualizacao();
        criaCliente().formartarCpf();
    }
}
