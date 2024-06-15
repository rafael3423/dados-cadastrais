package com.itau.dados_cadastrais.core.port.in;

import com.itau.dados_cadastrais.core.domain.Cliente;
import javassist.NotFoundException;

public interface CadastrarDadosCadastraisPortIn {

    Cliente execute(Cliente cliente, String cpf) throws NotFoundException;
}
