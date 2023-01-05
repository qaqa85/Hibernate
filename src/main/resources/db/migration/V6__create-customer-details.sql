CREATE TABLE customer_details (
    id BIGINT NOT NULL,
    birth_place VARCHAR(100) NOT NULL,
    birth_day DATETIME NOT NULL,
    father_name VARCHAR(50),
    mother_name VARCHAR(50),
    pesel VARCHAR(11),
    PRIMARY KEY (id),
    FOREIGN KEY (id) REFERENCES customer(id)
);