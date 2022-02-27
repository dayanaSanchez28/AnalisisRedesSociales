/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisredessociales.estructuras;

import analisisredessociales.dominio.Usuario;
import java.util.Arrays;


public class RedSocial {
    private Usuario[] usuarios;
    private final TablaIndices tablaIndices;
    private int[][] relaciones;
    private int size = 0;
    private static int MAX_SIZE = 100;

    /**
     * Crea un nuevo grafo de red social vacío
     */
    public RedSocial() {
        this.usuarios = new Usuario[MAX_SIZE];
        this.relaciones = new int[MAX_SIZE][MAX_SIZE];
        this.tablaIndices = new TablaIndices(MAX_SIZE);
    }
    
    public static RedSocial importar(String contenido) {
        String[] lineas = contenido.split("\n");
        ListaUsuarios listaImportacion = new ListaUsuarios();
        boolean extraccionUsuariosCompleta = false;
        int i = 0;
        for (; !extraccionUsuariosCompleta; i++) {
            String linea = lineas[i].trim();
            if ("Relaciones".equals(linea)) {
                extraccionUsuariosCompleta = true;
            } else if (!"Usuarios".equals(linea)) {
                String[] componentes = linea.split(", ?");
                if (componentes.length == 2) {
                    // usuario
                    int id = Integer.parseInt(componentes[0]);
                    String nombreUsuario = componentes[1];
                    listaImportacion.insertar(new Usuario(id, nombreUsuario));
                }
            }
        }
        RedSocial redSocial = new RedSocial();
        NodoUsuario nodo = listaImportacion.getCabeza();
        while (nodo != null) {
            redSocial.insertarUsuario(nodo.getUsuario());
            nodo = nodo.getSiguiente();
        }
        
        for (; i < lineas.length; i++) {
            String linea = lineas[i].trim();
            String[] componentes = linea.split(", ?");
            if (componentes.length == 3) {
                // relacion
                int idA = Integer.parseInt(componentes[0]);
                int idB = Integer.parseInt(componentes[1]);
                int tiempo = Integer.parseInt(componentes[2]);
                redSocial.establecerRelacion(idA, idB, tiempo);
            }
        }
        
        return redSocial;
    }
    
    public void insertarUsuario(Usuario usuario) {
        if (size == MAX_SIZE) {
            throw new RuntimeException("No se pueden insertar más usuarios en la Red Social");
        }
        usuarios[size] = usuario;
        tablaIndices.insertar(usuario.getId(), size++);
    }
    
    public void establecerRelacion(Usuario a, Usuario b, int tiempo) {
        establecerRelacion(a.getId(), b.getId(), tiempo);
    }
    
    public void establecerRelacion(int idA, int idB, int tiempo) {
        int indiceA = encontrarIndiceId(idA);
        int indiceB = encontrarIndiceId(idB);
        if (indiceA != -1 && indiceB != -1) {
            relaciones[indiceA][indiceB] = tiempo;
            relaciones[indiceB][indiceA] = tiempo;
        }
    }
    
    private int encontrarIndiceId(int id) {
        return tablaIndices.getIndice(id);
    }
    
    public String exportar() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuarios\n");
        for (int i = 0; i < size; i++) {
            Usuario u = usuarios[i];
            sb.append(u.getId()).append(", ").append(u.getNombreUsuario()).append("\n");
        }
        sb.append("Relaciones\n");
        for (int i = 0; i < size; i++) {
            Usuario usuarioA = usuarios[i];
            for (int j = i; j < size; j++) {
                Usuario usuarioB = usuarios[j];
                if (relaciones[i][j] != 0) {
                    sb.append(usuarioA.getId()).append(", ").append(usuarioB.getId()).append(", ").append(relaciones[i][j]).append("\n");
                }
            }
            
        }
        
        return sb.toString();
    }

    public int getNumeroUsuarios() {
        return getSize();
    }
    
    public int getNumeroRelaciones() {
        int num = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (relaciones[i][j] != 0) {
                    num++;
                }
            }
            
        }
        return num;
    }

    public int getSize() {
        return size;
    }

    public Usuario[] getUsuarios() {
        return usuarios;
    }

    public int[][] getRelaciones() {
        return relaciones;
    }
    
    public void eliminar(Usuario usuario) {
        int indice = tablaIndices.getIndice(usuario.getId());
        // TODO: Implementar método de eliminación del grafo
        for (int i = indice; i < size; i++) {
            usuarios[i] = usuarios[i + 1];
        }
        while (indice < size) {
            for (int i = 0; i < size; ++i) {
                relaciones[i][indice] = relaciones[i][indice + 1];
            }
            for (int i = 0; i < size; ++i) {
                relaciones[indice][i] = relaciones[indice + 1][i];
            }
            indice++;
        }
 
        size--;
        tablaIndices.eliminar(usuario.getId());
    }
}
