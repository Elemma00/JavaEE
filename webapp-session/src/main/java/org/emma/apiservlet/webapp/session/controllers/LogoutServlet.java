package org.emma.apiservlet.webapp.session.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.emma.apiservlet.webapp.session.services.LoginService;
import org.emma.apiservlet.webapp.session.services.LoginServiceCookieImpl;
import org.emma.apiservlet.webapp.session.services.LoginServiceSessionImpl;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LoginService auth = new LoginServiceSessionImpl();
        Optional<String> username = auth.getUsername(req);
        if(username.isPresent()){
            //Invalidamos la sesion
            HttpSession session = req.getSession();
            session.invalidate();
            // En este caso podemos utilizar el método invalidate() para eliminar la sesión
            // pero si tuvieramos un carro de compras o algo que queremos mantener en la sesión
            // podríamos eliminar solo el atributo de la sesión con session.removeAttribute("username");
        }
        resp.sendRedirect(req.getContextPath() + "/login");
    }
}
