package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import model.Eliminacion;
import model.PilaEliminacion;

/**
 * La clase {@code PanelMostrarEliminaciones} representa un panel gráfico que
 * muestra una lista de equipos eliminados con sus descripciones e imágenes asociadas.
 * 
 * Este panel utiliza una tabla no editable donde se visualizan los datos proporcionados
 * por una instancia de {@link PilaEliminacion}.
 */

public class PanelMostrarEliminaciones extends JPanel {

	/** Tabla que muestra las eliminaciones. */
    private JTable tabla;

    /** Etiqueta de título principal del panel. */
    private JLabel labelTitulo;

    /** Modelo de datos para la tabla. */
    private DefaultTableModel modeloTabla;

    /** Botón para volver a la pantalla anterior. */
    private JButton btnVolver;
    
    /**
     * Constructor del panel. Configura el layout general.
     * No inicializa componentes hasta que se llame a {@link #inicializarComponentes(PilaEliminacion)}.
     */
	
	public PanelMostrarEliminaciones() {
		
		setLayout(new BorderLayout());
        setVisible(false);
		
	}
	
	/**
     * Inicializa los componentes gráficos del panel, incluyendo una tabla con imágenes
     * y un botón para volver. Los datos se obtienen desde la pila de eliminaciones.
     * 
     * @param pila La pila de objetos {@link Eliminacion} que se van a mostrar.
     */
	
	public void inicializarComponentes(PilaEliminacion pila) {

        labelTitulo = new JLabel("Equipos Eliminados", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        add(labelTitulo, BorderLayout.NORTH);

        modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int column) {
                return column == 1 ? ImageIcon.class : String.class;
            }
        };

        modeloTabla.addColumn("Descripción");
        modeloTabla.addColumn("Imagen");

        Eliminacion[] eliminaciones = pila.getElementos();

        for (Eliminacion e : eliminaciones) {
            String rutaImagen = e.getImagen();
            System.out.println("Intentando cargar imagen desde: " + rutaImagen);

            try {
                URL recurso = getClass().getClassLoader().getResource(rutaImagen);

                if (recurso == null) {
                    System.err.println("⚠ No se encontró la imagen: " + rutaImagen);
                    modeloTabla.addRow(new Object[] { e.getDescripcion(), null });
                    continue;
                }

                // Cargar y escalar imagen
                ImageIcon icono = new ImageIcon(recurso);
                Image imagenEscalada = icono.getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH);
                ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);

                // Agregar a la tabla
                modeloTabla.addRow(new Object[] { e.getDescripcion(), iconoEscalado });

            } catch (Exception ex) {
                System.err.println("❌ Error al cargar imagen: " + rutaImagen);
                ex.printStackTrace();
                modeloTabla.addRow(new Object[] { e.getDescripcion(), null });
            }
        }

        
       


        tabla = new JTable(modeloTabla);
        tabla.setRowHeight(90);
        tabla.getColumnModel().getColumn(1).setMaxWidth(150);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        btnVolver = new JButton("Volver");
        JPanel panelBoton = new JPanel();
        panelBoton.add(btnVolver);
        add(panelBoton, BorderLayout.SOUTH);
    }

	/**
     * Obtiene el botón para volver.
     * @return El botón "Volver"
     */
	
	public JButton getBtnVolver() {
		return btnVolver;
	}
	
}
