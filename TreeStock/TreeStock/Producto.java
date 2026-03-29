/**
 * Clase Producto — Nodo del Árbol Binario de Búsqueda
 *
 * Cada Producto es un nodo con DOS punteros:
 *   - izquierdo: apunta al nodo con ID menor
 *   - derecho:   apunta al nodo con ID mayor
 *
 * Estructura visual de un nodo:
 *
 *        [ id | nombre ]
 *         /            \
 *   [ID menor]     [ID mayor]
 *
 * Autor: Mileydy Estefania Espinosa George
 * Institución: IU Digital de Antioquia
 * Curso: Estructura de Datos
 */
public class Producto {

    // ── DATOS DEL PRODUCTO ──────────────────────────────
    int id;         // Identificador único (clave de ordenamiento)
    String nombre;  // Nombre del producto en inventario

    // ── PUNTEROS DEL ÁRBOL ──────────────────────────────
    // Apunta al hijo con ID MENOR que este nodo
    Producto izquierdo;

    // Apunta al hijo con ID MAYOR que este nodo
    Producto derecho;

    /**
     * Constructor: crea un nodo hoja (sin hijos).
     * Los punteros inician en null hasta que se inserten hijos.
     *
     * @param id     Identificador numérico del producto
     * @param nombre Nombre descriptivo del producto
     */
    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.izquierdo = null;
        this.derecho = null;
    }

    /** Representación en texto del producto */
    @Override
    public String toString() {
        return "ID: " + id + " | Producto: " + nombre;
    }
}
