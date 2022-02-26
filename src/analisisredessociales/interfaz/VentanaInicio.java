/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisredessociales.interfaz;

import analisisredessociales.archivos.ManejadorArchivos;
import analisisredessociales.estructuras.RedSocial;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Dayana
 */
public class VentanaInicio extends javax.swing.JFrame {
    private static final int ESTADISTICA_ULTIMO_LEIDO = 0;
    private static final int ESTADISTICA_NUMERO_USUARIOS = 1;
    private static final int ESTADISTICA_NUMERO_RELACIONES = 2;
    private RedSocial redSocial;
    /**
     * Creates new form VentanaInicio
     */
    public VentanaInicio() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblTitulo = new javax.swing.JLabel();
        botonera = new javax.swing.JPanel();
        botonCargaArchivo = new javax.swing.JButton();
        botonGuardarArchivo = new javax.swing.JButton();
        botonMostrar = new javax.swing.JButton();
        botonContarIslas = new javax.swing.JButton();
        botonIdentificarPuentes = new javax.swing.JButton();
        estadisticas = new javax.swing.JPanel();
        lblNombreEstadisticas = new javax.swing.JLabel();
        lblValoresEstadisticas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Analizador de Redes Sociales");
        setLocation(new java.awt.Point(400, 400));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTitulo.setText("Analizador de Redes Sociales");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(lblTitulo, gridBagConstraints);

        botonera.setLayout(new javax.swing.BoxLayout(botonera, javax.swing.BoxLayout.LINE_AXIS));

        botonCargaArchivo.setText("Cargar");
        botonCargaArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCargaArchivoActionPerformed(evt);
            }
        });
        botonera.add(botonCargaArchivo);

        botonGuardarArchivo.setText("Guardar");
        botonGuardarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarArchivoActionPerformed(evt);
            }
        });
        botonera.add(botonGuardarArchivo);

        botonMostrar.setText("Mostrar Grafo");
        botonMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarActionPerformed(evt);
            }
        });
        botonera.add(botonMostrar);

        botonContarIslas.setText("Contar Islas");
        botonContarIslas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonContarIslasActionPerformed(evt);
            }
        });
        botonera.add(botonContarIslas);

        botonIdentificarPuentes.setText("Identificar Puentes");
        botonIdentificarPuentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIdentificarPuentesActionPerformed(evt);
            }
        });
        botonera.add(botonIdentificarPuentes);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        getContentPane().add(botonera, gridBagConstraints);

        lblNombreEstadisticas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombreEstadisticas.setText("<html>Último archivo cargado:<br>Número de usuarios:<br>Número de Relaciones<br></html>");
        estadisticas.add(lblNombreEstadisticas);

        lblValoresEstadisticas.setText("<html>Sin archivo cargado<br>0<br>0</html>");
        estadisticas.add(lblValoresEstadisticas);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(estadisticas, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCargaArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCargaArchivoActionPerformed
        String contenidos = ManejadorArchivos.seleccionArchivo(this);
        if (contenidos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se seleccionó archivo. No se tratará de cargar información", "Info", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {    
            redSocial = RedSocial.importar(contenidos);
            actualizarEstadistica(ESTADISTICA_ULTIMO_LEIDO, ManejadorArchivos.getUltimoLeido());
            actualizarEstadistica(ESTADISTICA_NUMERO_USUARIOS, String.valueOf(redSocial.getNumeroUsuarios()));
            actualizarEstadistica(ESTADISTICA_NUMERO_RELACIONES, String.valueOf(redSocial.getNumeroRelaciones()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error al importar archivo", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_botonCargaArchivoActionPerformed

    private void botonGuardarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarArchivoActionPerformed
        String contenidos = redSocial.exportar();
        if (ManejadorArchivos.guardarEnArchivo(contenidos, this)) {
            JOptionPane.showMessageDialog(this, "Repositorio guardado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_botonGuardarArchivoActionPerformed

    private void botonMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarActionPerformed
        SwingUtilities.invokeLater(() -> {
            VistaGrafo vistaGrafo = new VistaGrafo(redSocial);
            vistaGrafo.setVisible(true);
        });
    }//GEN-LAST:event_botonMostrarActionPerformed

    private void botonIdentificarPuentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIdentificarPuentesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonIdentificarPuentesActionPerformed

    private void botonContarIslasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonContarIslasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonContarIslasActionPerformed

    private void actualizarEstadistica(int estadistica, String valor) {
        String estadisticasHTML = lblValoresEstadisticas.getText();
        String limpio = estadisticasHTML.replace("<html>", "").replace("</html>", "");
        String[] valoresEstadisticas = limpio.split("<br>");
        valoresEstadisticas[estadistica] = valor;
        String nuevasEstadisticas = "<html>" + String.join("<br>", valoresEstadisticas) + "</html>";
        lblValoresEstadisticas.setText(nuevasEstadisticas);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCargaArchivo;
    private javax.swing.JButton botonContarIslas;
    private javax.swing.JButton botonGuardarArchivo;
    private javax.swing.JButton botonIdentificarPuentes;
    private javax.swing.JButton botonMostrar;
    private javax.swing.JPanel botonera;
    private javax.swing.JPanel estadisticas;
    private javax.swing.JLabel lblNombreEstadisticas;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValoresEstadisticas;
    // End of variables declaration//GEN-END:variables
}
