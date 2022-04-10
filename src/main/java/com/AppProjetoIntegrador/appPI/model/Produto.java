package com.AppProjetoIntegrador.appPI.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idproduto;

    private String nome;

    @NotEmpty
    private String preco;

    @NotNull
    private String tipo;

    @NotNull
    private String descricao;

    @NotNull
    private String valorEnergetico;

    @NotNull
    private String embalagem;

    @NotNull
    private String img;

    public long getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(long idproduto) {
        this.idproduto = idproduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValorEnergetico() {
        return valorEnergetico;
    }

    public void setValorEnergetico(String valorEnergetico) {
        this.valorEnergetico = valorEnergetico;
    }

    public String getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(String embalagem) {
        this.embalagem = embalagem;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }




}
