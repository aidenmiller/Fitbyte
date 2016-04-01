# `FitByte` - CS2212 Team07 Winter 2016
##### Optimized for Mac OS X
* **Author**: team07
* **Contributors**: John Abed, Bowen Jiang, Jue OuYang, Kevin Hong, Aiden Miller, Leonard Beth

## Synopsis
FitByte is a Desktop application that allows a user to track their fitness. The user's activity is recorded by their personal Fitbit device and displayed on the FitByte application.

The application connects to [Fitbit's API](https://dev.fitbit.com/) and uses the [ScribeJava](https://github.com/scribejava/scribejava) library for OAuth2 authentication and API response handling. The [JFreeChart](http://www.jfree.org/jfreechart/) library is also used to show Time Series Data for various user activity.

## Build
This project uses git and Bitbucket for version control and repository storage respectively. It is compiled and packaged into an executable JAR file using the Maven command `mvn package`. 
##### Clone team07 Repository
Using git, enter the following command to clone the repository to your local machine:
```
git clone ssh://git@repo.gaul.csd.uwo.ca:7999/cs2212_w2016/team07.git
```
##### Compiling using Maven
From the team07 working directory, enter the following command to package the program:
```
mvn package
```
##### Running the program
From the team07 working directory, run the program in one of two ways:

#normally:
```
java -jar target/team07_fitbitViewer-1.0-SNAPSHOT-jar-with-dependencies.jar
```
#test mode example:
```
java -jar target/team07_fitbitViewer-1.0-SNAPSHOT-jar-with-dependencies.jar test
```

## Usage
Please watch this [live demonstration](http://www.youtube.com) on usage of the FitByte desktop application.

## Documentation
JavaDoc documentation for the application can be viewed [here](doc/index.html).