CREATE TABLE produto (
                         idproduto bigint AUTO_INCREMENT,
                         nome varchar(150) NOT NULL,
                         preco varchar(10) NOT NULL,
                         tipo varchar(30) NOT NULL,
                         descricao varchar(300) NOT NULL,
                         valor_energetico varchar(150) NOT NULL,
                         embalagem varchar(150) NOT NULL,
                         img varchar(200) NOT NULL,
                         PRIMARY KEY (idproduto)
);