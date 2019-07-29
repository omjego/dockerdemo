#Multi stage docker build.
#Stage 1: First run maven build and create package
#Stage 2: Copy only target folder in to new image

#FROM maven as build
#WORKDIR /usr/src/app

#ADD pom.xml /usr/src/app
#RUN mvn verify --fail-never
#ADD . /usr/src/app
#RUN mvn clean package -DskipTests

#
#FROM openjdk:8-jre-alpine
#MAINTAINER omkar.j@media.net
#RUN echo 'Building project'
#
# CMD ["java", "-jar", "/usr/app.jar"]


FROM alpine
RUN apk add --update redis
CMD ["redis-server"]