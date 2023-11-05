CREATE TABLE product_registry (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100),
  version INTEGER,
  primary_contact VARCHAR(100),
  database VARCHAR(100),
  domain VARCHAR(100),
  json_schema VARCHAR(100)
);