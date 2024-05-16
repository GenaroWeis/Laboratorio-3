package ar.edu.utn.frbb.tup.Entities;

import ar.edu.utn.frbb.tup.Utils.TipoPersona;
import ar.edu.utn.frbb.tup.Entities.Movimientos;
import ar.edu.utn.frbb.tup.Utils.EstadoCuenta;
import ar.edu.utn.frbb.tup.Utils.Moneda;
import ar.edu.utn.frbb.tup.Utils.TipoCuenta;
import ar.edu.utn.frbb.tup.Utils.CuentasCliente;
import ar.edu.utn.frbb.tup.Utils.Direccion;
import ar.edu.utn.frbb.tup.Utils.CuentasCliente;

import java.time.LocalDate;

import java.util.HashSet;
import java.util.Set;

public class Cliente extends Persona {
    private TipoPersona tipoPersona;
    private Set<Cuenta> cuenta = new HashSet<>();
    private Set<CuentasCliente> cuentascliente = new HashSet<>();
    private LocalDate fechaAlta;

    public Cliente(String nombre, String apellido, int dni, Direccion direccion, LocalDate fechaNacimiento,
                   int telefono, String email, TipoPersona tipoPersona, int numeroCuenta, Set<Cuenta> cuentas, Set<CuentasCliente> cuentascliente,
                   LocalDate fechaAlta) {
        super(nombre, apellido, dni, direccion, fechaNacimiento, telefono, email);
        this.tipoPersona = tipoPersona;
        this.cuenta = cuentas;
        this.cuentascliente = cuentascliente;
        this.fechaAlta = fechaAlta;
    }

    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public Set<Cuenta> getCuenta() {
        return cuenta;
    }

    public void setCuenta(Set<Cuenta> cuentas) {
        this.cuenta = cuentas; 
    }

    public Set<CuentasCliente> getCuentascliente() {
        return cuentascliente;
    }

    public void setCuentascliente(Set<CuentasCliente> cuentascliente) {
        this.cuentascliente = cuentascliente;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public void crearCuenta(int dni, double saldoInicial, String cbu, String alias, int numeroCuenta, TipoCuenta tipoCuenta,
                        Moneda moneda, EstadoCuenta estadoCuenta, Set<Movimientos> movimientos) {
    Cuenta nuevaCuenta = new Cuenta(dni, saldoInicial, cbu, alias, numeroCuenta, tipoCuenta, moneda, estadoCuenta, movimientos);
    this.cuenta.add(nuevaCuenta);
}

}
