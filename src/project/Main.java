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
        System.out.println("4 - Logout");
    }

    static void MenuFuncionario(){
        System.out.println("Prima uma tecla:");
        System.out.println("1 - Ver o catálogo");
        System.out.println("2 - Histórico de compras");
        System.out.println("3 - Adicionar produto");
        System.out.println("4 - Remover produto");
        System.out.println("5 - Ver estatísticas");
        System.out.println("6 - Logout");
    }

    static void MenuCatalogo(ArrayList<Produto> produtos){
        System.out.println("ID | Categoria | Designacao | Preço | Stock");
        for (Produto p: produtos) {
            System.out.println(p.toString());
        }
    }

    static ArrayList<Pessoa> CarregarContas(){
        ArrayList<Pessoa> contas = new ArrayList<Pessoa>();
        try {
            ObjectInputStream ficheiro = new ObjectInputStream (new FileInputStream("C:\\Users\\Miguel\\Desktop\\UBI\\2o_Ano\\POO\\ProjetoPOO\\src\\project\\files\\contas.dat"));
            contas = (ArrayList<Pessoa>) ficheiro.readObject();
        }
        catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        return contas;
    }

    static ArrayList<Produto> CarregarEncomendas(){
        ArrayList<Produto> encomendas = new ArrayList<Produto>();
        try {
            ObjectInputStream ficheiro = new ObjectInputStream (new FileInputStream("C:\\Users\\Miguel\\Desktop\\UBI\\2o_Ano\\POO\\ProjetoPOO\\src\\project\\files\\encomendas.dat"));
            encomendas = (ArrayList<Produto>) ficheiro.readObject();
        }
        catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        return encomendas;
    }

    static ArrayList<Produto> CarregarProdutos(){
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        try {
            ObjectInputStream ficheiro = new ObjectInputStream (new FileInputStream("C:\\Users\\Miguel\\Desktop\\UBI\\2o_Ano\\POO\\ProjetoPOO\\src\\project\\files\\produtos.dat"));
            produtos = (ArrayList<Produto>) ficheiro.readObject();
        }
        catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        return produtos;
    }

    public static void main(String[] args) throws Exception {
        ArrayList<Pessoa> contas = CarregarContas();
        ArrayList<Produto> encomendas = CarregarEncomendas();
        ArrayList<Produto> produtos = CarregarProdutos();

        int escolha = -1;
        System.out.println("Bem vindo à loja Auto24");
        int estadoLogin = 0;

        Conta c;
        Estatistica estatisticas;
        Produto p;
        do{
            if(estadoLogin == 0){
                Menu1();
                escolha = Ler.umInt();
                switch (escolha){
                    case 1:
                        MenuCatalogo(produtos);
                        break;
                    case 2:
                        c = new Conta();
                        contas = c.criarConta(contas);
                        break;
                    case 3:
                        Auth auth = new Auth();
                        estadoLogin = auth.authentication(contas);
                        break;
                    }
            }
            else if(estadoLogin == 1){
                MenuCliente();
                escolha = Ler.umInt();
                switch (escolha){
                    case 1:
                        MenuCatalogo(produtos);
                        break;
                    case 2:
                        //Realizar uma compra
                        break;
                    case 3:
                        //Histórico de compras
                        break;
                    case 4:
                        estadoLogin = 0;
                        break;
                    }
            }
            else if(estadoLogin == 2){
                MenuFuncionario();
                escolha = Ler.umInt();
                switch (escolha){
                    case 1:
                        MenuCatalogo(produtos);
                        break;
                    case 2:
                        //Histórico de compras
                        break;
                    case 3:
                        p = new Produto();
                        Produto.setUltimo(produtos.size());
                        produtos = p.addProduct(produtos);
                        break;
                    case 4:
                        p = new Produto();
                        produtos = p.removeProduct(produtos);
                        break;
                        //e = new Estatistica();
                        //System.out.println(e.produzirEstatisticas(contas, encomendas, produtos));
                    case 5:
                        break;
                    case 6:
                        estadoLogin = 0;
                        break;
                    }
            }
        } while(escolha != 0);
    }
}
