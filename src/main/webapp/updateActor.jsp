<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Actor</title>
</head>
<body>
    <h1>Update Actor</h1>
    <form action="update-actor" method="post">
        <label for="actorId">Actor ID:</label>
        <input type="number" name="actor.actorId" id="actorId" required /><br>
        <label for="firstName">First Name:</label>
        <input type="text" name="actor.firstName" id="firstName" required /><br>
        <label for="lastName">Last Name:</label>
        <input type="text" name="actor.lastName" id="lastName" required /><br>
        <input type="submit" value="Update Actor" />
    </form>
    <div id="response"></div>
</body>
</html>