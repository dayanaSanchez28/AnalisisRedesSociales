/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package analisisredessociales;

import analisisredessociales.interfaz.VentanaInicio;
import javax.swing.SwingUtilities;

/**
 *
 * @author dayan
 */
public class AnalisisRedesSociales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.setProperty("org.graphstream.ui", "swing");
        SwingUtilities.invokeLater(() -> {
            new VentanaInicio().setVisible(true);
        });
    }
}
