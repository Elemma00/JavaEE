<%@ page import="org.emma.apiservlet.webapp.session.models.*" %>
<%@ page import="java.util.Optional" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<Producto> productos = (List<Producto>) request.getAttribute("productos");
    Optional<String> username = (Optional<String>) request.getAttribute("username");
%>

<%@include file="layout/header.jsp"%>
<h3><%=title%></h3>
<%if (username.isPresent()) {%>
<div class="alert alert-info">Hola <%=username.get()%>, bienvenido!</div>
<p><a class="btn btn-sm btn-primary my-2" href="<%=request.getContextPath()%>/productos/form"> crear [+]</a></p>
<%}%>
<table class="table table-primary table-hover table-striped">
    <tr>
        <th scope="col">id</th>
        <th scope="col">Nombre</th>
        <th scope="col">Tipo</th>
        <%if (username.isPresent()) {%>
        <th scope="col">Precio</th>
        <th scope="col">Agregar</th>
        <th scope="col">Editar</th>
        <th scope="col">Eliminar</th>
        <%}%>
    </tr>
    <% for (Producto p : productos) {%>
    <tr>
        <td><strong><%=p.getId()%>
        </strong></td>
        <td><%=p.getNombre()%>
        </td>
        <td><%=p.getCategoria().getNombre()%>
        </td>
        <%if (username.isPresent()) {%>
        <td><%=p.getPrecio()%>
        </td>
        <td><a class="btn btn-sm btn-primary" href="<%=request.getContextPath()%>/carro/agregar?id=<%=p.getId()%>">Agregar
            al carro</a></td>
        <td><a class="btn btn-sm btn-success" href="<%=request.getContextPath()%>/productos/form?id=<%=p.getId()%>">Editar</a>
        </td>
        <td><a class="btn btn-sm btn-danger" onclick="return confirm('¿Estás seguro de eliminar el producto?')"
               href="<%=request.getContextPath()%>/productos/eliminar?id=<%=p.getId()%>">Eliminar</a></td>
        <%}%>
    </tr>
    <%}%>
</table>
<%@include file="layout/footer.jsp"%>