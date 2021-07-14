CREATE TABLE products(
 id serial NOT null,
 mark VARCHAR(255) NOT NULL,
 amount INTEGER NOT NULL,
 model VARCHAR(255) NOT NULL,
 color VARCHAR(255) NOT NULL,
 price NUMERIC NOT NULL,
 PRIMARY KEY (id)
);

CREATE TABLE customer(
 id serial NOT NULL,
 name VARCHAR(255) NOT NULL,
 cpf VARCHAR(255) NOT NULL,
 address VARCHAR(255) NOT NULL,
 phone VARCHAR(255) NOT NULL,
 PRIMARY KEY (id)
);

CREATE TABLE sales(
 id serial NOT NULL,
 id_customer serial NOT NULL,
 id_product serial NOT NULL,
 buy_date timestamp NOT NULL,
 delivery_date timestamp NOT NULL,
 PRIMARY KEY (id),
 FOREIGN KEY (id_customer) REFERENCES customer (id),
 FOREIGN KEY (id_product) REFERENCES products (id)
);