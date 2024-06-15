package com.itau.dados_cadastrais.adapter.dynamo.exception;

public class DynamoAdapterException extends RuntimeException {
    public DynamoAdapterException(String message, Throwable cause) {
        super(message, cause);
    }

    public DynamoAdapterException(String message) {
        super(message);
    }
}

