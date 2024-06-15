package com.itau.dados_cadastrais;

import com.itau.dados_cadastrais.adapter.dynamo.dadoscadastrais.entity.ClienteEntity;
import com.itau.dados_cadastrais.adapter.web.model.request.ClienteRequestDTO;
import com.itau.dados_cadastrais.adapter.web.model.request.EnderecoRequestDTO;
import com.itau.dados_cadastrais.adapter.web.model.response.ClienteResponseDTO;
import com.itau.dados_cadastrais.adapter.web.model.response.EnderecoResponseDTO;
import com.itau.dados_cadastrais.core.domain.Cliente;
import com.itau.dados_cadastrais.core.domain.Endereco;

import java.time.LocalDateTime;

public class DTOUtils {

    public static ClienteEntity criaEntity() {
        return ClienteEntity.builder()
                .codigoTipoPessoa("F")
                .cpfCliente("34879027880")
                .dataHoraCadastro(LocalDateTime.now().toString())
                .dataHoraUltimaAutalizacao(LocalDateTime.now().toString())
                .endereco("{\"logradouro\":\"Rua Isabel\",\"numero\":\"352\",\"complemento\":null,\"bairro\":\"Vila Palmares\",\"cep\":\"09061580\",\"cidade\":\"Santo Andre\",\"uf\":\"SP\",\"pais\":\"Brasil\",\"principal\":true}")
                .numeroCelular("11991665922")
                .idCliente("31c3f324-714b-496f-9e18-8f88baf11a7a")
                .build();
    }

    public static Cliente criaCliente() {
        return Cliente.builder()
                .codigoTipoPessoa("F")
                .cpfCliente("348.790.278-80")
                .dataHoraCadastro(LocalDateTime.now())
                .dataHoraUltimaAutalizacao(LocalDateTime.now())
                .endereco(criaEndereco())
                .numeroCelular("11991665922")
                .idCliente("31c3f324-714b-496f-9e18-8f88baf11a7a")
                .build();
    }

    public static Endereco criaEndereco() {
        return Endereco.builder()
                .cep("09120075")
                .uf("SP")
                .pais("Brasil")
                .bairro("Vila Palmares")
                .cidade("Santo Andre")
                .numero("352")
                .principal(true)
                .logradouro("Rua Isabel")
                .build();
    }

    public static ClienteRequestDTO criaClienteRequestDTO() {
        return ClienteRequestDTO.builder()
                .codigoTipoPessoa("F")
                .cpfCliente("348.790.278-80")
                .enderecoRequestDTO(criaEnderecoRequestDTO())
                .numeroCelular("11991665922")
                .idCliente("31c3f324-714b-496f-9e18-8f88baf11a7a")
                .build();
    }

    public static EnderecoRequestDTO criaEnderecoRequestDTO() {
        return EnderecoRequestDTO.builder()
                .cep("09120075")
                .uf("SP")
                .pais("Brasil")
                .bairro("Vila Palmares")
                .cidade("Santo Andre")
                .numero("352")
                .principal(true)
                .logradouro("Rua Isabel")
                .build();
    }


    public static ClienteResponseDTO criaClienteResponseDTO() {
        return ClienteResponseDTO.builder()
                .codigoTipoPessoa("F")
                .cpfCliente("348.790.278-80")
                .enderecoResponseDTO(criaEnderecoResponseDTO())
                .numeroCelular("11991665922")
                .idCliente("31c3f324-714b-496f-9e18-8f88baf11a7a")
                .build();
    }

    public static EnderecoResponseDTO criaEnderecoResponseDTO() {
        return EnderecoResponseDTO.builder()
                .cep("09120075")
                .uf("SP")
                .pais("Brasil")
                .bairro("Vila Palmares")
                .cidade("Santo Andre")
                .numero("352")
                .principal(true)
                .logradouro("Rua Isabel")
                .build();
    }

}
