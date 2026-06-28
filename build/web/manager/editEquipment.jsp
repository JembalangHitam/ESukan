<%-- 
    Document   : editEquipment
    Created on : Jun 26, 2026, 12:47:24 AM
    Author     : 20248
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.EquipmentDAO"%>
<%@page import="model.Equipment"%>

<%
    int equipmentId =
            Integer.parseInt(request.getParameter("id"));

    EquipmentDAO equipmentDAO =
            new EquipmentDAO();

    Equipment equipment =
            equipmentDAO.getEquipmentById(equipmentId);
%>

<!DOCTYPE html>
<html>
    <head>
        <title>Edit Equipment</title>
    </head>

    <body>

        <h1>Edit Equipment</h1>

        <hr>

        <form action="../EquipmentServlet"
              method="post">

            <input type="hidden"
                   name="action"
                   value="update">

            <input type="hidden"
                   name="equipmentId"
                   value="<%= equipment.getEquipmentId()%>">

            <table>

                <tr>
                    <td><b>Equipment ID</b></td>
                    <td>
                        <%= equipment.getEquipmentId()%>
                    </td>
                </tr>

                <tr>
                    <td><b>Equipment Name</b></td>
                    <td>
                        <input type="text"
                               name="equipmentName"
                               value="<%= equipment.getEquipmentName()%>"
                               required>
                    </td>
                </tr>

                <tr>
                    <td><b>Quantity</b></td>
                    <td>
                        <input type="number"
                               name="quantity"
                               value="<%= equipment.getQuantity()%>"
                               required>
                    </td>
                </tr>

                <tr>
                    <td><b>Status</b></td>
                    <td>

                        <select name="status">

                            <option value="Available"
                                <%= equipment.getStatus().equals("Available") ? "selected" : "" %>>
                                Available
                            </option>

                            <option value="Damaged"
                                <%= equipment.getStatus().equals("Damaged") ? "selected" : "" %>>
                                Damaged
                            </option>
                            
                            <option value="In-Maintenance"
                                <%= equipment.getStatus().equals("In-Maintenance") ? "selected" : "" %>>
                                In-Maintenance
                            </option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit"
                               value="Update Equipment">
                        <a href="manageEquipment.jsp">
                            Cancel
                        </a>
                    </td>
                </tr>
            </table>
        </form>
        <hr>
    </body>
</html>
