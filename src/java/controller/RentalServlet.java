package controller;

import dao.RentalDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Rental;

public class RentalServlet extends HttpServlet {

    private RentalDAO rentalDAO;

    @Override
    public void init() {
        rentalDAO = new RentalDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("delete".equals(action)) {

            int rentalId =
                    Integer.parseInt(
                            request.getParameter("id"));

            rentalDAO.deleteRental(rentalId);

            response.sendRedirect(
                    "manager/manageRental.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int userId =
                Integer.parseInt(
                        request.getParameter("userId"));

        int equipmentId =
                Integer.parseInt(
                        request.getParameter("equipmentId"));

        int quantity =
                Integer.parseInt(
                        request.getParameter("quantity"));

        String rentalDate =
                request.getParameter("rentalDate");

        Rental rental = new Rental();

        rental.setUserId(userId);
        rental.setEquipmentId(equipmentId);
        rental.setQuantity(quantity);
        rental.setRentalDate(rentalDate);

        boolean result =
                rentalDAO.addRental(rental);

        if (result) {

            response.sendRedirect(
                    "student/myRental.jsp");

        } else {

            request.setAttribute(
                    "errMessage",
                    "Rental failed.");

            request.getRequestDispatcher(
                    "student/bookEquipment.jsp")
                    .forward(request, response);
        }
    }
}