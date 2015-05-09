package br.com.Modelo;

import com.mysql.jdbc.Connection;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// teste 

public class DAO {
    private final Connection conn;
    private ResultSet rs;    
    // método construtor para conectar com o banco
    public DAO () throws SQLException {
        this.conn = (Connection) FabricaDeConexão.getConnection();
    } //construtor  
    
} //class
