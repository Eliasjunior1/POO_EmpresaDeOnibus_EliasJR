create DATABASE ViacaoBatista; 

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
  placa varchar(10),
  motorista varchar(40) ,
  cobrador varchar(40) ,
  fiscal varchar(15),
  PRIMARY KEY (placa)
) ;

CREATE TABLE rota (
  id_rota int,
  origem varchar(40) ,
  destino varchar(40) ,
  onibus varchar(15),
  PRIMARY KEY (id_rota)
) ; 

INSERT INTO gerente(id_gerente,nome,cpf,idade,telefone,salario,cargo,senha) VALUES('RTX-1234','Roberta','123.456.789-10','28','22 98765-4321','6.045', 'Gerente','123roberta');