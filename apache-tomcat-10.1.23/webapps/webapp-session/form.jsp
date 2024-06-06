<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="org.emma.apiservlet.webapp.session.models.*, java.util.*" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<% List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
    Map<String, String> errores = (Map<String, String>) request.getAttribute("errores");
    Producto producto = (Producto) request.getAttribute("producto");
    String fecha = producto.getFechaRegistro() != null ? producto.getFechaRegistro().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) : "";
%>
<%@include file="layout/header.jsp"%>
    <h1><%=title%></h1>
    <form action="<%=request.getContextPath()%>/productos/form" method="post">
        <div class="row mb-2">
            <label for="nombre" class="col-form-label col-sm-2">Nombre</label>
            <div class="col-sm-4">
                <input type="text" name="nombre" id="nombre"
                       value="<%=producto.getNombre() != null ? producto.getNombre(): ""%>"
                       placeholder="nombre del producto" class="form-control">
            </div>
            <% if (errores != null && errores.containsKey("nombre")) {%>
            <div style="color: red"><%=errores.get("nombre")%>
            </div>
            <%}%>
        </div>
        <div class="row mb-2">
            <label for="precio" class="col-form-label col-sm-2">Precio</label>
            <div class="col-sm-4">
                <input type="text" name="precio" id="precio"
                       value="<%=producto.getPrecio() != 0 ? producto.getPrecio():""%>"
                       placeholder="precio del producto" class="form-control">
            </div>
            <% if (errores != null && errores.containsKey("precio")) {%>
            <div style="color: red"><%=errores.get("precio")%>
            </div>
            <%}%>
        </div>
        <div class="row mb-2">
            <label for="sku" class="col-form-label col-sm-2">Sku</label>
            <div class="col-sm-4">
                <input type="text" name="sku" id="sku" value="<%=producto.getSku()!=null? producto.getSku(): ""%>"
                       placeholder="SKU" class="form-control">
            </div>
            <% if (errores != null && errores.containsKey("sku")) {%>
            <div style="color: red"><%=errores.get("sku")%>
            </div>
            <%}%>
        </div>
        <div class="row mb-2">
            <label for="fecha_registro" class="col-form-label col-sm-2">Fecha Registro</label>
            <div class="col-sm-4">
                <input type="date" name="fecha_registro" id="fecha_registro" value="<%=fecha%>" class="form-control">
            </div>
            <% if (errores != null && errores.containsKey("fecha_registro")) {%>
            <div style="color: red"><%=errores.get("fecha_registro")%>
            </div>
            <%}%>
        </div>
        <div class="row mb-2">
            <label for="categoria" class="col-form-label col-sm-2">Categoria</label>
            <div class="col-sm-4">
                <select name="categoria" id="categoria" class="form-select">
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
        <div class="row mb-2">
            <div>
                <input class="btn btn-primary" type="submit"
                       value="<%=(producto.getId() != null && producto.getId() >0) ? "Editar": "Crear"%>">
            </div>
        </div>
        <input type="hidden" name="id" value="<%=producto.getId()%>">
    </form>
<%@include file="layout/footer.jsp"%>
