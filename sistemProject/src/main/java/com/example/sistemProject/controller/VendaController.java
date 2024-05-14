package com.example.sistemProject.controller;

import com.example.sistemProject.model.Venda;
import com.example.sistemProject.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping
    public ResponseEntity<Venda> realizarVenda(@RequestBody Venda venda) {
        Venda novaVenda = vendaService.realizarVenda(venda);
        return new ResponseEntity<>(novaVenda, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Venda>> listarVendas() {
        List<Venda> vendas = vendaService.listarVendas();
        return new ResponseEntity<>(vendas, HttpStatus.OK);
    }

    // Adicione outros métodos conforme necessário
}
