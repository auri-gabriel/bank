package BancoUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1901560111
 */
public class Cliente {

    private String Nome;
    private double CPF;

    /**
     *
     * @param nome
     */
    public Cliente(String nome) {
        this.Nome = nome;
    }

    /**
     *
     * @param nome
     * @param CPF
     */
    public Cliente(String nome, double CPF) {
        this.Nome = nome;
        this.CPF = CPF;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return Nome;
    }

    /**
     *
     * @return
     */
    public double getCPF() {
        return CPF;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.Nome = nome;
    }

    /**
     *
     * @param CPF
     */
    public void setCPF(double CPF) {
        this.CPF = CPF;
    }

    public String toString() {
        return "Titular = " + Nome + " CPF = " + CPF;
    }
}
