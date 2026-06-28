/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author 20248
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Facility;
import util.DBConnection;

public class FacilityDAO {

    Connection con;

    public FacilityDAO() {
        con = DBConnection.createConnection();
    }

    // ADD FACILITY
    public boolean addFacility(Facility facility) {

        boolean status = false;

        try {

            String sql = "INSERT INTO FACILITIES (FACILITY_NAME, LOCATION) VALUES (?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, facility.getFacilityName());
            ps.setString(2, facility.getLocation());

            status = ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // VIEW ALL FACILITIES
    public List<Facility> getAllFacilities() {

        List<Facility> facilityList = new ArrayList<>();

        try {

            String sql = "SELECT * FROM FACILITIES";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Facility facility = new Facility();

                facility.setFacilityId(rs.getInt("FACILITY_ID"));
                facility.setFacilityName(rs.getString("FACILITY_NAME"));
                facility.setLocation(rs.getString("LOCATION"));

                facilityList.add(facility);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return facilityList;
    }

    // GET FACILITY BY ID
    public Facility getFacilityById(int facilityId) {

        Facility facility = null;

        try {

            String sql = "SELECT * FROM FACILITIES WHERE FACILITY_ID=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, facilityId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                facility = new Facility();

                facility.setFacilityId(rs.getInt("FACILITY_ID"));
                facility.setFacilityName(rs.getString("FACILITY_NAME"));
                facility.setLocation(rs.getString("LOCATION"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return facility;
    }

    // UPDATE FACILITY
    public boolean updateFacility(Facility facility) {

        boolean status = false;

        try {

            String sql = "UPDATE FACILITIES SET FACILITY_NAME=?, LOCATION=? WHERE FACILITY_ID=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, facility.getFacilityName());
            ps.setString(2, facility.getLocation());
            ps.setInt(3, facility.getFacilityId());

            status = ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // DELETE FACILITY
    public boolean deleteFacility(int facilityId) {

        boolean status = false;

        try {

            String sql = "DELETE FROM FACILITIES WHERE FACILITY_ID=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, facilityId);

            status = ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}
