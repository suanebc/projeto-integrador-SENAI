package com.AppProjetoIntegrador.appPI.controller;

import com.AppProjetoIntegrador.appPI.model.Produto;
import com.AppProjetoIntegrador.appPI.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public ModelAndView index() {
        ModelAndView pv = new ModelAndView("index");
        List<Produto> produtosIndex = produtoRepository.findTop4ByOrderByNome();
        pv.addObject("produtos", produtosIndex);
        return pv;

    }
    @GetMapping("/contato")
    public String contato() {
        return "contato";

    }




}
