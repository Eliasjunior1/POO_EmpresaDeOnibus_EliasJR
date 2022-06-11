create DATABASE ViacaoBatista;

USE ViacaoBatista; 

CREATE TABLE gerente (
  id_gerente varchar(10),
  nome varchar(40) ,
  cpf varchar(40) ,
  idade int,
  telefone varchar(15),
  salario float,
  cargo varchar(10),
  senha varchar(15),
  PRIMARY KEY (id_gerente)
) ;


CREATE TABLE cobrador (
  id_cobrador varchar(10),
  nome varchar(40) ,
  cpf varchar(40) ,
  idade int,
  telefone varchar(15),
  salario float,
  cargo varchar(10),
  PRIMARY KEY (id_cobrador)
) ;

CREATE TABLE fiscal (
  id_fiscal varchar(10),
  nome varchar(40) ,
  cpf varchar(40) ,
  idade int,
  telefone varchar(15),
  salario float,
  cargo varchar(10),
  PRIMARY KEY (id_fiscal)
) ;

CREATE TABLE motorista (
  id_motorista varchar(10),
  nome varchar(40) ,
  cpf varchar(40) ,
  idade int,
  telefone varchar(15),
  salario float,
  cargo varchar(10),
  cnh varchar(15),
  PRIMARY KEY (id_motorista)
) ;

CREATE TABLE onibus (
  placa varchar(10) NOT NULL,
  motorista varchar(40),
  cobrador varchar(40),
  fiscal varchar(15),
  FOREIGN KEY (motorista) REFERENCES motorista(id_motorista) ON DELETE SET NULL,
  FOREIGN KEY (cobrador) REFERENCES cobrador(id_cobrador) ON DELETE SET NULL,
  FOREIGN KEY (fiscal) REFERENCES fiscal(id_fiscal)ON DELETE SET NULL,
  PRIMARY KEY (placa)
) ;

CREATE TABLE rota (
  id_rota int ,
  origem varchar(40) ,
  destino varchar(40) ,
  onibus varchar(15),
  FOREIGN KEY (onibus) REFERENCES onibus(placa)ON DELETE SET NULL,
  PRIMARY KEY (id_rota)
) ; 

CREATE INDEX indice_id_gerente on gerente(id_gerente);
CREATE INDEX indice_id_motorista on motorista(id_motorista);
CREATE INDEX indice_id_cobrador on cobrador(id_cobrador);
CREATE INDEX indice_id_fiscal on fiscal(id_fiscal);
CREATE INDEX indice_id_onibus on onibus(placa);
CREATE INDEX indice_id_rota on rota(id_rota);


INSERT INTO gerente(id_gerente,nome,cpf,idade,telefone,salario,cargo,senha) VALUES('RTX-1234','Elias','123.456.789-10','23','22 98765-4321','6.045', 'Gerente','123testando');
INSERT INTO motorista(id_motorista,nome,cpf,idade,telefone,salario,cargo,cnh) VALUES('DTR-6544','Jorge','143.678.455-56','23','22 98765-4321','4.045', 'Motorista','12349876432');
INSERT INTO cobrador(id_cobrador,nome,cpf,idade,telefone,salario,cargo) VALUES('DRA-6344','Maria','767.454.278-09','30','22 98765-4321','2.045', 'Cobrador');
INSERT INTO fiscal(id_fiscal,nome,cpf,idade,telefone,salario,cargo) VALUES('CNJ-3589','Caio','987.456.143-41','26','22 98765-4321','1.045', 'Fiscal');
INSERT INTO onibus(placa, motorista, cobrador, fiscal) VALUES ('ADS-4321','DTR-6544','DRA-6344','CNJ-3589');
INSERT INTO rota(id_rota,origem,destino,onibus) VALUES ('1','RJ','SP','ADS-4321');

UPDATE cobrador SET nome = 'Joao' where id_cobrador = 'DRA-6344';

CONSULTAS

SELECT * FROM gerente;
SELECT * FROM motorista;
SELECT * FROM cobrador;
SELECT * FROM fiscal;
SELECT * FROM onibus;
SELECT * FROM rota;


SELECT moto.nome, oni.placa FROM onibus oni RIGHT JOIN motorista moto on moto.id_motorista = oni.motorista;
SELECT cobra.nome, oni.placa FROM onibus oni RIGHT JOIN cobrador cobra on cobra.id_cobrador = oni.cobrador;
SELECT fis.nome, oni.placa FROM onibus oni RIGHT JOIN fiscal fis on fis.id_cobrador = oni.fiscal;
SELECT oni.placa, rota.origem, rota.destino FROM rota LEFT JOIN onibus oni ON oni.placa = rota.onibus;

SELECT oni.motorista, oni.cobrador, oni.fiscal FROM onibus oni where oni.placa ='ADS-4321'; 

--------------
Backup e recovery
create database bd_oficina;
use bd_oficina;

create table proprietario(
idProprietario int AUTO_INCREMENT,
nome varchar(50),
dtNasc date,
telefone varchar(15),
primary key(idProprietario)
);

create table veiculo(
idVeiculo int AUTO_INCREMENT,
modelo varchar(30),
ano int,
cor varchar(30),
idProprietario int,
FOREIGN KEY (idProprietario) REFERENCES proprietario(idProprietario) ON DELETE SET NULL ON UPDATE CASCADE,
primary key(idVeiculo)
);

2a -CREATE INDEX indice_idProprietario on veiculo(idProprietario);

2b - R: mysqldump -u root -p --databases bd_oficina > bd_oficina.sql
3 R: mysqldump -u root -p --databases --no-create-info bd_oficina > bd_oficina.sql 
4 R: mysqldump -u root -p --databases --no-data bd_oficina > bd_oficina.sql
5 R: source Oficina.bkp 
----------------------
Segurança e Integridade

create user 'MariadaSilva' identified by "";
grant insert,update,create on *.* to 'MariadaSilva' with grant option; 
create user 'JoaodeSouza' identified by "";

grant all on bd_oficina.veiculo to 'JoaodeSouza';
grant insert(nome) on bd_oficina.proprietario to 'JoaodeSouza';
flush privilegios;

5 - insert into proprietario(nome,dtNasc,telefone) values('Rodolfo','1990-01-13','22998432145');
R: ERROR 1143 (42000): INSERT command denied to user 'JoaodeSouza'@'localhost' for column 'dtNasc' in table 'proprietario'

6 - grant all on *.* to 'JoaodeSouza';
R: ERROR 1045 (28000): Access denied for user 'MariadaSilva'@'%' (using password: NO)

7 - Não, João só consegue fazer tudo na tabela veiculo do banco de dados bd_oficina e inserir na coluna nome da tabela proprietario do banco de dados proprietario.

8 - update user set password=password('321') where user='JoaodeSouza';

9 - show grants for 'JoaodeSouza';
show grants for 'MariadaSilva'; 

30 23 * * * mysqldump -u GerenteElias -p 123456 --databases ViacaoBatista > ViacaoBatista.bkp

                              Procedures Functions e triggers
Delimiter //
DROP FUNCTION IF EXISTS folha_salarial//
CREATE FUNCTION folha_salarial() RETURNS float
DETERMINISTIC 
BEGIN
    DECLARE s1 float;
    DECLARE s2 float;
    DECLARE s3 float;
    DECLARE s4 float;
    DECLARE total float;

    SELECT SUM(salario) INTO s1 FROM gerente;
    SELECT SUM(salario) INTO s2 FROM motorista;
    SELECT SUM(salario) INTO s3 FROM cobrador;
    SELECT SUM(salario) INTO s4 FROM fiscal;

    SET total = s1 + s2 + s3 + s4;
    return(total);
END;//

Delimiter //
DROP FUNCTION IF EXISTS qtde_funcionarios//
CREATE FUNCTION qtde_funcionarios() RETURNS int
DETERMINISTIC 
BEGIN
    DECLARE s1 int;
    DECLARE s2 int;
    DECLARE s3 int;
    DECLARE s4 int;
    DECLARE total int;

    SELECT count(id) INTO s1 FROM gerente;
    SELECT count(id) INTO s2 FROM motorista;
    SELECT count(id) INTO s3 FROM cobrador;
    SELECT count(id) INTO s4 FROM fiscal;

    SET total = s1 + s2 + s3 + s4;
    return(total);
END;//

Delimiter //
DROP FUNCTION IF EXISTS qtde_funcionarios//
CREATE FUNCTION qtde_funcionarios() RETURNS int
DETERMINISTIC 
BEGIN
    DECLARE s1 int;
    DECLARE s2 int;
    DECLARE s3 int;
    DECLARE s4 int;
    DECLARE total int;

  
    
    SELECT count(nome) INTO s1 FROM gerente;
    SELECT count(nome) INTO s2 FROM motorista;
    SELECT count(nome) INTO s3 FROM cobrador;
    SELECT count(nome) INTO s4 FROM fiscal;

    SET total = s1 + s2 + s3 + s4;
    return(total);
END;//