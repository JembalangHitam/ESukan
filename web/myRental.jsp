<%-- 
    Document   : myRental
    Created on : Jun 25, 2026, 1:22:45 AM
    Author     : 20248
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.esukan.dao.RentalDAO"%>
<%@page import="com.esukan.dao.EquipmentDAO"%>
<%@page import="com.esukan.model.Rental"%>
<%@page import="com.esukan.model.User"%>

<%
    User user = (User) session.getAttribute("user");

    RentalDAO rentalDAO = new RentalDAO();

    EquipmentDAO equipmentDAO = new EquipmentDAO();

    List<Rental> rentalList
            = rentalDAO.getRentalByUserId(user.getUserId());
%>

<!DOCTYPE html>
<html>
    <head>
        <title>My Rental</title>
    </head>
    <body>

        <h1>My Equipment Rental</h1>

        <table border="1">

            <tr>
                <th>Rental ID</th>
                <th>Equipment Name</th>
                <th>Quantity</th>
                <th>Rental Date</th>
            </tr>

            <%
                for (Rental rental : rentalList) {
            %>

            <tr>

                <td><%=rental.getRentalId()%></td>

                <td>
                    <%=equipmentDAO.getEquipmentNameById(
            rental.getEquipmentId())%>
                </td>

                <td><%=rental.getQuantity()%></td>

                <td><%=rental.getRentalDate()%></td>

            </tr>

            <%
                }
            %>

        </table>

        <br>

        <a href="studentDashboard.jsp">
            Back to Dashboard
        </a>

    </body>
</html>
