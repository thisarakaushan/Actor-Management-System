<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Actor</title>
</head>
<body>
    <h1>Delete Actor</h1>
    <form action="delete-actor" method="post">
        <label for="actorId">Actor ID:</label>
        <input type="number" name="actor.actorId" id="actorId" required /><br>
        <input type="submit" value="Delete Actor" />
    </form>
    <div id="response"></div>
</body>
</html>