/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esukan.dao;
import com.esukan.model.Rental;
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
public class RentalDAO {

    public boolean addRental(Rental rental) {

        boolean rowInserted = false;

        try {

            Connection conn = DBConnection.getConnection();

            String sql =
                    "INSERT INTO RENTALS(USER_ID, EQUIPMENT_ID, QUANTITY, RENTAL_DATE) "
                    + "VALUES (?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, rental.getUserId());
            ps.setInt(2, rental.getEquipmentId());
            ps.setInt(3, rental.getQuantity());
            ps.setString(4, rental.getRentalDate());

            rowInserted = ps.executeUpdate() > 0;

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowInserted;
    }

    public List<Rental> getAllRentals() {

        List<Rental> rentalList = new ArrayList<Rental>();

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM RENTALS";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Rental rental = new Rental();

                rental.setRentalId(rs.getInt("RENTAL_ID"));
                rental.setUserId(rs.getInt("USER_ID"));
                rental.setEquipmentId(rs.getInt("EQUIPMENT_ID"));
                rental.setQuantity(rs.getInt("QUANTITY"));
                rental.setRentalDate(rs.getString("RENTAL_DATE"));

                rentalList.add(rental);
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rentalList;
    }

    public List<Rental> getRentalByUserId(int userId) {

        List<Rental> rentalList = new ArrayList<Rental>();

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM RENTALS WHERE USER_ID=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Rental rental = new Rental();

                rental.setRentalId(rs.getInt("RENTAL_ID"));
                rental.setUserId(rs.getInt("USER_ID"));
                rental.setEquipmentId(rs.getInt("EQUIPMENT_ID"));
                rental.setQuantity(rs.getInt("QUANTITY"));
                rental.setRentalDate(rs.getString("RENTAL_DATE"));

                rentalList.add(rental);
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rentalList;
    }
}
