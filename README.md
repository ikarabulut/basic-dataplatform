# Data Mesh API

This repository stores the code for a data mesh platform API to allow users to add and view data products.

## Technologies

- Python3
- FastApi
- Postgres
- Poetry
- PyTest
- Docker, Docker-Compose

## Local set-up

This project utilized `docker-compose` to build and run the fastapi app as well as the cooresponding postgres database and admin dashboard

1. Navigate to the root directory and run `docker compose up`
2. Navigate to the root endpoint at `localhost:8000`
3. To view the database dashboard navigate to 'http://localhost:8080/`

- username: postgres
- password: example
