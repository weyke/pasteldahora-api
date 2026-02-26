CREATE TABLE pasteldahora.tb_produtos (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    categoria VARCHAR(64) NOT NULL,
    descricao VARCHAR(512) NOT NULL,
    preco NUMERIC(10,2) NOT NULL,
    image_url VARCHAR(255) NOT NULL,
    status BOOLEAN NOT NULL DEFAULT TRUE
);