/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esukan.controller;

import com.esukan.dao.FacilityDAO;
import com.esukan.model.Facility;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 20248
 */
public class FacilityServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String facilityName = request.getParameter("facilityName");
        String location = request.getParameter("location");
        String status = request.getParameter("status");
        Facility facility = new Facility();
        facility.setFacilityName(facilityName);
        facility.setLocation(location);
        facility.setStatus(status);
        FacilityDAO facilityDAO = new FacilityDAO();
        boolean result = facilityDAO.addFacility(facility);
        if (result) {
            response.sendRedirect("manageFacility.jsp");
        } else {
            response.getWriter().println("Failed to add facility!");
        }
    }
}
