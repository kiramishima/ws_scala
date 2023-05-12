CREATE TABLE IF NOT EXISTS customer (
    id SERIAL,
    name VARCHAR(45) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS product (
    id SERIAL,
    title VARCHAR(45) NOT NULL,
    creation_date DATE NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO customer (name)
VALUES
    ('Alice Abbott'),
    ('Bob Brown'),
    ('Charlie Clarke');

INSERT INTO product (title, creation_date)
VALUES
    ('Sword', CURRENT_DATE + INTERVAL '30'),
    ('Potion', CURRENT_DATE + INTERVAL '45');