package org.emma.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.emma.apiservlet.webapp.headers.models.Producto;
import org.emma.apiservlet.webapp.headers.services.ProductoService;
import org.emma.apiservlet.webapp.headers.services.ProductoServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet("/buscar-producto")
public class BuscarProductoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/buscar.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoService service = new ProductoServiceImpl();
        String nombre = req.getParameter("producto");
        Optional<Producto> encontrado = service.listar().stream().filter(producto -> {
            if(nombre.isBlank() || nombre == null){
                return false;
            }
            return producto.getNombre().contains(nombre);
            }).findFirst();
        if(encontrado.isPresent()){
            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("    <head>");
                out.println("       <meta charset=\"UTF-8\">");
                out.println("       <title>Producto encontrado</title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("       <h1>Producto encontrado!</h1>");
                out.println("       <ul>");
                out.println("         <li>Producto: " + encontrado.get().getNombre() + "</li>");
                out.println("         <li>Precio: " + encontrado.get().getPrecio() + "</li>");
                out.println("       </ul?");
                out.println("     </body>");
                out.println("</html>");
            }
        }else{
            resp.sendError(HttpServletResponse.SC_NOT_FOUND,"No se encontro el producto "+ nombre);
        }
    }
}
