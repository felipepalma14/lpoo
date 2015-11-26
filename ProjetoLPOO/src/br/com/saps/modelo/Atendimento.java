package br.com.saps.modelo;

public class Atendimento {
	private String protocolo;
	private Profissional matricula;
	private Cliente codigo;
	private String descri��o;
	private Data dataCriacao;

	public Atendimento(String protocolo, Profissional profissional, Cliente cliente, String descri��o,
			Data dataCriacao) {
		this.protocolo = protocolo;
		this.matricula = profissional;
		this.codigo = cliente;
		this.descri��o = descri��o;
		this.dataCriacao = dataCriacao;

	}

	public String getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}

	public Profissional getMatricula() {
		return matricula;
	}

	public void setMatricula(Profissional matricula) {
		this.matricula = matricula;
	}

	public Cliente getCodigo() {
		return codigo;
	}

	public void setCodigo(Cliente codigo) {
		this.codigo = codigo;
	}

	public String getDescri��o() {
		return descri��o;
	}

	public void setDescri��o(String descri��o) {
		this.descri��o = descri��o;
	}

	public Data getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Data dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Override
	public String toString() {
		return "Atendimento [protocolo=" + protocolo + ", matricula=" + matricula.getMatricula() + ", codigo="
				+ codigo.getCodigo() + ", descri��o=" + descri��o + ", dataCriacao=" + dataCriacao + "]";
	}
}
