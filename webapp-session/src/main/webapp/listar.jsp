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
    <%if (username.isPresent()) {%>
    <div>Hola <%=username.get()%>, bienvenido!</div>
    <p><a href="<%=request.getContextPath()%>/productos/form"> crear [+]</a></p>
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
        <th>Editar</th>
        <th>Eliminar</th>
        <%}%>
    </tr>
    <% for (Producto p : productos) {%>
    <tr>
        <td><%=p.getId()%>
        </td>
        <td><%=p.getNombre()%>
        </td>
        <td><%=p.getCategoria().getNombre()%>
        </td>
        <%if (username.isPresent()) {%>
        <td><%=p.getPrecio()%>
        </td>
        <td><a href="<%=request.getContextPath()%>/carro/agregar?id=<%=p.getId()%>">Agregar al carro</a></td>
        <td><a href="<%=request.getContextPath()%>/productos/form?id=<%=p.getId()%>">Editar</a></td>
        <td><a onclick="return confirm('¿Estás seguro de eliminar el producto?')"
                href="<%=request.getContextPath()%>/productos/eliminar?id=<%=p.getId()%>">Eliminar</a></td>
        <%}%>
    </tr>
    <%}%>
</table>
</body>
</html>
