package br.com.Modelo;

public class produtos {
    //Campos da tabela "produtos"
    int idProduto, estoque;
    float valor;
    String descricao,unidades;
    char situacao;
    
    public produtos(){
        
    }
    
    public produtos(int idProduto, int estoque, String unidades, float valor, String descricao, char situacao) {
        this.idProduto = idProduto;
        this.estoque = estoque;
        this.unidades = unidades;
        this.valor = valor;
        this.descricao = descricao;
        this.situacao = situacao;
    } //construtor completo
    public produtos(int idProduto, int estoque, String unidades) {
        this.idProduto = idProduto;
        this.estoque = estoque;
        this.unidades = unidades;
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
    public String getUnidades() {
        return unidades;
    }
    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }    
    public char getSituacao() {
        return situacao;
    }
    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }    
}
