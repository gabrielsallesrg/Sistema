package br.com.Modelo;

import java.util.Date;

public class pedido { //faltando idProduto?
    int idPedido, quantidade, idCliente, idProduto;
    double valor;
    char situacao;
    String pagamento, token; 
    Date emissao, retirada;   
    
    public pedido(){   }

    public pedido(int idPedido, int quantidade, double valor, char situacao, String emissao, String retirada, String pagamento, String token) {
        this.idPedido = idPedido;
        this.quantidade = quantidade;
        this.valor = valor; 
        this.situacao = situacao;
        this.pagamento = pagamento;
        this.token = token;
    } //construtor    

    public int getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(int idProduto) {
       this.idProduto = idProduto;
    }
    public int getIdPedido() {
        return idPedido;
    }
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public char getSituacao() {
        return situacao;
    }
    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }
    public Date getEmissao() {
        return emissao;
    }
    public void setEmissao(Date emissao) {
        this.emissao = emissao;
    }
    public Date getRetirada() {
        return retirada;
    }
    public void setRetirada(Date retirada) {
        this.retirada = retirada;
    }
    public String getPagamento() {
        return pagamento;
    }
    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }    
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    } 
    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }    
}
