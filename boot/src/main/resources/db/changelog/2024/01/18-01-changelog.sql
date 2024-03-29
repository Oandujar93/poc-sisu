-- liquibase formatted sql

-- changeset oandujar:1705571334729-1
DROP TABLE IF EXISTS prices;
CREATE TABLE prices
(
    id         BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    start_date TIMESTAMP with time zone,
    end_date   TIMESTAMP with time zone,
    fee        BIGINT,
    price      DOUBLE PRECISION,
    currency   VARCHAR(255),
    priority   INT,
    product_id BIGINT,
    CONSTRAINT pk_prices PRIMARY KEY (id)
);

-- changeset oandujar:1705571334729-2
DROP TABLE IF EXISTS product;
CREATE TABLE product
(
    id          BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name        VARCHAR(255),
    description VARCHAR(255),
    brand_id    BIGINT,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

-- changeset oandujar:1705571334729-3
DROP TABLE IF EXISTS brand;
CREATE TABLE brand
(
    id   BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_brand PRIMARY KEY (id)
);

-- changeset oandujar:1705571334729-4
ALTER TABLE prices
    ADD CONSTRAINT FK_PRICES_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES product (id);

-- changeset oandujar:1705571334729-5
ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_BRAND FOREIGN KEY (brand_id) REFERENCES brand (id);

