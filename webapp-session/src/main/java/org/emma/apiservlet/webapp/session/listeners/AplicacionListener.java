package org.emma.apiservlet.webapp.session.listeners;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import org.emma.apiservlet.webapp.session.models.Carro;

// Si queremos inicializar configuraciones o conexiones a bases de datos, podemos hacerlo con la intefaz ServletContextListener
// Si queremos hacer algo cuando se crea o destruye una petición, podemos hacerlo con la interfaz ServletRequestListener
// Si queremos hacer algo cuando se crea o destruye una sesión, podemos hacerlo con la interfaz HttpSessionListener

@WebListener
//Se utiliza la antotación @WebListener para indicar que esta clase es un listener
public class AplicacionListener implements ServletContextListener, ServletRequestListener, HttpSessionListener {

    private ServletContext servletContext;

    /**
     * Método que se ejecuta cuando se inicializa la aplicación.
     * Ocurre cuando se inicializa el contexto de la aplicación,
     * como ejemplo se puede inicializar una conexión a la base de datos
     * con el fin de que esté disponible para toda la aplicación.
     *
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().log("Inicializando la aplicación");
        servletContext = sce.getServletContext();
        servletContext.setAttribute("mensaje", "algun valor global de la app!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        servletContext.log("Destruyendo la aplicación");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        servletContext.log("Petición iniciada");
        sre.getServletRequest().setAttribute("mensaje", "guardando algun valor para el request");

    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        servletContext.log("Petición destruida");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        servletContext.log("Inicializando la sesión HTTP");
        Carro carro = new Carro();
        HttpSession session = se.getSession();
        session.setAttribute("carro", carro);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        servletContext.log("Destruyendo la sesión HTTP");
    }
}
