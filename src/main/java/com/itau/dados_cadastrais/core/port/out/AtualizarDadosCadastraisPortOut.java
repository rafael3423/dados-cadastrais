package com.itau.dados_cadastrais.core.port.out;

import com.itau.dados_cadastrais.core.domain.Cliente;
import com.itau.dados_cadastrais.core.observer.AtualizarDadosObserver;
import javassist.NotFoundException;

public interface AtualizarDadosCadastraisPortOut {
    Cliente execute(String idCliente, Cliente cliente) throws NotFoundException;
}
