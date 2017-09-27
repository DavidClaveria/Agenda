package com.cice.dto;

import java.util.List;

public class PersonalDTO extends PersonaDTO{
    
    private String email;
    private List<String> telefonos;
    private List<String> direcciones;
    private ProfesionalDTO datosProfesionales;
    
    
    
    
    
    

    public ProfesionalDTO getDatosProfesionales() {
        return datosProfesionales;
    }

    public void setDatosProfesionales(ProfesionalDTO datosProfesionales) {
        this.datosProfesionales = datosProfesionales;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<String> telefonos) {
        this.telefonos = telefonos;
    }

    public List<String> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<String> direcciones) {
        this.direcciones = direcciones;
    }
    
}
