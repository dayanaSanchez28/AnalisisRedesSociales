/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisredessociales.estructuras;

import analisisredessociales.dominio.Usuario;

/**
 * Clase meramente utilitaria que representa un Nodo de un Usuario
 * @author Dayana
 */
public class NodoUsuario {
    private final Usuario usuario;
    private NodoUsuario siguiente;

    public NodoUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public NodoUsuario getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoUsuario siguiente) {
        this.siguiente = siguiente;
    }
    
}
