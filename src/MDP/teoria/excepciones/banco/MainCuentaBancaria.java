package MDP.teoria.excepciones.banco;

public class MainCuentaBancaria {
	public static void main(String[]args) {
		CuentaBancaria b=new CuentaBancaria();
		System.out.println(b.getDisponible());
		deposito(b,100.0F);		//Funciona
		deposito(b,-50.0F);		//Error
		retiro(b,-10.0F);		//Error
		retiro(b,20.0F);		//Funciona
		retiro(b,1000.0F);		//Error
	}
	
	public static void deposito(CuentaBancaria c,float f) {
		if (c.depositar(f)) {
			System.out.println("He metido el dinero");
		}else {
			System.out.println("No he metido el dinero");
		}
	}
	
	public static void retiro(CuentaBancaria c,float f) {
		if (c.retirar(f)) {
			System.out.println("Se ha retirado con exito");
		}else {	//Por dos casos
			System.out.println("No se ha retirado con exito");
		}
	}

}
