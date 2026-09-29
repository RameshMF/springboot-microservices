
# Docker Commands Used in the Course

This document contains the Docker commands used throughout the Dockerizing Spring Boot Microservices section.

Follow the commands lecture by lecture.

---

# Lecture name: Dockerize the Service Registry

## Go to the Service Registry Project

```bash
cd service-registry
```

## Build the Docker Image

```bash
docker build -t service-registry .
```

## List Docker Images

```bash
docker images
```

## Create Docker Network

```bash
docker network create microservices-net
```

## Run the Service Registry Container

Run the Service Registry container on Windows Command Prompt:

```bash
docker run -d -p 8761:8761 --name service-registry --network microservices-net service-registry
```

## Check Running Containers

```bash
docker ps
```

## Check Service Registry Logs

```bash
docker logs service-registry
```

---

# Lecture name: Dockerize the Config Server

## Go Back to the Parent Folder

```bash
cd ..
```

## Go to the Config Server Project

```bash
cd config-server
```

## Build the Docker Image

```bash
docker build -t config-server .
```

## List Docker Images

```bash
docker images
```

## Check Running Containers

```bash
docker ps
```

## Start Service Registry if It Is Stopped

```bash
docker start service-registry
```

## Run the Config Server Container

Run Config Server using the `docker` Spring profile:

```bash
docker run -d -p 8888:8888 --name config-server --network microservices-net -e SPRING_PROFILES_ACTIVE=docker config-server
```

## Check Config Server Logs

```bash
docker logs config-server
```

---

# Lecture name: Dockerize the Department Service

## Go Back to the Parent Folder

```bash
cd ..
```

## Go to the Department Service Project

```bash
cd department-service
```

## Build the Docker Image

```bash
docker build -t department-service .
```

## List Docker Images

```bash
docker images
```

## Verify or Create Docker Network

```bash
docker network create microservices-net
```

## Check Running Containers

```bash
docker ps
```

## Start Service Registry if It Is Stopped

```bash
docker start service-registry
```

## Start Config Server if It Is Stopped

```bash
docker start config-server
```

## Run Department MySQL Container

```bash
docker run -d -p 3307:3306 --name department-mysql --network microservices-net -e MYSQL_ROOT_PASSWORD=Mysql@123 -e MYSQL_DATABASE=department_db mysql:8.4
```

## Check Department MySQL Logs

```bash
docker logs department-mysql
```

## Run Department Service Container

Run Department Service using the `docker` Spring profile:

```bash
docker run -d -p 8081:8081 --name department-service --network microservices-net -e SPRING_PROFILES_ACTIVE=docker department-service
```

## Check Department Service Logs

```bash
docker logs department-service
```

## Open Eureka Dashboard

```text
http://localhost:8761
```

## Test Create Department API

```http
POST http://localhost:8081/api/departments
```

Request body:

```json
{
  "departmentName": "Information Technology",
  "departmentDescription": "IT Department",
  "departmentCode": "IT"
}
```

## Test Get Department API by Department Code

```http
GET http://localhost:8081/api/departments/IT
```

## Test Get All Departments API

```http
GET http://localhost:8081/api/departments
```

---

# Lecture name: Dockerize the Organization Service

## Go Back to the Parent Folder

```bash
cd ..
```

## Go to the Organization Service Project

```bash
cd organization-service
```

## Build the Docker Image

```bash
docker build -t organization-service .
```

## List Docker Images

```bash
docker images
```

## Verify or Create Docker Network

```bash
docker network create microservices-net
```

## Check Running Containers

```bash
docker ps
```

## Start Service Registry if It Is Stopped

```bash
docker start service-registry
```

## Start Config Server if It Is Stopped

```bash
docker start config-server
```

## Run Organization MySQL Container

```bash
docker run -d -p 3309:3306 --name organization-mysql --network microservices-net -e MYSQL_ROOT_PASSWORD=Mysql@123 -e MYSQL_DATABASE=organization_db mysql:8.4
```

## Check Organization MySQL Logs

```bash
docker logs organization-mysql
```

## Run Organization Service Container

Run Organization Service using the `docker` Spring profile:

```bash
docker run -d -p 8084:8084 --name organization-service --network microservices-net -e SPRING_PROFILES_ACTIVE=docker organization-service
```

## Check Organization Service Logs

```bash
docker logs organization-service
```

## Open Eureka Dashboard

```text
http://localhost:8761
```

## Test Create Organization API

```http
POST http://localhost:8084/api/organizations
```

Request body:

```json
{
  "organizationName": "Java Guides",
  "organizationDescription": "Java Guides Organization",
  "organizationCode": "JG"
}
```

## Test Get Organization API by Organization Code

```http
GET http://localhost:8084/api/organizations/JG
```

## Test Get All Organizations API

```http
GET http://localhost:8084/api/organizations
```

---

# Lecture name: Dockerize the Employee Service

## Go Back to the Parent Folder

```bash
cd ..
```

## Go to the Employee Service Project

```bash
cd employee-service
```

## Build the Docker Image

```bash
docker build -t employee-service .
```

## List Docker Images

```bash
docker images
```

## Verify or Create Docker Network

```bash
docker network create microservices-net
```

## Check Running Containers

```bash
docker ps
```

## Start Service Registry if It Is Stopped

```bash
docker start service-registry
```

## Start Config Server if It Is Stopped

```bash
docker start config-server
```

## Start Department Service if It Is Stopped

```bash
docker start department-service
```

## Start Organization Service if It Is Stopped

```bash
docker start organization-service
```

## Run Employee MySQL Container

```bash
docker run -d -p 3308:3306 --name employee-mysql --network microservices-net -e MYSQL_ROOT_PASSWORD=Mysql@123 -e MYSQL_DATABASE=employee_db mysql:8.4
```

## Check Employee MySQL Logs

```bash
docker logs employee-mysql
```

## Run Employee Service Container

Run Employee Service using the `docker` Spring profile:

```bash
docker run -d -p 8082:8082 --name employee-service --network microservices-net -e SPRING_PROFILES_ACTIVE=docker employee-service
```

## Check Employee Service Logs

```bash
docker logs employee-service
```

## Open Eureka Dashboard

```text
http://localhost:8761
```

## Test Create Employee API

```http
POST http://localhost:8082/api/employees
```

Request body:

```json
{
  "firstName": "Ramesh",
  "lastName": "Fadatare",
  "email": "ramesh@javaguides.net",
  "departmentCode": "IT",
  "organizationCode": "JG"
}
```

## Test Get Employee API by Employee ID

```http
GET http://localhost:8082/api/employees/1
```

---

# Lecture name: Dockerize the API Gateway

## Go Back to the Parent Folder

```bash
cd ..
```

## Go to the API Gateway Project

```bash
cd api-gateway
```

## Build the Docker Image

```bash
docker build -t api-gateway .
```

## List Docker Images

```bash
docker images
```

## Verify or Create Docker Network

```bash
docker network create microservices-net
```

## Check Running Containers

```bash
docker ps
```

## Start Required Containers if They Are Stopped

```bash
docker start service-registry
```

```bash
docker start config-server
```

```bash
docker start department-mysql
```

```bash
docker start employee-mysql
```

```bash
docker start organization-mysql
```

```bash
docker start department-service
```

```bash
docker start organization-service
```

```bash
docker start employee-service
```

## Run API Gateway Container

Run API Gateway using the `docker` Spring profile:

```bash
docker run -d -p 9191:9191 --name api-gateway --network microservices-net -e SPRING_PROFILES_ACTIVE=docker api-gateway
```

## Check API Gateway Logs

```bash
docker logs api-gateway
```

## Follow API Gateway Live Logs

```bash
docker logs -f api-gateway
```

## Open Eureka Dashboard

```text
http://localhost:8761
```

## Test Department APIs Through API Gateway

```http
GET http://localhost:9191/api/departments
```

```http
GET http://localhost:9191/api/departments/IT
```

## Test Organization APIs Through API Gateway

```http
GET http://localhost:9191/api/organizations
```

```http
GET http://localhost:9191/api/organizations/JG
```

## Test Employee API Through API Gateway

```http
GET http://localhost:9191/api/employees/1
```

---

# Lecture name: Create Docker Compose for Service Registry and Config Server

## Run Docker Compose

```bash
docker compose up --build
```

## Run Docker Compose in the Background

```bash
docker compose up --build -d
```

## Check Running Containers

```bash
docker compose ps
```

## Open Eureka Dashboard

```text
http://localhost:8761
```

## Test Config Server URLs

```text
http://localhost:8888/department-service/docker
```

```text
http://localhost:8888/employee-service/docker
```

```text
http://localhost:8888/organization-service/docker
```

```text
http://localhost:8888/api-gateway/docker
```

---

# Lecture name: Add MySQL Containers to Docker Compose

## Run Docker Compose

```bash
docker compose up --build
```

## Run Docker Compose in the Background

```bash
docker compose up --build -d
```

## Check Running Containers

```bash
docker compose ps
```

## Check Department MySQL Logs

```bash
docker compose logs department-mysql
```

## Check Employee MySQL Logs

```bash
docker compose logs employee-mysql
```

## Check Organization MySQL Logs

```bash
docker compose logs organization-mysql
```

## Stop Containers and Keep Volumes

```bash
docker compose down
```

## Stop Containers and Remove Volumes

```bash
docker compose down -v
```

## Test Config Server URLs

```text
http://localhost:8888/department-service/docker
```

```text
http://localhost:8888/employee-service/docker
```

```text
http://localhost:8888/organization-service/docker
```

---

# Lecture name: Add Department Service and Organization Service to Docker Compose

## Run Docker Compose

```bash
docker compose up --build
```

## Run Docker Compose in the Background

```bash
docker compose up --build -d
```

## Check Running Containers

```bash
docker compose ps
```

## Check Department Service Logs

```bash
docker compose logs department-service
```

## Check Organization Service Logs

```bash
docker compose logs organization-service
```

## Open Eureka Dashboard

```text
http://localhost:8761
```

## Test Create Department API

```http
POST http://localhost:8081/api/departments
```

Department request body:

```json
{
  "departmentName": "Information Technology",
  "departmentDescription": "IT Department",
  "departmentCode": "IT"
}
```

## Test Get Department API by Department Code

```http
GET http://localhost:8081/api/departments/IT
```

## Test Get All Departments API

```http
GET http://localhost:8081/api/departments
```

## Test Create Organization API

```http
POST http://localhost:8084/api/organizations
```

Organization request body:

```json
{
  "organizationName": "Java Guides",
  "organizationDescription": "Java Guides Organization",
  "organizationCode": "JG"
}
```

## Test Get Organization API by Organization Code

```http
GET http://localhost:8084/api/organizations/JG
```

## Test Get All Organizations API

```http
GET http://localhost:8084/api/organizations
```

---

# Lecture name: Add Employee Service to Docker Compose

## Run Docker Compose

```bash
docker compose up --build
```

## Run Docker Compose in the Background

```bash
docker compose up --build -d
```

## Check Running Containers

```bash
docker compose ps
```

## Check Employee Service Logs

```bash
docker compose logs employee-service
```

## Follow Employee Service Live Logs

```bash
docker compose logs -f employee-service
```

## Open Eureka Dashboard

```text
http://localhost:8761
```

## Verify Employee Service Docker Configuration

```text
http://localhost:8888/employee-service/docker
```

## Test Create Employee API Directly

```http
POST http://localhost:8082/api/employees
```

Employee request body:

```json
{
  "firstName": "Ramesh",
  "lastName": "Fadatare",
  "email": "ramesh@javaguides.net",
  "departmentCode": "IT",
  "organizationCode": "JG"
}
```

## Test Get Employee API Directly

```http
GET http://localhost:8082/api/employees/1
```

---

# Lecture name: Add API Gateway to Docker Compose

## Run Docker Compose

```bash
docker compose up --build
```

## Run Docker Compose in the Background

```bash
docker compose up --build -d
```

## Check Running Containers

```bash
docker compose ps
```

## Check API Gateway Logs

```bash
docker compose logs api-gateway
```

## Follow API Gateway Live Logs

```bash
docker compose logs -f api-gateway
```

## Open Eureka Dashboard

```text
http://localhost:8761
```

## Verify API Gateway Docker Configuration

```text
http://localhost:8888/api-gateway/docker
```

## Test Department API Through API Gateway

```http
GET http://localhost:9191/api/departments/IT
```

## Test Organization API Through API Gateway

```http
GET http://localhost:9191/api/organizations/JG
```

## Test Employee API Through API Gateway

```http
GET http://localhost:9191/api/employees/1
```


This structure preserves the commands from your original course notes, including the Docker network, MySQL container, service container, Docker Compose, logging, Eureka, Config Server, and API testing commands. 
