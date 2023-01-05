CREATE TABLE note (
    id BIGINT NOT NULL,
    content VARCHAR(500) NOT NULL,
    created DATETIME NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE customer_note (
    customer_id BIGINT NOT NULL,
    notes_id BIGINT NOT NULL,
    PRIMARY KEY (customer_id, notes_id),
    CONSTRAINT fk_customer_customer_id
        FOREIGN KEY (customer_id) REFERENCES customer(id),
    CONSTRAINT fk_note_note_id
        FOREIGN KEY (notes_id) REFERENCES note(id)
);