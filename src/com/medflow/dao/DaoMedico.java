/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medflow.dao;

import com.medflow.model.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author CaioLuiz
 */
public class DaoMedico {

    private Connection conn;

    public DaoMedico(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Medico medico) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO tbMedico(cpf, nome, endereco, telefone, crm, especialidade) VALUES(?,?,?,?,?,?)");
            ps.setString(1, medico.getCpf().replace(".", "").replace("-", ""));
            ps.setString(2, medico.getNome());
            ps.setString(3, medico.getEndereco());
            ps.setString(4, medico.getTelefone());
            ps.setString(5, medico.getCrm());
            ps.setString(6, medico.getEspecialidade());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void alterar(Medico medico) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tbMedico set nome = ?,endereco = ?,telefone = ?,crm = ?, especialidade = ? where cpf = ?");

            ps.setString(1, medico.getNome());
            ps.setString(2, medico.getEndereco());
            ps.setString(3, medico.getTelefone());
            ps.setString(4, medico.getCrm());
            ps.setString(5, medico.getEspecialidade());
            ps.setString(6, medico.getCpf().replace(".", "").replace("-", ""));
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public Medico consultar(String cpf) {
        Medico m = null;

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from tbMedico where "
                    + "cpf = ?");

            ps.setString(1, cpf.replace(".", "").replace("-", ""));
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                m = new Medico(cpf, rs.getString("nome"), rs.getString("crm"), rs.getString("especialidade"));
                m.setEndereco(rs.getString("endereco"));
                m.setTelefone(rs.getString("telefone"));

            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (m);
    }

    public void excluir(Medico medico) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tbMedico where cpf = ?");

            ps.setString(1, medico.getCpf().replace(".", "").replace("-", ""));

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

}
