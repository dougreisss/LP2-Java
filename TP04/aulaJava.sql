use aulajava
go

Create table tbCargos
(
	cd_cargos smallint,
	ds_cargos char(20),
	constraint pk_cargos primary key  (cd_cargos)
);

Create table tbFunc
(
	cod_func decimal(9),
	nome_func char(80),
	sal_func decimal,
	cod_cargos smallint,
	constraint pk_func primary key (cod_func),
	constraint fk_func foreign key (cod_cargos) references tbCargos (cd_cargos)
);

insert into tbCargos values (1, 'Desenvolvedor')
insert into tbCargos values (2, 'Recursos Humanos')
insert into tbCargos values (3, 'Segurança')

insert into tbFunc values (1 , 'Douglas Reis', 1500, 1)
insert into tbFunc values (2 , 'Lucas Aquino', 2500, 1)
insert into tbFunc values (3 , 'Henrique Reis', 2500, 2)
insert into tbFunc values (4 , 'Douglas Gomes', 1500, 3)

