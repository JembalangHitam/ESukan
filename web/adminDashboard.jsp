<%-- 
    Document   : adminDashboard
    Created on : Jun 19, 2026, 4:11:22 AM
    Author     : 20248
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.esukan.dao.UserDAO"%>
<%@page import="com.esukan.dao.FacilityDAO"%>
<%@page import="com.esukan.dao.EquipmentDAO"%>
<%@page import="com.esukan.dao.BookingDAO"%>

<%
if (session.getAttribute("user") == null) {
    response.sendRedirect("login.jsp");
    return;
}

UserDAO userDAO = new UserDAO();
FacilityDAO facilityDAO = new FacilityDAO();
EquipmentDAO equipmentDAO = new EquipmentDAO();
BookingDAO bookingDAO = new BookingDAO();
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin Dashboard</title>
    </head>
    <body>

        <h1>Welcome Admin</h1>

        <a href="manageFacility.jsp">Manage Facilities</a>
        <br><br>

        <a href="manageEquipment.jsp">Manage Equipment</a>
        <br><br>

        <a href="manageBooking.jsp">Manage Booking</a>
        <br><br>

        <a href="LogoutServlet">Logout</a>
        <hr>
        <h2>Dashboard Summary</h2>
Total Users: <%=userDAO.getUserCount()%>
<br><br>

Total Facilities: <%=facilityDAO.getFacilityCount()%>
<br><br>

Total Equipments: <%=equipmentDAO.getEquipmentCount()%>
<br><br>

Total Bookings: <%=bookingDAO.getBookingCount()%>

    </body>
</html>