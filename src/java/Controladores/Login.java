/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.UserDao;
import VO.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fernando stiven
 */
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//
//        }
   }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        HttpSession sesionUsuario = request.getSession();
        Usuario _sesionUsuario = (Usuario) sesionUsuario.getAttribute("usuario");
        if (_sesionUsuario != null) {
            sesionUsuario.invalidate();
            response.sendRedirect("Sindex.jsp");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String login = request.getParameter("usuario");
        String pass = request.getParameter("pass");
        Usuario datosUsuario = new Usuario();
        datosUsuario.setLogin(login);
        datosUsuario.setPass(pass);

        //Validaciones
        UserDao userDao = new UserDao();
        Usuario sesion = userDao.validar(datosUsuario);
        HttpSession sesionUsuario = request.getSession();
        Usuario _sesionUsuario = (Usuario) sesionUsuario.getAttribute("usuario");
        if (_sesionUsuario == null) {
            //El usuario no a creado la sesion
            if (sesion != null) {
                sesionUsuario.setAttribute("usuario", sesion);
                sesionUsuario.setMaxInactiveInterval(20);
                System.out.println("holi llege ");
                response.sendRedirect("index.jsp");
            } else {
                response.sendRedirect("error.jsp");
                
            }

        } else {
            response.sendRedirect("sesion.jsp");
        }

        if (sesion != null) {

        } else {
            request.setAttribute("Error", "Revisar usuario/ pass");
            RequestDispatcher rq = request.getRequestDispatcher("Sindex.jsp");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
