/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esukan.dao;

import com.esukan.model.Equipment;
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
public class EquipmentDAO {

    public boolean addEquipment(Equipment equipment) {
        boolean rowInserted = false;
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO EQUIPMENTS(EQUIPMENT_NAME, QUANTITY, STATUS) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, equipment.getEquipmentName());
            ps.setInt(2, equipment.getQuantity());
            ps.setString(3, equipment.getStatus());
            rowInserted = ps.executeUpdate() > 0;
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowInserted;
    }

    public List<Equipment> getAllEquipments() {
        List<Equipment> equipmentList = new ArrayList<Equipment>();
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT * FROM EQUIPMENTS";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Equipment equipment = new Equipment();
                equipment.setEquipmentId(rs.getInt("EQUIPMENT_ID"));
                equipment.setEquipmentName(rs.getString("EQUIPMENT_NAME"));
                equipment.setQuantity(rs.getInt("QUANTITY"));
                equipment.setStatus(rs.getString("STATUS"));
                equipmentList.add(equipment);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return equipmentList;
    }

    public Equipment getEquipmentById(int equipmentId) {

        Equipment equipment = null;

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM EQUIPMENTS WHERE EQUIPMENT_ID=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, equipmentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                equipment = new Equipment();

                equipment.setEquipmentId(rs.getInt("EQUIPMENT_ID"));
                equipment.setEquipmentName(rs.getString("EQUIPMENT_NAME"));
                equipment.setQuantity(rs.getInt("QUANTITY"));
                equipment.setStatus(rs.getString("STATUS"));

            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return equipment;
    }

    public boolean updateEquipment(Equipment equipment) {

        boolean rowUpdated = false;

        try {

            Connection conn = DBConnection.getConnection();

            String sql
                    = "UPDATE EQUIPMENTS SET EQUIPMENT_NAME=?, QUANTITY=?, STATUS=? WHERE EQUIPMENT_ID=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, equipment.getEquipmentName());
            ps.setInt(2, equipment.getQuantity());
            ps.setString(3, equipment.getStatus());
            ps.setInt(4, equipment.getEquipmentId());

            rowUpdated = ps.executeUpdate() > 0;

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowUpdated;
    }

    public boolean deleteEquipment(int equipmentId) {

        boolean rowDeleted = false;

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "DELETE FROM EQUIPMENTS WHERE EQUIPMENT_ID=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, equipmentId);

            rowDeleted = ps.executeUpdate() > 0;

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    public int getEquipmentCount() {

        int count = 0;

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "SELECT COUNT(*) FROM EQUIPMENTS";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                count = rs.getInt(1);

            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    public String getEquipmentNameById(int equipmentId) {

        String equipmentName = "";

        try {

            Connection conn = DBConnection.getConnection();

            String sql
                    = "SELECT EQUIPMENT_NAME FROM EQUIPMENTS WHERE EQUIPMENT_ID=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, equipmentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                equipmentName = rs.getString("EQUIPMENT_NAME");

            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return equipmentName;
    }

    public int getEquipmentQuantity(int equipmentId) {

        int quantity = 0;

        try {

            Connection conn = DBConnection.getConnection();

            String sql
                    = "SELECT QUANTITY FROM EQUIPMENTS WHERE EQUIPMENT_ID=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, equipmentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                quantity = rs.getInt("QUANTITY");

            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return quantity;
    }

    public boolean updateQuantity(int equipmentId,
            int newQuantity) {

        boolean rowUpdated = false;

        try {

            Connection conn = DBConnection.getConnection();

            String sql
                    = "UPDATE EQUIPMENTS SET QUANTITY=? WHERE EQUIPMENT_ID=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, newQuantity);

            ps.setInt(2, equipmentId);

            rowUpdated = ps.executeUpdate() > 0;

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowUpdated;
    }
}
