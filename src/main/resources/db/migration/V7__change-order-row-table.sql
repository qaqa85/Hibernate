#  TABLE order_row DROP FOREIGN KEY fk_order_row_order_id;
ALTER TABLE order_row CHANGE order_id order_id BIGINT NULL ;
ALTER TABLE order_row ADD CONSTRAINT fk_order_row_order_id
    FOREIGN KEY (order_id) REFERENCES `order` (id);