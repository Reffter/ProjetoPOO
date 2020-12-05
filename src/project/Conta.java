package project;

import myinputs.Ler;

import java.io.*;
import java.util.ArrayList;

public class Conta implements Serializable{
    private String primeiroNome;
    private String ultimoNome;
    private int NIF;
    private String endereco;
    private String senha;

    public Conta(String primeiroNome, String ultimoNome, int NIF, String endereco, String senha){
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.NIF = NIF;
        this.endereco = endereco;
        this.senha = senha;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public int getNIF() {
        return NIF;
    }

    public void setNIF(int NIF) {
        this.NIF = NIF;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public static void criarConta(ArrayList<Conta> c){
        System.out.println("Insira o seu NIF: ");
        int NIF = Ler.umInt();
        for (int i = 0; i < c.size(); i++) {
            if(c.get(i).getNIF() == NIF){
                System.out.println("A conta já existe!");
                return;
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


        // atualizar ficheiro
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Miguel\\Desktop\\UBI\\2o_Ano\\POO\\ProjetoPOO\\src\\project\\contas.dat"));
            os.writeObject(c); // escrever o objeto no ficheiro
            os.flush(); // os dados são copiados de memória para o disco
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
