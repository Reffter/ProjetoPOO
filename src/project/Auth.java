package project;

import myinputs.Ler;

import java.util.ArrayList;

public class Auth{
    private int NIF_auth;
    private String senha_auth;

    public Auth(){
        NIF_auth = 0;
        senha_auth = "";
    }

    public boolean authentication(ArrayList<Pessoa> c)
    {
        System.out.println("NIF: ");
        NIF_auth = Ler.umInt();
        System.out.println("Senha: ");
        senha_auth = Ler.umaString();

        for(Pessoa pessoas : c) {
            if (pessoas.getNIF() == NIF_auth && ((Conta) pessoas).getSenha().equals(senha_auth)){
                System.out.println("Login efetuado!");
                return true;
            }
        }
        System.out.println("Login não efetuado!");
        return false;
    }


}
