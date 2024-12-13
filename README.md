# Spring Boot Quiz Application

This is a simple quiz application built with **Spring Boot**. The application allows users to perform the following actions through the provided APIs:

1. Start a new quiz session.
2. Get a random multiple choice question from a set of questions in the database.
3. Submit an answer for a question.
4. Get the total number of questions answered by the user, along with details on correct and incorrect submissions.

## Assumptions
- The application uses **H2 Database** for simplicity and quick setup.
- A set of pre-defined multiple-choice questions are seeded into the database.
- A single user is assumed to be answering the quiz.
- Each answer submitted by the user is associated with their session.
- This app only focuses on the API endpoints for handling quiz logic, no endpoints for creating questions are included.

## Technologies Used
- **Spring Boot** (for backend)
- **H2 Database** (in-memory database for simplicity)
- **Spring Data JPA** (for data persistence)
- **Spring Web** (for creating RESTful APIs)
- **Lombok** (for reducing boilerplate code)

##Features
- **Start Quiz** : Fetch a random question and display option.
- **Submit Answer** : Submit the answer to a question.
- **Get Results** : At the end of the quiz, the application provides the result of correct answers.

##Prerequisites
- Java 17 or higher installed on your system.
- Maven installed for building the project.
- Postman (or any API testing tool) for testing the APIs.

##Steps to Set Up
1. Clone the Repository
```
git clone https://github.com/<your-username>/quiz-application.git  
```
```
cd quiz-application
```
2. Build the Project
- Use Maven to build the project: 
`mvn clean install`

3. Run the Application
 - Start the application using the following command:
`mvn spring-boot:run  

4. Access the H2 Database
- The application uses the H2 in-memory database.
- To access the database, open a browser and go to:
`http://localhost:8080/h2-console`

- Enter the following credentials (found in application.properties):
- JDBC URL: jdbc:h2:mem:testdb
- Username: 
- Password: 
- Click Connect to view the tables and data.

![Database connection](https://github.com/user-attachments/assets/8d595abc-ec4b-434c-a5e8-a82b719be61f)

![Tables show](https://github.com/user-attachments/assets/92f500bc-3491-4c70-b0d1-0f46d801fe0b)


##Testing the APIs
You can use Postman (or any API testing tool) to test the application. Below are the API endpoints and how to use them:

## API Endpoints

### 1. Get a Random Question
- **Endpoint**: `GET /quiz/questions`
- **Description**: Fetches a random multiple-choice question from the database.
- **Response**: A random `Question` object containing the question and its multiple options.

#### Example Response:
```bash
"id": 1,
  "question": "What is the capital of France?",
  "optionA": "Berlin",
  "optionB": "Madrid",
  "optionC": "Paris",
  "optionD": "Rome"
```

### 2. Submit an Answer
- Endpoint: POST /quiz/submit
- Description: Submits an answer to a question.
- Example Request:
```json
{  
  "userId": 1,  
  "questionId": 2,  
  "selectedOption": "C"  
}  

```
-Expected Response:
```json
{  
  "message": "Answer submitted successfully."  
}  

```

###3. Get Quiz Results
- Endpoint: GET /quiz/results
- Description: Fetches the total questions answered by the user and details of correct/incorrect submissions.
- Example Response:
```json
{  
  "userId": 1,  
  "totalQuestions": 5,  
  "correctAnswers": 4,  
  "incorrectAnswers": 1,  
  "score": 80.0  
}  

```

###Troubleshooting
- If you encounter an error while running the application, make sure you have Java 17 or later installed and that the H2 database is properly initialized.
