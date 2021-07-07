package org.blog.BlogPessoal.seguranca;

import java.util.Optional;

import org.blog.BlogPessoal.model.Usuario;
import org.blog.BlogPessoal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service // Anotação de serviço
public class UserDetailsServiceImplemente implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	/**
	 * Metodo usado para verificar o nome do usuario no sistema.
	 * 
	 * @param userName
	 * @return usuario.map(UserDetailsImplements::new).get()
	 * @throws UsernameNotFoundException
	 * @author igor
	 * @since 1.0
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioRepository.findByUsuario(username);
		usuario.orElseThrow(() -> new UsernameNotFoundException(username + "not found. "));
		
		return usuario.map(UserDetailsImplements::new).get();
	}

	
}
