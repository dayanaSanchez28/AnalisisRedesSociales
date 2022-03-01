/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisredessociales.estructuras;

/**
 * Cola de enteros sencilla
 * @author Dayana
 */
public class Cola {
    private Nodo cabeza;
    
    /**
     * Determina si hay elementos en la cola
     * @return 
     */
    public boolean estaVacia() {
        return cabeza == null;
    }
    
    /**
     * Inserta un numero en la cola
     * @param n el numero a insertar
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
     * Devuelve el siguiente entero en la cola. 
     * @return 
     */
    public int siguiente() {
        if (cabeza == null) {
            return -1;
        }
        int n = cabeza.valor;
        cabeza = cabeza.siguiente;
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
