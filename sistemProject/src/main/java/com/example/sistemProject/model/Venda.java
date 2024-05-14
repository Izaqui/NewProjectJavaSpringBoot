package com.example.sistemProject.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime data;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Produto> produtos;

    private double valorTotal;

    // Construtor padrão vazio
    public Venda() {
    }

    // Construtor com parâmetros
    public Venda(LocalDateTime data, List<Produto> produtos, double valorTotal) {
        this.data = data;
        this.produtos = produtos;
        this.valorTotal = valorTotal;
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    // Método para adicionar um produto à lista de produtos da venda
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    // Método para remover um produto da lista de produtos da venda
    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    // Método para calcular o valor total da venda
    public void calcularValorTotal() {
        double total = 0;
        for (Produto produto : produtos) {
            total += produto.getPreco();
        }
        this.valorTotal = total;
    }
}
