package br.com.glandata.jpa.main;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.glandata.jpa.dao.ProdutoDao;
import br.com.glandata.jpa.model.Categoria;
import br.com.glandata.jpa.model.Produto;
import br.com.glandata.jpa.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		Produto produto = new Produto("Microondas Samsung", "Microondas samsung 30L",
				new BigDecimal("350.00"), new Categoria(12L));

		EntityManager em = JPAUtil.getEntityManager();

		ProdutoDao produtoDao = new ProdutoDao(em);

		try {
			em.getTransaction().begin();
			produtoDao.cadastrar(produto);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}
	}

}
