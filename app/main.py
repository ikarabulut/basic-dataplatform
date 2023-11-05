import psycopg2
from fastapi import FastAPI
from fastapi.responses import JSONResponse
from pydantic import BaseModel, Json


class DataProduct(BaseModel):
    name: str
    version: float
    primary_contact: str
    database: str
    domain: str
    json_schema: str


conn = psycopg2.connect(database="postgres",
                        user="postgres",
                        host="postgres",
                        password="example",
                        port=5432)

app = FastAPI()


@app.get("/")
async def root():
    return {"message": "Hello World"}


@app.post("/create/")
async def add_product_to_registry(product: DataProduct):
    cur = conn.cursor()
    cur.execute(
        f"INSERT INTO product_registry(name, version, primary_contact, database, domain, json_schema) VALUES('{product.name}', {product.version}, '{product.primary_contact}', '{product.database}', '{product.domain}', '{product.json_schema}')")
    conn.commit()
    cur.close()
    return JSONResponse(content=f"{product}")
