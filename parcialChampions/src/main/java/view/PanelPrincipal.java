package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Clase PanelPrincipal que representa el panel principal del sistema.
 * Muestra el título principal de la aplicación y botones para navegar hacia la gestión de campeones
 * o la visualización de eliminaciones.
 */
public class PanelPrincipal extends JPanel {

    private JLabel titulo;
    private JButton btnGestionarCampeones;
    private JButton btnMostrarEliminaciones;
    private GridBagConstraints gbc;

    /**
     * Constructor del panel PanelPrincipal.
     * Inicializa el diseño, componentes y visibilidad del panel.
     */
    public PanelPrincipal() {
        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        inicializarComponentes();
        setVisible(true);
    }

    /**
     * Inicializa y configura los componentes visuales del panel.
     * Se agregan el título y los botones al panel utilizando GridBagLayout.
     */
    public void inicializarComponentes() {
        titulo = new JLabel("Champion League", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 0, 20, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        add(titulo, gbc);

        btnGestionarCampeones = new JButton("Gestionar campeones");
        btnGestionarCampeones.setActionCommand("GESTIONARCAMPEONES");

        btnMostrarEliminaciones = new JButton("Mostrar eliminaciones");
        btnMostrarEliminaciones.setActionCommand("MOSTRARELIMINACIONES");

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 10, 0, 10);

        gbc.gridx = 0;
        add(btnGestionarCampeones, gbc);

        gbc.gridx = 1;
        add(btnMostrarEliminaciones, gbc);
    }

    /**
     * Obtiene el JLabel del título principal del panel.
     * @return JLabel con el texto "Champion League".
     */
    public JLabel getTitulo() {
        return titulo;
    }

    /**
     * Establece el JLabel del título principal del panel.
     * @param titulo JLabel a asignar como título.
     */
    public void setTitulo(JLabel titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el botón para gestionar campeones.
     * @return JButton "Gestionar campeones".
     */
    public JButton getBtnGestionarCampeones() {
        return btnGestionarCampeones;
    }

    /**
     * Establece el botón para gestionar campeones.
     * @param btnGestionarCampeones JButton a asignar.
     */
    public void setBtnGestionarCampeones(JButton btnGestionarCampeones) {
        this.btnGestionarCampeones = btnGestionarCampeones;
    }

    /**
     * Obtiene el botón para mostrar eliminaciones.
     * @return JButton "Mostrar eliminaciones".
     */
    public JButton getBtnMostrarEliminaciones() {
        return btnMostrarEliminaciones;
    }

    /**
     * Establece el botón para mostrar eliminaciones.
     * @param btnMostrarEliminaciones JButton a asignar.
     */
    public void setBtnMostrarEliminaciones(JButton btnMostrarEliminaciones) {
        this.btnMostrarEliminaciones = btnMostrarEliminaciones;
    }
}
