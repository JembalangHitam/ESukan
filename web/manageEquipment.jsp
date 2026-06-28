<%-- 
    Document   : manageEquipment
    Created on : Jun 24, 2026, 12:14:35 AM
    Author     : 20248
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.esukan.dao.EquipmentDAO"%>
<%@page import="com.esukan.model.Equipment"%>

<%
    EquipmentDAO equipmentDAO = new EquipmentDAO();
    List<Equipment> equipmentList = equipmentDAO.getAllEquipments();
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Manage Equipment</title>
    </head>
    <body>

        <h1>Manage Equipment</h1>

        <form action="EquipmentServlet" method="post">

            Equipment Name:
            <br>
            <input type="text" name="equipmentName" required>
            <br><br>

            Quantity:
            <br>
            <input type="number" name="quantity" required>
            <br><br>

            Status:
            <br>

            <select name="status">

                <option>Available</option>
                <option>Damaged</option>
                <option>In-Maintenance</option>

            </select>

            <br><br>

            <input type="submit" value="Add Equipment">

        </form>
        <a href="adminDashboard.jsp">Back to Dashboard</a>

        <hr>

        <h2>Equipment List</h2>

        <table border="1">

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

                <td><%=equipment.getEquipmentId()%></td>
                <td><%=equipment.getEquipmentName()%></td>
                <td><%=equipment.getQuantity()%></td>
                <td><%=equipment.getStatus()%></td>
                <td>
                    <a href="editEquipment.jsp?id=<%=equipment.getEquipmentId()%>">
                        Edit
                    </a>
                </td>
                <td>
                    <a href="EquipmentServlet?deleteId=<%=equipment.getEquipmentId()%>">
                        Delete
                    </a>
                </td>
            </tr>
            <%
                }
            %>

        </table>

    </body>
</html>
