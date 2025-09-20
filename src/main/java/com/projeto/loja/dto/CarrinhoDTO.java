package com.projeto.loja.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.projeto.loja.model.Carrinho;

public class CarrinhoDTO {
    private Long id;
    private Long clienteId;
    private Double valorTotal;
    private List<ItemCarrinhoDTO> itens;

    public CarrinhoDTO() {}

    public CarrinhoDTO(Long id, Long clienteId, Double valorTotal, List<ItemCarrinhoDTO> itens) {
        this.id = id;
        this.clienteId = clienteId;
        this.valorTotal = valorTotal;
        this.itens = itens;
    }

    // getters e setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getClienteId() {
        return clienteId;
    }
    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
    public Double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
    public List<ItemCarrinhoDTO> getItens() {
        return itens;
    }
    public void setItens(List<ItemCarrinhoDTO> itens) {
        this.itens = itens;
    }

    // conversão entidade -> dto
    public static CarrinhoDTO fromEntity(Carrinho carrinho) {
        if (carrinho == null) return null;

        CarrinhoDTO dto = new CarrinhoDTO();
        dto.setId(carrinho.getId());

        if (carrinho.getCliente() != null) {
            dto.setClienteId(carrinho.getCliente().getId());
        }

        dto.setValorTotal(carrinho.getValorTotal());

        if (carrinho.getItens() != null) {
            List<ItemCarrinhoDTO> itensDTO = carrinho.getItens().stream().map(ItemCarrinhoDTO::fromEntity).collect(Collectors.toList());
            dto.setItens(itensDTO);
        }
        return dto;
    }

}
