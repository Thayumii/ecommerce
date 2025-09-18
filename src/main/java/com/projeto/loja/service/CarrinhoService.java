package com.projeto.loja.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.projeto.loja.model.Carrinho;
import com.projeto.loja.repository.CarrinhoRepository;

@Service
public class CarrinhoService {

    private final CarrinhoRepository carrinhoRepository;

    public CarrinhoService(CarrinhoRepository carrinhoRepository) {
        this.carrinhoRepository = carrinhoRepository;

    }

    public Carrinho salvar(Carrinho carrinho) {
        return carrinhoRepository.save(carrinho);
    }
    public List<Carrinho> listar() {
        return carrinhoRepository.findAll();
    }

    public Optional<Carrinho> buscarPorId(Long id) {
        return carrinhoRepository.findById(id);
    }

    public void deletar(Long id) {
        carrinhoRepository.deleteById(id);
    }

}
