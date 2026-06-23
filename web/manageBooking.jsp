<%-- 
    Document   : manageBooking
    Created on : Jun 24, 2026, 12:31:21 AM
    Author     : 20248
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.esukan.dao.BookingDAO"%>
<%@page import="com.esukan.model.Booking"%>

<%
    BookingDAO bookingDAO = new BookingDAO();
    List<Booking> bookingList = bookingDAO.getAllBookings();
%>

<!DOCTYPE html>
<html>
    <head>
        <title>Manage Booking</title>
    </head>
    <body>

        <h1>Manage Booking</h1>

        <form action="BookingServlet" method="post">

            User ID:
            <br>
            <input type="number" name="userId" required>
            <br><br>

            Facility ID:
            <br>
            <input type="number" name="facilityId" required>
            <br><br>

            Booking Date:
            <br>
            <input type="date" name="bookingDate" required>
            <br><br>

            Time Slot:
            <br>
            <input type="text" name="timeSlot" required>
            <br><br>

            <input type="submit" value="Add Booking">

        </form>

        <a href="adminDashboard.jsp">Back to Dashboard</a>

        <hr>

        <h2>Booking List</h2>

        <table border="1">

            <tr>
                <th>ID</th>
                <th>User ID</th>
                <th>Facility ID</th>
                <th>Booking Date</th>
                <th>Time Slot</th>
            </tr>

            <%
                for (Booking booking : bookingList) {
            %>

            <tr>
                <td><%=booking.getBookingId()%></td>
                <td><%=booking.getUserId()%></td>
                <td><%=booking.getFacilityId()%></td>
                <td><%=booking.getBookingDate()%></td>
                <td><%=booking.getTimeSlot()%></td>
            </tr>

            <%
                }
            %>

        </table>

    </body>
</html>
