package MDP.teoria.HereAbsInter;

public class CuentaCorriente extends Cuenta implements Pagable {
    public CuentaCorriente(double saldo, int historial, Persona persona) {
        super(saldo, historial, persona);

    }

    @Override
    public String toString() {
        return "CuentaCorriente{} " + super.toString();
    }


    @Override
    //Redefine --> implementa el interfaz Informe

    public String generarInforme() {
        return "Informe de Cuenta corriente";
    }

    @Override
    public boolean pagar(float cantidad) {
        return retirar(cantidad);
    }
}
