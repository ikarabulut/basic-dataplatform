CREATE TABLE product_registry (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100),
  version VARCHAR(100),
  primary_contact VARCHAR(100),
  database VARCHAR(100),
  domain VARCHAR(100)
);