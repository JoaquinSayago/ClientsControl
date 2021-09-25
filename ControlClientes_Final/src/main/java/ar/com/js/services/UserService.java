package ar.com.js.services;

import ar.com.js.dao.UserDAO;
import ar.com.js.domain.Role;
import ar.com.js.domain.Usuario;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
@Slf4j
public class UserService implements UserDetailsService{
    
    @Autowired
    private UserDAO usuarioDao;
    
    
    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = usuarioDao.findByUsername(username);
        
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        //El tipo que necesita Spring para manejar los roles
        var roles = new ArrayList<GrantedAuthority>();
        
        for(Role role: user.getRoles()){
            roles.add(new SimpleGrantedAuthority(role.getNombre())); 
        }
        
        //User es una clase de Spring
        return new User(user.getUsername(),user.getPassword(), roles);
    }
    
}
