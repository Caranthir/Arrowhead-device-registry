# Device Registry

This project contains three different applications.

1) Device Registry Server Backend
2) Device Registry Server UI
3) Device Registry Client 

The goal of this project is to have a Device Registry component, to have a list of all the different components in our cloud and see if they are still up and running. When a client is started, it registers itself on the server. Also the server may contact the client to check if the client is still up and running. The application is independent of the Arrowhead Framework. So it can only show if the device is up and running but not the framework. 

Device Registry Server Backend is developed using:

* OpenJDK 11
* Spring Boot 
* MariaDB 10.5

Device Registry Server UI is developed with 
* Angular 10

Device Registry Client is developed using:
* OpenJDK 11
* Spring Boot 

It doesn't require a database. 


## How to deploy the device registry:
### 1) Server Side
First, install OpenJDK 11, MariaDB 10.5 on the server. The Spring Boot application needs the authentication information of the database.
To enter the authentication information of the database, edit the following properties in the application.properties file:
```
spring.datasource.username=<USERNAME>
spring.datasource.password=<PASSWORD>
```
The user needs the rights to create databases and tables in the database. The default username is root and the default password is admin in the properties file. If you use the prebuilt jar file to run the server application, you can find the application.properties file in /BOOT-INF/classes/ directory in the jar file. 

In the prebuilt jar file, the UI is already integrated. When starting the server application, the UI should also start automatically. If you edit the UI and want to integrate the UI in the Spring Boot application, execute the following command in the folder of the UI code:
```
ng build --prod
```
Copy the content of the dist/ArrowheadUI from the UI application into the target/classes/static folder of the Spring Boot application and create the JAR file with maven. 

The jar file is called DeviceRegistryServer-0.0.1-SNAPSHOT.jar by default. You can start the application by running the following command 

```
java -jar DeviceRegistryServer-0.0.1-SNAPSHOT.jar
```

### 2) Client Side 
First, install OpenJDK 11 on the client machine. You need to enter the address and the port of the server so that the client can register itself on the server.
For entering the connection information, you need to edit the following properties in the application.properties file:
```
Arrowheadserver.address = localhost
Arrowheadserver.port = 8080
```

Other properties needed on the client side are: 
```
client.name= <Name of the client. IT SHOULD BE UNIQUE FOR EVERY CLIENT>
client.address = <Address of the client. This address is used by the server to connect to client>
client.port = <Port of the client. This is sent to the server.>
server.port= <Port of the client. Should be the same one with client.port>
```

The jar file is called DeviceRegistryClient-0.0.1-SNAPSHOT.jar by default. You can start the application by running the following command 

```
java -jar DeviceRegistryClient-0.0.1-SNAPSHOT.jar
```

## How to use

The server needs to be started before the client. When the server starts, it starts to wait for other devices to register themselves. To refresh the status of the devices, click the "Refresh" button on the UI. The server will then try to connect to each device to get their status. Devices, that are offline will disappear from the list. 

The UI can be accessed from <hostname>:8080



# Using Arrowhead Framework
The Arrowhead Framework components may be installed with debian installation files. Please see the official documentation for installing Arrowhead Framework:

https://github.com/eclipse-arrowhead/core-java-spring/blob/master/documentation/deb-installer/DEBIAN-INSTALL.md

Since in the latest version 4.2.0, the github doesn't include .deb files, I have generated them and uploaded in this repository. Please find them under debs/

The official documentation for the Arrowhead Framework can be found under this link:
https://github.com/eclipse-arrowhead/core-java-spring

The core components of the Arrowhead Framework are:
* Service Registry
* Authorization
* Orchestrator

