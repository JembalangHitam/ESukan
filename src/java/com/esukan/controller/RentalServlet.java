/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esukan.controller;

import com.esukan.dao.RentalDAO;
import com.esukan.model.Rental;
import com.esukan.model.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.esukan.dao.EquipmentDAO;

/**
 *
 * @author 20248
 */
public class RentalServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        if (user == null) {

            response.sendRedirect("login.jsp");

            return;
        }

        int equipmentId
                = Integer.parseInt(request.getParameter("equipmentId"));

        int quantity
                = Integer.parseInt(request.getParameter("quantity"));

        String rentalDate
                = request.getParameter("rentalDate");

        EquipmentDAO equipmentDAO = new EquipmentDAO();

        int availableQuantity
                = equipmentDAO.getEquipmentQuantity(equipmentId);

        if (quantity > availableQuantity) {

            response.getWriter().println(
                    "Not enough equipment available!");

            return;
        }
        Rental rental = new Rental();

        rental.setUserId(user.getUserId());
        rental.setEquipmentId(equipmentId);
        rental.setQuantity(quantity);
        rental.setRentalDate(rentalDate);

        RentalDAO rentalDAO = new RentalDAO();

        boolean result = rentalDAO.addRental(rental);

        if (result) {

            response.sendRedirect("myRental.jsp");

        } else {

            response.getWriter().println("Rental Failed!");

        }
    }
}
