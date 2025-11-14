package MDP.Practicas.sesion3.es.unex.cume.mdp.sesion03;

//taskset -c 2 java -cp bin es.unex.cume.mdp.sesion03.MainBoleto3
import java.util.*;
import MDP.Practicas.sesion3.es.unex.cume.mdp.sesion03.boleto. *;

public class MainBoleto3 {
    // Formatea el número con ceros a la izquierda y separador de miles para decenas
    // de millón
    public static String formatTiempo(long valor) {
        // Millones con 4 dígitos, resto con 3 dígitos
        // Formato: 0.xxx.yyy si millones es 0, x.xxx.yyy si millones > 0
        // Siempre dos dígitos en millones, luego bloques de tres cifras
        long millones = valor / 1000000;
        long resto = valor % 1000000;
        String millonesStr = String.format("%02d", millones);
        String restoStr = String.format("%06d", resto);
        restoStr = restoStr.substring(0, 3) + "." + restoStr.substring(3);
        return millonesStr + "." + restoStr;
    }

    public static void main(String[] args) {
        int veces = 10000;
        Random r = new Random();

        List<Boleto> l = new ArrayList<>();
        List<Boleto> l2 = new LinkedList<>();
        Set<Boleto> s = new HashSet<>();
        Set<Boleto> s2 = new TreeSet<>();
        Map<Integer, Boleto> m = new HashMap<>();
        Map<Integer, Boleto> m2 = new TreeMap<>();

        // Añadimos n boletos a cada estructura
        for (int i = 0; i < veces; i++) {
            Boleto b = new Gordo(i, new Date());
            b.rellenarNumerosAleatorios();
            l.add(b);
            l2.add(b);
            s.add(b);
            s2.add(b);
            m.put(b.getIdentificador(), b);
            m2.put(b.getIdentificador(), b);
        }

        // Genero una lista de posiciones aleatorias
        List<Integer> posiciones = new ArrayList<>();
        for (int i = 0; i < veces; i++) {
            posiciones.add(i);
        }
        Collections.shuffle(posiciones);

        ///////////////////////////////////////
        // Tiempo acceso secuencial
        //////////////////////////////////////////////

        // Tiempo para ArrayList
        long inicioL = System.nanoTime();
        for (int i = 0; i < veces; i++) {
            Boleto b = l.get(i);

        }
        long finL = System.nanoTime();

        // Tiempo para linkedList
        long inicioL2 = System.nanoTime();
        Iterator<Boleto> it = l2.iterator();
        while (it.hasNext()) {
            Boleto b = it.next();

        }
        long finL2 = System.nanoTime();

        // Tiempo para HashSet
        long inicioS = System.nanoTime();
        it = s.iterator();
        while (it.hasNext()) {
            Boleto b = it.next();
        }
        long finS = System.nanoTime();

        // Tiempo para TreeSet
        long inicioS2 = System.nanoTime();
        it = s2.iterator();
        while (it.hasNext()) {
            Boleto b = it.next();
        }
        long finS2 = System.nanoTime();

        // Tiempo para HashMap
        long inicioM = System.nanoTime();
        for (int i = 0; i < veces; i++) {
            Boleto b = m.get(Integer.valueOf(i));
        }
        long finM = System.nanoTime();

        // Tiempo para HashMap
        long inicioM2 = System.nanoTime();
        for (int i = 0; i < veces; i++) {
            Boleto b = m2.get(Integer.valueOf(i));
        }
        long finM2 = System.nanoTime();

        // Muestro los tiempos
        System.out.println("Accesos Secuenciales de" + veces + " elementos:");
        System.out.println("Tiempo ArrayList (get(i)):      " + formatTiempo(finL - inicioL) + " ns");
        System.out.println("Tiempo LinkedList (iterator):   " + formatTiempo(finL2 - inicioL2) + " ns");
        System.out.println("Tiempo HashSet(iterator):       " + formatTiempo(finS - inicioS) + " ns");
        System.out.println("Tiempo TreeSet(iterator):       " + formatTiempo(finS2 - inicioS2) + " ns");
        System.out.println("Tiempo HashMap(posición Clave): " + formatTiempo(finM - inicioM) + " ns");
        System.out.println("Tiempo TreeMap(posición Clave): " + formatTiempo(finM2 - inicioM2) + " ns");

        /*
         * Acceso secuencial en las colecciones Java:
         * 
         * ArrayList y LinkedList: Permiten acceso secuencial por índice usando un bucle
         * for o for-each. Muy eficiente en ArrayList O(1) y lengo en LinkedList O(n).
         * HashSet y TreeSet: Solo permiten acceso secuencial usando un iterador o
         * for-each, no por índice. Eficiente O(n)
         * HashMap y TreeMap: Puedes recorrer los valores, claves o pares con for-each,
         * pero no accedes por índice, sino por clave. Eficiente (O(n))
         */

        //////////////////////////////////////////////
        // Tiempo acceso aleatorio
        //////////////////////////////////////////////

        // Tiempo para ArrayList
        inicioL = System.nanoTime();

        for (int i = 0; i < posiciones.size(); i++) {
            Boleto b = l.get(posiciones.get(i));
        }
        finL = System.nanoTime();

        // Tiempo para LinkedList
        inicioL2 = System.nanoTime();
        for (int i = 0; i < posiciones.size(); i++) {
            Boleto b = l2.get(posiciones.get(i));
        }
        finL2 = System.nanoTime();

        // Tiempo para HashMap
        inicioM = System.nanoTime();
        for (int i = 0; i < posiciones.size(); i++) {
            Boleto b = m.get(Integer.valueOf(posiciones.get(i)));
        }
        finM = System.nanoTime();

        // Tiempo para HashMap
        inicioM2 = System.nanoTime();
        for (int i = 0; i < posiciones.size(); i++) {
            Boleto b = m2.get(Integer.valueOf(posiciones.get(i)));
        }
        finM2 = System.nanoTime();

        // Muestro los tiempos
        System.out.println("\n\nAcceso por Posición Aleatorio de " + veces + " elementos:");
        System.out.println("Tiempo ArrayList (get(random)):  " + formatTiempo(finL - inicioL) + " ns");
        System.out.println("Tiempo LinkedList (get(ramdom)): " + formatTiempo(finL2 - inicioL2) + " ns");
        System.out.println("Tiempo HashSet: No tiene sentido");
        System.out.println("Tiempo TreeSet: No tiene sentido");
        System.out.println("Tiempo HashMap (posicion Clave): " + formatTiempo(finM - inicioM) + " ns");
        System.out.println("Tiempo TreeMap (posicion Clave): " + formatTiempo(finM2 - inicioM2) + " ns");
        /*
         * Acceso aleatorio por posición: *
         * ArrayList: Permite acceso aleatorio eficiente por índice (arrayList.get(i)).
         * O(1)
         * LinkedList: Permite acceso por índice, pero es lento (recorre desde el
         * inicioo final). Eficiencia O(n).
         * HashSet y TreeSet: No Aplicable, solo por iterador.
         * HashMap y TreeMap: Permiten acceso aleatorio eficiente por clave
         * (map.get(clave)), pero no por índice.
         * 
         */

        //////////////////////////////////////////////
        // Tiempo acceso por objeto
        //////////////////////////////////////////////

        // Tiempo para ArrayList
        inicioL = System.nanoTime();

        for (int i = 0; i < posiciones.size(); i++) {
            Boleto b = l.get(posiciones.get(i));
            l.contains(b);
        }
        finL = System.nanoTime();

        // Tiempo para LinkedList
        inicioL2 = System.nanoTime();
        for (int i = 0; i < posiciones.size(); i++) {
            Boleto b = l2.get(posiciones.get(i));
            l2.contains(b);
        }
        finL2 = System.nanoTime();

        // Tiempo para HashSet
        inicioS = System.nanoTime();
        for (int i = 0; i < veces; i++) {
            Boleto b = new Gordo(posiciones.get(i), null);
            s.contains(b);
        }
        finS = System.nanoTime();

        // Tiempo para TreeSet
        inicioS2 = System.nanoTime();
        for (int i = 0; i < veces; i++) {
            Boleto b = new Gordo(posiciones.get(i), null);
            s2.contains(b);
        }
        finS2 = System.nanoTime();

        // Tiempo para HashMap
        inicioM = System.nanoTime();
        for (int i = 0; i < posiciones.size(); i++) {
            Boleto b = m.get(Integer.valueOf(posiciones.get(i)));
        }
        finM = System.nanoTime();

        // Tiempo para HashMap
        inicioM2 = System.nanoTime();
        for (int i = 0; i < posiciones.size(); i++) {
            Boleto b = m2.get(Integer.valueOf(posiciones.get(i)));
        }
        finM2 = System.nanoTime();

        // Muestro los tiempos
        System.out.println("\n\nAcceso Por Objeto aleatorios  " + veces + " elementos:");
        System.out.println("Tiempo ArrayList (contains):  " + formatTiempo(finL - inicioL) + " ns");
        System.out.println("Tiempo LinkedList (contains): " + formatTiempo(finL2 - inicioL2) + " ns");
        System.out.println("Tiempo HashSet (contains):    " + formatTiempo(finS - inicioS) + " ns");
        System.out.println("Tiempo TreeSet (contains):    " + formatTiempo(finS2 - inicioS2) + " ns");
        System.out.println("Tiempo HashMap (get(key)):    " + formatTiempo(finM - inicioM) + " ns");
        System.out.println("Tiempo TreeMap (get(key)):    " + formatTiempo(finM2 - inicioM2) + " ns");
        /*
         * Acceso por objeto:
         * 
         * ArrayList y LinkedList: Puedes buscar un objeto con el método contains(obj) o
         * indexOf(obj), pero no es acceso directo, sino búsqueda lineal. Lento O(n)
         * HashSet y TreeSet: Permiten acceso eficiente por objeto usando contains(obj)
         * y remove(obj), gracias a hashCode/equals (HashSet) o compareTo (TreeSet). HS
         * O(1) y TS O(lgn)
         * HashMap y TreeMap: El acceso es por clave (que puede ser un objeto), usando
         * get(obj), containsKey(obj), remove(obj). HM O(1) y TM O(lgn)
         */

        ///////////////////////////////////////
        // Tiempo borrado secuencial
        /////////////////////////////////////////
        // ArrayList
        List<Boleto> lBorrar = new ArrayList<>(l);
        long inicioBorrarL = System.nanoTime();
        for (int i = 0; i < veces; i++) {
            Boleto b = lBorrar.remove(0); // Siempre borra el primero
        }
        long finBorrarL = System.nanoTime();

        // LinkedList
        List<Boleto> l2Borrar = new LinkedList<>(l2);
        long inicioBorrarL2 = System.nanoTime();
        for (int i = 0; i < veces; i++) {
            Boleto b = l2Borrar.remove(0);
        }
        long finBorrarL2 = System.nanoTime();
        // HashMap
        Map<Integer, Boleto> mBorrar = new HashMap<>(m);
        long inicioBorrarM = System.nanoTime();
        for (int i = 0; i < veces; i++) {
            Boleto b = mBorrar.remove(Integer.valueOf(i));
        }
        long finBorrarM = System.nanoTime();

        // TreeMap
        Map<Integer, Boleto> mBorrar2 = new TreeMap<>(m2);
        long inicioBorrarM2 = System.nanoTime();
        for (int i = 0; i < veces; i++) {
            Boleto b = mBorrar2.remove(Integer.valueOf(i));
        }
        long finBorrarM2 = System.nanoTime();
        System.out.println("\n\nBorrado Secuencial de " + veces + " elementos:");
        System.out.println("Tiempo ArrayList(posicion 0):  " + formatTiempo(finBorrarL - inicioBorrarL) + " ns");
        System.out.println("Tiempo LinkedList(posicion 0): " + formatTiempo(finBorrarL2 - inicioBorrarL2) + " ns");
        System.out.println("Tiempo HashSet: No tiene sentido");
        System.out.println("Tiempo TreeSet: No tiene sentido");
        System.out.println("Tiempo HashMap:                " + formatTiempo(finBorrarM - inicioBorrarM) + " ns");
        System.out.println("Tiempo TreeMap:                " + formatTiempo(finBorrarM2 - inicioBorrarM2) + " ns");
        /*
         * Borrado por posición
         * ArrayList: El borrado por posicion (remove(posicion)) es más eficiente. pues
         * no tiene que desplazar tanto, aun se mantiene Lentísimo O(n²)
         * LinkedList: El borrado por posición (remove(posición)) es muy lento. O(n²)
         * borrado), ya que solo actualiza referencias. Lento O(n)
         * HashSet: No tiene sentido el borrado por posición
         * TreeSet: No tiene sentido el borrado por posición
         * HashMap: Borrado por clave es eficiente (O(1) promedio por borrado).
         * TreeMap: Borrado por clave es eficiente (O(log n) por borrado).
         */

        ///////////////////////////////////////
        // Tiempo borrado aleatorio
        /////////////////////////////////////////

        // ArrayList
        lBorrar = new ArrayList<>(l);
        inicioBorrarL = System.nanoTime();
        for (int i = 0; i < veces; i++) {
            lBorrar.remove((int) r.nextInt(lBorrar.size()));
        }
        finBorrarL = System.nanoTime();

        // LinkedList
        l2Borrar = new LinkedList<>(l2);
        inicioBorrarL2 = System.nanoTime();
        for (int i = 0; i < veces; i++) {
            l2Borrar.remove((int) r.nextInt(l2Borrar.size()));
        }
        finBorrarL2 = System.nanoTime();

        // HashMap
        mBorrar = new HashMap<>(m);
        inicioBorrarM = System.nanoTime();
        for (int i = 0; i < veces; i++) {
            mBorrar.remove(r.nextInt(mBorrar.size()));
        }
        finBorrarM = System.nanoTime();

        // TreeMap
        mBorrar2 = new TreeMap<>(m2);
        inicioBorrarM2 = System.nanoTime();
        for (int i = 0; i < veces; i++) {
            mBorrar2.remove(r.nextInt(mBorrar2.size()));
        }
        finBorrarM2 = System.nanoTime();

        System.out.println(
                "\n\nBorrado Aleatorio Posición de " + veces + " elementos:");
        System.out.println("Tiempo ArrayList (posicion):          " + formatTiempo(finBorrarL - inicioBorrarL) + " ns");
        System.out
                .println("Tiempo LinkedList (posicion):         " + formatTiempo(finBorrarL2 - inicioBorrarL2) + " ns");
        System.out.println("Tiempo HashSet: No tiene sentido");
        System.out.println("Tiempo TreeSet: No tiene sentido");
        System.out.println("Tiempo HashMap(posicion-clave):       " + formatTiempo(finBorrarM - inicioBorrarM) + " ns");
        System.out
                .println("Tiempo TreeMap(posicion-clave):       " + formatTiempo(finBorrarM2 - inicioBorrarM2) + " ns");

        /*
         * Borrado por posición
         * ArrayList: El borrado por posicion (remove(posicion)) es más eficiente. pues
         * no tiene que desplazar tanto, aun se mantiene Lentísimo O(n²)
         * LinkedList: El borrado por posición (remove(posición)) es muy lento. O(n²)
         * HashSet: No tiene sentido el borrado por posición
         * TreeSet: No tiene sentido el borrado por posición
         * HashMap: Borrado por clave es eficiente (O(1) promedio por borrado).
         * TreeMap: Borrado por clave es eficiente (O(log n) por borrado).
         * 
         */
        ///////////////////////////////////////
        // Tiempo borrado por objeto aleatorio
        /////////////////////////////////////////
        // ArrayList
        lBorrar = new ArrayList<>(l);
        inicioBorrarL = System.nanoTime();
        for (int i = 0; i < veces; i++) {
            lBorrar.remove(lBorrar.get(r.nextInt(lBorrar.size()))); // Borra aleatorioamente por objeto
        }
        finBorrarL = System.nanoTime();
        // LinkedList
        l2Borrar = new LinkedList<>(l2);
        inicioBorrarL2 = System.nanoTime();
        for (int i = 0; i < veces; i++) {
            l2Borrar.remove(l2Borrar.get(r.nextInt(l2Borrar.size()))); // Borra aleatorioamente por objeto
        }
        finBorrarL2 = System.nanoTime();
        // HashSet
        Set<Boleto> sBorrar = new HashSet<>(s);
        long inicioBorrarS = System.nanoTime();
        for (int i = 0; i < veces; i++) {
            Boleto b = new Gordo(i, null);
            sBorrar.remove(b);
        }
        long finBorrarS = System.nanoTime();
        // TreeSet
        Set<Boleto> s2Borrar = new TreeSet<>(s2);
        long inicioBorrarS2 = System.nanoTime();
        for (int i = 0; i < veces; i++) {
            Boleto b = new Gordo(i, null);
            s2Borrar.remove(b);
        }
        long finBorrarS2 = System.nanoTime();
        // HashMap
        mBorrar = new HashMap<>(m);
        inicioBorrarM = System.nanoTime();
        for (int i = 0; i < veces; i++) {
            mBorrar.remove(Integer.valueOf(r.nextInt(mBorrar.size())));
        }
        finBorrarM = System.nanoTime();
        // TreeMap
        mBorrar2 = new TreeMap<>(m2);
        inicioBorrarM = System.nanoTime();
        for (int i = 0; i < veces; i++) {
            mBorrar2.remove(Integer.valueOf(r.nextInt(mBorrar2.size())));
        }
        finBorrarM = System.nanoTime();

        System.out.println("\n\nBorrado Por Objetos Aleatorios de " + veces + " elementos:");
        System.out
                .println("Tiempo ArrayList(remove-object):       " + formatTiempo(finBorrarL - inicioBorrarL) + " ns");
        System.out.println(
                "Tiempo LinkedList(remove-object):      " + formatTiempo(finBorrarL2 - inicioBorrarL2) + " ns");
        System.out
                .println("Tiempo HashSet(remove-object):         " + formatTiempo(finBorrarS - inicioBorrarS) + " ns");
        System.out.println(
                "Tiempo TreeSet(remove-object):         " + formatTiempo(finBorrarS2 - inicioBorrarS2) + " ns");
        System.out
                .println("Tiempo HashMap(remove-key):            " + formatTiempo(finBorrarM - inicioBorrarM) + " ns");
        System.out.println(
                "Tiempo TreeMap(remove-key):            " + formatTiempo(finBorrarM2 - inicioBorrarM2) + " ns");

        /*
         * * Borrado por objeto:
         * 
         * ArrayList y LinkedList: Debe realizar una búsqueda lineal para encontrar el objeto (O(n)) y luego desplazar los elementos. Muy lento O(n²)
         * HashSet y TreeSet: remove(obj) elimina el objeto si existe (HashSet usa equals/hashCode
         * TreeSet usa compareTo. O(n) y O(lgn) respectivamente.
         * HashMap y TreeMap: remove(clave) elimina el par clave-valor donde la clave es  el objeto. O(n) y O(lgn) respectivamente.
         */

        /*
        | Colección   | Acceso Secuencial | Acceso Aleatorio | Acceso por Objeto | Borrado Secuencial | Borrado Aleatorio | Borrado por Objeto |
        |-------------|-------------------|------------------|-------------------|--------------------|-------------------|--------------------|
        | ArrayList   | O(n)              | O(1)             | O(n)              | O(n^2)             | O(n^2)            | O(n^2)             |
        | LinkedList  | O(n) (iterator)   | O(n)             | O(n)              | O(n)               | O(n^2)            | O(n^2)             |
        | HashSet     | O(n) (iterator)   | N/A              | O(1)              | N/A                | N/A               | O(n)               |
        | TreeSet     | O(n) (iterator)   | N/A              | O(log n)          | N/A                | N/A               | O(n log n)         |
        | HashMap     | O(n) (iterator)   | O(1) (por clave) | O(1) (por clave)  | O(n)               | O(n)              | O(n)               |
        | TreeMap     | O(n) (iterator)   | O(log n) (clave) | O(log n) (clave)  | O(n)               | O(n)              | O(n log n)         |
        */
    }
}