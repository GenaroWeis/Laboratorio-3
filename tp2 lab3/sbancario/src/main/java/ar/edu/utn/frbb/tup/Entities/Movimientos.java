package ar.edu.utn.frbb.tup;
import ar.edu.utn.frbb.tup.Utils.Moneda;

import java.time.LocalDate;
public class Movimientos {
    private int tipo;//1- ingreso o 2- egreso de dinero
    private double monto;
    private String CuentaExterna;//de quien recibo o mando dinero
    private Moneda moneda;
    private LocalDate fecha;

    //constructor
    public Movimientos(int tipo, double monto, String CuentaExterna, Moneda moneda, LocalDate fecha) {
        this.tipo = tipo;
        this.monto = monto;
        this.CuentaExterna = CuentaExterna;
        this.moneda = moneda;
        this.fecha = fecha;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getCuentaExterna() {
        return CuentaExterna;
    }

    public void setCuentaExterna(String cuentaExterna) {
        CuentaExterna = cuentaExterna;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

}