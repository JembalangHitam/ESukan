/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esukan.controller;

import com.esukan.dao.EquipmentDAO;
import com.esukan.model.Equipment;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 20248
 */
public class EquipmentServlet extends HttpServlet {

    @Override

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String idStr = request.getParameter("equipmentId");

        String equipmentName = request.getParameter("equipmentName");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String status = request.getParameter("status");

        Equipment equipment = new Equipment();

        equipment.setEquipmentName(equipmentName);
        equipment.setQuantity(quantity);
        equipment.setStatus(status);

        EquipmentDAO equipmentDAO = new EquipmentDAO();

        boolean result;

        if (idStr == null || idStr.isEmpty()) {
            result = equipmentDAO.addEquipment(equipment);
        } else {
            int equipmentId = Integer.parseInt(idStr);
            equipment.setEquipmentId(equipmentId);
            result = equipmentDAO.updateEquipment(equipment);
        }
        if (result) {
            response.sendRedirect("manageEquipment.jsp");
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

            int equipmentId = Integer.parseInt(deleteId);

            EquipmentDAO equipmentDAO = new EquipmentDAO();

            equipmentDAO.deleteEquipment(equipmentId);
        }

        response.sendRedirect("manageEquipment.jsp");
    }
}
