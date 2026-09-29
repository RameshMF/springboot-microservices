
# Dockerizing Spring Boot Microservices

This folder contains two versions of the Spring Boot Microservices project used in the course.

## Repository Structure

```text
dockerizing-springboot-microservices/
│
├── springboot-microservices-latest/
│
└── springboot-microservices-docker/
```

## Download the GitHub Repository

Clone the GitHub repository:

```bash
git clone https://github.com/RameshMF/springboot-microservices.git
```

Or download the repository as a ZIP file from GitHub and extract it.

After downloading, go to:

```text
dockerizing-springboot-microservices/
```

## Start with `springboot-microservices-latest`

Open:

```text
dockerizing-springboot-microservices/springboot-microservices-latest
```

This is the latest Spring Boot Microservices project without Docker.

Use this project to follow the Dockerizing Spring Boot Microservices lectures step by step.

### Import into IntelliJ IDEA

1. Open IntelliJ IDEA.
2. Click **Open**.
3. Navigate to:

```text
dockerizing-springboot-microservices/springboot-microservices-latest
```

4. Select the project folder.
5. Click **Open**.
6. Allow IntelliJ IDEA to import the Maven projects and download the required dependencies.

Use this project while following the course and add the Docker-related configuration step by step.

## Use `springboot-microservices-docker` as Reference

The folder:

```text
dockerizing-springboot-microservices/springboot-microservices-docker
```

contains the complete and working Dockerized Spring Boot Microservices project from the course.

Use this project as a reference if:

- You want to compare your implementation with the completed code.
- You encounter an issue while Dockerizing a microservice.
- You want to verify a Dockerfile.
- You want to verify Docker Compose configuration.
- You want to check Docker-specific Spring configuration.
- You want to see the final working project after completing the course section.

## Recommended Course Workflow

Start with:

```text
springboot-microservices-latest
```

Follow the course and Dockerize the project step by step.

If you need help or want to compare your code, refer to:

```text
springboot-microservices-docker
```

The `springboot-microservices-docker` folder contains the final working source code demonstrated in the course.
