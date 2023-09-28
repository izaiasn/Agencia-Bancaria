package br.senai.sp.jandira.model;

import java.util.Scanner;

public class Menu {

    Cliente referenciacliente = new Cliente();
    Conta referenciaConta = new Conta();

    Scanner scanner = new Scanner(System.in);
    public void executarMenu(){

        boolean exit = false;

        while (!exit) {

            System.out.println("///// ----- Menu ------ /////");
            System.out.println("1 - Cadastrar Cliente        ");
            System.out.println("2 - Cadastrar Conta          ");
            System.out.println("3 - Consultar Saldo          ");
            System.out.println("4 - Realizar Deposito        ");
            System.out.println("5 - Realizar Saque           ");
            System.out.println("6 - Realizar Transferencia   ");
            System.out.println("7 - Sair                     ");
            System.out.println("/-/-/-/-/-/-/-/-/-/-/-/-/-/-/");

            int optionUser = scanner.nextInt();
            scanner.nextLine();

            switch (optionUser) {
                case 1:
                    Cliente cliente = new Cliente();
                    cliente.cadastrarCliente();
                    referenciacliente.adicionarCliente(cliente);
                    break;
                case 2:
                    System.out.print("Informe o cpf do titular: ");
                    long cpfTitular = scanner.nextLong();
                    scanner.nextLine();
                    Cliente clienteConta = referenciacliente.pesquisarCliente(cpfTitular);

                    if(clienteConta != null){
                        Conta conta = new Conta();
                        conta.gerarConta(clienteConta);
                        referenciaConta.adicionarConta(conta);
                        System.out.println("Conta Criada com Sucesso! ");
                    }else {
                        System.out.println("O cliente não tem cadastro...");
                    }

                    break;
                case 3:
                    System.out.print("Informe o CPF do titular");
                    long cpfSaldo = scanner.nextLong();
                    scanner.nextLine();

                    Conta contaSaldo = referenciaConta.pesquisarConta(cpfSaldo);

                    if (contaSaldo != null){
                        contaSaldo.consultarSaldo();
                    }else {
                        System.out.println("Ocliente não tem conta cadastrada...");
                    }

                    break;

                case 4:
                    System.out.print("Informe o CPF do deposito");
                    long cpfDeposito = scanner.nextLong();
                    scanner.nextLine();
                    Conta contaDeposito = referenciaConta.pesquisarConta(cpfDeposito);

                    if (contaDeposito != null){
                        System.out.print("Informe o valor do deposito");
                        double valorDeposito = scanner.nextDouble();
                        scanner.nextLine();
                        contaDeposito.realizarDeposito(valorDeposito);
                    }else {
                        System.out.println("O cliente não tem conta cadastrada...");
                    }
                    break;

                case 5:
                    System.out.print("Informe o CPF do saque");
                    long cpfSaque = scanner.nextLong();
                    scanner.nextLine();
                    Conta contaSaque = referenciaConta.pesquisarConta(cpfSaque);

                    if (contaSaque != null){
                        System.out.print("Informe o valor do saque");
                        double valorSaque = scanner.nextDouble();
                        scanner.nextLine();
                        contaSaque.realizarSaque(valorSaque);
                    }else {
                        System.out.println("O cliente não tem conta cadastrada...");
                    }
                    break;

                case 6:
                    System.out.print("Informe o CPF do titular a ser sacado");
                    long cpfUser = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Informe o CPF do titular a receber");
                    long cpfDestinatario = scanner.nextLong();

                    Conta contaUser = referenciaConta.pesquisarConta(cpfUser);
                    Conta contaDestinatario = referenciaConta.pesquisarConta(cpfDestinatario);

                    if (contaUser != null && contaDestinatario != null){
                        referenciaConta.realizarTransferencia(contaUser , contaDestinatario);

                    }else {
                        System.out.println("O cliente não tem conta cadastrada...");
                    }

                    break;

                case 7:
                    exit = true;
                    break;

            }
        }
    }
}
