/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.DbUtil;
import VO.Empleados;
import VO.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fernando stiven
 */
public class CrudEmpleado {
        private Connection connection;

    public CrudEmpleado() {
        connection = DbUtil.getConnection();
    }

    public void agregarEmpleado(Empleados Emp) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into Empleado(nombre,cedula,contraseña,usuario) values (?, ?, ?, ? )");
            // Parameters start with 1
            preparedStatement.setString(1, Emp.getNombre());
            preparedStatement.setInt(2, Emp.getCedula());
            preparedStatement.setString(3, Emp.getContrasenia());
            preparedStatement.setString(4, Emp.getUsuario());
            
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmpleado(int cedula) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from Empleado where cedula=?");
            // Parameters start with 1
            preparedStatement.setInt(1,cedula);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmpleado(Empleados em) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update Empleado set nombre=?, contraseña=?, usuario=?"
                            + "where cedula=?");
            // Parameters start with 1
            preparedStatement.setInt(1, em.getCedula());
            preparedStatement.setString(2, em.getNombre());
            preparedStatement.setString(3, em.getContrasenia());
            preparedStatement.setString(4, em.getUsuario());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Empleados> listarEmpleados() {
        List<Empleados> users = new ArrayList<Empleados>();
        try {
            System.out.println("LLegue hasta aca");
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from Empleados");
            while (rs.next()) {
                Empleados li = new Empleados();
               li.setNombre(rs.getString("nombre"));
               li.setCedula(rs.getInt("cedula"));
               li.setContrasenia(rs.getString("contraseña"));
               li.setUsuario(rs.getString("usuario"));
              
                users.add(li);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public Empleados extraerEmpleados(int contra) {
        Empleados em=new Empleados();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from Empleado where userid=?");
            preparedStatement.setInt(1, contra);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
               em.setNombre(rs.getString("nombre"));
               em.setCedula(rs.getInt("cedula"));
               em.setContrasenia(rs.getString("contraseña"));
               em.setUsuario(rs.getString("usuario"));
              
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return em;
    }

}

