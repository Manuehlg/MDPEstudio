package MDP.Practicas.Sesion07.Sesion07.sesion04;

import java.time.LocalDate;
import java.util.*;

import MDP.Practicas.sesion4.es.unex.cume.mdp.sesion04.boleto.*;
import MDP.Practicas.sesion4.es.unex.cume.mdp.sesion04.onlae.Onlae;
import MDP.Practicas.sesion4.es.unex.cume.mdp.sesion04.onlae.Sorteo;
import MDP.Practicas.sesion4.es.unex.cume.mdp.sesion04.onlae.Usuario;

public class MainSorteo {
    private Scanner scanner = new Scanner(System.in);
    private Onlae onlae = new Onlae();
        
    public static void main(String[] args) {
        MainSorteo app = new MainSorteo();
        app.ejecutar();
    }
    public void ejecutar() {
        int opcion = -1;

        do {
            mostrarMenu();
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 0:
                        crearDatos();
                        break;
                    case 1:
                        añadirUsuario();
                        break;
                    case 2:
                        crearSorteo();
                        break;
                    case 3:
                        añadirBoletoASorteo();
                        break;
                    case 4:
                        jugarSorteo();
                        break;
                    case 5:
                        mostrarBoletosDeSorteo();
                        break;
                    case 6:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe introducir un número.");
                scanner.nextLine(); // Limpiar buffer
            }
        } while (opcion != 6);

        scanner.close();
    }

    private  void mostrarMenu() {
        System.out.println("\n=== MENÚ PRINCIPAL ===");
        System.out.println("0. Crear datos de ejemplo");
        System.out.println("1. Añadir usuario");
        System.out.println("2. Crear sorteo");
        System.out.println("3. Añadir boleto a sorteo");
        System.out.println("4. Jugar sorteo");
        System.out.println("5. Mostrar boletos de un sorteo");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private  void crearDatos() {
        onlae.crearDatosEjemplo();
        System.out.println("Datos de ejemplo creados correctamente.");
        System.out.println("- 5 usuarios creados");
        System.out.println("- 5 sorteos creados");
        System.out.println("- Boletos asignados a cada sorteo");
    }

    private  void añadirUsuario() {
        System.out.println("\n--- Añadir Usuario ---");
        System.out.print("DNI: ");
        String dni = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Tipo de usuario:");
        System.out.println("0. Usuario VIP (requiere tarjeta de crédito)");
        System.out.println("1. Usuario Registrado (requiere saldo)");
        System.out.print("Seleccione tipo: ");
        
        try {
            int tipo = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            String derivada;
            if (tipo == 0) {
                System.out.print("Tarjeta de crédito: ");
                derivada = scanner.nextLine();
            } else if (tipo == 1) {
                System.out.print("Saldo inicial: ");
                derivada = scanner.nextLine();
            } else {
                System.out.println("Tipo de usuario no válido.");
                return;
            }
            
            boolean resultado = onlae.registrarUsuario(dni, telefono, nombre, derivada, tipo);
            if (resultado) {
                System.out.println("Usuario añadido correctamente.");
            } else {
                System.out.println("Error: No se pudo añadir el usuario. El DNI ya existe.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Tipo de dato no válido.");
            scanner.nextLine(); // Limpiar buffer
        }
    }

    private  void crearSorteo() {
        System.out.println("\n--- Crear Sorteo ---");
        System.out.print("ID del sorteo: ");
        try {
            int id = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            System.out.print("Fecha (formato YYYY-MM-DD): ");
            String fechaStr = scanner.nextLine();
            LocalDate fecha = LocalDate.parse(fechaStr);
            
            System.out.println("Tipo de sorteo:");
            System.out.println("0. Primitiva");
            System.out.println("1. Gordo");
            System.out.println("2. Euromillón");
            System.out.print("Seleccione tipo: ");
            int tipo = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            boolean resultado = onlae.crearSorteo(id, fecha, tipo);
            if (resultado) {
                System.out.println("Sorteo creado correctamente.");
            } else {
                System.out.println("Error: Ya existe un sorteo en esa fecha.");
            }
        } catch (Exception e) {
            System.out.println("Error: Formato de datos incorrecto.");
            scanner.nextLine(); // Limpiar buffer
        }
    }

    private  void añadirBoletoASorteo() {
        System.out.println("\n--- Añadir Boleto a Sorteo ---");
        System.out.print("DNI del usuario: ");
        String dni = scanner.nextLine();

        Usuario usuario = onlae.buscarUsuario(dni);
        if (usuario == null) {
            System.out.println("Error: No existe un usuario con ese DNI.");
            return;
        }
        
        System.out.print("Fecha del sorteo (formato YYYY-MM-DD): ");
        String fechaStr = scanner.nextLine();
        
        try {
            LocalDate fecha = LocalDate.parse(fechaStr);
            
            System.out.println("Tipo de boleto:");
            System.out.println("0. Primitiva (1.5€)");
            System.out.println("1. Gordo (2.5€)");
            System.out.println("2. Euromillón (3.5€)");
            System.out.print("Seleccione tipo: ");
            int tipo = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            boolean resultado = onlae.jugarSorteo(dni, fecha, tipo);
            if (resultado) {
                System.out.println("Boleto añadido correctamente al sorteo.");
            } else {
                System.out.println("Error: No se pudo añadir el boleto. Verifique que el usuario y el sorteo existan y que el tipo coincida.");
            }
        } catch (Exception e) {
            System.out.println("Error: Formato de datos incorrecto.");
            scanner.nextLine(); // Limpiar buffer
        }
    }

    private  void jugarSorteo() {
        System.out.println("\n--- Jugar Sorteo ---");
        System.out.print("Fecha del sorteo (formato YYYY-MM-DD): ");
        String fechaStr = scanner.nextLine();
        
        try {
            LocalDate fecha = LocalDate.parse(fechaStr);
            Sorteo sorteo = onlae.buscarSorteo(fecha);
            
            if (sorteo == null) {
                System.out.println("Error: No existe un sorteo en esa fecha.");
                return;
            }
            
            if (sorteo.isSorteado()) {
                System.out.println("Error: Este sorteo ya ha sido jugado.");
                return;
            }
            
            boolean resultado = onlae.sortearSorteo(fecha);
            if (resultado) {
                System.out.println("\n¡Sorteo realizado con éxito!");
                System.out.println("Combinación ganadora: " + sorteo.getCombinacionGanadora());
                System.out.println("Recaudación total: " + sorteo.getRecaudacion() + "€");
                System.out.println("\nResultados de los boletos:");
                for (Boleto b : sorteo.getBoletos()) {
                    System.out.println("  " + b + " - Aciertos: " + b.getNumAciertos());
                }
            } else {
                System.out.println("Error: No se pudo realizar el sorteo. ¿Hay boletos?");
            }
        } catch (Exception e) {
            System.out.println("Error: Formato de fecha incorrecto.");
        }
    }

    private  void mostrarBoletosDeSorteo() {
        System.out.println("\n--- Mostrar Boletos de Sorteo ---");
        System.out.print("Fecha del sorteo (formato YYYY-MM-DD): ");
        String fechaStr = scanner.nextLine();
        
        try {
            LocalDate fecha = LocalDate.parse(fechaStr);
            Sorteo sorteo = onlae.buscarSorteo(fecha);
            
            if (sorteo == null) {
                System.out.println("Error: No existe un sorteo en esa fecha.");
                return;
            }
            
            System.out.println("\nInformación del sorteo:");
            System.out.println("ID: " + sorteo.getId());
            System.out.println("Fecha: " + sorteo.getFecha());
            String tipoStr = sorteo.getTipo() == 0 ? "Primitiva" : (sorteo.getTipo() == 1 ? "Gordo" : "Euromillón");
            System.out.println("Tipo: " + tipoStr);
            System.out.println("Sorteado: " + (sorteo.isSorteado() ? "Sí" : "No"));
            System.out.println("Recaudación: " + sorteo.getRecaudacion() + "€");
            
            if (sorteo.isSorteado() && sorteo.getCombinacionGanadora() != null) {
                System.out.println("Combinación ganadora: " + sorteo.getCombinacionGanadora());
            }
            
            System.out.println("\nBoletos (" + sorteo.getBoletos().size() + "):");
            if (sorteo.getBoletos().isEmpty()) {
                System.out.println("  No hay boletos en este sorteo.");
            } else {
                for (Boleto b : sorteo.getBoletos()) {
                    System.out.print("  " + b);
                    if (sorteo.isSorteado()) {
                        System.out.print(" - Aciertos: " + b.getNumAciertos());
                    }
                    System.out.println();
                }
            }
        } catch (Exception e) {
            System.out.println("Error: Formato de fecha incorrecto.");
        }
    }
}
