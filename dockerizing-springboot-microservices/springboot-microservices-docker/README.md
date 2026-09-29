# Employee Management Microservices Project

## Services and ports

| Service | Port |
|---|---:|
| Service Registry | 8761 |
| Config Server | 8888 |
| Department Service | 8081 |
| Employee Service | 8082 |
| Organization Service | 8084 |
| API Gateway | 9191 |

## MySQL ports in Docker Compose

| Container | Host port | Database |
|---|---:|---|
| department-mysql | 3307 | department_db |
| employee-mysql | 3308 | employee_db |
| organization-mysql | 3309 | organization_db |

## Run with Docker Compose

```bash
docker compose up --build
```

The config server uses the included `config-repo` folder. In Docker Compose, this folder is mounted into the config-server container.

## Test APIs through API Gateway

Create a department:

```http
POST http://localhost:9191/api/departments
Content-Type: application/json

{
  "departmentName": "Information Technology",
  "departmentDescription": "Handles software development and IT operations",
  "departmentCode": "IT"
}
```

Create an organization:

```http
POST http://localhost:9191/api/organizations
Content-Type: application/json

{
  "organizationName": "Java Guides Pvt Ltd",
  "organizationDescription": "Software training and product development organization",
  "organizationCode": "JG",
  "createdDate": "2026-06-04T10:30:00"
}
```

Create an employee:

```http
POST http://localhost:9191/api/employees
Content-Type: application/json

{
  "firstName": "Ramesh",
  "lastName": "Fadatare",
  "email": "ramesh@example.com",
  "departmentCode": "IT",
  "organizationCode": "JG"
}
```

Get employee with department and organization details:

```http
GET http://localhost:9191/api/employees/1
```

