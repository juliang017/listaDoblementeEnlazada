package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Clase VentanaPrincipal que representa la ventana principal de la aplicación.
 * Esta ventana contiene todos los paneles utilizados para la gestión de campeones
 * y la visualización de datos en la Champions League.
 */
public class VentanaPrincipal extends JFrame {

    private PanelPrincipal pp;
    private PanelGestionCampeones pgc;
    private PanelAgregarEquipo pae;
    private PanelAgregarTitulo pat;
    private PanelMostrarTitulos pmt;
    private PanelMostrarEliminaciones pme;

    /**
     * Constructor de la clase VentanaPrincipal.
     * Configura las propiedades de la ventana principal y
     * llama al método para inicializar los componentes.
     */
    public VentanaPrincipal() {
        setTitle("Champions League");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        inicializarComponentes();

        setResizable(true);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setVisible(true);
    }

    /**
     * Inicializa todos los paneles utilizados en la aplicación.
     * Agrega el PanelPrincipal como vista inicial al contenido de la ventana.
     */
    public void inicializarComponentes() {
        pp = new PanelPrincipal();
        getContentPane().add(pp, BorderLayout.CENTER);

        pgc = new PanelGestionCampeones();
        pae = new PanelAgregarEquipo();
        pat = new PanelAgregarTitulo();
        pmt = new PanelMostrarTitulos();
        pme = new PanelMostrarEliminaciones();
    }

    // Métodos getter y setter para acceder y modificar los paneles

    /**
     * @return el panel principal (inicio).
     */
    public PanelPrincipal getPp() {
        return pp;
    }

    /**
     * @param pp el panel principal a asignar.
     */
    public void setPp(PanelPrincipal pp) {
        this.pp = pp;
    }

    /**
     * @return el panel de gestión de campeones.
     */
    public PanelGestionCampeones getPgc() {
        return pgc;
    }

    /**
     * @param pgc el panel de gestión de campeones a asignar.
     */
    public void setPgc(PanelGestionCampeones pgc) {
        this.pgc = pgc;
    }

    /**
     * @return el panel para agregar equipos.
     */
    public PanelAgregarEquipo getPae() {
        return pae;
    }

    /**
     * @param pae el panel para agregar equipos a asignar.
     */
    public void setPae(PanelAgregarEquipo pae) {
        this.pae = pae;
    }

    /**
     * @return el panel para agregar títulos.
     */
    public PanelAgregarTitulo getPat() {
        return pat;
    }

    /**
     * @param pat el panel para agregar títulos a asignar.
     */
    public void setPat(PanelAgregarTitulo pat) {
        this.pat = pat;
    }

    /**
     * @return el panel para mostrar títulos.
     */
    public PanelMostrarTitulos getPmt() {
        return pmt;
    }

    /**
     * @param pmt el panel para mostrar títulos a asignar.
     */
    public void setPmt(PanelMostrarTitulos pmt) {
        this.pmt = pmt;
    }

    /**
     * @return el panel para mostrar eliminaciones.
     */
    public PanelMostrarEliminaciones getPme() {
        return pme;
    }

    /**
     * @param pme el panel para mostrar eliminaciones a asignar.
     */
    public void setPme(PanelMostrarEliminaciones pme) {
        this.pme = pme;
    }
}
