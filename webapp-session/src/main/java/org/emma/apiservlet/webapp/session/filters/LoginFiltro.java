package org.emma.apiservlet.webapp.session.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.emma.apiservlet.webapp.session.services.LoginService;
import org.emma.apiservlet.webapp.session.services.LoginServiceSessionImpl;

import java.io.IOException;
import java.util.Optional;

// Esta clase es un filtro
// Un filtro es un objeto que se puede usar para realizar operaciones de preprocesamiento y postprocesamiento en una solicitud del cliente y en una respuesta del servidor.
// Los filtros se utilizan para realizar tareas como la autenticación, el registro, la compresión, el cifrado, la transcodificación, etc.

// Se utilizan solo en el contexto de los request y no tienen acceso a los objetos de la sesión.
// el metodo doFilter se ejecuta por cada petición que llega al servidor, antes de que llegue a un servlet o un JSP.
@WebFilter({"/carro/*"})
public class LoginFiltro implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LoginService service = new LoginServiceSessionImpl();
        Optional<String> username = service.getUsername((HttpServletRequest) servletRequest);
        if (username.isPresent()) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            ((HttpServletResponse) servletResponse).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos no estas autorizado para ver esta página");
        }
    }
}
