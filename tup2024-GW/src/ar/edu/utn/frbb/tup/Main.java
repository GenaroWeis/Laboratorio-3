package ar.edu.utn.frbb.tup;

import ar.edu.utn.frbb.tup.Entities.Banco;
import ar.edu.utn.frbb.tup.Entities.Cliente;
import ar.edu.utn.frbb.tup.Utils.Direccion;
import ar.edu.utn.frbb.tup.Utils.TipoPersona;
import ar.edu.utn.frbb.tup.Utils.CuentasCliente;
import ar.edu.utn.frbb.tup.Inputs.MenuInputProcessor;
import ar.edu.utn.frbb.tup.Entities.Cuenta;
import ar.edu.utn.frbb.tup.Inputs.ClientInputProcessor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Main {

      public static void main(String[] args) {
        Banco banco = new Banco(); // Crear instancia de Banco
        MenuInputProcessor menuInputProcessor = new MenuInputProcessor(); // Crear instancia de MenuInputProcessor
        CuentasCliente cuentasCliente = new CuentasCliente();
        menuInputProcessor.renderMenu(banco); 
}}
