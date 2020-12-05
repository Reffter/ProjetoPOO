package project;

import java.util.ArrayList;

public class Auth {
    private int NIF_auth;
    private String senha_auth;

    public Auth(int na,String sa)
    {
        NIF_auth = na;
        senha_auth = sa;
    }

    public boolean authentication(ArrayList<Conta> c)
    {
        for(Conta conta:c)
        {
            if(conta.getNIF() == NIF_auth && conta.getSenha().equals(senha_auth))
                return true;
        }
        return false;
    }
}
