package com.projeto.loja.service;

import com.projeto.loja.model.Cliente;
import com.projeto.loja.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // criar/atualizar cliente
    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    // listar todos
    public List<Cliente> listarTodos(){
        return clienteRepository.findAll();
    }

    // buscar por ID
    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    // deletar cliente
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

}
