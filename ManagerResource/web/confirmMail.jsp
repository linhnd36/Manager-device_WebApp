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
        <title>ConFirm Mail Page</title>
    </head>
    <body class="bgLogin">
        <div class="loginclass">
            <form action="confirm-mail" method="POST" class="p-4" style="background-color: white; margin-top: 50px; border-radius: 2%;">
                <h1 class="text-center">Manager Resource</h1>
                <h4 class="text-center">ConFirm Mail</h4>
                <p>Check your mail and get Code !</p>
                <div class="form-group">
                    <label >Code :</label>
                    <input type="text" class="form-control" placeholder="Enter Code" name="code" value="">
                </div>
                <s:if test="%{errors != null}">
                    <div class="alert alert-danger" role="alert">
                        <s:property value="errors"/>
                    </div>
                </s:if>
                <button type="submit" class="btn btn-success w-100">Confirm</button> 
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