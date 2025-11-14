package MDP.teoria.excepciones.balneario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Balneario {
    
    private List<Servicio> servicios = new ArrayList<>();
    private HashMap<String, Cliente> clientes = new HashMap<>();

    public Balneario() {
    }

    public void agregarServicio(Servicio s) {
        servicios.add(s);
    }

    public void agregarCliente(Cliente c) {
        clientes.put(c.getDni(), c);
    }

    public Cliente buscarClientePorDni(String dni) throws ClienteNoEncontradoException {
        Cliente cliente = clientes.get(dni);
        if (cliente == null) {
            throw new ClienteNoEncontradoException("Cliente no encontrado: " + dni);
        }
        return cliente;
    }

    public long contarMasajes() {
        int contar = 0;
        for (Servicio s : servicios) {
            if (s instanceof Masaje) {
                contar++;
            }
        }
        return contar;
    }

    public double calcularPrecioPorDni(String dni) throws ClienteNoEncontradoException {
        Cliente cliente = buscarClientePorDni(dni);
        return cliente.calcularTotal();
    }

    public double facturacionTotal() {
        double total = 0;
        for (Cliente c : clientes.values()) {
            total += c.calcularTotal();
        }
        return total;
    }

    public List<String> jubiladosConHidroterapiaMayor30() {
        List<String> resultado = new ArrayList<>();
        for (Cliente c : clientes.values()) {
            if (c instanceof Jubilado) {
                boolean tiene = false;
                for (Servicio s : c.servicios) {
                    if (s instanceof Hidroterapia && s.getPrecio() > 30) {
                        tiene = true;
                        break;
                    }
                }
                if (tiene)
                    resultado.add(c.getNombre());
            }
        }
        return resultado;
    }

    public Cliente clienteQueMasGasto() {
        Cliente clienteMax = null;
        double maxGasto = 0;
        for (Cliente c : clientes.values()) {
            double gasto = c.calcularTotal();
            if (gasto > maxGasto) {
                maxGasto = gasto;
                clienteMax = c;
            }
        }
        return clienteMax;
    }


    public void crearDatosEjemplos() throws PrecioInvalidoException, DniInvalidoException {
        // Crear servicios
        Servicio s1 = new Masaje("S1", "Masaje relajante", 50, "Relajante");
        Servicio s2 = new Lodo("S2", "Lodo chocolate", 40, "Chocolate");
        Servicio s3 = new Hidroterapia("S3", "Hidroterapia básica", 35, "Modelo A");
        Servicio s4 = new Masaje("S4", "Masaje deportivo", 60, "Deportivo");
        Servicio s5 = new Lodo("S5", "Lodo arcilla", 25, "Arcilla");

        agregarServicio(s1);
        agregarServicio(s2);
        agregarServicio(s3);
        agregarServicio(s4);
        agregarServicio(s5);

        // Crear clientes
        Cliente c1 = new Jubilado("Ana", "1R", 70);
        c1.agregarServicio(s1);
        c1.agregarServicio(s2);

        Cliente c2 = new Socio("Luis", "2W", "SOC123");
        c2.agregarServicio(s3);
        c2.agregarServicio(s4);
        c2.agregarServicio(s5);

        agregarCliente(c1);
        agregarCliente(c2);
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public HashMap<String, Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(HashMap<String, Cliente> clientes) {
        this.clientes = clientes;
    }
}