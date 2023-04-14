-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 14/04/2023 às 22:53
-- Versão do servidor: 10.4.28-MariaDB
-- Versão do PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `empresa_univector`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `2_pedidos/vendas`
--

CREATE TABLE `2_pedidos/vendas` (
  `id_servico` int(11) NOT NULL,
  `nome_servico` varchar(50) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `data_inicio` date DEFAULT NULL,
  `data_fim` date DEFAULT NULL,
  `total_valor` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `3_status_producao_pedido`
--

CREATE TABLE `3_status_producao_pedido` (
  `id_producao` int(11) NOT NULL,
  `id_servico` int(11) NOT NULL,
  `status_producao` enum('em_andamento','concluido','cancelado') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `4_itens_producao`
--

CREATE TABLE `4_itens_producao` (
  `id_item_producao` int(11) NOT NULL,
  `id_producao` int(11) NOT NULL,
  `quantidade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `clientes`
--

CREATE TABLE `clientes` (
  `id_clientes` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `endereco` varchar(200) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `cpf` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `estoque`
--

CREATE TABLE `estoque` (
  `id_material` int(11) NOT NULL,
  `nome_material` varchar(50) NOT NULL,
  `estoque_atual` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `2_pedidos/vendas`
--
ALTER TABLE `2_pedidos/vendas`
  ADD PRIMARY KEY (`id_servico`),
  ADD KEY `id_cliente` (`id_cliente`);

--
-- Índices de tabela `3_status_producao_pedido`
--
ALTER TABLE `3_status_producao_pedido`
  ADD PRIMARY KEY (`id_producao`),
  ADD KEY `id_servico` (`id_servico`);

--
-- Índices de tabela `4_itens_producao`
--
ALTER TABLE `4_itens_producao`
  ADD PRIMARY KEY (`id_item_producao`),
  ADD KEY `id_producao` (`id_producao`);

--
-- Índices de tabela `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id_clientes`);

--
-- Índices de tabela `estoque`
--
ALTER TABLE `estoque`
  ADD PRIMARY KEY (`id_material`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `2_pedidos/vendas`
--
ALTER TABLE `2_pedidos/vendas`
  MODIFY `id_servico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `3_status_producao_pedido`
--
ALTER TABLE `3_status_producao_pedido`
  MODIFY `id_producao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `4_itens_producao`
--
ALTER TABLE `4_itens_producao`
  MODIFY `id_item_producao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id_clientes` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=68;

--
-- AUTO_INCREMENT de tabela `estoque`
--
ALTER TABLE `estoque`
  MODIFY `id_material` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `2_pedidos/vendas`
--
ALTER TABLE `2_pedidos/vendas`
  ADD CONSTRAINT `2_pedidos/vendas_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_clientes`);

--
-- Restrições para tabelas `3_status_producao_pedido`
--
ALTER TABLE `3_status_producao_pedido`
  ADD CONSTRAINT `4_producao_pedido_ibfk_1` FOREIGN KEY (`id_servico`) REFERENCES `2_pedidos/vendas` (`id_servico`);

--
-- Restrições para tabelas `4_itens_producao`
--
ALTER TABLE `4_itens_producao`
  ADD CONSTRAINT `5_itens_producao_ibfk_1` FOREIGN KEY (`id_producao`) REFERENCES `3_status_producao_pedido` (`id_producao`),
  ADD CONSTRAINT `fk_4_itens_producao_5_estoque_materiais1` FOREIGN KEY (`id_producao`) REFERENCES `estoque` (`id_material`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
