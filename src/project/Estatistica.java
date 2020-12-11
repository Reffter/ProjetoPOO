package project;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Estatistica {
    public double getLucroTotal(ArrayList<Produto> encomendas, ArrayList<Produto> produtos) {
            double somatorioLucros = 0.0;
            for(Produto encomenda: encomendas){
                for(Produto produto : produtos){
                    if(produto.getID() == ((Encomenda)encomenda).getID()) {
                        somatorioLucros = somatorioLucros + ((((Encomenda) encomenda).getPrecoVenda() * (((Encomenda) encomenda).getQtd())) - (produto.getPrecoCompra() * (((Encomenda) encomenda).getQtd())));
                    }
                }
            }
            return somatorioLucros;
    }

    public int getClienteComMaisEncomendas(ArrayList<Produto> encomendas, ArrayList<Pessoa> pessoas){
        int count =  0, aux = 0, NIFpessoa = 0;

        for (Pessoa pessoa: pessoas) {
            count = 0;
            for (Produto encomenda : encomendas) {
                if(((Encomenda)encomenda).getNIFencomenda() == pessoa.getNIF()){
                    count++;
                }
            }
            if(aux < count){
                aux = count;
                NIFpessoa = pessoa.getNIF();
            }
        }
        return NIFpessoa;
    }

    public int getProdutoMaisVendido(ArrayList<Produto> produtos, ArrayList<Produto> encomendas){ // o segundo Arraylist do tipo produto é da encomenda
        int aux = 0, count = 0, IDproduto = 0;
        for (Produto produto: produtos) {
            for(Produto encomenda: encomendas){
                if(produto.getID() == ((Encomenda)encomenda).getID()){
                    count++;
                }
            }
            if(aux < count){
                aux = count;
                IDproduto = produto.getID();
            }
        }
        return IDproduto;
    }

    public void getProdutosEmDesconto(ArrayList<Produto> produtos){
        ArrayList<Produto> produtosDesconto = new ArrayList<Produto>();
        for (Produto produto: produtos) {
            if(produto.getDesconto() != 0){
                produtosDesconto.add(produto);
            }
        }
        System.out.println(produtosDesconto.toString());
    }
}
