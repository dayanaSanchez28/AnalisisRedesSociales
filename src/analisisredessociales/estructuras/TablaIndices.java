/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisredessociales.estructuras;

import java.util.Arrays;

public class TablaIndices {
    private FilaIndice[] filas;
    private int filasLlenas = 0;
    public TablaIndices(int size) {
        this.filas = new FilaIndice[size];
    }
    
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
    
    private boolean ocupado(int fila) {
        return filas[fila] != null;
    }
    
    private int funcionHash(int id) {
        return (filas.length - 1) & Integer.hashCode(id);
    }
    
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
