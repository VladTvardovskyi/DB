FROM maven:3-jdk-11-openj9 as maven
WORKDIR /
ADD . .
RUN mvn clean package

FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY --from=maven ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
