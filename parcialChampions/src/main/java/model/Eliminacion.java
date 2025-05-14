package model;

/**
 * Clase que representa una eliminación de un equipo en una competición.
 * Contiene información sobre la descripción de la eliminación y la ruta de la imagen asociada.
 */

public class Eliminacion {

	/** Descripcion de la eliminacion */
	
	private String descripcion;
	
	/** ruta de la imagen */
	private String imagen;
	
	/**
     * Constructor que crea una nueva instancia de Eliminacion.
     * 
     * @param descripcion El texto descriptivo de la eliminación (ej: "Equipo X eliminado en semifinales")
     * @param imagen La ruta o nombre del archivo de imagen asociado a la eliminación
     */

	
	public Eliminacion(String descripcion, String imagen) {
		this.descripcion = descripcion;
		this.imagen = imagen;
	}

	/**
     * Obtiene la descripción de la eliminación.
     * 
     * @return String con el texto descriptivo de la eliminación
     */
	
	public String getDescripcion() {
		return descripcion;
	}

	/**
     * Obtiene la ruta o nombre del archivo de imagen asociado a la eliminación.
     * 
     * @return String con la ruta/nombre de la imagen
     */
	
	public String getImagen() {
		return imagen;
	}
	
}
