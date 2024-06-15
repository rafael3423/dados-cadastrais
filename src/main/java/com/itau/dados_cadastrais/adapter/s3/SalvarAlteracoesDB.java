package com.itau.dados_cadastrais.adapter.s3;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itau.dados_cadastrais.core.domain.Cliente;
import com.itau.dados_cadastrais.core.port.out.SalvarAlteracoesDBPortOut;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class SalvarAlteracoesDB implements SalvarAlteracoesDBPortOut {

    private final ObjectMapper mapper;

    @Override
    public void execute(Cliente cliente, String cpf) {
        String filePath = "C:\\Users\\rmbfkhr\\IdeaProjects\\dados-cadastrais\\dados-cadastrais\\src\\main\\resources\\dynamoDBupdatedData\\"
                + cliente.getIdCliente() + ".json";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(mapper.writeValueAsString(cliente));
            log.info("Dados alterados no dynamo salvos com sucesso!");
        } catch (IOException e) {
            log.info("Erro ao salvar dados de atualização no DynamoDB");
        }
    }
}
