package com.itau.dados_cadastrais.adapter.web.handler.enums;

import lombok.Getter;

@Getter
public enum CodigoErroInterno {

    ERRO_CAMPO_INVALIDO("0000", "Campo preenchido incorretamente"),
    ERRO_DADOS_NAO_ENCONTRADOS("0010", "Dados não foram encontrados no banco de dados!"),
    ERRO_CADASTRAR_DADOS("0020", "Não foi possivel cadastrar os dados!");

    private final String code;

    private final String message;

    CodigoErroInterno(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
