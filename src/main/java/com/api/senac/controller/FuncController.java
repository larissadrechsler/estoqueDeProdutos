/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template

package com.api.senac.controller;
import com.api.senac.data.FilmeEntity; 
import com.api.senac.service.FilmeService; 
import jakarta.validation.Valid; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.validation.BindingResult; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping; 

@Controller 

public class FuncController { 
    @Autowired 
    FilmeService funcionarioService; 
    @GetMapping("/") 
    public String viewHomePage(Model model) { 
        model.addAttribute("listarFuncionarios", funcionarioService.listarTodosFuncionarios()); 
        return "index"; 
    } 

    @GetMapping("/deletarFuncionario/{id}") 
    public String deletarFuncionario(@PathVariable(value = "id") Integer id) { 
        funcionarioService.deletarFuncionario(id); 
        return "redirect:/"; 
    } 

    @GetMapping("/criarFuncionarioForm") 
    public String criarFuncionarioForm(Model model) { 
        FilmeEntity func = new FilmeEntity(); 
        model.addAttribute("funcionario", func); 
        return "inserir"; 
    } 

    @PostMapping("/salvarFuncionario") 
    public String salvarFuncionario(@Valid @ModelAttribute("funcionario") FilmeEntity func, BindingResult result) { 
        if (result.hasErrors()) { 
            return "inserir"; 
        } 
        if (func.getId()==null) { 
            funcionarioService.criarFuncionario(func); 
        } else { 
            funcionarioService.atualizarFuncionario(func.getId(), func); 
        } 
        return "redirect:/"; 
    } 

    @GetMapping("/atualizarFuncionarioForm/{id}") 

    public String atualizarFuncionarioForm(@PathVariable(value = "id") Integer id, Model model) { 
    FilmeEntity func = funcionarioService.getFuncionarioId(id); 
    model.addAttribute("funcionario", func); 
    return "atualizar"; 
    } 
} 
 */