<%-- 
    Document   : manageBooking
    Created on : Jun 26, 2026, 12:47:47 AM
    Author     : 20248
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.BookingDAO"%>
<%@page import="model.Booking"%>
<%@page import="java.util.List"%>

<%
    BookingDAO bookingDAO = new BookingDAO();

    List<Booking> bookingList
            = bookingDAO.getAllBookings();
%>

<!DOCTYPE html>
<html>
    <head>
        <title>Booking Management</title>
        <link rel="stylesheet"
              href="../css/style.css">
    </head>
    <body>
        <jsp:include page="../includes/header.jsp"/>
        <h1>Booking Management</h1>
        <hr>
        <table border="1" cellpadding="10">
            <tr>
                <th>Booking ID</th>
                <th>User ID</th>
                <th>Facility ID</th>
                <th>Booking Date</th>
                <th>Time Slot</th>
                <th>Status</th>
                <th>Delete</th>
            </tr>
            <%
                for (Booking booking : bookingList) {
            %>
            <tr>
                <td>
                    <%= booking.getBookingId()%>
                </td>
                <td>
                    <%= booking.getUserId()%>
                </td>
                <td>
                    <%= booking.getFacilityId()%>
                </td>
                <td>
                    <%= booking.getBookingDate()%>
                </td>
                <td>
                    <%= booking.getTimeSlot()%>
                </td>
                <td>
                    <form action="../BookingServlet" method="post">

                        <input type="hidden"
                               name="action"
                               value="updateStatus">

                        <input type="hidden"
                               name="bookingId"
                               value="<%= booking.getBookingId()%>">

                        <select name="status">

                            <option value="Pending"
                                    <%= "Pending".equals(booking.getStatus()) ? "selected" : ""%>>
                                Pending
                            </option>

                            <option value="Approved"
                                    <%= "Approved".equals(booking.getStatus()) ? "selected" : ""%>>
                                Approved
                            </option>

                            <option value="Rejected"
                                    <%= "Rejected".equals(booking.getStatus()) ? "selected" : ""%>>
                                Rejected
                            </option>

                        </select>

                        <input type="submit"
                               value="Update">

                    </form>
                </td>
                <td>
                    <a href="../BookingServlet?action=delete&id=<%= booking.getBookingId()%>">
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