CREATE database warsztaty2;

use warsztaty2;

create table user_group(id INT PRIMARY key auto_increment, name varchar(100) unique);
insert into user_group(name) Values ('first group'),('second group'),('third group');

create table users(id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100),
surname VARCHAR (100), email VARCHAR (200) Unique, password VARCHAR(100), user_group_id INT,
foreign key(user_group_id) references user_group(id));
har (500));

create table excercise (id INT PRIMARY KEY AUTO_INCREMENT, title varchar (255),
description Varchar (500));

create table solution (id INT AUTO_INCREMENT PRIMARY KEY, created DATETIME, updated DATETIME, 
description VARCHAR(500), excercise_id INT, user_id INT,
UNIQUE (excercise_id, user_id),
FOREIGN KEY (user_id) REFERENCES users(id),
FOREIGN KEY (excercise_id) REFERENCES excercise(id));


select * from users, user_group where users.user_group_id = user_group.id;

INSERT INTO excercise(title,description) VALUES 
('zadanie 1', 'latwe zadanie nr 1'),
('zadanie 2', 'trudne zadanie nr 2'),
('zadanie 3', 'trudne zadanie nr 3');

