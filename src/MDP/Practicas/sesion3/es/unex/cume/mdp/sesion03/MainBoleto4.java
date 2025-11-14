package MDP.Practicas.sesion3.es.unex.cume.mdp.sesion03;
import java.util.*;
import MDP.Practicas.sesion3.es.unex.cume.mdp.sesion03.boleto.*;

@SuppressWarnings("deprecation")
public class MainBoleto4 {
    public static void main(String[] args)  {
        // 1 Crear un boleto de Gordo, rellenar los numeros aleatoriamente y
        // mostrar por pantalla
        Boleto b = new Gordo(1, new Date());
        b.rellenarNumerosAleatorios();
        System.out.println(b.getNumeros().toString());

        // 2 Crear una lista de 10 boletos de Gordo con identificadores aleatorios
        // y fechas diferentes
        Random r = new Random();
        List<Boleto> l = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            // Generar día y mes aleatorio
            int mes = r.nextInt(12) + 1; // 1-12
            int dia = r.nextInt(28) + 1; // 1-28 para evitar problemas de meses cortos
            Date fechaAleatoria = new Date(125, mes - 1, dia); // Año 2025 (Date usa 1900 como base)
            b = new Gordo(r.nextInt(500), fechaAleatoria);
            b.rellenarNumerosAleatorios();
            l.add(b);
        }

        // 3 Ordenar la lista por identificador y mostrarla
        //Collections.sort(l);
        System.out.println("Lista ordenada por identificador:");

        for (Boleto b2 : l) {
            System.out.println(b2.getIdentificador() + " " + b2.getNumeros().toString());
        }


        // 4 Crear un boleto ganador y calcular aciertos y aciertos complementarios de
        // cada boleto de la lista
        Boleto ganador = new Gordo(1, new Date());
        ganador.rellenarNumerosAleatorios();
        for (Boleto b3 : l) {
            b3.aciertos(ganador);
            b3.aciertoComplementarios(ganador);
        }


        // 5 Mostrar la lista ordenada por aciertos y aciertos complementarios
        System.out.println("Lista ordenada por aciertos y aciertos complementarios:");
        Collections.sort(l, new ComparatorBoletosAciertos());    
        for (Boleto b4 : l) {
            System.out.println(b4.getIdentificador() + " " + b4.getNumAciertos() + " " +
                    b4.getNumAciertosComplementario() + " " + b4.getNumeros().toString());
        }
        
        // 6 Mostrar la lista ordenada por fecha        
        System.out.println("Lista ordenada por fecha:");
        Collections.sort(l, new ComparatorBoletosFecha());
        for (Boleto b5 : l) {
            System.out.println(b5.getIdentificador() + " " + b5.getNumAciertos() + " " +
                    b5.getNumAciertosComplementario() + " " + b5.getFecha().toString());
        }

    }
}
