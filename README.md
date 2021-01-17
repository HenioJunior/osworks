# osworks
Query de criação da tebela cliente

create table cliente (
id bigint not null auto_increment,
nome varchar(60) not null,
email varchar(255) not null,
telefone varchar(20) not null,

primary key (id)
);



Query de criação da tabela ordem_servico

create table ordem_servico (
id bigint not null auto_increment,
cliente_id bigint not null,
descricao text not null,
preco decimal(10,2) not null,
status varchar(20) not null,
data_abertura datetime not null,
data_finalizacao datetime,

primary key (id)
);

alter table ordem_servico add constraint fk_ordem_servico_cliente
foreign key (cliente_id) references cliente (id);


Query de criação da tabela comentario

create table comentario (
id bigint not null auto_increment,
ordem_servico_id bigint not null,
descricao text not null,
data_envio datetime not null,

primary key (id)
);

alter table comentario add constraint fk_comentario_ordem_servico
foreign key (ordem_servico_id) references ordem_servico (id);