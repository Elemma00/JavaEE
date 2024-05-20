package org.emma.apiservlet.webapp.form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.HashMap;

@WebServlet({"/crear", ""})
public class RegistroProductoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String nombre = req.getParameter("nombre");
        String precioParam = req.getParameter("precio");
        int precio = 0;
        String fabricante = req.getParameter("fabricante");

        Map<String,String> errores = new HashMap<>();
        if (nombre == null || nombre.isBlank()) {
            errores.put("nombre", "El campo nombre es requerido");
        }
        if (precioParam != null && !precioParam.isEmpty()) {
            try {
                precio = Integer.parseInt(precioParam);
            } catch (NumberFormatException e) {
                errores.put("precio", "El campo precio debe ser un número entero");
            }
        }
        if (fabricante == null || fabricante.isBlank()) {
            errores.put("fabricante", "El campo fabricante es requerido");
        }

        if (errores.isEmpty()) {
            try (PrintWriter out = resp.getWriter()) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("    <head>");
                out.println("       <meta charset=\"UTF-8\">");
                out.println("       <title></title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("       <h1>Producto Registrado</h1>");
                out.println("       <ul>");
                out.println("           <li>Nombre: " + nombre + "</li>");
                out.println("           <li>Precio: " + precio + "</li>");
                out.println("           <li>Fabricante: " + fabricante + "</li>");
                out.println("     </body>");
                out.println("</html>");
            }
        } else {
            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/form.jsp").forward(req, resp);
        }
    }
}
