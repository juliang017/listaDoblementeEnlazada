package view;

import javax.swing.JOptionPane;

import javax.swing.JOptionPane;

/**
 * Clase utilitaria que proporciona métodos para mostrar ventanas emergentes
 * (diálogos) al usuario para la entrada y salida de datos.
 */
public class VentanasEmergentes {

    /**
     * Muestra una ventana de entrada para que el usuario ingrese un dato de tipo String.
     *
     * @param mensaje El mensaje que se mostrará en la ventana emergente.
     * @return El dato ingresado por el usuario como String, o {@code null} si el usuario cancela.
     */
    public String leerDatoString(String mensaje) {
        return JOptionPane.showInputDialog(mensaje);
    }

    /**
     * Muestra un mensaje al usuario mediante una ventana emergente.
     *
     * @param mensaje El mensaje que se desea mostrar.
     */
    public void mostramensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
