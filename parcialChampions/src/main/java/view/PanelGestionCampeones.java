package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 * La clase {@code PanelGestionCampeones} representa un panel gráfico
 * dentro de una interfaz de usuario para gestionar equipos campeones.
 * 
 * Incluye una tabla con los equipos, botones para agregar nuevos equipos o títulos,
 * mostrar títulos existentes y volver a la pantalla anterior.
 */

public class PanelGestionCampeones extends JPanel {

	/** Etiqueta de título principal del panel. */
    private JLabel titulo;

    /** Tabla que muestra los equipos campeones. */
    private JTable tabla;

    /** Modelo de datos de la tabla. */
    private DefaultTableModel modeloTabla;

    /** Botón para agregar un nuevo equipo. */
    private JButton btnAgregarEquipo;

    /** Botón para agregar un nuevo título. */
    private JButton btnAgregarTitulo;

    /** Botón para mostrar los títulos de un equipo. */
    private JButton btnMostrarTitulos;

    /** Botón para volver al menú anterior. */
    private JButton btnVolver;
    
    /**
     * Constructor que configura el layout del panel e inicializa sus componentes.
     */
    
    public PanelGestionCampeones() {
        
        setLayout(new BorderLayout(10, 10)); 
        inicializarComponentes();
        setVisible(false);
    }

    /**
     * Inicializa los componentes gráficos del panel, como la tabla y los botones,
     * y los agrega al panel con un layout adecuado.
     */
    
    public void inicializarComponentes() {
    	
        titulo = new JLabel("Gestión de Campeones", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        add(titulo, BorderLayout.NORTH);

        modeloTabla = new DefaultTableModel(new String[]{"NOMBRE", "PAIS", "CANTIDAD DE TITULOS"}, 0);
        tabla = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tabla);

        add(scrollPane, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        btnAgregarEquipo = new JButton("Agregar Equipo");
        btnAgregarEquipo.setActionCommand("AGREGAREQUIPO");
        btnAgregarTitulo = new JButton("Agregar Título");
        btnAgregarTitulo.setActionCommand("AGREGARTITULO");
        btnMostrarTitulos = new JButton("Mostrar Títulos");
        btnMostrarTitulos.setActionCommand("MOSTRARTITULOS");
        btnVolver = new JButton("Volver");
        btnVolver.setActionCommand("VOLVER");

        panelBotones.add(btnAgregarEquipo);
        panelBotones.add(btnAgregarTitulo);
        panelBotones.add(btnMostrarTitulos);
        panelBotones.add(btnVolver);

        add(panelBotones, BorderLayout.SOUTH);
    	
    }
    
    /** @return la etiqueta del título del panel. */
    public JLabel getTitulo() { return titulo; }

    /** @param titulo la nueva etiqueta de título para el panel. */
    public void setTitulo(JLabel titulo) { this.titulo = titulo; }

    /** @return la tabla que muestra los equipos campeones. */
    public JTable getTabla() { return tabla; }

    /** @param tabla la nueva tabla a mostrar. */
    public void setTabla(JTable tabla) { this.tabla = tabla; }

    /** @return el modelo de la tabla. */
    public DefaultTableModel getModeloTabla() { return modeloTabla; }

    /** @param modeloTabla el nuevo modelo de datos para la tabla. */
    public void setModeloTabla(DefaultTableModel modeloTabla) { this.modeloTabla = modeloTabla; }

    /** @return el botón para agregar un nuevo equipo. */
    public JButton getBtnAgregarEquipo() { return btnAgregarEquipo; }

    /** @param btnAgregarEquipo el nuevo botón para agregar equipos. */
    public void setBtnAgregarEquipo(JButton btnAgregarEquipo) { this.btnAgregarEquipo = btnAgregarEquipo; }

    /** @return el botón para agregar un nuevo título. */
    public JButton getBtnAgregarTitulo() { return btnAgregarTitulo; }

    /** @param btnAgregarTitulo el nuevo botón para agregar títulos. */
    public void setBtnAgregarTitulo(JButton btnAgregarTitulo) { this.btnAgregarTitulo = btnAgregarTitulo; }

    /** @return el botón para mostrar títulos. */
    public JButton getBtnMostrarTitulos() { return btnMostrarTitulos; }

    /** @param btnMostrarTitulos el nuevo botón para mostrar títulos. */
    public void setBtnMostrarTitulos(JButton btnMostrarTitulos) { this.btnMostrarTitulos = btnMostrarTitulos; }

    /** @return el botón para volver al menú anterior. */
    public JButton getBtnVolver() { return btnVolver; }

    /** @param btnVolver el nuevo botón para volver. */
    public void setBtnVolver(JButton btnVolver) { this.btnVolver = btnVolver; }
    
}
