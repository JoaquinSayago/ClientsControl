package ar.com.js.dao;

//CrudRepository<> Realiza el trabajo de implementar querys xD

import ar.com.js.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

//Realizando un CTRL + Click en CrudRepository , tenemos los metodos mas comunes, podemos cambiarlos
public interface IPersonaDao extends JpaRepository<Persona, Long> {
    
}
