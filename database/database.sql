
-- MedFlow - Sistema de Gestão Clínica
-- Script de criação do banco de dados (Oracle)

CREATE TABLE tbPaciente(
    cpf             VARCHAR2(11) PRIMARY KEY,
    nome            VARCHAR2(100) NOT NULL,
    endereco        VARCHAR2(100),
    telefone        VARCHAR2(15),
    dataNascimento  DATE NOT NULL,
    altura          NUMBER(4,2),
    peso            NUMBER(5,2)
);

CREATE TABLE tbMedico(
    cpf             VARCHAR2(11) PRIMARY KEY,
    nome            VARCHAR2(100) NOT NULL,
    endereco        VARCHAR2(100),
    telefone        VARCHAR2(15),
    crm             VARCHAR2(10) NOT NULL UNIQUE,
    especialidade   VARCHAR2(30)
);

CREATE TABLE tbConsulta(
    codigo          NUMBER(9) PRIMARY KEY,
    dataConsulta    DATE NOT NULL,
    valor           NUMBER(10,2),
    cpf_paciente    VARCHAR2(11) NOT NULL,
    cpf_medico      VARCHAR2(11) NOT NULL,
    CONSTRAINT fk_consulta_paciente FOREIGN KEY (cpf_paciente) REFERENCES tbPaciente(cpf),
    CONSTRAINT fk_consulta_medico   FOREIGN KEY (cpf_medico)   REFERENCES tbMedico(cpf)
);

CREATE TABLE tbExame(
    codigo          NUMBER(9) PRIMARY KEY,
    codigo_consulta NUMBER(9) NOT NULL,
    descricao       VARCHAR2(500),
    dataExame       DATE NOT NULL,
    horario         VARCHAR2(5),
    valor           NUMBER(10,2),
    CONSTRAINT fk_exame_consulta FOREIGN KEY (codigo_consulta) REFERENCES tbConsulta(codigo)
);

-- Mantido com nome como identificador para preservar compatibilidade com a interface atual.
CREATE TABLE tbMedicacao(
    nome            VARCHAR2(100) PRIMARY KEY,
    codigo_consulta NUMBER(9) NOT NULL,
    dosagem         VARCHAR2(50),
    quantidadeDias  NUMBER(3),
    CONSTRAINT fk_medicacao_consulta FOREIGN KEY (codigo_consulta) REFERENCES tbConsulta(codigo)
);
