package MDP.Practicas.Sesion07.Sesion07.Sesion07;

import java.time.Clock;

public class MainReloj {

	// Método main para probar la clase Clock
	public static void main(String[] args) {
			//Fijamos un reloj a las 23:59:58
            Reloj clock = new Reloj(23, 59, 58);
			System.out.println("Current Time: " + clock.displayTime());
            clock.setHours(25);  

            inc_dec();
            
            addReloj();
			
	}
	
	public static void inc_dec() {
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
		Reloj clock1 = new Reloj(12, 45, 30);
		Reloj clock2 = new Reloj(11, 20, 40);
		System.out.println("Reloj 1: " + clock1.displayTime());
		System.out.println("Reloj 2: " + clock2.displayTime());
		clock1.addClock(clock2);
		System.out.println("Después de sumar el Reloj 2 al Reloj 1: " + clock1.displayTime());
		
		//Provamos excepción al sumar relojes que superan las 24 horas
		Reloj clock3 = new Reloj(23, 59, 59);
		Reloj clock4 = new Reloj(1, 0, 1);

		System.out.println("Reloj 3: " + clock3.displayTime());
		System.out.println("Reloj 4: " + clock4.displayTime());
		clock3.addClock(clock4);
	}

}
