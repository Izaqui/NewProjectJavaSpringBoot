package com.example.sistemProject.service;

import com.example.sistemProject.model.Produto;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto buscarProdutoPorId(Long id) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        return produtoOptional.orElse(null);
    }

    public Produto atualizarProduto(@NotNull Produto produto) {
        if (produto.getId() == null) {
            throw new IllegalArgumentException("ID do produto não pode ser nulo para atualização.");
        }
        return produtoRepository.save(produto);
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}