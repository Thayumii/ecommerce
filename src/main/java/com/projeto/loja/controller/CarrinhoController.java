package com.projeto.loja.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.loja.dto.CarrinhoDTO;
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
    public CarrinhoDTO criarCarrinho(@RequestBody Carrinho carrinho) {
        Carrinho salvo = carrinhoService.salvar(carrinho);
        return CarrinhoDTO.fromEntity(salvo);
    }

    @GetMapping
    public List<CarrinhoDTO> listaCarrinho(){
        return carrinhoService.listar().stream().map(CarrinhoDTO::fromEntity).toList();
    }

    @GetMapping("/{id}")
    public CarrinhoDTO buscarPorId(@PathVariable Long id) {
        Carrinho carrinho = carrinhoService.buscarPorId(id).orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));
        return CarrinhoDTO.fromEntity(carrinho);
    }
    
    @PutMapping("/{id}")
    public CarrinhoDTO atualizaCarrinho(@PathVariable Long id, @RequestBody Carrinho carrinho) {
        carrinho.setId(id);
        Carrinho atualizado = carrinhoService.salvar(carrinho);
        return CarrinhoDTO.fromEntity(atualizado);
    }

    @DeleteMapping("/{id}")
    public void deletarCarrinho(@PathVariable Long id) {
        carrinhoService.deletar(id);
    }

    
}
