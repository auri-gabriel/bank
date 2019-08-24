/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BancoUI;

/**
 *
 * @author 1901560111
 */
public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    public void atualiza(double taxa) {
        saldo = saldo - (saldo * (taxa * 3));
    }

}
