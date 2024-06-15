package com.itau.dados_cadastrais.adapter.dynamo;

import com.itau.dados_cadastrais.adapter.dynamo.dadoscadastrais.repository.DadosCadastraisRepository;
import com.itau.dados_cadastrais.adapter.dynamo.exception.CadastrarDadosCadastraisAdapterException;
import com.itau.dados_cadastrais.adapter.dynamo.mapper.CadastrarDadosCadastraisMapper;
import com.itau.dados_cadastrais.core.domain.Cliente;
import com.itau.dados_cadastrais.core.port.out.CadastrarDadosCadastraisPortOut;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CadastrarDadosCadastraisAdapter implements CadastrarDadosCadastraisPortOut {

    private final DadosCadastraisRepository dadosCadastraisRepository;
    private final CadastrarDadosCadastraisMapper cadastrarDadosCadastraisMapper;

    @Override
    public void execute(Cliente cliente, String cpf) {

        dadosCadastraisRepository.buscarPorSortkey(cliente.getIdCliente(), cpf)
                .ifPresent(c -> {
                    if (c.getCpfCliente().equals(cliente.getCpfCliente())) {
                        throw new CadastrarDadosCadastraisAdapterException("Cpf já cadastrado na base!.");
                    }
                });

        dadosCadastraisRepository.salvar(cadastrarDadosCadastraisMapper.toEntity(cliente));
    }
}
