package model;

/**
 * La clase {@code PilaEliminacion} implementa una pila (estructura de datos LIFO) 
 * con un tamaño máximo fijo. Esta pila está diseñada para almacenar objetos de tipo {@code Eliminacion}.
 * Proporciona métodos para insertar elementos (push) y obtener los elementos de la pila.
 */

public class PilaEliminacion {

	 /** El tamaño máximo de la pila. */
	private static final int MAX = 100;
	
	/** El arreglo que almacena los elementos de la pila. */
	private Eliminacion[] elementos;
	
	/** El índice del último elemento en la pila. */
	private int tope;
	
	/**
     * Constructor que inicializa la pila con un tamaño máximo definido.
     * El tope se establece en -1 para indicar que la pila está vacía.
     */
	
	public PilaEliminacion() {
		
		elementos = new Eliminacion[MAX];
		tope = -1;
	}

	/**
     * Inserta un nuevo elemento en la pila.
     * Si la pila no está llena, el elemento se agrega al tope.
     * 
     * @param item El objeto {@code Eliminacion} que se va a insertar en la pila.
     */
	
	public void push(Eliminacion item) {
        if (tope < MAX - 1) {
            elementos[++tope] = item;
        }
    }

	/**
     * Obtiene todos los elementos almacenados en la pila, desde el fondo hasta el tope.
     * 
     * @return Un arreglo de objetos {@code Eliminacion} que contiene todos los elementos de la pila.
     */
	
    public Eliminacion[] getElementos() {
    	Eliminacion[] resultado = new Eliminacion[tope + 1];
        for (int i = 0; i <= tope; i++) {
            resultado[i] = elementos[i];
        }
        return resultado;
    }
	
}
