package br.com.Modelo;

public class produtos {
    //Campos da tabela "produtos"
    int idProduto, estoque;
    double valor;
    String descricao, situacao;
    
    public produtos(){   }    
   
    public produtos(int idProduto, int estoque, double valor, String situacao) {
        
        this.idProduto = idProduto;
        this.estoque = estoque; //nullable
        this.valor = valor;
        this.situacao = situacao;
        
    } //construtor completo
    
    public produtos(int idProduto, int estoque, double valor, String descricao, String situacao) {
        this.idProduto = idProduto;
        this.estoque = estoque;
        this.valor = valor;
        this.descricao = descricao;
        this.situacao = situacao;
    } //construtor completo
    
    public produtos(String situacao, int estoque, String descricao, double valor) {
        this.situacao = situacao;
        this.estoque = estoque;
        this.valor = valor;
        this.descricao = descricao;
    } //construtor para manipular o estoque    

    
    //setters e getters
    public int getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    public int getEstoque() {
        return estoque;
    }
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }    
    public String getSituacao() {
        return situacao;
    }
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }    
}
