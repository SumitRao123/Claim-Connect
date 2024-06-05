<%@page import="insurance.controller.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Login Page</title>
    <link rel='stylesheet' href='./stylesheets/Login.css' />
  </head>
  <body>
    <h1>Login Page</h1>
    <form action="LoginServlet" method="post">
      <div class="inputBox">
        <input type="email" required="required" name="email">
        <span>Email</span>
      </div> 
      <div class="inputBox">
        <input type="password" required="required" name="pin" >
        <span>Pin</span>
      </div>  
      <input type="submit" value="Login" class="btn"> 
    </form>
  </body>
</html>
