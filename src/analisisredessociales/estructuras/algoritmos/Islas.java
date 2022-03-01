/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisredessociales.estructuras.algoritmos;

import analisisredessociales.estructuras.Cola;
import analisisredessociales.estructuras.Pila;
import analisisredessociales.estructuras.RedSocial;

/**
 * Clase utilitaria para el conteo de islas en una red social, que soporta dfs y bfs
 * @author Dayana
 */
public class Islas {

    private RedSocial redSocial;
    private int[][] ordenRecorrido;
    private int recuentoVisitas = 0;
    private int numIslas = 0;

    public Islas(RedSocial redSocial) {
        this.redSocial = redSocial;
        this.ordenRecorrido = new int[redSocial.getSize()][redSocial.getSize()];
    }

    /**
     * implementación iterativa del algoritmo DFS usando una Pila
     * @param iNodo el nodo de inicio
     * @param visitado el vector de nodos visitados
     */
    private void DFS(int iNodo, boolean[] visitado) {
        Pila pila = new Pila();
        pila.insertar(iNodo);
        while (!pila.estaVacia()) {
            // Siguiente nodo a procesar en la pila
            int sig = pila.siguiente();
            // Cargamos las relaciones de este nodo
            int[] relacionesNodo = redSocial.getRelaciones()[sig];
            // Verificamos que no haya sido visitado
            if (!visitado[sig]) {
                // Lo marcamos como visitado
                visitado[sig] = true;
                // Usamos + 1 para usar indices basados en 1. Esto prevendrá
                // confundir el 0 del primer elemento con el 0 de elementos de la matriz que no fueron llenados
                ordenRecorrido[numIslas][recuentoVisitas++] = sig + 1;
                for (int i = 0; i < redSocial.getSize(); i++) {
                    // nos aseguramos que esta relación exista (> 0) y que el nodo de esa relación no haya sido visitado
                    if (relacionesNodo[i] > 0 && !visitado[i]) {
                        // Si no está visitado y la relación existe, apilamos
                        pila.insertar(i);
                    }
                }
            }
        }
    }

    /**
     * implementación iterativa del algoritmo BFS usando una Cola
     * @param iNodo el nodo de inicio
     * @param visitado el vector de nodos visitados
     */
    private void BFS(int iNodo, boolean[] visitado) {
        Cola cola = new Cola();
        cola.insertar(iNodo);
        while (!cola.estaVacia()) {
            // Siguiente nodo a procesar en la cola
            int sig = cola.siguiente();
            // Cargamos las relaciones de este nodo
            int[] relacionesNodo = redSocial.getRelaciones()[sig];
            if (!visitado[sig]) {
                visitado[sig] = true;
                // Usamos + 1 para usar indices basados en 1. Esto prevendrá
                // confundir el 0 del primer elemento con el 0 de elementos de la matriz que no fueron llenados
                ordenRecorrido[numIslas][recuentoVisitas++] = sig + 1;
                for (int i = 0; i < redSocial.getSize(); i++) {
                    // nos aseguramos que esta relación exista (> 0) y que el nodo de esa relación no haya sido visitado
                    if (relacionesNodo[i] > 0 && !visitado[i]) {
                        // Si no está visitado y la relación existe, apilamos
                        cola.insertar(i);
                    }
                }
            }
        }
    }

    /**
     * Inicializa un conteo de islas usando DFS, y devuelve el resultado. 
     * La trazadel recorrido queda almacenada en ordenRecorrido
     * @return 
     */
    private int conteoDfs() {
        boolean visitado[] = new boolean[redSocial.getSize()];
        for (int i = 0; i < redSocial.getSize(); i++) {
            if (!visitado[i]) {
                recuentoVisitas = 0;
                DFS(i, visitado);
                numIslas++;
            }
        }
        return numIslas;
    }

    /**
     * Inicializa un conteo de islas usando BFS y devuelve el resultado.
     * La traza del recorrido qeda almacenada en ordenRecorrido
     * @return 
     */
    private int conteoBfs() {
        boolean visitado[] = new boolean[redSocial.getSize()];
        for (int i = 0; i < redSocial.getSize(); i++) {
            if (!visitado[i]) {
                recuentoVisitas = 0;
                BFS(i, visitado);
                numIslas++;
            }
        }
        return numIslas;
    }

    /**
     * Conteo de islas en el grafo mediante un algoritmo soportado (DFS O BFS)
     * @param algoritmo DFS O BFS, los algoritmos de recorrido soportados
     * @return la cantidad de islas
     */
    public int contIslas(String algoritmo) {
        switch (algoritmo) {
            case "DFS":
                return this.conteoDfs();
            case "BFS":
                return this.conteoBfs();
            default:
                throw new RuntimeException("Algoritmo no reconocido: " + algoritmo);
        }
    }

    public int[][] getOrdenRecorrido() {
        return ordenRecorrido;
    }
}
