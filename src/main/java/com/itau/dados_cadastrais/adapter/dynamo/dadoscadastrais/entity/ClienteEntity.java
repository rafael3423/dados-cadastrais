package com.itau.dados_cadastrais.adapter.dynamo.dadoscadastrais.entity;

import com.itau.dados_cadastrais.adapter.dynamo.infraestrutura.BaseEntity;
import com.itau.dados_cadastrais.adapter.dynamo.infraestrutura.annotations.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@Data
@Builder
@Entity(tableName = "tb_dados_cadastrais")
@DynamoDbBean
@NoArgsConstructor
@AllArgsConstructor
public class ClienteEntity implements BaseEntity {

    private String idCliente;
    private String cpfCliente;
    private String codigoTipoPessoa;
    private String dataHoraCadastro;
    private String dataHoraUltimaAutalizacao;
    private String endereco;
    private String numeroCelular;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("cod_idef_pess")
    public String getIdCliente() {
        return idCliente;
    }

    @DynamoDbSortKey
    @DynamoDbAttribute("num_cpf_clie")
    public String getCpfCliente() {
        return cpfCliente;
    }

    @DynamoDbAttribute("cod_tipo_pess")
    public String getCodigoTipoPessoa() {
        return codigoTipoPessoa;
    }
    @DynamoDbAttribute("dat_hor_cad")
    public String getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    @DynamoDbAttribute("dat_hor_atui")
    public String getDataHoraUltimaAutalizacao() {
        return dataHoraUltimaAutalizacao;
    }

    @DynamoDbAttribute("nom_end_clie")
    public String getEndereco() {
        return endereco;
    }

    @DynamoDbAttribute("num_cel_clie")
    public String getNumeroCelular() {
        return numeroCelular;
    }

    @Override
    public void setKey(String key) {
        this.idCliente = key;
    }
}
