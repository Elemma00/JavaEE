<%--
  Created by IntelliJ IDEA.
  User: Emmanuel
  Date: 5/16/2024
  Time: 5:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Buscar Producto</title>
</head>
<body>
 <h3>Buscar Producto</h3>
    <form action="/webapp-headers/buscar-producto" method="post">
        <div>
            <label for="producto">Buscar Producto</label>
            <div>
                <input type="text" id="producto" name="producto">
            </div>
        </div>
        <div>
            <input type="submit" value="Buscar">
        </div>
</body>
</html>
