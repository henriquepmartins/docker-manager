# Docker Manager

Docker Manager is a lightweight RESTful API built with Spring Boot to manage Docker containers and images. It leverages the docker-java library to interact with the Docker Engine, providing a simple interface for common container and image operations.

## Features

### Container Management

- **List Containers:**  
  Retrieve a list of Docker containers with an optional filter to show all or only running containers.  
  **Endpoint:** `GET /api/containers?showAll=[true|false]`

- **Start Container:**  
  Start a specific container by its ID.  
  **Endpoint:** `POST /api/containers/{id}/start`

- **Stop Container:**  
  Stop a running container by its ID.  
  **Endpoint:** `POST /api/containers/{id}/stop`

- **Remove Container:**  
  Remove a container by its ID.  
  **Endpoint:** `DELETE /api/containers/{id}`

- **Create Container:**  
  Create a new container using the specified image and container name.  
  **Endpoint:** `POST /api/containers?imageName=<image>&containerName=<name>`

### Image Management

- **List Images with Filter:**  
  Retrieve a list of Docker images filtered by a provided name.  
  **Endpoint:** `GET /api/images/filter?filterName=<filter>`  
  If no filter is provided, it uses the default value `"image-"`.

## How It Works

The application uses two main controllers:

- `DockerContainerController` for container operations.
- `DockerImagesController` for image filtering operations.

Both controllers delegate the operations to the `DockerService`, abstracting the interaction with Docker’s API. This design simplifies the management of Docker containers and images through well-defined RESTful endpoints.

## Screenshots

The following images showcase aspects of the application:

<img width="1582" alt="image" src="https://github.com/user-attachments/assets/a252bf77-3678-43f9-95d5-d5df2c2d585b" />

<img width="1582" alt="image" src="https://github.com/user-attachments/assets/43da1945-3c9b-4beb-8f69-225d860bbe9d" />

<img width="1582" alt="image" src="https://github.com/user-attachments/assets/7b1216ce-f219-4aa4-9865-2606458e9996" />

