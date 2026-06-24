<%-- 
    Document   : myBooking
    Created on : Jun 24, 2026, 11:45:02 PM
    Author     : 20248
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.esukan.dao.BookingDAO"%>
<%@page import="com.esukan.model.Booking"%>
<%@page import="com.esukan.model.User"%>
<%@page import="com.esukan.dao.FacilityDAO"%>

<%
    User user = (User) session.getAttribute("user");

    BookingDAO bookingDAO = new BookingDAO();
    FacilityDAO facilityDAO = new FacilityDAO();

    List<Booking> bookingList
            = bookingDAO.getBookingByUserId(user.getUserId());
%>

<!DOCTYPE html>
<html>
    <head>
        <title>My Booking</title>
    </head>
    <body>

        <h1>My Booking</h1>

        <table border="1">

            <tr>
                <th>Booking ID</th>
                <th>Facility Name</th>
                <th>Booking Date</th>
                <th>Time Slot</th>
                <th>Status</th>
            </tr>

            <%
                for (Booking booking : bookingList) {
            %>

            <tr>

                <td><%=booking.getBookingId()%></td>
                <td><%=facilityDAO.getFacilityNameById(booking.getFacilityId())%></td>
                <td><%=booking.getBookingDate()%></td>
                <td><%=booking.getTimeSlot()%></td>
                <td><%=booking.getBookingStatus()%></td>

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
