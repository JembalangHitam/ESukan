<%-- 
    Document   : managerDashboard
    Created on : Jun 26, 2026, 12:46:03 AM
    Author     : 20248
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.User"%>

<%
    User user = (User) session.getAttribute("user");

    if (user == null) {
        response.sendRedirect("../login.jsp");
        return;
    }

    if (!"FacilityManager".equals(user.getRole())) {
        response.sendRedirect("../student/studentDashboard.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Facility Manager Dashboard</title>

        <link rel="stylesheet" href="../css/style.css">
    </head>
    <body>

        <jsp:include page="../includes/header.jsp"/>

        <h1>Facility Manager Dashboard</h1>

        <p>
            Welcome
            <%= user.getFirstName()%>
            <%= user.getLastName()%>
        </p>

        <hr>

        <h3>Facility Management</h3>

        <p>
            <a href="manageFacility.jsp">
                Manage Facilities
            </a>
        </p>

        <h3>Equipment Management</h3>

        <p>
            <a href="manageEquipment.jsp">
                Manage Equipment
            </a>
        </p>

        <h3>Booking Management</h3>

        <p>
            <a href="manageBooking.jsp">
                Manage Bookings
            </a>
        </p>

        <h3>Rental Management</h3>

        <p>
            <a href="manageRental.jsp">
                Manage Rentals
            </a>
        </p>

        <jsp:include page="../includes/footer.jsp"/>

    </body>
</html>