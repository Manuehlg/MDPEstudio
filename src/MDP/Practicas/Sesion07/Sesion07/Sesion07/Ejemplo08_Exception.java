package MDP.Practicas.Sesion07.Sesion07.Sesion07;

public class Ejemplo08_Exception {
    public static void main(String args[]) {
        //try {
            metodo1();
        //} catch (MDPException e) {
        //    System.out.println("Excepcion en main");
        //}
    }

    private static void metodo1() {
        try {
            metodo2();
        } catch (MDPException e) {
            System.out.println("Excepcion en método 1");
        }
    }

    private static void metodo2() throws MDPException {
        metodo3();
    }

    private static void metodo3() throws MDPException {
        try {
            Object a = null;
            System.out.println(a.toString());
        } catch (NullPointerException e) {
            throw new MDPException();
        }
    }
}
