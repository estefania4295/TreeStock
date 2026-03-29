import java.util.Scanner;

/**
 * Clase Main — Tree-Stock
 * Sistema de Inventario con Árbol Binario de Búsqueda
 *
 * Menú interactivo en consola con switch-case.
 * Coordina todas las operaciones del árbol.
 *
 * Autor: Mileydy Estefania Espinosa George
 * Institución: IU Digital de Antioquia
 * Curso: Estructura de Datos
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArbolInventario arbol = new ArbolInventario();
        int opcion;

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║      TREE-STOCK  🌳                  ║");
        System.out.println("║  Sistema de Inventario               ║");
        System.out.println("║  Árbol Binario de Búsqueda en Java   ║");
        System.out.println("╚══════════════════════════════════════╝");

        do {
            System.out.println("\n========================================");
            System.out.println("  MENU PRINCIPAL");
            System.out.println("========================================");
            System.out.println("  1. Registrar Producto");
            System.out.println("  2. Mostrar Inventario (ordenado)");
            System.out.println("  3. Buscar Producto por ID");
            System.out.println("  0. Salir");
            System.out.println("========================================");
            System.out.print("  Selecciona una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {

                // ── OPCIÓN 1: REGISTRAR ──────────────────
                case 1:
                    System.out.println("\n--- Registrar nuevo producto ---");
                    System.out.print("  ID del producto (numero): ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("  Nombre del producto: ");
                    String nombre = scanner.nextLine();
                    arbol.insertar(id, nombre);
                    System.out.println("✔ Producto registrado correctamente.");
                    break;

                // ── OPCIÓN 2: MOSTRAR INVENTARIO ─────────
                case 2:
                    arbol.mostrarInorden();
                    break;

                // ── OPCIÓN 3: BUSCAR ─────────────────────
                case 3:
                    System.out.print("\n  Ingresa el ID a buscar: ");
                    int idBuscar = scanner.nextInt();
                    arbol.buscar(idBuscar);
                    break;

                // ── OPCIÓN 0: SALIR ──────────────────────
                case 0:
                    System.out.println("\n¡Hasta luego! Tree-Stock cerrado.");
                    break;

                default:
                    System.out.println("\n⚠ Opcion no valida. Intenta de nuevo.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}
