# 🌳 Tree-Stock — Sistema de Inventario con Árbol Binario de Búsqueda

**Curso:** Estructura de Datos — IU Digital de Antioquia
**Estudiante:** Mileydy Estefania Espinosa George
**Actividad:** EA2 — Implementación de Árbol Binario de Búsqueda en Java

---

##  Objetivo

Desarrollar una aplicación de consola en Java que gestione un inventario de productos usando un **Árbol Binario de Búsqueda (ABB)** implementado manualmente, sin usar librerías de Java como `TreeMap` o `TreeSet`.

---

##  ¿Qué es un Árbol Binario de Búsqueda?

Un **Árbol Binario de Búsqueda (ABB)** es una estructura de datos dinámica donde cada nodo tiene:
- Un **dato** (en este caso: ID y nombre del producto)
- Un puntero **izquierdo** → apunta al nodo con ID **menor**
- Un puntero **derecho** → apunta al nodo con ID **mayor**

```
Ejemplo con IDs: 5, 3, 7, 1, 4

          [5]          ← raíz
         /   \
       [3]   [7]
      /   \
    [1]   [4]
```

La propiedad clave del ABB es que el **recorrido inorden** (izquierda → nodo → derecha) siempre produce los elementos en orden **ascendente**: 1 → 3 → 4 → 5 → 7.

### Lógica de punteros en la inserción:

Cuando se inserta un nuevo producto con ID=4 en el árbol [5, 3, 7]:
1. Comparar con raíz [5]: 4 < 5 → ir a la **izquierda**
2. Comparar con [3]: 4 > 3 → ir a la **derecha**
3. Posición vacía encontrada → **insertar aquí**
4. `[3].derecho = [4]` ✓

---

##  Arquitectura del Proyecto

```
TreeStock/
├── Producto.java         → Nodo del árbol (id, nombre, izquierdo, derecho)
├── ArbolInventario.java  → Lógica del ABB (insertar, inorden, buscar)
├── Main.java             → Menú interactivo en consola (switch-case)
└── README.md             → Documentación del proyecto
```

### Clases y métodos:

| Clase | Método | Descripción |
|-------|--------|-------------|
| `Producto` | Constructor | Crea un nodo con id, nombre y punteros null |
| `ArbolInventario` | `insertar()` | Inserta un producto de forma recursiva |
| `ArbolInventario` | `mostrarInorden()` | Lista el inventario ordenado por ID |
| `ArbolInventario` | `buscar()` | Busca un producto por su ID |
| `Main` | `main()` | Menú interactivo con switch-case |

---

##  Instrucciones de Ejecución

### Requisitos
- JDK Eclipse Temurin 17 o superior
- VS Code con Extension Pack for Java

### Pasos
1. Clonar el repositorio:
   ```bash
   git clone https://github.com/estefania4295/TreeStock.git
   ```
2. Abrir la carpeta `TreeStock` en VS Code
3. Abrir el archivo `Main.java`
4. Dar clic en el botón ▶️ **Run** (arriba a la derecha)

### Compilar y ejecutar desde terminal:
```bash
javac Producto.java ArbolInventario.java Main.java
java Main
```

---

## 💻 Capturas de Pantalla

### Menú Principal
![Menu](capturas_menu.jpeg)

### Registro de Productos
![Registro](capturas_registro.jpeg)
![Registro2](capturas_registro1.jpeg)
![Registro3](capturas_registro2.jpeg)

### Mostrar Inventario Ordenado
![Inventario](capturas_inventario.jpeg)

### Búsqueda de Producto
![Busqueda](capturas_busqueda.jpeg)

##  Video de Sustentación

>[ https://youtu.be/OIN_gd_tGGQ ]

El video explica:
- Lógica de los punteros en la inserción recursiva
- Funcionamiento del recorrido inorden
- Demostración: Registrar → Mostrar inventario → Buscar producto

---
 Sistema implementado sin librerias de Java.
 Curso:Estructura de Datos 2026
 Actividad EA2 Completada.
 
##  Referencias

- Cormen, T. H., Leiserson, C. E., Rivest, R. L., & Stein, C. (2009). *Introduction to Algorithms* (3rd ed.). MIT Press.
- IU Digital de Antioquia. (2026). *Guía de actividad EA2 — Estructura de Datos*.
