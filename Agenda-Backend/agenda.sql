create table pessoa(
	pessoa_id serial primary key not null,
	pessoa_nome varchar (50) not null,
	pessoa_cpf_cnpj varchar (15) not null,
	pessoa_telefone varchar(15) not null,
	pessoa_email varchar (50) not null,
    pessoa_funcao varchar (50) not null,
	pessoa_login varchar (50) not null,
	pessoa_senha varchar (15) not null,
    pessoa_perfil varchar (50) not null
);

insert into pessoa(pessoa_nome,pessoa_cpf_cnpj,pessoa_telefone,pessoa_email,pessoa_funcao,pessoa_login,pessoa_senha,pessoa_perfil)
values ('Adriel Miranda','000.000.000-85','550621234-5678','adrielneer@gmail.com','Programador','adrielmiranda','miranda1234',
'https://github.com/adrielmiranda')

insert into pessoa(pessoa_nome,pessoa_cpf_cnpj,pessoa_telefone,pessoa_email,pessoa_funcao,pessoa_login,pessoa_senha,pessoa_perfil)
values ('Antonio','000.000.000-90','550621234-8765','antonioneer@gmail.com','Desenvolvedor','antoniomiranda','miranda123456',
'https://github.com/antonio')

select * from pessoa
drop table pessoa

