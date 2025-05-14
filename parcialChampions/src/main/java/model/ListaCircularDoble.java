package model;

/**
 * La clase {@code ListaCircularDoble} representa una lista circular doblemente enlazada,
 * que permite insertar elementos, buscarlos por nombre y mostrarlos en el orden hacia adelante.
 * Cada nodo de la lista contiene un objeto {@code Campeones}.
 */

 public class ListaCircularDoble {
	 
	 /** La cabeza de la lista circular, es el primer nodo. */
	private Nodo cabeza;
	
	/** La cola de la lista circular, es el último nodo. */
    private Nodo cola;
	
    /**
     * Obtiene la cabeza de la lista circular.
     * 
     * @return El nodo que representa la cabeza de la lista circular.
     */
    
    public Nodo getCabeza() {
        return cabeza;
    }

    /**
     * Establece la cabeza de la lista circular.
     * 
     * @param nuevaCabeza El nuevo nodo que será la cabeza de la lista.
     */
    
    public void setCabeza(Nodo nuevaCabeza) {
        this.cabeza = nuevaCabeza;
    }
    
    /**
     * Inserta un nuevo nodo con un objeto {@code Campeones} en la lista circular doble.
     * Si la lista está vacía, el nuevo nodo se convierte tanto en la cabeza como en la cola.
     * Si la lista ya contiene nodos, el nuevo nodo se inserta al final y se actualizan los enlaces.
     * 
     * @param nuevo El objeto {@code Campeones} que se insertará en la lista.
     */
    
    public void insertar(Campeones nuevo) {
        Nodo nodo = new Nodo(nuevo);
        if (cabeza == null) {
            cabeza = nodo;
            cabeza.siguiente = cabeza.anterior = cabeza;
        } else {
            Nodo ultimo = cabeza.anterior;
            ultimo.siguiente = nodo;
            nodo.anterior = ultimo;
            nodo.siguiente = cabeza;
            cabeza.anterior = nodo;
        }
    }
    
    /**
     * Busca un nodo por nombre de equipo (insensible a mayúsculas/minúsculas)
     * @param nombreEquipo Nombre del equipo a buscar
     * @return El nodo que contiene el equipo, o null si no se encuentra
     */
    public Nodo buscarPorNombre(String nombreEquipo) {
        if (nombreEquipo == null || nombreEquipo.trim().isEmpty()) {
            return null;
        }
        
        if (cabeza == null) {
            return null;
        }
        
        String nombreBuscado = nombreEquipo.trim().toLowerCase();
        Nodo actual = cabeza;
        
        do {
            if (actual != null && actual.dato != null && 
                actual.dato.nombre != null && 
                actual.dato.nombre.toLowerCase().equals(nombreBuscado)) {
                return actual;
            }
            actual = actual.siguiente;
            
            if (actual == null) {
                break;
            }
        } while (actual != cabeza);
        
        return null;
    }
    
    /**
     * Muestra los nodos de la lista circular de manera secuencial, comenzando desde la cabeza.
     * Si la lista está vacía, muestra un mensaje indicando que está vacía.
     */
    
    public void mostrarAdelante() {
        if (cabeza == null) {
            System.out.println("Lista vacía");
            return;
        }

        Nodo actual = cabeza;

        do {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        } while (actual != cabeza);

        System.out.println();
    }
    
    
	
}
