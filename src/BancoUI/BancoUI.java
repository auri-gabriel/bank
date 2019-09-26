package BancoUI;

import java.util.Scanner;

/**
 * A classe BancoUI possui como atributo um objeto da classe Banco e fornece a
 * interface com o usu�rio, ou seja, as opera��es de leitura (nextInt(),
 * nextLine()...) e escrita (println()) devem estar concinputs apenas nessa
 * classe.
 *
 * @author Aline
 */
public class BancoUI {

    private static Banco meuBanco = new Banco();
    int numero = 0;
    int numeroorig = 0;
    double valor = 0;

    /**
     * Apresenta o menu com as op��es de opera��es do banco.
     */
    public static void menu() {
        Scanner input = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\nBanco EC");
            System.out.println("1. Abrir Conta");
            System.out.println("2. Consultar Saldo");
            System.out.println("3. Sacar");
            System.out.println("4. Depositar");
            System.out.println("5. Tranferir");
            System.out.println("6. Listar Todas Contas");
            System.out.println("7. Encerrar Conta");
            System.out.println("0. Sair\n");

            System.out.println("Qual a opcao desejada:");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    abrir();
                    break;
                case 2:
                    consultarSaldo();
                    break;
                case 3:
                    sacar();
                    break;
                case 4:
                    depositar();
                    break;
                case 5:
                    transferir();
                    break;
                case 6:
                    listar();
                    break;
                case 7:
                    encerrar();
                    break;
                default:
                    System.out.println("Opcao Invalida");
            }
        } while (opcao != 0);
    }

    /**
     * Realiza a leitura dos dados necess�rios para realizar a abertura de conta
     * e informa ao usu�rio o resultado da opera��o.
     */
    public static void abrir() {
        int opcao;
        String nome;
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o seu nome:");
        nome = input.nextLine();
        Cliente novoCliente = new Cliente(nome);
        do {
            System.out.println("Escolha o tipo de conta:");
            System.out.println("1. Conta Corrente");
            System.out.println("2. Conta Poupança");
            opcao = input.nextInt();
            switch (opcao) {
                case 1:
                    ContaCorrente novaContaCorrente = new ContaCorrente(novoCliente);
                    meuBanco.abrirConta(novaContaCorrente);
                    System.out.println("Conta Corrente Criada com sucesso!");
                    break;
                case 2:
                    ContaPoupanca novaContaPoupanca = new ContaPoupanca(novoCliente);
                    meuBanco.abrirConta(novaContaPoupanca);
                    System.out.println("Conta Poupança Criada com sucesso!");
                    break;
                default:
                    System.out.println("Opcao Invalida");
                    menu();
            }
        } while (opcao != 0);

    }

    /**
     * Realiza a leitura dos dados necess�rios para realizar a consulta do saldo
     * de uma determinada conta e informa ao usu�rio o resultado da opera��o.
     */
    public static void consultarSaldo() {
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o numero da conta: ");
        int numero = input.nextInt();
        System.out.println("Informe a senha: ");
        String senha = input.next();
        System.out.println("Seu saldo é: " + meuBanco.consultarSaldo(numero, senha));
    }

    /**
     * Realiza a leitura dos dados necess�rios para realizar o saque de uma
     * determinada conta e informa ao usu�rio o resultado da opera��o.
     */
    public static void sacar() {
        try {
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o numero da conta: ");
        int numero = input.nextInt();
        System.out.print("Informe o valor: ");
        double valor = input.nextDouble();
        System.out.print("Informe a senha: ");
        String senha = input.next();
        meuBanco.sacar(numero, senha, valor);            
        } catch (IllegalArgumentException containexistente) {
            containexistente.getMessage();
        }

        
    }

    /**
     * Realiza a leitura dos dados necess�rios para realizar o dep�sito em uma
     * determinada conta e informa ao usu�rio o resultado da opera��o.
     */
    public static void depositar() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Informe o numero da conta: ");
            int numero = input.nextInt();
            System.out.println("Informe o valor: ");
            double valor = input.nextDouble();
            System.out.println("Informe a senha: ");
            String senha = input.next();
            meuBanco.depositar(numero, senha, valor);
        } catch (IllegalArgumentException containexistente) {
            containexistente.getMessage();
        }
    }
    

    /**
     * Realiza a leitura dos dados necess�rios para realizar a transfer�ncia
     * entre duas contas e informa ao usu�rio o resultado da opera��o.
     */
    public static void transferir() {
        boolean operacao;
        Scanner input = new Scanner(System.in);
        System.out.println("Informe a o numero da conta a receber o valor: ");
        int numero = input.nextInt();
        System.out.println("Informe a o valor: ");
        double valor = input.nextDouble();
        System.out.println("Informe o numero da conta origem: ");
        int numeroorig = input.nextInt();
        System.out.println("Informe a senha da origem: ");
        String senha = input.next();
        operacao = meuBanco.transferir(numeroorig, senha, numero, valor);
        if (operacao) {
            System.out.print("Operação realizada com sucesso!");
        } else {
            System.out.print("A operação falhou...");
        }
    }

    /**
     * Apresenta uma listagem com as informa��es de todas as ocntas.
     */
    public static void listar() {
        System.out.print(meuBanco.listarContas());
    }

    /**
     * Realiza a leitura dos dados necess�rios para realizar o encerramento de
     * uma determinada conta e informa ao usu�rio o resultado da opera��o.
     */
    public static void encerrar() {
        boolean operacao;
        Scanner input = new Scanner(System.in);
        int numero = input.nextInt();
        System.out.println("Informe a senha: ");
        String senha = input.next();
        operacao = meuBanco.encerrar(numero, senha);
        if (operacao) {
            System.out.print("Operação realizada com sucesso!");
        } else {
            System.out.print("A operação falhou...");
        }
    }
    
    public class SaldoInsuficienteException extends RuntimeException{
        SaldoInsuficienteException(String message){
            super(message);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BancoUI.menu();
    }
}
