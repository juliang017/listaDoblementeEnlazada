package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Campeones;
import model.ListaCircularDoble;
import model.Nodo;
import model.PilaEliminacion;
import model.Titulos;
import sort.ordenamientoPorTitulos;
import view.VentanaPrincipal;
import view.VentanasEmergentes;

/**
 * Controlador principal de la aplicación que gestiona la interacción entre la vista y los modelos.
 * Implementa ActionListener para manejar eventos de los componentes de la interfaz gráfica.
 */
public class Controller implements ActionListener {

	private VentanaPrincipal vp;
	private ListaCircularDoble lista;
	private PilaEliminacion pila;
	private VentanasEmergentes ve;
	private Nodo nodo;
	private LectorJson json;

	/**
     * Constructor que inicializa los componentes principales de la aplicación:
     * - Ventana principal
     * - Ventanas emergentes
     * - Estructuras de datos (lista circular doble y pila)
     * - Lector de archivos JSON
     */
	
	public Controller() {

		vp = new VentanaPrincipal();
		ve = new VentanasEmergentes();
		asignarOyentes();
		lista = new ListaCircularDoble();
		pila = new PilaEliminacion();
		nodo = new Nodo();
		json = new LectorJson();
		json.leerJsonCampeones(lista);
		json.leerJsonEliminacion(pila);

	}

	/**
     * Asigna los action listeners a los botones de la interfaz gráfica.
     */
	
	public void asignarOyentes() {

		vp.getPp().getBtnGestionarCampeones().addActionListener(this);
		vp.getPp().getBtnMostrarEliminaciones().addActionListener(this);
		vp.getPgc().getBtnAgregarEquipo().addActionListener(this);
		vp.getPgc().getBtnAgregarTitulo().addActionListener(this);
		vp.getPgc().getBtnMostrarTitulos().addActionListener(this);
		vp.getPgc().getBtnVolver().addActionListener(this);
		vp.getPae().getBtnAgregar().addActionListener(this);
		vp.getPae().getBtnVolver().addActionListener(this);
		vp.getPat().getBtnAgregar().addActionListener(this);
		vp.getPat().getBtnVolver().addActionListener(this);
		vp.getPmt().getBtnVolver().addActionListener(this);

	}

	/**
     * Maneja los eventos de acción generados por los componentes de la interfaz.
     * 
     * @param e El evento de acción que contiene información sobre el componente que lo generó
     */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if (comando.equals("GESTIONARCAMPEONES")) {

			mostrarGestionarCampeones();

		} else if (comando.equals("VOLVER")) {

			mostrarPanelPrincipal();

		} else if (comando.equals("AGREGAREQUIPO")) {

			mostrarAgregarEquipo();

		} else if (comando.equals("VOLVERGESTIONCAMPEONES")) {

			volverGestionarEquipos();

		} else if (comando.equals("AGREGARNUEVOEQUIPO")) {

			agregarEquipo();

		} else if (comando.equals("AGREGARTITULO")) {

			String equipo = ve.leerDatoString("Digite el nombre del equipo: ");
			nodo = lista.buscarPorNombre(equipo);
			if (nodo != null) {

				mostrarAgregarTitulo();

			} else {

				ve.mostramensaje("Equipo no encontrado");

			}
		} else if (comando.equals("AGREGARNUEVOTITULO")) {

			agregarTitulo(nodo);

		} else if(comando.equals("MOSTRARTITULOS")) {
			
			String equipo = ve.leerDatoString("Digite el nombre del equipo: ");
			nodo = lista.buscarPorNombre(equipo);
			if (nodo != null) {

				mostrarTitulos(nodo);

			} else {

				ve.mostramensaje("Equipo no encontrado");

			}
			
		} else if(comando.equals("MOSTRARELIMINACIONES")) {
			
			mostrarEliminaciones();
			
		}

	}


	/**
     * Carga los datos de los campeones en la tabla de la interfaz gráfica.
     * Ordena los equipos por cantidad de títulos antes de mostrarlos.
     */
	
	public void cargarDatosTabla() {

		DefaultTableModel modelo = vp.getPgc().getModeloTabla();
		modelo.setRowCount(0);
		ordenamientoPorTitulos.ordenarPorCantidadTitulos(lista);
		Nodo actual = lista.getCabeza();
		if (actual == null)
			return;

		do {
			Campeones c = actual.getDato();
			modelo.addRow(new Object[] { c.getNombre(), c.getPais(), c.getCantidadTitulos() });
			actual = actual.getSiguiente();
		} while (actual != lista.getCabeza());

	}

	/**
     * Muestra el panel de gestión de campeones.
     * Oculta los demás paneles y carga los datos en la tabla.
     */
	
	public void mostrarGestionarCampeones() {

		cargarDatosTabla();
		vp.getPp().setVisible(false);
		vp.getPae().setVisible(false);
		vp.getPat().setVisible(false);
		vp.getPmt().setVisible(false);
		vp.getPme().setVisible(false);
		vp.getContentPane().add(vp.getPgc());
		vp.getPgc().setVisible(true);

	}

	/**
     * Muestra el panel principal de la aplicación.
     * Oculta todos los demás paneles.
     */
	
	public void mostrarPanelPrincipal() {

		vp.getPgc().setVisible(false);
		vp.getPae().setVisible(false);
		vp.getPat().setVisible(false);
		vp.getPmt().setVisible(false);
		vp.getPme().setVisible(false);
		vp.getPp().setVisible(true);

	}

	/**
     * Muestra el panel agregar equipo de la aplicación.
     * Oculta todos los demás paneles.
     */
	
	public void mostrarAgregarEquipo() {

		vp.getPp().setVisible(false);
		vp.getPgc().setVisible(false);
		vp.getPat().setVisible(false);
		vp.getPmt().setVisible(false);
		vp.getPme().setVisible(false);
		vp.getContentPane().add(vp.getPae());
		vp.getPae().setVisible(true);

	}

	/**
     * Muestra el panel gestionar equipo de la aplicación.
     * Oculta todos los demás paneles.
     */
	
	public void volverGestionarEquipos() {

		vp.getPae().setVisible(false);
		vp.getPp().setVisible(false);
		vp.getPat().setVisible(false);
		vp.getPmt().setVisible(false);
		vp.getPme().setVisible(false);
		vp.getPgc().setVisible(true);

	}

	/**
     * Agrega un nuevo equipo a la lista de campeones.
     * Valida que todos los campos estén completos antes de agregar.
     */
	
	public void agregarEquipo() {

		if (vp.getPae().getTxtNombre().getText().trim().isEmpty() || vp.getPae().getTxtPais().getText().isEmpty()
				|| vp.getPae().getTxtGoleador().getText().isEmpty()
				|| vp.getPae().getTxtAnioTitulo().getText().trim().isEmpty()
				|| vp.getPae().getTxtCantidadGoles().getText().trim().isEmpty()) {

			ve.mostramensaje("Todos los campos son obligatorios");

		} else {

			String nombre = vp.getPae().getTxtNombre().getText();
			String pais = vp.getPae().getTxtPais().getText();
			int anio = Integer.parseInt(vp.getPae().getTxtAnioTitulo().getText());
			String goleador = vp.getPae().getTxtGoleador().getText();
			int cantidadGoles = Integer.parseInt(vp.getPae().getTxtCantidadGoles().getText());

			Titulos t = new Titulos(anio, goleador, cantidadGoles);

			List<Titulos> titulos = new ArrayList<Titulos>();
			titulos.add(t);

			Campeones c = new Campeones(nombre, pais, titulos);

			lista.insertar(c);
			
			ve.mostramensaje("Equipo agregado correctamente");

			cargarDatosTabla();
			volverGestionarEquipos();
			limpiarCamposAgregarEquipo();

		}

	}

	/**
     * Limpia los campos del formulario de agregar equipo.
     */
	
	public void limpiarCamposAgregarEquipo() {
		
		vp.getPae().getTxtNombre().setText("");
		vp.getPae().getTxtAnioTitulo().setText("");
		vp.getPae().getTxtPais().setText("");
		vp.getPae().getTxtCantidadGoles().setText("");
		vp.getPae().getTxtGoleador().setText("");
		
	}
	
	public void mostrarAgregarTitulo() {

		vp.getPae().setVisible(false);
		vp.getPp().setVisible(false);
		vp.getPgc().setVisible(false);
		vp.getPmt().setVisible(false);
		vp.getPme().setVisible(false);
		vp.getContentPane().add(vp.getPat());
		vp.getPat().setVisible(true);

	}

	/**
     * Agrega un nuevo título a un equipo existente.
     * 
     * @param nodo El nodo que contiene el equipo al que se le agregará el título
     */
	
	public void agregarTitulo(Nodo nodo) {

		if (vp.getPat().getTxtAnio().getText().trim().isEmpty()
				|| vp.getPat().getTxtCantidadGoles().getText().trim().isEmpty()
				|| vp.getPat().getTxtGoleador().getText().trim().isEmpty()) {
			
			ve.mostramensaje("Todos los campos son obligatorios");

		} else {
			
			int anio = Integer.parseInt(vp.getPat().getTxtAnio().getText());
			String goleador = vp.getPat().getTxtGoleador().getText();
			int cantidadGoles = Integer.parseInt(vp.getPat().getTxtCantidadGoles().getText());
			
			Titulos t = new Titulos(anio, goleador, cantidadGoles);
			
			List<Titulos> titulosNuevos = nodo.getDato().getTitulos();
			
			titulosNuevos.add(t);
			
			nodo.getDato().setTitulos(titulosNuevos);
			
			nodo.getDato().setCantidadTitulos(titulosNuevos.size());
			
			ve.mostramensaje("Titulo agregado correctamente");
			
			cargarDatosTabla();
			volverGestionarEquipos();
			limpiarCamposAgregarTitulo();
			
		}

	}
	
	/**
     * Limpia los campos del formulario de agregar titulo.
     */
	
	public void limpiarCamposAgregarTitulo() {
		
		vp.getPat().getTxtAnio().setText("");
		vp.getPat().getTxtCantidadGoles().setText("");
		vp.getPat().getTxtGoleador().setText("");
		
	}
	
	/**
     * Muestra los títulos de un equipo específico en una tabla.
     * 
     * @param nodo El nodo que contiene el equipo cuyos títulos se mostrarán
     */
	
	public void mostrarTitulos(Nodo nodo) {
		
		vp.getPmt().getLabelTitulo().setText("TITULOS DE " + nodo.getDato().getNombre() );
		
		DefaultTableModel modelo = vp.getPmt().getModeloTabla();
		modelo.setRowCount(0);
		List<Titulos> titulos = nodo.getDato().getTitulos();
		
		for (int i = 0; i < titulos.size(); i++) {
		
			modelo.addRow(new Object[] { titulos.get(i).getAnio(), titulos.get(i).getGoleador(), titulos.get(i).getGoles()  });
			
		}
		
		vp.getPae().setVisible(false);
		vp.getPp().setVisible(false);
		vp.getPat().setVisible(false);
		vp.getPgc().setVisible(false);
		vp.getPme().setVisible(false);
		vp.getContentPane().add(vp.getPmt());
		vp.getPmt().setVisible(true);
		
		
	}

	/**
     * Muestra el panel con las eliminaciones de equipos.
     * Inicializa los componentes del panel con los datos de la pila de eliminaciones.
     */
	
	public void mostrarEliminaciones() {
		
		vp.getPae().setVisible(false);
		vp.getPp().setVisible(false);
		vp.getPat().setVisible(false);
		vp.getPgc().setVisible(false);
		vp.getPmt().setVisible(false);
		vp.getContentPane().add(vp.getPme());
		vp.getPme().inicializarComponentes(pila);
		vp.getPme().setVisible(true);
		
	}
	
}
