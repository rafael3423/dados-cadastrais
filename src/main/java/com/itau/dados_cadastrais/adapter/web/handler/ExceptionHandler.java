package com.itau.dados_cadastrais.adapter.web.handler;

import com.itau.dados_cadastrais.adapter.dynamo.exception.CadastrarDadosCadastraisAdapterException;
import com.itau.dados_cadastrais.adapter.exception.DadosNaoEncontradosException;
import com.itau.dados_cadastrais.adapter.web.handler.enums.CodigoErroInterno;
import com.itau.dados_cadastrais.adapter.web.handler.response.ExceptionResponseDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(DadosNaoEncontradosException.class)
    public ResponseEntity<ExceptionResponseDTO> handleDadosNaoEncontradosException(DadosNaoEncontradosException e) {
        var body = new ExceptionResponseDTO(HttpStatus.UNPROCESSABLE_ENTITY.value(),
                Collections.singletonList(e.getMessage()),
                CodigoErroInterno.ERRO_DADOS_NAO_ENCONTRADOS.getCode());

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(body);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(CadastrarDadosCadastraisAdapterException.class)
    public ResponseEntity<ExceptionResponseDTO> handleCadastrarDadosCadastraisAdapterException(CadastrarDadosCadastraisAdapterException e) {
        var body = new ExceptionResponseDTO(HttpStatus.UNPROCESSABLE_ENTITY.value(),
                Collections.singletonList(e.getMessage()),
                CodigoErroInterno.ERRO_DADOS_NAO_ENCONTRADOS.getCode());

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(body);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatusCode status,
                                                                  WebRequest request) {

        var body = new ExceptionResponseDTO(HttpStatus.UNPROCESSABLE_ENTITY.value(),
                Collections.singletonList(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage()),
                CodigoErroInterno.ERRO_CAMPO_INVALIDO.getCode());

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(body);
    }


}
