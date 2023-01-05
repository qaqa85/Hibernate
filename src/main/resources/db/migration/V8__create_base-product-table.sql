CREATE TABLE base_product (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(500) NOT NULL,
    created DATETIME NOT NULL,
    product_type VARCHAR(15) NOT NULL,
    weight DECIMAL(5,2),
    width INT,
    length INT,
    height INT,
    downloadable boolean,
    file_path VARCHAR(100),
    file_name VARCHAR(100),
    PRIMARY KEY (id)
);