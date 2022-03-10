# Getting Started

###Prerequisite


You need to have maven environment (mvn) and java


### Steps

1. Create database
    
    - You need create database before taking the next steps.

2. Connect database
   - Open **application.properties** file 

     ({path-file-to-project}\src\main\resources\application.properties)
   
   - You enter URL, USERNAME, PASSWORD 

   `spring.datasource.url=${DB_URL}`

   `spring.datasource.username=${DB_USERNAME}`

   `spring.datasource.password=${DB_PASSWORD}`