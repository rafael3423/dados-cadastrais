package com.itau.dados_cadastrais.adapter.dynamo.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itau.dados_cadastrais.adapter.dynamo.dadoscadastrais.entity.ClienteEntity;
import com.itau.dados_cadastrais.core.domain.Cliente;
import com.itau.dados_cadastrais.core.domain.Endereco;
import lombok.SneakyThrows;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.Objects;

@Mapper(componentModel = "spring")
public interface AtualizarDadosCadastraisMapper {

    ObjectMapper mapper = new ObjectMapper();

    @Mappings(@Mapping(source = "endereco", target = "endereco", qualifiedByName = "asText"))
    ClienteEntity toEntity(Cliente cliente);

    @Mappings(@Mapping(source = "endereco", target = "endereco", qualifiedByName = "asObject"))
    Cliente toDomain(ClienteEntity clienteEntity);


    @SneakyThrows
    @Named("asText")
    static String toTextoObjetoEndereco(Endereco endereco) {
        if(Objects.isNull(endereco)){
            return null;
        }
        return mapper.writeValueAsString(endereco);
    }

    @SneakyThrows
    @Named("asObject")
    static Endereco toObjetoEndereco(String endereco) {
        return mapper.readValue(endereco, Endereco.class);
    }
}
