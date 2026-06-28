<%-- 
    Document   : editEquipment
    Created on : Jun 24, 2026, 12:21:45 AM
    Author     : 20248
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.esukan.dao.EquipmentDAO"%>
<%@page import="com.esukan.model.Equipment"%>

<%
    int equipmentId = Integer.parseInt(request.getParameter("id"));

    EquipmentDAO equipmentDAO = new EquipmentDAO();

    Equipment equipment = equipmentDAO.getEquipmentById(equipmentId);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Edit Equipment</title>
    </head>
    <body>

        <h1>Edit Equipment</h1>

        <form action="EquipmentServlet" method="post">

            <input type="hidden"
                   name="equipmentId"
                   value="<%=equipment.getEquipmentId()%>">

            Equipment Name:
            <br>
            <input type="text"
                   name="equipmentName"
                   value="<%=equipment.getEquipmentName()%>">
            <br><br>

            Quantity:
            <br>
            <input type="number"
                   name="quantity"
                   value="<%=equipment.getQuantity()%>">
            <br><br>

            Status:
            <br>

            <select name="status">

                <option><%=equipment.getStatus()%></option>

                <option>Available</option>
                <option>Damaged</option>
                <option>In-Maintenance</option>

            </select>

            <br><br>

            <input type="submit" value="Update Equipment">

        </form>

    </body>
</html>
