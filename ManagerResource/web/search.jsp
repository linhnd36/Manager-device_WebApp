<%-- 
    Document   : search
    Created on : Jul 6, 2020, 6:43:34 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!doctype html>
<html lang="en">

    <head>
        <title>Search Page</title>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Search Page</title>
    </head>

    <body>
        <div>
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <a class="navbar-brand" href="#">Manager Resource</a>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Search</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link " href="#">History</a>
                        </li>
                        <li class="nav-item" style="margin-left: 30px;">
                            <span class="text-danger">Welcome <s:property value="%{#session.USER.name}"/> </span>
                        </li>
                    </ul>
                    <a class="btn btn-outline-info my-2 my-sm-0 " style="color: white" href="view-booking"  >View Booking</a>
                    <a class="btn btn-outline-primary my-2 my-sm-0 ml-2" style="color: white" href="logout"  >LogOut</a>
                </div>
            </nav>
        </div>
        <div class="container">
            <h1 class="mt-3">Search Resource: </h1>
            <form action="search-action">
                <div class="row">
                    <div class="form-group col-6">
                        <label for="formGroupExampleInput">Name Resource: </label>
                        <input type="text" class="form-control" placeholder="Name Resource" name="nameSearch" value="<s:property value="%{nameSearch}"/>">
                    </div>
                    <div class="form-group col-6">
                        <label for="formGroupExampleInput2">Category Resource: </label>
                        <input type="text" class="form-control" placeholder="Category Resource" name="categorySearch" value="<s:property value="%{categorySearch}"/>">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="form-group col-5">
                        <label for="formGroupExampleInput2">Date From:</label>
                        <input type="date" class="form-control" min="<s:property value="%{#session.DATENOW}"/>" name="dateSearchFrom" value="<s:property value="%{dateSearchFrom}"/>">
                    </div>
                    <h5 class="mt-5">=======></h5>
                    <div class="form-group col-5">
                        <label for="formGroupExampleInput2">Date To:</label>
                        <input type="date" class="form-control"  min="<s:property value="%{#session.DATENOW}"/>" name="dateSearchTo" value="<s:property value="%{dateSearchTo}"/>">
                    </div>
                </div>
                <button type="submit" class="btn btn-success w-25 mt-3">Search</button>
            </form>
            <div class="pt-5">
                <div class="row">
                    <s:if test="%{subListResource != null}">
                        <s:iterator var="dto" value="subListResource" >
                            <div class="col-sm-6 pt-2">
                                <div class="card">
                                    <div class="card-body">
                                        <h5 class="card-title"><s:property value="ItemName"/></h5>
                                        <p class="card-text">Category : <s:property value="Category"/>   ---   Color: <s:property value="Color"/> --- Quantity: <s:property value="Quantity"/>
                                        </p>
                                        <p class="text-danger">Quantity Left: <s:property value="QuantityLeft"/></p>
                                        <s:url var="urlAddLink" value="add-to-card" escapeAmp="false">
                                            <s:param name="ResourceId" value="%{ResourceId}"/>
                                            <s:param name="nameSearch" value="%{nameSearch}"/> 
                                            <s:param name="categorySearch" value="%{categorySearch}"/> 
                                            <s:param name="dateSearchFrom" value="%{dateSearchFrom}"/> 
                                            <s:param name="dateSearchTo" value="%{dateSearchTo}"/> 
                                        </s:url> 
                                        <a href="<s:property value="%{#urlAddLink}"/>" class="btn btn-primary">Add to Booking</a>
                                       
                                    </div>
                                </div>
                            </div>
                        </s:iterator>
                    </s:if>
                    <s:if test="%{checkList != null}">
                        <div class="alert alert-danger w-75" role="alert">
                            <s:property value="checkList"/>
                        </div>
                    </s:if>
                </div>
                <nav>
                    <s:if test="%{Page > 1 }">
                        <ul class="pagination pt-2" style="margin-left: 40%;">
                            <s:iterator var="indexS" begin="1" end="Page">
                                <form action="search-action">
                                    <li class="page-item 
                                        <s:if test="%{#indexS == index}">
                                            active
                                        </s:if>
                                        ">
                                        <input class="page-link" type="submit" value="<s:property value="%{#indexS}"/>" name="pageSearchIndex"/>
                                        <input type="hidden" name="nameSearch" value="<s:property value="%{nameSearch}"/>">
                                        <input type="hidden" name="categorySearch" value="<s:property value="%{categorySearch}"/>">
                                        <input type="hidden" name="dateSearchFrom" value="<s:property value="%{dateSearchFrom}"/>">
                                        <input type="hidden" name="dateSearchTo" value="<s:property value="%{dateSearchTo}"/>">
                                    </li>
                                </form>
                            </s:iterator>
                        </ul>
                    </s:if>                      
                </nav>
            </div>
            <div class="pb-5"></div>
        </div>



        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
    </body>
</html>