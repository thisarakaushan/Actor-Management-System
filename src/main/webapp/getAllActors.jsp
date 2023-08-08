
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Actors</title>
</head>
<body>
    <h1>All Actors</h1>
    <%-- <s:div id="actorsData" theme="ajax"> --%>
    <!-- <button onclick="loadActors()">Load Actors</button> -->
        <s:url var="url" action="get-actors" />
        <s:submit value="Load Actors" onclick="loadActors()" />
    <%-- </s:div> --%>
    <script>
        function loadActors() {
            $.ajax({
                url: "<s:property value='#url' />",
                dataType: 'json',
                success: function (data) {
                    var actors = data.actors;
                    var actorsData = "<table><tr><th>Actor ID</th><th>First Name</th><th>Last Name</th></tr>";
                    for (var i = 0; i < actors.length; i++) {
                        actorsData += "<tr><td>" + actors[i].actorId + "</td><td>" + actors[i].firstName + "</td><td>" + actors[i].lastName + "</td></tr>";
                    }
                    actorsData += "</table>";
                    document.getElementById("actorsData").innerHTML = actorsData;
                },
                error: function (xhr, ajaxOptions, thrownError) {
                    alert("Error occurred while fetching actors: " + xhr.responseText);
                }
            });
        }
    </script>
</body>