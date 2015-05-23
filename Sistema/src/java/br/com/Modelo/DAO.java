package br.com.Modelo;

import com.mysql.jdbc.Connection;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    private final Connection conn;
    private ResultSet rs;    
    // método construtor para conectar com o banco
    public DAO () throws SQLException {
        System.out.println("DAO.java, construtor");
        this.conn = (Connection) FabricaDeConexão.getConnection();
        System.out.println("DAO.java, fim do construtor");
    } //construtor     
    
    /////////////////ADICIONAR TABELAS////////////////////
    public void adicionaCliente (cliente Cliente) { //rever a string sql. idCliente deve ter auto-incremento
        String SQL = "INSERT INTO Cliente (Nome, Sobrenome, Endereco, Telefone, Cidade, Email)"+" VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, Cliente.getNome());
            ps.setString(2, Cliente.getSobrenome());
            ps.setString(3, Cliente.getEndereco());
            ps.setString(4, Cliente.getTelefone());
            ps.setString(5, Cliente.getCidade());
            ps.setString(6, Cliente.getEmail());            
            ps.execute(); //executa os comandos no db.
            ps.close(); //finalize conexão com o db.
        } //try
        catch (SQLException e) {
            throw new RuntimeException(e);
        } //catch
    } //adicionarCliente
    
    public void cadastroProduto (produtos Produto) {
        String SQL = "INSERT INTO Produtos (descricao, valor, estoque, Situacao)"+" VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, Produto.getDescricao());
            String aux = Double.toString(Produto.getValor());
            ps.setString(2, aux);
            aux = Integer.toString(Produto.getEstoque());
            ps.setString(3, aux);
            aux = "" + Produto.getSituacao();
            ps.setString(4, aux);
            ps.execute();
            ps.close();
        } //try
        catch (SQLException e) {
            throw new RuntimeException(e);
        } //catch
    } //cadastrarProduto
    
    ////////////////////LISTAR E CONSULTAR TABELAS///////////////
    public List<produtos> listaProdutos() {            
        try {
            List<produtos> aut = new ArrayList<produtos>();
            String SQL = "SELECT * FROM Produtos";
            PreparedStatement stmt = this.conn.prepareStatement(SQL);
            ResultSet rs = stmt.executeQuery();            
            while(rs.next()){
                produtos prod = new produtos();                
                prod.setDescricao(rs.getString("descricao"));
                prod.setEstoque(rs.getInt("estoque"));
                prod.setIdProduto(rs.getInt("idProdutos"));
                prod.setUnidades(rs.getString("unidade"));
                prod.setValor(rs.getDouble("valor"));
                aut.add(prod);
            }
            rs.close();
            stmt.close();
            return aut;
        } //try
        catch (SQLException e) {
            throw new RuntimeException(e);
        } //catch
    } //listaProdutos
    
    public List<pedido> listaPedidos(int $cliente){        
        try{
            String SQL = " SELECT * FROM Pedidos ";
            if ($cliente > 0) { 
                SQL += " WHILE Cliente_idCliente = '" + $cliente + " ' ";
            }            
            List<pedido> aut = new ArrayList<pedido>();            
            PreparedStatement stmt = this.conn.prepareStatement(SQL);            
            ResultSet rs = stmt.executeQuery();            
            while(rs.next()){
                pedido ped = new pedido();                
                ped.setEmissao(rs.getDate("emissao").toString());
                ped.setIdPedido(rs.getInt("idPedido"));
                ped.setPagamento(rs.getString("pagamento"));
                ped.setQuantidade(rs.getInt("quantidade"));
                ped.setRetirada(rs.getDate("retirada").toString());
                ped.setToken(rs.getString("token"));
                ped.setValor(rs.getFloat("valor"));                
                aut.add(ped);
            }
            rs.close();
            stmt.close();
            return aut;            
        }catch(Exception e){
            throw new RuntimeException(e);
        }    
    } //listaPedidos
    
    public List<produtos> consultaIdProduto (produtos Produto) {
        try {
            int idProdutos = Produto.getIdProduto();
            List<produtos> listaProdutos = new ArrayList<produtos>(); //cria uma lista do tipo Autores
            String SQL = "SELECT * FROM Produtos WHERE idProdutos LIKE ?";  //frase SQL          
            PreparedStatement st = this.conn.prepareStatement(SQL); //manda a frase para o banco
            st.setString(1,Integer.toString(idProdutos));
            ResultSet rs = st.executeQuery(); //executa a frase SQL e recebe o resultado do retorno do banco
            while (rs.next()) { //enquanto houver item na lista
                produtos po = new produtos(); //cria um novo objeto                
                po.setDescricao(rs.getString("descricao"));
                po.setEstoque(rs.getInt("estoque"));
                po.setIdProduto(rs.getInt("idProdutos"));
                po.setSituacao(rs.getString("Situacao").charAt(0)); //função que recebe o index 1 da String "rs.getString("Situacao").
                po.setValor(rs.getDouble("valor"));                
                listaProdutos.add(po); //adiciona o objeto à lista
            } //while
            rs.close();
            st.close();
            return listaProdutos;
        } //try
        catch (SQLException erro) {
            throw new RuntimeException(erro);
        } //catch
    }
    
    
    public List<pedido> listaPedidobyToken(pedido pedid) {            
        try {
            List<pedido> aut = new ArrayList<pedido>();
            String SQL = "SELECT * FROM Pedido WHERE token = ?";
            
            PreparedStatement stmt = this.conn.prepareStatement(SQL);  
            stmt.setString(1, pedid.getToken());
            ResultSet rs = stmt.executeQuery();            
            
            
            while(rs.next()){
                pedido ped = new pedido();                
                ped.setEmissao(rs.getDate("emissao").toString());
                ped.setIdPedido(rs.getInt("idPedido"));
                ped.setPagamento(rs.getString("pagamento"));
                ped.setQuantidade(rs.getInt("quantidade"));
                if (rs.getDate("retirada") == null){
                    ped.setRetirada("");
                }
                else{
                    ped.setRetirada(rs.getDate("retirada").toString());
                }
                ped.setToken(rs.getString("token"));
                ped.setValor(rs.getFloat("valor"));                
                aut.add(ped);
            }
            
            rs.close();
            stmt.close();
            return aut;
        } //try
        catch (SQLException e) {
            throw new RuntimeException(e);
        } //catch
    } //listaProdutos
    
    
    public List<pedido> listaPedidobyToken_2(pedido p) {            
        try {
            List<pedido> aut = new ArrayList<pedido>();
            String token = p.getToken();
            String SQL = "SELECT * FROM Pedido WHERE token = " + token;
            
            PreparedStatement stmt = this.conn.prepareStatement(SQL);  
            ResultSet rs = stmt.executeQuery();            
            
            while(rs.next()){
                pedido ped = new pedido();                
                ped.setEmissao(rs.getDate("emissao").toString());
                ped.setIdPedido(rs.getInt("idPedido"));
                ped.setPagamento(rs.getString("pagamento"));
                ped.setQuantidade(rs.getInt("quantidade"));
                if (rs.getDate("retirada") == null){
                    ped.setRetirada("");
                }
                else{
                    ped.setRetirada(rs.getDate("retirada").toString());
                }
                ped.setToken(rs.getString("token"));
                ped.setValor(rs.getFloat("valor"));                
                aut.add(ped);
            }
            
            rs.close();
            stmt.close();
            return aut;
        } //try
        catch (SQLException e) {
            throw new RuntimeException(e);
        } //catch
    } //listaProdutos
    
    ////////////ALTERAR TABELAS/////////////
    public void alteraProduto (produtos Produto) {
        String SQL = "UPDATE Produtos SET descricao=?, valor=?, estoque=?, situacao=? WHERE idProdutos LIKE ?";
        try {
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, Produto.getDescricao());
            String aux = Double.toString(Produto.getValor());
            ps.setString(2, aux);
            aux = Integer.toString(Produto.getEstoque());
            ps.setString(3, aux);
            aux = "" + Produto.getSituacao();
            ps.setString(4, aux);
            ps.execute();
            ps.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        } //catch
    } //alteraProduto
} //class
