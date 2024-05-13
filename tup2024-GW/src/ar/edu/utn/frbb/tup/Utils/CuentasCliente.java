package ar.edu.utn.frbb.tup.Utils;

import ar.edu.utn.frbb.tup.Entities.Cuenta;

import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class CuentasCliente {
    private Set<Cuenta> cuentasClientes = new HashSet<>();
    private Scanner scanner = new Scanner(System.in);

    public Set<Integer> obtenerNumerosCuentaCliente(int dniCliente) {
        Set<Integer> numerosCuentaCliente = new HashSet<>();
        for (Cuenta cuenta : cuentasClientes) {
            if (cuenta.getDni() == dniCliente) {
                numerosCuentaCliente.add(cuenta.getNumeroCuenta());
            }
        }
        return numerosCuentaCliente;
    }

    public void mostrarCuentasCliente(int dniCliente) {
        Set<Integer> numerosCuentaCliente = obtenerNumerosCuentaCliente(dniCliente);
        if (!numerosCuentaCliente.isEmpty()) {
            System.out.println("Cuentas asociadas al cliente:");
            for (int numeroCuenta : numerosCuentaCliente) {
                System.out.println("Número de cuenta: " + numeroCuenta);
            }
        } else {
            System.out.println("El cliente no tiene cuentas asociadas.");
        }
    }

    public void transferirEntreCuentas() {

        //lee desde el usuario el número de cuenta de origen, número de cuenta de destino y monto a transferir
        System.out.println("Ingrese el numero de cuenta de origen:");
        int numeroCuentaOrigen = scanner.nextInt();
        System.out.println("Ingrese el numero de cuenta de destino:");
        int numeroCuentaDestino = scanner.nextInt();
        System.out.println("Ingrese el monto a transferir:");
        double montoTransferir = scanner.nextDouble();

        Cuenta cuentaOrigen = null;
        Cuenta cuentaDestino = null;
        for (Cuenta cuenta : cuentasClientes) {
            if (cuenta.getNumeroCuenta() == numeroCuentaOrigen) {
                cuentaOrigen = cuenta;
            }
            if (cuenta.getNumeroCuenta() == numeroCuentaDestino) {
                cuentaDestino = cuenta;
            }
        }

        if (cuentaOrigen != null && cuentaDestino != null) {//si se encontraron las cuentas
            // Verificar saldo suficiente en la cuenta de origen
            if (cuentaOrigen.getSaldo() >= montoTransferir) {
                // Realizar la transferencia
                cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - montoTransferir);
                cuentaDestino.setSaldo(cuentaDestino.getSaldo() + montoTransferir);
                System.out.println("Transferencia realizada con éxito.");
            } else {
                System.out.println("Saldo insuficiente en la cuenta de origen.");
            }
        } else {
            System.out.println("No se encontraron las cuentas.");
        }
    }
}
