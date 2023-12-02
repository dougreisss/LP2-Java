use aulajava

go

create table AlunoAcademia
(
	Id int  NOT NULL identity(1, 1),
    Nome varchar(255),
    Idade int,
    Peso float,
    Altura float,
    Objetivo text,
    constraint fk_alunoAcademia primary key (Id)
)