FROM tomcat:9
MAINTAINER adithya.j@admatic.in

ADD . /jenkins-tomcat-demo
WORKDIR /jenkins-tomcat-demo

RUN ./mvnw package
RUN cp target/tomcat-demo-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/

CMD ["catalina.sh", "run"]
