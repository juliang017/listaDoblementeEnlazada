package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Panel de interfaz gráfica para agregar nuevos equipos campeones al sistema.
 * <p>
 * Este panel contiene un formulario con campos para ingresar:
 * - Nombre del equipo
 * - País de origen
 * - Año del título
 * - Goleador del torneo
 * - Cantidad de goles
 * </p>
 * <p>
 * Implementa componentes Swing para la interacción con el usuario y sigue
 * el patrón de diseño MVC como vista en la arquitectura de la aplicación.
 * </p>
 */

public class PanelAgregarEquipo extends JPanel {

	private JLabel labelTitulo , labelNombre, labelPais,  labelAnio, labelGoleador, labelCantidadGoles;
	private JTextField txtNombre , txtPais, txtGoleador;
	private JFormattedTextField txtAnioTitulo, txtCantidadGoles;
	private JButton btnAgregar , btnVolver;
	private GridBagConstraints gbc;
	
	/**
     * Constructor que inicializa el panel y sus componentes.
     * <p>
     * Configura el diseño usando GridBagLayout y establece los márgenes internos.
     * Inicializa todos los componentes gráficos y los coloca en el panel.
     * </p>
     */
	
	PanelAgregarEquipo(){
		
		setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);

		inicializarComponentes();
		setVisible(false);
		
	}
	
	/**
     * Inicializa y posiciona todos los componentes gráficos del panel.
     * <p>
     * Crea y configura:
     * - Etiquetas descriptivas para cada campo
     * - Campos de texto para entrada de datos
     * - Campos de texto formateados para valores numéricos
     * - Botones de acción (Agregar y Volver)
     * </p>
     */
	
	public void inicializarComponentes() {
		
		labelTitulo = new JLabel("AGREGAR NUEVO CAMPEON");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(labelTitulo, gbc);
		
		labelNombre = new JLabel("Nombre del equipo: ");
		txtNombre = new JTextField();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(labelNombre , gbc);
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(txtNombre , gbc);
		
		labelPais = new JLabel("Pais del equipo: ");
		txtPais = new JTextField();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(labelPais , gbc);
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(txtPais , gbc);
		
		labelAnio = new JLabel("Año del titulo: ");
		NumberFormat anioFormat = NumberFormat.getIntegerInstance();
		anioFormat.setGroupingUsed(false);
		txtAnioTitulo = new JFormattedTextField(anioFormat);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(labelAnio , gbc);
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(txtAnioTitulo , gbc);
		
		labelGoleador = new JLabel("Goleador del torneo: ");
		txtGoleador = new JTextField();
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(labelGoleador , gbc);
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(txtGoleador , gbc);
		
		labelCantidadGoles = new JLabel("Cantidad de goles: ");
		NumberFormat golesFormat = NumberFormat.getIntegerInstance();
		golesFormat.setGroupingUsed(false);
		txtCantidadGoles = new JFormattedTextField(golesFormat);
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(labelCantidadGoles , gbc);
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(txtCantidadGoles , gbc);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setActionCommand("AGREGARNUEVOEQUIPO");
		btnVolver = new JButton("Volver");
		btnVolver.setActionCommand("VOLVERGESTIONCAMPEONES");
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(btnAgregar , gbc);
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(btnVolver , gbc);
		
	}

	/**
     * Obtiene la etiqueta del título del panel.
     * @return JLabel con el título del panel
     */
	
	public JLabel getLabelTitulo() {
		return labelTitulo;
	}

	/**
     * Establece la etiqueta del título del panel.
     * @param labelTitulo La nueva etiqueta de título
     */
	
	public void setLabelTitulo(JLabel labelTitulo) {
		this.labelTitulo = labelTitulo;
	}
	
    /**
     * Obtiene la etiqueta del campo "Nombre".
     * @return JLabel asociado al nombre del equipo.
     */
    public JLabel getLabelNombre() {
        return labelNombre;
    }

    /**
     * Establece la etiqueta para el campo "Nombre".
     * @param labelNombre JLabel a asignar.
     */
    public void setLabelNombre(JLabel labelNombre) {
        this.labelNombre = labelNombre;
    }

    /**
     * Obtiene la etiqueta del campo "País".
     * @return JLabel asociado al país del equipo.
     */
    public JLabel getLabelPais() {
        return labelPais;
    }

    /**
     * Establece la etiqueta para el campo "País".
     * @param labelPais JLabel a asignar.
     */
    public void setLabelPais(JLabel labelPais) {
        this.labelPais = labelPais;
    }

    /**
     * Obtiene la etiqueta del campo "Año".
     * @return JLabel asociado al año del título.
     */
    public JLabel getLabelAnio() {
        return labelAnio;
    }

    /**
     * Establece la etiqueta para el campo "Año".
     * @param labelAnio JLabel a asignar.
     */
    public void setLabelAnio(JLabel labelAnio) {
        this.labelAnio = labelAnio;
    }

    /**
     * Obtiene la etiqueta del campo "Goleador".
     * @return JLabel asociado al nombre del goleador.
     */
    public JLabel getLabelGoleador() {
        return labelGoleador;
    }

    /**
     * Establece la etiqueta para el campo "Goleador".
     * @param labelGoleador JLabel a asignar.
     */
    public void setLabelGoleador(JLabel labelGoleador) {
        this.labelGoleador = labelGoleador;
    }

    /**
     * Obtiene la etiqueta del campo "Cantidad de goles".
     * @return JLabel asociado a la cantidad de goles.
     */
    public JLabel getLabelCantidadGoles() {
        return labelCantidadGoles;
    }

    /**
     * Establece la etiqueta para el campo "Cantidad de goles".
     * @param labelCantidadGoles JLabel a asignar.
     */
    public void setLabelCantidadGoles(JLabel labelCantidadGoles) {
        this.labelCantidadGoles = labelCantidadGoles;
    }

    /**
     * Obtiene el campo de texto del nombre del equipo.
     * @return JTextField donde se ingresa el nombre del equipo.
     */
    public JTextField getTxtNombre() {
        return txtNombre;
    }

    /**
     * Establece el campo de texto del nombre del equipo.
     * @param txtNombre JTextField a asignar.
     */
    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    /**
     * Obtiene el campo de texto del país del equipo.
     * @return JTextField donde se ingresa el país.
     */
    public JTextField getTxtPais() {
        return txtPais;
    }

    /**
     * Establece el campo de texto del país del equipo.
     * @param txtPais JTextField a asignar.
     */
    public void setTxtPais(JTextField txtPais) {
        this.txtPais = txtPais;
    }

    /**
     * Obtiene el campo de texto del nombre del goleador.
     * @return JTextField donde se ingresa el goleador.
     */
    public JTextField getTxtGoleador() {
        return txtGoleador;
    }

    /**
     * Establece el campo de texto del nombre del goleador.
     * @param txtGoleador JTextField a asignar.
     */
    public void setTxtGoleador(JTextField txtGoleador) {
        this.txtGoleador = txtGoleador;
    }

    /**
     * Obtiene el botón "Agregar".
     * @return JButton utilizado para agregar un nuevo equipo o título.
     */
    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    /**
     * Establece el botón "Agregar".
     * @param btnAgregar JButton a asignar.
     */
    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    /**
     * Obtiene el botón "Volver".
     * @return JButton utilizado para regresar a la vista anterior.
     */
    public JButton getBtnVolver() {
        return btnVolver;
    }

    /**
     * Establece el botón "Volver".
     * @param btnVolver JButton a asignar.
     */
    public void setBtnVolver(JButton btnVolver) {
        this.btnVolver = btnVolver;
    }

    /**
     * Obtiene el campo de texto formateado para el año del título.
     * @return JFormattedTextField donde se ingresa el año.
     */
    public JFormattedTextField getTxtAnioTitulo() {
        return txtAnioTitulo;
    }

    /**
     * Establece el campo de texto formateado para el año del título.
     * @param txtAnioTitulo JFormattedTextField a asignar.
     */
    public void setTxtAnioTitulo(JFormattedTextField txtAnioTitulo) {
        this.txtAnioTitulo = txtAnioTitulo;
    }

    /**
     * Obtiene el campo de texto formateado para la cantidad de goles.
     * @return JFormattedTextField donde se ingresa la cantidad de goles.
     */
    public JFormattedTextField getTxtCantidadGoles() {
        return txtCantidadGoles;
    }

    /**
     * Establece el campo de texto formateado para la cantidad de goles.
     * @param txtCantidadGoles JFormattedTextField a asignar.
     */
    public void setTxtCantidadGoles(JFormattedTextField txtCantidadGoles) {
        this.txtCantidadGoles = txtCantidadGoles;
    }

	
}
