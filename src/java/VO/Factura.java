/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;


/**
 *
 * @author Juan Manuel
 */
public class  Factura  {

   private String nombreCliente;
   private String nombreLi;
   private int idLi;
   private int numFac;
   private int precio;
   private int idEmple;

    public Factura(String nombreCliente, String nombreLi, int idLi, int numFac, int precio, int idEmple) {
        this.nombreCliente = nombreCliente;
        this.nombreLi = nombreLi;
        this.idLi = idLi;
        this.numFac = numFac;
        this.precio = precio;
        this.idEmple = idEmple;
    }

    public Factura() {
    }
   
   
   
   
   
    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreLi() {
        return nombreLi;
    }

    public void setNombreLi(String nombreLi) {
        this.nombreLi = nombreLi;
    }

    public int getIdLi() {
        return idLi;
    }

    public void setIdLi(int idLi) {
        this.idLi = idLi;
    }

    public int getNumFac() {
        return numFac;
    }

    public void setNumFac(int numFac) {
        this.numFac = numFac;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getIdEmple() {
        return idEmple;
    }

    public void setIdEmple(int idEmple) {
        this.idEmple = idEmple;
    }

    
}
