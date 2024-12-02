-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           8.0.40 - MySQL Community Server - GPL
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              12.8.0.6908
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para projetoif
CREATE DATABASE IF NOT EXISTS `projetoif` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `projetoif`;

-- Copiando estrutura para tabela projetoif.avaliacao
CREATE TABLE IF NOT EXISTS `avaliacao` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nota` int DEFAULT NULL,
  `pedido` int DEFAULT NULL,
  `restaurante` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pedido` (`pedido`),
  KEY `restaurante` (`restaurante`),
  CONSTRAINT `avaliacao_ibfk_1` FOREIGN KEY (`pedido`) REFERENCES `pedido` (`id`),
  CONSTRAINT `avaliacao_ibfk_2` FOREIGN KEY (`restaurante`) REFERENCES `restaurante` (`id`),
  CONSTRAINT `avaliacao_chk_1` CHECK (((`nota` >= 0) and (`nota` <= 10)))
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela projetoif.avaliacao: ~10 rows (aproximadamente)
INSERT INTO `avaliacao` (`id`, `nota`, `pedido`, `restaurante`) VALUES
	(1, 9, 51, 1),
	(2, 8, 52, 2),
	(3, 7, 53, 3),
	(4, 10, 54, 1),
	(5, 6, 55, 4),
	(6, 8, 56, 5),
	(7, 5, 57, 6),
	(8, 9, 58, 7),
	(9, 10, 59, 8),
	(10, 7, 60, 9);

-- Copiando estrutura para tabela projetoif.categoria
CREATE TABLE IF NOT EXISTS `categoria` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tipo` varchar(50) DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  `descricao` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela projetoif.categoria: ~10 rows (aproximadamente)
INSERT INTO `categoria` (`id`, `tipo`, `nome`, `descricao`) VALUES
	(1, 'Comida', 'Pizzaria', 'Especialidade em pizzas artesanais'),
	(2, 'Comida', 'Hamburgueria', 'Hambúrgueres gourmet e combos'),
	(3, 'Sobremesa', 'Sorveteria', 'Gelados de diversos sabores'),
	(4, 'Bebida', 'Sucos Naturais', 'Sucos saudáveis e naturais'),
	(5, 'Bebida', 'Refrigerantes', 'Todas as marcas populares disponíveis'),
	(6, 'Comida', 'Churrascaria', 'Carnes nobres e assadas no ponto'),
	(7, 'Sobremesa', 'Doceria', 'Doces finos e tortas especiais'),
	(8, 'Comida', 'Vegana', 'Refeições 100% vegetais e saudáveis'),
	(9, 'Bebida', 'Cafeteria', 'Cafés artesanais e bebidas quentes'),
	(10, 'Comida', 'Comida Oriental', 'Sushis, temakis e pratos asiáticos tradicionais');

-- Copiando estrutura para tabela projetoif.endereco
CREATE TABLE IF NOT EXISTS `endereco` (
  `id` int NOT NULL AUTO_INCREMENT,
  `rua` varchar(255) NOT NULL,
  `bairro` varchar(100) DEFAULT NULL,
  `cidade` varchar(100) DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL,
  `numero` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `complemento` varchar(100) DEFAULT NULL,
  `ponto_referencia` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela projetoif.endereco: ~29 rows (aproximadamente)
INSERT INTO `endereco` (`id`, `rua`, `bairro`, `cidade`, `estado`, `numero`, `complemento`, `ponto_referencia`) VALUES
	(1, 'Rua das Flores', 'Centro', 'São Paulo', 'SP', '100', 'Apto 12', 'Próximo ao mercado'),
	(2, 'Av. Paulista', 'Bela Vista', 'São Paulo', 'SP', '1500', 'Sala 302', 'Ao lado do banco'),
	(3, 'Rua Bahia', 'Funcionários', 'Belo Horizonte', 'MG', '250', 'Casa', 'Em frente à praça'),
	(4, 'Av. Boa Viagem', 'Boa Viagem', 'Recife', 'PE', '900', NULL, 'Próximo à praia'),
	(5, 'Rua Amazonas', 'Centro', 'Curitiba', 'PR', '80', NULL, 'Próximo ao shopping'),
	(6, 'Rua 25 de Março', 'Comércio', 'São Paulo', 'SP', '500', NULL, 'Próximo ao mercado municipal'),
	(7, 'Rua do Sol', 'Boa Vista', 'Fortaleza', 'CE', '300', NULL, 'Esquina com a padaria'),
	(8, 'Av. Getúlio Vargas', 'Centro', 'Porto Alegre', 'RS', '100', 'Loja 10', NULL),
	(9, 'Rua das Palmeiras', 'Jardins', 'Salvador', 'BA', '120', NULL, 'Próximo ao parque'),
	(10, 'Av. Brasil', 'Centro', 'Brasília', 'DF', '999', NULL, NULL),
	(11, '', '', 'Sertânia', 'PE', '87981553826', NULL, NULL),
	(12, '', '', 'Sertânia', 'PE', '87981553826', NULL, NULL),
	(13, '', '', 'Sertânia', 'PE', '981553826', NULL, NULL),
	(14, 'sasss', 'dsasdsa', 'sdaaaa', 'sss', '87981554832', NULL, NULL),
	(15, '', '', 'Sertânia', 'PE', '981553826', NULL, NULL),
	(16, '', '', 'Sertânia', 'PE', '8721368765', NULL, NULL),
	(17, '2', '2', '2', '2', '222222', NULL, NULL),
	(18, '', '', 'Sertânia', 'PE', '3', NULL, NULL),
	(19, '', '', 'Sertânia', 'PE', '87981553826', NULL, NULL),
	(20, 'Rua José Valério dos Santos', 'Rio da Barra', 'Sertânia', 'PE', '981553826', NULL, NULL),
	(21, 'Rua José Valério dos Santos', 'Rio da Barra', 'Sertânia', 'PE', '87981579587', NULL, NULL),
	(22, '', '', 'Sertânia', 'PE', '2342', NULL, NULL),
	(23, 'Rua José Valério dos Santos', 'Rio da Barra', 'Sertânia', 'PE', '107', NULL, NULL),
	(24, 'Rua José Valério dos Santos', 'Rio da Barra', 'Sertânia', 'PE', '107', NULL, NULL),
	(25, '', '', 'Sertânia', 'PE', '123', NULL, NULL),
	(26, '', '', 'Sertânia', 'PE', '1243', NULL, NULL),
	(27, '', '', 'Sertânia', 'PE', '345', NULL, NULL),
	(28, '', '', 'Sertânia', 'PE', '34', NULL, NULL),
	(29, 'Rua José Valério dos Santos', 'Rio da Barra', 'Sertânia', 'PE', '87981553826', NULL, NULL),
	(30, '', '', 'Sertânia', 'PE', '107', NULL, NULL),
	(31, '', '', 'Sertânia', 'PE', '107', NULL, NULL),
	(32, '', '', 'Sertânia', 'PE', '107', NULL, NULL),
	(33, '', '', 'Sertânia', 'PE', '651', NULL, NULL),
	(34, 'asd', 'asd', 'asd', 'asd', '123', NULL, NULL);

-- Copiando estrutura para tabela projetoif.forma_pagamento
CREATE TABLE IF NOT EXISTS `forma_pagamento` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tipo_de_pagamento` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela projetoif.forma_pagamento: ~3 rows (aproximadamente)
INSERT INTO `forma_pagamento` (`id`, `tipo_de_pagamento`) VALUES
	(1, 'Cartão de Crédito'),
	(2, 'Cartão de Débito'),
	(3, 'Pix');

-- Copiando estrutura para tabela projetoif.historico_entrega
CREATE TABLE IF NOT EXISTS `historico_entrega` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_status_ent` int NOT NULL,
  `id_pedido` int NOT NULL,
  `datetime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_status_ent` (`id_status_ent`),
  KEY `id_pedido` (`id_pedido`),
  CONSTRAINT `historico_entrega_ibfk_1` FOREIGN KEY (`id_status_ent`) REFERENCES `status_entrega` (`id`),
  CONSTRAINT `historico_entrega_ibfk_2` FOREIGN KEY (`id_pedido`) REFERENCES `pedido` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela projetoif.historico_entrega: ~10 rows (aproximadamente)
INSERT INTO `historico_entrega` (`id`, `id_status_ent`, `id_pedido`, `datetime`) VALUES
	(1, 1, 51, '2024-11-01 14:00:00'),
	(2, 2, 52, '2024-11-02 16:00:00'),
	(3, 3, 53, '2024-11-03 19:30:00'),
	(4, 2, 54, '2024-11-04 21:00:00'),
	(5, 1, 55, '2024-11-05 22:00:00'),
	(6, 3, 56, '2024-11-06 12:30:00'),
	(7, 2, 57, '2024-11-07 15:00:00'),
	(8, 1, 58, '2024-11-08 16:00:00'),
	(9, 3, 59, '2024-11-09 18:00:00'),
	(10, 2, 60, '2024-11-10 20:30:00');

-- Copiando estrutura para tabela projetoif.historico_pagamento
CREATE TABLE IF NOT EXISTS `historico_pagamento` (
  `id` int NOT NULL AUTO_INCREMENT,
  `data` datetime NOT NULL,
  `id_forma` int DEFAULT NULL,
  `valor` decimal(10,2) NOT NULL,
  `id_pedido` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_forma` (`id_forma`),
  CONSTRAINT `historico_pagamento_ibfk_1` FOREIGN KEY (`id_forma`) REFERENCES `forma_pagamento` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela projetoif.historico_pagamento: ~10 rows (aproximadamente)
INSERT INTO `historico_pagamento` (`id`, `data`, `id_forma`, `valor`, `id_pedido`) VALUES
	(1, '2024-11-01 12:45:00', 1, 94.80, 51),
	(2, '2024-11-02 14:00:00', 2, 34.40, 52),
	(3, '2024-11-03 18:30:00', 3, 28.80, 53),
	(4, '2024-11-04 19:30:00', 1, 64.90, 54),
	(5, '2024-11-05 20:30:00', 2, 22.40, 55),
	(6, '2024-11-06 12:00:00', 3, 93.70, 56),
	(7, '2024-11-07 14:15:00', 1, 54.40, 57),
	(8, '2024-11-08 15:45:00', 2, 38.40, 58),
	(9, '2024-11-09 17:50:00', 1, 126.00, 59),
	(10, '2024-11-10 19:15:00', 3, 82.90, 60);

-- Copiando estrutura para tabela projetoif.pedido
CREATE TABLE IF NOT EXISTS `pedido` (
  `id` int NOT NULL AUTO_INCREMENT,
  `data` datetime NOT NULL,
  `id_restaurante` int DEFAULT NULL,
  `valor` decimal(10,2) NOT NULL,
  `taxa_entrega` decimal(10,2) DEFAULT NULL,
  `id_promocao` int DEFAULT NULL,
  `id_status_entrega` int DEFAULT NULL,
  `id_forma_pagamento` int DEFAULT NULL,
  `observacao` text,
  `troco` decimal(10,2) DEFAULT NULL,
  `id_endereco` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_restaurante` (`id_restaurante`),
  KEY `id_promocao` (`id_promocao`),
  KEY `id_status_entrega` (`id_status_entrega`),
  KEY `id_forma_pagamento` (`id_forma_pagamento`),
  KEY `id_endereco` (`id_endereco`),
  CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`id_restaurante`) REFERENCES `restaurante` (`id`),
  CONSTRAINT `pedido_ibfk_2` FOREIGN KEY (`id_promocao`) REFERENCES `promocao` (`id`),
  CONSTRAINT `pedido_ibfk_3` FOREIGN KEY (`id_status_entrega`) REFERENCES `status_entrega` (`id`),
  CONSTRAINT `pedido_ibfk_4` FOREIGN KEY (`id_forma_pagamento`) REFERENCES `forma_pagamento` (`id`),
  CONSTRAINT `pedido_ibfk_5` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela projetoif.pedido: ~10 rows (aproximadamente)
INSERT INTO `pedido` (`id`, `data`, `id_restaurante`, `valor`, `taxa_entrega`, `id_promocao`, `id_status_entrega`, `id_forma_pagamento`, `observacao`, `troco`, `id_endereco`) VALUES
	(51, '2024-11-01 12:30:00', 1, 89.80, 5.00, 1, 1, 1, 'Sem cebola na pizza', 0.00, 1),
	(52, '2024-11-02 13:45:00', 2, 29.90, 4.50, 2, 2, 2, 'Entrega rápida, por favor', 10.00, 2),
	(53, '2024-11-03 18:00:00', 3, 25.80, 3.00, NULL, 3, 3, NULL, 0.00, 3),
	(54, '2024-11-04 19:15:00', 1, 59.90, 5.00, 4, 1, 1, 'Adicionar queijo extra', 0.00, 1),
	(55, '2024-11-05 20:00:00', 4, 18.90, 3.50, 5, 2, 2, 'Sem gelo no suco', 5.00, 4),
	(56, '2024-11-06 11:30:00', 5, 85.70, 8.00, NULL, 3, 1, 'Precisa de troco para 100', 14.30, 5),
	(57, '2024-11-07 14:00:00', 6, 50.40, 4.00, 3, 1, 1, 'Pedido para presente', 0.00, 6),
	(58, '2024-11-08 15:20:00', 7, 32.90, 5.50, NULL, 2, 2, 'Deixar na portaria', 0.00, 7),
	(59, '2024-11-09 17:45:00', 8, 120.00, 6.00, 6, 1, 1, 'Com pressa, entrega antes das 18h', 0.00, 8),
	(60, '2024-11-10 19:00:00', 9, 75.90, 7.00, 7, 3, 3, 'Pedido recorrente, mesmo endereço', 0.00, 9);

-- Copiando estrutura para tabela projetoif.pedido_produto
CREATE TABLE IF NOT EXISTS `pedido_produto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_pedido` int DEFAULT NULL,
  `id_produto` int DEFAULT NULL,
  `quantidade` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_pedido` (`id_pedido`),
  KEY `id_produto` (`id_produto`),
  CONSTRAINT `pedido_produto_ibfk_1` FOREIGN KEY (`id_pedido`) REFERENCES `pedido` (`id`),
  CONSTRAINT `pedido_produto_ibfk_2` FOREIGN KEY (`id_produto`) REFERENCES `produto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela projetoif.pedido_produto: ~11 rows (aproximadamente)
INSERT INTO `pedido_produto` (`id`, `id_pedido`, `id_produto`, `quantidade`) VALUES
	(1, 51, 1, 2),
	(2, 51, 2, 1),
	(3, 52, 3, 1),
	(4, 53, 4, 3),
	(5, 54, 5, 2),
	(6, 55, 6, 1),
	(7, 56, 7, 5),
	(8, 57, 8, 2),
	(9, 58, 9, 1),
	(10, 59, 10, 3),
	(11, 60, 1, 1);

-- Copiando estrutura para tabela projetoif.produto
CREATE TABLE IF NOT EXISTS `produto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `descricao` text,
  `preco` double NOT NULL DEFAULT (0),
  `categoria_id` int DEFAULT NULL,
  `restaurante_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `categoria_id` (`categoria_id`),
  KEY `restaurante_id` (`restaurante_id`),
  CONSTRAINT `produto_ibfk_1` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`),
  CONSTRAINT `produto_ibfk_2` FOREIGN KEY (`restaurante_id`) REFERENCES `restaurante` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela projetoif.produto: ~20 rows (aproximadamente)
INSERT INTO `produto` (`id`, `nome`, `descricao`, `preco`, `categoria_id`, `restaurante_id`) VALUES
	(1, 'Pizza Margherita', 'Queijo, tomate e manjericão', 39.900001525878906, 1, 1),
	(2, 'Pizza Calabresa', 'Calabresa, cebola e queijo', 42.900001525878906, 1, 10),
	(3, 'Hambúrguer Clássico', 'Carne, queijo, salada e molho especial', 29.899999618530273, 2, 2),
	(4, 'Combo Família', 'Pizza grande + refrigerante', 59.900001525878906, 1, 1),
	(5, 'Sorvete de Chocolate', 'Chocolate artesanal', 12.899999618530273, 3, 3),
	(6, 'Suco Detox', 'Suco natural com frutas verdes', 10.899999618530273, 4, 4),
	(7, 'Refrigerante 2L', 'Coca-Cola, Fanta ou Guaraná', 8.899999618530273, 5, 4),
	(8, 'Espetinho de Carne', 'Carne assada no espeto', 15.899999618530273, 6, 5),
	(9, 'Brownie', 'Doce de chocolate com castanhas', 8.5, 7, 6),
	(10, 'Café Expresso', 'Café puro e forte', 6.900000095367432, 9, 9),
	(11, 'Ramen', 'Uma sopa com caldo a base de osso de porco', 14, 10, 8),
	(12, 'Lasanha vegana', 'Lasanha deliçiosa vegana', 22, 8, 7),
	(13, 'Hambúrguer Gourmet', 'Carne dupla,queijo,salada, molho especial, alface e cebola', 38, 2, 2),
	(14, 'Açaí ', 'Sorvete de açaí recheios a escolha', 11, 3, 3),
	(15, 'Espetinho de Carne suína', 'Linguiças otimas no espeto', 20, 6, 5),
	(16, 'Bolo red velvet', 'Bolo avemelhado lindo e gostoso', 87, 7, 6),
	(17, 'Strogonoff de cogumelos', 'Prato cremoso, feito com cogumelos ', 22, 8, 7),
	(18, 'Sashimi', 'Iguaria de peixes e frutos do mar', 18, 10, 8),
	(19, 'Café Especial ', 'Café isento de impurezas ', 9, 9, 9),
	(20, 'Pizza itáliana', 'Mozzarella de leite de vaca, cabra ou búfala, manjericão e azeite', 34, 1, 10);

-- Copiando estrutura para tabela projetoif.promocao
CREATE TABLE IF NOT EXISTS `promocao` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `codigo` varchar(50) NOT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  `valor` decimal(10,2) NOT NULL,
  `validade` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela projetoif.promocao: ~15 rows (aproximadamente)
INSERT INTO `promocao` (`id`, `nome`, `codigo`, `tipo`, `valor`, `validade`) VALUES
	(1, 'Promoção Black Friday', 'BLACKFRI23', 'Desconto', 20.00, '2024-12-01'),
	(2, 'Frete Grátis', 'FRETEGRATIS', 'Frete', 0.00, '2024-11-30'),
	(3, 'Desconto Aniversário', 'ANIVERSARIO', 'Desconto', 15.00, '2025-01-01'),
	(4, 'Desconto Combo', 'COMBO10', 'Desconto', 10.00, '2024-12-31'),
	(5, 'Natal Premiado', 'NATALPREMIO', 'Desconto', 25.00, '2024-12-25'),
	(6, 'Promoção Primeira Compra', 'BEMVINDO', 'Desconto', 30.00, '2025-01-15'),
	(7, 'Desconto Relâmpago', 'RELAMPAGO', 'Desconto', 5.00, '2024-11-25'),
	(8, 'Cashback Especial', 'CASHBACK20', 'Cashback', 20.00, '2024-12-10'),
	(9, 'Promoção Amigos', 'AMIGOS10', 'Desconto', 10.00, '2025-01-31'),
	(10, 'Cupom Inverno', 'INVERNO15', 'Desconto', 15.00, '2025-02-01'),
	(11, 'Desconto por Avaliação', 'AVALIEE10', 'Desconto', 10.00, '2025-03-01'),
	(12, 'Especial do Dia', 'DIAESPECIAL', 'Desconto', 7.50, '2024-11-20'),
	(13, 'Desconto Leve 3 Pague 2', 'LEVE3PAG2', 'Desconto', 12.00, '2024-12-15'),
	(14, 'Promoção de Combo', 'COMBODIA', 'Desconto', 18.00, '2025-01-10'),
	(15, 'Oferta de Fim de Semana', 'FIMSEMANA20', 'Desconto', 20.00, '2025-02-15');

-- Copiando estrutura para tabela projetoif.restaurante
CREATE TABLE IF NOT EXISTS `restaurante` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `end_id` int DEFAULT NULL,
  `telefone` varchar(15) DEFAULT NULL,
  `cat_id` int DEFAULT NULL,
  `hora_funcio` time DEFAULT NULL,
  `is_retirada` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `end_id` (`end_id`),
  KEY `cat_id` (`cat_id`),
  CONSTRAINT `restaurante_ibfk_1` FOREIGN KEY (`end_id`) REFERENCES `endereco` (`id`),
  CONSTRAINT `restaurante_ibfk_2` FOREIGN KEY (`cat_id`) REFERENCES `categoria` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela projetoif.restaurante: ~10 rows (aproximadamente)
INSERT INTO `restaurante` (`id`, `nome`, `end_id`, `telefone`, `cat_id`, `hora_funcio`, `is_retirada`) VALUES
	(1, 'Pizzaria Italiana', 1, '11987654321', 1, '18:00:00', 1),
	(2, 'Hamburgueria Gourmet', 2, '31987654322', 2, '11:00:00', 1),
	(3, 'Sorvetes Gelados', 3, '81987654323', 3, '12:00:00', 1),
	(4, 'Sucos Tropicais', 4, '41987654324', 4, '10:00:00', 1),
	(5, 'Rei dos Churrascos', 5, '51987654325', 6, '12:00:00', 0),
	(6, 'Doçuras Finas', 6, '21987654326', 7, '09:00:00', 1),
	(7, 'Veg Life', 7, '31987654327', 8, '08:00:00', 1),
	(8, 'Sushibar Nippon', 8, '41987654328', 10, '17:00:00', 0),
	(9, 'Café Gourmet', 9, '51987654329', 9, '07:00:00', 1),
	(10, 'Fast Pizza', 10, '61987654330', 5, '18:30:00', 1);

-- Copiando estrutura para tabela projetoif.restaurante_pagamento
CREATE TABLE IF NOT EXISTS `restaurante_pagamento` (
  `id_restaurante` int NOT NULL,
  `id_pagamento` int NOT NULL,
  PRIMARY KEY (`id_restaurante`,`id_pagamento`),
  KEY `id_pagamento` (`id_pagamento`),
  CONSTRAINT `restaurante_pagamento_ibfk_1` FOREIGN KEY (`id_restaurante`) REFERENCES `restaurante` (`id`),
  CONSTRAINT `restaurante_pagamento_ibfk_2` FOREIGN KEY (`id_pagamento`) REFERENCES `forma_pagamento` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela projetoif.restaurante_pagamento: ~25 rows (aproximadamente)
INSERT INTO `restaurante_pagamento` (`id_restaurante`, `id_pagamento`) VALUES
	(1, 1),
	(2, 1),
	(3, 1),
	(4, 1),
	(5, 1),
	(6, 1),
	(7, 1),
	(8, 1),
	(9, 1),
	(10, 1),
	(1, 2),
	(2, 2),
	(3, 2),
	(4, 2),
	(6, 2),
	(7, 2),
	(8, 2),
	(10, 2),
	(1, 3),
	(2, 3),
	(3, 3),
	(4, 3),
	(5, 3),
	(8, 3),
	(9, 3);

-- Copiando estrutura para tabela projetoif.status_entrega
CREATE TABLE IF NOT EXISTS `status_entrega` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela projetoif.status_entrega: ~3 rows (aproximadamente)
INSERT INTO `status_entrega` (`id`, `nome`) VALUES
	(1, 'Aguardando retirada'),
	(2, 'Saiu para entrega'),
	(3, 'Entregue');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
