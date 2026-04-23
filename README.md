========================================
        MEDFLOW – CLINICAL SYSTEM
   Management & Data Analysis Platform
========================================

Sistema desktop para gestão clínica desenvolvido em Java, com integração a banco de dados Oracle via JDBC e suporte à análise de dados utilizando SQL e views.

A aplicação permite o gerenciamento de médicos, pacientes, consultas, exames e medicações, além da geração de indicadores operacionais a partir dos dados armazenados.

----------------------------------------
FUNCIONALIDADES
----------------------------------------
- Cadastro de médicos
- Cadastro de pacientes
- Agendamento de consultas
- Agendamento de exames
- Prescrição de medicações
- Operações CRUD (inserir, consultar, alterar, excluir)
- Validação básica de CPF
- Integração com banco de dados Oracle
- Consultas analíticas com SQL
- Uso de views para geração de indicadores

----------------------------------------
ESTRUTURA DO PROJETO
----------------------------------------
medflow-clinic-management-system/
|
+-- database/
|   +-- database.sql
|   +-- analytics_views.sql
|
+-- src/
    +-- com/
        +-- medflow/
            +-- database/
            |   +-- Conexao.java
            |
            +-- dao/
            |   +-- DaoConsulta.java
            |   +-- DaoExame.java
            |   +-- DaoMedicacao.java
            |   +-- DaoMedico.java
            |   +-- DaoPaciente.java
            |
            +-- model/
            |   +-- Consulta.java
            |   +-- Exame.java
            |   +-- Medicacao.java
            |   +-- Medico.java
            |   +-- Paciente.java
            |   +-- Pessoa.java
            |
            +-- view/
                +-- GuiCadastroMedico.java
                +-- GuiCadastroPaciente.java
                +-- GuiMarcarConsulta.java
                +-- GuiMarcarExame.java
                +-- GuiMenu.java
                +-- GuiPrescreverMedicacao.java
                +-- icon/
----------------------------------------
TECNOLOGIAS UTILIZADAS
----------------------------------------
- Java
- Java Swing
- JDBC
- SQL
- Oracle Database
- Git / GitHub

----------------------------------------
MODELAGEM DE DADOS
----------------------------------------
Entidades principais:
- Paciente
- Médico
- Consulta
- Exame
- Medicação

Relacionamentos:
- Um paciente pode possuir várias consultas
- Um médico pode realizar várias consultas
- Uma consulta pode possuir vários exames
- Uma consulta pode possuir várias medicações

----------------------------------------
ANÁLISE DE DADOS
----------------------------------------
O sistema inclui consultas analíticas e views SQL para geração de indicadores:

- Total de consultas por médico
- Faturamento por médico
- Média de valores de consultas
- Análise de IMC de pacientes
- Quantidade de exames por médico

Exemplo de view:

CREATE VIEW vw_faturamento_por_medico AS
SELECT m.nome, SUM(c.valor) AS faturamento
FROM tbMedico m
JOIN tbConsulta c ON m.cpf = c.cpf_medico
GROUP BY m.nome;

As views estão disponíveis em:
database/analytics_views.sql

----------------------------------------
CONFIGURAÇÃO DO BANCO
----------------------------------------
No código, a conexão é configurada da seguinte forma:

conexao = new Conexao("SEU_USUARIO", "SUA_SENHA");
conexao.setDriver("oracle.jdbc.driver.OracleDriver");
conexao.setConnectionString("jdbc:oracle:thin:@localhost:1521/XEPDB1");

Altere os dados conforme seu ambiente.

----------------------------------------
COMO EXECUTAR
----------------------------------------
1. Executar o script: database/database.sql
2. Executar o script: database/analytics_views.sql
3. Importar o projeto na IDE (NetBeans recomendado)
4. Adicionar o driver JDBC do Oracle
5. Configurar usuário, senha e conexão
6. Executar a aplicação: com.medflow.view.GuiMenu

----------------------------------------
DIFERENCIAIS
----------------------------------------
- Integração entre aplicação Java e banco relacional
- Uso do padrão DAO
- Consultas analíticas em SQL
- Utilização de views para abstração de dados
- Estrutura organizada para manutenção

----------------------------------------
AUTOR
----------------------------------------
Caio Vinicius Macedo Fonseca

----------------------------------------
LICENÇA
----------------------------------------
Projeto com finalidade educacional e de portfólio.

========================================
