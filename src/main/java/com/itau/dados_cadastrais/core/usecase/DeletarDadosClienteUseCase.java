package com.itau.dados_cadastrais.core.usecase;

import com.itau.dados_cadastrais.core.port.in.DeletarDadosCadastraisPortIn;
import com.itau.dados_cadastrais.core.port.out.DeletarDadosCadastraisPortOut;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeletarDadosClienteUseCase implements DeletarDadosCadastraisPortIn {

    private final DeletarDadosCadastraisPortOut deletarDadosCadastraisPortOut;

    @Override
    public void execute(String idCliente, String cpf) {
        deletarDadosCadastraisPortOut.execute(idCliente, cpf);
    }
}
