/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package analisisredessociales;

import analisisredessociales.interfaz.VentanaInicio;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(AnalisisRedesSociales.class.getName()).log(Level.SEVERE, null, ex);
        }
        SwingUtilities.invokeLater(() -> {
            VentanaInicio vi = new VentanaInicio();
            vi.setVisible(true);
            vi.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        });
    }
}
