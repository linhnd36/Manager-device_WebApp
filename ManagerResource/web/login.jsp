<%-- 
    Document   : login.jsp
    Created on : Jul 5, 2020, 6:55:27 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css">
        <script src="https://www.google.com/recaptcha/api.js"></script>
    </head>
    <body class="bgLogin">
        <div class="loginclass">
            <form action="login" method="POST" class="p-4" style="background-color: white; margin-top: 50px; border-radius: 2%;">
                <h1 class="text-center">Manager Resource</h1>
                <h4 class="text-center">Login</h4>
                <s:if test="%{error != null }">
                    <div class="alert alert-danger" role="alert">
                        <s:property value="%{error}"/>
                    </div>
                </s:if>
                <div class="form-group">
                    <label >Email :</label>
                    <input type="email" class="form-control" placeholder="Enter username" name="username" value="">
                </div>
                <div class="form-group">
                    <label for="pwd">Password :</label>
                    <input type="password" class="form-control" placeholder="Enter password" name="password" value="">
                </div>
                <div class="g-recaptcha" style="margin-left: 50px; margin-bottom: 10px"
                     data-sitekey="6Le1b60ZAAAAAGT215Aq72gVVkWcgP9SWIt43Bw-"></div>
                <button type="submit" class="btn btn-success w-100">Login</button> 
                <a class="btn btn-info w-100" style="margin-top: 10px; margin-bottom: 10px; color: white" href="registration">Registration</a>
            </form>
        </div>
    </body>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
    crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
    crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
    crossorigin="anonymous"></script>
</html>