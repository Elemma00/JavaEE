<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="org.emma.apiservlet.webapp.session.models.*, java.util.*" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<% List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
    Map<String, String> errores = (Map<String, String>) request.getAttribute("errores");
    Producto producto = (Producto) request.getAttribute("producto");
    String fecha = producto.getFechaRegistro() != null ? producto.getFechaRegistro().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) : "";
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulario productos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<h1>Formulario productos</h1>
<form action="<%=request.getContextPath()%>/productos/form" method="post">
    <div>
        <label for="nombre">Nombre</label>
        <div>
            <input type="text" name="nombre" id="nombre"
                   value="<%=producto.getNombre() != null ? producto.getNombre(): ""%>"
                   placeholder="nombre del producto">
        </div>
        <% if (errores != null && errores.containsKey("nombre")) {%>
        <div style="color: red"><%=errores.get("nombre")%>
        </div>
        <%}%>
    </div>
    <div>
        <label for="precio">Precio</label>
        <div>
            <input type="text" name="precio" id="precio"
                   value="<%=producto.getPrecio() != 0 ? producto.getPrecio():""%>"
                   placeholder="precio del producto">
        </div>
        <% if (errores != null && errores.containsKey("precio")) {%>
        <div style="color: red"><%=errores.get("precio")%>
        </div>
        <%}%>
    </div>
    <div>
        <label for="sku">Sku</label>
        <div>
            <input type="text" name="sku" id="sku" value="<%=producto.getSku()!=null? producto.getSku(): ""%>"
                   placeholder="SKU">
        </div>
        <% if (errores != null && errores.containsKey("sku")) {%>
        <div style="color: red"><%=errores.get("sku")%>
        </div>
        <%}%>
    </div>
    <div>
        <label for="fecha_registro">Fecha Registro</label>
        <div>
            <input type="date" name="fecha_registro" id="fecha_registro" value="<%=fecha%>">
        </div>
        <% if (errores != null && errores.containsKey("fecha_registro")) {%>
        <div style="color: red"><%=errores.get("fecha_registro")%>
        </div>
        <%}%>
    </div>
    <div>
        <label for="categoria">Categoria</label>
        <div>
            <select name="categoria" id="categoria">
                <option value="">Seleccione la categoría</option>
                <% for (Categoria categoria : categorias) { %>
                <option value="<%=categoria.getId()%>" <%=categoria.getId().equals(producto.getCategoria().getId()) ? "selected" : ""%>><%=categoria.getNombre()%>
                </option>
                <% } %>
            </select>
        </div>
        <% if (errores != null && errores.containsKey("categoria")) {%>
        <div style="color: red"><%=errores.get("categoria")%>
        </div>
        <%}%>
    </div>
    <div>
        <input type="submit" value="<%=(producto.getId() != null && producto.getId() >0) ? "Editar": "Crear"%>">
    </div>
    <input type="hidden" name="id" value="<%=producto.getId()%>">
</form>
</body>
</html>
