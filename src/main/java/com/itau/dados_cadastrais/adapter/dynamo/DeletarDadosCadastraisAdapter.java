package com.itau.dados_cadastrais.adapter.dynamo;

import com.itau.dados_cadastrais.adapter.dynamo.dadoscadastrais.repository.DadosCadastraisRepository;
import com.itau.dados_cadastrais.adapter.dynamo.mapper.ConsultarDadosCadastraisMapper;
import com.itau.dados_cadastrais.core.port.out.DeletarDadosCadastraisPortOut;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DeletarDadosCadastraisAdapter implements DeletarDadosCadastraisPortOut {

    private final DadosCadastraisRepository dadosCadastraisRepository;

    @Override
    public void

    execute(String idCliente, String cpf) {
        dadosCadastraisRepository.deleteDynamoDBItem(idCliente, cpf);
    }
}
