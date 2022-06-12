package br.com.glandata.jpa.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "produtos", indexes = { @Index(name = "id_produto", columnList = "id") }
//		uniqueConstraints = { @UniqueConstraint(name = "nome_unique", columnNames = "nome") }
)
@ToString
public class Produto {

	public Produto() {
	}

	public Produto(Long id) {
		this.id = id;
	}

	public Produto(String nome, String descricao, BigDecimal valor, Categoria categoria) {
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.categoria = categoria;
	}

	@Getter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Getter
	@Setter
	private String nome;

	@Getter
	@Setter
	private String descricao;

	@Getter
	@Setter
	private BigDecimal valor;

	@Getter
	@Setter
	@ManyToOne
	private Categoria categoria;

	@Getter
	@Column(name = "data_cadastro")
	private LocalDate dataCadastro = LocalDate.now();
}
