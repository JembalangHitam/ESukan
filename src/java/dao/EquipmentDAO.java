package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Equipment;
import util.DBConnection;

public class EquipmentDAO {

    Connection con;

    public EquipmentDAO() {
        con = DBConnection.createConnection();
    }

    // ADD EQUIPMENT
    public boolean addEquipment(Equipment equipment) {

        boolean status = false;

        try {

            String sql =
                "INSERT INTO EQUIPMENTS (EQUIPMENT_NAME, QUANTITY, STATUS) VALUES (?, ?, ?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, equipment.getEquipmentName());
            ps.setInt(2, equipment.getQuantity());
            ps.setString(3, equipment.getStatus());

            status = ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // VIEW ALL EQUIPMENTS
    public List<Equipment> getAllEquipment() {

        List<Equipment> equipmentList =
                new ArrayList<>();

        try {

            String sql = "SELECT * FROM EQUIPMENTS";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Equipment equipment =
                        new Equipment();

                equipment.setEquipmentId(
                        rs.getInt("EQUIPMENT_ID"));

                equipment.setEquipmentName(
                        rs.getString("EQUIPMENT_NAME"));

                equipment.setQuantity(
                        rs.getInt("QUANTITY"));

                equipment.setStatus(
                        rs.getString("STATUS"));

                equipmentList.add(equipment);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return equipmentList;
    }

    // GET EQUIPMENT BY ID
    public Equipment getEquipmentById(int equipmentId) {

        Equipment equipment = null;

        try {

            String sql =
                "SELECT * FROM EQUIPMENTS WHERE EQUIPMENT_ID=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, equipmentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                equipment = new Equipment();

                equipment.setEquipmentId(
                        rs.getInt("EQUIPMENT_ID"));

                equipment.setEquipmentName(
                        rs.getString("EQUIPMENT_NAME"));

                equipment.setQuantity(
                        rs.getInt("QUANTITY"));

                equipment.setStatus(
                        rs.getString("STATUS"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return equipment;
    }

    // UPDATE EQUIPMENT
    public boolean updateEquipment(
            Equipment equipment) {

        boolean status = false;

        try {

            String sql =
                "UPDATE EQUIPMENTS SET EQUIPMENT_NAME=?, QUANTITY=?, STATUS=? WHERE EQUIPMENT_ID=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1,
                    equipment.getEquipmentName());

            ps.setInt(2,
                    equipment.getQuantity());

            ps.setString(3,
                    equipment.getStatus());

            ps.setInt(4,
                    equipment.getEquipmentId());

            status = ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // DELETE EQUIPMENT
    public boolean deleteEquipment(
            int equipmentId) {

        boolean status = false;

        try {

            String sql =
                "DELETE FROM EQUIPMENTS WHERE EQUIPMENT_ID=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, equipmentId);

            status = ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}