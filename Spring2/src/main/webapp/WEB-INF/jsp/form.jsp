<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<form:form method = "POST" modelAttribute="personForm" action = "/">
    <table>
        <tr>
            <td><form:label path = "name">Name</form:label></td>
            <td><form:input path = "name" /></td>
            <form:errors path="name" />
        </tr>
        <tr>
            <td><form:label path = "age">Age</form:label></td>
            <td><form:input path = "age" /></td>
            <form:errors path="age" />
        </tr>
        <tr>
            <td colspan = "2">
                <input type = "submit" value = "Submit"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>