package project;

import myinputs.Ler;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {

    static void Menu1(){
        System.out.println("Prima uma tecla:");
        System.out.println("1 - Ver o catálogo");
        System.out.println("2 - Registar uma conta");
        System.out.println("3 - Iniciar sessão");
        System.out.println("0 - Sair");
    }

    static void MenuCliente(){
        System.out.println("Prima uma tecla:");
        System.out.println("1 - Ver o catálogo");
        System.out.println("2 - Realizar uma compra");
        System.out.println("3 - Histórico de compras");
        System.out.println("0 - Sair");
    }

    static void MenuFuncionario(){

    }

    static void MenuCatalogo(ArrayList<Produto> produtos){
        for (Produto p: produtos) {
            System.out.println(p.toString());
        }
    }

    static ArrayList<Conta> CarregarContas(){
        ArrayList<Conta> contas = new ArrayList<Conta>();
        try {
            ObjectInputStream ficheiro = new ObjectInputStream (new FileInputStream("C:\\Users\\Miguel\\Desktop\\UBI\\2o_Ano\\POO\\ProjetoPOO\\src\\project\\contas.dat"));
            contas = (ArrayList<Conta>) ficheiro.readObject();
        }
        catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        return contas;
    }

    static ArrayList<Encomenda> CarregarEncomendas(){
        ArrayList<Encomenda> encomendas = new ArrayList<Encomenda>();
        try {
            ObjectInputStream ficheiro = new ObjectInputStream (new FileInputStream("C:\\Users\\Miguel\\Desktop\\UBI\\2o_Ano\\POO\\ProjetoPOO\\src\\project\\encomendas.dat"));
            encomendas = (ArrayList<Encomenda>) ficheiro.readObject();
        }
        catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        return encomendas;
    }

    static ArrayList<Produto> CarregarProdutos(){
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        try {
            ObjectInputStream ficheiro = new ObjectInputStream (new FileInputStream("C:\\Users\\Miguel\\Desktop\\UBI\\2o_Ano\\POO\\ProjetoPOO\\src\\project\\produtos.dat"));
            produtos = (ArrayList<Produto>) ficheiro.readObject();
        }
        catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        return produtos;
    }


    public static void main(String[] args) {
        CarregarContas();
        CarregarEncomendas();
        CarregarProdutos();
        int escolha;
        System.out.println("Bem vindo à loja Auto24");
        boolean logado = false;

        do{
            if(!logado){
                Menu1();
                escolha = Ler.umInt();
                switch (escolha){
                    case 1:
                        FuncAlunos.inserirAluno(alunos);
                        break;
                    case 2:
                        FuncAlunos.consultarAlunoNumero(alunos);
                        break;
                    case 3:
                        FuncAlunos.consultarAlunoNome(alunos);
                        break;
                    }
            }
            /*else if(logado && for cliente){
                mostrar menu cliente
            }
            else if(logado && for empregado){
                mostrar menu empregado
            }*/
        } while(escolha != 0);
    }
}