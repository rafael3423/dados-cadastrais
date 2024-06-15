package com.itau.dados_cadastrais.adapter.dynamo.exception;

public class ConsultarDadosCadastraisAdapterException extends RuntimeException {
    public ConsultarDadosCadastraisAdapterException(String message) {
        super(message);
    }

    public ConsultarDadosCadastraisAdapterException(String message, Throwable cause) {
        super(message, cause);
    }

}

