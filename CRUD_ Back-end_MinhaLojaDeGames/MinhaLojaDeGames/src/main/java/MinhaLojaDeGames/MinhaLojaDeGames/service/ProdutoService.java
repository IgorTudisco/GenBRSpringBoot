package MinhaLojaDeGames.MinhaLojaDeGames.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MinhaLojaDeGames.MinhaLojaDeGames.model.Categoria;
import MinhaLojaDeGames.MinhaLojaDeGames.model.Produto;
import MinhaLojaDeGames.MinhaLojaDeGames.repository.CategoriaRepository;
import MinhaLojaDeGames.MinhaLojaDeGames.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repositoryProduto;
	
	@Autowired
	private CategoriaRepository repositoryCategoria;
	
	// Salva um novo produto
	public Produto novoProduto(Produto novoProduto) {
		return repositoryProduto.save(novoProduto);
	}
	
	// Novo Item Categorisado
		public Optional<Produto> novoItemCategorisado(Long idProduto, Long idCategoria) {
			Optional<Categoria> categoria = repositoryCategoria.findById(idCategoria);
			Optional<Produto> produto = repositoryProduto.findById(idProduto);
			
			if(categoria.isPresent() && produto.isPresent()) {
				produto.get().getListaDeCategoria().add(categoria.get());
				return Optional.ofNullable(repositoryProduto.save(produto.get()));
			}
			return Optional.empty();
		}
	
}
