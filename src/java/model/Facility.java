/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 20248
 */
public class Facility {

    private int facilityId;
    private String facilityName;
    private String location;

    public Facility() {
    }

    public Facility(int facilityId, String facilityName, String location) {
        this.facilityId = facilityId;
        this.facilityName = facilityName;
        this.location = location;
    }

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
