package com.itau.dados_cadastrais.core.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cliente {
    private String idCliente;
    private String cpfCliente;
    private String codigoTipoPessoa;
    private LocalDateTime dataHoraCadastro;
    private LocalDateTime dataHoraUltimaAutalizacao;
    private Endereco endereco;
    private String numeroCelular;

    public void definirDataHoraCadastro(){
        this.dataHoraCadastro = LocalDateTime.now();
    }

    public void definirDataHoraAtualizacao(){
        this.dataHoraUltimaAutalizacao = LocalDateTime.now();
    }

    public void formartarCpf(){
        this.cpfCliente = this.cpfCliente.replaceAll("[^0-9]", "");
    }
}

