/**
 * Clase Producto — Nodo del Árbol Binario de Búsqueda
 *
 * Cada objeto Producto representa un nodo dentro del árbol.
 * Contiene los datos del producto y DOS punteros:
 *   - izquierdo: apunta al nodo con ID menor
 *   - derecho:   apunta al nodo con ID mayor
 *
 * Estructura visual de un nodo:
 *
 *        [ id | nombre ]
 *         /            \
 *   [menor ID]     [mayor ID]
 *
 * Autor: Mileydy Estefania Espinosa George
 * Curso: Estructura de Datos — IU Digital de Antioquia
 */
public class Producto {

    // ── DATOS DEL PRODUCTO ──────────────────────────────
    int id;        // Identificador único (clave de ordenamiento)
    String nombre; // Nombre del producto en inventario

    // ── PUNTEROS DEL ÁRBOL ──────────────────────────────
    // 'izquierdo' apunta al hijo con ID MENOR que este nodo
    Producto izquierdo;

    // 'derecho' apunta al hijo con ID MAYOR que este nodo
    Producto derecho;

    /**
     * Constructor: crea un nodo hoja (sin hijos aún).
     * Los punteros izquierdo y derecho inician en null,
     * lo que indica que este nodo no tiene hijos todavía.
     *
     * @param id     Identificador numérico del producto
     * @param nombre Nombre descriptivo del producto
     */
    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.izquierdo = null; // Sin hijo izquierdo al crear
        this.derecho = null;   // Sin hijo derecho al crear
    }

    /**
     * Representación en texto del producto.
     * Usado al listar el inventario.
     */
    @Override
    public String toString() {
        return "ID: " + id + " | Producto: " + nombre;
    }
}
