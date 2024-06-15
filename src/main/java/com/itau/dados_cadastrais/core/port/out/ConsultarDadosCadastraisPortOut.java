package com.itau.dados_cadastrais.core.port.out;
import com.itau.dados_cadastrais.core.domain.Cliente;
import javassist.NotFoundException;

public interface ConsultarDadosCadastraisPortOut {

    Cliente execute(String idCliente) throws NotFoundException;

}
