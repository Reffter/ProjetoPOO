package project;

import java.util.ArrayList;

public class Estatistica {
    private int numEncomendasRealizadas;
    private double lucroTotal;
    private int clienteComMaisEncomendas;
    private int IDprodutoMaisVendido;
    private String produtos_em_desconto;

    public Estatistica(){
        numEncomendasRealizadas = 0;
        lucroTotal = 0.0;
        clienteComMaisEncomendas = 0;
        IDprodutoMaisVendido = 0;
        produtos_em_desconto = "";
    }

    public int getNumEncomendasRealizadas() {
        return numEncomendasRealizadas;
    }
    public void setNumEncomendasRealizadas(int numEncomendasRealizadas) {
        this.numEncomendasRealizadas = numEncomendasRealizadas;
    }

    public double getLucroTotal(ArrayList<Produto> p) {
        lucrototal(p);
        return lucroTotal;
    }
    public void setLucroTotal(double lucroTotal) {
        this.lucroTotal = lucroTotal;
    }

    public int getClienteComMaisEncomendas() {
        return clienteComMaisEncomendas;
    }
    public void setClienteComMaisEncomendas(int clienteComMaisEncomendas) {
        this.clienteComMaisEncomendas = clienteComMaisEncomendas;
    }

    public int getIDprodutoMaisVendido() {
        return IDprodutoMaisVendido;
    }
    public void setIDprodutoMaisVendido(int IDprodutoMaisVendido) {
        this.IDprodutoMaisVendido = IDprodutoMaisVendido;
    }

    public String getProdutos_em_desconto() {
        return produtos_em_desconto;
    }
    public void setProdutos_em_desconto(String produtos_em_desconto) {
        this.produtos_em_desconto = produtos_em_desconto;
    }


    //contas, encomendas, produtos


    public void lucrototal(ArrayList<Produto> e){
        double count = 0.0;
        for(Produto produto: e ){
            count = ((Encomenda)produto).getPrecoVenda() - ((Encomenda)produto).getPrecoCompra();
        }
        lucroTotal = count;
    }

    public int cliente_mais_encomendas(ArrayList<Produto> produtos, ArrayList<Pessoa> pessoas){
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

    public int produto_mais_vendido(ArrayList<Produto> produtos, ArrayList<Produto> encomendas){ // o segundo Arraylist do tipo produto é da encomenda
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





    /* static void MenuEstatisticas{
            System.out.println("Prima uma tecla:");
            System.out.println("1 - Número de encomendas realizadas");
            System.out.println("2 - Lucro total");
            System.out.println("3 - Produtos que se encontram em desconto");
            System.out.println("4 - Cliente com mais encomendas");
            System.out.println("5 - ID do Produto mais vendido");
        }

        MenuEstatistica();
        escolha = Ler.umInt();
        switch (escolha){
            case 1:
                sout(encomendas.toString());
                break;
            case 2:
                sout(encomendas.getlucroTotal());
                break;
            case 3:
                //produtos que se encontram em desconto
                break;
            case 4:
                sout(encomendas.cliente_mais_encomendas());
                break;
            case 5:
                sout(encomendas.produto_mais_vendido());
                break
         }
     */
}
