package MDP.teoria.excepciones.basico;

public class Ejemplo08_Exception {
	public static void main(String args[]) {
		try {
			metodo1();
		} catch (MDPException e) {
			System.out.println("Excepcion en main");
		}
	}

	private static void metodo1() throws MDPException{
		try {
			metodo2();
		} catch (MDPException e) {
			System.out.println("Excepcion en método 1");
			throw e;
		}
		System.out.println("No llego aqui en método 1");
	}

	private static void metodo2() throws MDPException{
		System.out.println("Entro en método 2");
		metodo3();
		System.out.println("No llego aqui en método 2");
	}

	private static void metodo3() throws MDPException{
		System.out.println("Entro en método 3");
		try {
			Object a = null;
			System.out.println(a.toString());
		} catch (NullPointerException e) {
			throw new MDPException();
		}
		System.out.println("No llego aqui en método 3");
	}
}