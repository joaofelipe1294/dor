create table if not exists usuario (
	usuario_id serial ,
	email varchar (255) unique not null , 
   	senha varchar (255) not null ,
   	constraint pk_usuario primary key (usuario_id)
);

create table if not exists empresa (
	empresa_id serial ,
	razao_social varchar (255) unique  not null ,
	cnpj varchar (255) unique not null ,
	constraint pk_empresa primary key (empresa_id)
);

create table if not exists cliente (
	cliente_id serial ,
	nome varchar (255) not null ,
	cpf varchar (255) unique  default null , 
	cnpj varchar (255) unique  default null ,
	ativo boolean default true ,
	constraint  pk_cliente primary key (cliente_id)
);

create table if not exists registro (
        registro_id serial ,
        ativo boolean default true ,
        empresa_id integer default null ,
        cliente_id integer not null ,
        data_entrada date default CURRENT_DATE ,
        data_saida date default null,
        constraint pk_registro primary key (registro_id) ,
        constraint fk_registro_cliente foreign key (cliente_id) references cliente (cliente_id) ,
        constraint fk_registro_emrpesa foreign key (empresa_id) references empresa (empresa_id) 
); 
