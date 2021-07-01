package MinhaLojaDeGames.MinhaLojaDeGames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import MinhaLojaDeGames.MinhaLojaDeGames.model.Produto;
import MinhaLojaDeGames.MinhaLojaDeGames.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto") // EndPoint 
@CrossOrigin("*") // Assim ele irá aceitar qualquer API
public class ProdutoController {
	
	@Autowired
	public ProdutoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Produto>> GetAll(){
		
		return ResponseEntity.ok(repository.findAll());
		
	};
	
	@GetMapping("/{id}")
    public ResponseEntity<Produto> GetById(@PathVariable Long id) 
    {
        return repository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build()); 
    }
	
	@GetMapping("/nomeGame/{nomeGame}")
    public ResponseEntity<List<Produto>> GetByNomeGame(@PathVariable String nomeGame)
    {
        return ResponseEntity.ok(repository.findAllByNomeGameContainingIgnoreCase(nomeGame));
    }
	
	@PostMapping
	public ResponseEntity<Produto> postProduto(@RequestBody Produto produto){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
		
	};
	
	@PutMapping
    public ResponseEntity<Produto> putProduto (@RequestBody Produto produto)
    {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
    }
        
    @DeleteMapping("/{id}")
    public void deleteProduto(@PathVariable long id)
    {
        repository.deleteById(id);
    }

}
