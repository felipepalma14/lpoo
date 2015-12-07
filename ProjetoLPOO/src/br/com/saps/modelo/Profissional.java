package br.com.saps.modelo;

public class Profissional {
	private String matricula;
	private String cpf;
	private String nome;
	private String numeroRP;
	private RegistroProfissional sigla;
	private TipoProfissional tipo;
	private Data data;

	public Profissional() {
	}

	public Profissional(String matricula, String cpf, String nome, String numeroRP, RegistroProfissional sigla,
			TipoProfissional tipo, Data data) {
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

	public RegistroProfissional getSigla() {
		return sigla;
	}

	public void setSigla(RegistroProfissional sigla) {
		this.sigla = sigla;
	}

	public TipoProfissional getTipo() {
		return tipo;
	}

	public void setTipo(TipoProfissional tipo) {
		this.tipo = tipo;
	}

	public Data getData() {
		return data;
	}

	@Override
	public String toString() {
		return matricula + " - " + nome;
	}

}
