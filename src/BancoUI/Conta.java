package BancoUI;

/**
 * Classe Conta modela uma conta banc�ria permitindo consultar saldo, limite,
 * n�mero da conta e titular, efetuar opera��es de saque e dep�sito, al�m de
 * modificar o limite e o titular. A classe Conta possui seguintes atributos: *
 * numero corresponde ao n�mero da conta e � gerado automaticamente pela classe
 * a fim de que seja um valor �nico; * titular corresponde ao nome do(a)
 * propriet�rio(a) da conta. * senha corresponde a um c�digo secreto composto
 * por letras ou que serve para autenticar o titular e dar poder de manipular a
 * conta. * saldo corresponde ao valor que o titular j� depositou na conta. *
 * limite corresponde ao valor que o titular pode sacar al�m de seu saldo.
 *
 * @author Aline
 */
public class Conta {

    private static int nConta = 1;

    private final int numero;
    private String senha;
    private Cliente cliente;
    protected double saldo;
    private double limite;

    /**
     * Construtor da Conta que recebe o titular por par�metro, inicializa saldo
     * e limite com zero e o n�mero da conta de forma a garantir que toda conta
     * possui um n�mero �nico.
     *
     * @param cliente Nome completo do titular da conta.
     */
    public Conta(Cliente cliente) {
        this.cliente = cliente;
        senha = "1234";
        numero = nConta++;
    }

    /**
     * Captura o titular da Conta.
     *
     * @return Titular.
     */
    public Cliente getCliente() {
        return cliente;

    }

    /**
     * Captura n�mero da conta.
     *
     * @return N�mero da conta.
     */
    public int getNumero() {
        return this.numero;

    }

    /**
     * Captura o saldo da conta.
     *
     * @return Saldo.
     */
    public double getSaldo() {
        return this.saldo;

    }

    /**
     * Captura o limite da conta.
     *
     * @return Limite.
     */
    public double getLimite() {
        return this.limite;

    }

    /**
     * Captura a senha da conta.
     *
     * @return Senha.
     */
    public String getSenha() {
        return this.senha;

    }

    /**
     * Verifica se a senha informada por par�metro � igual a senha da conta.
     *
     * @param senhaInformada Senha a ser verificada.
     * @return True caso a senha informada esteja correta e False caso
     * contr�rio.
     */
    public boolean isSenhaCorreta(String senhaInformada) {
        return senhaInformada.equals(this.senha);
    }

    /**
     * Modifica o titular da conta.
     *
     * @param novoCliente Novo cliente.
     */
    public void setCliente(Cliente novoCliente) {
        this.cliente = novoCliente;
    }

    /**
     * Modifica a senha caso a senha antiga esteja correta.
     *
     * @param senhaAntiga Senha antiga.
     * @param senhaNova Senha nova.
     * @return True se a senha for modificada e False caso contr�rio.
     */
    public boolean setSenha(String senhaAntiga, String senhaNova) {
        if (isSenhaCorreta(senhaAntiga)) {
            this.senha = senhaNova;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Modifica o limite da conta.
     *
     * @param l Novo limite.
     */
    public void setLimite(double l) {
        this.limite = l;

    }

    /**
     * Acrescenta o valor informado por par�metro ao saldo da conta.
     *
     * @param valor
     */
    public void deposita(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Valor negativo");
        } else {
            this.saldo += valor;
            System.out.println("Valor depositado!");
        }
    }

    /**
     * Subtrai o valor informado por par�metro do saldo da conta caso esse valor
     * seja inferior ou igual a soma do saldo e do limite.
     *
     * @param valor Valor a ser sacado.
     * @return True se o saque foi realizado com sucesso e False caso contr�rio.
     */
    public void saca(double valor) {
        if (valor < 0) {
            if (valor <= saldo + limite) {
                saldo -= valor;
            } else {
                throw new RuntimeException("Saldo insuficiente!");
            }
        } else {
            throw new IllegalArgumentException("Valor negativo!");
        }
    }

    /**
     * Retorna as informa��es da conta
     *
     * @return Uma String com as informa��es.
     */
    public String toString() {
        String dados = "Conta n°: " + numero
                + " Titular: " + cliente.getNome()
                + " Saldo: " + saldo
                + " Limite: " + limite + "\n";
        return dados;
    }

    public void atualiza(double taxa) {

    }
}
