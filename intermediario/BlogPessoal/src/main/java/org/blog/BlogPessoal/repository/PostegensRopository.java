package org.blog.BlogPessoal.repository;

import org.blog.BlogPessoal.model.PostagensModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// passando a anotação de repositório
@Repository
public interface PostegensRopository extends JpaRepository<PostagensModel, Long>{ //Passando a Class e o tipy 
	
	public List<PostagensModel> findallByTituloContainingIgnoreCase (String titulo);
	
}
