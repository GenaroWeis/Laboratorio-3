package ar.edu.utn.frbb.tup.Inputs;

import ar.edu.utn.frbb.tup.Entities.Cliente;
import ar.edu.utn.frbb.tup.Utils.TipoPersona;
import ar.edu.utn.frbb.tup.Utils.Direccion;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;

public class ClientInputProcessor extends BaseInputProcessor {
     public Scanner getScanner() {
        return scanner;
    }
    public Cliente crearCliente() {
        clearScreen();

        System.out.println("Ingrese el nombre del cliente:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el apellido del cliente:");
        String apellido = scanner.nextLine();

        System.out.println("Ingrese el DNI del cliente:");
        int dni = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Ingrese la calle de la dirección del cliente:");
        String calle = scanner.nextLine();

        System.out.println("Ingrese el número de casa de la dirección del cliente:");
        int numeroCasa = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        Direccion direccion = new Direccion(calle, numeroCasa);// crea la dire

        System.out.println("Ingrese la fecha de nacimiento del cliente (yyyy-MM-dd):");
        String fechaNacimientoStr = scanner.nextLine();
        LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr);

        System.out.println("Ingrese el teléfono del cliente:");
        int telefono = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.println("Ingrese el email del cliente:");
        String email = scanner.nextLine();

        System.out.println("Ingrese el tipo de persona del cliente (1 para Persona Física, 2 para Persona Jurídica):");
        int tipoPersonaInt = scanner.nextInt();
        TipoPersona tipoPersona;
        if (tipoPersonaInt == 1) {
            tipoPersona = TipoPersona.PERSONA_FISICA;
        } else {
            tipoPersona = TipoPersona.PERSONA_JURIDICA;
        }

        // Crear y retornar el cliente
        return new Cliente(nombre, apellido, dni, direccion, fechaNacimiento, telefono, email, tipoPersona, 0, new HashSet<>(), new HashSet<>(), LocalDate.now());
    }
}

