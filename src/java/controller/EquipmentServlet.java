package controller;

import dao.EquipmentDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Equipment;

public class EquipmentServlet extends HttpServlet {

    private EquipmentDAO equipmentDAO;

    @Override
    public void init() {
        equipmentDAO = new EquipmentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("delete".equals(action)) {

            int equipmentId =
                    Integer.parseInt(request.getParameter("id"));

            equipmentDAO.deleteEquipment(equipmentId);

            response.sendRedirect(
                    "manager/manageEquipment.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        // UPDATE
        if ("update".equals(action)) {

            int equipmentId =
                    Integer.parseInt(
                            request.getParameter("equipmentId"));

            String equipmentName =
                    request.getParameter("equipmentName");

            int quantity =
                    Integer.parseInt(
                            request.getParameter("quantity"));

            String status =
                    request.getParameter("status");

            Equipment equipment = new Equipment();

            equipment.setEquipmentId(equipmentId);
            equipment.setEquipmentName(equipmentName);
            equipment.setQuantity(quantity);
            equipment.setStatus(status);

            equipmentDAO.updateEquipment(equipment);

            response.sendRedirect(
                    "manager/manageEquipment.jsp");

            return;
        }

        // ADD
        String equipmentName =
                request.getParameter("equipmentName");

        int quantity =
                Integer.parseInt(
                        request.getParameter("quantity"));

        String status =
                request.getParameter("status");

        Equipment equipment = new Equipment();

        equipment.setEquipmentName(equipmentName);
        equipment.setQuantity(quantity);
        equipment.setStatus(status);

        boolean result =
                equipmentDAO.addEquipment(equipment);

        if (result) {

            response.sendRedirect(
                    "manager/manageEquipment.jsp");

        } else {

            request.setAttribute(
                    "errMessage",
                    "Failed to add equipment.");

            request.getRequestDispatcher(
                    "manager/manageEquipment.jsp")
                    .forward(request, response);
        }
    }
}
