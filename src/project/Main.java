package project;

import myinputs.Ler;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
        System.out.println("Prima uma tecla:");
        System.out.println("1 - Ver o catálogo");
        System.out.println("2 - Histórico de compras");
        System.out.println("3 - Alterar catálogo");
        System.out.println("4 - Ver estatísticas");
        System.out.println("0 - Sair");
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
        ArrayList<Conta> contas = CarregarContas();
        ArrayList<Encomenda> encomendas = CarregarEncomendas();
        ArrayList<Produto> produtos = CarregarProdutos();

        int escolha = -1;
        System.out.println("Bem vindo à loja Auto24");
        boolean logado = false;

        Conta c;
        Estatistica estatisticas;

        do{
            if(!logado){
                Menu1();
                escolha = Ler.umInt();
                switch (escolha){
                    case 2:
                        c = new Conta();
                        c.criarConta(contas);
                        break;
                    case 3:
                        //iniciar sessão
                        break;
                    }
            }
            /*else if(logado && for cliente){
                MenuCliente();
                escolha = Ler.umInt();
                switch (escolha){
                    case 1:
                        MenuCatalogo(produtos);
                        break;
                    case 2:
                        Realizar uma compra
                    case 3:
                        Histórico de compras
                    }
            }
            else if(logado && for empregado){
                MenuEmpregado();
                escolha = Ler.umInt();
                switch (escolha){
                    case 1:
                        MenuCatalogo(produtos);
                        break;
                    case 2:
                        Histórico de compras
                    case 3:
                        Alterar catálogo
                    case 4:
                        e = new Estatistica();
                        System.out.println(e.produzirEstatisticas(contas, encomendas, produtos));
                    }
            }*/
        } while(escolha != 0);
    }
}