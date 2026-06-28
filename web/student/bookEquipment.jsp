
<%-- 
    Document   : bookEquipment
    Created on : Jun 27, 2026, 1:24:31 AM
    Author     : 20248
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.EquipmentDAO"%>
<%@page import="model.Equipment"%>
<%@page import="model.User"%>
<%@page import="java.util.List"%>

<%
    User currentUser =
            (User) session.getAttribute("user");

    if(currentUser == null){
        response.sendRedirect("../login.jsp");
        return;
    }

    EquipmentDAO equipmentDAO =
            new EquipmentDAO();

    List<Equipment> equipmentList =
            equipmentDAO.getAllEquipment();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Equipment Rental</title>
</head>

<body>

<jsp:include page="../includes/header.jsp"/>

<h1>Equipment Rental</h1>

<form action="../RentalServlet" method="post">

    <input type="hidden"
           name="userId"
           value="<%= currentUser.getUserId()%>">

    <table>
        <tr>
            <td>Equipment</td>
            <td>
                <select name="equipmentId" required>
                    <option value="">Select Equipment</option>
                    <%
                        for(Equipment equipment : equipmentList){
                        if("Available".equalsIgnoreCase(
                                equipment.getStatus())){
                    %>
                    <option value="<%= equipment.getEquipmentId()%>"><%= equipment.getEquipmentName()%></option>

                    <%}}%>
                </select>

            </td>
        </tr>
        <tr>
            <td>Quantity</td>
            <td><input type="number" name="quantity" min="1"required></td>
        </tr>
        <tr>
            <td>Rental Date</td>
            <td><input type="date" name="rentalDate"required></td>
        </tr>
        <tr><td colspan="2"><input type="submit" value="Rent Equipment"></td>
        </tr>
    </table>
</form>
<br>
<a href="studentDashboard.jsp">
    Back to Dashboard
</a>

<jsp:include page="../includes/footer.jsp"/>

</body>
</html>