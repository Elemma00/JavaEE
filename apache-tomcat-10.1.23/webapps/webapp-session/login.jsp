<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="layout/header.jsp"%>
<h3><%=title%></h3>
<form action="/webapp-session/login" method="post">
    <div class="row my-2">
        <label for="username" class="form-label">Username</label>
        <div>
        <input type="text" id="username" name="username" class="form-control">
        </div>
    </div>
    <div class="row my-2">
        <label for="password" class="form-label">Password</label>
        <div>
            <input type="password" id="password" name="password" class="form-control">
        </div>
    </div>
    <div class="row my-2">
        <input type="submit" value="Iniciar sesión" class="btn btn-primary">
    </div>
</form>
<%@include file="layout/footer.jsp"%>
