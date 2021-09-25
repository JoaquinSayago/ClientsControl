package ar.com.js.dao;

import ar.com.js.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

//Para hacer extends de una interface , la clase no debe ser clase , si no interface
public interface UserDAO extends JpaRepository<Usuario, Long> {
    
    //Esto recupera un objeto de tipo User , filtrado por username
    Usuario findByUsername(String username);
}
