<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="org.emma.apiservlet.webapp.session.models.*" %>
<% Carro carro = (Carro) session.getAttribute("carro"); %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Carro de Compras</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<h1>Carro de Compras</h1>
<% if (carro == null || carro.getItems().isEmpty()) {%>
<p>No hay productos en el carro</p>
<%} else {%>
<form name="formcarro" action="<%=request.getContextPath()%>/carro/actualizar" method="post">
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
