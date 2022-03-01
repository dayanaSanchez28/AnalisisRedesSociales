/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisredessociales.estructuras;

/**
 * Tabla hash sencilla cuyo propósito es acelerar la búsqueda de indices en el grafo
 * @author Dayana
 */
public class TablaIndices {
    private FilaIndice[] filas;
    private int filasLlenas = 0;
    public TablaIndices(int size) {
        this.filas = new FilaIndice[size];
    }
    
    /**
     * INserta una nueva entrada en la tabla hash
     * @param id El ID del usuario
     * @param indice El indice del usuario dentro del array del grafo
     */
    public void insertar(int id, int indice) {
        int fila = funcionHash(id);
        FilaIndice nuevaFila = new FilaIndice(id, indice);
        if (!ocupado(fila)) {
            filas[fila] = nuevaFila;
        } else {
            FilaIndice nodo = filas[fila];
            while (nodo.siguiente != null) {
                if (nodo.id == id) {
                    throw new RuntimeException("ID " + id + " ya existe");
                }
                nodo = nodo.siguiente;
            }
            if (nodo.id == id) {
                throw new RuntimeException("ID " + id + " ya existe");
            }
            nodo.siguiente = nuevaFila;
        }
        filasLlenas++;
    }
    
    /**
     * Obtiene el indice de un usuario apartir de su ID
     * @param id el ID del usuario
     * @return el indice del usuario dentro del array del grafo
     */
    public int getIndice(int id) {
        int numFila = funcionHash(id);
        // Revisamos si está ocupado
        if (!ocupado(numFila)) {
            return -1;
        }
        FilaIndice nodo = filas[numFila];
        while (nodo != null && nodo.id != id) {
            nodo = nodo.siguiente;
        }
        
        return nodo == null ? -1 : nodo.indice;
    }
    
    /**
     * Determina si una fila está ocupada
     * @param fila la fila a revisar
     * @return 
     */
    private boolean ocupado(int fila) {
        return filas[fila] != null;
    }
    
    /**
     * función de hash para el almacenamiento eficiente dentro de la tabla
     * @param id el ID a hashear
     * @return el ID hasheado
     */
    private int funcionHash(int id) {
        return (filas.length - 1) & Integer.hashCode(id);
    }
    
    /**
     * Clase interna que representa una entrada de la tabla hash.
     */
    private class FilaIndice {
        private final int id;
        private final int indice;
        private FilaIndice siguiente;

        public FilaIndice(int id, int indice) {
            this.id = id;
            this.indice = indice;
        }
    }
    
    public void eliminar(int id) {
        int fila = funcionHash(id);
        if (!ocupado(fila)) {
            return;
        }
        FilaIndice fi = filas[fila];
        if (fi.id == id) {
            filas[fila] = fi.siguiente;
        } else {
            while (fi.siguiente != null && fi.siguiente.id != id) {
                fi = fi.siguiente;
            }
            if (fi.siguiente != null && fi.siguiente.id == id) {
                fi.siguiente = fi.siguiente.siguiente;
                fi.siguiente = null;
            }
        }
    }
}
