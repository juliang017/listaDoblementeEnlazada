package sort;

import model.ListaCircularDoble;
import model.Nodo;

/**
 * Clase utilitaria que proporciona métodos para ordenar una lista circular doblemente enlazada
 * de equipos de fútbol según la cantidad de títulos que han ganado, en orden descendente.
 * Utiliza el algoritmo Merge Sort para realizar la ordenación.
 */

public class ordenamientoPorTitulos {

	/**
     * Ordena una lista circular doblemente enlazada por cantidad de títulos en orden descendente.
     * 
     * @param lista La lista circular doblemente enlazada a ordenar
     * @throws IllegalArgumentException Si la lista pasada como parámetro es null
     */
	
	 public static void ordenarPorCantidadTitulos(ListaCircularDoble lista) {
	        Nodo cabeza = lista.getCabeza();

	        if (cabeza == null || cabeza.siguiente == cabeza) return;

	        cabeza.anterior.siguiente = null;
	        cabeza.anterior = null;

	        Nodo nuevaCabeza = mergeSort(cabeza);

	        Nodo ultimo = nuevaCabeza;
	        while (ultimo.siguiente != null)
	            ultimo = ultimo.siguiente;

	        nuevaCabeza.anterior = ultimo;
	        ultimo.siguiente = nuevaCabeza;

	        lista.setCabeza(nuevaCabeza);
	    }

	 /**
	     * Implementación recursiva del algoritmo Merge Sort para nodos de una lista enlazada.
	     * 
	     * @param cabeza El nodo cabeza de la sublista a ordenar
	     * @return El nodo cabeza de la sublista ordenada
	     * @throws IllegalArgumentException Si el nodo cabeza es null
	     */
	 
	    private static Nodo mergeSort(Nodo cabeza) {
	        if (cabeza == null || cabeza.siguiente == null)
	            return cabeza;

	        Nodo medio = dividir(cabeza);
	        Nodo izquierda = mergeSort(cabeza);
	        Nodo derecha = mergeSort(medio);

	        return merge(izquierda, derecha);
	    }

	    /**
	     * Divide una lista enlazada en dos sublistas de aproximadamente igual tamaño.
	     * Utiliza el enfoque de puntero rápido y lento para encontrar el punto medio.
	     * 
	     * @param cabeza El nodo cabeza de la lista a dividir
	     * @return El nodo cabeza de la segunda mitad de la lista
	     */
	    
	    private static Nodo dividir(Nodo cabeza) {
	        Nodo lento = cabeza;
	        Nodo rapido = cabeza;

	        while (rapido.siguiente != null && rapido.siguiente.siguiente != null) {
	            rapido = rapido.siguiente.siguiente;
	            lento = lento.siguiente;
	        }

	        Nodo medio = lento.siguiente;
	        lento.siguiente = null;
	        if (medio != null) medio.anterior = null;

	        return medio;
	    }

	    /**
	     * Combina (merge) dos listas ordenadas en una sola lista ordenada.
	     * La comparación se realiza basándose en la cantidad de títulos de los equipos.
	     * 
	     * @param a Nodo cabeza de la primera lista ordenada
	     * @param b Nodo cabeza de la segunda lista ordenada
	     * @return Nodo cabeza de la lista combinada y ordenada
	     */
	    
	    private static Nodo merge(Nodo a, Nodo b) {
	        if (a == null) return b;
	        if (b == null) return a;

	        Nodo resultado;

	        if (a.dato.cantidadTitulos >= b.dato.cantidadTitulos) {
	            resultado = a;
	            resultado.siguiente = merge(a.siguiente, b);
	            if (resultado.siguiente != null) resultado.siguiente.anterior = resultado;
	        } else {
	            resultado = b;
	            resultado.siguiente = merge(a, b.siguiente);
	            if (resultado.siguiente != null) resultado.siguiente.anterior = resultado;
	        }

	        return resultado;
	    }
	
}
