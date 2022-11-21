CREATE TABLE abstract_object_plate (
   id INT PRIMARY KEY,
   created_at DATE,
   name VARCHAR(255),
   description TEXT
);

CREATE TABLE product_plate (
    id INT REFERENCES abstract_object_plate (id),
    calories INT,
    created_at DATE,
    name VARCHAR(255),
    description TEXT
);