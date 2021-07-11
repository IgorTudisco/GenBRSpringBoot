package org.blog.BlogPessoal.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.blog.BlogPessoal.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UsuarioRepositoryTest {
	
	public Usuario usuario;
	
	public UsuarioRepository repositoryUsuario;

	@Autowired
	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator = factory.getValidator();
	
	@Test
	public void start() {

		usuario = new Usuario("Zika", "jkdskhasdhskjdf", "zikaf24@gmail.com");
		if(repositoryUsuario.findByEmail(usuario.getEmail()) != null) {
			repositoryUsuario.save(usuario);
		}

	};
	
//	@Test
//	void testValidaAtributos() {
//		Set<ConstraintViolation<Usuario>> violacao = validator.validate(usuario);
//		System.out.println(violacao.toString());
//		assertTrue(violacao.isEmpty());
//	}
//
//
//	@Test
//	void testValidaMetodo() {
//		Set<ConstraintViolation<UsuarioRepository>> violacao = validator.validate(repositoryUsuario);
//		System.out.println(violacao.toString());
//		assertTrue(violacao.isEmpty());
//	}

}
