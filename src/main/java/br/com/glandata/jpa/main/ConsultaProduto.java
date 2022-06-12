package br.com.glandata.jpa.main;

import java.util.Optional;

import javax.persistence.EntityManager;

import br.com.glandata.jpa.dao.ProdutoDao;
import br.com.glandata.jpa.model.Produto;
import br.com.glandata.jpa.util.JPAUtil;

public class ConsultaProduto {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);

		Optional<Produto> produto = Optional.ofNullable(produtoDao.buscaPorId(2L));
		System.out.println("Produto: " + (produto.isPresent() ? produto.get().getNome() : "Produto Não Encontrado!!"));

//		try {
//			String nomeProduto = "TV";
//			BigDecimal precoProduto = produtoDao.buscarPreco(nomeProduto);
//			System.out.println("O preço de " + nomeProduto + " é: " + precoProduto);
//		} catch (Exception e) {
//			System.out.println("Produto não encontrado!");
//		}

	}

}
