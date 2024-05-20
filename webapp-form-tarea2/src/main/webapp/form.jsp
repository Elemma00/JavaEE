<%@page contentType="text/html; ISO-8859-1" pageEncoding="utf-8" %>
<%@ page import="java.util.Map" %>
<%
    Map<String, String> errores = (Map<String, String>) request.getAttribute("errores");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario de Producto</title>
    <link href="<%out.print(request.getContextPath());%>/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h3>Formulario de Producto</h3>

<% if (errores != null && !errores.isEmpty()) { %>
<ul class="alert alert-danger mx-5 px-5">
    <% for (String error : errores.values()) { %>
    <li><%= error %>
    </li>
    <% } %>
</ul>
<% } %>


<div class="px-5">
    <form action="/webapp-form-tarea2/crear" method="post">

        <div class="row mb-3">
            <label for="nombre" class="col-form-label col-sm-2">Nombre</label>
            <div class="col-sm-4"><input type="text" name="nombre" id="nombre" class="form-control"
                                         value="${param.nombre}"></div>
            <%
                if (errores != null && errores.containsKey("nombre")) {
                    out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>" + errores.get("nombre") + "</small>");
                }
            %>
        </div>
        <div class="row mb-3">
            <label for="precio" class="col-form-label col-sm-2">Precio</label>
            <div class="col-sm-4"><input type="number" name="precio" id="precio" class="form-control"
                                         value="${param.precio}"></div>
            <%
                if (errores != null && errores.containsKey("precio")) {
                    out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>" + errores.get("precio") + "</small>");
                }
            %>
        </div>
        <div class="row mb-3">
             <label for="fabricante" class="col-form-label col-sm-2">Fabricante</label>
             <div class="col-sm-4"><input type="text" name="fabricante" id="fabricante" class="form-control"
                                          value="${param.fabricante}"></div>
        </div>
        <div class="row mb-3">
            <div>
                <input type="submit" value="Crear" class="btn btn-primary">
            </div>
        </div>
    </form>
</div>
</body>
</html>
