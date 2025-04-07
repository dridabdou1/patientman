#### openApi url

    http://localhost:4000/v3/api-docs

### docker stuff

#### start the container

        docker-compose up -d

#### check the container

        docker ps

#### interact with db

        docker exec -it patient-postgres psql -U postgres -d patientman

Important Questions
Can you elaborate on your experience with microservices architecture and how you've implemented it in your projects?
What challenges have you faced when integrating SAP B1 with other systems, and how did you overcome them?
Can you provide examples of how you stay updated with new technologies and frameworks in the software development industry?
How do you prioritize and manage your tasks when working on multiple projects simultaneously?

#### generate target folder

make sure that the pom has grpc build then execute this to generate the stub

                mvn clean compile

