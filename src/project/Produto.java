package project;

import myinputs.Ler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Objects;

public class Produto implements Serializable {
    private String Categoria;
    private String Designacao;
    private double PrecoVenda;
    private double PrecoCompra;
    private int Stock;
    private int ID;
    private static int ultimo = 0;
    private double Desconto;

    public Produto(){
        Categoria = "";
        Designacao = "";
        PrecoVenda = 0.0;
        PrecoCompra = 0.0;
        Stock = 0;
        Desconto = 0;
    }

    public Produto(String Categoria, String Designacao, double PrecoVenda, double PrecoCompra, int Stock){
        ultimo++;
        this.ID = ultimo;
        this.Categoria = Categoria;
        this.Designacao = Designacao;
        this.PrecoVenda = PrecoVenda;
        this.PrecoCompra = PrecoCompra;
        this.Stock = Stock;
        this.Desconto = 0;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getDesignacao() {
        return Designacao;
    }

    public void setDesignacao(String designacao) {
        Designacao = designacao;
    }

    public double getPrecoVenda() {
        return PrecoVenda;
    }

    public void setPrecoVenda(double preco) {
        PrecoVenda = preco;
    }

    public double getPrecoCompra() {
        return PrecoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        PrecoCompra = precoCompra;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public static void setUltimo(int ultimo) {
        Produto.ultimo = ultimo;
    }

    public static int getUltimo() {
        return ultimo;
    }

    public void setDesconto(double desconto) {
        Desconto = desconto;
    }

    public double getDesconto() {
        return Desconto;
    }

    @Override
    public String toString() {
        return ID + " | " + Categoria + " | " + Designacao + " | " + PrecoVenda + " | " + Stock;
    }

    public String toStringEncomendas() {
        return ID + " | " + Categoria + " | " + Designacao + " | " + PrecoVenda + " | " + Stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(Categoria, produto.Categoria) && Objects.equals(Designacao, produto.Designacao);
    }

    //alpa -> ArrayList de Produto Auxiliar, tentar usar esta sigla quando se usa
    //        uma arraylist dos produtos numa funcao

    public ArrayList<Produto> addProduct(ArrayList<Produto> alpa){
        boolean doesProductExist = false;

        do {
            System.out.println("Indique o nome do produto que pretende adicionar: ");
            Designacao = Ler.umaString();
            doesProductExist = false;
            for (Produto i : alpa){
                if (i.getDesignacao().toLowerCase().equals(Designacao.toLowerCase())){
                    System.out.println("Este produto ja existe!");
                    doesProductExist = true;
                    break;
                }
            }
        }while(doesProductExist);

        System.out.println("Insira a categoria:");
        Categoria = Ler.umaString();

        System.out.println("Insira o preço de venda:");
        PrecoVenda = Ler.umDouble();

        System.out.println("Qual o preço de compra ao fornecedor?");
        PrecoCompra = Ler.umDouble();

        System.out.println("Quanto stock existe?");
        Stock = Ler.umInt();

        alpa.add(new Produto(Categoria, Designacao, PrecoVenda, PrecoCompra, Stock));

        // atualizar ficheiro
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("src\\project\\files\\produtos.dat"));
            os.writeInt(Produto.getUltimo());
            os.writeObject(alpa); // escrever o objeto no ficheiro
            os.flush(); // os dados são copiados de memória para o disco
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Produto adicionado!");
        return alpa;
    }

    public ArrayList<Produto> removeProduct(ArrayList<Produto> alpa) throws Exception {
        int numero = 0;
        numero = verificarID();

        for (Produto i : alpa){
            if(i.getID() == numero){
                alpa.remove(i);
                break;
            }
        }
        // atualizar ficheiro
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("src\\project\\files\\produtos.dat"));
            os.writeInt(Produto.getUltimo());
            os.writeObject(alpa); // escrever o objeto no ficheiro
            os.flush(); // os dados são copiados de memória para o disco
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Produto removido!\n");
        return alpa;
    }

    public ArrayList<Produto> editarProduto(ArrayList<Produto> alpa) {
        boolean produtoExiste = false;
        System.out.println("Qual o ID do produto a editar?");
        int editarID = Ler.umInt();

        for(Produto produto : alpa){
            if(produto.getID() == editarID){
                System.out.println("Produto existe! Insira os novos dados abaixo:");

                System.out.println("Insira a categoria:");
                produto.setCategoria(Ler.umaString());

                System.out.println("Insira a designação:");
                produto.setDesignacao(Ler.umaString());

                System.out.println("Insira o preço de venda:");
                produto.setPrecoVenda(Ler.umDouble());

                System.out.println("Qual o preço de compra ao fornecedor?");
                produto.setPrecoCompra(Ler.umDouble());

                System.out.println("Quanto stock existe?");
                produto.setStock(Ler.umInt());

                produtoExiste = true;
                break;
            }
        }

        if(!produtoExiste){
            System.out.println("Produto não encontrado!");
        }

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("src\\project\\files\\produtos.dat"));
            os.writeInt(Produto.getUltimo());
            os.writeObject(alpa); // escrever o objeto no ficheiro
            os.flush(); // os dados são copiados de memória para o disco
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return alpa;
    }

    public ArrayList<Produto> addPromo(ArrayList<Produto> alpa) throws Exception{
        int numero;
        double desconto = 0;
        boolean numerovalido = false;

        numero = verificarID();
        for (Produto i: alpa){
            if(i.getID()==numero){
                System.out.println("O produto foi encontrado, introduza a percentagem de desconto que quer aplicar: ");
                do{
                    numerovalido=true;
                    try{
                        desconto = Ler.umInt();
                    }
                    catch(Exception e){
                        System.out.println("Desconto invalido!");
                        numerovalido=false;
                    }
                }while(!numerovalido);

                i.setPrecoVenda(i.getPrecoVenda()*((100-desconto)/100));
                i.setDesconto(desconto);
                break;
            }
        }

        // atualizar ficheiro
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("src\\project\\files\\produtos.dat"));
            os.writeInt(Produto.getUltimo());
            os.writeObject(alpa); // escrever o objeto no ficheiro
            os.flush(); // os dados são copiados de memória para o disco
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return alpa;
    }

    public ArrayList<Produto> removePromo(ArrayList<Produto> alpa) throws Exception{
        int numero;
        double desconto = 0;
        boolean numerovalido = false;

        numero = verificarID();
        for (Produto i: alpa){
            if(i.getID() == numero){
                i.setPrecoVenda(i.getPrecoVenda()/((100-i.getDesconto())/100));
                i.setDesconto(0);
                System.out.println("O produto foi encontrado e o desconto removido!");
                break;
            }
        }

        // atualizar ficheiro
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("src\\project\\files\\produtos.dat"));
            os.writeInt(Produto.getUltimo());
            os.writeObject(alpa); // escrever o objeto no ficheiro
            os.flush(); // os dados são copiados de memória para o disco
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return alpa;
    }

    public int verificarID(){
        int n=0;
        boolean numerovalido=false;

        do{
            numerovalido=true;
            try{
                System.out.println("Introduza um ID valido: ");
                n=Ler.umInt();
                verificarnumero(n);
            }
            catch(Exception e){
                System.out.println("ID invalido!");
                numerovalido=false;
            }

        }while(!numerovalido);

        System.out.println("O ID '"+n+"' existe!");

        return n;
    }

    public void verificarnumero(int n) throws Exception {
        if (n < 1){
            throw new Exception("Introduza um numero maior que zero");
        }
    }
}
