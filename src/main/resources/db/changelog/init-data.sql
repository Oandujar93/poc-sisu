INSERT INTO brand (name) VALUES ('Zara');
INSERT INTO brand (name) VALUES ('Pull&Bear');
INSERT INTO brand (name) VALUES ('Massimo Dutti');
INSERT INTO brand (name) VALUES ('Bershka');
INSERT INTO brand (name) VALUES ('Stradivarius');
INSERT INTO brand (name) VALUES ('Oysho');
INSERT INTO brand (name) VALUES ('Zara Home');

INSERT INTO product (id, name, description) VALUES (35455, 'Camisa Lino', 'Camisa perfecta para el calor');
INSERT INTO product (id, name, description) VALUES (35454, 'Pantalon Polar', 'Prenda perfecta para el frio');
INSERT INTO product (id, name, description) VALUES (35456, 'Gorro', 'Prenda perfecta para el frio');
INSERT INTO product (id, name, description) VALUES (35457, 'Guantes', 'Prenda perfecta para el frio');

INSERT INTO prices (start_date, end_date, price_list, price, currency, brand_id, product_id, priority) VALUES ('2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 35.50, 'EUR', 1, 35455, 0);
INSERT INTO prices (start_date, end_date, price_list, price, currency, brand_id, product_id, priority) VALUES ('2020-06-14 15:00:00', '2020-06-14 18:30:00', 2, 25.45, 'EUR', 1, 35455, 1);
INSERT INTO prices (start_date, end_date, price_list, price, currency, brand_id, product_id, priority) VALUES ('2020-06-15 00:00:00', '2020-06-15 11:00:00', 3, 30.50, 'EUR', 1, 35455, 1);
INSERT INTO prices (start_date, end_date, price_list, price, currency, brand_id, product_id, priority) VALUES ('2020-06-15 16:00:00', '2020-12-31 23:59:59', 4, 38.95, 'EUR', 1, 35455, 1);