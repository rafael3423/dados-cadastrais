package com.itau.dados_cadastrais.adapter.dynamo.mapper;

import com.itau.dados_cadastrais.adapter.dynamo.dadoscadastrais.entity.ClienteEntity;
import com.itau.dados_cadastrais.adapter.dynamo.dadoscadastrais.entity.ClienteEntity.ClienteEntityBuilder;
import com.itau.dados_cadastrais.core.domain.Cliente;
import com.itau.dados_cadastrais.core.domain.Cliente.ClienteBuilder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-15T17:04:55-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
@Component
public class AtualizarDadosCadastraisMapperImpl implements AtualizarDadosCadastraisMapper {

    @Override
    public ClienteEntity toEntity(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        ClienteEntityBuilder clienteEntity = ClienteEntity.builder();

        clienteEntity.endereco( AtualizarDadosCadastraisMapper.toTextoObjetoEndereco( cliente.getEndereco() ) );
        clienteEntity.idCliente( cliente.getIdCliente() );
        clienteEntity.cpfCliente( cliente.getCpfCliente() );
        clienteEntity.codigoTipoPessoa( cliente.getCodigoTipoPessoa() );
        if ( cliente.getDataHoraCadastro() != null ) {
            clienteEntity.dataHoraCadastro( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( cliente.getDataHoraCadastro() ) );
        }
        if ( cliente.getDataHoraUltimaAutalizacao() != null ) {
            clienteEntity.dataHoraUltimaAutalizacao( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( cliente.getDataHoraUltimaAutalizacao() ) );
        }
        clienteEntity.numeroCelular( cliente.getNumeroCelular() );

        return clienteEntity.build();
    }

    @Override
    public Cliente toDomain(ClienteEntity clienteEntity) {
        if ( clienteEntity == null ) {
            return null;
        }

        ClienteBuilder cliente = Cliente.builder();

        cliente.endereco( AtualizarDadosCadastraisMapper.toObjetoEndereco( clienteEntity.getEndereco() ) );
        cliente.idCliente( clienteEntity.getIdCliente() );
        cliente.cpfCliente( clienteEntity.getCpfCliente() );
        cliente.codigoTipoPessoa( clienteEntity.getCodigoTipoPessoa() );
        if ( clienteEntity.getDataHoraCadastro() != null ) {
            cliente.dataHoraCadastro( LocalDateTime.parse( clienteEntity.getDataHoraCadastro() ) );
        }
        if ( clienteEntity.getDataHoraUltimaAutalizacao() != null ) {
            cliente.dataHoraUltimaAutalizacao( LocalDateTime.parse( clienteEntity.getDataHoraUltimaAutalizacao() ) );
        }
        cliente.numeroCelular( clienteEntity.getNumeroCelular() );

        return cliente.build();
    }
}
