package com.AppProjetoIntegrador.appPI.controller;

import com.AppProjetoIntegrador.appPI.model.Produto;
import com.AppProjetoIntegrador.appPI.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

// LISTAR PRODUTOS
    @RequestMapping("/produtos")
    public ModelAndView listarProduto() {
        ModelAndView produto = new ModelAndView("listar-produtos");
        Iterable<Produto> produtos = produtoRepository.findAll();
        produto.addObject("produtos", produtos);
        return produto;
    }


// DETALHE DO PRODUTO
    @RequestMapping(value = "/produtos/{idproduto}", method = RequestMethod.GET)
    public ModelAndView detalheProduto(@PathVariable("idproduto") long idproduto) {
        Produto produto = produtoRepository.findByIdproduto(idproduto);
        ModelAndView pv = new ModelAndView("produto");
        pv.addObject("produto", produto);
        List<Produto> produtos = produtoRepository.findTop4ByOrderByNome();
        pv.addObject("produtos", produtos);
        return pv;
    }

}
