<%-- 
    Document   : myRental
    Created on : Jun 26, 2026, 12:48:23 AM
    Author     : 20248
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.RentalDAO"%>
<%@page import="model.Rental"%>
<%@page import="java.util.List"%>
<%@page import="model.User"%>

<%
    RentalDAO rentalDAO = new RentalDAO();

    User currentUser
            = (User) session.getAttribute("user");

    List<Rental> rentalList
            = rentalDAO.getRentalsByUser(
                    currentUser.getUserId());
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type"
              content="text/html; charset=UTF-8">
        <title>My Rentals</title>
    </head>

    <body>

        <jsp:include page="../includes/header.jsp"/>

        <h1>My Rentals</h1>

        <hr>

        <table border="1" cellpadding="10">

            <tr>
                <th>Equipment</th>
                <th>Quantity</th>
                <th>Rental Date</th>
            </tr>

            <%
                for (Rental rental : rentalList) {
            %>

            <tr>

                <td><%= rental.getEquipmentName()%></td>
                <td>
                    <%= rental.getQuantity()%>
                </td>

                <td>
                    <%= rental.getRentalDate()%>
                </td>

            </tr>

            <%
                }
            %>

        </table>

        <br>

        <a href="studentDashboard.jsp">
            Back to Dashboard
        </a>

        <jsp:include page="../includes/footer.jsp"/>

    </body>
</html>
