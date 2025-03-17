/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.senac.controller;

/**
 *
 * @author laris

import com.api.senac.data.ProdutoEntity;
import com.api.senac.service.ProdutoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController

@RequestMapping("/filme")
public class FilmesController {
    @Autowired 
    ProdutoService filmeService;
    
    @GetMapping("/listar")
    public ResponseEntity<List> getAllFilmes() { 
        List<ProdutoEntity> filmes = filmeService.listarTodosProdutos(); 
        return new ResponseEntity<>(filmes, HttpStatus.OK);
    }
    
    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<ProdutoEntity> getFilmeById(@PathVariable Integer id) { 
        ProdutoEntity filme = filmeService.getProdutoId(id); 
        return new ResponseEntity<>(filme, HttpStatus.OK); 
    } 

    @PostMapping("/adicionar") 
    public ResponseEntity<ProdutoEntity> addFilme(@Valid @RequestBody ProdutoEntity filme) {
        var novoFilme = filmeService.criarProduto(filme); 
        return new ResponseEntity<>(novoFilme, HttpStatus.CREATED); 
    }
    
    @PutMapping("/atualizar/{id}") 
    public ResponseEntity<ProdutoEntity> atualizarFilme(@PathVariable Integer id, @RequestBody ProdutoEntity filme) {
        var filmeAtualizado = filmeService.atualizarProduto(id, filme);
        return new ResponseEntity<>(filmeAtualizado, HttpStatus.OK);
    }
    
    @DeleteMapping("/deletar/{id}") 
    public ResponseEntity deletarFilme(@PathVariable Integer id) {
        filmeService.deletarProduto(id);
        return new ResponseEntity<>(HttpStatus.OK); 
    }
    
//    @GetMapping("/pesquisar-nome/{nome}") 
//    public ResponseEntity<List> getPesquisarPorNomeFilme(@PathVariable String nome) { 
//    List<FilmeEntity> filmes = filmeService.getFilmePorNome(nome); 
//    return new ResponseEntity<>(filmes, HttpStatus.OK); 
//    }
    
}
 */