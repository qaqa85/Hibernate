DROP TABLE IF EXISTS attribute;
CREATE TABLE attribute (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NULL,
    value VARCHAR(800) NULL,
    PRIMARY KEY (id)
);

CREATE TABLE product_attribute (
    product_id BIGINT NOT NULL,
    attribute_id BIGINT NOT NULL,
    PRIMARY KEY (product_id, attribute_id),
    CONSTRAINT fk_product_attribute_product_id
        FOREIGN KEY (product_id) REFERENCES product (id),
    CONSTRAINT fk_product_attribute_attribute_id
        FOREIGN KEY (attribute_id) REFERENCES attribute (id)
);