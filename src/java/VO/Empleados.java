/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author fernando stiven
 */
public class Empleados {

    private String nombre;
    private int Cedula;
    private String contrasenia;
    private String usuario;

    public Empleados(String nombre, int Cedula, String contrasenia, String usuario) {
        this.nombre = nombre;
        this.Cedula = Cedula;
        this.contrasenia = contrasenia;
        this.usuario = usuario;
    }

    
    public Empleados() {
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int Cedula) {
        this.Cedula = Cedula;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contraseña) {
        this.contrasenia = contraseña;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
    
    
}
