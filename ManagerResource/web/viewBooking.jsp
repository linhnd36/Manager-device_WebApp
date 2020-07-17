<%-- 
    Document   : viewBooking
    Created on : Jul 16, 2020, 10:19:22 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <s:set var="listbooking" value="%{#session.BOOKING.booking}"/>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Date</th>
                    <th>Quantity</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator var="dto" value="%{#listbooking}">
                    <tr>
                        <td><s:property value="%{#dto.value.resourceDTO.itemName}"/></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                </s:iterator>

            </tbody>
        </table>

    </body>
</html>
