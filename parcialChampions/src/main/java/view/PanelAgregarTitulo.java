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
 * La clase {@code PanelAgregarTitulo} es un panel de interfaz gráfica (GUI) que permite al usuario
 * ingresar información para agregar un nuevo título a un equipo campeón.
 * 
 * El panel incluye campos para el año del título, el goleador del torneo y la cantidad de goles,
 * además de botones para confirmar la acción o volver a la pantalla anterior.
 */

public class PanelAgregarTitulo extends JPanel {

	/** Etiqueta principal del panel. */
    private JLabel labelTitulo;

    /** Etiqueta para el campo de año del título. */
    private JLabel labelAnio;

    /** Etiqueta para el campo del goleador. */
    private JLabel labelGoleador;

    /** Etiqueta para el campo de cantidad de goles. */
    private JLabel labelCantidadGoles;

    /** Campo de texto para ingresar el nombre del goleador. */
    private JTextField txtGoleador;

    /** Campo de texto con formato para ingresar el año del título. */
    private JFormattedTextField txtAnio;

    /** Campo de texto con formato para ingresar la cantidad de goles. */
    private JFormattedTextField txtCantidadGoles;

    /** Botón para agregar un nuevo título. */
    private JButton btnAgregar;

    /** Botón para volver a la vista anterior. */
    private JButton btnVolver;

    /** Restricciones de diseño para el GridBagLayout. */
    private GridBagConstraints gbc;
	
    /**
     * Constructor que inicializa el panel con sus componentes y los organiza usando GridBagLayout.
     */
    
	public PanelAgregarTitulo() {
		
		setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);

		inicializarComponentes();
		setVisible(false);
		
	}
	
	/**
     * Inicializa y posiciona todos los componentes del panel,
     * incluyendo etiquetas, campos de texto y botones.
     */
	
	public void inicializarComponentes() {
		
		labelTitulo = new JLabel("AGREGAR NUEVO TITULO");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(labelTitulo, gbc);
		
		labelAnio = new JLabel("Año del titulo: ");
		NumberFormat anioFormat = NumberFormat.getIntegerInstance();
		anioFormat.setGroupingUsed(false);
		txtAnio = new JFormattedTextField(anioFormat);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(labelAnio, gbc);
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(txtAnio , gbc);
		
		labelGoleador = new JLabel("Goleador del torneo: ");
		txtGoleador = new JTextField();
		gbc.gridx = 0;
		gbc.gridy = 2;
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
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(labelCantidadGoles , gbc);
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(txtCantidadGoles , gbc);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setActionCommand("AGREGARNUEVOTITULO");
		btnVolver = new JButton("Volver");
		btnVolver.setActionCommand("VOLVERGESTIONCAMPEONES");
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(btnAgregar , gbc);
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(btnVolver , gbc);
		
	}

	/** @return la etiqueta principal del panel. */
    public JLabel getLabelTitulo() { return labelTitulo; }

    /** @param labelTitulo la nueva etiqueta principal del panel. */
    public void setLabelTitulo(JLabel labelTitulo) { this.labelTitulo = labelTitulo; }

    /** @return la etiqueta del campo año. */
    public JLabel getLabelAnio() { return labelAnio; }

    /** @param labelAnio la nueva etiqueta para el campo año. */
    public void setLabelAnio(JLabel labelAnio) { this.labelAnio = labelAnio; }

    /** @return la etiqueta del campo goleador. */
    public JLabel getLabelGoleador() { return labelGoleador; }

    /** @param labelGoleador la nueva etiqueta para el campo goleador. */
    public void setLabelGoleador(JLabel labelGoleador) { this.labelGoleador = labelGoleador; }

    /** @return la etiqueta del campo cantidad de goles. */
    public JLabel getLabelCantidadGoles() { return labelCantidadGoles; }

    /** @param labelCantidadGoles la nueva etiqueta para el campo de goles. */
    public void setLabelCantidadGoles(JLabel labelCantidadGoles) { this.labelCantidadGoles = labelCantidadGoles; }

    /** @return el campo de texto para el nombre del goleador. */
    public JTextField getTxtGoleador() { return txtGoleador; }

    /** @param txtGoleador el nuevo campo de texto para el goleador. */
    public void setTxtGoleador(JTextField txtGoleador) { this.txtGoleador = txtGoleador; }

    /** @return el campo de texto con formato para el año. */
    public JFormattedTextField getTxtAnio() { return txtAnio; }

    /** @param txtAnio el nuevo campo de texto con formato para el año. */
    public void setTxtAnio(JFormattedTextField txtAnio) { this.txtAnio = txtAnio; }

    /** @return el campo de texto con formato para la cantidad de goles. */
    public JFormattedTextField getTxtCantidadGoles() { return txtCantidadGoles; }

    /** @param txtCantidadGoles el nuevo campo de texto para los goles. */
    public void setTxtCantidadGoles(JFormattedTextField txtCantidadGoles) { this.txtCantidadGoles = txtCantidadGoles; }

    /** @return el botón para agregar un nuevo título. */
    public JButton getBtnAgregar() { return btnAgregar; }

    /** @param btnAgregar el nuevo botón para agregar un título. */
    public void setBtnAgregar(JButton btnAgregar) { this.btnAgregar = btnAgregar; }

    /** @return el botón para volver al panel anterior. */
    public JButton getBtnVolver() { return btnVolver; }

    /** @param btnVolver el nuevo botón para volver al panel anterior. */
    public void setBtnVolver(JButton btnVolver) { this.btnVolver = btnVolver; }
	
}
