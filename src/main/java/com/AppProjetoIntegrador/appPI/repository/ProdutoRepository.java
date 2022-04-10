package com.AppProjetoIntegrador.appPI.repository;

import com.AppProjetoIntegrador.appPI.model.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
    Produto findByIdproduto(long idproduto);

    List<Produto> findByNome(String nome);

    @Query(value = "select u from Produto u where u.nome like %?1%")
    List<Produto>findByNomeProduto(String nome);

    @Query(value = "select u from Produto u where u.tipo like %?1%")
    List<Produto>findByTipo(String tipo);

    @Query(value = "select u from Produto u where u.tipo like %?1% or u.nome like %?1%")
    List<Produto>findByTipoOuNomeProduto(String nome);

    List<Produto> findTop4ByOrderByNome();
}
