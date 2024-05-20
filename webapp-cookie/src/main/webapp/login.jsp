<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulario de login</title>
</head>
<body>
<h1>Iniciar sesión</h1>
<form action="/webapp-cookie/login" method="post">
    <div>
        <label for="username">Username</label>
        <div>
        <input type="text" id="username" name="username">
        </div>
    </div>
    <div>
        <label for="password">Password</label>
        <div>
            <input type="password" id="password" name="password">
        </div>
    </div>
    <div>
        <input type="submit" value="Iniciar sesión">
    </div>
</form>
</body>
</html>
