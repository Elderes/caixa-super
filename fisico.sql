CREATE TABLE Caixa
(
 id INT PRIMARY KEY,
 quantia_armazenada INT,
 idGerente INT,
);

CREATE TABLE Produto
(
 id INT PRIMARY KEY,
 nome INT,
 tipo INT,
 quantidade INT,
 preco_unitario INT,
);

CREATE TABLE Gerente
(
 login INT,
 senha INT,
 id INT PRIMARY KEY,
);

CREATE TABLE Venda
(
 id INT PRIMARY KEY,
 valor_total INT,
 data_venda INT,
 produtos INT,
 idCaixa INT,
 idGerente INT,
);

CREATE TABLE Rel
(
 id INT PRIMARY KEY,
 id INT PRIMARY KEY,
);

ALTER TABLE Caixa ADD FOREIGN KEY(idGerente) REFERENCES Gerente (idGerente)
ALTER TABLE Venda ADD FOREIGN KEY(idCaixa) REFERENCES Caixa (idCaixa)
ALTER TABLE Venda ADD FOREIGN KEY(idGerente) REFERENCES Gerente (idGerente)
ALTER TABLE Rel ADD FOREIGN KEY(id) REFERENCES Produto (id)
ALTER TABLE Rel ADD FOREIGN KEY(id) REFERENCES Gerente (id)
