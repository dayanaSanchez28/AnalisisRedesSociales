/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisredessociales.estructuras;

import analisisredessociales.dominio.Usuario;
import java.util.Arrays;


public class RedSocial {
    private Usuario[] usuarios;
    private final TablaIndices tablaIndices;
    private int[][] relaciones;
    private int size = 0;

    /**
     * Crea un nuevo grafo de red social vacío
     * @param size El tamaño de la red social
     */
    public RedSocial(int size) {
        this.usuarios = new Usuario[size];
        this.relaciones = new int[size][size];
        this.tablaIndices = new TablaIndices(size);
    }
    
    public static RedSocial importar(String contenido) {
        String[] lineas = contenido.split("\n");
        ListaUsuarios listaImportacion = new ListaUsuarios();
        boolean eindicetraccionUsuariosCompleta = false;
        int i = 0;
        for (; !eindicetraccionUsuariosCompleta; i++) {
            String linea = lineas[i].trim();
            if ("Relaciones".equals(linea)) {
                eindicetraccionUsuariosCompleta = true;
            } else if (!"Usuarios".equals(linea)) {
                String[] componentes = linea.split(", ");
                if (componentes.length == 2) {
                    // usuario
                    int id = Integer.parseInt(componentes[0]);
                    String nombreUsuario = componentes[1];
                    listaImportacion.insertar(new Usuario(id, nombreUsuario));
                }
            }
        }
        RedSocial redSocial = new RedSocial(listaImportacion.getSize());
        NodoUsuario nodo = listaImportacion.getCabeza();
        while (nodo != null) {
            redSocial.insertarUsuario(nodo.getUsuario());
            nodo = nodo.getSiguiente();
        }
        
        for (; i < lineas.length; i++) {
            String linea = lineas[i].trim();
            String[] componentes = linea.split(", ");
            if (componentes.length == 3) {
                // relacion
                int idA = Integer.parseInt(componentes[0]);
                int idB = Integer.parseInt(componentes[1]);
                int tiempo = Integer.parseInt(componentes[2]);
                redSocial.establecerRelacion(idA, idB, tiempo);
            }
        }
        
        return redSocial;
    }
    
    public void insertarUsuario(Usuario usuario) {
        if (size == usuarios.length - 1) {
            int longitudActual = usuarios.length;
            int nuevaLongitud = (int) (longitudActual * 1.5);
            // Llegamos al limite, eindicepandamos los arrays internos
            usuarios = Arrays.copyOf(usuarios, nuevaLongitud);
            relaciones = Arrays.copyOf(relaciones, nuevaLongitud);
            for (int i = 0; i < nuevaLongitud; i++) {
                relaciones[i] = relaciones[i] == null 
                        ? new int[nuevaLongitud]
                        : Arrays.copyOf(relaciones[i], nuevaLongitud);
            }
        }
        usuarios[size] = usuario;
        tablaIndices.insertar(usuario.getId(), size++);
    }
    
    public void establecerRelacion(Usuario a, Usuario b, int tiempo) {
        establecerRelacion(a.getId(), b.getId(), tiempo);
    }
    
    public void establecerRelacion(int idA, int idB, int tiempo) {
        int indiceA = encontrarIndiceId(idA);
        int indiceB = encontrarIndiceId(idB);
        if (indiceA != -1 && indiceB != -1) {
            relaciones[indiceA][indiceB] = tiempo;
            relaciones[indiceB][indiceA] = tiempo;
        }
    }
    
    private int encontrarIndiceId(int id) {
        return tablaIndices.getIndice(id);
    }
    
    public String exportar() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuarios\n");
        for (int i = 0; i < size; i++) {
            Usuario u = usuarios[i];
            sb.append(u.getId()).append(", ").append(u.getNombreUsuario()).append("\n");
        }
        sb.append("Relaciones\n");
        for (int i = 0; i < size; i++) {
            Usuario usuarioA = usuarios[i];
            for (int j = i; j < size; j++) {
                Usuario usuarioB = usuarios[j];
                if (relaciones[i][j] != 0) {
                    sb.append(usuarioA.getId()).append(", ").append(usuarioB.getId()).append(", ").append(relaciones[i][j]).append("\n");
                }
            }
            
        }
        
        return sb.toString();
    }

    public int getNumeroUsuarios() {
        return getSize();
    }
    
    public int getNumeroRelaciones() {
        int num = 0;
        for (int i = 0; i < relaciones.length; i++) {
            for (int j = i; j < relaciones.length; j++) {
                if (relaciones[i][j] != 0) {
                    num++;
                }
            }
            
        }
        return num;
    }

    public int getSize() {
        return size;
    }

    public Usuario[] getUsuarios() {
        return usuarios;
    }

    public int[][] getRelaciones() {
        return relaciones;
    }
    
    public void eliminar(Usuario usuario) {
        int indice = tablaIndices.getIndice(usuario.getId());
        // TODO: Implementar método de eliminación del grafo
        for (int i = indice; i < size; i++) {
            usuarios[i] = usuarios[i + 1];
        }
        while (indice < size) {
            for (int i = 0; i < size; ++i) {
                relaciones[i][indice] = relaciones[i][indice + 1];
            }
            for (int i = 0; i < size; ++i) {
                relaciones[indice][i] = relaciones[indice + 1][i];
            }
            indice++;
        }
 
        size--;
        tablaIndices.eliminar(usuario.getId());
    }

    public String cont() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    class Islas{

	static final int FILA = 5, COL = 5;

	boolean perimetro(int M[][], int fila, int columna,
				boolean visitado[][])
	{

		return (fila >= 0) && (fila < FILA) && (columna >= 0) && (columna < COL) && (M[fila][columna] == 1 && !visitado[fila][columna]);
	}

	String DFS(int M[][], int fila, int columna, boolean visitado[][]){
		int filaNbr[] = new int[] {};
		int columnaNbr[] = new int[] {};

		visitado[fila][columna] = true;

		for (int k = 0; k < 8; ++k)
			if (perimetro(M, fila + filaNbr[k], columna + columnaNbr[k], visitado))
				DFS(M, fila + filaNbr[k], columna + columnaNbr[k], visitado);
            return "";
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

	public void main(String[] args) throws java.lang.Exception
	{
		int M[][] = new int[][] { {},};
		Islas I = new Islas();
		System.out.println("El total es : " + I.contIslas(M));
	}
}
}
