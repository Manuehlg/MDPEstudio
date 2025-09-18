package MDP.repaso.interfaz;

public interface CuentaInterface {
    public boolean addTransaccion (Transaccion transaccion);

    public boolean depositar (float valor);

    public boolean retirar (float valor);
}
