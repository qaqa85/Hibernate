DROP TABLE IF EXISTS category;
CREATE TABLE category (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name varchar(100) NULL,
    description varchar(800) NULL,
    PRIMARY KEY (id)
);

ALTER TABLE product
ADD COLUMN category_id BIGINT NULL;
