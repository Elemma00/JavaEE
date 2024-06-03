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
    <meta charset="UTF-8">
    <title>Listado de Productos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<h1>Listado de Productos</h1>
<%if (username.isPresent()) {%>
<div>Hola <%=username.get()%>, bienvenido!</div>
<p><a href="<%=request.getContextPath()%>/productos/form"> crear [+]</a></p>
<%}%>
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
