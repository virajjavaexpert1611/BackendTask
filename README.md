
# Guide 
Go To the project directory

Commands to run the backend project with docker
1. To build the project
   
        ./mvnw -e clean -DskipTests install

2. To build the docker image of the backend project

        docker build --build-arg NAME=UserName -t viraj/be-get-user-name .

3. To run the backend docker image

        docker run -p 8081:8081 viraj/be-get-user-name

4. The response of the backend API will be visible at http://localhost:8081/get-user


5. Commands to run the test cases for the project
    
        mvn test


6.  Helm chart is added into fe directory.


7. To deploy helm chart,
  
        helm upgrade -i be-app be/ --values be/values.yaml

8) To access service from browser,

        export NODE_PORT=$(kubectl get --namespace demo -o jsonpath="{.spec.ports[0].nodePort}" services be-app)
        export NODE_IP=$(kubectl get nodes --namespace demo -o jsonpath="{.items[0].status.addresses[0].address}")
        echo http://$NODE_IP:$NODE_PORT

# Notes:-
1. Update docker image reference and tag in values.yaml file,
    ```
    image:
      repository: viraj/be-get-user-name            ==> Update docker image
      pullPolicy: IfNotPresent
      # Overrides the image tag whose default is the chart appVersion.
      tag: "v3"                        ==> Update tag
    ```

2. Update service type and port according to app configuration if required,
      ```
        service:
          type: NodePort           
          port: 8081

      ## service type can be change to clusterIP if required.
      ```

3. Enable HPA if required,
      ```
      autoscaling:
        enabled: false
        minReplicas: 1
        maxReplicas: 100

      set above enabled: true and replicacounts
      ```

4. Update value of name and redeploy helm chart to see the changes,
      ```
      be:
        name: "Viraj"    ==> As per requirement
      ```
