/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.DbUtil;
import VO.Factura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan Manuel
 */
public class CrudFactura {
 private Connection connection;

    public CrudFactura() {
        connection = DbUtil.getConnection();
    }

    public void facturar(Factura li) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into Factura (NombreCliente,nombreLi,idLi,numFac,precio,cedulaEmple) values (?, ?, ?, ? , ?, ?)");

           // Parameters start with 1
            preparedStatement.setString(1, li.getNombreCliente());
            preparedStatement.setString(2, li.getNombreLi());
            preparedStatement.setInt(3, li.getIdLi());
            preparedStatement.setInt(4, li.getNumFac());
            preparedStatement.setInt(5, li.getPrecio());
            preparedStatement.setInt(6, li.getIdEmple());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
      public List<Factura> mostarFacturas() {
        List<Factura> facs = new ArrayList<Factura>();
        try {
            System.out.println("LLegue hasta aca");
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from Factura");
            while (rs.next()) {
                
                Factura f=new Factura();
              f.setNombreCliente(rs.getString("nombreCliente"));
              f.setNombreLi(rs.getString("nombreLi"));
              f.setIdLi(rs.getInt("idLi"));
              f.setNumFac(rs.getInt("numFac"));
              f.setPrecio(rs.getInt("precio"));
              f.setIdEmple(rs.getInt("cedulaEmple"));
              
               
               
               facs.add(f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return facs;
    }
    
    

}
   

