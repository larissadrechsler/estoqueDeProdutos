
package com.api.senac.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping; 

/**
 *
 * @author laris
 */
@Controller 
@RequestMapping("/cookies") 

public class CookiesController {
    
    @RequestMapping("/grava") 
    public String criaCookie(HttpServletResponse response){ 
    Cookie novoCookie = new Cookie("user-id", "123abc"); 
    response.addCookie(novoCookie); 
    return "lista-filmes"; 
    } 
    
    @RequestMapping("/le") 
    public String leCookie(@CookieValue(name="user-id", defaultValue="nenhum-valor")String userId, Model model){ 
        model.addAttribute("userid", userId); 
        return "lista-filmes"; 
    } 
    @RequestMapping("/exclui") 
    public String excluiCookie(HttpServletResponse response){ 
        Cookie novoCookie = new Cookie("user-id", null); 
        novoCookie.setMaxAge(0); 
        response.addCookie(novoCookie); 
        return "lista-filmes"; 
    } 
}
