<%-- 
    Document   : studentDashboard
    Created on : Jun 26, 2026
    Author     : 20248
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.User"%>

<%
    User user = (User) session.getAttribute("user");

    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    if (!"Student".equals(user.getRole())) {
        response.sendRedirect("manager/managerDashboard.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>

    <meta http-equiv="Content-Type"
          content="text/html; charset=UTF-8">

    <title>Student Dashboard</title>

    <link rel="stylesheet"
          href="../css/style.css">

</head>

<body>

    <jsp:include page="../includes/header.jsp"/>

    <h1>Student Dashboard</h1>

    <p>
        Welcome
        <%=user.getFirstName()%>
        <%=user.getLastName()%>
    </p>

    <hr>

    <p><a href="bookFacility.jsp">Book Sport Court</a></p>

    <p><a href="bookEquipment.jsp">Rent Equipment</a></p>

    <p><a href="myBooking.jsp">My Booking</a></p>

    <p><a href="myRental.jsp">My Rental</a></p>

    <jsp:include page="../includes/footer.jsp"/>

</body>
</html>
