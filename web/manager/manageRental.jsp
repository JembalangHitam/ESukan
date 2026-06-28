<%-- 
    Document   : manageRental
    Created on : Jun 26, 2026, 12:48:36 AM
    Author     : 20248
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.RentalDAO"%>
<%@page import="model.Rental"%>
<%@page import="java.util.List"%>

<%
    RentalDAO rentalDAO = new RentalDAO();

    List<Rental> rentalList =
            rentalDAO.getAllRentals();
%>

<!DOCTYPE html>
<html>
    <head>
        <title>Rental Management</title>
        <link rel="stylesheet"
              href="../css/style.css">
    </head>

    <body>

        <jsp:include page="../includes/header.jsp"/>

        <h1>Rental Management</h1>

        <hr>

        <table border="1" cellpadding="10">

            <tr>
                <th>Rental ID</th>
                <th>User ID</th>
                <th>Equipment ID</th>
                <th>Quantity</th>
                <th>Rental Date</th>
                <th>Delete</th>
            </tr>

            <%
                for (Rental rental : rentalList) {
            %>

            <tr>

                <td>
                    <%= rental.getRentalId()%>
                </td>

                <td>
                    <%= rental.getUserId()%>
                </td>

                <td>
                    <%= rental.getEquipmentId()%>
                </td>

                <td>
                    <%= rental.getQuantity()%>
                </td>

                <td>
                    <%= rental.getRentalDate()%>
                </td>

                <td>
                    <a href="../RentalServlet?action=delete&id=<%= rental.getRentalId()%>">
                        Delete
                    </a>
                </td>

            </tr>

            <%
                }
            %>

        </table>

        <br>

        <a href="managerDashboard.jsp">
            Back to Dashboard
        </a>

        <jsp:include page="../includes/footer.jsp"/>

    </body>
</html>
