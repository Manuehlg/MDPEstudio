package MDP.repaso.HereAbsInter;

public class Main {
    public static void main(String[] args) {
        Cuenta c = new CuentaJoven(1000.0D, 432432, new Persona("Luis", 5, 5)) ;
        c.depositar(1000);
        c.retirar(500);
        System.out.println(c);
    }
}
