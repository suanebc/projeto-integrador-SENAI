package com.AppProjetoIntegrador.appPI;

import com.AppProjetoIntegrador.appPI.model.Produto;
import com.AppProjetoIntegrador.appPI.repository.ProdutoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CargaBanco implements CommandLineRunner {

    private ProdutoRepository produtoRepository;

    public CargaBanco(ProdutoRepository produtoRepository) {

        this.produtoRepository = produtoRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Produto> produtos = new ArrayList<>();
        produtos.add(criarProduto("Nobre Chá Hortelâ com Maçâ", "15,90", "sache", "Sabor ideal para os dias frios, com plantas selecionas e possui uma combinação única. Efeito termogênico que auxilia em acelerar o metabolismo.", "15 Kcal por porção de 2,5 g", "Sacola de plástico com 20 Sachês", "sache1.svg"));
        produtos.add(criarProduto("Nobre Chá Camomila com Cravo", "19,90", "sache", "Sabor ideal para os dias frios, com plantas selecionas e possui uma combinação única. Efeito termogênico que auxilia em acelerar o metabolismo.", "15 Kcal por porção de 2,5 g", "Sacola de plástico com 20 Sachês", "sache2.svg"));
        produtos.add(criarProduto("Chá Nobre Boldo com Limão", "19,90", "sache", "abor ideal para os dias frios, com plantas selecionas e possui uma combinação única. Efeito termogênico que auxilia em acelerar o metabolismo.", "15 Kcal por porção de 2,5 g", "Sacola de plástico com 20 Sachês", "sache3.svg"));
        produtos.add(criarProduto("Nobre Chá Frutas Silvestres", "14,90", "sache", "Sabor ideal para os dias frios, com plantas selecionas e possui uma combinação única. Efeito termogênico que auxilia em acelerar o metabolismo.", "15 Kcal por porção de 2,5 g", "Sacola de plástico com 20 Sachês", "sache4.svg"));

        produtos.add(criarProduto("Nobre Chá Maçã com Lima", "6,90", "gelado", "Sabor ideal para se refrescar, uma combinação única. Efeito termogênico que auxilia em acelerar o metabolismo.", "25 Kcal por porção de 1,5 gr", "Lata 220ml", "gelado1.svg"));
        produtos.add(criarProduto("Nobre Chá Perâ Verde", "7,90", "gelado", "Sabor ideal para se refrescar, uma combinação única. Efeito termogênico que auxilia em acelerar o metabolismo.", "25 Kcal por porção de 1,5 gr", "Lata 220ml", "gelado2.svg"));
        produtos.add(criarProduto("Nobre Chá Frutas Cítricas", "7,90", "gelado", "Sabor ideal para se refrescar, uma combinação única. Efeito termogênico que auxilia em acelerar o metabolismo.", "25 Kcal por porção de 1,5 gr", "Lata 220ml", "gelado2.svg"));
        produtos.add(criarProduto("Nobre Chá Manga", "7,65","gelado", "Sabor ideal para se refrescar, uma combinação única. Efeito termogênico que auxilia em acelerar o metabolismo.","25 Kcal por porção de 1,5 gr", "Lata 220ml","gelado3.svg"));

        produtos.add(criarProduto("Nobre Chá Limão com Mel", "22,90", "capsula", "Uma combinação de ingredientes para relaxar. Efeito termogênico que auxilia em acelerar o metabolismo.", "23 Kcal por porção de 1,5 gr", "caixa com 10 unidades", "capsula1.svg"));
        produtos.add(criarProduto("Nobre Chá Cidreira com Maracujá", "21,90", "capsula", "Uma combinação de ingredientes para relaxar. Efeito termogênico que auxilia em acelerar o metabolismo.", "23 Kcal por porção de 1,5 gr","caixa com 10 unidades", "capsula2.svg"));
        produtos.add(criarProduto("Nobre Chá Amora com Rosa Silvestre", "21,90", "capsula", "Uma combinação de ingredientes para relaxar. Efeito termogênico que auxilia em acelerar o metabolismo.","23 Kcal por porção de 1,5 gr","caixa com 10 unidades","capsula3.svg"));
        produtos.add(criarProduto("Nobre Chá Camomila com Mel", "20,90", "capsula", "Uma combinação de ingredientes para relaxar. Efeito termogênico que auxilia em acelerar o metabolismo.","23 Kcal por porção de 1,5 gr", "caixa com 10 unidades", "capsula4.svg"));

        produtoRepository.saveAll(produtos);
    }

    private Produto criarProduto(String nome, String preco, String tipo, String descricao, String valorEnergetico, String embalagem, String img){
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setPreco(preco);
        produto.setTipo(tipo);
        produto.setDescricao(descricao);
        produto.setValorEnergetico(valorEnergetico);
        produto.setEmbalagem(embalagem);
        produto.setImg(img);
        return produto;
    }
}
