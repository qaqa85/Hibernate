DROP TABLE IF EXISTS review;
CREATE TABLE IF NOT EXISTS review (
    id BIGINT NOT NULL AUTO_INCREMENT,
    product_id BIGINT NOT NULL,
    content VARCHAR(400) NULL,
    rating INT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_review_product
        FOREIGN KEY (product_id)
        REFERENCES product (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
