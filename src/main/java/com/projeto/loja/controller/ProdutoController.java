package com.projeto.loja.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.loja.dto.ProdutoDTO;
import com.projeto.loja.model.Produto;
import com.projeto.loja.service.ProdutoService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ProdutoDTO criarProduto(@RequestBody Produto produto) {
        Produto salvo = produtoService.salvar(produto);
        return ProdutoDTO.fromEntity(salvo);
    }

    @GetMapping
    public List<ProdutoDTO> listaProdutos() {
        return produtoService.listarTodos().stream().map(ProdutoDTO::fromEntity).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProdutoDTO buscarPorId(@PathVariable Long id) {
        Produto produto = produtoService.buscarPorId(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return ProdutoDTO.fromEntity(produto);
    }

    @PutMapping("/{id}")
    public ProdutoDTO atualizaProduto(@PathVariable Long id, @RequestBody Produto produto) {
        produto.setId(id);
        Produto atualizado = produtoService.salvar(produto);
        return ProdutoDTO.fromEntity(atualizado);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id) {
        produtoService.deletar(id);
    }
    

}
