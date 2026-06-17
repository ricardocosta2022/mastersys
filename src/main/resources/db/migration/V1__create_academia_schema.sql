CREATE TABLE alunos(

    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    data_nascimento DATE,
    sexo VARCHAR(1) CHECK (sexo IN ('M', 'F')),
    telefone VARCHAR(20),
    celular VARCHAR(20),
    email VARCHAR(255) UNIQUE,
    observacao TEXT,
    endereco VARCHAR(255),
    numero VARCHAR(20),
    complemento VARCHAR(255),
    bairro VARCHAR(255),
    cidade VARCHAR(255),
    estado VARCHAR(255),
    cep VARCHAR(20),
    criado_em TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    atualizado_em TIMESTAMP
);

CREATE TABLE modalidades(
    id  SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL UNIQUE,
    ativa BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE graduacoes(

    id SERIAL PRIMARY KEY,
    modalidade_id BIGINT NOT NULL REFERENCES modalidades(id),
    nome VARCHAR(255) NOT NULL,
    UNIQUE (modalidade_id, nome)
);

CREATE TABLE planos(

    id SERIAL PRIMARY KEY,
    modalidade_id BIGINT NOT NULL REFERENCES modalidades(id),
    nome VARCHAR(255) NOT NULL,
    valor_mensal NUMERIC(10, 2) NOT NULL CHECK(valor_mensal >= 0),
    ativo BOOLEAN NOT NULL DEFAULT TRUE,
    UNIQUE (modalidade_id, nome)
);

CREATE TABLE matriculas(

    id SERIAL PRIMARY KEY,
    aluno_id BIGINT NOT NULL REFERENCES alunos(id),
    data_matricula DATE NOT NULL DEFAULT CURRENT_DATE,
    dia_vencimento INT NOT NULL CHECK(dia_vencimento >= 1 AND dia_vencimento <= 31),
    data_encerramento DATE,
    status VARCHAR(20)  NOT NULL DEFAULT 'ATIVA',
    CHECK (status IN ( 'ATIVA' ,'CANCELADA', 'ENCERRADA'))

);

CREATE TABLE matriculas_modalidades(

    id SERIAL PRIMARY KEY,
    matricula_id BIGINT NOT NULL REFERENCES matriculas(id) ,
    modalidade_id BIGINT NOT NULL REFERENCES modalidades(id) ,
    graduacao_id BIGINT NOT NULL REFERENCES graduacoes(id) ,
    plano_id BIGINT NOT NULL REFERENCES planos(id) ,
    data_inicio DATE NOT NULL DEFAULT CURRENT_DATE,
    data_fim DATE,
    UNIQUE (matricula_id, modalidade_id)
);


CREATE TABLE faturas_matriculas(

    id SERIAL PRIMARY KEY,
    matricula_id BIGINT NOT NULL REFERENCES matriculas(id) ,
    data_vencimento DATE NOT NULL,
    valor NUMERIC(10, 2) NOT NULL CHECK(valor >= 0),
    data_pagamento TIMESTAMP,
    data_cancelamento DATE,
    status VARCHAR(20) NOT NULL DEFAULT 'ABERTA',
    CHECK (status IN ('ABERTA', 'PAGA', 'CANCELADA', 'VENCIDA')),
    UNIQUE (matricula_id, data_vencimento)
);

CREATE TABLE assiduidade(

    id SERIAL PRIMARY KEY,
    matricula_id BIGINT NOT NULL REFERENCES matriculas(id) ,
    data_entrada TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    data_saida TIMESTAMP
);








