# Data Mesh API

This repository stores the code for a data mesh platform API to allow users to add and view data products.

## Technologies

- Python3, FastApi, Postgres, Poetry, PyTest, Docker, Docker-Compose, Github Actions

## Local set-up

This project utilized `docker-compose` to build and run the fastapi app as well as the cooresponding postgres database and admin dashboard

1. Navigate to the root directory and run `docker compose up`
2. Navigate to the root endpoint at `localhost:8000`
3. To view the database dashboard navigate to 'http://localhost:8080/`
   local database credentials:

- username: postgres
- password: example

### Endpoints

(view FastAPI docs @ localhost:8000/docs)

- `POST "/create/"`

  - This endpoint will add a data product to the registry table `product_registry` table hosted in the local `postgres` database running

Example:

```
curl -X 'POST' \
 'http://localhost:8000/product/create' \
 -H 'accept: application/json' \
 -H 'Content-Type: application/json' \
 -d '{
"table": "test_table",
"json_schema": "{\"name\":\"text\", \"location\":\"text\"}"
}'

```

- `POST "/product/create"`
  - This endpoint will create a table in the local `postgres` database with the passed schema

```
curl -X 'POST' \
  'http://localhost:8000/create/' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "name": "test_name",
  "version": 0.1,
  "primary_contact": "ismail",
  "database": "location",
  "domain": "weather",
  "json_schema": "{\"name\":\"text\", \"location\":\"text\"}"
}'
```
