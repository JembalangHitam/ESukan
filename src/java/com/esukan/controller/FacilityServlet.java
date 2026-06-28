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
import javax.servlet.ServletException;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author 20248
 */
public class FacilityServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String idStr = request.getParameter("facilityId");

        String facilityName = request.getParameter("facilityName");
        String location = request.getParameter("location");
        String status = request.getParameter("status");

        Facility facility = new Facility();

        facility.setFacilityName(facilityName);
        facility.setLocation(location);
        facility.setStatus(status);

        FacilityDAO facilityDAO = new FacilityDAO();

        boolean result;

        if (idStr == null || idStr.isEmpty()) {

            result = facilityDAO.addFacility(facility);

        } else {

            int facilityId = Integer.parseInt(idStr);

            facility.setFacilityId(facilityId);

            result = facilityDAO.updateFacility(facility);
        }

        if (result) {

            response.sendRedirect("manageFacility.jsp");

        } else {

            response.getWriter().println("Operation Failed!");

        }
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String deleteId = request.getParameter("deleteId");

        if (deleteId != null) {

            int facilityId = Integer.parseInt(deleteId);

            FacilityDAO facilityDAO = new FacilityDAO();

            facilityDAO.deleteFacility(facilityId);
        }

        response.sendRedirect("manageFacility.jsp");
    }
}
