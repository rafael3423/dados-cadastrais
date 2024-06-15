package com.itau.dados_cadastrais.core.port.in;

import com.itau.dados_cadastrais.core.domain.Cliente;
import javassist.NotFoundException;

public interface ConsultarDadosCadastraisPortIn {

    Cliente execute(String idCliente) throws NotFoundException;
}
