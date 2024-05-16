package ar.edu.utn.frbb.tup.Entities;

import ar.edu.utn.frbb.tup.Utils.EstadoCuenta;
import ar.edu.utn.frbb.tup.Utils.TipoCuenta;
import ar.edu.utn.frbb.tup.Utils.Moneda;
import ar.edu.utn.frbb.tup.Entities.Movimientos;

import java.util.Set;
import java.util.HashSet;
import java.time.LocalDate;


public class Cuenta {
    private int dni;
    private double saldo;
    private String cbu;
    private String alias;
    private int numeroCuenta;
    private TipoCuenta tipoCuenta;
    private Moneda moneda;
    private EstadoCuenta EstadoCuenta;
    private Set<Movimientos> movimientos = new HashSet<>();// otra aparte tambien

    public Cuenta( int dni, double saldo, String cbu, String alias, int numeroCuenta, TipoCuenta tipoCuenta, Moneda moneda,
                  EstadoCuenta estadoCuenta, Set<Movimientos> movimientos) {
        this.dni = dni;
        this.saldo = saldo;
        this.cbu = cbu;
        this.alias = alias;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.moneda = moneda;
        this.EstadoCuenta = estadoCuenta;
        this.movimientos = movimientos;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getCbu() {
        return cbu;
    }

    public void setCbu(String cbu) {
        this.cbu = cbu;
    }

    public String getAlias() {
        return alias;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public EstadoCuenta getEstadoCuenta() {
        return EstadoCuenta;
    }

    public void setEstadoCuenta(EstadoCuenta estadoCuenta) {
        EstadoCuenta = estadoCuenta;
    }

    public Set<Movimientos> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(Set<Movimientos> movimientos) {
        this.movimientos = movimientos;
    }

    public void activarCuenta() {
        this.EstadoCuenta = EstadoCuenta.ACTIVO;
        System.out.println("Cuenta activada correctamente.");
    }

    public void congelarCuenta() {
        this.EstadoCuenta = EstadoCuenta.CONGELADO;
        System.out.println("Cuenta congelada correctamente.");
    }
    
    public void registrarMovimiento(int tipo, double monto, String cuentaExterna, Moneda moneda, LocalDate fecha) {
        Movimientos movimiento = new Movimientos(tipo, monto, cuentaExterna, moneda, fecha);
        this.movimientos.add(movimiento);
    }
    

    private boolean verificarEstadoCuenta() {
        if (this.getEstadoCuenta() == EstadoCuenta.INACTIVO) {
            System.out.println("Su cuenta esta inactiva. Por favor, activela para realizar operaciones");
            return false; //La transacción no se realiza
        } else if (this.getEstadoCuenta() == EstadoCuenta.CONGELADO) {
            System.out.println("Su cuenta esta congelada. Comuniquese con el banco para mas info");
            return false; //La transacción no se realiza
        }else{
        return true;//se puede realizar la transacción
    }
    }

    public void realizarDeposito(double monto) {
        if (this.verificarEstadoCuenta()) {//crequea que la cuenta este activa
            if (monto <= 0) {
                System.out.println("Debe depositar un monto para suplir esta funcion");
            } else {
                this.setSaldo(this.getSaldo() + monto);//agrega el saldo
                this.registrarMovimiento(1, monto, "Cuenta Interna", this.getMoneda(), LocalDate.now());//registra el movimiento en movimientos
                System.out.println("Deposito realizado con exito. Nuevo saldo: " + this.getSaldo());//printea
            }
        }
    }

    public void realizarRetiro(double monto) {
        if (this.verificarEstadoCuenta()) {//cheuqea que la cuenta este activa
            if (monto <= 0) {
                System.out.println("El monto a retirar debe ser mayor que cero");
            } else if (this.getSaldo() < monto) {
                System.out.println("Saldo insuficiente para realizar el retiro");
            } else {
                this.setSaldo(this.getSaldo() - monto);
                this.registrarMovimiento(2, monto, "Cuenta Interna", this.getMoneda(), LocalDate.now());
                System.out.println("Retiro realizado con exto. Nuevo saldo: " + this.getSaldo());
            }
        }
    }
    
    public void consultarSaldo() {
        System.out.println("Su saldo es de: " + this.getSaldo());
    }


    
}
