CREATE DATABASE IF NOT EXISTS film_db DEFAULT CHARACTER SET utf8;
USE film_db;

DROP TABLE IF EXISTS film_db.box_office;
DROP TABLE IF EXISTS film_db.film_director;
DROP TABLE IF EXISTS film_db.director;
DROP TABLE IF EXISTS film_db.`role`;
DROP TABLE IF EXISTS film_db.film_genre;
DROP TABLE IF EXISTS film_db.genre;
DROP TABLE IF EXISTS film_db.star;
DROP TABLE IF EXISTS film_db.country;
DROP TABLE IF EXISTS film_db.film;

CREATE TABLE IF NOT EXISTS film_db.film (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(45) NOT NULL,
  `description` TEXT NULL,
  running_time INT NOT NULL,
  release_date DATE NOT NULL,
  rate DOUBLE NULL,
  worldwide_box_office INT NULL,
  interesting_facts TEXT NULL
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS film_db.country (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(45) NOT NULL
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS film_db.star (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45) NOT NULL,
  age INT NOT NULL,
  date_of_birth DATE NULL,
  bio TEXT NULL
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS film_db.genre (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(45) NOT NULL
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS film_db.film_genre (
  film_id INT NOT NULL,
  genre_id INT NOT NULL,
  PRIMARY KEY (film_id, genre_id)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS film_db.`role` (
  film_id INT NOT NULL,
  star_id INT NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (film_id, star_id)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS film_db.director (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45) NOT NULL,
  age INT NULL,
  bio TEXT NULL
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS film_db.film_director (
  film_id INT NOT NULL,
  director_id INT NOT NULL,
  PRIMARY KEY (film_id, director_id)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS film_db.box_office (
  film_id INT NOT NULL,
  country_id INT NOT NULL,
  box_office BIGINT NOT NULL,
  PRIMARY KEY (film_id, country_id)
) ENGINE = InnoDB;

ALTER TABLE film_db.film_genre 
  ADD INDEX fk_film_genre_film1_idx (film_id ASC),
  ADD INDEX fk_film_genre_genre1_idx (genre_id ASC),
  ADD CONSTRAINT fk_film_genre_film1
    FOREIGN KEY (film_id)
    REFERENCES film_db.film (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  ADD CONSTRAINT fk_film_genre_genre1
    FOREIGN KEY (genre_id)
    REFERENCES film_db.genre (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;
    
ALTER TABLE film_db.`role`
  ADD INDEX fk_role_star1_idx (star_id ASC),
  ADD INDEX fk_role_film1_idx (film_id ASC),
  ADD CONSTRAINT fk_role_film1
    FOREIGN KEY (film_id)
    REFERENCES film_db.film (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  ADD CONSTRAINT fk_role_star1
    FOREIGN KEY (star_id)
    REFERENCES film_db.star (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE film_db.film_director 
  ADD INDEX fk_film_director_director1_idx (director_id ASC),
  ADD INDEX fk_film_director_film1_idx (film_id ASC),
  ADD CONSTRAINT fk_film_director_film1
    FOREIGN KEY (film_id)
    REFERENCES film_db.film (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  ADD CONSTRAINT fk_film_director_director1
    FOREIGN KEY (director_id)
    REFERENCES film_db.director (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE film_db.box_office
  ADD INDEX fk_box_office_country1_idx (country_id ASC),
  ADD INDEX fk_box_office_film1_idx (film_id ASC),
  ADD CONSTRAINT fk_box_office_film1
    FOREIGN KEY (film_id)
    REFERENCES film_db.film (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  ADD CONSTRAINT fk_box_office_country1
    FOREIGN KEY (country_id)
    REFERENCES film_db.country (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

#----Insertion of data
INSERT INTO film_db.film (title, running_time, release_date)
VALUES ('Joker', 122, '2019-10-03'), 
     ('Abominable', 97, '2019-10-03'), 
       ('Downton Abbey', 122, '2019-11-21'),
       ('Hustlers', 110, '2019-09-12'),
       ('It Chapter Two', 169, '2019-09-05'),
       ('Judy', 118, '2019-10-17'),
       ('Ad Astra', 123, '2019-09-26'),
       ('Rambo: Last Blood', 89, '2019-09-19'),
       ('War', 154, '2019-10-02'),
       ('Good Boys', 90, '2019-08-16');

INSERT INTO film_db.country (name)
VALUES ('Australia'),
       ('Japan'),
       ('Serbia'),
       ('Egypt'),
       ('Mexico'),
       ('USA'),
       ('Ukraine'),
       ('Belgium'),
       ('Portugal'),
       ('Italy');
INSERT INTO film_db.star (first_name, last_name, age)
VALUES ('Joaquin', 'Phoenix', 44),
       ('Chloe', 'Bennet', 27),
       ('Tuppence', 'Middleton', 32),
       ('Lili', 'Reinhart', 21),
       ('Jessica', 'Chastain', 42),
       ('Renée', 'Zellweger', 50),
       ('Brad', 'Pitt', 56),
       ('Sylvester', 'Stallone', 73),
       ('Hrithik', 'Roshan', 45),
       ('Jacob', 'Tremblay', 13);

INSERT INTO film_db.genre (name)
VALUES ('Crime'),
       ('Drama'),
       ('Thriller'),
       ('Animation'),
       ('Adventure'),
       ('Comedy'),
       ('Horror'),
       ('Fantasy'),
       ('Biography'),
       ('History');

INSERT INTO film_db.film_genre (film_id, genre_id)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (2, 4),
       (2, 5),
       (2, 6),
       (3, 2),
       (4, 6),
       (4, 1),
       (4, 2);

INSERT INTO film_db.`role` (film_id, star_id, `role`)
VALUES (1, 1, 'Arthur Fleck'),
       (2, 2, 'Yi'),
       (3, 3, 'Lucy Smith'),
       (4, 4, 'Annabelle'),
       (5, 5, 'Beverly Marsh'),
       (6, 6, 'Judy Garland'),
       (7, 7, 'Roy McBride'),
       (8, 8, 'Rambo'),
       (9, 9, 'Kabir'),
       (10, 10, 'Max');

INSERT INTO film_db.director (first_name, last_name)
VALUES ('Todd', 'Phillips'),
       ('Jill', 'Culton'),
       ('Michael', 'Engler'),
       ('Lorene', 'Scafaria'),
       ('Andy', 'Muschietti'),
       ('Rupert', 'Goold'),
       ('James', 'Gray'),
       ('Adrian', 'Grunberg'),
       ('Siddharth', 'Anand'),
       ('Gene', 'Stupnitsky');

INSERT INTO film_db.film_director (film_id, director_id)
VALUES (1,1),
       (2,2),
       (3,3),
       (4,4),
       (5,5),
       (6,6),
       (7,7),
       (8,8),
       (9,9),
       (10,10);

INSERT INTO film_db.box_office (film_id, country_id, box_office)
VALUES (1, 7, 1345608),
       (1, 10, 6876614),
       (1, 9, 945070),
       (1, 1, 6599583),
       (2, 5, 2051730),
       (2, 7, 520693),
       (2, 1, 4223073),
       (3, 1, 7653967),
       (3, 4, 12264),
       (3, 3, 18050);