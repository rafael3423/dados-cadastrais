package com.itau.dados_cadastrais.adapter.dynamo;

import com.itau.dados_cadastrais.adapter.dynamo.dadoscadastrais.entity.ClienteEntity;
import com.itau.dados_cadastrais.adapter.dynamo.dadoscadastrais.repository.DadosCadastraisRepository;
import com.itau.dados_cadastrais.adapter.dynamo.exception.AtualizarDadosCadastraisAdapterException;
import com.itau.dados_cadastrais.adapter.dynamo.mapper.AtualizarDadosCadastraisMapper;
import com.itau.dados_cadastrais.core.domain.Cliente;
import com.itau.dados_cadastrais.core.port.out.AtualizarDadosCadastraisPortOut;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class AtualizarDadosCadastraisAdapter implements AtualizarDadosCadastraisPortOut {

    private final DadosCadastraisRepository dadosCadastraisRepository;
    private final AtualizarDadosCadastraisMapper atualizarDadosCadastraisMapper;

    @Override
    public Cliente execute(String idCliente, Cliente cliente) {
        try {
            Optional<ClienteEntity> clienteEntityResponse =
                    dadosCadastraisRepository.atualizar(atualizarDadosCadastraisMapper
                            .toEntity(cliente));

            if (clienteEntityResponse.isPresent()) {
                return cliente;
            }
            throw new AtualizarDadosCadastraisAdapterException("Não foi possível atualizar os dados cadastrais.");

        } catch (Exception e) {
            throw new AtualizarDadosCadastraisAdapterException("Não foi possível atualizar os dados cadastrais: {}", e);
        }

    }
}
