package br.com.saps.modelo;

public class Cliente {

	private int codigo;
	private String nome, email;
	private int telefone, celular;
	private Data dataNasc;
	private int idade;
	private char sexo; // M: masculino; F: feminino
	private Endereco endereco;

	public Cliente() {
	}

	public Cliente(String nome) {
		this.nome = nome;
	}

	public Cliente(int codigo, String nome, Data nascimento, char sexo) {
		this.codigo = codigo;
		this.nome = nome;
		this.dataNasc = new Data(nascimento.getDia(), nascimento.getMes(), nascimento.getAno());
		this.sexo = sexo;
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

	public void setSexo(char s) {
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

	public char getSexo() {
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

	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nome=" + nome + ", dataNasc=" + dataNasc + ", sexo=" + sexo + "]";
	}

}
