package controller;

import dao.BookingDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Booking;

public class BookingServlet extends HttpServlet {

    private BookingDAO bookingDAO;

    @Override
    public void init() {
        bookingDAO = new BookingDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("delete".equals(action)) {
            int bookingId
                    = Integer.parseInt(
                            request.getParameter("id"));
            bookingDAO.deleteBooking(bookingId);
            response.sendRedirect(
                    "manager/manageBooking.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String action
                = request.getParameter("action");

        if ("updateStatus".equals(action)) {

            int bookingId
                    = Integer.parseInt(
                            request.getParameter("bookingId"));

            String status
                    = request.getParameter("status");

            bookingDAO.updateBookingStatus(
                    bookingId,
                    status);

            response.sendRedirect(
                    "manager/manageBooking.jsp");

            return;
        }

        // BOOK FACILITY
        int userId
                = Integer.parseInt(request.getParameter("userId"));

        int facilityId
                = Integer.parseInt(request.getParameter("facilityId"));

        String bookingDate
                = request.getParameter("bookingDate");

        String timeSlot
                = request.getParameter("timeSlot");

        Booking booking = new Booking();

        booking.setUserId(userId);
        booking.setFacilityId(facilityId);
        booking.setBookingDate(bookingDate);
        booking.setTimeSlot(timeSlot);
        booking.setStatus("Pending");

        boolean result
                = bookingDAO.addBooking(booking);

        if (result) {
            response.sendRedirect("student/myBooking.jsp");
        } else {
            request.setAttribute(
                    "errMessage",
                    "Booking failed.");

            request.getRequestDispatcher(
                    "student/bookFacility.jsp")
                    .forward(request, response);
        }
    }
}
