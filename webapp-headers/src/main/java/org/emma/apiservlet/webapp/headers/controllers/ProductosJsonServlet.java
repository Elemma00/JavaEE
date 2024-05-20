package org.emma.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.emma.apiservlet.webapp.headers.models.Producto;
import org.emma.apiservlet.webapp.headers.services.ProductoService;
import org.emma.apiservlet.webapp.headers.services.ProductoServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/productos.json")
public class ProductosJsonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoService service = new ProductoServiceImpl();
        List<Producto> productos = service.listar();

        // El objeto ObjectMapper se encarga de convertir objetos a JSON
        // el metodo writeValueAsString convierte el objeto a JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(productos);
        resp.setContentType("application/json");
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // El método getInputStream() obtiene el flujo de entrada de la petición
        // y se lo pasamos al objeto ObjectMapper para que convierta el JSON a objeto
        ServletInputStream jsonStream = req.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        Producto producto = mapper.readValue(jsonStream, Producto.class);
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("    <head>");
            out.println("       <meta charset=\"UTF-8\">");
            out.println("       <title>Detalle de producto desde json</title>");
            out.println("    </head>");
            out.println("    <body>");
            out.println("       <h1>Detalle de producto desde json</h1>");
            out.println("       <ul>");
            out.println("       <li>id: " + producto.getId() + "</li>");
            out.println("       <li>Nombre: " + producto.getNombre() + "</li>");
            out.println("       <li>Tipo: " + producto.getTipo() + "</li>");
            out.println("       <li>Precio: " + producto.getPrecio() + "</li>");
            out.println("       </ul>");
            out.println("     </body>");
            out.println("</html>");
        }
    }
}
