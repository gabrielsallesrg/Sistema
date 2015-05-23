package br.com.Modelo;

public class cliente {
    int idCliente;
    String telefone;
    String nome, sobrenome, endereco, cidade, email;

    public cliente(int idCliente, String telefone, String nome, String sobrenome, String endereco, String cidade, String email) {
        this.idCliente = idCliente;
        this.telefone = telefone; //nullable
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco; //nullable
        this.cidade = cidade; //nullable
        this.email = email;
    } //construtor completo
    public cliente(String telefone, String nome, String sobrenome, String endereco, String cidade, String email) {
        this.telefone = telefone;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.email = email;
    } //construtor sem idCliente

    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }   
    
}
