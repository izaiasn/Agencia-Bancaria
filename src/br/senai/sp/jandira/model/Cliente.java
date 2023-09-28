package br.senai.sp.jandira.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {
    private String nome;
    private long cpf, rg, telefone;

    Scanner scanner = new Scanner(System.in);
    List<Cliente> listCliente = new ArrayList<>();
    public void adicionarCliente  (Cliente cliente){
        listCliente.add(cliente);
    }


    public  Cliente pesquisarCliente(long cpf){
        for (Cliente cliente : listCliente){
            long cpfCliente = cliente.getCpf();
             if (cpfCliente == cpf){
                 return cliente;
             }
        }
        return  null;
    }

    public void cadastrarCliente(){

        System.out.println("///// ----- Cadastrar Cliente   ----- /////");
        System.out.println("Informe seu nome: ");
        nome = scanner.nextLine();
        System.out.println("Informe seu cpf: ");
        cpf = scanner.nextLong();
        System.out.println("Informe seu rg: ");
        rg = scanner.nextLong();
        System.out.println("Informe seu telefone: ");
        telefone = scanner.nextLong();
        scanner.nextLine();
        System.out.println("/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/");

    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public long getCpf() {
        return cpf;
    }

    public void setRg(long rg) {
        this.rg = rg;
    }

    public long getRg() {
        return rg;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }
}
