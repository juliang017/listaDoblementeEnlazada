package model;

/**
 * La clase {@code Titulos} representa un título ganado por un campeón en un año específico,
 * junto con el goleador destacado y la cantidad de goles marcados en ese título.
 * 
 * Esta clase proporciona métodos para acceder y modificar el año, el goleador y los goles asociados con un título.
 */

public class Titulos {

	/** El año en que se ganó el título. */
    public int anio;

    /** El nombre del goleador que destacó en el título. */
    public String goleador;

    /** La cantidad de goles marcados por el goleador en ese título. */
    public int goles;

    /**
     * Constructor que inicializa un objeto {@code Titulos} con los valores proporcionados.
     * 
     * @param anio El año en que se ganó el título.
     * @param goleador El nombre del goleador destacado.
     * @param goles La cantidad de goles marcados por el goleador en ese título.
     */
    
	public Titulos(int anio, String goleador, int goles) {
		this.anio = anio;
		this.goleador = goleador;
		this.goles = goles;
	}

	/**
     * Obtiene el año en que se ganó el título.
     * 
     * @return El año del título.
     */
    public int getAnio() {
        return anio;
    }

    /**
     * Establece el año en que se ganó el título.
     * 
     * @param anio El año del título.
     */
    public void setAnio(int anio) {
        this.anio = anio;
    }

    /**
     * Obtiene el nombre del goleador destacado en el título.
     * 
     * @return El nombre del goleador.
     */
    public String getGoleador() {
        return goleador;
    }

    /**
     * Establece el nombre del goleador destacado en el título.
     * 
     * @param goleador El nombre del goleador.
     */
    public void setGoleador(String goleador) {
        this.goleador = goleador;
    }

    /**
     * Obtiene la cantidad de goles marcados por el goleador en el título.
     * 
     * @return La cantidad de goles del goleador.
     */
    public int getGoles() {
        return goles;
    }

    /**
     * Establece la cantidad de goles marcados por el goleador en el título.
     * 
     * @param goles La cantidad de goles del goleador.
     */
    public void setGoles(int goles) {
        this.goles = goles;
    }
	
}
