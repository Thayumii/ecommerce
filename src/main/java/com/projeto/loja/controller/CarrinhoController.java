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

import com.projeto.loja.model.Carrinho;
import com.projeto.loja.service.CarrinhoService;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    private final CarrinhoService carrinhoService;

    public CarrinhoController(CarrinhoService carrinhoService) {
        this.carrinhoService = carrinhoService;
    }

    @PostMapping
    public Carrinho criarCarrinho(@RequestBody Carrinho carrinho) {
        return carrinhoService.salvar(carrinho);
    }

    @GetMapping
    public List<Carrinho> listaCarrinho(){
        return carrinhoService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Carrinho> buscarPorId(@PathVariable Long id) {
        return carrinhoService.buscarPorId(id);
    }
    
    @PutMapping("/{id}")
    public Carrinho atualizaCarrinho(@PathVariable Long id, @RequestBody Carrinho carrinho) {
        carrinho.setId(id);
        return carrinhoService.salvar(carrinho);
    }

    @DeleteMapping("/{id}")
    public void deletarCarrinho(@PathVariable Long id) {
        carrinhoService.deletar(id);
    }

    
}
