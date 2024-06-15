package com.itau.dados_cadastrais.adapter.web.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteRequestDTO {

    @JsonProperty("id_cliente")
    private String idCliente;

    @JsonProperty("cpf_cliente")
    @CPF
    @NotBlank(message = "cpf do cliente não deve ser nulo/vazio.")
    private String cpfCliente;

    @JsonProperty("codigo_tipo_pessoa")
    @Size(max = 1, message = "codigo tipo pessoa dever ser F (fisica) ou J (juridica)")
    @NotBlank(message = "codigo tipo de pessoa não deve ser nulo/vazio.")
    private String codigoTipoPessoa;

    @JsonProperty("endereco")
    private EnderecoRequestDTO enderecoRequestDTO;

    @JsonProperty("numero_celular")
    @NotBlank(message = "celular do cliente não deve ser nulo/vazio.")
    @Size(min = 11,
            message = "celular deve conter 11 digitos (ddd + numero)")
    private String numeroCelular;
}

