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

    public Login authentication(ArrayList<Pessoa> c, Login account)
    {
        System.out.println("NIF: ");
        NIF_auth = Ler.umInt();
        System.out.println("Senha: ");
        senha_auth = Ler.umaString();

        for(Pessoa pessoas : c) {
            if (pessoas.getNIF() == NIF_auth && ((Conta) pessoas).getSenha().equals(senha_auth)){
                System.out.println("Login efetuado!");

                if(NIF_auth == 1){
                    account = new Login(pessoas, ((Conta) pessoas).getSenha());
                    account.setEstadoLogin(2);
                    return account;
                }
                account = new Login(pessoas, ((Conta) pessoas).getSenha());
                account.setEstadoLogin(1);
                return account;
            }
        }
        System.out.println("Login não efetuado!");

        account = new Login();
        account.setEstadoLogin(0);
        return account;
    }
}

//account = new Conta(pessoas, ((Conta) pessoas).getSenha());