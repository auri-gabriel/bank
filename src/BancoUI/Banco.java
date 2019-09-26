package BancoUI;

import java.util.ArrayList;

/**
 * A classe Banco é responsável por gerenciar um número indeterminado de contas
 * bancárias. O banco permite abrir e encerrar uma conta bancária; consultar o
 * saldo, depositar e sacar de uma determinada conta, além de listar todas as
 * contas.
 *
 * @author Aline
 */
public class Banco {

    private ArrayList<Conta> contas;

    public Banco() {
        contas = new ArrayList();
    }

    /**
     * Abrir uma nova conta no banco.
     *
     * @param novaConta
     */
    public void abrirConta(Conta novaConta) {
        contas.add(novaConta);
    }

    /**
     * Captura a conta com o número informado por parâmetro.
     *
     * @param numero Número da conta a ser capturada.
     * @return A conta capturada ou null caso o número informado não exista
     */
    private Conta getConta(int numero) {
        for (Conta c : contas) {
            if (numero == c.getNumero()) {
                return c;
            }
        }
        return null;
    }

    /**
     * Captura a conta com o número e senha informados por parâmetro.
     *
     * @param numero Número da conta a ser capturada.
     * @param senha Senha da conta a ser capturada.
     * @return A conta capturada ou null caso o número ou senha informados
     * estejam incorretos.
     */
    private Conta getConta(int numero, String senha) {
        for (Conta c : contas) {
            if (numero == c.getNumero() && c.isSenhaCorreta(senha)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Sacar o valor informado da conta com o número informado caso a senha
     * esteja correta.
     *
     * @param numero Número da conta a ser realizado o saque.
     * @param senha Senha da conta a ser realizado o saque.
     * @param valor Valor a ser sacado.
     * @return True caso o saque tenha sido realizado e False caso os dados
     * (número e/ou senha) da conta estejam incorretos ou não é permitido
     * realizar o saque do valor solicitado.
     */
    public void sacar(int numero, String senha, double valor) throws IllegalArgumentException {
        for (Conta c : contas) {
            if (numero == c.getNumero() && c.isSenhaCorreta(senha)) {
                c.saca(valor);
            } else {
                throw new IllegalArgumentException("Número de conta inexistente");
            }
        }

    }

    /**
     * Deposita o valor informado na conta com o número informado caso a senha
     * esteja correta.
     *
     * @param numero Número da conta a ser realizado o depósito.
     * @param senha Senha da conta a ser realizado o depósito.
     * @param valor Valor a ser depositado.
     * @return True caso o depósito tenha sido realizado e False caso os dados
     * (número e/ou senha) da conta estejam incorretos.
     */
    public void depositar(int numero, String senha, double valor) throws IllegalArgumentException {
        for (Conta c : contas) {
            if (numero == c.getNumero() && c.isSenhaCorreta(senha)) {
                c.deposita(valor);
            }
            else{
                throw new IllegalArgumentException("Número de conta inexistente");
            }
        }
    }

    /**
     * Consulta o saldo da conta cujo número foi informado por parâmetro e caso
     * a senha esteja correta.
     *
     * @param numero Número da conta.
     * @param senha Senha da conta.
     * @return Valor do saldo caso os dados (número e senha) informados estejam
     * corretos ou -1 caso contrário.
     */
    public double consultarSaldo(int numero, String senha) {
        for (Conta c : contas) {
            if (numero == c.getNumero() && c.isSenhaCorreta(senha)) {
                return c.getSaldo();
            }
        }
        return -1;
    }

    /**
     * Transfere um valor da conta origem para a conta destino caso as
     * informações das contas estejam corretas e a conta origem tenha saldo
     * suficente.
     *
     * @param numeroOrigem Número da conta de origem, onde o valor será sacado.
     * @param senhaOrigem Senha da conta de origem.
     * @param numeroDestino Número da conta de destino, onde o valor será
     * depositado.
     * @param valor Valor a ser transferido.
     * @return True caso a transferência tenha sido realizada ou False caso os
     * dados das contas estejam incorretos ou a conta origem não tenha saldo
     * suficiente.
     */
    public boolean transferir(int numeroOrigem, String senhaOrigem, int numeroDestino, double valor) {
        for (Conta c : contas) {
            if (numeroOrigem == c.getNumero() && c.isSenhaCorreta(senhaOrigem)) {
                for (Conta b : contas) {
                    if (numeroDestino == b.getNumero()) {
                        c.saca(valor);
                        b.deposita(valor);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Retorna uma String com os dados de todas as contas existentes.
     *
     * @return String com as informações das contas.
     */
    public String listarContas() {
        for (Conta c : contas) {
            c.toString();
        }
        return null;

    }

    /**
     * Encerra a conta com o número informado, removendo do conjunto, desde que
     * a senha informada esteja correta.
     *
     * @param numero Número da conta a ser encerrada.
     * @param senha Senha da conta a ser encerrada.
     * @return True caso a conta tenha sido encerrada e False cao contrário.
     */
    public boolean encerrar(int numero, String senha) {
        for (Conta c : contas) {
            if (numero == c.getNumero() && c.isSenhaCorreta(senha)) {
                contas.remove(c);
                return true;
            }
        }
        return false;
    }

    public void atualiza(double taxa) {
        for (Conta c : contas) {

        }

    }
}
