DROP TABLE IF EXISTS user_account;
DROP TABLE IF EXISTS brand;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS order_product;

CREATE TABLE user_account
(
    id          bigint       not null AUTO_INCREMENT,
    login_id    varchar(50)  not null,
    email       varchar(50)  not null,
    password    varchar(255) not null,
    role        varchar(50)  not null,
    created_at  timestamp    not null,
    modified_at timestamp    not null,
    PRIMARY KEY (id)
);

CREATE TABLE brand
(
    id               bigint       not null AUTO_INCREMENT,
    brand_manager_id bigint       not null,
    brand_name       varchar(255) not null,
    brand_status     varchar(50)  not null,
    created_at       timestamp    not null,
    modified_at      timestamp    not null,
    PRIMARY KEY (id),
    FOREIGN KEY (brand_manager_id) REFERENCES user_account (id)
);

CREATE TABLE product
(
    id               bigint       not null AUTO_INCREMENT,
    product_name     varchar(255) not null,
    product_category varchar(50)  not null,
    created_at       timestamp    not null,
    modified_at      timestamp    not null,
    PRIMARY KEY (id)
);

CREATE TABLE orders
(
    id              bigint      not null AUTO_INCREMENT,
    user_account_id bigint      not null,
    order_status    varchar(50) not null,
    created_at      timestamp   not null,
    modified_at     timestamp   not null,
    PRIMARY KEY (id),
    FOREIGN KEY (user_account_id) REFERENCES user_account (id)
);

CREATE TABLE order_product
(
    id          bigint    not null AUTO_INCREMENT,
    order_id    bigint    not null,
    product_id  bigint    not null,
    created_at  timestamp not null,
    modified_at timestamp not null,
    PRIMARY KEY (id),
    FOREIGN KEY (order_id) REFERENCES orders (id),
    FOREIGN KEY (product_id) REFERENCES product (id)
);