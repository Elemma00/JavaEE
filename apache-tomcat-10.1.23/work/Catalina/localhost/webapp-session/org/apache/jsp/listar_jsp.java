/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.23
 * Generated at: 2024-05-29 18:29:07 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import org.emma.apiservlet.webapp.session.models.*;
import java.util.Optional;
import java.util.List;

public final class listar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_packages.add("org.emma.apiservlet.webapp.session.models");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(2);
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("java.util.Optional");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 List<Producto> productos = (List<Producto>) request.getAttribute("productos");
   Optional<String> username = (Optional<String>) request.getAttribute("username");

    String mensajeRequest = (String) request.getAttribute("mensaje");
    String mensajeApp = (String) getServletContext().getAttribute("mensaje");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Listado de Productos</title>\r\n");
      out.write("    ");
if (username.isPresent()){
      out.write("\r\n");
      out.write("        <div>Hola ");
      out.print(username.get());
      out.write(", bienvenido!</div>\r\n");
      out.write("    ");
}
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h1>Listado de Productos</h1>\r\n");
      out.write("<table>\r\n");
      out.write("    <tr>\r\n");
      out.write("        <th>id</th>\r\n");
      out.write("        <th>Nombre</th>\r\n");
      out.write("        <th>Tipo</th>\r\n");
      out.write("        ");
if (username.isPresent()) {
      out.write("\r\n");
      out.write("        <th>Precio</th>\r\n");
      out.write("        <th>Agregar</th>\r\n");
      out.write("        ");
}
      out.write("\r\n");
      out.write("    </tr>\r\n");
      out.write("    ");
 for (Producto p : productos) {
      out.write("\r\n");
      out.write("    <tr>\r\n");
      out.write("        <td>");
      out.print(p.getId());
      out.write("\r\n");
      out.write("        </td>\r\n");
      out.write("        <td>");
      out.print(p.getNombre());
      out.write("\r\n");
      out.write("        </td>\r\n");
      out.write("        <td>");
      out.print(p.getTipo());
      out.write("\r\n");
      out.write("        </td>\r\n");
      out.write("        ");
if (username.isPresent()) {
      out.write("\r\n");
      out.write("        <td>");
      out.print(p.getPrecio());
      out.write("\r\n");
      out.write("        </td>\r\n");
      out.write("        <td><a href=\"");
      out.print(request.getContextPath());
      out.write("/carro/agregar?id=");
      out.print(p.getId());
      out.write("\">Agregar al carro</a></td>\r\n");
      out.write("        ");
}
      out.write("\r\n");
      out.write("    </tr>\r\n");
      out.write("    ");
}
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}