
package MDP.Practicas.sesion3.es.unex.cume.mdp.sesion03.boleto;

import java.util.*;

public class Euromillon extends Boleto {

    // Euromillon: 5 números entre 1 y 49 y 2 complementarios entre 0 y 9

    private int complementario1, complementario2;

    public Euromillon(int identificador, Date f) {
        super(identificador, f, 5, 49, 9);
    }

    public Euromillon(int identificador, Date f, int c1, int c2) {
        super(identificador, f);
        this.complementario1 = c1;
        this.complementario2 = c2;
    }



    public int aciertoComplementarios(Boleto b) {
    	Euromillon aux=(Euromillon)b;
    	int contar=0;
    	if (this.complementario1==aux.complementario1)
        	contar++;
    	if (this.complementario2==aux.complementario2)
        	contar++;
    	if (this.complementario1==aux.complementario2)
        	contar++;
    	if (this.complementario2==aux.complementario1)
        	contar++;    	
        return contar;
   }

    public boolean rellenarNumerosAleatorios() {
    	 Random r = new Random(new Date().getTime());
         while (this.numeros.size() != cantidadNumeros) {
             try {
                 Thread.sleep(10);
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
            this.numeros.add(r.nextInt(maxNumero) + 1);
         }
         this.complementario1 = r.nextInt(maxComplementario);
         this.complementario2 = r.nextInt(maxComplementario);
         return true;
    }

    public int getComplementario1() {
        return complementario1;
    }

    public void setComplementario1(int complementario1) {
        this.complementario1 = complementario1;
    }

    public int getComplementario2() {
        return complementario2;
    }

    public void setComplementario2(int complementario2) {
        this.complementario2 = complementario2;
    }

    @Override
    public String toString() {
        return "Euromillon [identificador=" + identificador + ", complementario1=" + complementario1
                + ", complementario2=" + complementario2 + ", numeros=" + numeros
                + "]";
    }
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
