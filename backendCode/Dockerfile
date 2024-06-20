# Build we are running our app (This is our image)
FROM maven:3.9.6-eclipse-temurin-22 AS build
# Copy everything within our file
COPY . .
# create our jar
RUN mvn clean package -DskipTests

FROM openjdk:22-jdk

# copy our file from movies snapshot into demo.jar
COPY --from=build /target/movies-0.0.1-SNAPSHOT.jar demo.jar
# export our port
EXPOSE 8080
# command to run
ENTRYPOINT [ "java","-jar","demo.jar" ]
