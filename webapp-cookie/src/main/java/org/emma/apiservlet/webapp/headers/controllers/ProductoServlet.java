package org.emma.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.emma.apiservlet.webapp.headers.models.Producto;
import org.emma.apiservlet.webapp.headers.services.LoginService;
import org.emma.apiservlet.webapp.headers.services.LoginServiceImpl;
import org.emma.apiservlet.webapp.headers.services.ProductoService;
import org.emma.apiservlet.webapp.headers.services.ProductoServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@WebServlet({"/productos.html", "/productos"})
public class ProductoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoService service = new ProductoServiceImpl();
        List<Producto> productos = service.listar();

        LoginService auth = new LoginServiceImpl();
        Optional<String> cookieOptional = auth.getUsername(req);

        resp.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("    <head>");
            out.println("       <meta charset=\"UTF-8\">");
            out.println("       <title></title>");
            out.println("    </head>");
            out.println("    <body>");
            out.println("       <h1>Listado de Productos!</h1>");
            cookieOptional.ifPresent(s -> out.println("<div style='color: blue;'>Hola " + s + ", bienvenido!</div>"));
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>id</th>");
            out.println("<th>Nombre</th>");
            out.println("<th>Tipo</th>");
            if(cookieOptional.isPresent()) {
                out.println("<th>Precio</th>");
            }
            out.println("</tr>");
            productos.forEach(p -> {
                out.println("<tr>");
                out.println("<td>" + p.getId() + "</td>");
                out.println("<td>" + p.getNombre() + "</td>");
                out.println("<td>" + p.getTipo() + "</td>");
                if(cookieOptional.isPresent()) {
                    out.println("<td>" + p.getPrecio() + "</td>");
                }
                out.println("</tr>");
            });
            out.println("</table>");
            out.println("     </body>");
            out.println("</html>");
        }
    }
}
