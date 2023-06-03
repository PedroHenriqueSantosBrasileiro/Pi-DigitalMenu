#NOVO
DROP database IF EXISTS digitalmenu;
create database digitalmenu;
use digitalmenu;

CREATE TABLE USUARIO (
    IDUSUARIO INT AUTO_INCREMENT PRIMARY KEY,
    USUARIO VARCHAR(30) NOT NULL UNIQUE,
    SENHA VARCHAR(30) NOT NULL,
    TIPOACESSO enum('administrador','atendente') NOT NULL,
    STATUS enum('ATIVADO','DESATIVADO') NOT NULL DEFAULT 'ATIVADO'
);

CREATE TABLE MESA (
    IDMESA INT PRIMARY KEY,
    STATUS enum('ATIVADO','DESATIVADO') NOT NULL DEFAULT 'ATIVADO'
);

CREATE TABLE PEDIDO (
    IDPEDIDO INT AUTO_INCREMENT PRIMARY KEY,
    TOTAL DECIMAL(7,2) NOT NULL DEFAULT 0.0,
    DATA DATETIME NOT NULL DEFAULT NOW(),
    STATUS ENUM('ABERTO','CANCELADO','ENCERRADO') NOT NULL DEFAULT 'ABERTO',
    ID_MESA INT NOT NULL
);

CREATE TABLE PRODUTO (
    IDPRODUTO INT AUTO_INCREMENT PRIMARY KEY,
    NOME VARCHAR(30) NOT NULL UNIQUE,
    DESCRICAO VARCHAR(200),
    PRECO DECIMAL(7,2) NOT NULL,
    STATUS enum('ATIVADO','DESATIVADO') NOT NULL DEFAULT 'ATIVADO',
    ID_CATEGORIA INT NOT NULL
);

CREATE TABLE ITEM (
    IDITEM INT AUTO_INCREMENT PRIMARY KEY,
    ID_PEDIDO INT NOT NULL,
    ID_PRODUTO INT NOT NULL,
    QTDE INT UNSIGNED NOT NULL,
    SUBTOTAL DECIMAL(7,2) NOT NULL DEFAULT 0.0,
    OBSERVACAO VARCHAR(30),
    STATUS ENUM('CANCELADO','CONFIRMADO') NOT NULL DEFAULT 'CONFIRMADO',
    HORAPEDIDO TIME NOT NULL DEFAULT (CURTIME())
);

CREATE TABLE CATEGORIA (
    IDCATEGORIA INT AUTO_INCREMENT PRIMARY KEY,
    NOME varchar(30) NOT NULL UNIQUE,
    STATUS enum('ATIVADO','DESATIVADO') NOT NULL DEFAULT 'ATIVADO'
);

ALTER TABLE PEDIDO ADD CONSTRAINT FK_PEDIDO_MESA
    FOREIGN KEY (ID_MESA)
    REFERENCES MESA (IDMESA)
    ON DELETE CASCADE ON UPDATE CASCADE;
 
ALTER TABLE PRODUTO ADD CONSTRAINT FK_PRODUTO_CATEGORIA
    FOREIGN KEY (ID_CATEGORIA)
    REFERENCES CATEGORIA (IDCATEGORIA)
    ON DELETE CASCADE ON UPDATE CASCADE;
 
ALTER TABLE ITEM ADD CONSTRAINT FK_PEDIDO
    FOREIGN KEY (ID_PEDIDO)
    REFERENCES PEDIDO (IDPEDIDO);
 
ALTER TABLE ITEM ADD CONSTRAINT FK_PRODUTO
    FOREIGN KEY (ID_PRODUTO)
    REFERENCES PRODUTO (IDPRODUTO);
    
INSERT INTO MESA VALUES 
(1, default),
(2, default),
(3, default),
(4, default),
(5, default)
;   
   
INSERT INTO CATEGORIA VALUES
(null, 'Entradas', default),
(null, 'Proteínas', default),
(null, 'Hambúrguer', default),
(null, 'Bebidas', default),
(null, 'Sobremesa', default)
;

INSERT INTO PRODUTO VALUES
(null, 'Tortillas', 'Tortillas acompanhadas de molho chipotle e creme de espinafre com alcachofra.', 45.0, default, 1),
(null, 'Bone-in Wings', 'Coxinha da asa crocantes acompanhado de molho ranch.', 55.0, default, 1),
(null, 'Mozzarella Sticks', 'Bastões de mozzarella empanados, crocantes por fora.', 40.0, default, 1),
(null, 'Pretzels', 'Pretzels acompanhado de molho cheddar com cerveja e mostarda Dijon.', 35.0, default, 1),
(null, 'Boneless Wings', 'Asinhas de frango desosada acompanhado de molho de queijo gorgonzola.', 49.0, default, 1),
(null, 'Shrimp Parmesan', 'Contra-filé servido com camarão ao molho de parmesão.', 110.0, default, 2),
(null, 'Top Sirloin', 'Bife de alcatra de 200g acompanhado de brócolis e purê de batata.', 84.00, default, 2),
(null, 'Street Steak', 'Bife de alcatra temperado com pimentas Cajun.', 82.00, default, 2),
(null, 'Chicken Tender', 'Isca de frango crocante, acompanhado de fritas e mostarda Dijon.', 65.0, default, 2),
(null, 'Chicken Shrimp', 'Peito de frango grelhado acompanhado de camarão e purê de batata.', 79.0, default, 2),
(null, 'Swiss Burger', 'Hambúrguer com cogumelos e queijo suiço, acompanhado de fritas.', 58.0, default, 3),
(null, 'Double Burger', 'Dois hambúrgueres, queijo e maionese de alho.', 65.0, default, 3),
(null, 'Bacon Burger', 'Hambúrger, bacon, onion rings e fritas.', 60.0, default, 3),
(null, 'Classic Bacon', 'Hambúrguer, queijo, bacon e fritas.', 45.0, default, 3),
(null, 'Classic Burger', 'Cheese salada acompanhado de fritas.', 47.0, default, 3),
(null, 'Suco de laranja', 'Copo 450ml.', 12.0, default, 4),
(null, 'Suco de maracujá', 'Copo 450ml.', 12.0, default, 4),
(null, 'Coca-Cola', 'Lata 450ml.', 8.50, default, 4),
(null, 'Guaraná', 'Lata 450ml.', 8.50, default, 4),
(null, 'Fanta Uva', 'Lata 450ml.', 8.50, default, 4),
(null, 'Brownie Bite', 'Brownie acompanhado de sorvete de baunilha.', 37.50, default, 5),
(null, 'Chocolate Meltdown', 'Bolo de chocolate rechado e coberto com fudge de chocolate meio amargo.', 32.50, default, 5),
(null, 'Bolo de Chocolate', 'Fatia de bolo', 19.50, default, 5),
(null, 'Mousse de maracujá', 'Fatia de mousse.', 19.50, default, 5),
(null, 'Bolo com caramelo', 'Fatia de bolo.', 19.50, default, 5)
;

INSERT INTO usuario VALUES
(null, 'admin','admin','administrador',default),
(null, 'atendente','atendente','atendente',default);