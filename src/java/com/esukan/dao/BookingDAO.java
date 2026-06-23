/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esukan.dao;
import com.esukan.model.Booking;
import com.esukan.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author 20248
 */
public class BookingDAO {

    public boolean addBooking(Booking booking) {

        boolean rowInserted = false;

        try {

            Connection conn = DBConnection.getConnection();

            String sql =
                    "INSERT INTO BOOKINGS(USER_ID, FACILITY_ID, BOOKING_DATE, TIME_SLOT) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, booking.getUserId());
            ps.setInt(2, booking.getFacilityId());
            ps.setString(3, booking.getBookingDate());
            ps.setString(4, booking.getTimeSlot());

            rowInserted = ps.executeUpdate() > 0;

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowInserted;
    }

    public List<Booking> getAllBookings() {

        List<Booking> bookingList = new ArrayList<Booking>();

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM BOOKINGS";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Booking booking = new Booking();

                booking.setBookingId(rs.getInt("BOOKING_ID"));
                booking.setUserId(rs.getInt("USER_ID"));
                booking.setFacilityId(rs.getInt("FACILITY_ID"));
                booking.setBookingDate(rs.getString("BOOKING_DATE"));
                booking.setTimeSlot(rs.getString("TIME_SLOT"));

                bookingList.add(booking);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookingList;
    }
}
