package com.projeto.loja.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    private Double valorTotal;

    @OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL)
    private List<ItemCarrinho> itens;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }
    public void setItens(List<ItemCarrinho> itens) {
        this.itens = itens;
    }

}
