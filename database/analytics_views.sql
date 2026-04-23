
-- =============================================
-- MedFlow - Views Analíticas
-- Banco: Oracle SQL
-- =============================================

-- 1) Total de consultas por médico
CREATE OR REPLACE VIEW vw_consultas_por_medico AS
SELECT
    m.cpf AS cpf_medico,
    m.nome AS nome_medico,
    m.especialidade,
    COUNT(c.codigo) AS total_consultas
FROM tbMedico m
LEFT JOIN tbConsulta c
       ON c.cpf_medico = m.cpf
GROUP BY m.cpf, m.nome, m.especialidade;

-- 2) Faturamento por médico com base nas consultas
CREATE OR REPLACE VIEW vw_faturamento_por_medico AS
SELECT
    m.cpf AS cpf_medico,
    m.nome AS nome_medico,
    m.especialidade,
    NVL(SUM(c.valor), 0) AS faturamento_total
FROM tbMedico m
LEFT JOIN tbConsulta c
       ON c.cpf_medico = m.cpf
GROUP BY m.cpf, m.nome, m.especialidade;

-- 3) IMC dos pacientes
CREATE OR REPLACE VIEW vw_pacientes_imc AS
SELECT
    p.cpf AS cpf_paciente,
    p.nome AS nome_paciente,
    p.altura,
    p.peso,
    CASE
        WHEN p.altura IS NOT NULL AND p.altura > 0 AND p.peso IS NOT NULL
        THEN p.peso / POWER(p.altura, 2)
        ELSE NULL
    END AS imc
FROM tbPaciente p;

-- 4) Quantidade de exames por médico
CREATE OR REPLACE VIEW vw_exames_por_medico AS
SELECT
    m.cpf AS cpf_medico,
    m.nome AS nome_medico,
    m.especialidade,
    COUNT(e.codigo) AS total_exames
FROM tbMedico m
LEFT JOIN tbConsulta c
       ON c.cpf_medico = m.cpf
LEFT JOIN tbExame e
       ON e.codigo_consulta = c.codigo
GROUP BY m.cpf, m.nome, m.especialidade;

-- 5) Resumo consolidado das consultas
CREATE OR REPLACE VIEW vw_resumo_consulta AS
SELECT
    c.codigo AS codigo_consulta,
    c.dataConsulta,
    c.valor,
    p.cpf AS cpf_paciente,
    p.nome AS nome_paciente,
    m.cpf AS cpf_medico,
    m.nome AS nome_medico,
    m.especialidade
FROM tbConsulta c
JOIN tbPaciente p
  ON p.cpf = c.cpf_paciente
JOIN tbMedico m
  ON m.cpf = c.cpf_medico;

-- =============================================
-- Consultas de exemplo
-- =============================================

-- SELECT * FROM vw_consultas_por_medico ORDER BY total_consultas DESC;
-- SELECT * FROM vw_faturamento_por_medico ORDER BY faturamento_total DESC;
-- SELECT nome_paciente, ROUND(imc, 2) AS imc FROM vw_pacientes_imc ORDER BY imc DESC;
-- SELECT * FROM vw_exames_por_medico ORDER BY total_exames DESC;
-- SELECT * FROM vw_resumo_consulta ORDER BY dataConsulta DESC;
