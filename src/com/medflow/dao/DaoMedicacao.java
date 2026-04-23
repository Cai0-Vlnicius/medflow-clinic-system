/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medflow.dao;

import com.medflow.model.Medicacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author CaioLuiz
 */
public class DaoMedicacao {

    private Connection conn;

    public DaoMedicacao(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Medicacao medicacao, int codigoConsulta) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO tbMedicacao(nome, codigo_consulta, dosagem, quantidadeDias) VALUES(?,?,?,?)");
            ps.setString(1, medicacao.getNome());
            ps.setInt(2, codigoConsulta);
            ps.setString(3, medicacao.getDosagem());
            ps.setInt(4, medicacao.getQtdeDias());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void alterar(Medicacao medicacao) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tbMedicacao set dosagem = ?, quantidadeDias = ? where nome = ?");

            ps.setString(1, medicacao.getDosagem());
            ps.setInt(2, medicacao.getQtdeDias());
            ps.setString(3, medicacao.getNome());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public Medicacao consultar(String nome) {
        Medicacao m = null;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM tbMedicacao WHERE nome = ?");
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                m = new Medicacao(rs.getString("nome"));
                m.setDosagem(rs.getString("dosagem"));
                m.setQtdeDias(rs.getInt("quantidadeDias"));

            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return m;
    }

    public void excluir(Medicacao medicacao) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tbMedicacao where nome = ?");

            ps.setString(1, medicacao.getNome());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public int CodigoConsulta(String nomeMedicacao) {
        int codigo = -1;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT codigo_consulta FROM tbMedicacao WHERE nome = ?");
            ps.setString(1, nomeMedicacao);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                codigo = rs.getInt("codigo_consulta");
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return codigo;
    }
}
