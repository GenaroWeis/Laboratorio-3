package ar.edu.utn.frbb.tup.Entities;

import ar.edu.utn.frbb.tup.Utils.Direccion;

import java.time.LocalDate;// local date para las fechas

public class Persona {

    // Atributos
    private String nombre;
    private String apellido;
    private int dni;
    private Direccion direccion; //relacionada a la clase direccion
    private LocalDate fechaNacimiento;
    private int telefono;
    private String email;

    // Constructor
    public Persona(String nombre, String apellido, int dni, Direccion direccion, LocalDate fechaNacimiento,
    int telefono, String email) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.dni = dni;
    this.direccion = direccion;
    this.fechaNacimiento = fechaNacimiento;
    this.telefono = telefono;
    this.email = email;
}

    // getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   
}