package br.com.glandata.jpa.main;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.glandata.jpa.dao.CategoriaDao;
import br.com.glandata.jpa.dao.ProdutoDao;
import br.com.glandata.jpa.model.Categoria;
import br.com.glandata.jpa.model.Produto;
import br.com.glandata.jpa.util.JPAUtil;

public class AtualizaProduto {

	public static void main(String[] args) {
		Produto produto = new Produto(4L);
		produto.setNome("TV");
		produto.setDescricao("Aparelho televisor de 50\"");
		produto.setValor(new BigDecimal("2500"));
		produto.setCategoria(new Categoria("Televisões"));
		
		EntityManager em = JPAUtil.getEntityManager();

		CategoriaDao categoriaDao = new CategoriaDao(em);
		ProdutoDao produtoDao = new ProdutoDao(em);

		em.getTransaction().begin();
		categoriaDao.cadastrar(produto.getCategoria());
		produtoDao.atualizar(produto);
		em.getTransaction().commit();
		em.close();
	}

}
