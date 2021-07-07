package MinhaLojaDeGames.MinhaLojaDeGames.seguranca;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import MinhaLojaDeGames.MinhaLojaDeGames.model.Usuario;
import MinhaLojaDeGames.MinhaLojaDeGames.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImplemente implements UserDetailsService {
	
	private UsuarioRepository repositoryUsuario; 

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
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Optional<Usuario> usuario = repositoryUsuario.findByEmail(email);
		
		usuario.orElseThrow(() -> new UsernameNotFoundException(email + " email not found. "));
		
		return usuario.map(UserDetailsImplements::new).get();
		
	}

}
