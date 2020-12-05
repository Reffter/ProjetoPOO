package project;

import java.io.*;
import java.util.ArrayList;

public class Conta extends Pessoa implements Serializable{
    private String senha;

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

    @Override
    public String toString() {
        return "Conta{" +
                "senha='" + senha + '\'' + super.toString() +
                '}';
    }

    public void RegistoConta(ArrayList<Conta> c){
        for (Conta c1: c) {
            if(c1.getNIF() == super.NIF){
                System.out.println("A conta já existe!");
     //           return;
                }
            }

        Pessoa p = new Pessoa(super.primeiroNome, super.ultimoNome, super.NIF, super.endereco);
        Conta novaConta = new Conta(p, this.senha);
        c.add(novaConta);

        // atualizar ficheiro
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Miguel\\Desktop\\UBI\\2o_Ano\\POO\\ProjetoPOO\\src\\project\\contas.dat"));
            // escrever o objeto alunos no ficheiro
            os.writeObject(c);
            os.flush(); // os dados são copiados de memória para o disco
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
