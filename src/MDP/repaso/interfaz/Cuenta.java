package MDP.repaso.interfaz;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Cuenta implements CuentaInterface{
    protected double saldo;
    protected long numero;
    //getters setters
    protected Persona propietario; //Composicion unaria
    //getters setters y addtransaccion,
    //constructores NO RECIBEN la naria y hay que hacer new
    protected List<Transaccion> historial;

    public Cuenta(double saldo, long numero, Persona propietario, List<Transaccion> historial) {
        super();
        this.saldo = saldo;
        this.numero = numero;
        this.propietario = propietario;
        this.historial = historial;


    }

    public Cuenta(double saldo, long numero, Persona propietario) {
        super();
        this.saldo = saldo;
        this.numero = numero;
        this.propietario = propietario;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public Persona getPropietario() {
        return propietario;
    }

    public void setPropietario(Persona propietario) {
        this.propietario = propietario;
    }

    public List<Transaccion> getHistorial() {
        return historial;
    }

    public void setHistorial(List<Transaccion> historial) {
        this.historial = historial;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cuenta cuenta)) return false;
        return Double.compare(saldo, cuenta.saldo) == 0 && numero == cuenta.numero && Objects.equals(propietario, cuenta.propietario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(saldo, numero, propietario);
    }

    public boolean addTransaccion(Transaccion transaccion) {
        //Cuenta c1 es de Luis, saldo 1000 y numero de cuenta 143254498
        //Trasasccion tipo 1, 500€
        if (transaccion.getTipo()==0){ //ingresar
            saldo = saldo + transaccion.getCantidad();
        }
        else if ( transaccion.getTipo()==1){
            if (saldo>=transaccion.getCantidad()){
                saldo = saldo - transaccion.getCantidad();
            }
        }
        else {
            return false;
        }
        return historial.add(transaccion);
    }

    public boolean depositar(float cantidad) {
        Transaccion t = new Transaccion(0, cantidad, new Date());
        return addTransaccion(t);
    }

    public boolean retirar(float cantidad) {
        Transaccion t = new Transaccion(1, cantidad, new Date());
        return addTransaccion(t);
    }
}
