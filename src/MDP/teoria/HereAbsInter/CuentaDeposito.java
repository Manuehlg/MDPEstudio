package MDP.teoria.HereAbsInter;

public class CuentaDeposito extends Cuenta {
    public CuentaDeposito(double saldo, int historial, Persona persona) {
        super(saldo, historial, persona);

    }

    @Override
    public String toString() {
        return "CuentaDeposito{} " + super.toString();
    }

    @Override
    public String generarInforme() {
        return "Informe Cuenta de Deposito";
    }
}
