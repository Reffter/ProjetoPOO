package project;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Main {
    static void Menu1(){
        System.out.println("Prima uma tecla:");
        System.out.println("1 - Ver o catálogo");
        System.out.println("2 - Registar uma conta");
        System.out.println("3 - Iniciar sessão");
        System.out.println("4 - Sair");
    }
    static void MenuCatalogo(ArrayList<Produto> produtos){
        for (Produto p: produtos) {
            System.out.println(p.toString());
        }
    }

    public static void main(String[] args) {

        ArrayList<Conta> c = new ArrayList<Conta>();

        try {
            ObjectInputStream ficheiro = new ObjectInputStream (new FileInputStream("contas.dat"));
            c = (ArrayList<Conta>) ficheiro.readObject();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        catch ( ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Bem vindo à loja Auto24");
        Pessoa p = new Pessoa("Zeze", "Tenrinho", 248184350, "Rua 69");
        Conta c1 = new Conta(p, "abc123");
        c1.RegistoConta(c);
    }
}
