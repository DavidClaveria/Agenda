package com.cice.business;

import com.cice.business.interfaces.IAgenda;
import com.cice.dto.PersonaDTO;
import com.cice.dto.PersonalDTO;
import com.cice.dto.ProfesionalDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;




public class Agenda implements IAgenda{

    //variable local de la clase. Esta accesible para todos los metodos de la clase.
    Scanner sc = new Scanner(System.in);
    
    @Override
    public PersonaDTO agregarContacto() {
        
        //-----INSERTO LOS DATOS PERSONALES-----
        PersonaDTO persona = new PersonaDTO();
        
        System.out.println("Datos del contacto: ");
        
                System.out.print("Introduce el nombre: ");
        String nombre = sc.nextLine();
        persona.setNombre(nombre);
        
        System.out.print("Introduce el apellido1: ");
        String apellido1 = sc.nextLine();
        persona.setApellido1(apellido1);
        
        System.out.print("Introduce el apellido2: ");
        String apellido2 = sc.nextLine();
        persona.setApellido2(apellido2);
        
        System.out.print("Introduce fecha de nacimiento (ej: 25-12-1983): ");
        String fecha = sc.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaNacimiento = null;
        try {
            fechaNacimiento = formatter.parse(fecha);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        persona.setFechaNacimiento(fechaNacimiento);
        
        
        //Ahora introduciría los datos que solicita PersonalDTO : email, telefono1 , telefono 2, Direccion 1 y2
        
        System.out.println("Datos personales: ");
        
        System.out.println("Introduce el email: ");
        String email = sc.nextLine();
        persona.setEmail(email);
        
        List<String> listaTelefonos = new ArrayList<>();
        System.out.println("Introduce telefono1: ");
        String telefono1 = sc.nextLine();
        listaTelefonos.add(telefono1);
        
        System.out.println("Introduce telefono2: ");
        String telefono2 = sc.nextLine();
        persona.setTelefonos(listaTelefonos);
        
        
        List<String> listaDirecciones = new ArrayList<>();
        System.out.println("Introduce direccion1: ");
        String direccion1 = sc.nextLine();
        listaDirecciones.add(direccion1);
        
        System.out.println("Introduce direccion2: ");
        String direccion2 =sc.nextLine();
        persona.setDirecciones(listaDirecciones);
        
        //Ahora introduzco los datos que se solicita en ProfesionalDTO: cif y el sector
        
        ProfesionalDTO profesional = new ProfesionalDTO();
        
        System.out.println("Datos profesionales: ");
        System.out.println("Introduce el NIF,CIF: ");
        String cif = sc.nextLine();
        profesional.setCif(cif);
        
        System.out.println("Introduce el sector: ");
        String sector = sc.nextLine();
        profesional.setSector(sector);
        
        return persona;
       
    }
    
    
    
    

    @Override
    public void editarContacto() {
        System.out.println("Editando contacto...");
        
        
    }

    @Override
    public void eliminarContacto() {
        System.out.println("Eliminando contacto...");
        
    }

    @Override
    public void mostrarTodosContactos() {
        System.out.println("Mostrando contactos...");
       
    }

    @Override
    public void buscarContactosByNombreApellido() {
        System.out.println("Buscando contactos por nombre o apellido...");
    }
    
}



/*////////////////////////////////////////////editar contacto//////////////////////////////



    @Override
    public void editarContacto(Map<PersonaDTO,PersonalDTO> contactos) {
    	
    	PersonaDTO contactoBusqueda = leerNombreApellidos();
    	//Solo se editarán contactos en los que coincida el nombre y los dos apellidos
    	if (existeContacto(contactoBusqueda, contactos)){
    		
    		System.out.println("Datos nuevos a editar: ");
    		PersonalDTO contactoEditado = agregarContacto();
    		
    		Iterator it = contactos.entrySet().iterator();
            int contactosEditados = 0;
            
            while (it.hasNext()) {
            	Map.Entry e = (Map.Entry)it.next();
            	PersonaDTO key = (PersonaDTO)e.getKey();
             	PersonalDTO contacto = (PersonalDTO)e.getValue();
            	
            	if ((contacto.getNombre()!=null && contactoBusqueda.getNombre()!=null && contacto.getNombre().equals(contactoBusqueda.getNombre()))
            			&& (contacto.getApellido1()!=null && contactoBusqueda.getApellido1()!=null && contacto.getApellido1().equals(contactoBusqueda.getApellido1()))
            		&& (contacto.getApellido2()!=null && contactoBusqueda.getApellido2()!=null && contacto.getApellido2().equals(contactoBusqueda.getApellido2()))){
            		 contactos.put(key, contactoEditado);
            		 contactosEditados++;
            	} 
            }

        	System.out.println("Se han editado "+contactosEditados+" contactos.");
            
    	}else{
    		System.out.println("No existe el contacto para este nombre/apellidos");
    	}
    	      
        //return contactos;
    }
    ////////////////////////////////////////////eliminar contacto////////////////////////////////
    @Override
    public void eliminarContacto(Map<PersonaDTO,PersonalDTO> contactos) {
    	PersonaDTO contactoBusqueda = leerNombreApellidos();
         
    	Iterator it = contactos.entrySet().iterator();
         boolean existeContacto = false;
         int contactosEliminados = 0;
         while (it.hasNext()) {
         	Map.Entry e = (Map.Entry)it.next();
         	PersonaDTO key = (PersonaDTO)e.getKey();
         	PersonalDTO contacto = (PersonalDTO)e.getValue();
         	//Solo se editarán contactos en los que coincida el nombre y los dos apellidos
         	if ((contacto.getNombre()!=null && contactoBusqueda.getNombre()!=null && contacto.getNombre().equals(contactoBusqueda.getNombre()))
         			&& (contacto.getApellido1()!=null && contactoBusqueda.getApellido1()!=null && contacto.getApellido1().equals(contactoBusqueda.getApellido1()))
         		&& (contacto.getApellido2()!=null && contactoBusqueda.getApellido2()!=null && contacto.getApellido2().equals(contactoBusqueda.getApellido2()))){
         		 contactos.remove(key);
         		 contactosEliminados++;
         		 existeContacto = true;
         	}
             
         }
         if (!existeContacto){
        	 System.out.println("No existe el contacto para este nombre/apellidos");
         }else{
        	 System.out.println("Se han eliminado "+contactosEliminados+" contactos.");
         }
         
         //return contactos;
    }
    ///////////////////////////////////mostrar todos los contactos//////////////////////////////////////

    
    @Override
    public void mostrarTodosContactos(Map<PersonaDTO,PersonalDTO> contactos) {
    	if (contactos==null || (contactos!=null && contactos.size()==0)){
    		System.out.println("La agenda no tiene contactos...");
    		return;
    	}
        System.out.println("Mostrando contactos...");
        Iterator it = contactos.entrySet().iterator();
        while (it.hasNext()) {
        	Map.Entry e = (Map.Entry)it.next();
        	PersonalDTO contacto = (PersonalDTO)e.getValue();
        	System.out.println("-------------------------------------------------");
        	System.out.println("DATOS CONTACTO:");
            System.out.println("Nombre: "+contacto.getNombre());
            System.out.println("Apellido1: "+contacto.getApellido1());
            System.out.println("Apellido2: "+contacto.getApellido2());
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            System.out.println("Fecha de nacimiento: "+formatter.format(contacto.getFechaNacimiento()));
            System.out.println("");
            System.out.println("DATOS PERSONALES:");
            System.out.println("Email: "+contacto.getEmail());
            for (String telefono : contacto.getTelefonos()){
            	System.out.println("Teléfono: "+telefono);
            }
            for (String direccion : contacto.getDirecciones()){
            	System.out.println("Dirección: "+direccion);
            }
            System.out.println("");
            System.out.println("DATOS PROFESIONALES:");
            System.out.println("Nif/cif/nie: "+contacto.getDatosProfesionales()!=null?contacto.getDatosProfesionales().getCif():"");
            System.out.println("Sector: "+contacto.getDatosProfesionales()!=null?contacto.getDatosProfesionales().getSector():"");
            System.out.println("");
        }
    }
        /////////////////////////////////////buscar contactos nombre y apellido////////////////////////////////

    @Override
    public void buscarContactosByNombreApellido(Map<PersonaDTO,PersonalDTO> contactos) {
        
        PersonaDTO contactoBusqueda = leerNombreApellidos();
        Iterator it = contactos.entrySet().iterator();
        boolean existeContacto = false;
        while (it.hasNext()) {
        	Map.Entry e = (Map.Entry)it.next();
        	PersonalDTO contacto = (PersonalDTO)e.getValue();
        	
        	if ((contacto.getNombre()!=null && contactoBusqueda.getNombre()!=null && contacto.getNombre().equals(contactoBusqueda.getNombre()))
        			|| (contacto.getApellido1()!=null && contactoBusqueda.getApellido1()!=null && contacto.getApellido1().equals(contactoBusqueda.getApellido1()))
        			|| (contacto.getApellido2()!=null && contactoBusqueda.getApellido2()!=null && contacto.getApellido2().equals(contactoBusqueda.getApellido2()))){
        		
        		System.out.println("-------------------------------------------------");
            	System.out.println("DATOS CONTACTO:");
                System.out.println("Nombre: "+contacto.getNombre());
                System.out.println("Apellido1: "+contacto.getApellido1());
                System.out.println("Apellido2: "+contacto.getApellido2());
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                System.out.println("Fecha de nacimiento: "+formatter.format(contacto.getFechaNacimiento()));
                System.out.println("");
                System.out.println("DATOS PERSONALES:");
                System.out.println("Email: "+contacto.getEmail());
                for (String telefono : contacto.getTelefonos()){
                	System.out.println("Teléfono: "+telefono);
                }
                for (String direccion : contacto.getDirecciones()){
                	System.out.println("Dirección: "+direccion);
                }
                System.out.println("");
                System.out.println("DATOS PROFESIONALES:");
                System.out.println("Nif/cif/nie: "+contacto.getDatosProfesionales()!=null?contacto.getDatosProfesionales().getCif():"");
                System.out.println("Sector: "+contacto.getDatosProfesionales()!=null?contacto.getDatosProfesionales().getSector():"");
                System.out.println("");
                existeContacto = true;
        	}
            
        }
        if (!existeContacto){
        	System.out.println("No existe el contacto para este nombre/apellidos");
        }
    }
    
    private PersonaDTO leerNombreApellidos() {
        PersonaDTO persona = new PersonaDTO();
        
        System.out.print("Introduce el nombre: ");
        String nombre = sc.nextLine();
        persona.setNombre(nombre);
        
        System.out.print("Introduce el apellido1: ");
        String apellido1 = sc.nextLine();
        persona.setApellido1(apellido1);
        
        System.out.print("Introduce el apellido2: ");
        String apellido2 = sc.nextLine();
        persona.setApellido2(apellido2);
        
        return persona;
        
    }

    private boolean existeContacto(PersonaDTO contactoBusqueda, Map<PersonaDTO,PersonalDTO> contactos) {
        
        boolean resultado = false;
        Iterator it = contactos.entrySet().iterator();
        while (it.hasNext()) {
        	Map.Entry e = (Map.Entry)it.next();
        	PersonaDTO contacto = (PersonaDTO)e.getValue();
        	
        	if ((contacto.getNombre()!=null && contactoBusqueda.getNombre()!=null && contacto.getNombre().equals(contactoBusqueda.getNombre()))
        			&& (contacto.getApellido1()!=null && contactoBusqueda.getApellido1()!=null && contacto.getApellido1().equals(contactoBusqueda.getApellido1()))
        			&& (contacto.getApellido2()!=null && contactoBusqueda.getApellido2()!=null && contacto.getApellido2().equals(contactoBusqueda.getApellido2()))){
        		
        		    return true;
        	}
            
        }
        
        return resultado;
    }
}
*/