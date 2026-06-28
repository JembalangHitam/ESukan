<%-- 
    Document   : header
    Created on : Jun 27, 2026
    Author     : 20248
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.User"%>

<%
    User user = (User) session.getAttribute("user");
%>

<header>

    <h2>E-Sukan</h2>

    <hr>

    <a href="<%=request.getContextPath()%>/index.jsp">Home</a>

    |

    <a href="<%=request.getContextPath()%>/student/bookFacility.jsp">
        Sport Court
    </a>

    |

    <a href="<%=request.getContextPath()%>/student/bookEquipment.jsp">
        Equipment
    </a>

    |

    <% if (user != null) { %>

        Welcome,
        <%=user.getFirstName()%>

        |

        <a href="<%=request.getContextPath()%>/LogoutServlet">
            Logout
        </a>

    <% } else { %>

        <a href="<%=request.getContextPath()%>/login.jsp">
            Login
        </a>

        |

        <a href="<%=request.getContextPath()%>/register.jsp">
            Register
        </a>

    <% } %>

    <hr>

</header>