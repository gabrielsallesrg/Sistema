package br.com.Modelo;

public class Usuario {

	private Long id_Log;
	private String nome;
	private String senha;
//	private String descricao;
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
		this.id_Log = id_Log;
		this.nome = nome;
		this.senha = senha;
	}

	public Usuario(Long id_Log, String nome, String senha, String tipo) {
		this.id_Log = id_Log;
		this.nome = nome;
		this.senha = senha;
		this.tipo = tipo;
	}

	public Long getId_Log() {
		return id_Log;
	}

	public void setId_Log(Long id_Log) {
		this.id_Log = id_Log;
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
        
        

}
