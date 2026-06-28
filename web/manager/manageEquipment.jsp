<%-- 
    Document   : manageEquipment
    Created on : Jun 26, 2026, 12:47:01 AM
    Author     : 20248
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.EquipmentDAO"%>
<%@page import="model.Equipment"%>
<%@page import="java.util.List"%>

<%
    EquipmentDAO equipmentDAO = new EquipmentDAO();

    List<Equipment> equipmentList =
            equipmentDAO.getAllEquipment();
%>

<!DOCTYPE html>
<html>
    <head>
        <title>Equipment Management</title>
        <link rel="stylesheet"
              href="../css/style.css">
    </head>

    <body>

        <jsp:include page="../includes/header.jsp"/>

        <h1>Equipment Management</h1>

        <form action="../EquipmentServlet"
              method="post">

            <table>

                <tr>
                    <td>Equipment Name</td>
                    <td>
                        <input type="text"
                               name="equipmentName"
                               required>
                    </td>
                </tr>

                <tr>
                    <td>Quantity</td>
                    <td>
                        <input type="number"
                               name="quantity"
                               required>
                    </td>
                </tr>

                <tr>
                    <td>Status</td>
                    <td>
                        <select name="status">

                            <option value="Available">
                                Available
                            </option>

                            <option value="Damaged">
                                Damaged
                            </option>

                            <option value="In-Maintenance">
                                In-Maintenance
                            </option>

                        </select>
                    </td>
                </tr>

                <tr>
                    <td colspan="2">
                        <input type="submit"
                               value="Add Equipment">
                    </td>
                </tr>

            </table>

        </form>

        <hr>

        <h2>Equipment List</h2>

        <table border="1" cellpadding="10">

            <tr>
                <th>ID</th>
                <th>Equipment Name</th>
                <th>Quantity</th>
                <th>Status</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>

            <%
                for (Equipment equipment : equipmentList) {
            %>

            <tr>

                <td>
                    <%= equipment.getEquipmentId()%>
                </td>

                <td>
                    <%= equipment.getEquipmentName()%>
                </td>

                <td>
                    <%= equipment.getQuantity()%>
                </td>

                <td>
                    <%= equipment.getStatus()%>
                </td>

                <td>
                    <a href="editEquipment.jsp?id=<%= equipment.getEquipmentId()%>">
                        Edit
                    </a>
                </td>

                <td>
                    <a href="../EquipmentServlet?action=delete&id=<%= equipment.getEquipmentId()%>">
                        Delete
                    </a>
                </td>

            </tr>

            <%
                }
            %>

        </table>

        <br>

        <a href="managerDashboard.jsp">
            Back to Dashboard
        </a>

        <jsp:include page="../includes/footer.jsp"/>

    </body>
</html>
