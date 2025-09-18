package com.projeto.loja.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projeto.loja.model.ItemCarrinho;
import com.projeto.loja.repository.ItemCarrinhoRepository;

@Service
public class ItemCarrinhoService {

    private final ItemCarrinhoRepository itemCarrinhoRepository;

    public ItemCarrinhoService(ItemCarrinhoRepository itemCarrinhoRepository) {
        this.itemCarrinhoRepository = itemCarrinhoRepository;
    }

    public ItemCarrinho salvarItemCarrinho(ItemCarrinho itemCarrinho) {
        return itemCarrinhoRepository.save(itemCarrinho);
    }

    public List<ItemCarrinho> listarItemCarrinhos() {
        return itemCarrinhoRepository.findAll();
    }

    public Optional<ItemCarrinho> buscarPorId(Long id) {
        return itemCarrinhoRepository.findById(id);
    }

    public void deletar(Long id) {
        itemCarrinhoRepository.deleteById(id);
    }
}
