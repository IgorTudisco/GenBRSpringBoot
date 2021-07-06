package MinhaLojaDeGames.MinhaLojaDeGames.model;

import java.util.List;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduto;

	@NotEmpty(message = "nomeGame may not be empty")
	@Size(min = 3, max = 10)
	private String nomeGame;

	@NotEmpty(message = "preco may not be empty")
	@Size(min = 10, max = 100)
	private Long preco;

	@ManyToOne
	@JsonIgnoreProperties({ "produto", "listaDeProdutos" })
	private Categoria categoria;

	@ManyToMany
	@JoinTable(name = "tb_juncao", joinColumns = @JoinColumn(name = "fk_produto"), inverseJoinColumns = @JoinColumn(name = "fk_categoria"))
	@JsonIgnoreProperties({ "produto", "listaDeProdutos" })
	private List<Categoria> listaDeCategoria;

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeGame() {
		return nomeGame;
	}

	public void setNomeGame(String nomeGame) {
		this.nomeGame = nomeGame;
	}

	public Long getPreco() {
		return preco;
	}

	public void setPreco(Long preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getListaDeCategoria() {
		return listaDeCategoria;
	}

	public void setListaDeCategoria(List<Categoria> listaDeCategoria) {
		this.listaDeCategoria = listaDeCategoria;
	}

}
