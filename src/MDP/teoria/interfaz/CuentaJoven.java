package MDP.teoria.interfaz;

public class CuentaJoven extends Cuenta {
    //final no permite cambiar el valor mediante herencia, final -> static SIEMPRE
    private static final float minIngreso=1000.0f;
    private static final float incremento=50.0f;

    public CuentaJoven(double saldo, long numero, Persona propietario) {
        super(saldo, numero, propietario);
    }
//    public CuentaJoven(double saldo, long numero) {
//        super(saldo, numero);
//    }

    @Override
    public String toString() {
        return "CuentaJoven{ toString()="+super.toString()+"}";
    }

    public boolean depositar(float cantidad) {
        boolean resultado= super.depositar(cantidad);
        if (resultado){
            if (cantidad >= minIngreso){
                depositar(incremento);
            }
            return resultado;
        }else {
            return false;
        }
    }

    public boolean retirar(float cantidad) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
