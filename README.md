
Go To the project directory

Commands to run the backend project with docker
1) To build the project
    
		./mvnw -e clean -DskipTests install
2) To build the docker image of the backend project
   

		docker build --build-arg NAME=UserName -t backend-task/get-user-name .
3) To run the backend docker image

		docker run -p 8081:8081 backend-task/get-user-name

The response of the backend API will be visible at http://localhost:8081/get-user


Commands to run the test cases for the project

		mvn test
