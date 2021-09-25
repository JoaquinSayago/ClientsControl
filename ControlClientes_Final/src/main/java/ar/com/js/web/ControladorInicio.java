package ar.com.js.web;

import ar.com.js.domain.Persona;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ar.com.js.services.PersonaService;
import javax.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.Errors;


//Damos permisos para utilizar esta clase dentro del Framework , con Spring MVC

@Controller
@Slf4j
public class ControladorInicio {
    @Autowired
    private PersonaService personaService;
    //Peticion GET
    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user) {
        var personas = personaService.listarPersonas();
        log.info("Usuario que hizo login");
        model.addAttribute("personas", personas);
        var saldoTotal = 0D;
        for(var p:personas){
            saldoTotal += p.getSaldo();
        }
        model.addAttribute("saldoTotal",saldoTotal);
        model.addAttribute("totalClientes", personas.size());
        return "index";
    }
    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";
    
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona,Errors errors){
        if(errors.hasErrors()){
           return "modificar";
        } 
        personaService.guardar(persona);
        //Redirecciona a la pagina de inicio
        return "redirect:/";
        }
     
    
    //Automaticamente el mapping asocia el id persona con el objeto pasado como parametro
    @GetMapping("/editar/{id_persona}")
    public String editar(Persona persona, Model model){
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }
    
    @GetMapping("/eliminar/{id_persona}")
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }
}


