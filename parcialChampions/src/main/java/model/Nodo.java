package model;

/**
 * Clase que representa un nodo para una lista doblemente enlazada circular.
 * Cada nodo contiene un objeto Campeones y referencias al nodo siguiente y anterior en la lista.
 */

public class Nodo {

	/** El dato almacenado en el nodo, de tipo Campeones */
	public Campeones dato;
	
	/** Referencia al nodo siguiente en la lista */
	public Nodo siguiente;
	
	/** Referencia al nodo anterior en la lista */
	public Nodo anterior;
	
	/**
     * Constructor por defecto que crea un nodo vacío.
     * Inicializa todos los campos como null.
     */
	
	public Nodo() {}
	
	/**
    * Constructor que crea un nodo con el dato especificado.
    * Inicializa las referencias siguiente y anterior como null.
    * 
    * @param dato El objeto Campeones que se almacenará en el nodo
    */
	
	public Nodo(Campeones dato) {
        this.dato = dato;
        siguiente = anterior = null;
    }

	/**
     * Obtiene el dato almacenado en el nodo.
     * 
     * @return El objeto Campeones almacenado en el nodo
     */
	
	public Campeones getDato() {
		return dato;
	}

	/**
     * Establece el dato que contendrá el nodo.
     * 
     * @param dato El objeto Campeones a almacenar en el nodo
     */
	
	public void setDato(Campeones dato) {
		this.dato = dato;
	}

	/**
     * Obtiene la referencia al nodo siguiente en la lista.
     * 
     * @return El nodo siguiente en la lista, o null si es el último
     */
	
	public Nodo getSiguiente() {
		return siguiente;
	}

	/**
     * Establece la referencia al nodo siguiente en la lista.
     * 
     * @param siguiente El nodo que será el siguiente de este nodo
     */
	
	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}

	/**
     * Obtiene la referencia al nodo anterior en la lista.
     * 
     * @return El nodo anterior en la lista, o null si es el primero
     */
	
	public Nodo getAnterior() {
		return anterior;
	}

	/**
     * Establece la referencia al nodo anterior en la lista.
     * 
     * @param anterior El nodo que será el anterior de este nodo
     */
	
	public void setAnterior(Nodo anterior) {
		this.anterior = anterior;
	}
	
}
