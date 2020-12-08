package project;

import java.util.ArrayList;

public class Estatistica {
    public double getLucroTotal(ArrayList<Produto> produtos) {
            double somatorioLucros = 0.0;
            for(Produto produto: produtos){
                somatorioLucros = ((Encomenda)produto).getPrecoVenda() - ((Encomenda)produto).getPrecoCompra();
            }
            return somatorioLucros;
    }

    public int getClienteComMaisEncomendas(ArrayList<Produto> produtos, ArrayList<Pessoa> pessoas){
        int count1 =  0;
        int aux = 0;
        for (Pessoa pessoa: pessoas) {
            for (Produto produto : produtos) {
                if(((Encomenda)produto).getNIFencomenda() == pessoa.getNIF()){
                    count1 ++;
                }
            }
            if(aux < count1){
                aux = count1;
            }
        }
        return aux;
    }

    public int getProdutoMaisVendido(ArrayList<Produto> produtos, ArrayList<Produto> encomendas){ // o segundo Arraylist do tipo produto é da encomenda
        int aux1 = 0;
        int count2 = 0;
        for (Produto produto: produtos) {
            for(Produto encomenda: encomendas){
                if(produto.getID() == ((Encomenda)encomenda).getID()){
                    count2 ++;
                }
            }
            if(aux1 < count2){
                aux1 = count2;
            }
        }
        return aux1;
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
