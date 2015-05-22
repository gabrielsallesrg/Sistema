package br.com.Modelo;

public class login {
    String account, senha;
    int idCliente;

    public login(String account, String senha, int idCliente) {
        this.account = account;
        this.senha = senha;
        this.idCliente = idCliente;
    }
    public login ( ) { }
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }    
}
