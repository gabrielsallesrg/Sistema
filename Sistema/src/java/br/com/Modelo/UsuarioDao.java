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
			}
		} catch (Exception e) {
		}
		return result;
	}
	
	// Metodo para inserir Usuario no banco de dados
	public void adicionaUsuario(Usuario usuario) {
		String SQL = "INSERT INTO usuario (nome, senha, tipo, Cliente_idCliente) VALUES (?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getSenha());
                        ps.setString(3, usuario.getTipo());
                        ps.setLong(4, usuario.getCliente_idCliente());
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
					u.setId_Log(rs.getLong("id_Log"));
					u.setNome(rs.getString("nome"));
					u.setSenha(rs.getString("senha"));
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
					u.setId_Log(rs.getLong("id_Log"));
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
				Long id_Log = usuario.getId_Log();

				List<Usuario> listaUsuario = new ArrayList<Usuario>();
				String SQL = "SELECT * FROM usuario WHERE id_Log=? ";
				PreparedStatement st = this.conn.prepareStatement(SQL);
				st.setLong(1, id_Log);
				ResultSet rs = st.executeQuery();

				while (rs.next()) {
					Usuario u = new Usuario();
					u.setId_Log(rs.getLong("id_Log"));
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
			String SQL = "UPDATE usuario SET nome=?, senha=?, descricao=? "
					+ "WHERE id_Log=?  ";
			try {
				PreparedStatement st = conn.prepareStatement(SQL);
				st.setString(1, usuario.getNome());
				st.setString(2, usuario.getSenha());
				st.setLong(4, usuario.getId_Log());
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
                
                
                
}
