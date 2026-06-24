/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esukan.dao;

import com.esukan.model.Facility;
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
public class FacilityDAO {

    public boolean addFacility(Facility facility) {
        boolean rowInserted = false;
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO FACILITIES(FACILITY_NAME, LOCATION, STATUS) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, facility.getFacilityName());
            ps.setString(2, facility.getLocation());
            ps.setString(3, facility.getStatus());
            rowInserted = ps.executeUpdate() > 0;
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowInserted;
    }

    public List<Facility> getAllFacilities() {
        List<Facility> facilityList = new ArrayList<Facility>();

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM FACILITIES";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Facility facility = new Facility();

                facility.setFacilityId(rs.getInt("FACILITY_ID"));
                facility.setFacilityName(rs.getString("FACILITY_NAME"));
                facility.setLocation(rs.getString("LOCATION"));
                facility.setStatus(rs.getString("STATUS"));

                facilityList.add(facility);
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return facilityList;
    }

    public Facility getFacilityById(int facilityId) {

        Facility facility = null;

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM FACILITIES WHERE FACILITY_ID=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, facilityId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                facility = new Facility();

                facility.setFacilityId(rs.getInt("FACILITY_ID"));
                facility.setFacilityName(rs.getString("FACILITY_NAME"));
                facility.setLocation(rs.getString("LOCATION"));
                facility.setStatus(rs.getString("STATUS"));

            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return facility;
    }

    public boolean updateFacility(Facility facility) {

        boolean rowUpdated = false;

        try {

            Connection conn = DBConnection.getConnection();

            String sql
                    = "UPDATE FACILITIES SET FACILITY_NAME=?, LOCATION=?, STATUS=? WHERE FACILITY_ID=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, facility.getFacilityName());
            ps.setString(2, facility.getLocation());
            ps.setString(3, facility.getStatus());
            ps.setInt(4, facility.getFacilityId());

            rowUpdated = ps.executeUpdate() > 0;

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowUpdated;
    }

    public boolean deleteFacility(int facilityId) {

        boolean rowDeleted = false;

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "DELETE FROM FACILITIES WHERE FACILITY_ID=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, facilityId);

            rowDeleted = ps.executeUpdate() > 0;

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowDeleted;
    }

    public int getFacilityCount() {

        int count = 0;

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "SELECT COUNT(*) FROM FACILITIES";

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

    public List<Facility> getAvailableFacilities() {

        List<Facility> facilityList = new ArrayList<Facility>();

        try {

            Connection conn = DBConnection.getConnection();

            String sql
                    = "SELECT * FROM FACILITIES WHERE STATUS='Available'";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Facility facility = new Facility();

                facility.setFacilityId(rs.getInt("FACILITY_ID"));
                facility.setFacilityName(rs.getString("FACILITY_NAME"));
                facility.setLocation(rs.getString("LOCATION"));
                facility.setStatus(rs.getString("STATUS"));

                facilityList.add(facility);
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return facilityList;
    }

    public String getFacilityNameById(int facilityId) {

        String facilityName = "";

        try {

            Connection conn = DBConnection.getConnection();

            String sql
                    = "SELECT FACILITY_NAME FROM FACILITIES WHERE FACILITY_ID=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, facilityId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                facilityName = rs.getString("FACILITY_NAME");
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return facilityName;
    }
}
