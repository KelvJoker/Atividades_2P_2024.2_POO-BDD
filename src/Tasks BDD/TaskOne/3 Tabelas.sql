create table livros(
	id int auto_increment primary key,
	titulo text,
	autor text,
	editora text,
	ano_publicacao int,
	preco decimal(10, 2)
);
create table clientes(
	id int auto_increment primary key,
	nome text,
	email text,
	endereco text
);

create table pedidos(
	id  int auto_increment primary key ,
	id_cliente int,
	data_pedido date,
	total decimal(10, 2),
    foreign key (id_cliente) references clientes(id)
);