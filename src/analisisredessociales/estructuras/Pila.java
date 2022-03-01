/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisredessociales.estructuras;

/**
 * Pila de enteros sencilla
 * @author Dayana
 */
public class Pila {

    private Nodo cabeza;
    
    /**
     * Determina si la pila está vacía
     * @return 
     */
    public boolean estaVacia() {
        return cabeza == null;
    }

    /**
     * Inserta un nuevo entero en la pila
     * @param n 
     */
    public void insertar(int n) {
        Nodo nodo = new Nodo(n);
        if (cabeza == null) {
            cabeza = nodo;
        } else {
            Nodo tmp = cabeza;
            while (tmp.siguiente != null) {
                tmp = tmp.siguiente;
            }
            tmp.siguiente = nodo;
        }
    }

    /**
     * Devuelve y quita el siguiente entero en la pila.
     * @return 
     */
    public int siguiente() {
        if (cabeza == null) {
            return -1;
        }
        if (cabeza.siguiente == null) {
            int n = cabeza.valor;
            cabeza = null;
            return n;
        }
        Nodo tmp = cabeza;
        while (tmp.siguiente.siguiente != null) {
            tmp = tmp.siguiente;
        }
        int n = tmp.siguiente.valor;
        tmp.siguiente = tmp.siguiente.siguiente;
        return n;
    }

    private class Nodo {

        int valor;
        Nodo siguiente;

        public Nodo(int valor) {
            this.valor = valor;
        }
    }
}
