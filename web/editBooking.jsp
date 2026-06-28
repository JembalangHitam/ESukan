<%-- 
    Document   : editBooking
    Created on : Jun 24, 2026, 11:39:24 PM
    Author     : 20248
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.esukan.dao.BookingDAO"%>
<%@page import="com.esukan.model.Booking"%>

<%
    int bookingId = Integer.parseInt(request.getParameter("id"));

    BookingDAO bookingDAO = new BookingDAO();

    Booking booking = bookingDAO.getBookingById(bookingId);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Edit Booking</title>
    </head>
    <body>

        <h1>Edit Booking</h1>

        <form action="BookingServlet" method="post">

            <input type="hidden"
                   name="bookingId"
                   value="<%=booking.getBookingId()%>">

            Facility ID:
            <br>
            <input type="number"
                   name="facilityId"
                   value="<%=booking.getFacilityId()%>">
            <br><br>

            Booking Date:
            <br>
            <input type="date"
                   name="bookingDate"
                   value="<%=booking.getBookingDate()%>">
            <br><br>

            Time Slot:
            <br>
            <input type="text"
                   name="timeSlot"
                   value="<%=booking.getTimeSlot()%>">
            <br><br>

            Status:
            <br>

            <select name="bookingStatus">

                <option><%=booking.getBookingStatus()%></option>

                <option>Pending</option>
                <option>Approved</option>
                <option>Rejected</option>

            </select>

            <br><br>

            <input type="submit" value="Update Booking">

        </form>

    </body>
</html>
