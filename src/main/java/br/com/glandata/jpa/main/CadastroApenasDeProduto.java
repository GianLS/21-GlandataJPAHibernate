package br.com.glandata.jpa.main;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.glandata.jpa.dao.CategoriaDao;
import br.com.glandata.jpa.dao.ProdutoDao;
import br.com.glandata.jpa.model.Categoria;
import br.com.glandata.jpa.model.Produto;
import br.com.glandata.jpa.util.JPAUtil;

public class CadastroApenasDeProduto {

	public static void main(String[] args) {
		Categoria categoria = new Categoria("Smartphones");

		Produto produto = new Produto("Iphone 13 Max Pro", "Smartphone mais caro do que deveria",
				new BigDecimal("6500.00"), categoria);

		EntityManager em = JPAUtil.getEntityManager();

		CategoriaDao categoriaDao = new CategoriaDao(em);
		ProdutoDao produtoDao = new ProdutoDao(em);

		try {
			em.getTransaction().begin();
			categoriaDao.cadastrar(categoria);
			produtoDao.cadastrar(produto);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}
	}

}
