CREATE TABLE customer_address (
    customer_id BIGINT NOT NULL,
    address_type VARCHAR(12) NOT NULL,
    postal_code VARCHAR(6) NOT NULL,
    street VARCHAR(120) NOT NULL,
    city VARCHAR(80) NOT NULL
);