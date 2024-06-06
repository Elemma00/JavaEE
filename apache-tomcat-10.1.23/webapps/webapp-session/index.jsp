<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="layout/header.jsp"%>
<h3><%=title%></h3>
<ul class="list-group">
   <li class="list-group-item active">Menú de opciones</li>
   <li class="list-group-item"><a href="<%out.print(request.getContextPath());%>/productos">Mostrar Productos HTML</a></li>
   <li class="list-group-item"><a href="<%out.print(request.getContextPath());%>/login">Login</a></li>
   <li class="list-group-item"><a href="<%out.print(request.getContextPath());%>/logout">Cerrar Sesión</a></li>
   <li class="list-group-item"><a href="<%out.print(request.getContextPath());%>/carro/ver">Ver Carro</a></li>
</ul>
<%@include file="layout/footer.jsp"%>