CREATE USER 'v0luntario'@'localhost' IDENTIFIED BY 'qwerty';
GRANT ALL PRIVILEGES ON *.* TO 'v0luntario'@'localhost' WITH GRANT OPTION;
CREATE USER 'v0luntario'@'%' IDENTIFIED BY 'qwerty';
GRANT ALL PRIVILEGES ON *.* TO 'v0luntario'@'%' WITH GRANT OPTION;