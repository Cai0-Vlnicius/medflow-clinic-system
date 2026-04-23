/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medflow.model;

import java.util.ArrayList;

/**
 *
 * @author CaioLuiz
 */
public class Medico extends Pessoa {
    private String crm;
    private String especialidade;
    private ArrayList <Consulta> consulta;
    
    public Medico( String cpf, String nome,String crm, String especialidade) {
        super(cpf, nome);
        this.crm = crm;
        this.especialidade = especialidade;
        consulta = new ArrayList<>();
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    
    public String getCrm() {
        return crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }
    public void addConsulta(Consulta c){
        this.consulta.add(c);
    }
    
}
