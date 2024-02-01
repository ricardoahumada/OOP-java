CREATE SCHEMA `schooldbsol` ;

USE mysql;

CREATE USER 'schoolusersol'@'%' IDENTIFIED BY 'school123sol';

GRANT ALL PRIVILEGES ON schooldbsol.* TO 'schoolusersol'@'%';
FLUSH PRIVILEGES;