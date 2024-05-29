<%@ page import="org.emma.apiservlet.webapp.session.models.*" %>
<%@ page import="java.util.Optional" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<Producto> productos = (List<Producto>) request.getAttribute("productos");
   Optional<String> username = (Optional<String>) request.getAttribute("username");

    String mensajeRequest = (String) request.getAttribute("mensaje");
    String mensajeApp = (String) getServletContext().getAttribute("mensaje");%>
<html>
<head>
    <title>Listado de Productos</title>
    <%if (username.isPresent()){%>
        <div>Hola <%=username.get()%>, bienvenido!</div>
    <%}%>
</head>
<body>
<h1>Listado de Productos</h1>
<table>
    <tr>
        <th>id</th>
        <th>Nombre</th>
        <th>Tipo</th>
        <%if (username.isPresent()) {%>
        <th>Precio</th>
        <th>Agregar</th>
        <%}%>
    </tr>
    <% for (Producto p : productos) {%>
    <tr>
        <td><%=p.getId()%>
        </td>
        <td><%=p.getNombre()%>
        </td>
        <td><%=p.getTipo()%>
        </td>
        <%if (username.isPresent()) {%>
        <td><%=p.getPrecio()%>
        </td>
        <td><a href="<%=request.getContextPath()%>/carro/agregar?id=<%=p.getId()%>">Agregar al carro</a></td>
        <%}%>
    </tr>
    <%}%>
</table>
</body>
</html>
