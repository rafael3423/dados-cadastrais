package com.itau.dados_cadastrais.adapter.web.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteResponseDTO {

    @JsonProperty("id_cliente")
    private String idCliente;
    @JsonProperty("cpf_cliente")
    private String cpfCliente;
    @JsonProperty("codigo_tipo_pessoa")
    private String codigoTipoPessoa;
    @JsonProperty("data_hora_cadastro")
    private LocalDateTime dataHoraCadastro;
    @JsonProperty("data_hora_ultima_atualizacao")
    private LocalDateTime dataHoraUltimaAutalizacao;
    @JsonProperty("endereco")
    private EnderecoResponseDTO enderecoResponseDTO;
    @JsonProperty("numero_celular")
    private String numeroCelular;
}

