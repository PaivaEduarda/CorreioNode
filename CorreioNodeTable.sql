CREATE DATABASE CorreioEntrega;
USE CorreioEntrega;

CREATE TABLE CorreioEntrega( 
idCorreio smallint auto_increment,
cpf varchar(11),
nomeRemetente varchar(30) not null,
nomeDestinatario varchar(30) not null,
cep varchar(8) not null,
complemento varchar(30),
nmrCasa int not null,
primary key(idCorreio)
);

Insert into CorreioEntrega (cpf, nomeRemetente, nomeDestinatario, cep, complemento, nmrCasa) 
Values("51796214884", "Eduarda Graziele", "Eloisa", "13058413", "apto c, bloco 23", 55);

SELECT * FROM CorreioEntrega;