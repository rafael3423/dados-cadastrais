package com.itau.dados_cadastrais.adapter.web.handler.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class ExceptionResponseDTO implements Serializable {
    private static final long serialVersion = 1L;

    private Integer codigo;
    private List<String> mensagem;
    private String codigoErroInterno;
}

