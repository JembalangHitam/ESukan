package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Booking;
import util.DBConnection;

public class BookingDAO {

    Connection con;

    public BookingDAO() {
        con = DBConnection.createConnection();
    }

    // ADD BOOKING
    public boolean addBooking(Booking booking) {

        boolean status = false;

        try {

            System.out.println("USER_ID = " + booking.getUserId());
            System.out.println("FACILITY_ID = " + booking.getFacilityId());
            System.out.println("DATE = " + booking.getBookingDate());
            System.out.println("TIME = " + booking.getTimeSlot());
            System.out.println("STATUS = " + booking.getStatus());

            String sql
                    = "INSERT INTO BOOKINGS (USER_ID, FACILITY_ID, BOOKING_DATE, TIME_SLOT, BOOKING_STATUS) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps
                    = con.prepareStatement(sql);

            ps.setInt(1, booking.getUserId());
            ps.setInt(2, booking.getFacilityId());
            ps.setString(3, booking.getBookingDate());
            ps.setString(4, booking.getTimeSlot());
            ps.setString(5, booking.getStatus());

            status = ps.executeUpdate() > 0;

            System.out.println("INSERT STATUS = " + status);

        } catch (Exception e) {

            System.out.println("BOOKING INSERT ERROR");
            e.printStackTrace();

        }

        return status;
    }

    // VIEW ALL BOOKINGS for manager
    public List<Booking> getAllBookings() {

        List<Booking> bookingList
                = new ArrayList<>();

        try {

            String sql
                    = "SELECT B.*, F.FACILITY_NAME "
                    + "FROM BOOKINGS B "
                    + "JOIN FACILITIES F "
                    + "ON B.FACILITY_ID = F.FACILITY_ID";

            PreparedStatement ps
                    = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Booking booking
                        = new Booking();

                booking.setFacilityName(
                        rs.getString("FACILITY_NAME"));

                booking.setBookingDate(
                        rs.getString("BOOKING_DATE"));

                booking.setTimeSlot(
                        rs.getString("TIME_SLOT"));

                booking.setStatus(
                        rs.getString("BOOKING_STATUS"));

                bookingList.add(booking);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bookingList;
    }

    // DELETE BOOKING
    public boolean deleteBooking(int bookingId) {

        boolean status = false;

        try {

            String sql
                    = "DELETE FROM BOOKINGS WHERE BOOKING_ID=?";

            PreparedStatement ps
                    = con.prepareStatement(sql);

            ps.setInt(1, bookingId);

            status = ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // UPDATE BOOKING STATUS
    public boolean updateBookingStatus(
            int bookingId,
            String status) {

        boolean result = false;

        try {

            String sql
                    = "UPDATE BOOKINGS SET BOOKING_STATUS=? WHERE BOOKING_ID=?";

            PreparedStatement ps
                    = con.prepareStatement(sql);

            ps.setString(1, status);
            ps.setInt(2, bookingId);

            result = ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    
    //For current user student see their booking
    public List<Booking> getBookingsByUser(int userId) {

        List<Booking> bookingList
                = new ArrayList<>();

        try {

            String sql
                    = "SELECT B.*, F.FACILITY_NAME "
                    + "FROM BOOKINGS B "
                    + "JOIN FACILITIES F "
                    + "ON B.FACILITY_ID = F.FACILITY_ID "
                    + "WHERE B.USER_ID=?";

            PreparedStatement ps
                    = con.prepareStatement(sql);

            ps.setInt(1, userId);

            ResultSet rs
                    = ps.executeQuery();

            while (rs.next()) {

                Booking booking
                        = new Booking();

                booking.setBookingId(
                        rs.getInt("BOOKING_ID"));

                booking.setUserId(
                        rs.getInt("USER_ID"));

                booking.setFacilityId(
                        rs.getInt("FACILITY_ID"));

                booking.setBookingDate(
                        rs.getString("BOOKING_DATE"));

                booking.setTimeSlot(
                        rs.getString("TIME_SLOT"));

                booking.setStatus(
                        rs.getString("BOOKING_STATUS"));

                booking.setFacilityName(
                        rs.getString("FACILITY_NAME"));

                bookingList.add(booking);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bookingList;
    }
}
