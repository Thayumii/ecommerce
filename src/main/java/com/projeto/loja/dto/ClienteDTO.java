package com.projeto.loja.dto;

import com.projeto.loja.model.Cliente;

public class ClienteDTO {
    private Long id;
    private String nome;
    private String email;
    private String endereco;

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public static ClienteDTO fromEntity(Cliente cliente) {
        if (cliente == null ) return null;

        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setEmail(cliente.getEmail());
        dto.setEndereco(cliente.getEndereco());
        return dto;
    }
    public Cliente toEntity() {
        Cliente cliente = new Cliente();
        cliente.setId(this.id);
        cliente.setNome(this.nome);
        cliente.setEmail(this.email);
        cliente.setEndereco(this.endereco);
        return cliente;
    }

}
