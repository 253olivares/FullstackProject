#### Repository for Fullstack Spring Boot Project  

This project is a movie database fullstack created using Java, MongoDB, and React js.

LINK TO BACKEND API: https://backendrepository-byzb.onrender.com/api/v1/movies

#### BackEnd

The backend utilizes a build tool Maven to set up our spring framework. Using mongoDB atlas we create a cloud data base that we connect to our spring backend through using enviromental variables.

To use this project one need to provide their only credital log within the .env file created from .env.example
File Location: backendCode\src\main\resources\.env

Followed by launching the application using the main java file MoviesApplication.java

This will start our backend api assuming the connected mondodb is set up properly.

####  CURRENT API Maps

Current Home of all our collections

**GET** localhost:8080/api/v1/movies - Fetch all our movies from our Movies collection in mongoDB

**GET** localhost:8080/api/v1/reviews - Fetch all our reviews from our Reviews collection in mongoDB

**Get** localhost:8080/api/v1/movies/${id} - Fetches our select movie based on the id provided. Java grabs our id and fetches it from the mongodb using spring

**Push** localhost:8080/api/v1/reviews/addReview - Pushes a new review to our data base by passing our reviewbody and imdbId through the header instead of passing it through the uri

Postman was utilized for testing purposes to check these end points were functional

#### FrontEnd

Fontend consists our React, tailwindCSS, and ReactRedux.

The practice module was initial created using the guide below as practice to use spring. I am taking my own liberties on the front end to create my own unique interface for this project.



###### Sources:

This is a follow along project where I am following along a online lab to understand how to utilize these langauges together.

Project will utilize MongoDB for the database
Java for backend
React for front end


Provided below is the lab I am following along with: 
[https://www.youtube.com/watch?v=5PdEmeopJVQ&list=WL&index=110](https://www.youtube.com/watch?v=5PdEmeopJVQ&list=WL&index=110)
