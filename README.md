# MedFlow - Clinical Management & Data Analysis System

Aplicação desktop em Java Swing para gerenciamento de uma clínica, com integração a banco de dados Oracle via JDBC e suporte a análise de dados utilizando SQL e views.

O sistema permite o cadastro e gerenciamento de médicos, pacientes, consultas, exames e medicações, além da extração de indicadores operacionais a partir dos dados armazenados.

---

## Visão geral

Este projeto foi estruturado para uso em portfólio, combinando conceitos de desenvolvimento Java com manipulação e análise de dados em banco relacional.

---

## Funcionalidades principais

- Cadastro de médicos  
- Cadastro de pacientes  
- Agendamento de consultas  
- Agendamento de exames vinculados a consultas  
- Prescrição de medicações  
- Operações de consulta, inserção, alteração e exclusão (CRUD)  
- Validação básica de CPF  
- Integração com banco Oracle via JDBC  
- Execução de consultas analíticas com SQL  
- Uso de views para geração de indicadores  

---

## Estrutura do projeto


medflow-clinic-management-system/
├── database/
│   ├── database.sql
│   └── analytics_views.sql
│
├── src/
│   └── com/
│       └── medflow/
│           ├── database/
│           │   └── Conexao.java
│           ├── dao/
│           │   ├── DaoConsulta.java
│           │   ├── DaoExame.java
│           │   ├── DaoMedicacao.java
│           │   ├── DaoMedico.java
│           │   └── DaoPaciente.java
│           ├── model/
│           │   ├── Consulta.java
│           │   ├── Exame.java
│           │   ├── Medicacao.java
│           │   ├── Medico.java
│           │   ├── Paciente.java
│           │   └── Pessoa.java
│           └── view/
│               ├── GuiCadastroMedico.java
│               ├── GuiCadastroPaciente.java
│               ├── GuiMarcarConsulta.java
│               ├── GuiMarcarExame.java
│               ├── GuiMenu.java
│               ├── GuiPrescreverMedicacao.java
│               └── icon/

Tecnologias utilizadas
Java
Java Swing
JDBC
SQL
Oracle Database
Git / GitHub
Modelagem de dados
Entidades principais
Paciente
Médico
Consulta
Exame
Medicação
Relacionamentos
--Um paciente pode possuir várias consultas
--Um médico pode realizar várias consultas
--Uma consulta pode possuir vários exames
--Uma consulta pode possuir várias medicações
Análise de Dados

O projeto inclui consultas analíticas e views SQL para geração de indicadores:

Total de consultas por médico
Faturamento por médico
Média de valores de consultas
Análise de IMC de pacientes
Quantidade de exames por médico

===Exemplo de view
CREATE VIEW vw_faturamento_por_medico AS
SELECT m.nome, SUM(c.valor) AS faturamento
FROM tbMedico m
JOIN tbConsulta c ON m.cpf = c.cpf_medico
GROUP BY m.nome;

As views estão disponíveis no arquivo:

database/analytics_views.sql
Configuração do banco

No código, a conexão é configurada da seguinte forma:

conexao = new Conexao("SEU_USUARIO", "SUA_SENHA");
conexao.setDriver("oracle.jdbc.driver.OracleDriver");
conexao.setConnectionString("jdbc:oracle:thin:@localhost:1521/XEPDB1");

Altere os dados conforme seu ambiente.

Como executar
Criar o banco com o script:
database/database.sql
Criar as views analíticas:
database/analytics_views.sql
Importar o projeto na IDE (NetBeans recomendado)
Adicionar o driver JDBC do Oracle
Configurar usuário, senha e conexão
Executar a aplicação:
com.medflow.view.GuiMenu
Diferenciais do projeto
Integração entre aplicação Java e banco relacional
Uso de padrão DAO para acesso a dados
Aplicação de consultas analíticas em SQL
Uso de views para abstração e reutilização de consultas
Estrutura organizada para manutenção
Licença

Projeto com finalidade educacional e de portfólio.
