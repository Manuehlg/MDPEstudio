package MDP.Practicas.Sesion07.Sesion07.Sesion07;

public class Reloj {
	// Campos para horas, minutos y segundos
	private int hours;
	private int minutes;
	private int seconds;

	// Constructor para inicializar el reloj con horas, minutos y segundos dados
	public Reloj(int hours, int minutes, int seconds) {
		setHours(hours);
		setMinutes(minutes);
		setSeconds(seconds);
	}

	// Constructor por defecto que inicializa el reloj a 00:00:00
	public Reloj() {
		this(0, 0, 0);
	}

	// Getters
	public int getHours() {
		return hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	// Setters con validación para lanzar IllegalArgumentException si los valores
	// están fuera de rango
	public void setHours(int hours) {
		//TODO: validar que hours esté entre 0 y 23 y sino devolver una excepción
		this.hours = hours;
	}

	public void setMinutes(int minutes) {
		//TODO: validar que minutes esté entre 0 y 59 y sino devolver una excepción
		this.minutes = minutes;
	}

	public void setSeconds(int seconds) {
		//TODO: validar que seconds esté entre 0 y 59 y sino devolver una excepción
		this.seconds = seconds;
	}

	// Método para incrementar el tiempo en un segundo
	public void incSeg() {
		seconds++;
		if (seconds == 60) {
			seconds = 0;
			minutes++;
			if (minutes == 60) {
				minutes = 0;
				hours = (hours + 1);
				//TODO: comprobar si supera las 24 horas y devolver una excepción

			}
		}
	}

	// Método para decrementar el tiempo en un segundo
	public void decSeg() {
		//TODO: Comprobar si todo es 0 para generar excepción
		if (seconds == 0) {
			seconds = 59;
			if (minutes == 0) {
				minutes = 59;
				hours = (hours == 0) ? 23 : hours - 1;
			} else {
				minutes--;
			}
		} else {
			seconds--;
		}
	}

	// Método para sumar otro objeto Clock a este, con manejo de excepciones
	public void addClock(Reloj otherClock) {
		
		int newSeconds = this.seconds + otherClock.getSeconds();
		int newMinutes = this.minutes + otherClock.getMinutes() + newSeconds / 60;
		int newHours = this.hours + otherClock.getHours() + newMinutes / 60;

		//TODO: Compruebo si las horas superan las 24 para lanzar excepción

		// Ajuste de valores usando aritmética modular
		this.seconds = newSeconds % 60;
		this.minutes = newMinutes % 60;
		this.hours = newHours;
	}

	// Método para mostrar el tiempo en formato HH:MM:SS
	public String displayTime() {
		return String.format("%02d:%02d:%02d", hours, minutes, seconds);
	}
}
