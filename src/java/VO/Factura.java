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
   private Libro li;
   private int cantidad;

    public Factura(String nombreCliente, Libro li,int cantidad) {
        this.nombreCliente = nombreCliente;
        this.li = li;
        this.cantidad=cantidad;
    }
    
    public Factura(){}

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
   

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Libro getLi() {
        return li;
    }

    public void setLi(Libro li) {
        this.li = li;
    }
   
   

    
  
    
}
