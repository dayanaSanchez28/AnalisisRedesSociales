/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisredessociales.interfaz;

import analisisredessociales.archivos.ManejadorArchivos;
import analisisredessociales.dominio.Usuario;
import analisisredessociales.estructuras.RedSocial;
import analisisredessociales.estructuras.algoritmos.IdentificadorPuentes;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swing_viewer.SwingViewer;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.ViewerListener;
import org.graphstream.ui.view.ViewerPipe;

/**
 *
 * @author Dayana
 */
public class VentanaInicio extends javax.swing.JFrame implements ViewerListener {
    private final static String CSS_GRAFO = "node {" +
                                            "fill-color: white;" +
                                            "stroke-mode: plain;" +
                                            "stroke-color: black;" +
                                            "text-background-mode: plain;" +
                                            "text-background-color: white;" +
                                            "size: 25px;" +
                                            "}" +
                                            "node.hovered {" + 
                                            "stroke-color: darkred;" +
                                            "text-color: darkred;" + 
                                            "}" +
                                            "node.seleccionado {" + 
                                            "stroke-color: green;" +
                                            "text-color: green;" + 
                                            "}" +
                                            "graph {" +
                                            "padding: 40px;" +
                                            "}" +
                                            "edge {" +
                                            "text-alignment: above;" +
                                            "text-size: 14;" +
                                            "}" +
                                            "edge.puente {" +
                                            "stroke-mode: plain;" +
                                            "fill-color: red;"+
                                            "}" ;
    private static final int ESTADISTICA_ULTIMO_LEIDO = 0;
    private RedSocial redSocial;
    private Usuario usuarioSeleccionado;
    private Graph grafo;
    private boolean loop = true;
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

        dialogoCreacion = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        txtIdNuevoUsuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNombreNuevoUsuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtRelacionesNuevoUsuario = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        botoneraGrafo = new javax.swing.JPanel();
        botonCargaArchivo = new javax.swing.JButton();
        botonGuardarArchivo = new javax.swing.JButton();
        botonContarIslas = new javax.swing.JButton();
        botonIdentificarPuentes = new javax.swing.JButton();
        panelGrafo = new javax.swing.JPanel();
        botoneraNodos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 15), new java.awt.Dimension(0, 15), new java.awt.Dimension(32767, 20));
        jLabel2 = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 15), new java.awt.Dimension(0, 15), new java.awt.Dimension(32767, 15));
        jLabel3 = new javax.swing.JLabel();
        txtIdUsuario = new javax.swing.JTextField();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 15), new java.awt.Dimension(0, 15), new java.awt.Dimension(32767, 20));
        botonEliminar = new javax.swing.JButton();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 75), new java.awt.Dimension(0, 75), new java.awt.Dimension(32767, 75));
        botonNuevo = new javax.swing.JButton();
        estadisticas = new javax.swing.JPanel();
        lblNombreEstadisticas = new javax.swing.JLabel();
        lblValoresEstadisticas = new javax.swing.JLabel();

        dialogoCreacion.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialogoCreacion.setTitle("Añadir usuario");
        dialogoCreacion.setSize(new java.awt.Dimension(600, 400));
        dialogoCreacion.getContentPane().setLayout(new java.awt.GridLayout(4, 2));

        jLabel4.setText("ID:");
        dialogoCreacion.getContentPane().add(jLabel4);
        dialogoCreacion.getContentPane().add(txtIdNuevoUsuario);

        jLabel5.setText("Nombre usuario: @");
        dialogoCreacion.getContentPane().add(jLabel5);
        dialogoCreacion.getContentPane().add(txtNombreNuevoUsuario);

        jLabel6.setText("<html>Relaciones<br><i>(Escriba el ID y luego de 2 puntos, el tiempo de relación, separe múltiples relaciones con comas. <br>Ej: 121:5,122:4)</i></html>");
        dialogoCreacion.getContentPane().add(jLabel6);
        dialogoCreacion.getContentPane().add(txtRelacionesNuevoUsuario);

        btnGuardar.setText("Crear");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        dialogoCreacion.getContentPane().add(btnGuardar);

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
        getContentPane().add(lblTitulo, gridBagConstraints);

        botoneraGrafo.setLayout(new javax.swing.BoxLayout(botoneraGrafo, javax.swing.BoxLayout.LINE_AXIS));

        botonCargaArchivo.setText("Cargar");
        botonCargaArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCargaArchivoActionPerformed(evt);
            }
        });
        botoneraGrafo.add(botonCargaArchivo);

        botonGuardarArchivo.setText("Guardar");
        botonGuardarArchivo.setEnabled(false);
        botonGuardarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarArchivoActionPerformed(evt);
            }
        });
        botoneraGrafo.add(botonGuardarArchivo);

        botonContarIslas.setText("Contar Islas");
        botonContarIslas.setEnabled(false);
        botoneraGrafo.add(botonContarIslas);

        botonIdentificarPuentes.setText("Identificar Puentes");
        botonIdentificarPuentes.setEnabled(false);
        botonIdentificarPuentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIdentificarPuentesActionPerformed(evt);
            }
        });
        botoneraGrafo.add(botonIdentificarPuentes);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(botoneraGrafo, gridBagConstraints);

        panelGrafo.setBackground(new java.awt.Color(255, 255, 255));
        panelGrafo.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 3.0;
        getContentPane().add(panelGrafo, gridBagConstraints);

        botoneraNodos.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("<html><i>Seleccione un nodo para ver detalles</i></html>");
        jLabel1.setMaximumSize(new java.awt.Dimension(200, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        botoneraNodos.add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        botoneraNodos.add(filler3, gridBagConstraints);

        jLabel2.setText("Nombre usuario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        botoneraNodos.add(jLabel2, gridBagConstraints);

        txtNombreUsuario.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        botoneraNodos.add(txtNombreUsuario, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        botoneraNodos.add(filler1, gridBagConstraints);

        jLabel3.setText("ID usuario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        botoneraNodos.add(jLabel3, gridBagConstraints);

        txtIdUsuario.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        botoneraNodos.add(txtIdUsuario, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        botoneraNodos.add(filler2, gridBagConstraints);

        botonEliminar.setText("Eliminar");
        botonEliminar.setEnabled(false);
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        botoneraNodos.add(botonEliminar, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        botoneraNodos.add(filler4, gridBagConstraints);

        botonNuevo.setText("Añadir usuario");
        botonNuevo.setEnabled(false);
        botonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        botoneraNodos.add(botonNuevo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        getContentPane().add(botoneraNodos, gridBagConstraints);

        estadisticas.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        lblNombreEstadisticas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombreEstadisticas.setText("<html>Último archivo cargado:</html>");
        estadisticas.add(lblNombreEstadisticas);

        lblValoresEstadisticas.setText("<html>Sin archivo cargado</html>");
        estadisticas.add(lblValoresEstadisticas);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
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
            inicializarGrafo();
            actualizarEstadistica(ESTADISTICA_ULTIMO_LEIDO, ManejadorArchivos.getUltimoLeido());
            botonContarIslas.setEnabled(true);
            botonGuardarArchivo.setEnabled(true);
            botonNuevo.setEnabled(true);
            botonIdentificarPuentes.setEnabled(true);
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

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        if (usuarioSeleccionado != null) {
            redSocial.eliminar(usuarioSeleccionado);
            grafo.removeNode(String.valueOf(usuarioSeleccionado.getId()));
        }
        seleccionarUsuario(null);
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoActionPerformed
        dialogoCreacion.setVisible(true);
    }//GEN-LAST:event_botonNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String nombreUsuario = txtNombreNuevoUsuario.getText();
        String idUsuario = txtIdNuevoUsuario.getText();
        String relaciones = txtRelacionesNuevoUsuario.getText();
        int[][] relacionesProcesadas = procesarNuevasRelaciones(relaciones);
        Usuario nuevo = new Usuario(Integer.parseInt(idUsuario), "@" + nombreUsuario);
        try {
            redSocial.insertarUsuario(nuevo);
            Node nodo = grafo.addNode(idUsuario);
            nodo.setAttribute("ui.label", idUsuario);
            nodo.setAttribute("datosUsuario", nuevo);
            for (int i = 0; i < relacionesProcesadas.length; i++) {
                int[] relacion = relacionesProcesadas[i];
                redSocial.establecerRelacion(nuevo.getId(), relacion[0], relacion[1]);
                grafo.addEdge(idUsuario + "-" + relacion[0], idUsuario, String.valueOf(relacion[0])).setAttribute("ui.label", relacion[1]);
            }
            txtIdNuevoUsuario.setText("");
            txtNombreNuevoUsuario.setText("");
            txtRelacionesNuevoUsuario.setText("");
            dialogoCreacion.dispose();
            seleccionarUsuario(nuevo);
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "No se pudo insertar", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void botonIdentificarPuentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIdentificarPuentesActionPerformed
        IdentificadorPuentes identificadorPuentes = new IdentificadorPuentes(redSocial);
        Usuario[][] puentes = identificadorPuentes.identificarPuentes();
        StringBuilder sb = new StringBuilder("Se identificaron " + identificadorPuentes.getIdentificados() + " puentes:\n");
        for (int i = 0; i < identificadorPuentes.getIdentificados(); i++) {
            Usuario[] puente = puentes[i];
            sb.append(puente[0].getNombreUsuario() + " (ID=" + puente[0].getId() + ") <=> " + puente[1].getNombreUsuario() + " (ID=" + puente[1].getId() +")\n");
            grafo.getEdge(puente[0].getId() + "-" + puente[1].getId()).setAttribute("ui.class", "puente");
        }
        sb.append("Estos han sido marcados en el grafo para su visualización\n");
        JOptionPane.showMessageDialog(this, sb.toString(), "Resultados de identifiación de puentes", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_botonIdentificarPuentesActionPerformed

    private void actualizarEstadistica(int estadistica, String valor) {
        String estadisticasHTML = lblValoresEstadisticas.getText();
        String limpio = estadisticasHTML.replace("<html>", "").replace("</html>", "");
        String[] valoresEstadisticas = limpio.split("<br>");
        valoresEstadisticas[estadistica] = valor;
        String nuevasEstadisticas = "<html>" + String.join("<br>", valoresEstadisticas) + "</html>";
        lblValoresEstadisticas.setText(nuevasEstadisticas);
    }
    
    @Override
    public void viewClosed(String string) {
        loop = false;
    }

    @Override
    public void buttonPushed(String string) {
        System.out.println("buttonPushed" + string);
    }

    @Override
    public void buttonReleased(String string) {
        Node nodo = grafo.getNode(string);
        if (nodo != null) {
            Usuario usuario = nodo.getAttribute("datosUsuario", Usuario.class);
            seleccionarUsuario(usuario);
        }
    }

    @Override
    public void mouseOver(String id) {
        Node nodo = grafo.getNode(id);
        if (!nodo.hasAttribute("ui.class")) {
            nodo.setAttribute("ui.class", "hovered");
        }
    }

    @Override
    public void mouseLeft(String string) {
        Node nodo = grafo.getNode(string);
        if ("hovered".equals(nodo.getAttribute("ui.class", String.class))) {
            nodo.removeAttribute("ui.class");    
        }
    }

    private int[][] procesarNuevasRelaciones(String relaciones) {
        String[] listaRelaciones = relaciones.split(",");
        int[][] procesadas = new int[listaRelaciones.length][2];
        String noProcesadas = "";
        for (int i = 0; i < listaRelaciones.length; i++) {
            String rel = listaRelaciones[i];
            String[] componentes = rel.split(":");
            if (componentes.length == 2) {
                try {
                    int id = Integer.parseInt(componentes[0]);
                    int tiempo = Integer.parseInt(componentes[1]);
                    procesadas[i] = new int[] {id, tiempo};
                } catch (NumberFormatException e) {
                    noProcesadas += e.getMessage();
                }
            }
        }
        
        if (!noProcesadas.isBlank()) {
            JOptionPane.showMessageDialog(this, "Ocurrieron los siguientes errores: \n" + noProcesadas + "\nLas relaciones que sí pudieron ser procesadas se agregarán", "Errores al procesar relaciones", JOptionPane.WARNING_MESSAGE);
        }
        
        return procesadas;
    }
    
    private void seleccionarUsuario(Usuario usuario) {
        if (usuarioSeleccionado != null) {
            grafo.getNode(String.valueOf(usuarioSeleccionado.getId()))
                    .removeAttribute("ui.class");
        }
        usuarioSeleccionado = usuario;
        txtIdUsuario.setText(usuario == null ? "" : String.valueOf(usuario.getId()));
        txtNombreUsuario.setText(usuario == null ? "" : usuario.getNombreUsuario());
        botonEliminar.setEnabled(usuario != null);
        if (usuario != null) {
            grafo.getNode(String.valueOf(usuario.getId()))
                    .setAttribute("ui.class", "seleccionado");
        }
    }
    
    private void inicializarGrafo() {
        // construimos grafo visual a partir de la red social
        grafo = crearGrafoUI();
        // embeber grafo en el panel destinado para ello
        SwingViewer swingViewer = new SwingViewer(grafo, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        swingViewer.enableAutoLayout();
        ViewPanel view = (ViewPanel) swingViewer.addDefaultView(false);
        view.enableMouseOptions();
        grafo.setAttribute("ui.stylesheet", CSS_GRAFO);
        grafo.setAttribute("ui.quality");
        grafo.setAttribute("ui.antialias");
        grafo.setAttribute("layout.force", 0.2);
        grafo.setAttribute("layout.quality", 4);
        grafo.setAttribute("layout.stabilization-limit", 0.3);
        panelGrafo.add(view);
        // Empezar a escuchar eventos
        ViewerPipe pipe = swingViewer.newViewerPipe();
        pipe.addViewerListener(this);
        pipe.addSink(grafo);
        Thread t = new Thread(() -> {
            while (loop) {
                pipe.pump();
            }
        });
        t.start();
    }
    
    private Graph crearGrafoUI() {
        Graph grafo = new SingleGraph("Red Social", false, true);
        int[][] relaciones = redSocial.getRelaciones();
        Usuario[] usuarios = redSocial.getUsuarios();
        for (int i = 0; i < redSocial.getSize(); i++) {
            int[] fila = relaciones[i];
            Usuario usuarioA = usuarios[i];
            for (int j = i; j < redSocial.getSize(); j++) {
                Usuario usuarioB = usuarios[j];
                int tiempo = relaciones[i][j];
                if (tiempo != 0) {
                    Edge arista = grafo.addEdge(usuarioA.getId() + "-" + usuarioB.getId(), String.valueOf(usuarioA.getId()), String.valueOf(usuarioB.getId()));
                    arista.setAttribute("ui.label", String.valueOf(tiempo));
                }
            }
            Node nodo = grafo.getNode(String.valueOf(usuarioA.getId()));
            if (null == nodo) {
                nodo = grafo.addNode(String.valueOf(usuarioA.getId()));
                
            }
            nodo.setAttribute("ui.label", String.valueOf(usuarioA.getId()));
            nodo.setAttribute("datosUsuario", usuarioA);
        }
        
        return grafo;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCargaArchivo;
    private javax.swing.JButton botonContarIslas;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonGuardarArchivo;
    private javax.swing.JButton botonIdentificarPuentes;
    private javax.swing.JButton botonNuevo;
    private javax.swing.JPanel botoneraGrafo;
    private javax.swing.JPanel botoneraNodos;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JDialog dialogoCreacion;
    private javax.swing.JPanel estadisticas;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblNombreEstadisticas;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValoresEstadisticas;
    private javax.swing.JPanel panelGrafo;
    private javax.swing.JTextField txtIdNuevoUsuario;
    private javax.swing.JTextField txtIdUsuario;
    private javax.swing.JTextField txtNombreNuevoUsuario;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtRelacionesNuevoUsuario;
    // End of variables declaration//GEN-END:variables
}
