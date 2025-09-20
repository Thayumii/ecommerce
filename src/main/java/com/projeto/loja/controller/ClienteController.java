package com.projeto.loja.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.loja.dto.ClienteDTO;
import com.projeto.loja.model.Cliente;
import com.projeto.loja.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ClienteDTO criar(@RequestBody ClienteDTO clienteDTO) {
        Cliente salvo = clienteService.salvar(clienteDTO.toEntity());
        return ClienteDTO.fromEntity(salvo);
    }

    @GetMapping
    public List<ClienteDTO> listar() {
        return clienteService.listarTodos().stream().map(ClienteDTO::fromEntity).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ClienteDTO buscarPorId(@PathVariable Long id) {
        Cliente cliente = clienteService.buscarPorId(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return ClienteDTO.fromEntity(cliente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        clienteService.deletar(id);
    }

}
