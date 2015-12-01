package br.com.saps.modelo;

public class Atendimento {
	private String protocolo;
	private Profissional profissional;
	private Cliente cliente;
	private String descri��o;
	private Data dataCriacao;
	private String Especialidade;

	public String getEspecialidade() {
		return Especialidade;
	}

	public void setEspecialidade(String especialidade) {
		Especialidade = especialidade;
	}

	public Atendimento(String protocolo, Profissional profissional, Cliente cliente, String descri��o, Data dataCriacao,
			String especialidade) {
		super();
		this.protocolo = protocolo;
		this.profissional = profissional;
		this.cliente = cliente;
		this.descri��o = descri��o;
		this.dataCriacao = dataCriacao;
		Especialidade = especialidade;
	}

	public String getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
		return "Atendimento [protocolo=" + protocolo + ", profissional=" + profissional + ", cliente=" + cliente
				+ ", descri��o=" + descri��o + ", dataCriacao=" + dataCriacao + ", Especialidade=" + Especialidade
				+ "]";
	}

}
