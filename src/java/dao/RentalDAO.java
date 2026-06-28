package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Rental;
import util.DBConnection;

public class RentalDAO {

    private Connection conn;

    public RentalDAO() {
        conn = DBConnection.getConnection();
    }

    public boolean addRental(Rental rental) {

        boolean status = false;

        try {

            String sql
                    = "INSERT INTO RENTALS "
                    + "(USER_ID, EQUIPMENT_ID, QUANTITY, RENTAL_DATE) "
                    + "VALUES (?, ?, ?, ?)";

            PreparedStatement ps
                    = conn.prepareStatement(sql);

            ps.setInt(1, rental.getUserId());
            ps.setInt(2, rental.getEquipmentId());
            ps.setInt(3, rental.getQuantity());
            ps.setString(4, rental.getRentalDate());

            status = ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public List<Rental> getAllRentals() {

        List<Rental> rentalList
                = new ArrayList<>();

        try {

            String sql
                    = "SELECT R.*, E.EQUIPMENT_NAME "
                    + "FROM RENTALS R "
                    + "JOIN EQUIPMENTS E "
                    + "ON R.EQUIPMENT_ID = E.EQUIPMENT_ID";

            PreparedStatement ps
                    = conn.prepareStatement(sql);

            ResultSet rs
                    = ps.executeQuery();

            while (rs.next()) {

                Rental rental
                        = new Rental();

                rental.setRentalId(
                        rs.getInt("RENTAL_ID"));

                rental.setUserId(
                        rs.getInt("USER_ID"));

                rental.setEquipmentId(
                        rs.getInt("EQUIPMENT_ID"));

                rental.setQuantity(
                        rs.getInt("QUANTITY"));

                rental.setRentalDate(
                        rs.getString("RENTAL_DATE"));

                rental.setEquipmentName(
                        rs.getString("EQUIPMENT_NAME"));

                rentalList.add(rental);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rentalList;
    }

    public List<Rental> getRentalsByUser(int userId) {

        List<Rental> rentalList
                = new ArrayList<>();

        try {

            String sql
                    = "SELECT R.*, E.EQUIPMENT_NAME "
                    + "FROM RENTALS R "
                    + "JOIN EQUIPMENTS E "
                    + "ON R.EQUIPMENT_ID = E.EQUIPMENT_ID "
                    + "WHERE R.USER_ID=?";

            PreparedStatement ps
                    = conn.prepareStatement(sql);

            ps.setInt(1, userId);

            ResultSet rs
                    = ps.executeQuery();

            while (rs.next()) {

                Rental rental
                        = new Rental();

                rental.setRentalId(
                        rs.getInt("RENTAL_ID"));

                rental.setUserId(
                        rs.getInt("USER_ID"));

                rental.setEquipmentId(
                        rs.getInt("EQUIPMENT_ID"));

                rental.setQuantity(
                        rs.getInt("QUANTITY"));

                rental.setRentalDate(
                        rs.getString("RENTAL_DATE"));

                rental.setEquipmentName(
                        rs.getString("EQUIPMENT_NAME"));

                rentalList.add(rental);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rentalList;
    }

    public boolean deleteRental(int rentalId) {

        boolean status = false;

        try {

            String sql
                    = "DELETE FROM RENTALS "
                    + "WHERE RENTAL_ID=?";

            PreparedStatement ps
                    = conn.prepareStatement(sql);

            ps.setInt(1, rentalId);

            status = ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}
