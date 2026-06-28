<%-- 
    Document   : myBooking
    Created on : Jun 26, 2026, 12:47:39 AM
    Author     : 20248
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.BookingDAO"%>
<%@page import="model.Booking"%>
<%@page import="model.User"%>
<%@page import="java.util.List"%>


<%
    User currentUser =
            (User) session.getAttribute("user");

    BookingDAO bookingDAO =
            new BookingDAO();

    List<Booking> bookingList =
            bookingDAO.getBookingsByUser(
                    currentUser.getUserId());
%>


<!DOCTYPE html>
<html>
    <head>
        <title>My Bookings</title>
    </head>

    <body>

        <jsp:include page="../includes/header.jsp"/>

        <h1>My Bookings</h1>

        <hr>

        <table border="1" cellpadding="10">

            <tr>
                <th>Facility</th>
                <th>Booking Date</th>
                <th>Time Slot</th>
                <th>Status</th>
            </tr>

            <%
                for (Booking booking : bookingList) {
            %>

            <tr>

                <td>
                    <%= booking.getFacilityName()%>
                </td>

                <td>
                    <%= booking.getBookingDate()%>
                </td>

                <td>
                    <%= booking.getTimeSlot()%>
                </td>

                <td>
                    <%= booking.getStatus()%>
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
