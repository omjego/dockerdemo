FROM openjdk:8-jre-alpine
WORKDIR /usr/myapp
COPY ./target/docker-demo-0.0.1-SNAPSHOT.jar /usr/myapp/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/myapp/app.jar"]]