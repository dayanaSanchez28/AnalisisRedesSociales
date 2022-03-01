/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisredessociales.estructuras;

import analisisredessociales.dominio.Usuario;

/**
 * Lista simplemente enlazada de usuarios
 * @author Dayana
 */
public class ListaUsuarios {
    private NodoUsuario cabeza = null;
    private int size = 0;

    /**
     * Inserta un nuevo usuario en la lista simplemente enlazada (inserción por cola)
     * @param usuario 
     */
    public void insertar(Usuario usuario) {
        NodoUsuario nodo = new NodoUsuario(usuario);
        if (cabeza == null) {
            cabeza = nodo;
        } else {
            NodoUsuario aux = cabeza;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nodo);
        }
        size++;
    }

    public int getSize() {
        return size;
    }

    public NodoUsuario getCabeza() {
        return cabeza;
    }
}
