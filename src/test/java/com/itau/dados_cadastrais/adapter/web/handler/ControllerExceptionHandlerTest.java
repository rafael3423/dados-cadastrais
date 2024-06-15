package com.itau.dados_cadastrais.adapter.web.handler;

import com.itau.dados_cadastrais.adapter.exception.DadosNaoEncontradosException;
import com.itau.dados_cadastrais.adapter.web.handler.response.ExceptionResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.itau.dados_cadastrais.adapter.web.handler.enums.CodigoErroInterno.ERRO_DADOS_NAO_ENCONTRADOS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class ControllerExceptionHandlerTest {

    private ExceptionHandler exceptionHandler;

    @BeforeEach
    void setUp() {
        exceptionHandler = new ExceptionHandler();
    }

    @Test
    void quandoReceberConsultaProjetoException_entaoRetorna404() {
        ResponseEntity<ExceptionResponseDTO> response
                = exceptionHandler.handleDadosNaoEncontradosException(new DadosNaoEncontradosException("Projeto não encontrado no banco de dados"));
        ExceptionResponseDTO body = response.getBody();
        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY.value(), body.getCodigo());
        assertNotNull(body);

        assertEquals(ERRO_DADOS_NAO_ENCONTRADOS.getCode(),
                body.getCodigoErroInterno());

        assertEquals("Projeto não encontrado no banco de dados",
                body.getMensagem().get(0));
    }
}
