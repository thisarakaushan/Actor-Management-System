# **Actor Management System**

This is a simple web application that allows users to perform CRUD (Create, Read, Update, Delete) operations on a list of actors. The application is built using the Java Spring framework and Struts 2 for the backend, and HTML, JavaScript, and jQuery for the frontend.

##  Requirements

- DataBase connecting [JAR file](http://www.java2s.com/Code/Jar/m/Downloadmysqlconnectorjar.htm)
- Spring Boot [JAR files]([https://jar-download.com/download-handling.php](http://www.java2s.com/example/jar/s/download-springboot153releasejar-file.html))
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

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, feel free to open an issue or create a pull request.
