<%-- 
    Document   : viewBooking
    Created on : Jul 19, 2020, 3:43:31 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>

    <head>
        <title>Cart User</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css">
        <title>View Booking</title>
    </head>

    <body>
        <header>
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <a class="navbar-brand" href="search.jsp">Manager Resource</a>
                <div class="collapse navbar-collapse">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="search.jsp">Search</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">History</a>
                        </li>
                        <li class="nav-item ml-5">
                            <span class="text-danger">Welcome <s:property value="%{#session.USER.name}"/> </span>
                        </li>
                    </ul>

                    <a class="btn btn-outline-primary my-2 my-sm-0 ml-2" style="color: white" href="logout"  >LogOut</a>
                </div>
            </nav>
        </header>
        <div class="container">
            <s:set var="listbooking" value="%{#session.BOOKING.booking}"/>
            <s:if test="%{ #listbooking != null }">
                <h3 class="mt-5">Your Booking :</h3>
                <p class="m-2">Date: <strong><s:property value="%{#session.BOOKING.DateBookingFrom}" /> --> <s:property value="%{#session.BOOKING.DateBookingTo}" /></strong></p>
                <table id="cart" class="table table-hover table-condensed">
                    <thead>
                        <tr>
                            <th style="width: 32%;">Tour</th>
                            <th style="width: 10%;">ID</th>
                            <th style="width: 15%;">Category</th>
                            <th style="width: 10%;">Color</th>
                            <th style="width: 8%;">Quantity</th>
                            <th style="width: 10%;">Action</th>
                        </tr>
                    </thead>
                    <tbody>

                        <s:iterator var="dto" value="%{#listbooking}">
                        <form action="update-cart">
                            <tr>
                                <td>
                                    <div class="row">
                                        <div class="col-sm-7">
                                            <h5 class="nomargin"><s:property value="%{#dto.value.resourceDTO.itemName}"/></h5>
                                        </div>
                                    </div>
                                </td>
                                <td> <s:property value="%{#dto.value.resourceDTO.resourceId}"/> </td>
                                <td ><s:property value="%{#dto.value.resourceDTO.category}"/> </td>
                                <td ><s:property value="%{#dto.value.resourceDTO.color}"/>  </td>
                                <td data-th="Quantity">
                                    <input type="number" class="form-control text-center" name="QuantityNew" min="1" value="<s:property value="%{#dto.value.quantity}"/>" />
                                    <p class="text-danger">Only <s:property value="%{#dto.value.resourceDTO.quantityLeft}"/> left.</p>
                                </td>
                                <td class="actions" data-th="">
                                    <button type="submit" class="btn btn-info">Update</button>
                                    <s:url var="urldelete" value="delete-booking">
                                        <s:param name="ResourceId" value="%{#dto.value.resourceDTO.resourceId}" />
                                    </s:url>
                                    <a href="<s:property value="%{#urldelete}"/>" class="btn btn-danger">Delete</a>
                                    <input type="hidden" name="ResourceId" value="<s:property value="%{#dto.value.resourceDTO.resourceId}"/>" />
                                </td>
                            </tr>
                        </form>
                    </s:iterator>

                    </tbody>
                    <tfoot>
                        <tr>
                            <td>
                                <a href="search.jsp" class="btn btn-warning"><i class="fa fa-angle-left"></i> Continue
                                    Booking</a>
                            </td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td>
                                <a href="check-out" class="btn btn-success btn-block">Booking </a>
                            </td>
                        </tr>
                    </tfoot>
                </table>
            </s:if>
            <s:if test="%{#listbooking == null}">
                <div class="alert alert-danger" role="alert">
                    No Resource in booking !
                </div>
            </s:if>
            <s:if test="%{listError != null}">
                <div class="alert alert-warning" role="alert">
                    <s:iterator var="dtoE" value="%{listError}">
                        <s:property value="%{#dtoE}"/>
                    </s:iterator>
                </div>
            </s:if>
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                    integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                    integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
            <script src="./js/view.js"></script>

    </body>

</html>