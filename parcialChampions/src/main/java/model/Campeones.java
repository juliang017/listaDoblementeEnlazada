package model;

import java.util.List;

/**
 * La clase {@code Campeones} representa a un campeón con su nombre, país y una lista de títulos ganados.
 * Esta clase también proporciona métodos para obtener y establecer el nombre, país y los títulos del campeón,
 * así como la cantidad total de títulos ganados.
 */

public class Campeones {

	/** El nombre del campeón. */
	public String nombre;
	
	/** El país de origen del campeón. */
	public String pais;
	
	 /** La lista de títulos ganados por el campeón. */
	public List<Titulos> titulos;
	
	 /** La cantidad total de títulos ganados por el campeón. */
	public int cantidadTitulos;
	
	
	/**
     * Constructor para crear una instancia de {@code Campeones} con el nombre, país y la lista de títulos.
     * 
     * @param nombre El nombre del campeón.
     * @param pais El país de origen del campeón.
     * @param titulos La lista de títulos ganados por el campeón.
     */
	public Campeones(String nombre, String pais, List<Titulos> titulos) {
		this.nombre = nombre;
		this.pais = pais;
		this.titulos = titulos;
		cantidadTitulos = titulos.size();
	}

	/**
     * Obtiene el nombre del campeón.
     * 
     * @return El nombre del campeón.
     */
	
	public String getNombre() {
		return nombre;
	}

	/**
     * Establece el nombre del campeón.
     * 
     * @param nombre El nombre del campeón.
     */
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
     * Obtiene el país del campeón.
     * 
     * @return El país del campeón.
     */
	
	public String getPais() {
		return pais;
	}

	/**
     * Establece el país del campeón.
     * 
     * @param pais El país del campeón.
     */
	
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
     * Obtiene la lista de títulos ganados por el campeón.
     * 
     * @return La lista de títulos del campeón.
     */
	
	public List<Titulos> getTitulos() {
		return titulos;
	}

	/**
     * Establece la lista de títulos ganados por el campeón.
     * 
     * @param titulos La lista de títulos del campeón.
     */
	
	public void setTitulos(List<Titulos> titulos) {
		this.titulos = titulos;
	}

	/**
     * Obtiene la cantidad total de títulos ganados por el campeón.
     * 
     * @return La cantidad de títulos ganados por el campeón.
     */
	
	public int getCantidadTitulos() {
		return cantidadTitulos;
	}

	/**
     * Establece la cantidad de títulos ganados por el campeón.
     * 
     * @param cantidadTitulos La cantidad de títulos ganados.
     */
	
	public void setCantidadTitulos(int cantidadTitulos) {
		this.cantidadTitulos = cantidadTitulos;
	}
	
}
