package com.itau.dados_cadastrais.core.observer;

import com.itau.dados_cadastrais.core.domain.Cliente;

public interface CadastrarDadosObserver {

    void execute(Cliente cliente, String cpf);

}
