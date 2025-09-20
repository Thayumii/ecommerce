package com.projeto.loja.dto;

import com.projeto.loja.model.Produto;

public class ProdutoDTO {
    private Long id;
    private String nome;
    private String descricao;
    private Double preco;
    private Integer estoque;
    private String imagemUrl;

    public ProdutoDTO() {}

    public ProdutoDTO(Long id, String nome, String descricao, Double preco, Integer estoque, String imagemUrl) {

        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
        this.imagemUrl = imagemUrl;
    }
    
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
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Double getPreco() {
        return preco;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    public Integer getEstoque() {
        return estoque;
    }
    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }
    public String getImagemUrl() {
        return imagemUrl;
    }
    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public static ProdutoDTO fromEntity(Produto produto) {
        if (produto == null) return null;
        return new ProdutoDTO(
            produto.getId(),
            produto.getNome(),
            produto.getDescricao(),
            produto.getPreco(),
            produto.getEstoque(),
            produto.getImagemUrl()
        );
    }

}
