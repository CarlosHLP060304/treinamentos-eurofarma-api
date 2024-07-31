CREATE TABLE tb_usuario (
  id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  cpf VARCHAR(14),
  nome VARCHAR(255),
  senha VARCHAR(255),
  ativo BOOLEAN DEFAULT TRUE,
  tipo ENUM('ANALISTA','ALUNO'),
  PRIMARY KEY (id)
);

CREATE TABLE tb_aula (
  id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  sala VARCHAR(255) ,
  duracao DOUBLE ,
  nome VARCHAR(255),
  link VARCHAR(255),
  ativo BOOLEAN  DEFAULT TRUE,
  id_treinamento BIGINT UNSIGNED ,
  PRIMARY KEY (id)
);


CREATE TABLE tb_aluno_aula (
  id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  id_aula BIGINT UNSIGNED,
  id_aluno BIGINT UNSIGNED,
  aula_concluida BOOLEAN DEFAULT FALSE,
  PRIMARY KEY (id)
);


CREATE TABLE tb_apostila (
  id BIGINT UNSIGNED AUTO_INCREMENT,
  id_treinamento BIGINT UNSIGNED,
  link VARCHAR(255),
  PRIMARY KEY (id)
);

CREATE TABLE tb_treinamento (
  id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255),
  descricao VARCHAR(255),
  formato ENUM('PRESENCIAL','ONLINE'),
  ativo BOOLEAN DEFAULT TRUE,
  data_inicio DATE,
  data_fim DATE,
  nome_professor VARCHAR(255),
  cpf_professor VARCHAR(14),
  PRIMARY KEY (id)
);


ALTER TABLE tb_aula ADD FOREIGN KEY (id_treinamento) REFERENCES tb_treinamento(id) ON DELETE CASCADE;
ALTER TABLE tb_aluno_aula ADD FOREIGN KEY (id_aula) REFERENCES tb_aula(id) ON DELETE CASCADE;
ALTER TABLE tb_aluno_aula ADD FOREIGN KEY (id_aluno) REFERENCES tb_usuario(id) ON DELETE CASCADE;
ALTER TABLE tb_apostila ADD FOREIGN KEY (id_treinamento) REFERENCES tb_treinamento(id) ON DELETE CASCADE;