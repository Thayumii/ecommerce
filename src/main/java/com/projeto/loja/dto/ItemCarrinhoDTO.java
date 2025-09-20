package com.projeto.loja.dto;

import com.projeto.loja.model.ItemCarrinho;

public class ItemCarrinhoDTO {
    private Long id;
    private Long produtoId;
    private Integer quantidade;
    private Double subtotal;

    public ItemCarrinhoDTO() {}

    public ItemCarrinhoDTO(Long id, Long produtoId, Integer quantidade, Double subtotal ) {
        this.id = id;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
        this.subtotal = subtotal;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getProdutoId() {
        return produtoId;
    }
    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public Double getSubtotal() {
        return subtotal;
    }
    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }


    public static ItemCarrinhoDTO fromEntity(ItemCarrinho item) {
        if (item == null) return null;
        Long prodId = item.getProduto() != null ? item.getProduto().getId() : null;
        return new ItemCarrinhoDTO(
            item.getId(),
            prodId,
            item.getQuantidade(),
            item.getSubtotal()
        );
    }

}
