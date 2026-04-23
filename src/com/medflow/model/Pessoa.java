/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medflow.model;

/**
 *
 * @author CaioLuiz
 */
public class Pessoa {

    private String cpf;
    private String nome;
    private String endereco;
    private String telefone;

    public Pessoa(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public static boolean validarCpf(String cpf) {
        cpf = cpf.replace(".", "").replace("-", "");

        if (cpf.length() != 11) {
            return false;
        }

        for (int i = 0; i < 11; i++) {
            if (!Character.isDigit(cpf.charAt(i))) {
                return false;
            }
        }

        boolean todosIguais = true;
        for (int i = 1; i < 11; i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                todosIguais = false;
                break;
            }
        }
        if (todosIguais) {
            return false;
        }

        int soma = 0;
        for (int i = 0; i < 9; i++) {
            int digito = cpf.charAt(i) - '0';
            int peso = i + 1;
            soma += digito * peso;
        }

        int dig1 = soma % 11;
        if (dig1 == 10) {
            dig1 = 0;
        }

        if (dig1 != (cpf.charAt(9) - '0')) {
            return false;
        }

        soma = 0;
        for (int i = 0; i < 10; i++) {
            int digito = cpf.charAt(i) - '0';
            int peso = 11 - i;
            soma += digito * peso;
        }

        int dig2 = (soma * 10) % 11;
        if (dig2 == 10) {
            dig2 = 0;
        }

        return dig2 == (cpf.charAt(10) - '0');

    }
}
