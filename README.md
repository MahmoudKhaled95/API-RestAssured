# API Automation Testing Project

## Table of Contents
- [Overview](#Overview)
- [Project Structure](#Project-Structure)
- [Prerequisites](#Prerequisites)
- [Features](#Features)
- [Project Layout](#Project-Layout)
- [Clone the Repository](#clone-the-repository)
- [Running the Tests](#running-the-tests)
  - [Using IDE](#using-ide)
  - [Using Maven](#using-maven)
- [Enhancing API Security with Token-Based Authorization](#Enhancing-API-Security-with-Token-Based-Authorization)
- [Validation for Test Cases](#Validation-for-Test-Cases)
- [TestNG Reports](#TestNG-Reports)
- [Demo Videos](#Demo-Videos) 

## Overview 
- This project demonstrates API testing using Java with Rest Assured and TestNG. 
- The project is designed to automate various API tests, including authentication, booking creation, and retrieval. 
- The project follows best practices in automation, including the use of the Page Object Model (POM) pattern and data-driven testing.

## Project Structure
- Java Version: 3.141.59
- Rest Assured Version: 3.4.0
- Maven Version: 3.0.0-M5
- TestNG Version: 7.8.0
- Operating System: Windows 11
  
## Prerequisites
- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) (my version  17.0.8)
- [Maven](https://maven.apache.org/install.html)
- [Rest Assured](https://rest-assured.io/)

## Features
1. Parallel Test Execution: Configured to run 3 tests in parallel using TestNG.
2. Page Object Model (POM): Implements the POM pattern for organizing test code.3
3. Data-Driven Testing: Uses external data files for dynamic testing.

## Project Layout
1- src/test/java/test1:
   - Contains all test cases.
        - Test1.authPOST: Tests the authentication API endpoint.
        - Test1.bookingPOST: Tests the booking creation API endpoint.
        - Test1.bookingGET: Tests the booking retrieval API endpoint.
     
2- src/test/resources:
   - Contains data-driven files used in tests.
        -  body.json: json file used for request auth.
        -  bookingData.json: JSON file containing booking data for tests.

- encapsulate the elements in a separate class to improve the maintainability and readability of my code. This is often referred to as the Page Object Model (POM) pattern.
  
 1. POM Pattern of my Project :
    
    ```css
     APIs-Automation
       ├── pom.xml
       ├── testng.xml
       ├── src
       │   ├── main
       │   │   └── java
       │   │       
       │   │     
       │   │       
       │   └── test
       │       └── java
       │       │    └── Test1
       │       │        └── authPOST
       │       │        ├── bookingPOST
       │       │        ├── bookingGET
       │       │        └── GlobalVaiables          
       │       │                      
       │       │                          
       │       │            . 
       │       │               
       │       └──resourses             
       │                   └── bookingData.json
       │                   └── body.json
       │                        
       └── README.md


## Clone the Repository
1. Clone:

   ```sh
   git clone https://github.com/Yassmin-gamal/API-Automation.git
   cd API-Automation

## Running the Tests

### Using IDE
   Open testng.xml in your IDE.
   Right-click on testng.xml and select "Run 'testng.xml'".

### Using Maven
1. Maven Test
   ```sh
   mvn test

## Enhancing API Security with Token-Based Authorization
- Currently, the API endpoints for operations such as retrieving lists and posting bookings are accessible without additional security measures. To further strengthen the security of our APIs, I would suggest implementing token-based authorization
- The retrieved token is stored in a global variable, allowing it to be reused across different test cases. This approach ensures that all subsequent API requests to secured endpoints include the necessary authorization token.

## Validation for Test Cases
1- authPOST

![WhatsApp Image 2024-08-18 at 9 20 35 PM](https://github.com/user-attachments/assets/2dea79e1-f132-4049-9641-cfe0771bb67a)

2- bookingGET

![cxz](https://github.com/user-attachments/assets/46940fe1-33e3-43e0-8a3d-2df95e898229)


3- bookingGET

![WhatsApp Image 2024-08-18 at 9 21 01 PM](https://github.com/user-attachments/assets/65bbb6f6-8166-48ce-86af-1bde31303dc5)


## TestNG Reports
- Run 3 tests in parallel as specified in the testng.xml file.
  
![test1](https://github.com/user-attachments/assets/d215d8b6-1fba-42e4-a9c1-09c71257dabb)

## Demo Videos

1- Scenario 1: 

https://github.com/user-attachments/assets/470ac852-570b-4296-8015-df4f0280cf31

2- Scenario 2 : 

https://github.com/user-attachments/assets/225e1f4d-2a4b-4714-87e9-3ca09a2adf10

3- Scenario 3 :

https://github.com/user-attachments/assets/b93edeae-377b-4620-aaec-6b47d30fca81

4- 3 tests in parallel : 


https://github.com/user-attachments/assets/2593ea25-4115-4afc-ac9e-e64c144991e6

