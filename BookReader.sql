CREATE DATABASE sistema_livros;
USE sistema_livros;

CREATE TABLE UserAdm (
    id int AUTO_INCREMENT PRIMARY KEY,
    UserAdm VARCHAR (50),
    senha VARCHAR (50),
);

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    data_nascimento date not null,
    sexo INT,
    tipo_preferido VARCHAR(20),
);

CREATE TABLE livros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    autor VARCHAR(50) NOT NULL,
    genero VARCHAR(20),
    avaliacao DECIMAL(3.1),
    
);

CREATE TABLE avaliacao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nota DECIMAL(3.1) NOT NULL,
    livro_id INT NOT NULL,
    usuario_id INT NOT NULL,
);
