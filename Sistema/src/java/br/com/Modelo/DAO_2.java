package br.com.Modelo;

import com.mysql.jdbc.Connection;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_2 {
    private final Connection conn;
    private ResultSet rs;    
    // método construtor para conectar com o banco
    public DAO_2 () throws SQLException {
        System.out.println("DAO_2.java, construtor");
        this.conn = (Connection) FabricaDeConexão.getConnection();
        System.out.println("DAO_2.java, fim do construtor");
    } //construtor     
    
      
    
    public List<pedido> listaPedidobyToken(pedido pedid) {            
        try {
            List<pedido> aut = new ArrayList<pedido>();
            String SQL = "SELECT * FROM Pedido WHERE token = ?";
            
            PreparedStatement stmt = this.conn.prepareStatement(SQL);  
            stmt.setString(1, pedid.getToken());
            ResultSet rs = stmt.executeQuery();            
            
            
            while(rs.next()){
                pedido ped = new pedido();                
                ped.setEmissao(rs.getDate("emissao"));
                ped.setIdPedido(rs.getInt("idPedido"));
                ped.setPagamento(rs.getString("pagamento"));
                ped.setQuantidade(rs.getInt("quantidade"));
                if (rs.getDate("retirada") == null){
                    ped.setRetirada(null);
                }
                else{
                    ped.setRetirada(rs.getDate("retirada"));
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
                ped.setEmissao(rs.getDate("emissao"));
                ped.setIdPedido(rs.getInt("idPedido"));
                ped.setPagamento(rs.getString("pagamento"));
                ped.setQuantidade(rs.getInt("quantidade"));
                if (rs.getDate("retirada") == null){
                    ped.setRetirada(null);
                }
                else{
                    ped.setRetirada(rs.getDate("retirada"));
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
} //class
