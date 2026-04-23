/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medflow.dao;

import com.medflow.model.Consulta;
import com.medflow.model.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author CaioLuiz
 */
public class DaoConsulta {

    private Connection conn;

    public DaoConsulta(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Consulta consulta, String cpfPaciente) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO tbConsulta(codigo, dataconsulta, valor, cpf_paciente, cpf_medico) VALUES(?,?,?,?,?)");
            ps.setInt(1, consulta.getCodigo());
            ps.setString(2, consulta.getData());
            ps.setDouble(3, consulta.getValor());
            ps.setString(4, cpfPaciente.replace(".", "").replace("-", ""));
            ps.setString(5, consulta.getMedico().getCpf().replace(".", "").replace("-", ""));
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void alterar(Consulta consulta) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tbConsulta set dataconsulta = ?,valor = ? where codigo = ?");

            ps.setString(1, consulta.getData());
            ps.setDouble(2, consulta.getValor());
            ps.setInt(3, consulta.getCodigo());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public Consulta consultar(int codigo) {
        Consulta c = null;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM tbConsulta WHERE codigo = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                java.sql.Date dataDoBanco = rs.getDate("DATACONSULTA");
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
                String dataFormatada = sdf.format(dataDoBanco);

                c = new Consulta(rs.getInt("codigo"), dataFormatada);
                c.setValor(rs.getDouble("valor"));
                String cpfMedico = rs.getString("cpf_medico");
                DaoMedico daoMedico = new DaoMedico(conn);
                Medico medico = daoMedico.consultar(cpfMedico);
                c.setMedico(medico);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return c;
    }

    public void excluir(Consulta consulta) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tbConsulta where codigo = ?");

            ps.setInt(1, consulta.getCodigo());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public String NomeMedico(int codigo) {
        String nome = null;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT nome FROM tbMedico inner join tbConsulta on tbConsulta.cpf_medico = tbMedico.cpf where tbConsulta.codigo = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                nome = rs.getString("nome");
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return nome;
    }
}
