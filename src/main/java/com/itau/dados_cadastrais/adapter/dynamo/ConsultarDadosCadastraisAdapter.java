package com.itau.dados_cadastrais.adapter.dynamo;

import com.itau.dados_cadastrais.adapter.dynamo.dadoscadastrais.entity.ClienteEntity;
import com.itau.dados_cadastrais.adapter.dynamo.dadoscadastrais.repository.DadosCadastraisRepository;
import com.itau.dados_cadastrais.adapter.dynamo.exception.ConsultarDadosCadastraisAdapterException;
import com.itau.dados_cadastrais.adapter.dynamo.mapper.ConsultarDadosCadastraisMapper;
import com.itau.dados_cadastrais.adapter.exception.DadosNaoEncontradosException;
import com.itau.dados_cadastrais.core.domain.Cliente;
import com.itau.dados_cadastrais.core.port.out.ConsultarDadosCadastraisPortOut;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class ConsultarDadosCadastraisAdapter implements ConsultarDadosCadastraisPortOut {

    private final DadosCadastraisRepository dadosCadastraisRepository;
    private final ConsultarDadosCadastraisMapper consultarDadosCadastraisMapper;


    @Override
    public Cliente execute(String idCliente) {
        try {
            Optional<ClienteEntity> clienteEntityResponse =
                    dadosCadastraisRepository.buscarPorChave(idCliente);

            return clienteEntityResponse.map(consultarDadosCadastraisMapper::toDomain)
                    .orElseThrow(() -> new DadosNaoEncontradosException("Cliente não encontrado na base de dados!"));
        } catch (Exception e) {
            throw new ConsultarDadosCadastraisAdapterException("Erro ao consultar Cliente na base de dados!", e);

        }
    }
}
