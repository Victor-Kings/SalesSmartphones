--drop table sales;
--drop type statusType
--drop table product;

CREATE TABLE product(
 id serial NOT null,
 mark VARCHAR(255) NULL,
 amount INTEGER NULL,
 model VARCHAR(255) NULL,
 color VARCHAR(255) NULL,
 price NUMERIC NULL,
 id_sales serial,
 PRIMARY KEY (id),
 FOREIGN KEY (id_sales) REFERENCES sales (id)
);

CREATE TABLE customer(
 id serial NOT NULL,
 name VARCHAR(255) NOT NULL,
 cpf VARCHAR(255) NOT NULL,
 address VARCHAR(255) NOT NULL,
 phone VARCHAR(255) NOT NULL,
 PRIMARY KEY (id)
);

--CREATE TYPE statusType as ENUM('AGUARDANDO_PAGAMENTO','PAGAMENTO_RECEBIDO','SAINDO_PARA_ENTREGA','CONCLUIDO','CANCELADA');

CREATE TABLE sales(
 id serial NOT NULL,
 id_customer serial,
 id_product serial,
 buy_date timestamp NOT NULL,
 delivery_date timestamp,
 status_sales VARCHAR(255),
 PRIMARY KEY (id),
 FOREIGN KEY (id_customer) REFERENCES customer (id)
);

--alter table products rename to product