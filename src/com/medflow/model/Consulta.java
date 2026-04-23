/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medflow.model;

import java.util.ArrayList;

/**
 *
 * @author Caio
 */
public class Consulta {

    private int codigo;
    private String data;
    private double valor;
    private ArrayList<Exame> exame;
    private ArrayList<Medicacao> medicacao;
    private Medico medico;
    
    public Consulta(int codigo, String data) {
        this.codigo = codigo;
        this.data = data;
        exame = new ArrayList<>();
        medicacao = new ArrayList<>();
        
    }

    public void setData(String data) {
        this.data = data;
    }
    
    
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public String getData() {
        return data;
    }
    
    public double getValor() {
        return valor;
    }
    
    public Medico getMedico() {
        return medico;
    }
    
    public void setMedico(Medico medico) {
        this.medico = medico;
        medico.addConsulta(this);
    }
    
    public void adicionarExame(Exame e) {
        this.exame.add(e);
    }

    public void addMedicacao(Medicacao m) {
        this.medicacao.add(m);
    }

    public double calcValorTotalPagar() {
        double total = this.valor;
        for (int i = 0; i < exame.size(); i++) {
            total += exame.get(i).getValor();
        }
        return total;
    }
}
