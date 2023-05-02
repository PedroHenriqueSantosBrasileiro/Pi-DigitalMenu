create schema f;
use f;

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
    STATUS ENUM('ABERTO','ENCERRADO','CANCELADO') NOT NULL DEFAULT 'ABERTO',
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
    SUBTOTAL DECIMAL(7,2) NOT NULL DEFAULT 0.0,
    STATUS ENUM('CANCELADO','CONFIRMADO') NOT NULL DEFAULT 'CONFIRMADO',
    QTDE INT UNSIGNED NOT NULL,
    OBSERVACAO VARCHAR(30),
    HORAPEDIDO TIME NOT NULL DEFAULT (CURTIME()),
    ID_PEDIDO INT NOT NULL,
    ID_PRODUTO INT NOT NULL
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
(2, default)
;   

SELECT * FROM MESA;
/*
+--------+---------+
| IDMESA | STATUS  |
+--------+---------+
|      1 | ATIVADO |
|      2 | ATIVADO |
+--------+---------+
*/    
INSERT INTO CATEGORIA VALUES
(null, 'Pastel', default),
(null, 'Bebida', default)
;
/*
+-------------+--------+---------+
| IDCATEGORIA | NOME   | STATUS  |
+-------------+--------+---------+
|           1 | Pastel | ATIVADO |
|           2 | Bebida | ATIVADO |
+-------------+--------+---------+
*/
INSERT INTO PRODUTO VALUES
(null, 'Camarão', 'Camarão e catupiry', 15.0, default, 1),
(null, 'Calabresa queijo', 'Calabresa com mussarela', 10.0, default, 1),
(null, 'Frango Catupiry', 'Frango com catupiry', 10.0, default, 1),
(null, 'Carne', 'Carne moída', 10.0, default, 1),
(null, 'Especial', 'Carne moída, queijo, ovo, catupiry e tomate', 18.0, default, 1),
(null, 'Escarola', 'Mussarela e escarola', 10.0, default, 1),
(null, 'Vento', 'Massa crocante', 7.0, default, 1),
(null, 'Pizza', 'Mussarela, tomate e orégano', 10.0, default, 1),
(null, 'Calabresa', 'Calabresa mpída', 10.0, default, 1),
(null, '4 Queijos', 'Mussarela, parmesão, catupiry e gorgonzola', 12.0, default, 1),
(null, 'Coca-Cola', 'Lata 350ml', 7.0, default, 2),
(null, 'Guaraná', 'Lata 350ml', 7.0, default, 2),
(null, 'Fanta Laranja', 'Lata 350ml', 7.0, default, 2),
(null, 'Fanta Uva', 'Lata 350ml', 7.0, default, 2),
(null, 'Citrus', 'Lata 350ml', 7.0, default, 2),
(null, 'Tônica', 'Lata 350ml', 7.0, default, 2),
(null, 'Água', 'Garrafa 500ml', 5.0, default, 2),
(null, 'Água com gás', 'Garrafa 500ml', 6.0, default, 2),
(null, 'Chá Gelado Pêssego', 'Garrafa 500ml', 7.50, default, 2),
(null, 'Chá Gelado Limão', 'Garrafa 500ml', 7.50, default, 2)
;
/*
+-----------+--------------------+---------------------------------------------+-------+---------+--------------+
| IDPRODUTO | NOME               | DESCRICAO                                   | PRECO | STATUS  | ID_CATEGORIA |
+-----------+--------------------+---------------------------------------------+-------+---------+--------------+
|         1 | Camarão            | Camarão e catupiry                          | 15.00 | ATIVADO |            1 |
|         2 | Calabresa queijo   | Calabresa com mussarela                     | 10.00 | ATIVADO |            1 |
|         3 | Frango Catupiry    | Frango com catupiry                         | 10.00 | ATIVADO |            1 |
|         4 | Carne              | Carne moída                                 | 10.00 | ATIVADO |            1 |
|         5 | Especial           | Carne moída, queijo, ovo, catupiry e tomate | 18.00 | ATIVADO |            1 |
|         6 | Escarola           | Mussarela e escarola                        | 10.00 | ATIVADO |            1 |
|         7 | Vento              | Massa crocante                              |  7.00 | ATIVADO |            1 |
|         8 | Pizza              | Mussarela, tomate e orégano                 | 10.00 | ATIVADO |            1 |
|         9 | Calabresa          | Calabresa mpída                             | 10.00 | ATIVADO |            1 |
|        10 | 4 Queijos          | Mussarela, parmesão, catupiry e gorgonzola  | 12.00 | ATIVADO |            1 |
|        11 | Coca-Cola          | Lata 350ml                                  |  7.00 | ATIVADO |            2 |
|        12 | Guaraná            | Lata 350ml                                  |  7.00 | ATIVADO |            2 |
|        13 | Fanta Laranja      | Lata 350ml                                  |  7.00 | ATIVADO |            2 |
|        14 | Fanta Uva          | Lata 350ml                                  |  7.00 | ATIVADO |            2 |
|        15 | Citrus             | Lata 350ml                                  |  7.00 | ATIVADO |            2 |
|        16 | Tônica             | Lata 350ml                                  |  7.00 | ATIVADO |            2 |
|        17 | Água               | Garrafa 500ml                               |  5.00 | ATIVADO |            2 |
|        18 | Água com gás       | Garrafa 500ml                               |  6.00 | ATIVADO |            2 |
|        19 | Chá Gelado Pêssego | Garrafa 500ml                               |  7.50 | ATIVADO |            2 |
|        20 | Chá Gelado Limão   | Garrafa 500ml                               |  7.50 | ATIVADO |            2 |
+-----------+--------------------+---------------------------------------------+-------+---------+--------------+
*/

INSERT INTO usuario VALUES
(null, 'admin','admin','administrador',default),
(null, 'atendente','atendente','atendente',default);
/*
+-----------+-----------+-----------+---------------+---------+
| IDUSUARIO | USUARIO   | SENHA     | TIPOACESSO    | STATUS  |
+-----------+-----------+-----------+---------------+---------+
|         1 | admin     | admin     | administrador | ATIVADO |
|         2 | atendente | atendente | atendente     | ATIVADO |
+-----------+-----------+-----------+---------------+---------+
    */