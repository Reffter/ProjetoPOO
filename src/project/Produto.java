package project;

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
}