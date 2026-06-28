<%-- 
    Document   : bookFacility
    Created on : Jun 26, 2026, 12:47:30 AM
    Author     : 20248
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.FacilityDAO"%>
<%@page import="model.Facility"%>
<%@page import="model.User"%>
<%@page import="java.util.List"%>

<%
    User currentUser =
            (User) session.getAttribute("user");

    if (currentUser == null) {
        response.sendRedirect("../login.jsp");
        return;
    }

    FacilityDAO facilityDAO = new FacilityDAO();
    List<Facility> facilityList =
            facilityDAO.getAllFacilities();
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type"
              content="text/html; charset=UTF-8">
        <title>Book Facility</title>
    </head>

    <body>

        <jsp:include page="../includes/header.jsp"/>

        <h1>Book Facility</h1>

        <form action="../BookingServlet" method="post">

            <!-- Logged-in User ID -->
            <input type="hidden"
                   name="userId"
                   value="<%= currentUser.getUserId()%>">

            <table>

                <tr>
                    <td>Facility</td>
                    <td>
                        <select name="facilityId" required>

                            <option value="">
                                Select Facility
                            </option>

                            <%
                                for (Facility facility : facilityList) {
                            %>

                            <option value="<%= facility.getFacilityId()%>">
                                <%= facility.getFacilityName()%>
                            </option>

                            <%
                                }
                            %>

                        </select>
                    </td>
                </tr>

                <tr>
                    <td>Booking Date</td>
                    <td>
                        <input type="date"
                               name="bookingDate"
                               required>
                    </td>
                </tr>

                <tr>
                    <td>Time Slot</td>
                    <td>
                        <select name="timeSlot" required>

                            <option value="8AM-10AM">
                                8AM-10AM
                            </option>

                            <option value="10AM-12PM">
                                10AM-12PM
                            </option>

                            <option value="2PM-4PM">
                                2PM-4PM
                            </option>

                            <option value="4PM-6PM">
                                4PM-6PM
                            </option>

                        </select>
                    </td>
                </tr>

                <tr>
                    <td colspan="2">
                        <input type="submit"
                               value="Book Facility">
                    </td>
                </tr>

            </table>

        </form>

        <br>

        <a href="studentDashboard.jsp">
            Back to Dashboard
        </a>

        <jsp:include page="../includes/footer.jsp"/>

    </body>
</html>
