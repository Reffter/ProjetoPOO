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

    static void MenuEstatisticas(){
        System.out.println("Prima uma tecla:");
        System.out.println("1 - Encomendas realizadas");
        System.out.println("2 - Lucro total");
        System.out.println("3 - Produtos que se encontram em desconto");
        System.out.println("4 - Cliente com mais encomendas");
        System.out.println("5 - ID do Produto mais vendido");
        System.out.println("6 - Voltar atrás");
    }

    static void MenuCatalogo(ArrayList<Produto> produtos){
        System.out.println("ID | Categoria | Designacao | Preço | Stock\n");
        for (Produto p: produtos) {
            System.out.println(p.toString());
        }
    }

    static void MenuEncomendasCliente(ArrayList<Produto> encomendas, int NIF){
        System.out.println("ID Encomenda | Designacao do Produto | Quantidade Encomendada | Preco a Pagar\n");
        for (Produto produtos: encomendas) {
            if(NIF == ((Encomenda)produtos).getNIFencomenda())
                System.out.println(((Encomenda) produtos).getIDencomenda() + " | " + produtos.getDesignacao() + " | " + ((Encomenda) produtos).getQtd() + " | " + produtos.getPrecoVenda());
        }
    }

    static void MenuEncomendasStaff(ArrayList<Produto> encomendas){
        System.out.println("ID Encomenda | Designacao | Quantidade | Preco | NIF do Cliente\n");
        for (Produto produtos: encomendas) {
            System.out.println(produtos.toString());
            //System.out.println(((Encomenda) produtos).getIDencomenda() + " | " + produtos.getDesignacao() + " | " + ((Encomenda) produtos).getQtd() + " | " + produtos.getPrecoVenda());
        }
    }

    static ArrayList<Pessoa> CarregarContas(){
        ArrayList<Pessoa> contas = new ArrayList<Pessoa>();
        try {
            ObjectInputStream ficheiro = new ObjectInputStream (new FileInputStream("src\\project\\files\\contas.dat"));
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
            ObjectInputStream ficheiro = new ObjectInputStream (new FileInputStream("src\\project\\files\\encomendas.dat"));
            int ult = ficheiro.readInt();
            Encomenda.setUltimo(ult);
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
            ObjectInputStream ficheiro = new ObjectInputStream (new FileInputStream("src\\project\\files\\produtos.dat"));
            int ult = ficheiro.readInt();
            Produto.setUltimo(ult);
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

        Conta c;
        Produto p;
        Encomenda e;
        Login login = new Login();

        do{
            if(login.getEstadoLogin() == 0){
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
                        login = auth.authentication(contas, login);
                        break;
                    }
            }
            else if(login.getEstadoLogin() == 1){
                MenuCliente();
                escolha = Ler.umInt();
                switch (escolha){
                    case 1:
                        MenuCatalogo(produtos);
                        break;
                    case 2:
                        try {
                            e = new Encomenda();
                            ArrayList<ArrayList<Produto>> array = new ArrayList<ArrayList<Produto>>();
                            array = e.realizarEncomenda(produtos, encomendas, login.getNIF());
                            encomendas = array.get(0);
                            System.out.println(array.get(1));
                            produtos = array.get(1);

                        }
                        catch(Exception exception){
                            System.out.println(exception.getMessage());
                        }
                        break;
                    case 3:
                        MenuEncomendasCliente(encomendas, login.getNIF());
                        break;
                    case 4:
                        login.setEstadoLogin(0);
                        break;
                    }
            }
            else if(login.getEstadoLogin() == 2){
                MenuFuncionario();
                escolha = Ler.umInt();
                switch (escolha){
                    case 1:
                        MenuCatalogo(produtos);
                        break;
                    case 2:
                        MenuEncomendasStaff(encomendas);
                        break;
                    case 3:
                        p = new Produto();
                        produtos = p.addProduct(produtos);
                        break;
                    case 4:
                        p = new Produto();
                        produtos = p.removeProduct(produtos);
                        break;
                    case 5:
                        MenuEstatisticas();
                        escolha = Ler.umInt();
                        Estatistica estatisticas = new Estatistica();
                        switch (escolha){
                            case 1:
                                System.out.println(encomendas.toString());
                                break;
                            case 2:
                                System.out.println(estatisticas.getLucroTotal(encomendas));
                                break;
                            case 3:
                                estatisticas.getProdutosEmDesconto(produtos);
                                break;
                            case 4:
                                System.out.println(estatisticas.getClienteComMaisEncomendas(encomendas, contas));
                                break;
                            case 5:
                                System.out.println(estatisticas.getProdutoMaisVendido(produtos, encomendas));
                                break;
                            case 6:
                                break;
                        }
                        break;
                    case 6:
                        login.setEstadoLogin(0);
                        break;
                    }
            }
        } while(escolha != 0);
    }
}
