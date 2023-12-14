<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./Plantillas/css/login.css"> 
<title>Formulario Login</title>
</head>
<body>

	<form action="/ingresar" class="login" method="POST">
        <h1>Login</h1>
       
          <input id= "Usuario" type="text" name="Usuario" placeholder="Username" required="required" />
          <input id="Password" type="password" name="Password" placeholder="Password" required="required" />
          <input id="ingresar" class="btn btn-primary btn-block btn-large" type="submit" value="Login">
          
       	  <a class="Registrar" href="./Crearusuario.html">Crear Usuario</a>
      </form>

</body>
</html>