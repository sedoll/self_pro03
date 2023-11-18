create database teaspoon;

USE teaspoon;

CREATE table sample(NO INTEGER AUTO_INCREMENT PRIMARY KEY,
NAME VARCHAR(100));
 
 
INSERT INTO sample VALUES (DEFAULT, '김기태');
INSERT INTO sample VALUES (DEFAULT, '한선');
INSERT INTO sample VALUES (DEFAULT, '이은영');
INSERT INTO sample VALUES (DEFAULT, '서광');
INSERT INTO sample VALUES (DEFAULT, '이소윤');

COMMIT;
