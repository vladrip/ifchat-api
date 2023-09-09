# ifchat-api
Spring REST API for "IFChat" chat application.<br>

### Demo-video: https://youtu.be/CxigXRoug1g

### Client, Android application: https://github.com/vladrip/ifchat-android

### Running api:<br>
Create database which can be accessed with this url (or change application.properties, 
as of 17.04.2023 api does not have native queires and should work with any RDBMS):<br>
<code>url=jdbc:postgresql://localhost:5432/ifchat   username=postgres   password=1212</code><br><br>
Download project and in root directory (where pom.xml is located) execute this command (you should have maven installed and have it in PATH):<br>
<code>mvn spring-boot:run</code>
