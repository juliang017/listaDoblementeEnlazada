package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Campeones;
import model.Eliminacion;
import model.ListaCircularDoble;
import model.PilaEliminacion;
import model.Titulos;

/**
 * Clase responsable de leer y procesar archivos JSON que contienen información
 * sobre equipos campeones y sus eliminaciones.
 * Proporciona métodos para cargar estos datos en estructuras de datos específicas.
 */

public class LectorJson {

	/**
    * Lee un archivo JSON con información de equipos campeones y carga los datos
    * en una lista circular doble enlazada.
    * 
    * @param lista La lista circular doble donde se almacenarán los equipos campeones
    * @throws RuntimeException Si ocurre un error al leer el archivo JSON
    */
	
	public void leerJsonCampeones(ListaCircularDoble lista) {

		InputStream is = getClass().getClassLoader().getResourceAsStream("data/campeones.json");
		String jsonTexto = "";
		try {
			jsonTexto = new String(is.readAllBytes(), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}

		cargarDatosJSON(jsonTexto, lista);

	}

	/**
     * Procesa el texto JSON y carga los datos de equipos campeones en la lista proporcionada.
     * 
     * @param jsonTexto El texto JSON que contiene la información de los equipos
     * @param lista La lista circular doble donde se almacenarán los datos
     * @throws JSONException Si el formato del JSON es inválido o faltan campos requeridos
     */
	
	public void cargarDatosJSON(String jsonTexto, ListaCircularDoble lista) {

		JSONArray campeones = new JSONArray(jsonTexto);

		for (int i = 0; i < campeones.length(); i++) {
			JSONObject obj = campeones.getJSONObject(i);
			String nombre = obj.getString("nombre");
			String pais = obj.getString("pais");

			JSONArray titulosJSON = obj.getJSONArray("titulos");
			List<Titulos> titulos = new ArrayList<>();

			for (int j = 0; j < titulosJSON.length(); j++) {
				JSONObject t = titulosJSON.getJSONObject(j);
				int año = t.getInt("año");
				String goleador = t.getString("nombreGoleador");
				int goles = t.getInt("cantidadGoles");
				titulos.add(new Titulos(año, goleador, goles));
			}

			Campeones c = new Campeones(nombre, pais, titulos);
			lista.insertar(c);
		}

	}
	
	/**
     * Lee un archivo JSON con información sobre eliminaciones de equipos y carga los datos
     * en una pila de eliminaciones.
     * 
     * @param pila La pila donde se almacenarán las eliminaciones
     * @throws RuntimeException Si ocurre un error al leer el archivo JSON
     */
	
	public void leerJsonEliminacion(PilaEliminacion pila) {
        StringBuilder contenido = new StringBuilder();

        try (
            InputStream is = LectorJson.class.getClassLoader().getResourceAsStream("data/eliminaciones.json");
            BufferedReader br = new BufferedReader(new InputStreamReader(is))
        ) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea);
            }

            JSONArray array = new JSONArray(contenido.toString());
            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);
                String descripcion = obj.optString("descripcion");
                String imagen = obj.optString("imagen");
                pila.push(new Eliminacion(descripcion, imagen));
            }
        } catch (Exception e) {
            e.printStackTrace();
    }
        
    }
	
}
