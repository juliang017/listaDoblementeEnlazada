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
 * Clase PanelMostrarTitulos que representa un panel gráfico para visualizar los títulos obtenidos por un equipo.
 * Muestra una tabla con información como el año, el goleador y la cantidad de goles.
 * Incluye también un botón para volver a la vista de gestión de campeones.
 */
public class PanelMostrarTitulos extends JPanel {

    private JLabel labelTitulo;
    private JTable tabla;
    private DefaultTableModel modeloTabla;
    private JButton btnVolver;

    /**
     * Constructor del panel PanelMostrarTitulos.
     * Inicializa el diseño y los componentes gráficos del panel.
     */
    public PanelMostrarTitulos() {
        setLayout(new BorderLayout(10, 10));
        inicializarComponentes();
        setVisible(false);
    }

    /**
     * Inicializa y configura los componentes del panel.
     * Crea el título, la tabla de títulos y el botón de volver.
     */
    private void inicializarComponentes() {
        labelTitulo = new JLabel("Títulos de", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        add(labelTitulo, BorderLayout.NORTH);

        modeloTabla = new DefaultTableModel(new String[]{"AÑO", "GOLEADOR", "CANTIDAD DE GOLES"}, 0);
        tabla = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tabla);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        btnVolver = new JButton("Volver");
        btnVolver.setActionCommand("VOLVERGESTIONCAMPEONES");
        panelBotones.add(btnVolver);

        add(panelBotones, BorderLayout.SOUTH);
    }

    /**
     * Obtiene la etiqueta del título principal del panel.
     * @return JLabel del título.
     */
    public JLabel getLabelTitulo() {
        return labelTitulo;
    }

    /**
     * Establece la etiqueta del título principal del panel.
     * @param labelTitulo JLabel a asignar.
     */
    public void setLabelTitulo(JLabel labelTitulo) {
        this.labelTitulo = labelTitulo;
    }

    /**
     * Obtiene la tabla que muestra los títulos.
     * @return JTable que contiene los datos.
     */
    public JTable getTabla() {
        return tabla;
    }

    /**
     * Establece la tabla de títulos.
     * @param tabla JTable a asignar.
     */
    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    /**
     * Obtiene el modelo de la tabla utilizado para los datos de títulos.
     * @return DefaultTableModel asociado a la tabla.
     */
    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    /**
     * Establece el modelo de la tabla con los datos de los títulos.
     * @param modeloTabla Modelo de tabla a asignar.
     */
    public void setModeloTabla(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

    /**
     * Obtiene el botón "Volver" del panel.
     * @return JButton utilizado para regresar a la vista anterior.
     */
    public JButton getBtnVolver() {
        return btnVolver;
    }

    /**
     * Establece el botón "Volver" del panel.
     * @param btnVolver JButton a asignar.
     */
    public void setBtnVolver(JButton btnVolver) {
        this.btnVolver = btnVolver;
    }
}
