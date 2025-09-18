package com.projeto.loja.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.loja.model.ItemCarrinho;
import com.projeto.loja.service.ItemCarrinhoService;

@RestController
@RequestMapping("/itemcarrinhos")
public class ItemCarrinhoController {

    private final ItemCarrinhoService itemCarrinhoService;

    public ItemCarrinhoController(ItemCarrinhoService itemCarrinhoService) {
        this.itemCarrinhoService = itemCarrinhoService;
    }

    @PostMapping
    public ItemCarrinho criarItemCarrinho(@RequestBody ItemCarrinho itemCarrinho) {
        return itemCarrinhoService.salvarItemCarrinho(itemCarrinho);
    }

    @GetMapping
    public List<ItemCarrinho> listarItemCarrinhos() {
       return itemCarrinhoService.listarItemCarrinhos(); 
    }

    @GetMapping("/{id}")
    public Optional<ItemCarrinho> buscarPorId(@PathVariable Long id) {
        return itemCarrinhoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ItemCarrinho atualItemCarrinho(@PathVariable Long id, @RequestBody ItemCarrinho itemCarrinho) {
        itemCarrinho.setId(id);
        return itemCarrinhoService.salvarItemCarrinho(itemCarrinho);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        itemCarrinhoService.deletar(id);
    }
}
