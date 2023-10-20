## Web automation final project
This is Java based project example for automating tests with Selenium WebDriver, Maven, and TestNG using the web application [My Awesome App](http://https://vue-demo.daniel-avellaneda.com/ "My Awesome App")

Project is organized using the Page Object Model design pattern which provides better maintainability 
and structure for automating UI tests. Page classes are organized into Landing, Login, Signup, Navigation, 
Message pop up and Cities page. They are located in *src/main/java/pages directory*.
You can extend or modify them to accommodate changes in the application.
Test scripts can be found in *src/test/java/tests directory*.

#### All tests are organized into five categories:
* Login Tests: login page functionality, successful login, error messages, input fields and button
* Signup Tests: signup functionality, error messages, successful sign up, input fields and button
* Admin Cities Tests: add, edit and delete functionality for cities page
* Auth Routes Tests: route protection in case user is not authenticated
* Locale Tests: language buttons functionality, page content in different languages

Requirements

Before running the tests, ensure you have the following dependencies installed:

* Java Development Kit (JDK)
* Maven
* TestNG
* Chrome WebDriver

For running testng file from command line use command: mvn clean test -Dsurefire.suiteXmlFiles=testng.xml