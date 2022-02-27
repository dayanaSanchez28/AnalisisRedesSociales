/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisredessociales.estructuras.algoritmos;

import analisisredessociales.dominio.Usuario;
import analisisredessociales.estructuras.RedSocial;

/**
 *
 * @author Dayana
 */
public class IdentificadorPuentes {
    private int tiempo = 0;
    private int identificados = 0;
    private RedSocial redSocial;
    private int[][] matrizAdyacencia;
    private Usuario[][] resultados;

    public IdentificadorPuentes(RedSocial redSocial) {
        this.redSocial = redSocial;
        this.matrizAdyacencia = this.redSocial.getRelaciones();
    }
    
    private void dfsRecursivo(int nodoActual, boolean[] visitados, int[] tDescubrimiento, int[] tBajo, int[] padre) {
        // Marcamos el nodo actual como visitado
        visitados[nodoActual] = true;
        // Inicializamos el tiempo de descubrimiento de este nodo, el cual será su tiempo más bajo, igualmente
        tDescubrimiento[nodoActual] = tBajo[nodoActual] = ++tiempo;
        
        // Iteración sobre todos los nodos adyacentes. Al ser una matriz de un grafo ponderado,
        // los adyacentes son aquellos nodos cuya relación sea mayor a 0
        for (int i = 0; i < redSocial.getSize(); i++) {
            if (matrizAdyacencia[nodoActual][i] == 0) {
                continue; // No hay adyacencia
            }
            // i es el indice del nodo adyacente.
            // si no está visitado, marcamos el nodo actual como padre del adyacente
            if (!visitados[i]) {
                padre[i] = nodoActual;
                // vamos recursivamente a los nodos adyacentes no visitados para calcular sus tiempos de descubrimiento
                dfsRecursivo(i, visitados, tDescubrimiento, tBajo, padre);
                
                // Verificamos si el tiempo bajo del nodo adyacente es mejor que el tiempo bajo del nodo actual.
                // Si es mejor, actualizamos el tiempo bajo del nodo actual. Esto indica que el nodo adyacente 
                // tiene alguna conexión con algún nodo padre del nodo actual
                tBajo[nodoActual] = Math.min(tBajo[nodoActual], tBajo[i]);
                
                // Si el tiempo más bajo de descubrimiento del adyacente es mayor que el tiempo de descubrimiento
                // del nodo actual, entonces no hay otra forma de llegar al adyacente más que el nodo actual
                // por tanto, esta arista es un puente
                if (tBajo[i] > tDescubrimiento[nodoActual]) {
                    // Añadimos a nuestra lista de resultados
                    resultados[identificados++] = new Usuario[] {redSocial.getUsuarios()[nodoActual], redSocial.getUsuarios()[i]};
                }
            } else if (i != padre[nodoActual]) {
                // si el nodo adyacente no es padre del nodo actual, 
                // actualizamos el tiempo bajo del nodo actual para las llamadas padre del nodo actual
                tBajo[nodoActual] = Math.min(tBajo[nodoActual], tDescubrimiento[i]);
            }
        }
    }
    
    public Usuario[][] identificarPuentes() {
        int size = redSocial.getSize();
        boolean[] visitados = new boolean[size];
        int[] tDescubrimiento = new int[size];
        int[] tBajos = new int[size];
        int[] padres = new int[size];
        resultados = new Usuario[redSocial.getNumeroRelaciones()][2];
        // Aplicamos dfs para todos los nodos no visitados
        for (int i = 0; i < size; i++) {
            if (!visitados[i]) {
                dfsRecursivo(i, visitados, tDescubrimiento, tBajos, padres);
            }
        }
        return resultados;
    }

    public int getIdentificados() {
        return identificados;
    }
}
