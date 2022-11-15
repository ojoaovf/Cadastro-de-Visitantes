drop database if exists bd_visitantes;
create database bd_visitantes;
use bd_visitantes;

create table Cadastro (
	id			int				primary key		auto_increment,
    nome		varchar(60)		not null,
    cpf			varchar(14)		unique 			not null,
    telefone	varchar(14)		not null,
    cidade		varchar(20)		not null,
	estado		varchar(30)		not null,
    email		varchar(60)		not null
);

-- select * from cadastro;
