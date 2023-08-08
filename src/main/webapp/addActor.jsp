<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Actor</title>
</head>
<body>
    <h1>Add Actor</h1>
    <form action="add-actor" method="post">
        <label for="firstName">First Name:</label>
        <input type="text" name="actor.firstName" id="firstName" required /><br>
        <label for="lastName">Last Name:</label>
        <input type="text" name="actor.lastName" id="lastName" required /><br>
        <input type="submit" value="Add Actor" />
    </form>
    <div id="response"></div>
</body>
</html>