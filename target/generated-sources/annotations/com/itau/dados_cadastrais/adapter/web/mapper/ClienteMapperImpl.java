package com.itau.dados_cadastrais.adapter.web.mapper;

import com.itau.dados_cadastrais.adapter.web.model.request.ClienteRequestDTO;
import com.itau.dados_cadastrais.adapter.web.model.request.EnderecoRequestDTO;
import com.itau.dados_cadastrais.adapter.web.model.response.ClienteResponseDTO;
import com.itau.dados_cadastrais.adapter.web.model.response.ClienteResponseDTO.ClienteResponseDTOBuilder;
import com.itau.dados_cadastrais.adapter.web.model.response.EnderecoResponseDTO;
import com.itau.dados_cadastrais.adapter.web.model.response.EnderecoResponseDTO.EnderecoResponseDTOBuilder;
import com.itau.dados_cadastrais.core.domain.Cliente;
import com.itau.dados_cadastrais.core.domain.Cliente.ClienteBuilder;
import com.itau.dados_cadastrais.core.domain.Endereco;
import com.itau.dados_cadastrais.core.domain.Endereco.EnderecoBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-15T17:34:57-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public Cliente toModel(ClienteRequestDTO clienteRequestDTO) {
        if ( clienteRequestDTO == null ) {
            return null;
        }

        ClienteBuilder cliente = Cliente.builder();

        cliente.endereco( enderecoRequestDTOToEndereco( clienteRequestDTO.getEnderecoRequestDTO() ) );
        cliente.idCliente( clienteRequestDTO.getIdCliente() );
        cliente.cpfCliente( clienteRequestDTO.getCpfCliente() );
        cliente.codigoTipoPessoa( clienteRequestDTO.getCodigoTipoPessoa() );
        cliente.numeroCelular( clienteRequestDTO.getNumeroCelular() );

        return cliente.build();
    }

    @Override
    public ClienteResponseDTO toResponseDTO(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        ClienteResponseDTOBuilder clienteResponseDTO = ClienteResponseDTO.builder();

        clienteResponseDTO.enderecoResponseDTO( enderecoToEnderecoResponseDTO( cliente.getEndereco() ) );
        clienteResponseDTO.idCliente( cliente.getIdCliente() );
        clienteResponseDTO.cpfCliente( cliente.getCpfCliente() );
        clienteResponseDTO.codigoTipoPessoa( cliente.getCodigoTipoPessoa() );
        clienteResponseDTO.dataHoraCadastro( cliente.getDataHoraCadastro() );
        clienteResponseDTO.dataHoraUltimaAutalizacao( cliente.getDataHoraUltimaAutalizacao() );
        clienteResponseDTO.numeroCelular( cliente.getNumeroCelular() );

        return clienteResponseDTO.build();
    }

    protected Endereco enderecoRequestDTOToEndereco(EnderecoRequestDTO enderecoRequestDTO) {
        if ( enderecoRequestDTO == null ) {
            return null;
        }

        EnderecoBuilder endereco = Endereco.builder();

        endereco.logradouro( enderecoRequestDTO.getLogradouro() );
        endereco.numero( enderecoRequestDTO.getNumero() );
        endereco.complemento( enderecoRequestDTO.getComplemento() );
        endereco.bairro( enderecoRequestDTO.getBairro() );
        endereco.cep( enderecoRequestDTO.getCep() );
        endereco.cidade( enderecoRequestDTO.getCidade() );
        endereco.uf( enderecoRequestDTO.getUf() );
        endereco.pais( enderecoRequestDTO.getPais() );
        endereco.principal( enderecoRequestDTO.getPrincipal() );

        return endereco.build();
    }

    protected EnderecoResponseDTO enderecoToEnderecoResponseDTO(Endereco endereco) {
        if ( endereco == null ) {
            return null;
        }

        EnderecoResponseDTOBuilder enderecoResponseDTO = EnderecoResponseDTO.builder();

        enderecoResponseDTO.logradouro( endereco.getLogradouro() );
        enderecoResponseDTO.numero( endereco.getNumero() );
        enderecoResponseDTO.complemento( endereco.getComplemento() );
        enderecoResponseDTO.bairro( endereco.getBairro() );
        enderecoResponseDTO.cep( endereco.getCep() );
        enderecoResponseDTO.cidade( endereco.getCidade() );
        enderecoResponseDTO.uf( endereco.getUf() );
        enderecoResponseDTO.pais( endereco.getPais() );
        enderecoResponseDTO.principal( endereco.getPrincipal() );

        return enderecoResponseDTO.build();
    }
}
