package project;

import myinputs.Ler;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

public class Produto {
    private String Categoria;
    private String Designacao;
    private double Preco;
    private double PrecoCompra;
    private int Stock;
    private int ID;
    private int ultimo = 0;

    public Produto(){
        ultimo++;
        ID = ultimo;
        Categoria = "";
        Designacao = "";
        Preco = 0.0;
        PrecoCompra = 0.0;
        Stock = 0;
    }

    public Produto(String Categoria, String Designacao, double Preco, int Stock){
        this.Categoria = Categoria;
        this.Designacao = Designacao;
        this.Preco = Preco;
        this.Stock = Stock;
    }

    public Produto(String Categoria, String Designacao, double Preco, double PrecoCompra, int Stock){
        this.Categoria = Categoria;
        this.Designacao = Designacao;
        this.Preco = Preco;
        this.PrecoCompra = PrecoCompra;
        this.Stock = Stock;
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

    public double getPreco() {
        return Preco;
    }

    public void setPreco(double preco) {
        Preco = preco;
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

    @Override
    public String toString() {
        return ID + " | " + Categoria + " | " + Designacao + " | " + Preco + " | " + Stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(Categoria, produto.Categoria) && Objects.equals(Designacao, produto.Designacao);
    }

    public ArrayList<Produto> addProduct(ArrayList<Produto> alpa){
        Produto pa = new Produto();
        boolean doesProductExist = true;

        System.out.println("Indique o nome do produto que pretende adicionar: ");
        do {
            pa.setDesignacao(Ler.umaString());

            for (Produto i : alpa){
                if (i.getDesignacao().toLowerCase(Locale.ROOT).equals(pa.getDesignacao().toLowerCase(Locale.ROOT))){
                    System.out.println("Este produto ja existe!");
                    doesProductExist = true;
                }
                else{
                    doesProductExist = false;
                }
            }
        }while(doesProductExist);

        pa.setCategoria(Ler.umaString());
        pa.setPreco(Ler.umDouble());
        pa.setPrecoCompra(Ler.umDouble());
        pa.setStock(Ler.umInt());

        alpa.add(pa);
        return alpa;
    }

    public ArrayList<Produto> removeProduct(ArrayList<Produto> alpa) throws Exception {
        int numero = 0;
        boolean numerovalido=false;

        do{
            numerovalido=true;
            try{
                System.out.println("Introduza um ID valido: ");
                numero=Ler.umInt();
                verificarnumero(numero);
            }
            catch(Exception e){
            System.out.println("ID invalido!");
            numerovalido=false;
            }

        }while(!numerovalido);

        //se houver tempo, adicionar checkbox que mostra o produto e pergunta se quer remover

        for (Produto i : alpa){
            if(i.getID() == numero){
                alpa.remove(i);
                return alpa;
            }
        }
    return alpa;
    }

    public void verificarnumero(int n) throws Exception {
        if (n <0){
            throw new Exception("Introduza um numero igual ou maior que zero");
        }
    }
}