# OnlineEventPlanner

Welcome to the OnlineEventPlanner project! This application helps users and vendors manage their event planning requirements. Please go through the presentation in the repository in order to get a more in-depth understanding of the features and funcationality of the app. It is built using the following technologies:

- **Java 11**: The backend of the application is powered by Java 11.
- **HTML5**: We use HTML5 for structuring the content of our web pages.
- **CSS3**: CSS3 is used for styling and layout design.
- **Bootstrap 5**: Bootstrap 5 is employed to enhance the user interface and provide responsive design.
- **MySQL**: MySQL is used as the database management system to store and manage application data. We have used the MySQL Connector as a dependency for connecting the Java application with the MySQL database.

## Project Structure

The project is organized into several directories:

1. **/application**: This directory contains all the source code for the OnlineEventPlanner application. It includes the HTML, CSS, JavaScript files for the frontend and Java files for the backend.

2. **/documents**: In this directory, you will find various documents related to the project, which can be useful for understanding and configuring the application. These documents include:

   - UML Diagrams: Unified Modeling Language diagrams that illustrate the system's architecture and relationships between components.
   - Entity-Relationship (ER) Diagram: A visual representation of the database schema, showing tables and their relationships.
   - Use Case Diagram: A diagram depicting the interactions between users (actors) and the system, outlining different use cases.
   - Test Case Document: Documentation outlining the test cases and scenarios for testing the application.
   - Dataflow Diagram: A diagram representing how data flows within the system.

## Configuration

### Installing Bootstrap 

Use the CDN from the [offical Bootstrap Website](https://getbootstrap.com/docs/5.0/getting-started/download/) 

Add these CDN Links in your html files<<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>>



### Setting Up the Database

1. **MySQL**: Make sure you have MySQL installed on your system. If not, you can download it from the [official MySQL website](https://dev.mysql.com/downloads/).

2. **Database Schema**: Inside the `/documents` directory, you will find the SQL schema file (`schema.sql`) that defines the database structure. To set up the database, you can use the following command:

   ```shell
   mysql -u <username> -p < schema.sql


Replace <username> with your MySQL username. You will be prompted to enter your MySQL password.

This will create the necessary tables and schema for the OnlineEventPlanner application.

## License

MIT LICENSE


# BUILT WITH ❤️ IN INDIA


