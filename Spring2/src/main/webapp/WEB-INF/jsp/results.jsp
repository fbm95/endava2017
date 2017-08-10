<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>

<body>
<h2>Submitted Student Information</h2>
<table>
    <tr>
        <td>Name</td>
        <td>${name}</td>
        <td><c:if test="${fields.hasErrors('name')}">*{name}</c:if></td>
        <td th:if="${fields.hasErrors('name')}" th:errors="*{name}">Name Error</td>
    </tr>
    <tr>
        <td>Age</td>
        <td>${age}</td>
        <td th:if="${fields.hasErrors('age')}" th:errors="*{age}">Age Error</td>
    </tr>
</table>
</body>
