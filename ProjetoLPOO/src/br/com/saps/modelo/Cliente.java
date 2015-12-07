package br.com.saps.modelo;

public class Cliente {

	private int codigo;
	private String nome, email;
	private String telefone, celular;
	private Data dataNasc;
	private int idade;
	private String sexo; // M: masculino; F: feminino
	private Endereco endereco;

	public Cliente() {
	}

	public Cliente(int codigo, String nome, String email, String telefone, String celular, Data dataNasc, int idade,
			String sexo, Endereco endereco) {
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.celular = celular;
		this.dataNasc = dataNasc;
		this.idade = idade;
		this.sexo = sexo;
		this.endereco = endereco;
	}

	public void setCodigo(int c) {
		codigo = c;
	}

	public void setNome(String n) {
		nome = n;
	}

	public void setDataNasc(Data d) {
		dataNasc = d;
	}

	public void setSexo(String s) {
		sexo = s;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public Data getDataNasc() {
		return dataNasc;
	}

	/**
	 * @return
	 */
	public String getData() {
		return dataNasc.toString();
	}

	public String getSexo() {
		return sexo;
	}

	public Cliente getCliente() {
		return this;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return codigo + " - " + nome;
	}

}
