package com.itau.dados_cadastrais.core.usecase;

import com.itau.dados_cadastrais.core.domain.Cliente;
import com.itau.dados_cadastrais.core.observer.CadastrarDadosObserver;
import com.itau.dados_cadastrais.core.port.in.CadastrarDadosCadastraisPortIn;
import com.itau.dados_cadastrais.core.port.out.CadastrarDadosCadastraisPortOut;
import com.itau.dados_cadastrais.core.port.out.SalvarAlteracoesDBPortOut;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CadastrarDadosClienteUseCase implements CadastrarDadosCadastraisPortIn {

    private final List<CadastrarDadosObserver> cadastrarDadosObserverList;

    @Override
    public Cliente execute(Cliente cliente, String cpf) throws NotFoundException {
        cliente.definirDataHoraCadastro();
        cliente.definirDataHoraAtualizacao();
        cliente.formartarCpf();
        cadastrarDadosObserverList.forEach(o-> o.execute(cliente, cpf));
        return cliente;
    }
}
