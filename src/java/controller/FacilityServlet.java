package controller;

import dao.FacilityDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Facility;

public class FacilityServlet extends HttpServlet {

    private FacilityDAO facilityDAO;

    @Override
    public void init() {
        facilityDAO = new FacilityDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("delete".equals(action)) {

            int facilityId =
                    Integer.parseInt(request.getParameter("id"));

            facilityDAO.deleteFacility(facilityId);

            response.sendRedirect("manager/manageFacility.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        // UPDATE
        if ("update".equals(action)) {

            int facilityId =
                    Integer.parseInt(request.getParameter("facilityId"));

            String facilityName =
                    request.getParameter("facilityName");

            String location =
                    request.getParameter("location");

            Facility facility = new Facility();

            facility.setFacilityId(facilityId);
            facility.setFacilityName(facilityName);
            facility.setLocation(location);

            facilityDAO.updateFacility(facility);

            response.sendRedirect("manager/manageFacility.jsp");

            return;
        }

        // ADD
        String facilityName =
                request.getParameter("facilityName");

        String location =
                request.getParameter("location");

        Facility facility = new Facility();

        facility.setFacilityName(facilityName);
        facility.setLocation(location);

        boolean status =
                facilityDAO.addFacility(facility);

        if (status) {

            response.sendRedirect("manager/manageFacility.jsp");

        } else {

            request.setAttribute(
                    "errMessage",
                    "Failed to add facility.");

            request.getRequestDispatcher(
                    "manager/manageFacility.jsp")
                    .forward(request, response);
        }
    }
}