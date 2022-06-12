package br.com.glandata.jpa.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.glandata.jpa.model.Produto;

public class ProdutoDao {

	private EntityManager em;

	public ProdutoDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Produto produto) {
		em.persist(produto);
	}

	public void atualizar(Produto produto) {
		em.merge(produto);
	}

	public void deletar(Produto produto) {
		em.remove(produto);
	}

	public Produto buscaPorId(Long id) {
		return em.find(Produto.class, id);
	}

	public List<Produto> listarProdutos() {
		String jpql = "SELECT p FROM Produto p";
		return em.createQuery(jpql, Produto.class).getResultList();
	}

	public List<Produto> buscarPorNome(String nome) {
		String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
		return em.createQuery(jpql, Produto.class).setParameter("nome", nome).getResultList();
	}

	public List<Produto> listaProdutosPorCategoria(String categoria) {
//		String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :categoria";
		String jpql = "SELECT p FROM Produto p JOIN p.categoria c WHERE c.nome = :categoria";
		return em.createQuery(jpql, Produto.class).setParameter("categoria", categoria).getResultList();
	}

	public BigDecimal buscarPreco(String nome) {
		String jpql = "SELECT p.valor FROM Produto p WHERE p.nome = :nome";
		return em.createQuery(jpql, BigDecimal.class).setParameter("nome", nome).setMaxResults(1).getSingleResult();
	}
}
