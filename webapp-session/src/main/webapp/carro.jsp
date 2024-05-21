<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="org.emma.apiservlet.webapp.session.models.*" %>
<% Carro carro = (Carro) session.getAttribute("carro"); %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Carro de Compras</title>
</head>
<body>
<h1>Carro de Compras</h1>
<% if (carro == null || carro.getItems().isEmpty()) {%>
<p>No hay productos en el carro</p>
<%} else {%>
<form name="formcarro" action="<%=request.getContextPath()%>/actualizar-carro" method="post">
    <table>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Precio</th>
            <th>Cantidad</th>
            <th>Total</th>
            <th>Borrar</th>
        </tr>
        <% for (ItemCarro item : carro.getItems()) {%>
        <tr>
            <td><%=item.getProducto().getId() %>
            </td>
            <td><%=item.getProducto().getNombre() %>
            </td>
            <td><%=item.getProducto().getPrecio() %>
            </td>
            <td><input type="text" size="4" name="cant_<%=item.getProducto().getId()%>" value="<%=item.getCantidad()%>" /></td>
            <td><%=item.getImporte()%></td>
            <td><input type="checkbox" value="<%=item.getProducto().getId()%>" name="deleteProductos"/></td>
        </tr>
        <%}%>
        <tr>
            <td colspan="4" style="text-align: right">Total:</td>
            <td><%=carro.getTotal()%>
            </td>
        </tr>
    </table>
    <a href="javascript:document.formcarro.submit();">Actualizar</a>
</form>
<%}%>
<a href="<%=request.getContextPath()%>/productos">Seguir comprando</a>
<a href="<%=request.getContextPath()%>">Inicio</a>

</body>
</html>
