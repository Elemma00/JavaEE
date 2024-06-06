<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="org.emma.apiservlet.webapp.session.models.*" %>
<% Carro carro = (Carro) session.getAttribute("carro"); %>
<%@include file="layout/header.jsp"%>
<h3><%=title%></h3>
<% if (carro == null || carro.getItems().isEmpty()) {%>
<div class="alert alert-warning">No hay productos en el carro</div>
<%} else {%>
<form name="formcarro" action="<%=request.getContextPath()%>/carro/actualizar" method="post">
    <table class="table table-hover table-striped table-info">
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
            <td><input type="text" size="4" name="cant_<%=item.getProducto().getId()%>"
                       value="<%=item.getCantidad()%>"/></td>
            <td><%=item.getImporte()%>
            </td>
            <td><input type="checkbox" value="<%=item.getProducto().getId()%>" name="deleteProductos"/></td>
        </tr>
        <%}%>
        <tr>
            <td colspan="5" style="text-align: right">Total:</td>
            <td><%=carro.getTotal()%>
            </td>
        </tr>
    </table>
    <a class="btn btn-primary" href="javascript:document.formcarro.submit();">Actualizar</a>
</form>
<%}%>
<div class="my-2">
    <a class="btn btn-success" href="<%=request.getContextPath()%>/productos">Seguir comprando</a>
    <a class="btn btn-secondary" href="<%=request.getContextPath()%>">Inicio</a>
</div>
<%@include file="layout/footer.jsp"%>