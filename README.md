# **Actor Management System**

This is a simple web application that allows users to perform CRUD (Create, Read, Update, Delete) operations on a list of actors. The application is built using the Java Spring framework and Struts 2 for the backend, and HTML, JavaScript, and jQuery for the frontend.

##  Requirements

- DataBase connecting [JAR file](http://www.java2s.com/Code/Jar/m/Downloadmysqlconnectorjar.htm)
- Spring Boot [JAR files](http://www.java2s.com/example/jar/s/download-springboot153releasejar-file.html)
- Struts [JAR file](http://www.java2s.com/Code/Jar/s/Downloadstrutscore1310jar.htm#google_vignette)

## Features

- View the list of all actors.
- Add a new actor to the list.
- Update the details of an existing actor.
- Delete an actor from the list.

## Prerequisites

- Java JDK 8 or higher
- Dynamic Web Project
- MySQL database
- Tomcat or similar web server

## Setup

1. Clone the repository:

```
   git clone https://github.com/thisarakaushan/Actor-Management-System.git
```
1. Created a MySQL database named sakila or update the database configuration in src/main/resources/applicationContext.xml and src/main/resources/struts.xml.

2. Build the project using Java and Dyanamic Web Poject:

```
cd actor-management-system
```

3. Deploy the generated **JAR file** to your _**Tomcat web server**_.

4. Access the application in your browser:
```
http://localhost:8080/Actor-Management-System/
```

## Implementation

The workflow step by step:

**User Interaction:**

The user opens the web application by accessing the main URL : ```http://localhost:8080/Actor_Management_System```.
The main ```index.jsp``` page is displayed, providing links to various operations (Get All Actors, Add Actor, Update Actor, Delete Actor).
If there is any exception/ unexpected error, the error message will be displayed to the user.

**Get All Actors:**

- When the user clicks on the "get All Actors" link in the ```index.jsp```, the browser sends an HTTP GET request to the getAllActors action in the ```struts.xml``` configuration.
- The **ActorAction** class handles the request and invokes the _**getAllActors**_ method.
- The _**getAllActors**_ method in **ActorAction** communicates with the **ActorManager** and **ActorDao** to fetch the list of actors from the database.
- The list of actors is converted to ```JSON format``` and sent as an HTTP response back to the browser.

**Add Actor:**

When the user clicks on the "Add Actor" link in the ```index.jsp```, they are taken to the ```addActor.jsp``` page.
The user fills in the first name and last name fields.
The browser sends an HTTP POST request to the _add-actor_ action in the ```struts.xml``` configuration.
The **ActorAction** class handles the request and invokes the _**addActor**_ method.
The _**addActor**_ method in **ActorAction** communicates with the **ActorManager** and **ActorDao** to add the new actor to the database.
If the actor is successfully added, an appropriate response message is sent back to the browser.

**Update Actor:**

Similar to the "Add Actor" process, the user clicks on the "Update Actor" link in the ```index.jsp``` and is taken to the ```updateActor.jsp``` page.
The user enters the actor ID, new first name, and new last name.
The browser sends an HTTP POST request to the _update-actor_ action in the ```struts.xml``` configuration.
The **ActorAction** class handles the request and invokes the _**updateActor**_ method.
The _**updateActor**_  method in **ActorAction** communicates with the **ActorManager** and **ActorDao** to update the actor's information in the database.
Depending on the success or failure of the update, an appropriate response message is sent back to the browser.

**Delete Actor:**

Similar to the "Update Actor" process, the user clicks on the "Delete Actor" link in the ```index.jsp```and is taken to the ```deleteActor.jsp``` page.
The user enters the actor ID.
The browser sends an HTTP POST request to the delete-actor action in the ```struts.xml``` configuration.
The **ActorAction** class handles the request and invokes the _**deleteActor**_ method.
The _**deleteActor**_  method in **ActorAction** communicates with the **ActorManager** and **ActorDao** to delete the actor from the database.
Depending on the success or failure of the deletion, an appropriate response message is sent back to the browser.

These actions  request the appropriate actions defined in the ```struts.xml``` configuration. The Java code in the action classes (e.g., ActorAction, ActorManagerImpl) communicates with the _data access layer_ (**ActorDaoImpl**) and the database. JSON responses are used to communicate data and status between the server and the browser.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, feel free to open an issue or create a pull request.
