package com.itau.dados_cadastrais.core.port.out;

import com.itau.dados_cadastrais.core.observer.AtualizarDadosObserver;
import com.itau.dados_cadastrais.core.observer.CadastrarDadosObserver;

public interface SalvarAlteracoesDBPortOut extends CadastrarDadosObserver, AtualizarDadosObserver {

}
