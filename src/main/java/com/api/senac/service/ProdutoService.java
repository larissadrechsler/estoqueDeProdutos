package com.api.senac.service;

import com.api.senac.data.ProdutoEntity;
import com.api.senac.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.senac.data.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public ProdutoEntity criarProduto(ProdutoEntity produto) {
        produto.setId(null);
        produtoRepository.save(produto);
        return produto;
    }

    public ProdutoEntity atualizarProduto(Integer id, ProdutoEntity produtoRequest) {
        ProdutoEntity produto = getProdutoId(id);
        produto.setPeca(produtoRequest.getPeca());
        produto.setTamanho(produtoRequest.getTamanho());
        produto.setQuantidade(produtoRequest.getQuantidade());
        produto.setPreco(produtoRequest.getPreco());
        produtoRepository.save(produto);
        return produto;
    }

    public ProdutoEntity getProdutoId(Integer id) {
        return produtoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado " + id));
    }

    public List<ProdutoEntity> listarTodosProdutos() {
        return produtoRepository.findAll();
    }

    public void deletarProduto(Integer id) {
        ProdutoEntity func = getProdutoId(id);
        produtoRepository.deleteById(func.getId());
    }

//    public List<FilmeEntity> getFilmePorNome(String nome) { 
//        return filmeRepository.findByNomeContaining(nome);     
//    } 
}
