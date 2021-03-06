package com.comparapreco.dtos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.comparapreco.models.Loja;
import com.comparapreco.models.Produto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ProdutoDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5052620967082868145L;
	private Integer id;
	private String nome;
	private String foto;
	private Double preco;
	private String nomeMarca;
	private String nomeCategoria;
	@JsonIgnoreProperties("produtos")
	private Set<Loja> lojas;
	
	public ProdutoDTO() {}
	
	public ProdutoDTO(Produto produto) {
		this.setId(produto.getId());
		this.setNome(produto.getNome());
		this.setFoto(produto.getFoto());
		this.setPreco(produto.getPreco());
		this.setNomeMarca(produto.getMarca().getNome());
		this.setNomeCategoria(produto.getCategoria().getNome());
		this.setLojas(produto.getLojas());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getNomeMarca() {
		return nomeMarca;
	}

	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public Set<Loja> getLojas() {
		return lojas;
	}

	public void setLojas(Set<Loja> lojas) {
		this.lojas = lojas;
	}

}



	