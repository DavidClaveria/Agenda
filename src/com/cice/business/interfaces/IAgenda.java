package com.cice.business.interfaces;

import java.util.Map;
import com.cice.dto.PersonaDTO;
import com.cice.dto.PersonalDTO;



public interface IAgenda {
    
    PersonalDTO agregarContacto();
    
    
     
    
   // void agregarContacto(); //Metodo que usará mi agenda
    
    void editarContacto(Map<PersonaDTO,PersonalDTO> contactos); //Map<PersonaDTO,PersonalDTO> editarContacto(Map<PersonaDTO,PersonalDTO> contactos);
    
    void eliminarContacto(Map<PersonaDTO,PersonalDTO> contactos);
    
    void mostrarTodosContactos(Map<PersonaDTO,PersonalDTO> contactos);
    
    void buscarContactosByNombreApellido(Map<PersonaDTO,PersonalDTO> contactos);
    
}
