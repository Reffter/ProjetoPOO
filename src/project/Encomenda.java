package project;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Encomenda extends Produto {
    private int IDencomenda = 0;
    private int qnt = 0;
    private boolean estado = false;
    private int NIFencomenda = 0;

    public Encomenda(Produto p,int IDencomenda, int qtd, boolean estado, int NIFencomenda){
        super.setDesignacao(p.getDesignacao());
        super.setPreco(p.getPreco());
        super.setID(p.getID());
        this.IDencomenda = IDencomenda;
        this.qnt = qtd;
        this.estado = estado;
        this.NIFencomenda = NIFencomenda;
    }

    public void incrementar_IDencomenda(){
        IDencomenda ++;
    }

    public int getIDencomenda() {
        return IDencomenda;
    }
    public void setIDencomenda(int IDencomenda) {
        this.IDencomenda = IDencomenda;
    }

    public int getQnt() {
        return qnt;
    }
    public void setQnt(int qnt) {
        this.qnt = qnt;
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

    @Override
    public String toString() {
        return "Encomenda{" + "IDencomenda=" + IDencomenda + ", qnt=" + qnt + ", estado=" + estado + ", NIFencomenda=" + NIFencomenda + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Encomenda encomenda = (Encomenda) o;
        return qnt == encomenda.qnt && estado == encomenda.estado && NIFencomenda == encomenda.NIFencomenda && IDencomenda == encomenda.IDencomenda;
    }
}
