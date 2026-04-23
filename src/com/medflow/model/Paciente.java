/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medflow.model;

import java.text.Format;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author Caio
 */
public class Paciente extends Pessoa {
    private LocalDate dataNascimento;
    private double altura;
    private double peso;
    private ArrayList <Consulta> consulta;
    
    public Paciente(String cpf, String nome, LocalDate dataNascimento) {
        super(cpf, nome);
        this.dataNascimento = dataNascimento;
        consulta = new ArrayList<>();
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    public String getDataNascimento() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataNascimento.format(formato);
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }
    
    public void addConsulta(Consulta c){
        this.consulta.add(c);
    }
    
    public double calcImc(){
        return peso/Math.pow(altura,2);
    }

    public int calcIdade(LocalDate data) {

        Period periodo = Period.between(this.dataNascimento, data);
        return periodo.getYears();
    }
    
}
