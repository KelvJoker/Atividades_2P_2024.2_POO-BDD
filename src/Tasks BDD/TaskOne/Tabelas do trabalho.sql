create table usuarios (
    id_usuario int auto_increment primary key,
    nome varchar(100),
    telefone varchar(20),
    email varchar(100),
    cpf varchar(11)
);

create table autores (
    id_autor int auto_increment primary key,
    nome varchar(100),
    data_nascimento date,
    nacionalidade varchar(50)
);

create table livros (
    id_livro int auto_increment primary key,
    titulo varchar(200),
    isbn varchar(13),
    ano_publicacao year,
    id_autor int,
    foreign key (id_autor) references autores(id_autor)
);

create table categorias (
    id_categoria int auto_increment primary key,
    nome varchar(50)
);

create table livros_categorias (
    id_livro int,
    id_categoria int,
    foreign key (id_livro) references livros(id_livro),
    foreign key (id_categoria) references categorias(id_categoria)
);

create table emprestimos (
    id_emprestimo int auto_increment primary key,
    id_usuario int,
    id_livro int,
    data_emprestimo date,
    data_devolucao date,
    foreign key (id_usuario) references usuarios(id_usuario),
    foreign key (id_livro) references livros(id_livro)
);