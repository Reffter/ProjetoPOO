package project;

import myinputs.Ler;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Conta extends Pessoa implements Serializable{
    protected String senha;
    private boolean cliente;

    public Conta(){
        senha = "";
        cliente = true;
    }

    public Conta(Pessoa p, String senha){
        super.primeiroNome = p.primeiroNome;
        super.ultimoNome = p.ultimoNome;
        super.NIF = p.NIF;
        super.endereco = p.endereco;
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setCliente(boolean cliente) {
        this.cliente = cliente;
    }

    public boolean getCliente(){
        return cliente;
    }

    public ArrayList<Pessoa> criarConta(ArrayList<Pessoa> c){
        System.out.println("Insira o seu NIF: ");
        int NIF = Ler.umInt();
        for (int i = 0; i < c.size(); i++) {
            if(c.get(i).getNIF() == NIF){
                System.out.println("A conta já existe!");
                return c;
            }
        }
        System.out.println("Insira a sua senha: ");
        String senha = Ler.umaString();

        System.out.println("Insira o seu nome: ");
        String primeiroNome = Ler.umaString();

        System.out.println("Insira o seu apelido: ");
        String ultimoNome = Ler.umaString();

        System.out.println("Insira o seu endereço: ");
        String endereco = Ler.umaString();

        Conta novaConta = new Conta(new Pessoa(primeiroNome, ultimoNome, NIF, endereco), senha);

        //transformar a conta com NIF 1 em conta staff
        if(novaConta.getNIF() == 1){
            novaConta.setCliente(false);
            c.add(novaConta);
            System.out.println("Conta staff criada!");
            return c;
        }

        c.add(novaConta);

        // atualizar ficheiro
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Miguel\\Desktop\\UBI\\2o_Ano\\POO\\ProjetoPOO\\src\\project\\contas.dat"));
            os.writeObject(c); // escrever o objeto no ficheiro
            os.flush(); // os dados são copiados de memória para o disco
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Conta criada!");
        return c;
    }

    /*public void historicoCompras(ArrayList<Encomenda> encomendas){
        if(cliente){ //Encomendas de cada cliente
            for (Encomenda e: encomendas) {
                if(e.getNIF() == NIF)
                    System.out.println(e.toString());
            }
        }
        else{ //Encomendas realizadas
            for (Encomenda e: encomendas) {
                System.out.println(e.toString());
            }
        }
    }*/
}
