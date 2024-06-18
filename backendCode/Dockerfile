# # Build we are running our app (This is our image)
# FROM maven:3.8.5-openjdk-17 AS build
# # Copy everything within our file
# COPY . .
# # create our jar
# RUN mvn clean package

# FROM openjdk:17.0.1-jdk-slim
# # copy our file from movies snapshot into demo.jar
# COPY --from=build /target/movies-0.0.1-SNAPSHOT.jar demo.jar
# # export our port
# EXPOSE 8080
# # command to run
# ENTRYPOINT [ "java","-jar","demo.jar" ]


FROM openjdk:22-slim
COPY target/*jar app.jar
ENTRYPOINT [ "java","-jar","app.jar" ]