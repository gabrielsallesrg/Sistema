package br.com.Modelo;

public class Usuario {

	private Long idUsuario,Cliente_idCliente;
	private String nome;
	private String senha;
        private String tipo;

	public Usuario() {
	}

	public Usuario(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}

	public Usuario(String nome, String senha, String tipo) {
		this.nome = nome;
		this.senha = senha;
		this.tipo = tipo;
	}

	public Usuario(Long id_Log, String nome, String senha) {
		this.idUsuario = id_Log;
		this.nome = nome;
		this.senha = senha;
	}

	public Usuario(Long id_Log, String nome, String senha, String tipo) {
		this.idUsuario = id_Log;
		this.nome = nome;
		this.senha = senha;
		this.tipo = tipo;
	}

	public Long getId_Log() {
		return idUsuario;
	}

	public void setId_Log(Long id_Log) {
		this.idUsuario = id_Log;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getCliente_idCliente() {
        return Cliente_idCliente;
    }

    public void setCliente_idCliente(Long Cliente_idCliente) {
        this.Cliente_idCliente = Cliente_idCliente;
    }
        
    
        

}
