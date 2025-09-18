package MDP.repaso.HereAbsInter;

import java.util.Date;
import java.util.Objects;

public class Transaccion {
    private int tipo; // 0 = ingreso, 1 = egreso
    private float cantidad;
    private Date date;


    public Transaccion(int tipo, float cantidad, Date date) {
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.date = date;

    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Transaccion that)) return false;
        return tipo == that.tipo && Float.compare(cantidad, that.cantidad) == 0 && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo, cantidad, date);
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "date=" + date +
                ", tipo=" + tipo +
                ", cantidad=" + cantidad +
                '}';
    }
}
