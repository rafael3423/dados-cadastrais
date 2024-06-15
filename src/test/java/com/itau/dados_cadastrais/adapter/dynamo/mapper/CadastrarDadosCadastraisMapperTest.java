package com.itau.dados_cadastrais.adapter.dynamo.mapper;

import com.itau.dados_cadastrais.DTOUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CadastrarDadosCadastraisMapperTest {
  @Spy
  private CadastrarDadosCadastraisMapper mapper = Mappers.getMapper(CadastrarDadosCadastraisMapper.class);

  @Test
  @DisplayName("teste mapper cadastrar dados cadastrais")
  public void atualizaMapperEntity() {
    mapper.toDomain(DTOUtils.criaEntity());
  }

  @Test
  @DisplayName("teste mapper cadastrar dados cadastrais")
  public void atualizaMapperModel() {
    mapper.toEntity(DTOUtils.criaCliente());
  }
}