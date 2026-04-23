/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medflow.dao;
import com.medflow.model.Consulta;
import com.medflow.model.Exame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author CaioLuiz
 */
public class DaoExame {
    private Connection conn;

    public DaoExame(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Exame exame) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO tbExame(codigo, codigo_consulta, descricao, dataExame, horario, valor) VALUES(?,?,?,?,?,?)");
            ps.setInt(1, exame.getCodigo());
            ps.setInt(2, exame.getConsulta().getCodigo());
            ps.setString(3, exame.getDescricao());
            ps.setString(4, exame.getData());
            ps.setString(5, exame.getHorario());
            ps.setDouble(6, exame.getValor());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void alterar(Exame exame) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tbExame set descricao = ?, dataExame = ?, horario = ?, valor = ? where codigo = ?");

            ps.setString(1, exame.getDescricao());
            ps.setString(2, exame.getData());
            ps.setString(3, exame.getHorario());
            ps.setDouble(4, exame.getValor());
            ps.setInt(5, exame.getCodigo());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public Exame consultar(int codigo) {
        Exame e = null;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM tbExame WHERE codigo = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                java.sql.Date dataDoBanco = rs.getDate("dataExame");
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
                String dataFormatada = sdf.format(dataDoBanco);

                e = new Exame(rs.getInt("codigo"), rs.getString("descricao"));
                
                e.setData(dataFormatada);
                e.setValor(rs.getDouble("valor"));
                e.setHorario(rs.getString("horario"));
                
                int codConsulta = rs.getInt("codigo_consulta");
                
                DaoConsulta daoConsulta = new DaoConsulta(conn);
                Consulta c = daoConsulta.consultar(codConsulta);
            
                e.setConsulta(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return e;
    }

    public void excluir(Exame exame) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tbExame where codigo = ?");

            ps.setInt(1, exame.getCodigo());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

}
