/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisredessociales.dominio;

/**
 * Usuario de la Red Social, un objeto sencillo que guarda información sobre el id y el nombre de usuario.
 * No tiene métodos más que los getters y setters convencionales
 * @author Dayana
 */
public class Usuario {
    private int id;
    private String nombreUsuario;

    public Usuario(int id, String nombreUsuario) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombreUsuario=" + nombreUsuario + '}';
    }
}
