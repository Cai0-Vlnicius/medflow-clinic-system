/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medflow.model;

/**
 *
 * @author Caio
 */
public class Exame {

    private int codigo;
    private String descricao;
    private String data;
    private String horario;
    private double valor;
    private Consulta consulta;
    
    public Exame(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
    public void setData(String data) {
        this.data = data;
    }
    
    public void setHorario(String horario) {
        this.horario = horario;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public String getData() {
        return data;
    }
    
    public String getHorario() {
        return horario;
    }
    
    public double getValor() {
        return valor;
    }
    
    public Consulta getConsulta() {
        return consulta;
    }
    
    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
        consulta.adicionarExame(this);
    }
    
}
