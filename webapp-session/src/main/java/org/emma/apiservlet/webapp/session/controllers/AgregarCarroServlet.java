package org.emma.apiservlet.webapp.session.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.emma.apiservlet.webapp.session.models.Carro;
import org.emma.apiservlet.webapp.session.models.ItemCarro;
import org.emma.apiservlet.webapp.session.models.Producto;
import org.emma.apiservlet.webapp.session.services.ProductoService;
import org.emma.apiservlet.webapp.session.services.ProductoServiceImpl;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/carro/agregar")
public class AgregarCarroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id").trim());
        ProductoService service = new ProductoServiceImpl();
        Optional<Producto> producto = service.porId(id);
        if(producto.isPresent()){
            ItemCarro item = new ItemCarro(1,producto.get());
            HttpSession session = req.getSession();
            Carro carro = (Carro) session.getAttribute("carro");
            carro.addItemCarro(item);
        }
        resp.sendRedirect(req.getContextPath()+ "/carro/ver");
    }
}


