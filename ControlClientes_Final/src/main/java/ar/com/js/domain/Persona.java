
package ar.com.js.domain;

import com.sun.istack.NotNull;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

//Agregamos de manera automatica los constructores y los metodos equals, hashcode, y toString con lombok
@Data
@Entity
//Esta notacion evita los problemas con las minusculas y mayusculas de las bases de datos
@Table(name = "persona")
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    
    //Mapeo de la PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_persona;
    
    @NotEmpty
    private String nombre; 
    @NotEmpty
    private String apellido;
    @NotEmpty
    private String telefono;
    @Email
    @NotEmpty
    private String email;
    
    @NotNull
    private double saldo;
}
