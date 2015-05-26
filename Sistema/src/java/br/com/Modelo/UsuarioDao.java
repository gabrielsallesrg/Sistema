package br.com.Modelo;

import com.mysql.jdbc.Connection;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

	/*
	 * DAO (Objeto de acesso a dados) Classe responsavel em separar regras de
	 * negocio das regras de acesso a banco de dados. Obtem as conexoes, mapeia
	 * objetos Java para tipos de dados SQL ou executa comandos SQL.
	 */

        private final Connection conn;
        private ResultSet rs;  
        private String tipo_cliente; // Variavel do tipo ResultSet
        private int idCliente; // Variavel do tipo ResultSet

	// Metodo construtor para conectar com o banco
	public UsuarioDao() throws SQLException {
                this.conn = (Connection) FabricaDeConexão.getConnection();
	}

	public boolean verificaUsuario(Usuario usuario) {
		String nome = usuario.getNome();
		String senha = usuario.getSenha();
		boolean result = false;

		try {
			String SQL = "SELECT * FROM usuario WHERE nome = ? AND senha = ?";

			PreparedStatement stmt = conn.prepareStatement(SQL);
			
                        stmt.setString(1, usuario.getNome());
                        stmt.setString(2, usuario.getSenha());
                          
                       ResultSet rs = stmt.executeQuery();
                        //setTipo_cliente(rs.getString("tipo"));
                        
			if (rs.next()) {
				result = true;
                                setTipo_cliente(rs.getString("tipo"));
                                setIdCliente(rs.getInt("Cliente_idCliente"));
			}
		} catch (Exception e) {
		}
		return result;
	}
	
	// Metodo para inserir Usuario no banco de dados
	public void adicionaUsuario(Usuario usuario) {
		String SQL = "INSERT INTO usuario (Cliente_idCliente, nome, senha, tipo) VALUES (?,?,?,?) ";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
                        
                        ps.setInt(1, usuario.getCliente_idCliente());
			ps.setString(2, usuario.getNome());
			ps.setString(3, usuario.getSenha());
                        ps.setString(4, usuario.getTipo());
                        
			ps.execute();
			ps.close();
                        
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	// Metodo para criar uma lista de Usuarios no banco de dados
		public List<Usuario> obtemLista() {
			try {
				List<Usuario> usuario = new ArrayList<Usuario>();
				String SQL = "SELECT * FROM usuario";
				PreparedStatement stmt = conn.prepareStatement(SQL);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					Usuario u = new Usuario();
					u.setCliente_idCliente(rs.getInt("Cliente_idCliente"));
					u.setIdUsuario(rs.getInt("idUsuario"));
                                        u.setNome(rs.getString("nome"));
					u.setSenha(rs.getString("senha"));
                                        u.setTipo(rs.getString("tipo"));
					usuario.add(u);
				}
				rs.close();
				stmt.close();
				return usuario;
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
	
	// Metodo para buscar na lista Usuario pelo nome no banco de dados
		public List<Usuario> obtemUsuario(Usuario usuario) {
			try {
				String nome = usuario.getNome();
				List<Usuario> listaUsuario = new ArrayList<Usuario>();
				String SQL = "SELECT * FROM usuario WHERE nome like ?";
				PreparedStatement ps = this.conn.prepareStatement(SQL);
				ps.setString(1, "%" + nome + "%");
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Usuario u = new Usuario();
					u.setId_Log(rs.getInt("idUsuario"));
					u.setNome(rs.getString("nome"));
					u.setSenha(rs.getString("senha"));
					listaUsuario.add(u);
				}
				rs.close();
				ps.close();
				return listaUsuario;
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
	
		// Metodo para buscar na lista Usuario pelo id no banco de dados
		public List<Usuario> obtemUsuarioById(Usuario usuario) {
			try {
				int id_Log = usuario.getId_Log();

				List<Usuario> listaUsuario = new ArrayList<Usuario>();
				String SQL = "SELECT * FROM usuario WHERE idUsuario = ? ";
				PreparedStatement st = this.conn.prepareStatement(SQL);
				st.setLong(1, id_Log);
				ResultSet rs = st.executeQuery();

				while (rs.next()) {
					Usuario u = new Usuario();
					u.setId_Log(rs.getInt("idUsuario"));
					u.setNome(rs.getString("nome"));
					u.setSenha(rs.getString("senha"));
					listaUsuario.add(u);
				}

				rs.close();
				st.close();
				return listaUsuario;

			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
		
	// Metodo para alterar/atualizar Usuario no banco de dados
		public void alteraUsuario(Usuario usuario) {
			String SQL = "UPDATE usuario SET senha=? "
					+ " WHERE idUsuario = ?  ";
			try {
				PreparedStatement st = conn.prepareStatement(SQL);
                                
				//st.setString(1, usuario.getNome());
				st.setString(1, usuario.getSenha());
				st.setInt (2, usuario.getId_Log());
                                
				st.execute();
				st.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

    public String getTipo_cliente() {
        return tipo_cliente;
    }

    private void setTipo_cliente(String $tipo_cliente) {
        this.tipo_cliente = $tipo_cliente;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
                
                
                
}
