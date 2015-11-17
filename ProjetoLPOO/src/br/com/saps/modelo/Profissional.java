package br.com.saps.modelo;

public class Profissional {
	private String matricula;
	private String cpf;
	private String nome;
	private String numeroRP;
	private String sigla;
	private String tipo;
	private Data data;

	public Profissional(String matricula, String cpf, String nome, String numeroRP, String sigla, String tipo,
			Data data) {
		this.matricula = matricula;
		this.cpf = cpf;
		this.nome = nome;
		this.numeroRP = numeroRP;
		this.sigla = sigla;
		this.tipo = tipo;
		this.data = data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumeroRP() {
		return numeroRP;
	}

	public void setNumeroRP(String numeroRP) {
		this.numeroRP = numeroRP;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Data getData() {
		return data;
	}

}
