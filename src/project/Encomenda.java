package project;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import myinputs.Ler;

public class Encomenda extends Produto {
    private static int ultimo = 0;
    private int IDencomenda = 0;
    private int qtd = 0;
    private boolean estado = false;
    private int NIFencomenda = 0;

    public Encomenda(Produto p, int qtd, int NIFencomenda){
        ultimo++;
        super.setDesignacao(p.getDesignacao());
        super.setPrecoVenda(p.getPrecoVenda());
        super.setID(p.getID());
        this.IDencomenda = ultimo;
        this.qtd = qtd;
        this.estado = false;
        this.NIFencomenda = NIFencomenda;
    }

    public Encomenda(){}

    public int getIDencomenda() {
        return IDencomenda;
    }
    public void setIDencomenda(int IDencomenda) {
        this.IDencomenda = IDencomenda;
    }

    public int getQtd() {
        return qtd;
    }
    public void setQtd(int qnt) {
        this.qtd = qtd;
    }

    public boolean getEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getNIFencomenda() {
        return NIFencomenda;
    }
    public void setNIFencomenda(int NIFencomenda) {
        this.NIFencomenda = NIFencomenda;
    }

    public static void setUltimo(int ultimo) {
        Encomenda.ultimo = ultimo;
    }

    public static int getUltimo() {
        return ultimo;
    }

    public ArrayList<ArrayList<Produto>> realizarEncomenda(ArrayList<Produto> produtos, ArrayList<Produto> encomendas , int NIF){
        System.out.println("Qual o ID do produto?");
        super.setID(Ler.umInt());

        System.out.println("Qual a quantidade a encomendar?");
        this.qtd = Ler.umInt();

        boolean encomendaRealizada = false;

        for (Produto produto: produtos) {
            if(produto.getID() == super.getID() && qtd <= produto.getStock()){
                encomendas.add(new Encomenda(produto, this.qtd, NIF));
                produto.setStock(produto.getStock() - qtd);
                System.out.println(produto.toString());
                System.out.println("Encomenda realizada!");
                encomendaRealizada = true;
                break;
            }
        }

        if(!encomendaRealizada)
            System.out.println("Encomenda não efetuada!");

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("src\\project\\files\\encomendas.dat"));
            os.writeInt(Encomenda.getUltimo());
            os.writeObject(encomendas); // escrever o objeto no ficheiro

            os = new ObjectOutputStream(new FileOutputStream("src\\project\\files\\produtos.dat"));
            os.writeInt(Produto.getUltimo());
            os.writeObject(produtos); // escrever o objeto no ficheiro

            os.flush(); // os dados são copiados de memória para o disco
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        ArrayList<ArrayList<Produto>> array = new ArrayList<ArrayList<Produto>>();
        array.add(encomendas);
        array.add(produtos);
        System.out.println(produtos);
        return array;
    }

    @Override
    public String toString() {
            return IDencomenda + " | " + getDesignacao() + " | " + qtd + " | " + getPrecoVenda() + " | " + NIFencomenda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Encomenda encomenda = (Encomenda) o;
        return qtd == encomenda.qtd && estado == encomenda.estado && NIFencomenda == encomenda.NIFencomenda && IDencomenda == encomenda.IDencomenda;
    }
}
