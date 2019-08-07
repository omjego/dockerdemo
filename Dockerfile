
#Stage 1, Build artifact
FROM maven:3.6.1-jdk-8  as build
WORKDIR /usr/myapp

COPY pom.xml /usr/myapp
COPY settings.xml /usr/myapp
RUN mvn -s settings.xml dependency:go-offline -B

COPY src /usr/myapp/src
RUN mvn -s settings.xml package


#Stage 2, copy artifact
FROM openjdk:8-jre-alpine
COPY --from=build /usr/myapp/target/docker-demo-0.0.1-SNAPSHOT.jar /usr/myapp/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/myapp/app.jar"]