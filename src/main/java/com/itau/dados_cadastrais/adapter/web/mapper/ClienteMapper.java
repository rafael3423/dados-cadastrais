package com.itau.dados_cadastrais.adapter.web.mapper;

import com.itau.dados_cadastrais.adapter.web.model.request.ClienteRequestDTO;
import com.itau.dados_cadastrais.adapter.web.model.response.ClienteResponseDTO;
import com.itau.dados_cadastrais.core.domain.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mappings({@Mapping(source = "enderecoRequestDTO", target = "endereco")})
    Cliente toModel(ClienteRequestDTO clienteRequestDTO);

    @Mappings({@Mapping(source = "endereco", target = "enderecoResponseDTO")})
    ClienteResponseDTO toResponseDTO(Cliente cliente);
}
