package MDP.Practicas.Sesion07.Sesion07.Sesion07;

import java.time.Clock;

public class MainReloj {

	// Método main para probar la clase Clock
	public static void main(String[] args)  {
			//Fijamos un reloj a las 23:59:58
        Reloj clock = null;
        try {
            clock = new Reloj(23, 59, 58);

			System.out.println("Current Time: " + clock.displayTime());
			clock.setHours(25);

		} catch (RelojNoValido e) {
            System.out.println("Reloj no valido");
        }

        try {
            inc_dec();
        } catch (DesbordamientoReloj | RelojNoValido e) {
			System.out.println("Ha habido fallos de incre/decre");
        }

        addReloj();

	}
	
	public static void inc_dec() throws DesbordamientoReloj, RelojNoValido {
		//Provamos excepción al incrementar segundos
		Reloj clock = new Reloj(23, 59, 59);
		System.out.println("Current Time: " + clock.displayTime());
		clock.incSeg();
		System.out.println("Current Time: " + clock.displayTime());
		

		//Provamos excepción al decrementar segundos
		clock = new Reloj(0, 0, 0);
		System.out.println("Current Time: " + clock.displayTime());
		
		clock.decSeg();
		System.out.println("Current Time: " + clock.displayTime());
	}
	
	public static void addReloj() {
		//Provamos excepción al sumar relojes que superan las 24 horas
        Reloj clock1 = null;
        Reloj clock2 = null;
        try {
            clock1 = new Reloj(12, 45, 30);
            clock2 = new Reloj(11, 20, 40);
            System.out.println("Reloj 1: " + clock1.displayTime());

			clock1.addClock(clock2);
			System.out.println("Después de sumar el Reloj 2 al Reloj 1: " + clock1.displayTime());
        } catch (RelojNoValido e) {
			System.out.println("Reloj mal inicializado");
        } catch (DesbordamientoReloj e) {
			System.out.println("Problemas al sumar el reloj");
        }


        //Provamos excepción al sumar relojes que superan las 24 horas
        try {
            Reloj clock3 = new Reloj(23, 59, 59);
            Reloj clock4 = new Reloj(1, 0, 1);

            System.out.println("Reloj 3: " + clock3.displayTime());
            System.out.println("Reloj 4: " + clock4.displayTime());
            clock3.addClock(clock4);
        } catch (RelojNoValido e) {
			System.out.println("Reloj mal inicializado");
        } catch (DesbordamientoReloj e) {
			System.out.println("Problemas al sumar el reloj");
        }
    }

}
