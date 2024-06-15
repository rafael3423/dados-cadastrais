package com.itau.dados_cadastrais.core.config;

import com.itau.dados_cadastrais.core.observer.AtualizarDadosObserver;
import com.itau.dados_cadastrais.core.observer.CadastrarDadosObserver;
import com.itau.dados_cadastrais.core.port.out.CadastrarDadosCadastraisPortOut;
import com.itau.dados_cadastrais.core.port.out.SalvarAlteracoesDBPortOut;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class CadastrarDadosCadastraisFactory {
    private final CadastrarDadosCadastraisPortOut cadastrarDadosCadastraisPortOut;
    private final SalvarAlteracoesDBPortOut salvarAlteracoesDBPortOut;

    @Bean
    public List<CadastrarDadosObserver> definirStepsCadastrarDados(){
        return List.of(cadastrarDadosCadastraisPortOut, salvarAlteracoesDBPortOut);
    }
}
