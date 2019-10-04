# Jenkins Tomcat Demo

## Prerequisites

### Ubuntu 18.04

```bash
lsb_release -a
```

```output
No LSB modules are available.
Distributor ID: Ubuntu
Description:    Ubuntu 18.04.3 LTS
Release:        18.04
Codename:       bionic
```

### Java

```bash
{
  sudo apt update
  sudo apt install default-jdk -y
}
```

### Tomcat

```bash
sudo systemctl status tomcat
```

```output
● tomcat.service - Apache Tomcat Web Application Container
   Loaded: loaded (/etc/systemd/system/tomcat.service; enabled; vendor preset: enabled)
   Active: active (running) since Thu 2019-10-03 08:16:36 UTC; 20min ago
  Process: 10554 ExecStop=/opt/tomcat/bin/shutdown.sh (code=exited, status=0/SUCCESS)
  Process: 10589 ExecStart=/opt/tomcat/bin/startup.sh (code=exited, status=0/SUCCESS)
 Main PID: 10606 (java)
    Tasks: 44 (limit: 4703)
   CGroup: /system.slice/tomcat.service
           └─10606 /usr/lib/jvm/java-1.11.0-openjdk-amd64/bin/java -Djava.util.logging.config.file=/opt/tomcat/conf/logging.properties -Djava.util.logging.manager=org.apache.juli.ClassLoaderL

Oct 03 08:16:36 c2-r4-18-04-s32-1 systemd[1]: Starting Apache Tomcat Web Application Container...
Oct 03 08:16:36 c2-r4-18-04-s32-1 startup.sh[10589]: Tomcat started.
Oct 03 08:16:36 c2-r4-18-04-s32-1 systemd[1]: Started Apache Tomcat Web Application Container.
```

## Run the application

```bash
{
  cd tomcat-demo
  # ./mvnw spring-boot:run -Dserver.port=8090

  ./mvnw package
  sudo cp target/tomcat-demo-0.0.1-SNAPSHOT.war /opt/tomcat/webapps/
}
```

```bash
curl localhost:8080/tomcat-demo-0.0.1-SNAPSHOT/greeting?name=Admatic
```

```json
{ "id": 1, "content": "Hello, Admatic!" }
```

## Start Jenkins

```bash
{
  # Install docker
  curl -sSL http://get.docker.com/ | sh

  sudo apt update
  sudo apt install wget default-jdk -y

  cd ~
  wget https://www.dropbox.com/s/azyefpt6vqu3qij/jenkins.war
  sudo java -jar jenkins.war --httpPort=8081
}
```
