package com.AppProjetoIntegrador.appPI.controller;

import com.AppProjetoIntegrador.appPI.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BuscaController {

    @Autowired
    private ProdutoRepository pr;


    //POST
    @RequestMapping(value = "/busca", method = RequestMethod.POST)
    public ModelAndView buscarIndex(@RequestParam("buscar") String buscar){

        ModelAndView mv = new ModelAndView("listar-busca");
        String mensagem = "Resultados da busca por " + buscar;
        mv.addObject("produtos", pr.findByTipoOuNomeProduto(buscar));
        mv.addObject("mensagem", mensagem);

        return mv;
    }

}
