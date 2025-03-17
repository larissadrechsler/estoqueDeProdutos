/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.api.senac.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query; 

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Integer> {
    //FilmeEntity findByNome(String titulo); 
    //List<FilmeEntity> findByNomeStartingWith(String titulo); 
    //List<FilmeEntity> findByNomeEndingWith(String titulo); 
    //List<FilmeEntity> findByNomeContaining(String titulo); 
    //List<FilmeEntity> findByOrderByNomeAsc(); 
    //List<FilmeEntity> findByOrderByNomeDesc(); 
    //@Query(value="select MAX(salario) from Funcionario", nativeQuery=true) 
    //List<FilmeEntity> findAllMaiorSalario();
}
