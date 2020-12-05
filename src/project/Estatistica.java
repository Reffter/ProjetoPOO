package project;

public class Estatistica {
    private int numEncomendasRealizadas;
    private double lucroTotal;
    private int clienteComMaisEncomendas;
    private int IDprodutoMaisVendido;

    public Estatistica(){
        numEncomendasRealizadas = 0;
        lucroTotal = 0.0;
        clienteComMaisEncomendas = 0;
        IDprodutoMaisVendido = 0;
    }

    public int getNumEncomendasRealizadas() {
        return numEncomendasRealizadas;
    }

    public void setNumEncomendasRealizadas(int numEncomendasRealizadas) {
        this.numEncomendasRealizadas = numEncomendasRealizadas;
    }

    public double getLucroTotal() {
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

    //contas, encomendas, produtos
    public String produzirEstatisticas(ArrayList<Conta> c, ArrayList<Encomenda> e, ArrayList<Produto> p){
        numEncomendasRealizadas = e.size();
        lucroTotal = ???
        clienteComMaisEncomendas = ???
        IDprodutoMaisVendido = ???
    }
}
