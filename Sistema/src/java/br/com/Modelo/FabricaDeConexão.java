package br.com.Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexão {
    private static final String BANCODADOS = "Sistema";
    private static final String URL = "jdbc:mysql://localhost/"+BANCODADOS;
    private static final String USUARIO = "root";
    private static final String SENHA = "123456";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    
    public static Connection getConnection() throws SQLException {
        try {
            System.out.println("FabricaDeConexão.java, try");
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USUARIO, SENHA);            
        } //try
        catch (ClassNotFoundException erro) {
            System.out.println("FabricaDeConexão.java, catch");
            erro.printStackTrace();
            System.out.println(erro.getMessage());
            throw new SQLException(erro.getMessage());
        } //catch
    }
    
}
