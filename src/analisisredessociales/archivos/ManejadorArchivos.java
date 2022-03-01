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
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 * Clase utiliaria para el manejo de archivos
 * @author Dayana
 */
public class ManejadorArchivos {
    private static String ultimoLeido;
    
    /**
     * Abre la selección de archivos para cargar un txt en el sistema.
     * @param jFrame 
     * @return El contenito del txt
     */
    public static String seleccionArchivo(JFrame jFrame) {
        try {
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto", "txt");
            JFileChooser seleccionador = new JFileChooser();
            seleccionador.setFileFilter(filter);
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

    /**
     * Ruta hacia el ultimo archivo leído
     * @return 
     */
    public static String getUltimoLeido() {
        return ultimoLeido;
    }
    
    public static String seleccionArchivo() {
        return seleccionArchivo(null);
    }
    
    /**
     * Guarda el contenido recibido como argumento, en un archivo que seleccione el usuario a través de un JFileChooser
     * @param contenido
     * @param jFrame
     * @return el resultado de éxito de la operación
     */
    public static boolean guardarEnArchivo(String contenido, JFrame jFrame) {
        try {
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto", "txt");
            JFileChooser guardador = new JFileChooser();
            guardador.setFileFilter(filter);
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
