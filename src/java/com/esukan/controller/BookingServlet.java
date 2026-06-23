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
/**
 *
 * @author 20248
 */
public class BookingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int userId = Integer.parseInt(request.getParameter("userId"));
        int facilityId = Integer.parseInt(request.getParameter("facilityId"));
        String bookingDate = request.getParameter("bookingDate");
        String timeSlot = request.getParameter("timeSlot");

        Booking booking = new Booking();

        booking.setUserId(userId);
        booking.setFacilityId(facilityId);
        booking.setBookingDate(bookingDate);
        booking.setTimeSlot(timeSlot);

        BookingDAO bookingDAO = new BookingDAO();

        boolean result = bookingDAO.addBooking(booking);

        if (result) {

            response.sendRedirect("manageBooking.jsp");

        } else {

            response.getWriter().println("Booking Failed!");

        }

    }

}

