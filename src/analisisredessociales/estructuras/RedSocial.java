/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisredessociales.estructuras;

import analisisredessociales.dominio.Usuario;

/**
 * Grafo de Usuarios que usa matriz de adyacencia para la gestión de relaciones
 * @author Dayana
 */
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

    /**
     * Método utilitario para procesar los datos de una red social como un string y crear una instancia a partir de esta
     * @param contenido El contenido a procesar
     * @return 
     */
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

    /**
     * Inserta un nuevo usuario en la Red Social, equivalente a insertar un nodo en el grafo
     * @param usuario el Usuario a insertar
     */
    public void insertarUsuario(Usuario usuario) {
        if (size == MAX_SIZE) {
            throw new RuntimeException("No se pueden insertar más usuarios en la Red Social");
        }
        usuarios[size] = usuario;
        tablaIndices.insertar(usuario.getId(), size++);
    }

    /**
     * Crea una nueva relación entre 2 usuarios con un tiempo determinado, equivalente a crear una arista en el grafo
     * @param a uno de los usuarios de la relación
     * @param b el otro usuario de la relación
     * @param tiempo el tiempo que se conocen
     */
    public void establecerRelacion(Usuario a, Usuario b, int tiempo) {
        establecerRelacion(a.getId(), b.getId(), tiempo);
    }

    /**
     * @inheritDoc
     */
    public void establecerRelacion(int idA, int idB, int tiempo) {
        int indiceA = encontrarIndiceId(idA);
        int indiceB = encontrarIndiceId(idB);
        if (indiceA != -1 && indiceB != -1) {
            relaciones[indiceA][indiceB] = tiempo;
            relaciones[indiceB][indiceA] = tiempo;
        }
    }

    /**
     * Devuelve el indice de un usuario dentro del grafo a partir de su ID
     * @param id el id a usuario a encontrar
     * @return el indice del usuario
     */
    private int encontrarIndiceId(int id) {
        return tablaIndices.getIndice(id);
    }

    /**
     * Devuelve una representación en string de la Red Social que se puede usar para volver a recrearla con el método de importación
     * @return 
     */
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

    /**
     * Devuelve la cantidad de usuarios, equivalente a getSize
     * @return 
     */
    public int getNumeroUsuarios() {
        return getSize();
    }

    /**
     * Devuelve la cantidad de relaciones que hay en la red social, equivalente al numero de aristas
     * @return 
     */
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

    /**
     * Devuelve la cantidad de usuarios en la Red Social, equivalente al número de nodos en el grafo.
     * @return el tamaño del grafo
     */
    public int getSize() {
        return size;
    }

    /**
     * Devuelve el array de Usuarios de la Red Social.
     * @return el array de usuarios
     */
    public Usuario[] getUsuarios() {
        return usuarios;
    }

    /**
     * Devuelve la matriz de adyacencia de la Red Social
     * @return la matriz de adyacencia de la red social
     */
    public int[][] getRelaciones() {
        return relaciones;
    }

    /**
     * Elimina un usuario especifico de la Red Social.
     * Este proceso consiste en correr todos los usuarios a la derecha de este, un espacio a la izquierda, lo mismo con sus relaciones
     * @param usuario 
     */
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
