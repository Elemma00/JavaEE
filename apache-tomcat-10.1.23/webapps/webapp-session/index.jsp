<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manejo de Cookies HTTP</title>
</head>
<body>
<h3>Manejo de Cookies HTTP</h3>
<ul>
   <li><a href="<%out.print(request.getContextPath());%>/productos">Mostrar Productos HTML</a></li>
   <li><a href="<%out.print(request.getContextPath());%>/login">Login</a></li>
   <li><a href="<%out.print(request.getContextPath());%>/logout">Cerrar Sesión</a></li>
   <li><a href="<%out.print(request.getContextPath());%>/ver-carro">Ver Carro</a></li>
</ul>
</body>

</html>