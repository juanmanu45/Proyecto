/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.DbUtil;
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
 * @author Juan Manuel
 */
public class CrudLibro {

    private Connection connection;

    public CrudLibro() {
        connection = DbUtil.getConnection();
    }

    public void agregarLibro(Libro li) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into Libro(id_libro,nombre,autor,editorial,estado,precio) values (?, ?, ?, ? , ?, ?)");
            // Parameters start with 1
            preparedStatement.setInt(1, li.getId());
            preparedStatement.setString(2, li.getNombre());
            preparedStatement.setString(3, li.getAutor());
            preparedStatement.setString(4, li.getEditorial());
            preparedStatement.setString(5, li.getEstado());
            preparedStatement.setInt(6, li.getPrecio());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int libroid) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from Libro where id_libro=?");
            // Parameters start with 1
            preparedStatement.setInt(1, libroid);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(Libro li) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update Libro set nombre=?, autor=?, editorial=?, estado=?,precio=?"
                            + "where id_libro=?");
            // Parameters start with 1
          preparedStatement.setInt(1, li.getId());
            preparedStatement.setString(2, li.getNombre());
            preparedStatement.setString(3, li.getAutor());
            preparedStatement.setString(4, li.getEditorial());
            preparedStatement.setString(5, li.getEstado());
            preparedStatement.setInt(6, li.getPrecio());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Libro> listarLibros() {
        List<Libro> users = new ArrayList<Libro>();
        try {
            System.out.println("LLegue hasta aca");
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from Libro");
            while (rs.next()) {
                Libro li = new Libro();
               li.setNombre(rs.getString("nombre"));
               li.setAutor(rs.getString("autor"));
               li.setId(rs.getInt("id_libro"));
               li.setEditorial(rs.getString("editorial"));
               li.setEstado(rs.getString("estado"));
               li.setPrecio(rs.getInt("precio"));
                users.add(li);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public Libro extraerLibro(int userId) {
        Libro li = new Libro();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from users where userid=?");
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
               li.setNombre(rs.getString("nombre"));
               li.setAutor(rs.getString("autor"));
               li.setId(rs.getInt("id_libro"));
               li.setEditorial(rs.getString("editorial"));
               li.setEstado(rs.getString("estado"));
               li.setPrecio(rs.getInt("precio"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return li;
    }

}
