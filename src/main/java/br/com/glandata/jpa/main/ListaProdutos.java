package br.com.glandata.jpa.main;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.glandata.jpa.dao.ProdutoDao;
import br.com.glandata.jpa.model.Produto;
import br.com.glandata.jpa.util.JPAUtil;

public class ListaProdutos {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();

		ProdutoDao produtoDao = new ProdutoDao(em);

		List<Produto> produtos = produtoDao.listarProdutos();

//		System.out.println("Lista todos os produtos");
//		for (Produto produto : produtos) {
//			System.out.println(produto.getId() + "\t" + produto.getNome() + "\t" + produto.getDescricao() + "\t"
//					+ produto.getValor() + "\t");
//		}
//		produtos.forEach(p -> System.out
//				.println(p.getId() + " \t " + p.getNome() + " \t " + p.getDescricao() + " \t " + p.getValor()));

//		produtos = produtoDao.buscarPorNome("Iphone 13 Max Pro");//
//		System.out.println("Lista todos os produtos filtrando por nome:");
//		produtos.forEach(p -> System.out.println(p.getId() + " \t " + p.getNome() + " \t " + p.getDescricao() + " \t "
//				+ p.getValor() + " \t " + p.getCategoria().getNome()));
		
		produtos = produtoDao.listaProdutosPorCategoria("Vestuario");
		System.out.println("\nLista todos os produtos filtrando por nome da categoria:");
		produtos.forEach(p -> System.out.println(p.getId() + " \t " + p.getNome() + " \t " + p.getDescricao() + " \t "
				+ p.getValor() + " \t " + p.getCategoria().getNome()));
		
	}

}
