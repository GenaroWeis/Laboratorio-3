package ar.edu.utn.frbb.tup.Inputs;

import ar.edu.utn.frbb.tup.Entities.Cuenta;
import ar.edu.utn.frbb.tup.Utils.EstadoCuenta;
import ar.edu.utn.frbb.tup.Utils.TipoCuenta;
import ar.edu.utn.frbb.tup.Utils.Moneda;
import ar.edu.utn.frbb.tup.Entities.Movimientos;

import java.util.HashSet;
import java.util.Set;

public class CuentainputProcessor extends BaseInputProcessor {

    public Cuenta crearCuenta() {

        System.out.println("Ingrese el DNI del cliente:");
        int dni = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Ingrese el saldo inicial:");
        double saldo = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.println("Ingrese el CBU:");
        String cbu = scanner.nextLine();

        System.out.println("Ingrese el alias:");
        String alias = scanner.nextLine();

        System.out.println("Ingrese el número de cuenta:");
        int numeroCuenta = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Ingrese el tipo de cuenta (1 para Cuenta Corriente, 2 para Caja de Ahorro):");
        int tipoCuentaInt = scanner.nextInt();
        TipoCuenta tipoCuenta;
        if (tipoCuentaInt == 1) {
            tipoCuenta = TipoCuenta.CUENTA_CORRIENTE;
        } else if (tipoCuentaInt == 2) {
            tipoCuenta = TipoCuenta.CUENTA_AHORRO;
        } else {
            // Por defecto, se asigna cuenta corriente
            tipoCuenta = TipoCuenta.CUENTA_CORRIENTE;
        }

        System.out.println("Ingrese la moneda (1 para Pesos, 2 para Dólares):");
        int monedaInt = scanner.nextInt();
        Moneda moneda;
        if (monedaInt == 1) {
            moneda = Moneda.PESO_ARG;
        } else if (monedaInt == 2) {
            moneda = Moneda.DOLAR;
        } else {
            // Por defecto, se asigna pesos
            moneda = Moneda.PESO_ARG;
        }

        System.out.println("debe activar su cuenta antes de usarla, ingrese 1 si quiere congelar su cuenta");
        int estadoCuentaInt = scanner.nextInt();
        EstadoCuenta estadoCuenta;
        if (estadoCuentaInt == 1) {
            estadoCuenta = EstadoCuenta.CONGELADO;
        } else {
            //Por defecto, se asigna estado inactivo
            estadoCuenta = EstadoCuenta.INACTIVO;
        }

        // Crear un set vacío de movimientos
        Set<Movimientos> movimientos = new HashSet<>();

        // Crear y retornar la cuenta
        return new Cuenta(dni, saldo, cbu, alias, numeroCuenta, tipoCuenta, moneda, estadoCuenta, movimientos);
    }
}
