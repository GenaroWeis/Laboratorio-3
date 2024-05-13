
package ar.edu.utn.frbb.tup.Inputs;

import ar.edu.utn.frbb.tup.Entities.Cliente;
import ar.edu.utn.frbb.tup.Entities.Cuenta;
import ar.edu.utn.frbb.tup.Entities.Banco;
import ar.edu.utn.frbb.tup.Utils.CuentasCliente;

import java.util.Scanner;

public class MenuInputProcessor extends BaseInputProcessor{
    boolean exit = false;
    private CuentasCliente CuentasCliente = new CuentasCliente();

    public void renderMenu(Banco banco) {

        while (!exit) {
            System.out.println("Menu principal gestion bancaria");
            System.out.println("1. CLIENTE");
            System.out.println("2. CUENTAS");
            System.out.println("3. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    renderMenuCliente(banco);
                    break;
                case 2:
                    renderMenuCuentas(banco);
                    break;
                case 3:
                    exit = true;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Por favor, ingrese una opción válida.");
                    break;
            }
        }
    }

    private void renderMenuCliente(Banco banco) {
        System.out.println("Menu Cliente");
        System.out.println("1. Crear Cliente");
        System.out.println("2. Modificar Cliente");
        System.out.println("3. Eliminar Cliente");
        System.out.println("4. Ver lista de Clientes");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
    
        switch (choice) {
            case 1:
                banco.agregarNuevoCliente(new ClientInputProcessor());
                break;
            case 2:
                banco.modificarClienteExistente(new ClientInputProcessor());
                break;
            case 3:
            System.out.println("Ingrese el DNI del cliente que desea eliminar:");
            int dniClienteEliminar = scanner.nextInt();
            scanner.nextLine(); 
            banco.eliminarCliente(dniClienteEliminar);
                break;
            case 4:
                banco.mostrarClientes();
                break;
            default:
                System.out.println("Por favor, ingrese una opción válida.");
                break;
        }

    }
    private void renderMenuCuentas(Banco banco) {
        System.out.println("Menu Cuentas");
        System.out.println("1. Crear Cuenta");
        System.out.println("2. Operaciones y Gestión");
        System.out.println("3. Cuentas asociadas al cliente");

        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) {
            case 1:
            Cuenta nuevaCuenta = new CuentainputProcessor().crearCuenta();
            System.out.println("Ingrese el DNI del cliente al que desea asociar la cuenta:");
            int dniClienteAsociar = scanner.nextInt();
            scanner.nextLine();
            Cliente clienteAsociar = null;
            for (Cliente cliente : banco.getClientes()) {
                if (cliente.getDni() == dniClienteAsociar) {
                    clienteAsociar = cliente;
                    break;
                }
            }
            if (clienteAsociar != null) {
                clienteAsociar.getCuenta().add(nuevaCuenta);
                System.out.println("Cuenta creada y asociada al cliente correctamente.");
            } else {
                System.out.println("No se encontró ningún cliente con el DNI ingresado para asociar la cuenta.");
            }
            break;
        
            case 2:
            System.out.println("Ingrese el DNI del cliente:");
            int dniClienteOperaciones = scanner.nextInt();
            scanner.nextLine();
            Cliente clienteOperaciones = null;
            for (Cliente cliente : banco.getClientes()) {
                if (cliente.getDni() == dniClienteOperaciones) {
                    clienteOperaciones = cliente;
                    break;
                }
            }
            if (clienteOperaciones != null) {
                System.out.println("Cuentas del cliente:");
                for (Cuenta cuenta : clienteOperaciones.getCuenta()) {
                    System.out.println("Número de cuenta: " + cuenta.getNumeroCuenta());
                }
        
                System.out.println("Ingrese el número de cuenta al que desea acceder:");
                int numeroCuentaOperaciones = scanner.nextInt();
                scanner.nextLine();
                Cuenta cuentaOperaciones = null;
                for (Cuenta cuenta : clienteOperaciones.getCuenta()) {
                    if (cuenta.getNumeroCuenta() == numeroCuentaOperaciones) {
                        cuentaOperaciones = cuenta;
                        break;
                    }
                }
                if (cuentaOperaciones != null) {
                    boolean exitOperacionesCuenta = false;
                    while (!exitOperacionesCuenta) {
                        System.out.println("Operaciones en la cuenta:");
                        System.out.println("1. Transferir a otra cuenta");
                        System.out.println("2. Realizar Depósito");
                        System.out.println("3. Realizar Retiro");
                        System.out.println("4. Consultar Saldo");
                        System.out.println("5. Volver al Menú de Cuentas");
        
                        int choiceOperacionesCuenta = scanner.nextInt();
                        scanner.nextLine();
        
                        switch (choiceOperacionesCuenta) {
                            case 1:
                                CuentasCliente.transferirEntreCuentas();
                                break;
                            case 2:
                                System.out.println("Ingrese el monto a depositar:");
                                double montoDeposito = scanner.nextDouble();
                                scanner.nextLine();
                                cuentaOperaciones.realizarDeposito(montoDeposito);
                                break;
                            case 3:
                                System.out.println("Ingrese el monto a retirar:");
                                double montoRetiro = scanner.nextDouble();
                                scanner.nextLine();
                                cuentaOperaciones.realizarRetiro(montoRetiro);
                                break;
                            case 4:
                                cuentaOperaciones.consultarSaldo();
                                break;
                            case 5:
                                exitOperacionesCuenta = true;
                                break;
                            default:
                                System.out.println("Por favor, ingrese una opción válida.");
                                break;
                        }
                    }
                } else {
                    System.out.println("No se encontró ninguna cuenta con el número ingresado.");
                }
            } else {
                System.out.println("No se encontró ningún cliente con el DNI ingresado.");
            }
            break;
        
            case 3:
            System.out.println("Ingrese el DNI del cliente:");
            int dniClienteCuentas = scanner.nextInt();
            scanner.nextLine();
            CuentasCliente cuentasCliente = new CuentasCliente();
            cuentasCliente.mostrarCuentasCliente(dniClienteCuentas);
            break;

        default:
            System.out.println("Por favor, ingrese una opción válida.");
            break;}
    }




    private void renderOperacionesGestion(Banco banco) {
        System.out.println("Ingrese el DNI del cliente:");
        int dni = scanner.nextInt();
        scanner.nextLine(); 

        for (Cliente cliente : banco.getClientes()) {
            if (cliente.getDni() == dni) {
                System.out.println("Cuentas del cliente con DNI " + dni + ":");
                for (Cuenta cuenta : cliente.getCuenta()) {
                    System.out.println("Número de cuenta: " + cuenta.getNumeroCuenta());
                }
                return;
            }
        }
        System.out.println("No se encontraron cuentas para el cliente con DNI " + dni);
    }
}

   