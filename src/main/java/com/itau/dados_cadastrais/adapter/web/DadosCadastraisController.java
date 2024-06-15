package com.itau.dados_cadastrais.adapter.web;

import com.itau.dados_cadastrais.adapter.web.mapper.ClienteMapper;
import com.itau.dados_cadastrais.adapter.web.model.request.ClienteRequestDTO;
import com.itau.dados_cadastrais.adapter.web.model.response.ClienteResponseDTO;
import com.itau.dados_cadastrais.core.port.in.AtualizarDadosCadastraisPortIn;
import com.itau.dados_cadastrais.core.port.in.CadastrarDadosCadastraisPortIn;
import com.itau.dados_cadastrais.core.port.in.ConsultarDadosCadastraisPortIn;
import com.itau.dados_cadastrais.core.port.in.DeletarDadosCadastraisPortIn;
import jakarta.validation.Valid;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/v1/dados-cadastrais")
@RequiredArgsConstructor
public class DadosCadastraisController {

    private final CadastrarDadosCadastraisPortIn cadastrarClientePortIn;
    private final ConsultarDadosCadastraisPortIn consultarDadosClientePortIn;
    private final AtualizarDadosCadastraisPortIn atualizarDadosClientePortIn;
    private final DeletarDadosCadastraisPortIn deletarDadosClientePortIn;
    private final ClienteMapper clienteMapper;

    @PostMapping("/cadastrar")
    public ResponseEntity<ClienteResponseDTO> salvarDadosCadastrais(@RequestBody @Valid ClienteRequestDTO clienteRequestDTO) throws NotFoundException {
        clienteRequestDTO.setIdCliente(String.valueOf(UUID.randomUUID()));
        log.info("Iniciando registro de dados de um novo cliente.");
        var cliente = cadastrarClientePortIn.execute(clienteMapper.toModel(clienteRequestDTO), clienteRequestDTO.getCpfCliente());
        var clienteResponseDTO = clienteMapper.toResponseDTO(cliente);
        log.info("Cliente gerado com sucesso: {}", clienteResponseDTO);

        return new ResponseEntity<>(clienteResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/consultar/{id_cliente}")
    public ResponseEntity<ClienteResponseDTO> consultarDadosCadastrais(@PathVariable("id_cliente") String idCliente) throws NotFoundException {
        log.info("Iniciando busca de dados do cliente com o id: {}.", idCliente);
        var cliente = consultarDadosClientePortIn.execute(idCliente);
        var clienteResponseDTO = clienteMapper.toResponseDTO(cliente);
        log.info("Cliente encontrado com sucesso: {}", clienteResponseDTO);

        return new ResponseEntity<>(clienteResponseDTO, HttpStatus.OK);
    }

    @PutMapping("/atualizar/{id_cliente}")
    public ResponseEntity<ClienteResponseDTO> atualizarDadosCadastrais(@PathVariable("id_cliente") String idCliente,
                                                       @RequestBody ClienteRequestDTO clienteRequestDTO) throws NotFoundException {

        clienteRequestDTO.setIdCliente(idCliente);
        log.info("Iniciando atualização de dados do cliente com o id: {}.", idCliente);
        var cliente = atualizarDadosClientePortIn.execute(idCliente, clienteMapper.toModel(clienteRequestDTO));
        var clienteResponseDTO = clienteMapper.toResponseDTO(cliente);
        log.info("Cliente encontrado com sucesso: {}", clienteResponseDTO);
        return new ResponseEntity<>(clienteResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id_cliente}")
    public ResponseEntity<Void> deletarDadosCadastrais(@PathVariable("id_cliente") String idCliente,
                                       @RequestBody ClienteRequestDTO clienteRequestDTO) {

        log.info("Iniciando a deleção de dados do cliente com o id: {}.", idCliente);
        deletarDadosClientePortIn.execute(idCliente, clienteRequestDTO.getCpfCliente());
        log.info("Cliente deletado com sucesso!");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
