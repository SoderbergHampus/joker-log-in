FROM maven:3.6.0-jdk-11
COPY pom.xml /tmp/pom.xml
RUN mvn -B -f /tmp/pom.xml -s /usr/share/maven/ref/settings-docker.xml dependency:resolve
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]