package ar.edu.utn.frbb.tup.Entities;

import ar.edu.utn.frbb.tup.Entities.Cliente;
import ar.edu.utn.frbb.tup.Inputs.ClientInputProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco {
    private List<Cliente> clientes = new ArrayList<>();
    protected Scanner scanner = new Scanner(System.in);

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    } 

    public void modificarCliente(Cliente clienteExistente, Cliente clienteModificado) {//cliente existente y la modificacion
        int index = clientes.indexOf(clienteExistente);//busca al existente con indexOF que te dice en que posicion de la lista esta (numero), si no existe index tira -1 por defecto
        if (index != -1) {//si tiro el -1 es que no esta en la lista
            clientes.set(index, clienteModificado);//si esta en la lista se reemplaza por el nuevo cliente
        } else {
            System.out.println("El cliente no se encuentra en la lista.");
        }
    }

    public void eliminarCliente(int dniCliente) {
        Cliente clienteEliminar = null;
        for (Cliente cliente : clientes) {
            if (cliente.getDni() == dniCliente) {
                clienteEliminar = cliente;
                break;
            }
        }
        if (clienteEliminar != null) {
            clientes.remove(clienteEliminar);
            System.out.println("Cliente eliminado correctamente.");
        } else {
            System.out.println("No se encontró ningún cliente con el DNI ingresado.");
        }
    }
    

      public void agregarNuevoCliente(ClientInputProcessor inputProcessor) {
        Cliente nuevoCliente = inputProcessor.crearCliente();
        clientes.add(nuevoCliente);
    }

    public void modificarClienteExistente(ClientInputProcessor inputProcessor) {
        System.out.println("Ingrese el DNI del cliente que desea modificar:");
        int dniCliente = inputProcessor.getScanner().nextInt();
        Cliente clienteExistente = null;
        for (Cliente cliente : clientes) {
            if (cliente.getDni() == dniCliente) {
                clienteExistente = cliente;
                break;
            }
        }
        if (clienteExistente != null) {
            Cliente clienteModificado = inputProcessor.crearCliente();
            modificarCliente(clienteExistente, clienteModificado);
        } else {
            System.out.println("No se encontró ningún cliente con el DNI ingresado.");
        }
    }

    public void mostrarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados en el banco.");
        } else {
            System.out.println("Lista de Clientes:");
            for (Cliente cliente : clientes) {
                System.out.println("Nombre: " + cliente.getNombre());
                System.out.println("Apellido: " + cliente.getApellido());
                System.out.println("DNI: " + cliente.getDni());
                System.out.println("etc");
            }
        }
    }
    

}

