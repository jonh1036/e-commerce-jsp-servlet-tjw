-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 18, 2021 at 01:39 AM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lojinha`
--

-- --------------------------------------------------------

--
-- Table structure for table `produto`
--

CREATE TABLE `produto` (
  `idProduto` int(11) NOT NULL,
  `nome` varchar(150) DEFAULT NULL,
  `valor` double DEFAULT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  `urlImg` varchar(150) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `produto`
--

INSERT INTO `produto` (`idProduto`, `nome`, `valor`, `descricao`, `urlImg`) VALUES
(6, 'Celular Motorola Moto e6s', 899, 'Cor: Cinza, Capacidade: 32GB', 'resources/images/celular.jpg'),
(7, 'Caneta Azul, azul caneta', 2, 'Cor: Azul', 'resources/images/caneta.jpg'),
(9, 'Impressora HP', 499, 'Cor: Branca, Multifuncional', 'resources/images/impressora.jpg'),
(11, 'Gabinete', 524, 'Gabinete gamer', 'resources/images/computador.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE `usuario` (
  `login` varchar(100) NOT NULL,
  `senha` varchar(80) DEFAULT NULL,
  `nome` varchar(150) DEFAULT NULL,
  `cpf` varchar(45) DEFAULT NULL,
  `telefone` varchar(50) DEFAULT NULL,
  `endereco` varchar(150) DEFAULT NULL,
  `flagAdmin` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`login`, `senha`, `nome`, `cpf`, `telefone`, `endereco`, `flagAdmin`) VALUES
('jonathan', '123', 'Jonathan Silva', '07470085319', '(85) 9853-12872', 'Rua Cento e Vinte e Cinco, 20', 1),
('lucas', '123', 'Lucas', '07470085319', '(85) 9853-12871', 'Rua 12, 210', 0);

-- --------------------------------------------------------

--
-- Table structure for table `vendas`
--

CREATE TABLE `vendas` (
  `idVenda` int(11) NOT NULL,
  `data` varchar(45) DEFAULT NULL,
  `nomeComprador` varchar(150) NOT NULL,
  `cartaoComprador` varchar(20) NOT NULL,
  `codSegurancaComprador` varchar(5) NOT NULL,
  `valor` double NOT NULL,
  `idProdutoFk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `vendas`
--

INSERT INTO `vendas` (`idVenda`, `data`, `nomeComprador`, `cartaoComprador`, `codSegurancaComprador`, `valor`, `idProdutoFk`) VALUES
(8, 'Wed Feb 17 21:03:37 BRT 2021', 'Lucas', '4129847291479247', '412', 899, 6);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`idProduto`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`login`);

--
-- Indexes for table `vendas`
--
ALTER TABLE `vendas`
  ADD PRIMARY KEY (`idVenda`),
  ADD KEY `fk_Vendas_Produto_idx` (`idProdutoFk`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
  MODIFY `idProduto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `vendas`
--
ALTER TABLE `vendas`
  MODIFY `idVenda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `vendas`
--
ALTER TABLE `vendas`
  ADD CONSTRAINT `fk_Vendas_Produto` FOREIGN KEY (`idProdutoFk`) REFERENCES `produto` (`idProduto`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
