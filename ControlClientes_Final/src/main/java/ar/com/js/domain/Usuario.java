package ar.com.js.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Data
@Table(name="usuario")
public class Usuario implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idUsuario;
    
    @NotEmpty
    private String username;
    
    @NotEmpty
    private String password;
    
    @OneToMany
    //Indicamos la clave foranea que relaciona nuestra tablas
    @JoinColumn(name="id_usuario")
    private List<Role> roles;
    
    
}
