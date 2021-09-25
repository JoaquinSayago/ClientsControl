package ar.com.js.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Data
//Si esto no se hace podria afectar el mapeo de esta tabla
@Table(name="role")
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_role;
    
    @NotEmpty
    private String nombre;
    
}
