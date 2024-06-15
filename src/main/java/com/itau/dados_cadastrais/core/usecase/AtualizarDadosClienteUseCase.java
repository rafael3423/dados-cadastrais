package com.itau.dados_cadastrais.core.usecase;

import com.itau.dados_cadastrais.core.domain.Cliente;
import com.itau.dados_cadastrais.core.port.in.AtualizarDadosCadastraisPortIn;
import com.itau.dados_cadastrais.core.port.out.AtualizarDadosCadastraisPortOut;
import com.itau.dados_cadastrais.core.port.out.SalvarAlteracoesDBPortOut;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class AtualizarDadosClienteUseCase implements AtualizarDadosCadastraisPortIn {

    private final AtualizarDadosCadastraisPortOut atualizarDadosCadastraisPortOut;
    private final SalvarAlteracoesDBPortOut salvarAlteracoesDBPortOut;

    @Override
    public Cliente execute(String idCliente, Cliente cliente) throws NotFoundException {
        cliente.definirDataHoraAtualizacao();
        atualizarDadosCadastraisPortOut.execute(idCliente, cliente);
        salvarAlteracoesDBPortOut.execute(cliente, cliente.getCpfCliente());
        return cliente;
    }
}
