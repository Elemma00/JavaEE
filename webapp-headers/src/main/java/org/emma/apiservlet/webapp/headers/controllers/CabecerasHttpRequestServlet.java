package org.emma.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/cabeceras-request")
public class CabecerasHttpRequestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String metodoHTTP = req.getMethod();
        String requestURI = req.getRequestURI();
        String requestURL = req.getRequestURL().toString();
        String contextPath = req.getContextPath();
        String servletPath = req.getServletPath();
        String ipCliente = req.getRemoteAddr();
        String ip = req.getLocalAddr();
        int port = req.getLocalPort();
        String scheme = req.getScheme();
        String host = req.getHeader("host");
        String url = scheme+ "://" + host + requestURI;

        try (PrintWriter out = resp.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("    <head>");
            out.println("       <meta charset=\"UTF-8\">");
            out.println("       <title>Cabeceras HTTP Request</title>");
            out.println("    </head>");
            out.println("    <body>");
            out.println("       <h1>Cabeceras HTTP Request</h1>");
            out.println("       <ul>");
            out.println("       <li>Método HTTP: " + metodoHTTP + "</li>");
            out.println("       <li>Request URI: " + requestURI + "</li>");
            out.println("       <li>Request URL: " + requestURL + "</li>");
            out.println("       <li>Context Path: " + contextPath + "</li>");
            out.println("       <li>Servlet Path: " + servletPath + "</li>");
            out.println("       <li>IP Cliente: " + ipCliente + "</li>");
            out.println("       <li>IP local: " + ip + "</li>");
            out.println("       <li>Port: " + port + "</li>");
            out.println("       <li>Scheme: " + scheme + "</li>");
            out.println("       <li>HOST: " + host + "</li>");
            out.println("       <li>url: " + url + "</li>");
            Enumeration<String> headerNames = req.getHeaderNames();
            while(headerNames.hasMoreElements()){
                String headerName = headerNames.nextElement();
                String headerValue = req.getHeader(headerName);
                out.println("       <li>" + headerName + ": " + headerValue + "</li>");
            }
            out.println("       </ul>");
            out.println("     </body>");
            out.println("</html>");
        }
    }
}
