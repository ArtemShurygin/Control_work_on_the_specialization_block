/*
7. В подключенном MySQL репозитории создать базу данных “Друзья
человека
*/

DROP DATABASE IF EXISTS human_Friends;
CREATE DATABASE IF NOT EXISTS human_Friends;
USE human_Friends;


/*
8. Создать таблицы с иерархией из диаграммы в БД
*/

CREATE TABLE IF NOT EXISTS animals
(	
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    class VARCHAR(45)
);

CREATE TABLE IF NOT EXISTS pets
(	
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    type VARCHAR(45),
    class_id INT,
    FOREIGN KEY (class_id)
	REFERENCES animals(id)
);

CREATE TABLE IF NOT EXISTS pack_animals
(	
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    type VARCHAR(45),
    class_id INT,
    FOREIGN KEY (class_id)
	REFERENCES animals(id)
);

CREATE TABLE IF NOT EXISTS dogs
(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(45),
commands VARCHAR(200),
birthdate DATE,
type_id INT,
FOREIGN KEY (type_id)
REFERENCES pets(id)
);

CREATE TABLE IF NOT EXISTS cats
(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(45),
commands VARCHAR(200),
birthdate DATE,
type_id INT,
FOREIGN KEY (type_id)
REFERENCES pets(id)
);

CREATE TABLE IF NOT EXISTS hamsters
(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(45),
commands VARCHAR(200),
birthdate DATE,
type_id INT,
FOREIGN KEY (type_id)
REFERENCES pets(id)
);

CREATE TABLE IF NOT EXISTS horses
(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(45),
commands VARCHAR(200),
birthdate DATE,
type_id INT,
FOREIGN KEY (type_id)
REFERENCES pack_animals(id)
);

CREATE TABLE IF NOT EXISTS camels
(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(45),
commands VARCHAR(200),
birthdate DATE,
type_id INT,
FOREIGN KEY (type_id)
REFERENCES pack_animals(id)
);

CREATE TABLE IF NOT EXISTS donkeys
(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(45),
commands VARCHAR(200),
birthdate DATE,
type_id INT,
FOREIGN KEY (type_id)
REFERENCES pack_animals(id)
);

/*
9. Заполнить низкоуровневые таблицы именами(животных), командами
которые они выполняют и датами рождения
*/


INSERT INTO animals(class)
VALUES
('домашнее животное'),
('вьючное животное');

INSERT INTO pets(type, class_id)
VALUES
('собака', 1),
('кошка', 1),
('хомяк', 1);

INSERT INTO pack_animals(type, class_id)
VALUES
('лошадь', 2),
('верблюд', 2),
('осел', 2);

-- Домашние животные

INSERT INTO dogs(name, commands, birthdate, type_id)
VALUES
('Боб', 'сидеть, лежать, голос', '2016-5-4', 1),
('Рокки', 'сидеть, лежать', '2022-8-3', 1);

INSERT INTO cats(name, commands, birthdate, type_id)
VALUES
('Мика', 'кушать', '2023-5-4', 2),
('Пуша', 'кушать', '2022-8-7', 2),
('Тиша', 'кушать, сидеть, лежать', '2020-8-3', 2);

INSERT INTO hamsters(name, commands, birthdate, type_id)
VALUES
('Шуша', 'кушать, ко мне, сидеть, лежать', '2018-7-2', 3),
('Тихон', 'кушать, ко мне', '2021-8-3', 3);


-- Вьючные животные

INSERT INTO horses(name, commands, birthdate, type_id)
VALUES
('Зорька', 'вперед, стоять, голос', '2018-11-4', 1),
('Буран', 'вперед, стоять, быстро', '2022-8-3', 1);

INSERT INTO camels(name, commands, birthdate, type_id)
VALUES
('Дружок', 'вперед, стоять, быстро', '2023-5-4', 2);

INSERT INTO donkeys(name, commands, birthdate, type_id)
VALUES
('Изабель', 'вперед, стоять, быстро', '2019-7-12', 3),
('Гарри', 'кушать, вперед, стоять, быстро', '2021-12-8', 3);


-- Вывод таблиц

SELECT * FROM animals;

SELECT p.type, a.class
FROM pets p
JOIN animals a 
ON p.class_id = a.id;

SELECT pa.type, a.class
FROM pack_animals pa
JOIN animals a 
ON pa.class_id = a.id;

SELECT d.name, d.commands, d.birthdate, p.type, a.class
FROM dogs d
JOIN pets p 
ON d.type_id = p.id
JOIN animals a
ON p.class_id = a.id;

SELECT c.name, c.commands, c.birthdate, p.type, a.class
FROM cats c
JOIN pets p 
ON c.type_id = p.id
JOIN animals a
ON p.class_id = a.id;

SELECT h.name, h.commands, h.birthdate, p.type, a.class
FROM hamsters h
JOIN pets p 
ON h.type_id = p.id
JOIN animals a
ON p.class_id = a.id;

SELECT h.name, h.commands, h.birthdate, pa.type, a.class
FROM horses h
JOIN pack_animals pa
ON h.type_id = pa.id
JOIN animals a
ON pa.class_id = a.id;

SELECT c.name, c.commands, c.birthdate, pa.type, a.class
FROM camels c
JOIN pack_animals pa 
ON c.type_id = pa.id
JOIN animals a
ON pa.class_id = a.id;

SELECT d.name, d.commands, d.birthdate, pa.type, a.class
FROM donkeys d
JOIN pack_animals pa
ON d.type_id = pa.id
JOIN animals a
ON pa.class_id = a.id;


/*
10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.
*/

DROP TABLE IF EXISTS camels;

DELETE
FROM pack_animals
WHERE type = 'верблюд';

SELECT pa.type, a.class
FROM pack_animals pa
JOIN animals a 
ON pa.class_id = a.id;

CREATE TABLE horses_and_donkeys
(
id INT PRIMARY KEY AUTO_INCREMENT
)
SELECT h.name, h.commands, h.birthdate, pa.type, a.class
FROM horses h
JOIN pack_animals pa
ON h.type_id = pa.id
JOIN animals a
ON pa.class_id = a.id
UNION
SELECT d.name, d.commands, d.birthdate, pa.type, a.class
FROM donkeys d
JOIN pack_animals pa
ON d.type_id = pa.id
JOIN animals a
ON pa.class_id = a.id;

SELECT *
FROM horses_and_donkeys;


/*
11.Создать новую таблицу “молодые животные” в которую попадут все
животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
до месяца подсчитать возраст животных в новой таблице
*/

CREATE TABLE young_animals
(
id INT PRIMARY KEY AUTO_INCREMENT
)
SELECT
name,
commands,
birthdate,
TIMESTAMPDIFF (MONTH, birthdate, CURDATE()) as age_in_months,
type,
class
FROM
(
	SELECT d.name, d.commands, d.birthdate, p.type, a.class
	FROM dogs d
	JOIN pets p 
	ON d.type_id = p.id
	JOIN animals a
	ON p.class_id = a.id
	UNION
	SELECT c.name, c.commands, c.birthdate, p.type, a.class
	FROM cats c
	JOIN pets p 
	ON c.type_id = p.id
	JOIN animals a
	ON p.class_id = a.id
	UNION
	SELECT h.name, h.commands, h.birthdate, p.type, a.class
	FROM hamsters h
	JOIN pets p 
	ON h.type_id = p.id
	JOIN animals a
	ON p.class_id = a.id
	UNION
	SELECT h.name, h.commands, h.birthdate, pa.type, a.class
	FROM horses h
	JOIN pack_animals pa
	ON h.type_id = pa.id
	JOIN animals a
	ON pa.class_id = a.id
	UNION
	SELECT d.name, d.commands, d.birthdate, pa.type, a.class
	FROM donkeys d
	JOIN pack_animals pa
	ON d.type_id = pa.id
	JOIN animals a
	ON pa.class_id = a.id
) AS t
WHERE birthdate BETWEEN  CURDATE() - INTERVAL 3 YEAR AND CURDATE() - INTERVAL 1 YEAR;


SELECT * 
FROM young_animals;
/*
12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
прошлую принадлежность к старым таблицам.
*/

CREATE TABLE all_animals
(
id INT PRIMARY KEY AUTO_INCREMENT
)
SELECT d.name, d.commands, d.birthdate, p.type, a.class
FROM dogs d
JOIN pets p 
ON d.type_id = p.id
JOIN animals a
ON p.class_id = a.id
UNION
SELECT c.name, c.commands, c.birthdate, p.type, a.class
FROM cats c
JOIN pets p 
ON c.type_id = p.id
JOIN animals a
ON p.class_id = a.id
UNION
SELECT h.name, h.commands, h.birthdate, p.type, a.class
FROM hamsters h
JOIN pets p 
ON h.type_id = p.id
JOIN animals a
ON p.class_id = a.id
UNION
SELECT h.name, h.commands, h.birthdate, pa.type, a.class
FROM horses h
JOIN pack_animals pa
ON h.type_id = pa.id
JOIN animals a
ON pa.class_id = a.id
UNION
SELECT d.name, d.commands, d.birthdate, pa.type, a.class
FROM donkeys d
JOIN pack_animals pa
ON d.type_id = pa.id
JOIN animals a
ON pa.class_id = a.id;

SELECT *
FROM all_animals;



