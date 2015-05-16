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
        this.conn = (Connection) FabricaDeConexão.getConnection();
    } //construtor     
    
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
    }
    
    public List<produtos> listaProdutos() { 
      
            
        try {
            List<produtos> aut = new ArrayList<produtos>();
            String SQL = "SELECT * FROM PRODUTOS";
            PreparedStatement stmt = this.conn.prepareStatement(SQL);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                produtos prod = new produtos();
                
                prod.setDescricao(rs.getString("descricao"));
                prod.setEstoque(rs.getInt("estoque"));
                prod.setIdProduto(rs.getInt("idProdutos"));
                prod.setUnidades(rs.getString("unidade"));
                prod.setValor(rs.getFloat("valor"));
                aut.add(prod);
            }
            rs.close();
            stmt.close();
            return aut;
        } //try
        catch (SQLException e) {
            throw new RuntimeException(e);
        } //catch
    }
    
    
    public List<pedido> listaPedidos(int $cliente){
        
        
        try{
            String SQL = " SELECT * FROM PEDIDOS ";
            if ($cliente > 0) { 
                SQL += " WHILE Cliente_idCliente = '" + $cliente + " ' ";
            }
            
            List<pedido> aut = new ArrayList<pedido>();
            
            PreparedStatement stmt = this.conn.prepareStatement(SQL);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                pedido ped = new pedido();
                
                ped.setEmissao(rs.getDate("emissao"));
                ped.setIdPedido(rs.getInt("idPedido"));
                ped.setPagamento(rs.getString("pagamento"));
                ped.setQuantidade(rs.getInt("quantidade"));
                ped.setRetirada(rs.getDate("retirada"));
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
        
        
    }
    
    
} //class
