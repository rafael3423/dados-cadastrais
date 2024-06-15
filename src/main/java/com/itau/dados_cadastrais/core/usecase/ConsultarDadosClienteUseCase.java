package com.itau.dados_cadastrais.core.usecase;

import com.itau.dados_cadastrais.adapter.dynamo.exception.ConsultarDadosCadastraisAdapterException;
import com.itau.dados_cadastrais.core.domain.Cliente;
import com.itau.dados_cadastrais.core.port.in.ConsultarDadosCadastraisPortIn;
import com.itau.dados_cadastrais.core.port.out.ConsultarDadosCadastraisPortOut;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConsultarDadosClienteUseCase implements ConsultarDadosCadastraisPortIn {

    private final ConsultarDadosCadastraisPortOut consultarDadosCadastraisPortOut;

    @Override
    public Cliente execute(String idCliente) throws NotFoundException {
            return consultarDadosCadastraisPortOut.execute(idCliente);
    }
}
