package MDP.Practicas.Sesion07.Sesion07.Sesion07;

public class Reloj {
    // Campos para horas, minutos y segundos
    private int hours;
    private int minutes;
    private int seconds;

    // Constructor para inicializar el reloj con horas, minutos y segundos dados
    public Reloj(int hours, int minutes, int seconds) throws RelojNoValido {
        setHours(hours);
        setMinutes(minutes);
        setSeconds(seconds);
    }

    // Constructor por defecto que inicializa el reloj a 00:00:00
    public Reloj() throws RelojNoValido {
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
    public void setHours(int hours) throws RelojNoValido {
        //TODO: validar que hours esté entre 0 y 23 y sino devolver una excepción
        if (hours < 0 || hours > 23) {
            this.hours = hours;
        } else {
            throw new RelojNoValido();
        }
    }

    public void setMinutes(int minutes) throws RelojNoValido {
        //TODO: validar que minutes esté entre 0 y 59 y sino devolver una excepción

        if (minutes < 0 || minutes > 60) {
            this.minutes = minutes;
        } else {
            throw new RelojNoValido();
        }

    }

    public void setSeconds(int seconds) throws RelojNoValido {
        //TODO: validar que seconds esté entre 0 y 59 y sino devolver una excepción


        if (seconds < 0 || seconds > 60) {
            this.seconds = seconds;
        } else {
            throw new RelojNoValido();
        }
    }

    // Método para incrementar el tiempo en un segundo
    public void incSeg() throws DesbordamientoReloj {
        seconds++;
        if (seconds == 60) {
            seconds = 0;
            minutes++;
            if (minutes == 60) {
                minutes = 0;
                hours = (hours + 1);
                //TODO: comprobar si supera las 24 horas y devolver una excepción
                if (hours > 23){
                    throw new DesbordamientoReloj();
                }

            }
        }
    }

    // Método para decrementar el tiempo en un segundo
    public void decSeg() throws DesbordamientoReloj {
        //TODO: Comprobar si todo es 0 para generar excepción
        if (seconds == 0) {
            seconds = 59;
            if (minutes == 0) {
                minutes = 59;
                //hours = (hours == 0) ? 23 : hours - 1;
                if (hours ==0){
                    throw new DesbordamientoReloj();
                }
                hours--;
            } else {
                minutes--;
            }
        } else {
            seconds--;
        }
    }

    // Método para sumar otro objeto Clock a este, con manejo de excepciones
    public void addClock(Reloj otherClock) throws DesbordamientoReloj {

        int newSeconds = this.seconds + otherClock.getSeconds();
        int newMinutes = this.minutes + otherClock.getMinutes() + newSeconds / 60;
        int newHours = this.hours + otherClock.getHours() + newMinutes / 60;

        //TODO: Compruebo si las horas superan las 24 para lanzar excepción

        // Ajuste de valores usando aritmética modular
        this.seconds = newSeconds % 60;
        this.minutes = newMinutes % 60;


        if (newHours > 23){
            throw new DesbordamientoReloj();
        }
        this.hours = newHours;

    }

    // Método para mostrar el tiempo en formato HH:MM:SS
    public String displayTime() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
