/**
 * Clase ArbolInventario — Árbol Binario de Búsqueda (ABB)
 *
 * Implementa la lógica completa del árbol desde cero.
 * NO usa librerías de Java como TreeMap o TreeSet.
 *
 * REGLA FUNDAMENTAL DEL ABB:
 *   - ID MENOR  → va a la IZQUIERDA
 *   - ID MAYOR  → va a la DERECHA
 *
 * Esto garantiza que el recorrido inorden siempre
 * entrega los productos ordenados de menor a mayor ID.
 *
 * Ejemplo con IDs insertados en orden 5, 3, 7, 1, 4:
 *
 *           [5]          ← raíz
 *          /   \
 *        [3]   [7]
 *       /   \
 *     [1]   [4]
 *
 * Recorrido inorden: 1 → 3 → 4 → 5 → 7  ✓ (ordenado)
 *
 * Autor: Mileydy Estefania Espinosa George
 * Institución: IU Digital de Antioquia
 * Curso: Estructura de Datos
 */
public class ArbolInventario {

    // Raíz del árbol — punto de entrada para todas las operaciones
    // Si raiz == null, el árbol está vacío
    private Producto raiz;

    /** Constructor: árbol vacío */
    public ArbolInventario() {
        this.raiz = null;
    }

    // ══════════════════════════════════════════════════════
    // INSERTAR — público
    // ══════════════════════════════════════════════════════
    /**
     * Inserta un nuevo producto en el árbol.
     * Llama al método recursivo privado desde la raíz.
     *
     * @param id     ID del nuevo producto
     * @param nombre Nombre del nuevo producto
     */
    public void insertar(int id, String nombre) {
        Producto nuevo = new Producto(id, nombre);
        raiz = insertarRecursivo(raiz, nuevo);
    }

    // ══════════════════════════════════════════════════════
    // INSERTAR RECURSIVO — privado
    // ══════════════════════════════════════════════════════
    /**
     * Ubica la posición correcta del nuevo nodo de forma RECURSIVA.
     *
     * Lógica de punteros:
     *   1. Si nodoActual == null → posición vacía encontrada, insertar aquí
     *   2. Si ID nuevo < ID actual → buscar en subárbol IZQUIERDO
     *   3. Si ID nuevo > ID actual → buscar en subárbol DERECHO
     *   4. Si ID igual → no se inserta (IDs deben ser únicos)
     *
     * Ejemplo insertando ID=4 en árbol [5, 3, 7]:
     *   insertarRec([5], 4) → 4 < 5 → ir izquierda
     *   insertarRec([3], 4) → 4 > 3 → ir derecha
     *   insertarRec(null,  4) → insertar aquí → retorna nodo[4]
     *   [3].derecho = [4] ✓
     *
     * @param nodoActual Nodo evaluado en esta llamada recursiva
     * @param nuevo      Producto a insertar
     * @return Nodo actualizado con el producto insertado
     */
    private Producto insertarRecursivo(Producto nodoActual, Producto nuevo) {

        // CASO BASE: posición vacía → insertar aquí
        if (nodoActual == null) {
            return nuevo;
        }

        if (nuevo.id < nodoActual.id) {
            // ID menor → bajar por la IZQUIERDA
            nodoActual.izquierdo = insertarRecursivo(nodoActual.izquierdo, nuevo);

        } else if (nuevo.id > nodoActual.id) {
            // ID mayor → bajar por la DERECHA
            nodoActual.derecho = insertarRecursivo(nodoActual.derecho, nuevo);

        } else {
            // ID duplicado → informar y no insertar
            System.out.println("\n⚠ Ya existe un producto con ID " + nuevo.id + ". No se insertó.");
        }

        return nodoActual;
    }

    // ══════════════════════════════════════════════════════
    // RECORRIDO INORDEN — público
    // ══════════════════════════════════════════════════════
    /**
     * Lista todos los productos en orden ascendente de ID.
     * El recorrido inorden visita: izquierda → raíz → derecha.
     * Por la propiedad del ABB, esto siempre produce orden ascendente.
     */
    public void mostrarInorden() {
        if (raiz == null) {
            System.out.println("\n   (el inventario está vacío)");
            return;
        }
        System.out.println("\n--- Inventario ordenado por ID ---");
        inordenRecursivo(raiz);
        System.out.println("----------------------------------");
    }

    /**
     * Recorre el árbol en orden: izquierda → nodo → derecha.
     *
     * @param nodo Nodo actual en el recorrido
     */
    private void inordenRecursivo(Producto nodo) {
        if (nodo == null) return;            // Caso base: nodo vacío
        inordenRecursivo(nodo.izquierdo);    // 1. Visitar subárbol izquierdo
        System.out.println("   " + nodo);   // 2. Imprimir nodo actual
        inordenRecursivo(nodo.derecho);      // 3. Visitar subárbol derecho
    }

    // ══════════════════════════════════════════════════════
    // BUSCAR — público
    // ══════════════════════════════════════════════════════
    /**
     * Busca un producto por su ID en el árbol.
     *
     * @param id ID a buscar
     */
    public void buscar(int id) {
        Producto resultado = buscarRecursivo(raiz, id);
        if (resultado != null) {
            System.out.println("\n✔ Producto encontrado: " + resultado);
        } else {
            System.out.println("\n✘ No existe ningún producto con ID " + id);
        }
    }

    /**
     * Búsqueda recursiva por ID.
     * Aprovecha la propiedad del ABB para descartar mitades del árbol.
     *
     * Lógica:
     *   - Si ID buscado < ID actual → buscar en la IZQUIERDA
     *   - Si ID buscado > ID actual → buscar en la DERECHA
     *   - Si ID buscado == ID actual → ¡encontrado!
     *
     * @param nodo Nodo actual
     * @param id   ID buscado
     * @return Producto si se encuentra, null si no existe
     */
    private Producto buscarRecursivo(Producto nodo, int id) {
        // Caso base: nodo vacío → no existe
        if (nodo == null) return null;

        // Caso base: encontrado
        if (id == nodo.id) return nodo;

        if (id < nodo.id) {
            // Buscar en subárbol izquierdo
            return buscarRecursivo(nodo.izquierdo, id);
        } else {
            // Buscar en subárbol derecho
            return buscarRecursivo(nodo.derecho, id);
        }
    }
}
