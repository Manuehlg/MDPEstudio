package MDP.teoria.excepciones.balneario;

import java.util.List;
import java.util.Scanner;

public class MainBalneario {
    
    private Balneario balneario = new Balneario();
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        MainBalneario m = new MainBalneario();
        m.ejecutar();
    }

    public void ejecutar() {
        int opcion;
        try {
            balneario.crearDatosEjemplos();
        } catch (PrecioInvalidoException | DniInvalidoException e) {
            System.out.println("Error al crear datos de ejemplo: " + e.getMessage());
            // System.exit(1);
            System.out.println("Comenzando sin datos de ejemplo.");
        }

        // Menú interactivo
        do {
            System.out.println("\n=== MENÚ BALNEARIO ===");
            System.out.println("1. Contar masajes");
            System.out.println("2. Calcular precio por DNI");
            System.out.println("3. Facturación total");
            System.out.println("4. Jubilados con hidroterapia >30€");
            System.out.println("5. Cliente que más gastó");
            System.out.println("6. Añadir cliente");
            System.out.println("7. Agregar servicio a cliente");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("Número de masajes: " + balneario.contarMasajes());
                    break;

                case 2:
                    System.out.print("Introduzca el DNI del cliente: ");
                    String dni = sc.nextLine();
                    try {
                        double precio = balneario.calcularPrecioPorDni(dni);
                        System.out.println("Precio total: " + precio + "€");
                    } catch (ClienteNoEncontradoException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Facturación total: " + balneario.facturacionTotal() + "€");
                    break;

                case 4:
                    List<String> jubilados = balneario.jubiladosConHidroterapiaMayor30();
                    if (jubilados.isEmpty()) {
                        System.out.println("No hay jubilados con hidroterapia >30€");
                    } else {
                        System.out.println("Jubilados con hidroterapia >30€: " + jubilados);
                    }
                    break;

                case 5:
                    Cliente cliente = balneario.clienteQueMasGasto();
                    if (cliente != null) {
                        System.out.println("Cliente que más gastó: " + cliente.getNombre() +
                                " (" + cliente.calcularTotal() + "€)");
                    } else {
                        System.out.println("No hay clientes registrados");
                    }
                    break;
                case 6: // añadir cliente
                    System.out.print("Introduzca el nombre del cliente: ");
                    String nombre = sc.nextLine();
                    System.out.print("Introduzca el DNI del cliente: ");
                    String dniNuevo = sc.nextLine();
                    System.out.print("Tipo de cliente (1-Jubilado, 2-Socio): ");
                    int tipo = sc.nextInt();
                    Cliente nuevoCliente = null;
                    try {
                        if (tipo == 1) {
                            nuevoCliente = new Jubilado(nombre, dniNuevo, 65);
                            balneario.agregarCliente(nuevoCliente);
                            System.out.println("Cliente añadido correctamente.");
                            break;
                        } else {
                             nuevoCliente = new Socio(nombre, dniNuevo, "SOC"+(balneario.getClientes().size()+1));
                            balneario.agregarCliente(nuevoCliente);
                            System.out.println("Cliente añadido correctamente.");
                            break;

                        }
                    } catch (DniInvalidoException e) {
                        System.out.println("Error al añadir cliente: " + e.getMessage());
                    }
                    break;
                case 7: // agregar servicio a cliente
                    System.out.print("Introduzca el DNI del cliente: ");
                    String dniCliente = sc.nextLine();
                    try {
                        Cliente clienteExistente = balneario.buscarClientePorDni(dniCliente);
                        System.out.println("Servicios disponibles:");
                        for (int i = 0; i < balneario.getServicios().size(); i++) {
                            Servicio s = balneario.getServicios().get(i);
                            System.out.println((i + 1) + ". " + s.getNombre() + " (" + s.getPrecio() + "€)");
                        }
                        System.out.print("Seleccione el número del servicio a agregar: ");
                        int numServicio = sc.nextInt();
                        if (numServicio < 1 || numServicio > balneario.getServicios().size()) {
                            System.out.println("Número de servicio inválido.");
                        } else {
                            Servicio servicioSeleccionado = balneario.getServicios().get(numServicio - 1);
                            clienteExistente.agregarServicio(servicioSeleccionado);
                            System.out.println("Servicio agregado correctamente a " + clienteExistente.getNombre());
                        }
                    } catch (ClienteNoEncontradoException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 0);

    }
}
