package com.cice.main;

import com.cice.business.Agenda;
import com.cice.dto.PersonaDTO;
import com.cice.dto.PersonalDTO;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String... args) {

        Agenda agenda = new Agenda();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        Map<PersonaDTO, PersonalDTO> contactos = new HashMap<PersonaDTO, PersonalDTO>();
        PersonaDTO contacto;
        PersonalDTO personal;

        do {
            mostrarMenu();
            opcion = sc.nextInt();
            switch (opcion) {
                case 0:
                    System.out.println("Hasta pronto!!!");
                    break;
                case 1:
                    agenda.mostrarTodosContactos();
                    break;
                case 2:
                    agenda.buscarContactosByNombreApellido();
                    break;
                case 3:
                    personal = (PersonalDTO) agenda.agregarContacto();
                    contacto = new PersonalDTO();
                    contacto.setNombre(personal.getNombre());
                    contacto.setApellido1(personal.getApellido1());
                    contacto.setApellido2(personal.getApellido2());
                    contacto.setFechaNacimiento(personal.getFechaNacimiento());
                    contactos.put(contacto, personal);
                    break;
                    
                case 4:
                    agenda.editarContacto();
                    break;
                case 5:
                    agenda.eliminarContacto();
                    break;
                default:
                    System.out.println("Opción no reconocida.");
            }
        } while (opcion != 0);

    }

    private static void mostrarMenu() {

        System.out.println("============== Menu agenda ==============");
        System.out.println("");
        System.out.println("1. Listar todos los contactos.");
        System.out.println("2. Buscar contacto por nombre o apellido.");
        System.out.println("3. agregar nuevo contacto.");
        System.out.println("4. Editar un contacto.");
        System.out.println("5. Eliminar un contacto.");
        System.out.println("");
        System.out.println("0. Salir de la aplicación.");
        System.out.println("");
        System.out.print("Selecciona una opción: ");

    }
}
