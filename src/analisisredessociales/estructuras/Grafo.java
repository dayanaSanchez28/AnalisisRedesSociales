/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisredessociales.estructuras;

import java.util.ArrayList;

public class Grafo
{

    public int [][] adjmatrix; 
    public int vertices;


    public Grafo(int vertices) 
    {
        adjmatrix = new int[vertices][vertices];            
        this.vertices = vertices;                           


    }

    public void addEdge(String nombreUsuario, int id)
    {
        if(getvertices(nombreUsuario) == -1)
        {

        }
    }


    public int[] recorrido(int vertice) 
    {

        ArrayList<Integer> recorrido = new ArrayList<>(); 

        for (int i = 0; i < vertices; i++) {

            if(adjmatrix[vertice][i] == 0)
            {
                recorrido.add(i);
            }
        }

        int size = recorrido.size();

        int[] neighbor = new int[size];

        for(int i = 0; i < size; i++){

            neighbor[i] = recorrido.get(i);
        }
        return neighbor;
    }

    public void camino(String nombreUsuario, int id)
    {

    }

    private int getvertices(String nombreUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}