<%--
  Created by IntelliJ IDEA.
  User: JS
  Date: 31.08.2018
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Client</title>
</head>
<body>
    <form action="${pageContext.servletContext.contextPath}/user/create" method="post">
        <table>
            <tr>
                <td align="right" > Client name: </td>
                <td>
                    <input type="text" name="login">
                </td>
            </tr>
            <tr>
                <td align="right" > Email: </td>
                <td>
                    <input type="text" name="email">
                </td>
            </tr>

            <tr>
                <td align="right" > Phone: </td>
                <td>
                    <input type="text" name="phone">
                </td>
            </tr>

            <tr>
                <td align="right" > Pet name: </td>
                <td>
                    <input type="text" name="pet_name">
                </td>
            </tr>

            <tr>
                <td align="right" > Pet type: </td>
                <td>
                    <input type="text" name="pet_type">
                </td>
            </tr>

            <tr>
                <td><input type="submit" align="center" value="Add"></td>
            </tr>
        </table>
    </form>
</body>
</html>
