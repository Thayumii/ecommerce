package com.projeto.loja.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.loja.dto.ItemCarrinhoDTO;
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
    public ItemCarrinhoDTO criarItemCarrinho(@RequestBody ItemCarrinho itemCarrinho) {
        ItemCarrinho salvo =  itemCarrinhoService.salvarItemCarrinho(itemCarrinho);
        return ItemCarrinhoDTO.fromEntity(salvo);
    }

    @GetMapping
    public List<ItemCarrinhoDTO> listarItemCarrinhos() {
       return itemCarrinhoService.listarItemCarrinhos().stream().map(ItemCarrinhoDTO::fromEntity).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ItemCarrinhoDTO buscarPorId(@PathVariable Long id) {
        ItemCarrinho item = itemCarrinhoService.buscarPorId(id).orElseThrow(() -> new RuntimeException("Item do carrinho não encontrado"));
        return ItemCarrinhoDTO.fromEntity(item);
    }

    @PutMapping("/{id}")
    public ItemCarrinhoDTO atualItemCarrinho(@PathVariable Long id, @RequestBody ItemCarrinho itemCarrinho) {
        itemCarrinho.setId(id);
        ItemCarrinho atualizado =  itemCarrinhoService.salvarItemCarrinho(itemCarrinho);
        return ItemCarrinhoDTO.fromEntity(atualizado);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        itemCarrinhoService.deletar(id);
    }
}
