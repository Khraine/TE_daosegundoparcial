package com.emergentes.controlador;

import com.emergentes.dao.EventoDAO;
import com.emergentes.dao.EventoDAOimpl;
import com.emergentes.modelo.Evento;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EventoControlador", urlPatterns = {"/EventoControlador"})
public class EventoControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            EventoDAO dao = new EventoDAOimpl();
            Evento evn = new Evento();
            int id;
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("evento", evn);
                    request.getRequestDispatcher("frmEvento.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    evn=dao.getById(id);
                    request.setAttribute("evento", evn);
                    request.getRequestDispatcher("frmEvento.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("EventoControlador");   
                    break;
                case "view":
                    List<Evento> lista = dao.getAll();
                    request.setAttribute("eventos", lista);
                    request.getRequestDispatcher("eventos.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EventoDAO dao = new EventoDAOimpl();
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String expositor = request.getParameter("expositor");
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");
        int cupo = Integer.parseInt(request.getParameter("cupo"));
        Evento evn = new Evento();
        evn.setId(id);
        evn.setTitulo(titulo);
        evn.setExpositor(expositor);
        evn.setFecha(fecha);
        evn.setHora(hora);
        evn.setCupo(cupo);
        if (id==0) {
            try {
                dao.insert(evn);
                response.sendRedirect("EventoControlador");
            } catch (Exception ex) {
                System.out.println("Error"+ex.getMessage());
            }
            
        }else{
            try {
                dao.update(evn);
                response.sendRedirect("EventoControlador");
            } catch (Exception ex) {
                System.out.println("Error"+ex.getMessage());
            }
            
        }
      
    }
}
