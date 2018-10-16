<%--
  Created by IntelliJ IDEA.
  User: JS
  Date: 31.08.2018
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Список клиентов</title>
</head>
<body>
<td> <a href="${pageContext.servletContext.contextPath}/views/user/CreateUser.jsp">Добавить пользователя</a> </td>
    <table border="1">

        <tr>
            <td> Client name </td>
            <td> Email </td>
            <td> Phone </td>
            <td> Pet name </td>
            <td> Pet type </td>
            <td> Действие </td>
        </tr>
        <c:forEach items="${users}" var="user" varStatus="status">
            <tr valign="top">
                <td> ${user.name} </td>
                <td> ${user.email} </td>
                <td> ${user.phone} </td>
                <td> ${user.pet.name} </td>
                <td> ${user.pet.type} </td>
                   <td> <a href="${pageContext.servletContext.contextPath}/user/edit?id=${user.id}">Редактировать</a> </td>
                  <td>  <a href="${pageContext.servletContext.contextPath}/user/delete?id=${user.id}">Удалить </a> </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
