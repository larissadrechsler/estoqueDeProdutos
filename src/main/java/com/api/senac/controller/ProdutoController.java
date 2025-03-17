/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.senac.controller;

import com.api.senac.data.ProdutoEntity;
import com.api.senac.model.Produto;
import com.api.senac.service.ProdutoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author laris
 */
@Controller
public class ProdutoController {

    private List<Produto> produtos = new ArrayList();
    @Autowired
    ProdutoService produtoService;

    @GetMapping("/exibir-produto")
    public String exibirProduto(Model model) {

        // Criando uma nova instância da classe "produto" com os valores especificados 
        //Produto produto = new Produto(1, "Camiseta Oversized", "P", 5, 25.5);
        //model.addAttribute("produto", produto);
        model.addAttribute("produto", produtoService.listarTodosProdutos());
        // Retornando o nome da visualização (view) que será renderizada 
        return "estoque";
    }

    @GetMapping("/estoque")
    public String listaProdutos(Model model) {
        // Criação de objetos produto e adição à coleção produtos 
        //produtos.add(new Produto(1, "Camiseta Oversized", "M", 15, 25.5));
        //produtos.add(new Produto(1, "Camiseta Oversized", "G", 8, 25.5));
        //produtos.add(new Produto(1, "Camiseta Oversized", "GG", 12, 25.5));

        // Adição da coleção produtos ao modelo 
        model.addAttribute("produtos", produtos);
        model.addAttribute("produtos", produtoService.listarTodosProdutos()); 
        // Retorna o nome da página que será renderizada 
        return "estoque";
    }

    @GetMapping("/cadastro")
    public String exibirFormulario(Model model) {
        // Cria uma nova instância da classe e a adiciona ao modelo 
        ProdutoEntity produto = new ProdutoEntity();
        model.addAttribute("produto", produto);
        //model.addAttribute("produto", new Produto());

        // Retorna o nome do template "cadastro" para exibir o formulário 
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String processarFormulario(@ModelAttribute ProdutoEntity produto, BindingResult result) {
        if (result.hasErrors()) {
            return "cadastro";
        }
        if (produto.getId() == null) {
            produtoService.criarProduto(produto);
        } else {
            produtoService.atualizarProduto(produto.getId(), produto);
        }
        // Adiciona o filme à lista de filmes (supondo que "filmes" seja uma lista já existente) 
        //filmes.add(filme); 
        // Adiciona o filme ao modelo para ser exibida no template "exibir-filme" 
        //model.addAttribute("filme", filme); 
        // Retorna o nome do template "exibir-filme" para exibir os detalhes do filme 
        return "estoque";
    }
    
    /*
    @PostMapping("/cadastro") 
    public String processarFormulario(@ModelAttribute Produto produto, Model model) { 
        produtos.add(produto);
        model.addAttribute("produto", produto);
        return "estoque";
    }
    */
    @GetMapping("/deletarProduto/{id}")
    public String deletarProduto(@PathVariable(value = "id") Integer id) {
        produtoService.deletarProduto(id);
        //produtos.remove(produtos.indexOf(id));
        return "estoque";

    }
}
