CREATE DATABASE Registros;
USE Registros;


CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,           
    nombre VARCHAR(40) NOT NULL,                
    apellido VARCHAR(70) NOT NULL,              
    nombre_usuario VARCHAR(30) UNIQUE NOT NULL, 
    telefono VARCHAR(10),                       
    correo VARCHAR(120) UNIQUE NOT NULL,        
    contrasena VARCHAR(260) NOT NULL,           
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP 
);

commit;

select * from usuarios;