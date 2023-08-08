<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
    <h1>An error occurred: <%= request.getAttribute("javax.servlet.error.message") %></h1>
</body>
</html>