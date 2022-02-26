/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisredessociales.estructuras;

import analisisredessociales.dominio.Usuario;
import analisisredessociales.estructuras.RedSocial;

// Java program to count islands in boolean 2D matrix
import java.util.*;
import java.lang.*;
import java.io.*;

class Islas {

	static final int FILA = 5, COL = 5;

	boolean perimetro(int M[][], int fila, int columna,
				boolean visitado[][])
	{

		return (fila >= 0) && (fila < FILA) && (columna >= 0) && (columna < COL) && (M[fila][columna] == 1 && !visitado[fila][columna]);
	}

	void DFS(int M[][], int fila, int columna, boolean visitado[][])
	{
		int filaNbr[] = new int[] {};
		int columnaNbr[] = new int[] {};

		// Mark this cell as visited
		visitado[fila][columna] = true;

		// Recur for all connected neighbours
		for (int k = 0; k < 8; ++k)
			if (perimetro(M, fila + filaNbr[k], columna + columnaNbr[k], visitado))
				DFS(M, fila + filaNbr[k], columna + columnaNbr[k], visitado);
	}

	int contIslas(int M[][])
	{

		boolean visitado[][] = new boolean[FILA][COL];

		int cont = 0;
		for (int i = 0; i < FILA; ++i)
			for (int j = 0; j < COL; ++j)
				if (M[i][j] == 1 && !visitado[i][j])
				{ DFS(M, i, j, visitado); 
                                ++cont;}

		return cont;
	}

	public static void main(String[] args) throws java.lang.Exception
	{
		int M[][] = new int[][] { {},};
		Islas I = new Islas();
		System.out.println("El total es : " + I.contIslas(M));
	}
}
