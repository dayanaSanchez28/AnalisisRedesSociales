/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisredessociales.archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class ManejadorArchivos {
    private static String ultimoLeido;
    public static String seleccionArchivo(JFrame jFrame) {
        try {
            JFileChooser seleccionador = new JFileChooser();
            seleccionador.showOpenDialog(jFrame);
            File archivoSeleccionado = seleccionador.getSelectedFile();
            if (null == archivoSeleccionado) {
                return "";
            }
            String contenido = Files.readString(archivoSeleccionado.toPath());
            ultimoLeido = archivoSeleccionado.toPath().toAbsolutePath().toString();
            return contenido;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(jFrame, ex.getMessage(), "Ocurrió un error", JOptionPane.ERROR_MESSAGE);
            return "";
        }
    }

    public static String getUltimoLeido() {
        return ultimoLeido;
    }
    
    public static String seleccionArchivo() {
        return seleccionArchivo(null);
    }
    
    public static boolean guardarEnArchivo(String contenido, JFrame jFrame) {
        try {
            JFileChooser guardador = new JFileChooser();
            guardador.showSaveDialog(jFrame);
            File guardado = guardador.getSelectedFile();
            if (null == guardado) {
                return false;
            }
            FileWriter fileWriter = new FileWriter(guardado);
            fileWriter.write(contenido);
            fileWriter.close();
            return true;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(jFrame, ex.getMessage(), "Ocurrió un error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public static boolean guardarEnArchivo(String contenido) {
        return guardarEnArchivo(contenido, null);
    }
}
