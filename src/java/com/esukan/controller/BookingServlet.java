/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esukan.controller;

import com.esukan.dao.BookingDAO;
import com.esukan.model.Booking;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.esukan.model.User;

/**
 *
 * @author 20248
 */
public class BookingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        if (user == null) {

            response.getWriter().println("User session is NULL. Please login again.");

            return;
        }

        String idStr = request.getParameter("bookingId");

        int facilityId = Integer.parseInt(request.getParameter("facilityId"));

        String bookingDate = request.getParameter("bookingDate");

        String timeSlot = request.getParameter("timeSlot");

        String bookingStatus = request.getParameter("bookingStatus");

        if (bookingStatus == null || bookingStatus.isEmpty()) {

            bookingStatus = "Pending";
        }

        Booking booking = new Booking();

        booking.setUserId(user.getUserId());

        booking.setFacilityId(facilityId);

        booking.setBookingDate(bookingDate);

        booking.setTimeSlot(timeSlot);

        booking.setBookingStatus(bookingStatus);

        BookingDAO bookingDAO = new BookingDAO();

        boolean result;

        if (idStr == null || idStr.isEmpty()) {

            result = bookingDAO.addBooking(booking);

        } else {

            int bookingId = Integer.parseInt(idStr);

            booking.setBookingId(bookingId);

            result = bookingDAO.updateBooking(booking);
        }

        if (result) {

            if (idStr == null || idStr.isEmpty()) {

                response.sendRedirect("myBooking.jsp");

            } else {

                response.sendRedirect("manageBooking.jsp");

            }

        } else {

            response.getWriter().println("Operation Failed!");

        }

    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String deleteId = request.getParameter("deleteId");

        if (deleteId != null) {

            int bookingId = Integer.parseInt(deleteId);

            BookingDAO bookingDAO = new BookingDAO();

            bookingDAO.deleteBooking(bookingId);
        }

        response.sendRedirect("manageBooking.jsp");
    }

}
