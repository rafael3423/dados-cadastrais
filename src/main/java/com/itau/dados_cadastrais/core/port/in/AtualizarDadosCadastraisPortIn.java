package com.itau.dados_cadastrais.core.port.in;

import com.itau.dados_cadastrais.core.domain.Cliente;
import javassist.NotFoundException;

public interface AtualizarDadosCadastraisPortIn {

    Cliente execute(String idCliente, Cliente cliente) throws NotFoundException;

}
