import psycopg
import json
from fastapi import FastAPI
from fastapi.responses import JSONResponse
from pydantic import BaseModel, Json


class Product(BaseModel):
    table: str
    json_schema: str


class DataProduct(BaseModel):
    name: str
    version: float
    primary_contact: str
    database: str
    domain: str
    json_schema: str


app = FastAPI()


@app.get("/")
async def root():
    return {"message": "Hello World"}


@app.post("/create/")
async def add_product_to_registry(product: DataProduct):
    conn = psycopg.connect(
        "dbname=postgres user=postgres host=postgres password=example port=5432")
    cur = conn.cursor()
    cur.execute(
        f"INSERT INTO product_registry(name, version, primary_contact, database, domain, json_schema) VALUES('{product.name}', {product.version}, '{product.primary_contact}', '{product.database}', '{product.domain}', '{product.json_schema}')")
    conn.commit()
    cur.close()
    conn.close()

    return JSONResponse(content=f"{product}")


@app.post("/product/create")
async def create_sql_data_product(product: Product):
    conn = psycopg.connect(
        "dbname=postgres user=postgres host=postgres password=example port=5432")
    cur = conn.cursor()
    cur.execute(build_create_table_query(product))
    conn.commit()
    cur.close()
    conn.close()
    return JSONResponse(content=f"{product}")


def build_create_table_query(product: Product):
    schema = json.loads(product.json_schema)
    keys = list(dict.keys(schema))
    string_builder = f"CREATE TABLE {product.table} (id SERIAL PRIMARY KEY, "
    for key in keys:
        if key == keys[-1]:
            string_builder += f"{str.upper(key)} {schema[key]})"
            string_builder += ";"
        else:
            string_builder += f"{str.upper(key)} {schema[key]}, "
    return string_builder
