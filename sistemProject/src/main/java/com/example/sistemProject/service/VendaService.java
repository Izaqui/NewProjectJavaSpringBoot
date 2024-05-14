package com.example.sistemProject.service;

import com.example.sistemProject.model.Produto;
import com.example.sistemProject.model.Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public VendaService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public Venda realizarVenda(Venda venda) {
        double valorTotal = 0.0;

        // Calcula o valor total da venda
        for (ProdutoVendido produtoVendido : venda.getProdutos()) {
            Produto produto = produtoVendido.getProduto();
            int quantidade = produtoVendido.getQuantidade();
            double preco = produto.getPreco();
            valorTotal += quantidade * preco;
        }

        venda.setValorTotal(valorTotal);

        // Salva a venda no banco de dados
        return vendaRepository.save(venda);
    }

    public List<Venda> listarVendas() {
        return vendaRepository.findAll();
    }

}
