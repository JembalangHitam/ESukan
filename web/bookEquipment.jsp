<%-- 
    Document   : bookEquipment
    Created on : Jun 25, 2026, 1:20:26 AM
    Author     : 20248
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.esukan.dao.EquipmentDAO"%>
<%@page import="com.esukan.model.Equipment"%>

<%
    EquipmentDAO equipmentDAO = new EquipmentDAO();

    List<Equipment> equipmentList =
            equipmentDAO.getAllEquipments();
%>

<!DOCTYPE html>
<html>
    <head>
        <title>Book Equipment</title>
    </head>
    <body>

        <h1>Book Equipment</h1>

        <form action="RentalServlet" method="post">

            Equipment:
            <br>

            <select name="equipmentId" required>

                <%
                    for (Equipment equipment : equipmentList) {
                %>

                <option value="<%=equipment.getEquipmentId()%>">
                    <%=equipment.getEquipmentName()%>
                </option>

                <%
                    }
                %>

            </select>

            <br><br>

            Quantity:
            <br>
            <input type="number"
                   name="quantity"
                   min="1"
                   required>

            <br><br>

            Rental Date:
            <br>
            <input type="date"
                   name="rentalDate"
                   required>

            <br><br>

            <input type="submit"
                   value="Rent Equipment">

        </form>

        <br>

        <a href="studentDashboard.jsp">
            Back to Dashboard
        </a>

    </body>
</html>
