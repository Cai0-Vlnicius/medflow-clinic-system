/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medflow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.medflow.model.Paciente;
import java.time.LocalDate;

/**
 *
 * @author CaioLuiz
 */
public class DaoPaciente {

    private Connection conn;

    public DaoPaciente(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Paciente paciente) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO tbPaciente(cpf, nome, endereco, telefone, datanascimento, altura, peso) VALUES(?,?,?,?,?,?,?)");
            ps.setString(1, paciente.getCpf().replace(".", "").replace("-", ""));
            ps.setString(2, paciente.getNome());
            ps.setString(3, paciente.getEndereco());
            ps.setString(4, paciente.getTelefone());
            ps.setString(5, paciente.getDataNascimento());
            ps.setDouble(6, paciente.getAltura());
            ps.setDouble(7, paciente.getPeso());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void alterar(Paciente paciente) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tbPaciente set nome = ?,endereco = ?,telefone = ?,datanascimento = ?, altura = ?,peso = ? where cpf = ?");

            ps.setString(1, paciente.getNome());
            ps.setString(2, paciente.getEndereco());
            ps.setString(3, paciente.getTelefone());
            ps.setString(4, paciente.getDataNascimento());
            ps.setDouble(5, paciente.getAltura());
            ps.setDouble(6, paciente.getPeso());
            ps.setString(7, paciente.getCpf().replace(".", "").replace("-", ""));
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public Paciente consultar(String cpf) {
        Paciente p = null;

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from tbPaciente where "
                    + "cpf = ?");

            ps.setString(1, cpf.replace(".", "").replace("-", ""));
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                java.sql.Date sqlDate = rs.getDate("datanascimento");
                LocalDate dataNasc = sqlDate.toLocalDate();

                p = new Paciente(cpf, rs.getString("nome"), dataNasc);
                p.setEndereco(rs.getString("endereco"));
                p.setTelefone(rs.getString("telefone"));
                p.setAltura(rs.getDouble("altura"));
                p.setPeso(rs.getDouble("peso"));

            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (p);
    }

    public void excluir(Paciente paciente) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tbPaciente where cpf = ?");

            ps.setString(1, paciente.getCpf().replace(".", "").replace("-", ""));

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public String NomePaciente(String cpf) {
        String nome = null;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT nome FROM tbPaciente WHERE cpf = ?");
            ps.setString(1, cpf.replace(".", "").replace("-", ""));
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                nome = rs.getString("nome");
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return nome;
    }

    public String CpfPaciente(int codigoConsulta) {
        String cpfPaciente = null;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT cpf_paciente FROM tbConsulta WHERE codigo = ?");
            ps.setInt(1, codigoConsulta);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cpfPaciente = rs.getString("cpf_paciente");
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return cpfPaciente;
    }

}
