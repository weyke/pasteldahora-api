CREATE TABLE pasteldahora.tb_products (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category VARCHAR(64) NOT NULL,
    description VARCHAR(512) NOT NULL,
    price NUMERIC(10,2) NOT NULL,
    image_url VARCHAR(255) NOT NULL,
    status BOOLEAN NOT NULL DEFAULT TRUE
);