# Moved to monorepo: https://github.com/vladrip/ifchat
# ifchat-api
Spring REST API for "IFChat" chat application.<br>
### Demo-video: https://youtu.be/CxigXRoug1g
### Client, Android application: https://github.com/vladrip/ifchat-android<br>
### Running api:
Run docker compose file to setup database
```
docker-compose --project-name="ifchat" up --detach
```
Start api via your IDE, or in root directory (where pom.xml is located) execute this command (you should have maven installed and have it in PATH):<br>
<code>mvn spring-boot:run</code>
