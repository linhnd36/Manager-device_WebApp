<%-- 
    Document   : signup
    Created on : Jul 14, 2020, 6:48:16 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>Sign Up Page</title>
    </head>

    <body class="bgLogin">
        <div class="loginclass">
            <form action="signup" method="POST" class="p-4"
                  style="background-color: white; margin-top: 50px; border-radius: 2%; ">
                <h1 class="text-center">Manager Resource</h1>
                <h4 class="text-center">SignUp</h4>
                <div class="form-group">
                    <label>Email :</label>
                    <input type="email" class="form-control" placeholder="Enter email" name="Email">
                </div>
                <div class="form-group">
                    <label for="pwd">Password :</label>
                    <input type="password" class="form-control" placeholder="Enter Password" name="Password">
                </div>
                <div class="form-group">
                    <label for="pwd">Password Confirm:</label>
                    <input type="password" class="form-control" placeholder="Enter Password Confirm:" name="PasswordConfirm:">
                </div>
                <div class="form-group">
                    <label for="pwd">Name :</label>
                    <input type="text" class="form-control" placeholder="Enter name" name="Name">
                </div>
                <div class="form-group">
                    <label for="pwd">Phone :</label>
                    <input type="tel" class="form-control" name="Phone" placeholder="Enter phone" pattern="[0-9]{10}">
                </div>
                <div class="form-group">
                    <label for="pwd">Address :</label>
                    <input type="text" class="form-control" placeholder="Enter Address" name="Address">
                </div>
                <button type="submit" class="btn btn-success w-100">Registration</button>
            </form>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
                integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
                integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
                integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
    </body>

</html>